package com.unifacisa.ouvidoria.domains;

import java.util.*;

import com.unifacisa.ouvidoria.utils.Formatter;
import com.unifacisa.ouvidoria.utils.Validator;

public class Compliments {

	Formatter formatter = new Formatter();
	Validator validator = new Validator();

	public ArrayList<String> compliments;

	public Compliments() {
		this.compliments = new ArrayList<String>();
	}

	public void getCompliments() {
		formatter.header("Elogios", 100);

		if (this.compliments.size() == 0) {
			System.out.println("\nNao ha elogios!");
		} else {
			for (int i = 0; i < this.compliments.size(); i++) {
				System.out.println(i + 1 + " | " + this.compliments.get(i));
			}
		}
	}

	public void addCompliment(String compliment) {
		this.compliments.add(compliment);
		formatter.successEmitter("Elogio adicionado com sucesso!");
	}

	public void deleteCompliment(int id) {
		if (id == 0 || id > this.compliments.size()) {
			formatter.errorEmitter("Elogio nao encontrado!");
		} else {
			this.compliments.remove(id - 1);
			formatter.successEmitter("Elogio removido com sucesso!");
		}
	}

	public void setCompliment(int id) {
		if (id == 0 || id > compliments.size()) {
			formatter.errorEmitter("Elogio nao encontrado!");
		} else {
			System.out.println();
			String newCompliment = validator.readString("\nDigite seu novo elogio:\n");

			compliments.set(id - 1, newCompliment);
			formatter.successEmitter("Elogio editado com sucesso!");
		}
	}
}
