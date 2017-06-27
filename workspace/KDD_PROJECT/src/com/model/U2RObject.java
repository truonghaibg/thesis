package com.model;

public class U2RObject extends Object {
	private int x6;
	private int x11;
	private int x12;
	private int x14;
	private int x17;
	private int x24;
	private int x32;
	private int x33;
	private int x35;
	private int x36;
	private int x37;
	private int x40;
	private int x41;
	private int x42;

	public int getX42() {
		return x42;
	}

	public void setX42(int x42) {
		this.x42 = x42;
	}

	public int getX6() {
		return x6;
	}

	public void setX6(int x6) {
		this.x6 = x6;
	}

	public int getX11() {
		return x11;
	}

	public void setX11(int x11) {
		this.x11 = x11;
	}

	public int getX12() {
		return x12;
	}

	public void setX12(int x12) {
		this.x12 = x12;
	}

	public int getX14() {
		return x14;
	}

	public void setX14(int x14) {
		this.x14 = x14;
	}

	public int getX17() {
		return x17;
	}

	public void setX17(int x17) {
		this.x17 = x17;
	}

	public int getX24() {
		return x24;
	}

	public void setX24(int x24) {
		this.x24 = x24;
	}

	public int getX32() {
		return x32;
	}

	public void setX32(int x32) {
		this.x32 = x32;
	}

	public int getX33() {
		return x33;
	}

	public void setX33(int x33) {
		this.x33 = x33;
	}

	public int getX35() {
		return x35;
	}

	public void setX35(int x35) {
		this.x35 = x35;
	}

	public int getX36() {
		return x36;
	}

	public void setX36(int x36) {
		this.x36 = x36;
	}

	public int getX37() {
		return x37;
	}

	public void setX37(int x37) {
		this.x37 = x37;
	}

	public int getX40() {
		return x40;
	}

	public void setX40(int x40) {
		this.x40 = x40;
	}

	public int getX41() {
		return x41;
	}

	public void setX41(int x41) {
		this.x41 = x41;
	}

	public String toString() {
		return this.x6 + " " + this.x11 + " " + this.x12 + " " + this.x14 + " "
				+ this.x17 + " " + this.x24 + " " + this.x32 + " " + this.x33
				+ " " + this.x35 + " " + this.x36 + " " + this.x37 + " "
				+ this.x40 + " " + this.x41 + " " + this.x42;
	}

	public String toRule() {
		String rule = "IF(x6=" + this.x6 + ";x11=" + this.x11 + ";x12="
				+ this.x12 + ";x14=" + this.x14 + ";x17=" + this.x17 + ";x24="
				+ this.x24 + ";x32=" + this.x32 + ";x33=" + this.x33 + ";x35="
				+ this.x35 + ";x36=" + this.x36 + ";x37=" + this.x37 + ";x40="
				+ this.x40 + ";x41=" + this.x41 + ") THEN(y=" + this.x42 + ");";
		return rule;
	}

	public String toRuleIf() {
		String rule = "IF(x6=" + this.x6 + ";x11=" + this.x11 + ";x12="
				+ this.x12 + ";x14=" + this.x14 + ";x17=" + this.x17 + ";x24="
				+ this.x24 + ";x32=" + this.x32 + ";x33=" + this.x33 + ";x35="
				+ this.x35 + ";x36=" + this.x36 + ";x37=" + this.x37 + ";x40="
				+ this.x40 + ";x41=" + this.x41 + ")";
		return rule;
	}

	public String toRuleThen() {
		String rule = "THEN(y=" + this.x42 + ");";
		return rule;
	}

	public int compareTo(U2RObject object) {

		int compareQuantity = object.getX6();

		// ascending order
		return this.x6 - compareQuantity;

		// descending order
		// return compareQuantity - this.quantity;

	}
}
