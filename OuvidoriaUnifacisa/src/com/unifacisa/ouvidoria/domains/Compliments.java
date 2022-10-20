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
		if (compliment == "") {
			System.out.println("Nao foi possivel adicionar a reclamacao!");
		} else {
			this.compliments.add(compliment);
			System.out.println("\nElogio adicionado com sucesso!");
		}
	}

	public void deleteCompliment(int id) {
		if (id == 0 || id > this.compliments.size()) {
			System.out.println("\nElogio nao encontrado!");
		} else {
			this.compliments.remove(id - 1);
			System.out.println("\nElogio removido com sucesso!");
		}
	}

	public void setCompliment(int id) {
		if (id == 0 || id > compliments.size()) {
			System.out.println("\nElogio nao encontrado!\n");
		} else {
			System.out.println("\nDigite seu novo elogio:");
			String newCompliment = validator.readString();

			compliments.set(id - 1, newCompliment);
			System.out.println("\nElogio editado com sucesso!");
		}
	}
}
