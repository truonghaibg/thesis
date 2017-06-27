package com.model;

import com.kddcup.KddCupUtils;

public class ThresholdU2RObject {
	private double x6Min = 1000;;
	private double x11Min = 1000;;
	private double x12Min = 1000;;
	private double x14Min = 1000;
	private double x17Min = 1000;
	private double x24Min = 1000;
	private double x32Min = 1000;
	private double x33Min = 1000;
	private double x35Min = 1000;
	private double x36Min = 1000;
	private double x37Min = 1000;
	private double x40Min = 1000;
	private double x41Min = 1000;

	private double x6Max = 0;
	private double x11Max = 0;
	private double x12Max = 0;
	private double x14Max = 0;
	private double x17Max = 0;
	private double x24Max = 0;
	private double x32Max = 0;
	private double x33Max = 0;
	private double x35Max = 0;
	private double x36Max = 0;
	private double x37Max = 0;
	private double x40Max = 0;
	private double x41Max = 0;

	public void setX6(double value) {
		x6Min = KddCupUtils.getInstance().searchMin(x6Min, value);
		x6Max = KddCupUtils.getInstance().searchMax(x6Max, value);
	}

	public void setX11(double value) {
		x11Min = KddCupUtils.getInstance().searchMin(x11Min, value);
		x11Max = KddCupUtils.getInstance().searchMax(x11Max, value);
	}

	public void setX12(double value) {
		x12Min = KddCupUtils.getInstance().searchMin(x12Min, value);
		x12Max = KddCupUtils.getInstance().searchMax(x12Max, value);
	}

	public void setX14(double value) {
		x14Min = KddCupUtils.getInstance().searchMin(x14Min, value);
		x14Max = KddCupUtils.getInstance().searchMax(x14Max, value);
	}

	public void setX17(double value) {
		x17Min = KddCupUtils.getInstance().searchMin(x17Min, value);
		x17Max = KddCupUtils.getInstance().searchMax(x17Max, value);
	}

	public void setX24(double value) {
		x24Min = KddCupUtils.getInstance().searchMin(x24Min, value);
		x24Max = KddCupUtils.getInstance().searchMax(x24Max, value);
	}

	public void setX32(double value) {
		x32Min = KddCupUtils.getInstance().searchMin(x32Min, value);
		x32Max = KddCupUtils.getInstance().searchMax(x32Max, value);
	}

	public void setX33(double value) {
		x33Min = KddCupUtils.getInstance().searchMin(x33Min, value);
		x33Max = KddCupUtils.getInstance().searchMax(x33Max, value);
	}

	public void setX35(double value) {
		x35Min = KddCupUtils.getInstance().searchMin(x35Min, value);
		x35Max = KddCupUtils.getInstance().searchMax(x35Max, value);
	}

	public void setX36(double value) {
		x36Min = KddCupUtils.getInstance().searchMin(x36Min, value);
		x36Max = KddCupUtils.getInstance().searchMax(x36Max, value);
	}

	public void setX37(double value) {
		x37Min = KddCupUtils.getInstance().searchMin(x37Min, value);
		x37Max = KddCupUtils.getInstance().searchMax(x37Max, value);
	}

	public void setX40(double value) {
		x40Min = KddCupUtils.getInstance().searchMin(x40Min, value);
		x40Max = KddCupUtils.getInstance().searchMax(x40Max, value);
	}

	public void setX41(double value) {
		x41Min = KddCupUtils.getInstance().searchMin(x41Min, value);
		x41Max = KddCupUtils.getInstance().searchMax(x41Max, value);
	}

	public double getX6Min() {
		return x6Min;
	}

	public void setX6Min(double x6Min) {
		this.x6Min = x6Min;
	}

	public double getX11Min() {
		return x11Min;
	}

	public void setX11Min(double x11Min) {
		this.x11Min = x11Min;
	}

	public double getX12Min() {
		return x12Min;
	}

	public void setX12Min(double x12Min) {
		this.x12Min = x12Min;
	}

	public double getX14Min() {
		return x14Min;
	}

	public void setX14Min(double x14Min) {
		this.x14Min = x14Min;
	}

	public double getX17Min() {
		return x17Min;
	}

	public void setX17Min(double x17Min) {
		this.x17Min = x17Min;
	}

	public double getX24Min() {
		return x24Min;
	}

	public void setX24Min(double x24Min) {
		this.x24Min = x24Min;
	}

	public double getX32Min() {
		return x32Min;
	}

	public void setX32Min(double x32Min) {
		this.x32Min = x32Min;
	}

	public double getX33Min() {
		return x33Min;
	}

	public void setX33Min(double x33Min) {
		this.x33Min = x33Min;
	}

	public double getX35Min() {
		return x35Min;
	}

	public void setX35Min(double x35Min) {
		this.x35Min = x35Min;
	}

	public double getX36Min() {
		return x36Min;
	}

	public void setX36Min(double x36Min) {
		this.x36Min = x36Min;
	}

	public double getX37Min() {
		return x37Min;
	}

	public void setX37Min(double x37Min) {
		this.x37Min = x37Min;
	}

	public double getX40Min() {
		return x40Min;
	}

	public void setX40Min(double x40Min) {
		this.x40Min = x40Min;
	}

	public double getX41Min() {
		return x41Min;
	}

	public void setX41Min(double x41Min) {
		this.x41Min = x41Min;
	}

	public double getX6Max() {
		return x6Max;
	}

	public void setX6Max(double x6Max) {
		this.x6Max = x6Max;
	}

	public double getX11Max() {
		return x11Max;
	}

	public void setX11Max(double x11Max) {
		this.x11Max = x11Max;
	}

	public double getX12Max() {
		return x12Max;
	}

	public void setX12Max(double x12Max) {
		this.x12Max = x12Max;
	}

	public double getX14Max() {
		return x14Max;
	}

	public void setX14Max(double x14Max) {
		this.x14Max = x14Max;
	}

	public double getX17Max() {
		return x17Max;
	}

	public void setX17Max(double x17Max) {
		this.x17Max = x17Max;
	}

	public double getX24Max() {
		return x24Max;
	}

	public void setX24Max(double x24Max) {
		this.x24Max = x24Max;
	}

	public double getX32Max() {
		return x32Max;
	}

	public void setX32Max(double x32Max) {
		this.x32Max = x32Max;
	}

	public double getX33Max() {
		return x33Max;
	}

	public void setX33Max(double x33Max) {
		this.x33Max = x33Max;
	}

	public double getX35Max() {
		return x35Max;
	}

	public void setX35Max(double x35Max) {
		this.x35Max = x35Max;
	}

	public double getX36Max() {
		return x36Max;
	}

	public void setX36Max(double x36Max) {
		this.x36Max = x36Max;
	}

	public double getX37Max() {
		return x37Max;
	}

	public void setX37Max(double x37Max) {
		this.x37Max = x37Max;
	}

	public double getX40Max() {
		return x40Max;
	}

	public void setX40Max(double x40Max) {
		this.x40Max = x40Max;
	}

	public double getX41Max() {
		return x41Max;
	}

	public void setX41Max(double x41Max) {
		this.x41Max = x41Max;
	}
	
}
