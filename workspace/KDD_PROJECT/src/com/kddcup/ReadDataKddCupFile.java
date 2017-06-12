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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

import com.constant.GeneralConstant;
import com.model.KddCupObject;
import com.model.ScoreObject;
import com.model.ShortKddCupObject;
import com.model.ThresholdObject;

public class ReadDataKddCupFile {

	public static void main(String agr[]) throws IOException {
		read(GeneralConstant.INPUT_KDD_CUP_10_PERCENT);
		// fetchUniNumber((float) 0.0, (float) 255.0, 5, 67);
		// fetchUniNumber((float) 0.0, (float) 1.0, 5, (float) 4.7750006);
	}

	public static void read(String nameFile) throws IOException {
		List<ShortKddCupObject> shortKddCups = new ArrayList<ShortKddCupObject>();
		List<KddCupObject> kddCups = new ArrayList<KddCupObject>();
		List<String> services = new ArrayList<String>();
		ThresholdObject threshold = new ThresholdObject();
		Set<String> attack = new HashSet<String>();
		BufferedReader buffReader = null;
		try {
			buffReader = new BufferedReader(new InputStreamReader(
					new FileInputStream(new File(nameFile)),
					GeneralConstant.ENCODING_UTF8));
			String token;
			while ((token = buffReader.readLine()) != null) {
				String[] parameters = token.split(",");
				if (parameters.length == 42) {
					ShortKddCupObject shortKddCup = new ShortKddCupObject();
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
					if (GeneralConstant.LABELS.contains(label)) {
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
		System.out.println("Min: " + threshold.getCountMin() + ", Max: "
				+ threshold.getCountMax());
		System.out.println("Min: " + threshold.getSrvSerrorRateMin()
				+ ", Max: " + threshold.getSrvSerrorRateMax());
		System.out.println("Min: " + threshold.getSrvRerrorRateMin()
				+ ", Max: " + threshold.getSrvRerrorRateMax());
		System.out.println("Min: " + threshold.getDstHostCountMin() + ", Max: "
				+ threshold.getDstHostCountMax());
		System.out.println("Min: " + threshold.getDstHostSameSrvRateMin()
				+ ", Max: " + threshold.getDstHostSameSrvRateMax());
		System.out.println("Min: " + threshold.getDstHostDiffSrvRateMin()
				+ ", Max: " + threshold.getDstHostDiffSrvRateMax());

		for (ShortKddCupObject ob : shortKddCups) {
			KddCupObject temp = new KddCupObject();
			temp.setX3(Integer.parseInt(ob.getService()));
			temp.setX23(KddCupUtils.getInstance().fetchUniNumber(
					threshold.getCountMin(), threshold.getCountMax(),
					GeneralConstant.NUMBER_OF_RANGES, ob.getCount()));
			temp.setX29(KddCupUtils.getInstance().fetchUniNumber(
					threshold.getSrvSerrorRateMin(),
					threshold.getSrvSerrorRateMax(),
					GeneralConstant.NUMBER_OF_RANGES, ob.getSrvSerrorRate()));
			temp.setX30(KddCupUtils.getInstance().fetchUniNumber(
					threshold.getSrvRerrorRateMin(),
					threshold.getSrvRerrorRateMax(),
					GeneralConstant.NUMBER_OF_RANGES, ob.getSrvRerrorRate()));
			temp.setX32(KddCupUtils.getInstance().fetchUniNumber(
					threshold.getDstHostCountMin(),
					threshold.getDstHostCountMax(),
					GeneralConstant.NUMBER_OF_RANGES, ob.getDstHostCount()));
			temp.setX34(KddCupUtils.getInstance().fetchUniNumber(
					threshold.getDstHostSameSrvRateMin(),
					threshold.getDstHostSameSrvRateMax(),
					GeneralConstant.NUMBER_OF_RANGES,
					ob.getDstHostSameSrvRate()));
			temp.setX35(KddCupUtils.getInstance().fetchUniNumber(
					threshold.getDstHostDiffSrvRateMin(),
					threshold.getDstHostDiffSrvRateMax(),
					GeneralConstant.NUMBER_OF_RANGES,
					ob.getDstHostDiffSrvRate()));
			temp.setX42(Integer.parseInt(ob.getAttack()));
			kddCups.add(temp);
		}
		Map<String, Integer> ruleMap = new HashMap<String, Integer>();
		Map<String, Integer> ruleIfMap = new HashMap<String, Integer>();
		Map<String, Integer> ruleThenMap = new HashMap<String, Integer>();
		FileWriter writer = null;
		try {
			writer = new FileWriter(
					GeneralConstant.INPUT_KDD_CUP_10_PERCENT_8_PARAMESTER);
			for (KddCupObject ob : kddCups) {
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
			writer = new FileWriter(
					GeneralConstant.INPUT_KDD_CUP_10_PERCENT_RULE);
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
		try {
			writer = new FileWriter(
					GeneralConstant.INPUT_KDD_CUP_10_PERCENT_SCORE);
			DecimalFormat df = new DecimalFormat("#.#");
			df.setMaximumFractionDigits(6);
			for (ScoreObject rule : result) {
				// System.out.println(rule);
				if (rule.getAccuracy() == 1) {
					tt++;
				}
				writer.write(df.format(rule.getSupport()) + " " + df.format(rule.getAccuracy()) + " "
						+ df.format(rule.getCoverage()) + " " + rule.getRule() + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
		System.out.println("Accurary = 1: " + tt);
		System.out.println("Rule map: "
				+ KddCupUtils.getInstance().countNumber(ruleMap));
		// System.out.println("Rule If map: " +
		// KddCupUtils.getInstance().countNumber(ruleIfMap));
		// System.out.println("Rule Then map: " +
		// KddCupUtils.getInstance().countNumber(ruleThenMap));
	}
}
