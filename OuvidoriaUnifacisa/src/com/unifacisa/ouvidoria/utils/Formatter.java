package com.unifacisa.ouvidoria.utils;

import java.util.*;

import com.unifacisa.ouvidoria.utils.StringAlignUtils.Alignment;

public class Formatter {

	String separator = System.lineSeparator();

	String ANSI_RED = "\u001B[31m";
	String ANSI_GREEN = "\u001B[32m";
	String ANSI_YELLOW = "\u001B[33m";
	String ANSI_BLUE = "\u001B[36m";
	String ANSI_RESET = "\u001B[0m";

	public Formatter() {
	}

	public void line(int size) {
		System.out.println("=".repeat(size));
	}

	public void header(String text, int sizeOfLine) {
		StringAlignUtils textCenter = new StringAlignUtils(sizeOfLine, Alignment.CENTER);

		System.out.println(separator + "-".repeat(sizeOfLine));
		System.out.print(textCenter.format(text));
		System.out.print("-".repeat(sizeOfLine) + separator);
	}

	public void menu(String title, List<String> options) {
		System.out.println(separator + title + separator);
		for (int i = 0; i < options.size(); i++) {
			System.out.println(String.format("%s%d)%s %s%s%s", ANSI_YELLOW, i + 1, ANSI_RESET, ANSI_BLUE,
					options.get(i), ANSI_RESET));
		}
	}

	public void errorEmitter(String msg) {
		System.out.println(String.format("%s%s%s%s%s", separator, ANSI_RED, msg, ANSI_RESET, separator));
	}

	public void successEmitter(String msg) {
		System.out.println(String.format("%s%s%s%s%s", separator, ANSI_GREEN, msg, ANSI_RESET, separator));
	}
}
