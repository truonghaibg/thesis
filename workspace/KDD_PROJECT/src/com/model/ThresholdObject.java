package com.model;

import com.kddcup.KddCupUtils;

public class ThresholdObject {
	double countMin;
	double countMax;
	double srvSerrorRateMin;
	double srvSerrorRateMax;
	double srvRerrorRateMin;
	double srvRerrorRateMax;
	double dstHostCountMin;
	double dstHostCountMax;
	double dstHostSameSrvRateMin;
	double dstHostSameSrvRateMax;
	double dstHostDiffSrvRateMin;
	double dstHostDiffSrvRateMax;

	public void setCount(double value) {
		countMin = KddCupUtils.getInstance().searchMin(countMin, value);
		countMax = KddCupUtils.getInstance().searchMax(countMax, value);
	}

	public void setSrvSerrorRate(double value) {
		srvSerrorRateMin = KddCupUtils.getInstance().searchMin(srvSerrorRateMin, value);
		srvSerrorRateMax = KddCupUtils.getInstance().searchMax(srvSerrorRateMax, value);
	}

	public void setSrvRerrorRate(double value) {
		srvRerrorRateMin = KddCupUtils.getInstance().searchMin(srvRerrorRateMin, value);
		srvRerrorRateMax = KddCupUtils.getInstance().searchMax(srvRerrorRateMax, value);
	}

	public void setDstHostCount(double value) {
		dstHostCountMin = KddCupUtils.getInstance().searchMin(dstHostCountMin, value);
		dstHostCountMax = KddCupUtils.getInstance().searchMax(dstHostCountMax, value);
	}

	public void setDstHostSameSrvRate(double value) {
		dstHostSameSrvRateMin = KddCupUtils.getInstance().searchMin(dstHostSameSrvRateMin, value);
		dstHostSameSrvRateMax = KddCupUtils.getInstance().searchMax(dstHostSameSrvRateMax, value);
	}

	public void setDstHostDiffSrvRate(double value) {
		dstHostDiffSrvRateMin = KddCupUtils.getInstance().searchMin(dstHostDiffSrvRateMin, value);
		dstHostDiffSrvRateMax = KddCupUtils.getInstance().searchMax(dstHostDiffSrvRateMax, value);
	}

	public double getCountMin() {
		return countMin;
	}

	public void setCountMin(double countMin) {
		this.countMin = countMin;
	}

	public double getCountMax() {
		return countMax;
	}

	public void setCountMax(double countMax) {
		this.countMax = countMax;
	}

	public double getSrvSerrorRateMin() {
		return srvSerrorRateMin;
	}

	public void setSrvSerrorRateMin(double srvSerrorRateMin) {
		this.srvSerrorRateMin = srvSerrorRateMin;
	}

	public double getSrvSerrorRateMax() {
		return srvSerrorRateMax;
	}

	public void setSrvSerrorRateMax(double srvSerrorRateMax) {
		this.srvSerrorRateMax = srvSerrorRateMax;
	}

	public double getSrvRerrorRateMin() {
		return srvRerrorRateMin;
	}

	public void setSrvRerrorRateMin(double srvRerrorRateMin) {
		this.srvRerrorRateMin = srvRerrorRateMin;
	}

	public double getSrvRerrorRateMax() {
		return srvRerrorRateMax;
	}

	public void setSrvRerrorRateMax(double srvRerrorRateMax) {
		this.srvRerrorRateMax = srvRerrorRateMax;
	}

	public double getDstHostCountMin() {
		return dstHostCountMin;
	}

	public void setDstHostCountMin(double dstHostCountMin) {
		this.dstHostCountMin = dstHostCountMin;
	}

	public double getDstHostCountMax() {
		return dstHostCountMax;
	}

	public void setDstHostCountMax(double dstHostCountMax) {
		this.dstHostCountMax = dstHostCountMax;
	}

	public double getDstHostSameSrvRateMin() {
		return dstHostSameSrvRateMin;
	}

	public void setDstHostSameSrvRateMin(double dstHostSameSrvRateMin) {
		this.dstHostSameSrvRateMin = dstHostSameSrvRateMin;
	}

	public double getDstHostSameSrvRateMax() {
		return dstHostSameSrvRateMax;
	}

	public void setDstHostSameSrvRateMax(double dstHostSameSrvRateMax) {
		this.dstHostSameSrvRateMax = dstHostSameSrvRateMax;
	}

	public double getDstHostDiffSrvRateMin() {
		return dstHostDiffSrvRateMin;
	}

	public void setDstHostDiffSrvRateMin(double dstHostDiffSrvRateMin) {
		this.dstHostDiffSrvRateMin = dstHostDiffSrvRateMin;
	}

	public double getDstHostDiffSrvRateMax() {
		return dstHostDiffSrvRateMax;
	}

	public void setDstHostDiffSrvRateMax(double dstHostDiffSrvRateMax) {
		this.dstHostDiffSrvRateMax = dstHostDiffSrvRateMax;
	}

}
