package com.constant;

import java.util.Arrays;
import java.util.List;

public final class GeneralConstant {

	public class SYMBOL {
		public static final String DOTS = ".";
		public static final String SPACE = " ";
		public static final String UNDERSCORE = "_";
		public static final String SLASH = "/";
		public static final String AND = "&";
	}

	public class CLASSIFY {
		public static final String MALE = "male";
		public static final String MALE_VALUE = "1";
		public static final String FEMALE = "female";
		public static final String FEMALE_VALUE = "-1";
	}

	public static final String INPUT_KDD_CUP_10_PERCENT = "dataset/kddcup.data_10_percent_corrected";
	public static final String INPUT_KDD_CUP_10_PERCENT_8_PARAMESTER = "dataset/kddcup.data_10_percent_corrected_8_paramester";
	public static final String INPUT_KDD_CUP_10_PERCENT_RULE = "dataset/kddcup.data_10_percent_corrected_rule";
	public static final String INPUT_KDD_CUP_10_PERCENT_SCORE = "dataset/kddcup.data_10_percent_score";

	public static final String ENCODING_UTF8 = "UTF-8";

	public static int NUMBER_OF_RANGES = 5;

	public static List<String> LABELS = Arrays.asList("back", "land", "neptune", "pod", "smurf", "teardrop");
}
