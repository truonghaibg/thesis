package com.constant;

import java.util.Arrays;
import java.util.List;

public final class GeneralConstant {

	public class SYMBOL {

		public static final String DOTS = ".";
		public static final String SPACE = " ";
		public static final String UNDERSCORE = "_";
		public static final String SLASH = "/";
	}

	public static final String INPUT_KDD_CUP_10_PERCENT = "dataset/kddcup.data_10_percent_corrected";
	
	public static final String INPUT_KDD_CUP_10_PERCENT_8_PARAMESTER_DOS = "dataset/dos_kddcup.data_10_percent_corrected_8_paramester";
	public static final String INPUT_KDD_CUP_10_PERCENT_RULE_DOS = "dataset/dos_kddcup.data_10_percent_corrected_rule";
	public static final String INPUT_KDD_CUP_10_PERCENT_SCORE_DOS = "dataset/dos_kddcup.data_10_percent_score";
	
	public static final String INPUT_KDD_CUP_10_PERCENT_14_PARAMESTER_U2R = "dataset/u2r_kddcup.data_10_percent_corrected_14_paramester";
	public static final String INPUT_KDD_CUP_10_PERCENT_RULE_U2R = "dataset/u2r_kddcup.data_10_percent_corrected_rule";
	public static final String INPUT_KDD_CUP_10_PERCENT_SCORE_U2R = "dataset/u2r_kddcup.data_10_percent_score";

	public static final String ENCODING_UTF8 = "UTF-8";

	public static int NUMBER_OF_RANGES = 5;

	public static List<String> DOS_LABELS = Arrays.asList("back", "land", "neptune", "pod", "smurf", "teardrop");
	public static List<String> U2R_LABELS = Arrays.asList("buffer_overflow", "loadmodule", "perl", "rootkit");
}
