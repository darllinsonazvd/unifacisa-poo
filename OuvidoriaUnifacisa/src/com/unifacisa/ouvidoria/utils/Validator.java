package com.unifacisa.ouvidoria.utils;

import java.util.*;

public class Validator {
	Scanner textInput = new Scanner(System.in);
	Scanner numberInput = new Scanner(System.in);

	public Validator() {
	}

	public int readInt() {
		String number = numberInput.nextLine();

		if (!number.matches("[0-9]+")) {
			System.out.println("\nErro: Insira um numero inteiro!\n");
		} else {
			int validNumber = Integer.parseInt(number);
			return validNumber;
		}
		return 0;
	}

	public String readString() {
		while (true) {
			String text = textInput.nextLine();

			if (text == "") {
				System.out.println("\nErro: Texto vazio, digite algo!\n");
			} else {
				return text;
			}
		}
	}
}
