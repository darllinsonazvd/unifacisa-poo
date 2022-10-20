package com.unifacisa.ouvidoria.utils;

import java.util.*;

import com.unifacisa.ouvidoria.utils.StringAlignUtils.Alignment;

public class Formatter {
	
	public Formatter() {
	}

	public void line(int size) {
		System.out.println("=".repeat(size));
	}

	public void header(String text, int sizeOfLine) {
		StringAlignUtils textCenter = new StringAlignUtils(sizeOfLine, Alignment.CENTER);

		System.out.println("\n" + "-".repeat(sizeOfLine));
		System.out.print(textCenter.format(text));
		System.out.print("-".repeat(sizeOfLine) + "\n");
	}

	public void menu(String title, List<String> options) {
		System.out.println("\n" + title + "\n");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + ") " + options.get(i));
		}
	}
}
