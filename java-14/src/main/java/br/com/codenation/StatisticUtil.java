package br.com.codenation;

import java.util.Arrays;

public class StatisticUtil {

	public static int average(int[] elements) {
		int sum = 0;
		for (int i = 0; i < elements.length; i++){
			sum += elements[i];
		}
		return sum / elements.length;
	}

	public static int mode(int[] elements) {
		int maxCount = 0;
		int modeValue = 0;
		for (int i = 0; i < elements.length; i++) {
			int count = 0;
			for (int j = 0; j < elements.length; j++) {
				if (elements[j] == elements[i]) {
					count ++;
				}
			}
			if (count > maxCount) {
				maxCount = count;
				modeValue = elements[i];
			}
		}
		return modeValue;
	}

	public static int median(int[] elements) {
		Arrays.sort(elements);
		int middle = elements.length / 2;
		if (elements.length % 2 == 1) {
			return elements[middle];
		} else {
			return (elements[middle - 1] + elements[middle]) / 2;
		}
	}
}