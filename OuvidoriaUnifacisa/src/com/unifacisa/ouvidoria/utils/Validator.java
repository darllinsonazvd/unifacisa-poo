package com.unifacisa.ouvidoria.utils;

import java.util.*;

public class Validator {
	String separator = System.lineSeparator();
	
	Scanner textInput = new Scanner(System.in);
	Scanner numberInput = new Scanner(System.in);

	public Validator() {
	}

	public int readInt() {
		while (true) {
			String number = numberInput.nextLine();
			
			if (number.matches("[0-9]+")) {
				int validNumber = Integer.parseInt(number);
				return validNumber;
			} else {
				System.out.println(separator + "Erro: Insira um numero inteiro!" + separator);
			}
		}

	}

	public String readString() {
		while (true) {
			String text = textInput.nextLine();

			if (text == "") {
				System.out.println(separator + "Erro: Texto vazio, digite algo!" + separator);
			} else {
				return text;
			}
		}
	}
}
