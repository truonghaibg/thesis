package com.model;

public class ShortDOSObject {
	private String service;
	private double count;
	private double srvSerrorRate;
	private double srvRerrorRate;
	private double dstHostCount;
	private double dstHostSameSrvRate;
	private double dstHostDiffSrvRate;
	private String attack;

	public ShortDOSObject() {

	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public double getCount() {
		return count;
	}

	public void setCount(double count) {
		this.count = count;
	}

	public double getSrvSerrorRate() {
		return srvSerrorRate;
	}

	public void setSrvSerrorRate(double srvSerrorRate) {
		this.srvSerrorRate = srvSerrorRate;
	}

	public double getSrvRerrorRate() {
		return srvRerrorRate;
	}

	public void setSrvRerrorRate(double srvRerrorRate) {
		this.srvRerrorRate = srvRerrorRate;
	}

	public double getDstHostCount() {
		return dstHostCount;
	}

	public void setDstHostCount(double dstHostCount) {
		this.dstHostCount = dstHostCount;
	}

	public double getDstHostSameSrvRate() {
		return dstHostSameSrvRate;
	}

	public void setDstHostSameSrvRate(double dstHostSameSrvRate) {
		this.dstHostSameSrvRate = dstHostSameSrvRate;
	}

	public double getDstHostDiffSrvRate() {
		return dstHostDiffSrvRate;
	}

	public void setDstHostDiffSrvRate(double dstHostDiffSrvRate) {
		this.dstHostDiffSrvRate = dstHostDiffSrvRate;
	}

	public String getAttack() {
		return attack;
	}

	public void setAttack(String attack) {
		this.attack = attack;
	}

	@Override
	public String toString() {
		// return this.service + "," + this.count + "," + this.srvSerrorRate +
		// "," + this.srvRerrorRate + "," + this.dstHostCount + "," +
		// this.dstHostSameSrvRate
		// + "," + this.dstHostDiffSrvRate + "," + this.attack;
		return this.service + " " + (int) this.count + " " + (int) this.srvSerrorRate + " " + (int) this.srvRerrorRate + " " + (int) this.dstHostCount + " "
				+ (int) this.dstHostSameSrvRate + " " + (int) this.dstHostDiffSrvRate + " " + this.attack;
	}
}
