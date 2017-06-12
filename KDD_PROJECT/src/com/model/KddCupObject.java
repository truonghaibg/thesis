package com.model;

public class KddCupObject extends Object {
	private int x3;
	private int x23;
	private int x29;
	private int x30;
	private int x32;
	private int x34;
	private int x35;
	private int x42;

	public int getX3() {
		return x3;
	}

	public void setX3(int x3) {
		this.x3 = x3;
	}

	public int getX23() {
		return x23;
	}

	public void setX23(int x23) {
		this.x23 = x23;
	}

	public int getX29() {
		return x29;
	}

	public void setX29(int x29) {
		this.x29 = x29;
	}

	public int getX30() {
		return x30;
	}

	public void setX30(int x30) {
		this.x30 = x30;
	}

	public int getX32() {
		return x32;
	}

	public void setX32(int x32) {
		this.x32 = x32;
	}

	public int getX34() {
		return x34;
	}

	public void setX34(int x34) {
		this.x34 = x34;
	}

	public int getX35() {
		return x35;
	}

	public void setX35(int x35) {
		this.x35 = x35;
	}

	public int getX42() {
		return x42;
	}

	public void setX42(int x42) {
		this.x42 = x42;
	}

	@Override
	public String toString() {
		// return this.service + "," + this.count + "," + this.srvSerrorRate +
		// "," + this.srvRerrorRate + "," + this.dstHostCount + "," +
		// this.dstHostSameSrvRate
		// + "," + this.dstHostDiffSrvRate + "," + this.attack;
		return this.x3 + " " + this.x23 + " " + this.x29 + " " + this.x30 + " " + this.x32 + " " + this.x34 + " " + this.x35 + " " + this.x42;
	}

	public String toRule() {
		String rule = "IF(x3=" + this.x3 + "; x23=" + this.x23 + "; x29=" + this.x29 + "; x30=" + this.x30 + "; x32=" + this.x32 + "; x34=" + this.x34
				+ "; x35=" + this.x35 + ") THEN(y=" + this.x42 + ");";
		return rule;
	}

	public int compareTo(KddCupObject object) {

		int compareQuantity = object.getX3();

		// ascending order
		return this.x3 - compareQuantity;

		// descending order
		// return compareQuantity - this.quantity;

	}
}
