package com.ada.test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;

public class ThreadTest {
	
	private final static Log log = LogFactory.getLog(ThreadTest.class);
	public static Boolean running = false;
	public static Counter counter;
	
	public static void main(String[] args){
		start(10,null);
	}
	
	public static void stop(){
		running = false;
	}
	
	public static void start(Integer maxThreads,Long times){
		if(!running){
			running = true;
			counter = new Counter();
			counter.setMaxThreads(maxThreads);
			counter.setStartTime(new Timestamp(System.currentTimeMillis()));
			for(int i=0;i<maxThreads;i++){
				new Thread(new SingleThread(counter, null)).start();
			}
			
			consoleLog();
		}
	}
	
	public static void consoleLog(){
		new Thread(new Runnable() {
			public void run() {
				while(running){
					Long now = System.currentTimeMillis();
					Long senkds = (now-counter.getStartTime().getTime())/1000;
					Long s = 0l;
					
					try {
						s = counter.getSuccess().get()/senkds;
					} catch (Exception e) {
						// TODO: handle exception
					}
					
					log.info(counter);
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
	
	public static class SingleThread implements Runnable {
		private HttpClient httpclient;
		private Counter counter;
		private Long times;
		
		public SingleThread(Counter counter,Long times){
			this.counter = counter;
			this.times = times;
			initHttpclient();
		}
		
		private void initHttpclient(){
			httpclient = new DefaultHttpClient();
			httpclient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 5000); 
			httpclient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 5000);
			
			//HttpHost proxy = new HttpHost("127.0.0.1",4000, null);  
			//httpclient.getParams().setParameter(ConnRouteParams.DEFAULT_PROXY, proxy);  
		}
		
		private SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		private SimpleDateFormat df1 = new SimpleDateFormat("yyyyMMddHH");
		private SimpleDateFormat df2 = new SimpleDateFormat("yyyyMMddHHmm");
		private SimpleDateFormat df3 = new SimpleDateFormat("yyyyMMddHHmmss");
		
		private void invoke() {
			String url = "http://log.qgs.com/l1";
			Long now = System.currentTimeMillis();
			Timestamp time = new Timestamp(now);
//			String body = "u=86c95270eb7f4326b9d18cafcbcf5e96&s=1000&c=&a=&e=2&v=1.1&p=http://xxx.test.com/index.html?86c95270eb7f4326b9d18cafcbcf5e9686c95270eb7f4326b9d18cafcbcf5e96"
//					+ "f="+now+"o="+now+"r=http://xxx.test.com/referer.html?86c95270eb7f4326b9d18cafcbcf5e9686c95270eb7f4326b9d18cafcbcf5e96&os=windows&br=IE&ss=1024x768&ps=1024x768&if=0&"
//							+ "ua=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36";
			Map<String,String> paramMap = new LinkedHashMap<String,String>();
			paramMap.put("u", df1.format(time));
			paramMap.put("s", "1000");
			paramMap.put("c", "");
			paramMap.put("a", "");
			paramMap.put("e", "2");
			paramMap.put("ep", "");
			paramMap.put("v", "1");
			paramMap.put("p", "http://xxx.test.com/index.html?86c95270eb7f4326b9d18cafcbcf5e"+UUID.randomUUID().toString().replaceAll("-", ""));
			paramMap.put("o", now.toString());
			paramMap.put("t", now.toString());
			paramMap.put("f", now.toString());
			paramMap.put("r", "http://xxx.test.com/referer.html?86c95270eb7f4326b9d18cafcbcf5e9686c95270eb7f4326b9d18cafcbcf5e96");
			
			paramMap.put("os", "windows");
			paramMap.put("br", df.format(time));
			paramMap.put("ss", df2.format(time));
			paramMap.put("ps", df3.format(time));
			paramMap.put("if", "0");
			paramMap.put("ua", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36");
			
			
			List<NameValuePair> paramList = new ArrayList<NameValuePair>();
			if (paramMap != null) {
				for (Iterator<String> i =paramMap.keySet().iterator();i.hasNext();) {
					String key = i.next();
					String value = paramMap.get(key);
					paramList.add(new BasicNameValuePair(key, value));
				}
			}

			try {
				HttpEntity entity = null;
				HttpResponse response = null;
				try {
					HttpPost httppost = new HttpPost(url);
					UrlEncodedFormEntity urlEncodeEntyty  = new UrlEncodedFormEntity(paramList, "utf-8");
					httppost.setEntity(urlEncodeEntyty);
					response = httpclient.execute(httppost);
					entity = response.getEntity();
					Integer statuscode = response.getStatusLine().getStatusCode();
					if (null != entity && (statuscode == HttpStatus.SC_OK || statuscode == HttpStatus.SC_ACCEPTED)) {
						String ret = EntityUtils.toString(entity,"utf-8");
						counter.success();
						//log.info("Post " +url +" ret->"+ret);
					} else {
						EntityUtils.toString(entity,"utf-8");
						counter.error();
						log.error("statuscode:"+statuscode);;
					}
				} catch (Exception e) {
					counter.error();
					log.error("exception:"+e.getMessage(),e);
				}
			} catch (Exception e) {
			}
		}

		@Override
		public void run() {
			if(times==null || times ==0){
				while(running){
					invoke();
				}
			}else{
				for(Long i=0l;i<times && running;i++){
					invoke();
				}
			}
		}
	}
}
