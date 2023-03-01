package com.unifacisa.ouvidoria.utils;

import java.util.*;

import com.unifacisa.ouvidoria.utils.StringAlignUtils.Alignment;

/**
 * @apiNote Classe com utilitários para formatação de dados
 *
 * @author Darllinson Azevedo
 */
public class Formatter {

	String separator = System.lineSeparator();

	String ANSI_RED = "\u001B[31m";
	String ANSI_GREEN = "\u001B[32m";
	String ANSI_YELLOW = "\u001B[33m";
	String ANSI_BLUE = "\u001B[36m";
	String ANSI_RESET = "\u001B[0m";

	public Formatter() {
	}

	/**
	 * @apiNote Imprimir linha
	 *
	 * @author Darllinson Azevedo
	 *
	 * @param size Tamanho da linha
	 */
	public void line(int size) {
		System.out.println("=".repeat(size));
	}

	/**
	 * @apiNote Imprimir cabeçalho
	 *
	 * @author Darllinson Azevedo
	 *
	 * @param text Título do cabeçalho
	 * @param sizeOfLine Tamanho da linha separadora
	 */
	public void header(String text, int sizeOfLine) {
		StringAlignUtils textCenter = new StringAlignUtils(sizeOfLine, Alignment.CENTER);

		System.out.println(separator + "-".repeat(sizeOfLine));
		System.out.print(textCenter.format(text));
		System.out.print("-".repeat(sizeOfLine) + separator);
	}

	/**
	 * @apiNote Imprimir menu
	 *
	 * @author Darllinson Azevedo
	 *
	 * @param title Título do menu
	 * @param options Lista de opções do menu
	 */
	public void menu(String title, List<String> options) {
		System.out.println(separator + title + separator);
		for (int i = 0; i < options.size(); i++) {
			System.out.println(String.format("%s%d)%s %s%s%s", ANSI_YELLOW, i + 1, ANSI_RESET, ANSI_BLUE,
					options.get(i), ANSI_RESET));
		}
	}

	/**
	 * @apiNote Emitir mensagem de erro
	 *
	 * @author Darllinson Azevedo
	 *
	 * @param msg Mensagem
	 */
	public void errorEmitter(String msg) {
		System.out.println(String.format("%s%s%s%s%s", separator, ANSI_RED, msg, ANSI_RESET, separator));
	}

	/**
	 * @apiNote Emitir mensagem de sucesso
	 *
	 * @author Darllinson Azevedo
	 *
	 * @param msg Mensagem
	 */
	public void successEmitter(String msg) {
		System.out.println(String.format("%s%s%s%s%s", separator, ANSI_GREEN, msg, ANSI_RESET, separator));
	}
}
