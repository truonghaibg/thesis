package com.model;

import com.kddcup.KddCupUtils;


public class ThresholdScoreObject {
	private double supportMin = 1000;
	private double supportMax = 0;
	private double accuracyMin = 1000;
	private double accuracyMax = 0;
	private double coverageMin = 1000;
	private double coverageMax = 0;

	public void setSupport(double value) {
		supportMin = KddCupUtils.getInstance().searchMin(supportMin, value);
		supportMax = KddCupUtils.getInstance().searchMax(supportMax, value);
	}

	public void setAccuracy(double value) {
		accuracyMin = KddCupUtils.getInstance().searchMin(accuracyMin, value);
		accuracyMax = KddCupUtils.getInstance().searchMax(accuracyMax, value);
	}

	public void setCoverage(double value) {
		coverageMin = KddCupUtils.getInstance().searchMin(coverageMin, value);
		coverageMax = KddCupUtils.getInstance().searchMax(coverageMax, value);
	}

	public double getSupportMin() {
		return supportMin;
	}

	public void setSupportMin(double supportMin) {
		this.supportMin = supportMin;
	}

	public double getAccuracyMin() {
		return accuracyMin;
	}

	public void setAccuracyMin(double accuracyMin) {
		this.accuracyMin = accuracyMin;
	}

	public double getCoverageMin() {
		return coverageMin;
	}

	public void setCoverageMin(double coverageMin) {
		this.coverageMin = coverageMin;
	}

	public double getSupportMax() {
		return supportMax;
	}

	public void setSupportMax(double supportMax) {
		this.supportMax = supportMax;
	}

	public double getAccuracyMax() {
		return accuracyMax;
	}

	public void setAccuracyMax(double accuracyMax) {
		this.accuracyMax = accuracyMax;
	}

	public double getCoverageMax() {
		return coverageMax;
	}

	public void setCoverageMax(double coverageMax) {
		this.coverageMax = coverageMax;
	}

	public void showReport() {
		System.out.println("Suppor min:" + this.supportMin);
		System.out.println("Suppor max:" + this.supportMax);
		System.out.println("Accuracy min:" + this.accuracyMin);
		System.out.println("Accuracy max:" + this.accuracyMax);
		System.out.println("Coverage min:" + this.coverageMin);
		System.out.println("CoverageMax max:" + this.coverageMax);
	}

}
