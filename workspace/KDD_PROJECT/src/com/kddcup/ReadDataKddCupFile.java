package com.kddcup;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.constant.GeneralConstant;
import com.model.DosObject;
import com.model.ScoreObject;
import com.model.ShortDOSObject;
import com.model.ShortU2RObject;
import com.model.ThresholdObject;
import com.model.ThresholdScoreObject;
import com.model.ThresholdU2RObject;
import com.model.U2RObject;

public class ReadDataKddCupFile {

	public static void main(String agr[]) throws IOException {
		// readDOS(GeneralConstant.INPUT_KDD_CUP_10_PERCENT);
		readU2R(GeneralConstant.INPUT_KDD_CUP_10_PERCENT);
		// fetchUniNumber((float) 0.0, (float) 255.0, 5, 67);
		// fetchUniNumber((float) 0.0, (float) 1.0, 5, (float) 4.7750006);
	}

	public static void readDOS(String nameFile) throws IOException {
		List<ShortDOSObject> shortKddCups = new ArrayList<ShortDOSObject>();
		List<DosObject> kddCups = new ArrayList<DosObject>();
		List<String> services = new ArrayList<String>();
		ThresholdObject threshold = new ThresholdObject();
		Set<String> attack = new HashSet<String>();
		BufferedReader buffReader = null;
		try {
			buffReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(nameFile)), GeneralConstant.ENCODING_UTF8));
			String token;
			while ((token = buffReader.readLine()) != null) {
				String[] parameters = token.split(",");
				if (parameters.length == 42) {
					ShortDOSObject shortKddCup = new ShortDOSObject();
					float count;
					float srvSerrorRate;
					float srvRerrorRate;
					float dstHostCount;
					float dstHostSameSrvRate;
					float dstHostDiffSrvRate;

					String service = parameters[2];
					if (!services.contains(service)) {
						services.add(service);
					}
					int index = services.indexOf(service);
					shortKddCup.setService(index + "");

					count = Float.parseFloat(parameters[22]);
					threshold.setCount(count);
					shortKddCup.setCount(count);

					srvSerrorRate = Float.parseFloat(parameters[28]);
					threshold.setSrvSerrorRate(srvSerrorRate);
					shortKddCup.setSrvSerrorRate(srvSerrorRate);

					srvRerrorRate = Float.parseFloat(parameters[29]);
					threshold.setSrvRerrorRate(srvRerrorRate);
					shortKddCup.setSrvRerrorRate(srvRerrorRate);

					dstHostCount = Float.parseFloat(parameters[31]);
					threshold.setDstHostCount(dstHostCount);
					shortKddCup.setDstHostCount(dstHostCount);

					dstHostSameSrvRate = Float.parseFloat(parameters[33]);
					threshold.setDstHostSameSrvRate(dstHostSameSrvRate);
					shortKddCup.setDstHostSameSrvRate(dstHostSameSrvRate);

					dstHostDiffSrvRate = Float.parseFloat(parameters[34]);
					threshold.setDstHostDiffSrvRate(dstHostDiffSrvRate);
					shortKddCup.setDstHostDiffSrvRate(dstHostDiffSrvRate);

					String label = parameters[41].replace(".", "");
					attack.add(label);
					if (GeneralConstant.DOS_LABELS.contains(label)) {
						label = "1";
					} else {
						label = "0";
					}
					shortKddCup.setAttack(label);
					shortKddCups.add(shortKddCup);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (buffReader != null) {
				buffReader.close();
			}
		}
		// for (String ob : attack) {
		// System.out.println(ob);
		// }
		System.out.println("Min: " + threshold.getCountMin() + ", Max: " + threshold.getCountMax());
		System.out.println("Min: " + threshold.getSrvSerrorRateMin() + ", Max: " + threshold.getSrvSerrorRateMax());
		System.out.println("Min: " + threshold.getSrvRerrorRateMin() + ", Max: " + threshold.getSrvRerrorRateMax());
		System.out.println("Min: " + threshold.getDstHostCountMin() + ", Max: " + threshold.getDstHostCountMax());
		System.out.println("Min: " + threshold.getDstHostSameSrvRateMin() + ", Max: " + threshold.getDstHostSameSrvRateMax());
		System.out.println("Min: " + threshold.getDstHostDiffSrvRateMin() + ", Max: " + threshold.getDstHostDiffSrvRateMax());

		for (ShortDOSObject ob : shortKddCups) {
			DosObject temp = new DosObject();
			temp.setX3(Integer.parseInt(ob.getService()));
			temp.setX23(KddCupUtils.getInstance().fetchUniNumber(threshold.getCountMin(), threshold.getCountMax(), GeneralConstant.NUMBER_OF_RANGES,
					ob.getCount()));
			temp.setX29(KddCupUtils.getInstance().fetchUniNumber(threshold.getSrvSerrorRateMin(), threshold.getSrvSerrorRateMax(),
					GeneralConstant.NUMBER_OF_RANGES, ob.getSrvSerrorRate()));
			temp.setX30(KddCupUtils.getInstance().fetchUniNumber(threshold.getSrvRerrorRateMin(), threshold.getSrvRerrorRateMax(),
					GeneralConstant.NUMBER_OF_RANGES, ob.getSrvRerrorRate()));
			temp.setX32(KddCupUtils.getInstance().fetchUniNumber(threshold.getDstHostCountMin(), threshold.getDstHostCountMax(),
					GeneralConstant.NUMBER_OF_RANGES, ob.getDstHostCount()));
			temp.setX34(KddCupUtils.getInstance().fetchUniNumber(threshold.getDstHostSameSrvRateMin(), threshold.getDstHostSameSrvRateMax(),
					GeneralConstant.NUMBER_OF_RANGES, ob.getDstHostSameSrvRate()));
			temp.setX35(KddCupUtils.getInstance().fetchUniNumber(threshold.getDstHostDiffSrvRateMin(), threshold.getDstHostDiffSrvRateMax(),
					GeneralConstant.NUMBER_OF_RANGES, ob.getDstHostDiffSrvRate()));
			temp.setX42(Integer.parseInt(ob.getAttack()));
			kddCups.add(temp);
		}
		Map<String, Integer> ruleMap = new HashMap<String, Integer>();
		Map<String, Integer> ruleIfMap = new HashMap<String, Integer>();
		Map<String, Integer> ruleThenMap = new HashMap<String, Integer>();
		FileWriter writer = null;
		try {
			writer = new FileWriter(GeneralConstant.INPUT_KDD_CUP_10_PERCENT_8_PARAMESTER_DOS);
			for (DosObject ob : kddCups) {
				String key = ob.toRule();
				KddCupUtils.getInstance().putKeyIntoMap(ruleMap, key);

				String keyIf = ob.toRuleIf();
				KddCupUtils.getInstance().putKeyIntoMap(ruleIfMap, keyIf);

				String keyThen = ob.toRuleThen();
				KddCupUtils.getInstance().putKeyIntoMap(ruleThenMap, keyThen);

				writer.write(ob.toString() + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
		System.out.println("Size rule: " + ruleMap.size());
		try {
			writer = new FileWriter(GeneralConstant.INPUT_KDD_CUP_10_PERCENT_RULE_DOS);
			for (Entry<String, Integer> entry : ruleMap.entrySet()) {
				// System.out.println(entry.getKey());
				writer.write(entry.getKey() + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				writer.close();
			}
		}

		List<ScoreObject> result = new ArrayList<ScoreObject>();
		int size = kddCups.size();
		for (Entry<String, Integer> entry : ruleMap.entrySet()) {
			ScoreObject so = new ScoreObject();
			String key = entry.getKey();
			String keyIf = key.split(GeneralConstant.SYMBOL.SPACE)[0];
			String keyThen = key.split(GeneralConstant.SYMBOL.SPACE)[1];
			Integer value = entry.getValue();
			so.setRule(keyIf + " " + keyThen);
			so.setSupport(value, size);
			so.setAccuracy(value, ruleIfMap.get(keyIf));
			so.setCoverage(value, ruleThenMap.get(keyThen));

			result.add(so);
		}
		int tt = 0;
		Collections.sort(result);
		ThresholdScoreObject thresholdScore = new ThresholdScoreObject();
		try {
			writer = new FileWriter(GeneralConstant.INPUT_KDD_CUP_10_PERCENT_SCORE_DOS);
			DecimalFormat df = new DecimalFormat("#.#");
			df.setMaximumFractionDigits(6);
			for (ScoreObject rule : result) {
				// System.out.println(rule);
				thresholdScore.setSupport(rule.getSupport());
				thresholdScore.setAccuracy(rule.getAccuracy());
				thresholdScore.setCoverage(rule.getCoverage());
				if (rule.getAccuracy() == 1) {
					tt++;
				}
				writer.write(df.format(rule.getTotal()) + " " + df.format(rule.getSupport()) + " " + df.format(rule.getAccuracy()) + " "
						+ df.format(rule.getCoverage()) + " " + rule.getRule() + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
		thresholdScore.showReport();
		System.out.println("Accurary = 1: " + tt);
		System.out.println("Rule map: " + KddCupUtils.getInstance().countNumber(ruleMap));
		// System.out.println("Rule If map: " +
		// KddCupUtils.getInstance().countNumber(ruleIfMap));
		// System.out.println("Rule Then map: " +
		// KddCupUtils.getInstance().countNumber(ruleThenMap));
	}

	public static void readU2R(String nameFile) throws IOException {
		List<ShortU2RObject> shortU2R = new ArrayList<ShortU2RObject>();
		List<U2RObject> u2rCups = new ArrayList<U2RObject>();
		List<String> services = new ArrayList<String>();
		ThresholdU2RObject threshold = new ThresholdU2RObject();
		Set<String> attack = new HashSet<String>();
		BufferedReader buffReader = null;
		try {
			buffReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(nameFile)), GeneralConstant.ENCODING_UTF8));
			String token;
			while ((token = buffReader.readLine()) != null) {
				String[] parameters = token.split(",");
				if (parameters.length == 42) {
					ShortU2RObject shortU2RKddCup = new ShortU2RObject();
					float x6;
					float x11;
					float x12;
					float x14;
					float x17;
					float x24;
					float x32;
					float x33;
					float x35;
					float x36;
					float x37;
					float x40;
					float x41;

					x6 = Float.parseFloat(parameters[5]);
					threshold.setX6(x6);
					shortU2RKddCup.setX6(x6);

					x11 = Float.parseFloat(parameters[10]);
					threshold.setX11(x11);
					shortU2RKddCup.setX11(x11);

					x12 = Float.parseFloat(parameters[11]);
					threshold.setX12(x12);
					shortU2RKddCup.setX12(x12);

					x14 = Float.parseFloat(parameters[13]);
					threshold.setX14(x14);
					shortU2RKddCup.setX14(x14);

					x17 = Float.parseFloat(parameters[16]);
					threshold.setX17(x17);
					shortU2RKddCup.setX17(x17);

					x24 = Float.parseFloat(parameters[23]);
					threshold.setX24(x24);
					shortU2RKddCup.setX24(x24);

					x32 = Float.parseFloat(parameters[31]);
					threshold.setX32(x32);
					shortU2RKddCup.setX32(x32);

					x33 = Float.parseFloat(parameters[32]);
					threshold.setX33(x33);
					shortU2RKddCup.setX33(x33);

					x35 = Float.parseFloat(parameters[34]);
					threshold.setX35(x35);
					shortU2RKddCup.setX35(x35);

					x36 = Float.parseFloat(parameters[35]);
					threshold.setX36(x36);
					shortU2RKddCup.setX36(x36);

					x37 = Float.parseFloat(parameters[36]);
					threshold.setX37(x37);
					shortU2RKddCup.setX37(x37);

					x40 = Float.parseFloat(parameters[39]);
					threshold.setX40(x40);
					shortU2RKddCup.setX40(x40);

					x41 = Float.parseFloat(parameters[40]);
					threshold.setX41(x41);
					shortU2RKddCup.setX41(x41);

					String label = parameters[41].replace(".", "");
					attack.add(label);
					if (GeneralConstant.U2R_LABELS.contains(label)) {
						label = "1";
					} else {
						label = "0";
					}
					shortU2RKddCup.setX42(label);
					shortU2R.add(shortU2RKddCup);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (buffReader != null) {
				buffReader.close();
			}
		}
		// for (String ob : attack) {
		// System.out.println(ob);
		// }
		System.out.println("x6:  Min: " + threshold.getX6Min() + ", Max: " + threshold.getX6Max());
		System.out.println("x11: Min: " + threshold.getX11Min() + ", Max: " + threshold.getX11Max());
		System.out.println("x12: Min: " + threshold.getX12Min() + ", Max: " + threshold.getX12Max());
		System.out.println("x14: Min: " + threshold.getX14Min() + ", Max: " + threshold.getX14Max());
		System.out.println("x17: Min: " + threshold.getX17Min() + ", Max: " + threshold.getX17Max());
		System.out.println("x24: Min: " + threshold.getX24Min() + ", Max: " + threshold.getX24Max());
		System.out.println("x32: Min: " + threshold.getX32Min() + ", Max: " + threshold.getX32Max());
		System.out.println("x33: Min: " + threshold.getX33Min() + ", Max: " + threshold.getX33Max());
		System.out.println("x35: Min: " + threshold.getX35Min() + ", Max: " + threshold.getX35Max());
		System.out.println("x36: Min: " + threshold.getX36Min() + ", Max: " + threshold.getX36Max());
		System.out.println("x37: Min: " + threshold.getX37Min() + ", Max: " + threshold.getX37Max());
		System.out.println("x40: Min: " + threshold.getX40Min() + ", Max: " + threshold.getX40Max());
		System.out.println("x41: Min: " + threshold.getX41Min() + ", Max: " + threshold.getX41Max());

		for (ShortU2RObject ob : shortU2R) {
			U2RObject temp = new U2RObject();
			temp.setX6(KddCupUtils.getInstance().fetchUniNumber(threshold.getX6Min(), threshold.getX6Max(), GeneralConstant.NUMBER_OF_RANGES, ob.getX6()));
			temp.setX11(KddCupUtils.getInstance().fetchUniNumber(threshold.getX11Min(), threshold.getX11Max(), GeneralConstant.NUMBER_OF_RANGES, ob.getX11()));
			temp.setX14(KddCupUtils.getInstance().fetchUniNumber(threshold.getX14Min(), threshold.getX14Max(), GeneralConstant.NUMBER_OF_RANGES, ob.getX14()));
			temp.setX17(KddCupUtils.getInstance().fetchUniNumber(threshold.getX17Min(), threshold.getX17Max(), GeneralConstant.NUMBER_OF_RANGES, ob.getX17()));
			temp.setX24(KddCupUtils.getInstance().fetchUniNumber(threshold.getX24Min(), threshold.getX24Max(), GeneralConstant.NUMBER_OF_RANGES, ob.getX24()));
			temp.setX32(KddCupUtils.getInstance().fetchUniNumber(threshold.getX32Min(), threshold.getX32Max(), GeneralConstant.NUMBER_OF_RANGES, ob.getX32()));
			temp.setX33(KddCupUtils.getInstance().fetchUniNumber(threshold.getX33Min(), threshold.getX33Max(), GeneralConstant.NUMBER_OF_RANGES, ob.getX32()));
			temp.setX35(KddCupUtils.getInstance().fetchUniNumber(threshold.getX35Min(), threshold.getX35Max(), GeneralConstant.NUMBER_OF_RANGES, ob.getX32()));
			temp.setX36(KddCupUtils.getInstance().fetchUniNumber(threshold.getX36Min(), threshold.getX36Max(), GeneralConstant.NUMBER_OF_RANGES, ob.getX32()));
			temp.setX37(KddCupUtils.getInstance().fetchUniNumber(threshold.getX37Min(), threshold.getX37Max(), GeneralConstant.NUMBER_OF_RANGES, ob.getX32()));
			temp.setX40(KddCupUtils.getInstance().fetchUniNumber(threshold.getX40Min(), threshold.getX40Max(), GeneralConstant.NUMBER_OF_RANGES, ob.getX32()));
			temp.setX41(KddCupUtils.getInstance().fetchUniNumber(threshold.getX41Min(), threshold.getX41Max(), GeneralConstant.NUMBER_OF_RANGES, ob.getX32()));

			temp.setX42(Integer.parseInt(ob.getX42()));
			u2rCups.add(temp);
		}
		Map<String, Integer> ruleMap = new HashMap<String, Integer>();
		Map<String, Integer> ruleIfMap = new HashMap<String, Integer>();
		Map<String, Integer> ruleThenMap = new HashMap<String, Integer>();
		FileWriter writer = null;
		try {
			writer = new FileWriter(GeneralConstant.INPUT_KDD_CUP_10_PERCENT_14_PARAMESTER_U2R);
			for (U2RObject ob : u2rCups) {
				String key = ob.toRule();
				KddCupUtils.getInstance().putKeyIntoMap(ruleMap, key);

				String keyIf = ob.toRuleIf();
				KddCupUtils.getInstance().putKeyIntoMap(ruleIfMap, keyIf);

				String keyThen = ob.toRuleThen();
				KddCupUtils.getInstance().putKeyIntoMap(ruleThenMap, keyThen);

				writer.write(ob.toString() + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
		System.out.println("Size rule: " + ruleMap.size());
		try {
			writer = new FileWriter(GeneralConstant.INPUT_KDD_CUP_10_PERCENT_RULE_U2R);
			for (Entry<String, Integer> entry : ruleMap.entrySet()) {
				// System.out.println(entry.getKey());
				writer.write(entry.getKey() + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				writer.close();
			}
		}

		List<ScoreObject> result = new ArrayList<ScoreObject>();
		int size = u2rCups.size();
		for (Entry<String, Integer> entry : ruleMap.entrySet()) {
			ScoreObject so = new ScoreObject();
			String key = entry.getKey();
			String keyIf = key.split(GeneralConstant.SYMBOL.SPACE)[0];
			String keyThen = key.split(GeneralConstant.SYMBOL.SPACE)[1];
			Integer value = entry.getValue();
			so.setRule(keyIf + " " + keyThen);
			so.setSupport(value, size);
			so.setAccuracy(value, ruleIfMap.get(keyIf));
			so.setCoverage(value, ruleThenMap.get(keyThen));

			result.add(so);
		}
		int tt = 0;
		Collections.sort(result);
		ThresholdScoreObject thresholdScore = new ThresholdScoreObject();
		try {
			writer = new FileWriter(GeneralConstant.INPUT_KDD_CUP_10_PERCENT_SCORE_U2R);
			DecimalFormat df = new DecimalFormat("#.#");
			df.setMaximumFractionDigits(6);
			for (ScoreObject rule : result) {
				// System.out.println(rule);
				thresholdScore.setSupport(rule.getSupport());
				thresholdScore.setAccuracy(rule.getAccuracy());
				thresholdScore.setCoverage(rule.getCoverage());
				if (rule.getAccuracy() == 1) {
					tt++;
				}
				writer.write(df.format(rule.getTotal()) + " " + df.format(rule.getSupport()) + " " + df.format(rule.getAccuracy()) + " "
						+ df.format(rule.getCoverage()) + " " + rule.getRule() + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
		thresholdScore.showReport();
		System.out.println("Accurary = 1: " + tt);
		System.out.println("Rule map: " + KddCupUtils.getInstance().countNumber(ruleMap));
		 System.out.println("Rule If map: " +
		 KddCupUtils.getInstance().countNumber(ruleIfMap));
		 System.out.println("Rule Then map: " +
		 KddCupUtils.getInstance().countNumber(ruleThenMap));
	}
}
