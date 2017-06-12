package com.kddcup;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.constant.GeneralConstant;
import com.model.KddCupObject;
import com.model.ShortKddCupObject;

public class ReadDataKddCupFile {

	public static void main(String agr[]) throws IOException {
		read(GeneralConstant.INPUT_KDD_CUP_10_PERCENT);
		// fetchUniNumber((float) 0.0, (float) 255.0, 5, 67);
		// fetchUniNumber((float) 0.0, (float) 1.0, 5, (float) 4.7750006);
	}

	public static void read(String nameFile) throws IOException {
		List<ShortKddCupObject> shortKddCups = new ArrayList<ShortKddCupObject>();
		List<KddCupObject> kddCups = new ArrayList<KddCupObject>();
		List<String> labels = new ArrayList<String>();
		List<String> services = new ArrayList<String>();
		labels.add("back");
		labels.add("land");
		labels.add("neptune");
		labels.add("pod");
		labels.add("smurf");
		labels.add("teardrop");
		float countMin = 0;
		float countMax = 0;
		float srvSerrorRateMin = 0;
		float srvSerrorRateMax = 0;
		float srvRerrorRateMin = 0;
		float srvRerrorRateMax = 0;
		float dstHostCountMin = 0;
		float dstHostCountMax = 0;
		float dstHostSameSrvRateMin = 0;
		float dstHostSameSrvRateMax = 0;
		float dstHostDiffSrvRateMin = 0;
		float dstHostDiffSrvRateMax = 0;
		Set<String> attack = new HashSet<String>();
		Set<String> rules = new TreeSet<String>();
		BufferedReader buffReader = null;
		try {
			buffReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(nameFile)), GeneralConstant.ENCODING_UTF8));
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
					countMin = searchMin(countMin, count);
					countMax = searchMax(countMax, count);
					shortKddCup.setCount(count);

					srvSerrorRate = Float.parseFloat(parameters[28]);
					srvSerrorRateMin = searchMin(srvSerrorRateMin, srvSerrorRate);
					srvSerrorRateMax = searchMax(srvSerrorRateMax, srvSerrorRate);
					shortKddCup.setSrvSerrorRate(srvSerrorRate);

					srvRerrorRate = Float.parseFloat(parameters[29]);
					srvRerrorRateMin = searchMin(srvRerrorRateMin, srvRerrorRate);
					srvRerrorRateMax = searchMax(srvRerrorRateMax, srvRerrorRate);
					shortKddCup.setSrvRerrorRate(srvRerrorRate);

					dstHostCount = Float.parseFloat(parameters[31]);
					dstHostCountMin = searchMin(dstHostCountMin, dstHostCount);
					dstHostCountMax = searchMax(dstHostCountMax, dstHostCount);
					shortKddCup.setDstHostCount(dstHostCount);

					dstHostSameSrvRate = Float.parseFloat(parameters[33]);
					dstHostSameSrvRateMin = searchMin(dstHostSameSrvRateMin, dstHostSameSrvRate);
					dstHostSameSrvRateMax = searchMax(dstHostSameSrvRateMax, dstHostSameSrvRate);
					shortKddCup.setDstHostSameSrvRate(dstHostSameSrvRate);

					dstHostDiffSrvRate = Float.parseFloat(parameters[34]);
					dstHostDiffSrvRateMin = searchMin(dstHostDiffSrvRateMin, dstHostDiffSrvRate);
					dstHostDiffSrvRateMax = searchMax(dstHostDiffSrvRateMax, dstHostDiffSrvRate);
					shortKddCup.setDstHostDiffSrvRate(dstHostDiffSrvRate);

					String label = parameters[41].replace(".", "");
					attack.add(label);
					if (labels.contains(label)) {
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
		for (String ob : attack) {
			System.out.println(ob);
		}
		System.out.println("Min: " + countMin + ", Max: " + countMax);
		System.out.println("Min: " + srvSerrorRateMin + ", Max: " + srvSerrorRateMax);
		System.out.println("Min: " + srvRerrorRateMin + ", Max: " + srvRerrorRateMax);
		System.out.println("Min: " + dstHostCountMin + ", Max: " + dstHostCountMax);
		System.out.println("Min: " + dstHostSameSrvRateMin + ", Max: " + dstHostSameSrvRateMax);
		System.out.println("Min: " + dstHostDiffSrvRateMin + ", Max: " + dstHostDiffSrvRateMax);

		for (ShortKddCupObject ob : shortKddCups) {
			KddCupObject temp = new KddCupObject();
			temp.setX3(Integer.parseInt(ob.getService()));
			temp.setX23(fetchUniNumber(countMin, countMax, GeneralConstant.NUMBER_OF_RANGES, ob.getCount()));
			temp.setX29(fetchUniNumber(srvSerrorRateMin, srvSerrorRateMax, GeneralConstant.NUMBER_OF_RANGES, ob.getSrvSerrorRate()));
			temp.setX30(fetchUniNumber(srvRerrorRateMin, srvRerrorRateMax, GeneralConstant.NUMBER_OF_RANGES, ob.getSrvRerrorRate()));
			temp.setX32(fetchUniNumber(dstHostCountMin, dstHostCountMax, GeneralConstant.NUMBER_OF_RANGES, ob.getDstHostCount()));
			temp.setX34(fetchUniNumber(dstHostSameSrvRateMin, dstHostSameSrvRateMax, GeneralConstant.NUMBER_OF_RANGES, ob.getDstHostSameSrvRate()));
			temp.setX35(fetchUniNumber(dstHostDiffSrvRateMin, dstHostDiffSrvRateMax, GeneralConstant.NUMBER_OF_RANGES, ob.getDstHostDiffSrvRate()));
			temp.setX42(Integer.parseInt(ob.getAttack()));
			kddCups.add(temp);
		}
		FileWriter writer = null;
		try {
			writer = new FileWriter(GeneralConstant.INPUT_KDD_CUP_10_PERCENT_8_PARAMESTER);
			for (KddCupObject ob : kddCups) {
				rules.add(ob.toRule());
				writer.write(ob.toString() + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
		// System.out.println("Size rule: " + rules.size());
		try {
			writer = new FileWriter(GeneralConstant.INPUT_KDD_CUP_10_PERCENT_RULE);
			for (String rule : rules) {
				System.out.println(rule);
				writer.write(rule + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
		System.out.println("Size rule: " + rules.size());
	}

	public static float searchMin(float min, float value) {
		if (min > value) {
			min = value;
		}
		return min;
	}

	public static float searchMax(float max, float value) {
		if (value > max) {
			max = value;
		}
		return max;
	}

	public static int fetchUniNumber(float min, float max, int number_of_ranges, float value) {
		float total_length = max - min;
		float subrange_length = total_length / number_of_ranges;
		int result = 0;
		float start = min;
		for (int i = 0; i < number_of_ranges; ++i) {
			float end = start + subrange_length;
			// System.out.println("Smaller range: [" + start + ", " + end +
			// "]");
			if (value >= start && value < end) {
				result = i;
			}
			start += subrange_length;
		}
		// System.out.println(value + ", " + result);
		return result;
	}
}
