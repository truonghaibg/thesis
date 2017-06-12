package com.model;

public class ShortKddCupObject {
	private String service;
	private float count;
	private float srvSerrorRate;
	private float srvRerrorRate;
	private float dstHostCount;
	private float dstHostSameSrvRate;
	private float dstHostDiffSrvRate;
	private String attack;

	public ShortKddCupObject() {

	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public float getCount() {
		return count;
	}

	public void setCount(float count) {
		this.count = count;
	}

	public float getSrvSerrorRate() {
		return srvSerrorRate;
	}

	public void setSrvSerrorRate(float srvSerrorRate) {
		this.srvSerrorRate = srvSerrorRate;
	}

	public float getSrvRerrorRate() {
		return srvRerrorRate;
	}

	public void setSrvRerrorRate(float srvRerrorRate) {
		this.srvRerrorRate = srvRerrorRate;
	}

	public float getDstHostCount() {
		return dstHostCount;
	}

	public void setDstHostCount(float dstHostCount) {
		this.dstHostCount = dstHostCount;
	}

	public float getDstHostSameSrvRate() {
		return dstHostSameSrvRate;
	}

	public void setDstHostSameSrvRate(float dstHostSameSrvRate) {
		this.dstHostSameSrvRate = dstHostSameSrvRate;
	}

	public float getDstHostDiffSrvRate() {
		return dstHostDiffSrvRate;
	}

	public void setDstHostDiffSrvRate(float dstHostDiffSrvRate) {
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
