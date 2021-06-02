package br.com.codenation.desafioexe;

import java.util.ArrayList;
import java.util.List;

public class DesafioApplication {

	public static List<Integer> fibonacci() {
		ArrayList<Integer> list = new ArrayList();
		int previousNumber = 0;
		int nextNumber = 1;
		list.add(previousNumber);
		while(previousNumber < 350) {
			nextNumber = previousNumber + nextNumber;
			previousNumber = nextNumber - previousNumber;
			list.add(previousNumber);
		}
		return list;
	}

	public static Boolean isFibonacci(Integer a) {
		return fibonacci().contains(a);
	}

}