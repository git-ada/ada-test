package com.ada.test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicLong;


public class Counter {

	private Timestamp startTime;
	private Integer maxThreads;
	
	
	private AtomicLong total = new AtomicLong();
	private AtomicLong success = new AtomicLong();
	private AtomicLong faild = new AtomicLong();
	private Long avgSeconds;
	
	public AtomicLong getTotal() {
		return total;
	}
	public void setTotal(AtomicLong total) {
		this.total = total;
	}
	public AtomicLong getSuccess() {
		return success;
	}
	public void setSuccess(AtomicLong success) {
		this.success = success;
	}
	public AtomicLong getFaild() {
		return faild;
	}
	public void setFaild(AtomicLong faild) {
		this.faild = faild;
	}
	
	
	public void success(){
		total.incrementAndGet();
		success.incrementAndGet();
	}
	
	public void error(){
		total.incrementAndGet();
		faild.incrementAndGet();
	}
	
	
	public void success(Integer n){
		total.addAndGet(n);
		success.addAndGet(n);
	}
	
	public void error(Integer n){
		total.addAndGet(n);
		faild.addAndGet(n);
	}

	public String toString2() {
		Long now = System.currentTimeMillis();
		Long senkds = (now-startTime.getTime())/1000;
		Long s = 0l;
		
		try {
			s = success.get()/senkds;
		} catch (Exception e) {
		}
		
		return "Counter [开始="+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") +" total=" + total + ", success=" + success + ", faild=" + faild+ ", 平均每秒=" + s + "]";
	}
	public Timestamp getStartTime() {
		return startTime;
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	public Integer getMaxThreads() {
		return maxThreads;
	}
	public void setMaxThreads(Integer maxThreads) {
		this.maxThreads = maxThreads;
	}

	public Long getAvgSeconds() {
		Long now = System.currentTimeMillis();
		Long t = (now-startTime.getTime())/1000;
		try {
			avgSeconds = success.get()/t;
		} catch (Exception e) {
		}
		return avgSeconds;
	}
	@Override
	public String toString() {	
		return "Counter [startTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(startTime) + ", maxThreads=" + maxThreads + ", total=" + total + ", success="
				+ success + ", faild=" + faild + ", avgSeconds=" + getAvgSeconds() + "]";
	}
}
