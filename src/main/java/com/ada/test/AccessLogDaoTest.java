package com.ada.test;

import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.yorbee.qgs.bigdata.hbase.entity.AccessLog;

public class AccessLogDaoTest {
	
	private final static Log log = LogFactory.getLog(AccessLogDaoTest.class);

	
	public void batchInsert(List<AccessLog> logs) {
		// TODO Auto-generated method stub
		
	}

	public List<AccessLog> findBySiteId() {
		log.info("findBySiteId start");
		
		Long starTime = System.currentTimeMillis();
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		Long endTime = System.currentTimeMillis();
		Long cost = endTime - starTime;
		log.info("cost->"+cost);
		
		return null;
	}

	
	public List<AccessLog> findByDomainId(Integer domainId, Integer pageSize, Integer pageNo) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<AccessLog> findBySiteIdAndIp(Integer siteId, String ipAddress, Integer pageSize, Integer pageNo) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<AccessLog> findByDomainIdAndIp(Integer domainId, String ipAddress, Integer pageSize, Integer pageNo) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<AccessLog> findBySiteIdAndUrlLike(Integer siteId, String url) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<AccessLog> findByDomainIdAndUrlLike(Integer domainId, String url) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Integer countBySiteIdAndIp(Integer siteId, String ipAddress) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Integer countByDomainIdAndIp(Integer domainId, String ipAddress) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Integer countBySiteIdAndUrlLike(Integer siteId, String ipAddress) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Integer countByDomainIdAndUrlLike(Integer domainId, String ipAddress) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Integer statSiteIP(Integer siteId, Timestamp startTime, Timestamp endTime) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Integer statSitePV(Integer siteId, Timestamp startTime, Timestamp endTime) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Integer statSiteUV(Integer siteId, Timestamp startTime, Timestamp endTime) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Integer statDomainIP(Integer domainId, Timestamp startTime, Timestamp endTime) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Integer statDomainPV(Integer domainId, Timestamp startTime, Timestamp endTime) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Integer statDomainUV(Integer domainId, Timestamp startTime, Timestamp endTime) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Integer statSiteRegionIP(Integer siteId, String region, Timestamp startTime, Timestamp endTime) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Integer statSiteRegionPV(Integer siteId, String region, Timestamp startTime, Timestamp endTime) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Integer statSiteRegionUV(Integer siteId, String region, Timestamp startTime, Timestamp endTime) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Integer statDomainRegionIP(Integer domainId, String region, Timestamp startTime, Timestamp endTime) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Integer statDomainRegionPV(Integer domainId, String region, Timestamp startTime, Timestamp endTime) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Integer statDomainRegionUV(Integer domainId, String region, Timestamp startTime, Timestamp endTime) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<AccessLog> findByTime(Timestamp startTime, Timestamp endTime, Integer pageSize, Integer pageNo) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void deleteByTime(Timestamp startTime, Timestamp endTime) {
		// TODO Auto-generated method stub
		
	}

}
