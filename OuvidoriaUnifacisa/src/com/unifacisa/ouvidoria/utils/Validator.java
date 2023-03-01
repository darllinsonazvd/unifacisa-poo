package com.unifacisa.ouvidoria.utils;

import java.util.*;

/**
 * @apiNote Classe com utilitários para validação de dados
 *
 * @author Darllinson Azevedo
 */
public class Validator {
	Formatter formatter = new Formatter();

	Scanner textInput = new Scanner(System.in);
	Scanner numberInput = new Scanner(System.in);

	public Validator() {
	}

	/**
	 * @apiNote Ler número
	 *
	 * @author Darllinson Azevedo
	 *
	 * @param placeholder Descreva o que é sua entrada
	 * @return Número inteiro, se a entrada não for um número retorna uma excessão
	 */
	public int readInt(String placeholder) {
		while (true) {
			System.out.print(placeholder);
			String number = numberInput.nextLine();

			if (number.matches("[0-9]+"))
				return Integer.parseInt(number);
			else
				formatter.errorEmitter("Erro: Insira um numero inteiro!");
		}
	}

	/**
	 * @apiNote Ler texto
	 *
	 * @author Darllinson Azevvedo
	 *
	 * @param placeholder Descreva o que é sua entrada
	 * @return Texto, se for vazio retorna uma excessão
	 */
	public String readString(String placeholder) {
		while (true) {
			System.out.print(placeholder);
			String text = textInput.nextLine();

			if (text.matches("(^\\s*$|^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.(?:[a-zA-Z]{2}|com|org|net|edu|gov|mil|biz|info|mobi|name|aero|asia|jobs|museum)$)"))
				formatter.errorEmitter("Erro: Texto vazio, digite algo!");
			else
				return text;
		}
	}
}
