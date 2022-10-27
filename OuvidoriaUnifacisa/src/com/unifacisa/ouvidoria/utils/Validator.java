package com.unifacisa.ouvidoria.utils;

import java.util.*;

public class Validator {
	Formatter formatter = new Formatter();

	String separator = System.lineSeparator();

	Scanner textInput = new Scanner(System.in);
	Scanner numberInput = new Scanner(System.in);

	public Validator() {
	}

	public int readInt(String placeholder) {
		while (true) {
			System.out.print(placeholder);
			String number = numberInput.nextLine();

			if (number.matches("[0-9]+")) {
				int validNumber = Integer.parseInt(number);
				return validNumber;
			} else {
				formatter.errorEmitter("Erro: Insira um numero inteiro!");
			}
		}
	}

	public String readString(String placeholder) {
		while (true) {
			System.out.print(placeholder);
			String text = textInput.nextLine();

			if (text == "") {
				formatter.errorEmitter("Erro: Texto vazio, digite algo!");
			} else {
				return text;
			}
		}
	}
}
