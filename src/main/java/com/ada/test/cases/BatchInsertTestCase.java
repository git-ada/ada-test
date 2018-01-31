package com.ada.test.cases;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ada.test.Counter;
import com.ada.test.TestCase;
import com.ada.test.util.IPv4;
import com.yorbee.qgs.bigdata.hbase.dao.AccessLogDao;
import com.yorbee.qgs.bigdata.hbase.dao.AccessLogDaoImp;
import com.yorbee.qgs.bigdata.hbase.entity.AccessLog;

/**
 * 批量插入测试用例
 * @author wanghl.cn
 *
 */
public class BatchInsertTestCase implements TestCase {
	
	private final static Log logger = LogFactory.getLog(BatchInsertTestCase.class);
	
	private Integer batchSize    = 10000;
	private Integer maxSiteId =    10000;
	private Integer maxAdId =      100000;
	private Integer maxDomianId =  1000000;
	private Integer maxChannelId = 10000000;
	private Integer maxRegion =    2000;
	private Integer maxIp =        10000000;
	private Integer maxUuid =      12000000;
	private Integer maxUrl =       1000000;
	
	private Random random = new Random();
	private AccessLogDao dao;
	
	public BatchInsertTestCase(){
		init();
	}
	
	private List<AccessLog> logs;
	
	public static Boolean testing = false;
	
	public static AtomicInteger error = new AtomicInteger();
	
	private static Timer timer = new Timer();
	
	public static void main(String[] args){
//		BatchInsertTestCase.start();
		System.out.println(new BatchInsertTestCase().randomInstance());
	}
	
	public static void start() {
		logger.info("start");
		if(!testing){
			testing = true;
			counter.setStartTime(new Timestamp(System.currentTimeMillis()));
			timer = new Timer();
			timer.schedule(new TimerTask() {
				public void run() {
					new Thread(new Runnable() {
						public void run() {
							try {
								BatchInsertTestCase n = new BatchInsertTestCase();
								n.init();
								n.beforeTest();
								n.test();
							} catch (Exception e) {
								logger.error(e);
							}
						}
					}).start();
				}
			}, 0,1000);
		}
	}
	
	public static void stop(){
		timer.cancel();
	}
	
	private void init(){
		AccessLogDaoImp impl = new AccessLogDaoImp();
		impl.set_host("qgs-14,qgs-17,qgs-18,qgs-19,qgs-20");
		impl.set_port("2181");
		dao = impl;
		
		counter.setStartTime(new Timestamp(System.currentTimeMillis()));
	}
	
	@Override
	public void beforeTest() {
		List<AccessLog> accessLogs = new ArrayList<AccessLog>();
		for(int i =0 ;i<batchSize;i++){
			accessLogs.add(randomInstance());
		}
		logs = accessLogs;
	}
	
	public AccessLog randomInstance(){
		Long now = System.currentTimeMillis();
		String url = "http://www.test.com/"+random.nextInt(maxUrl)+"/5bf6dd40d0883252fddd328fd25d1a7f22a609e9";
		AccessLog t = new AccessLog();
		t.setSiteId(random.nextInt(maxSiteId));
		t.setDomainId(random.nextInt(maxDomianId));
		t.setChannelId(random.nextInt(maxChannelId));
		t.setAdId(random.nextInt(maxAdId));
		t.setEntranceType(1);
		t.setIpAddress(IPv4.toString(random.nextInt(maxIp)));
		t.setRegion("地区编号"+random.nextInt(maxRegion));
		t.setUuid(String.valueOf(random.nextInt(maxUuid)));
		t.setUrl(url);
		t.setUseragent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36");
		t.setOs("OS"+String.valueOf(random.nextInt(3)));
		t.setOs("BR"+String.valueOf(random.nextInt(15)));
		t.setScreenSize("1024x768");
		t.setPageSize("1024x768");
		t.setReferer(url);
		t.setRequestTime(now);
		t.setTodayTime(now);
		t.setFirstTime(now);
		t.setCreateTime(new Timestamp(now));
		return t;
	};
	
	public static AtomicInteger total = new AtomicInteger();
	public static Counter counter = new Counter();

	public boolean test() {
		try {
			logger.info("batch add " + logs.size() +",total->"+total.addAndGet(logs.size()));
			Long startTime = System.currentTimeMillis();
			dao.batchInsert(logs);
			Long endTime = System.currentTimeMillis();
			Long cost = endTime -startTime;
			counter.success(batchSize);
			logger.info(counter+",Cost="+cost+"ms");
		} catch (Exception e) {
			counter.error(batchSize);
			logger.info(counter);
		}
		
		return false;
	}

}
