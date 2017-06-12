package com.model;

public class ScoreObject {
	private String rule;
	private double support;
	private double accuracy;
	private double coverage;
	int scale = 6;

	public void setSupport(Integer a, Integer b) {
		this.support = (float) a / b;
		this.support = round(this.support, scale);
	}

	public void setAccuracy(Integer a, Integer b) {
		this.accuracy = (float) a / b;
		this.accuracy = round(this.accuracy, scale);
	}

	public void setCoverage(Integer a, Integer b) {
		this.coverage = (float) a / b;
		this.coverage = round(this.coverage, scale);
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

	public static double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();

		long factor = (long) Math.pow(10, places);
		value = value * factor;
		long tmp = Math.round(value);
		return (double) tmp / factor;
	}
}
