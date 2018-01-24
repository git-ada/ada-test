package com.ada.test;

import java.sql.Timestamp;
import java.util.concurrent.atomic.AtomicLong;


public class Counter {

	private Timestamp startTime;
	
	private AtomicLong total = new AtomicLong();
	private AtomicLong success = new AtomicLong();
	private AtomicLong faild = new AtomicLong();
	
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
	@Override
	public String toString() {
		return "Counter [total=" + total + ", success=" + success + ", faild=" + faild + "]";
	}
	public Timestamp getStartTime() {
		return startTime;
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
}
