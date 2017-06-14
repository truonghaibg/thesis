package com.model;

public class ScoreObject implements Comparable<ScoreObject>{
	private String rule;
	private double support;
	private double accuracy;
	private double coverage;
	private double total;
	int scale = 6;

	public void setSupport(Integer a, Integer b) {
		this.support = (double) a / b;
		this.support = round(this.support, scale);
		this.total = this.total + this.support;
	}

	public void setAccuracy(Integer a, Integer b) {
		this.accuracy = (double) a / b;
		this.accuracy = round(this.accuracy, scale);
		this.total = this.total + this.accuracy;
	}

	public void setCoverage(Integer a, Integer b) {
		this.coverage = (double) a / b;
		this.coverage = round(this.coverage, scale);
		this.total = this.total + this.coverage;
	}

	public String getRule() {
		return rule;
	}

	public void setRule(String rule) {
		this.rule = rule;
	}

	public double getSupport() {
		return support;
	}

	public void setSupport(double support) {
		this.support = support;
	}

	public double getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(double accuracy) {
		this.accuracy = accuracy;
	}

	public double getCoverage() {
		return coverage;
	}

	public void setCoverage(float coverage) {
		this.coverage = coverage;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public static double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();

		long factor = (long) Math.pow(10, places);
		value = value * factor;
		long tmp = Math.round(value);
		return (double) tmp / factor;
	}

	public int compareTo(ScoreObject o) {
		return new Double(o.getTotal()).compareTo(this.total);
	}

	public String toString() {
		return String.valueOf(this.total);
	}
}
