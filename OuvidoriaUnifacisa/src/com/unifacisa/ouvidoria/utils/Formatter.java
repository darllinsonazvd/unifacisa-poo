package com.unifacisa.ouvidoria.utils;

import java.util.*;

import com.unifacisa.ouvidoria.utils.StringAlignUtils.Alignment;

public class Formatter {
	
	String separator = System.lineSeparator();
	
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
			System.out.println(i + 1 + ") " + options.get(i));
		}
	}
}
