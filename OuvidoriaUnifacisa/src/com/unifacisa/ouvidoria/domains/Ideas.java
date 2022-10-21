package com.unifacisa.ouvidoria.domains;

import java.util.*;

import com.unifacisa.ouvidoria.utils.Formatter;
import com.unifacisa.ouvidoria.utils.Validator;

public class Ideas {

	Formatter formatter = new Formatter();
	Validator validator = new Validator();

	public ArrayList<String> ideas;

	public Ideas() {
		this.ideas = new ArrayList<String>();
	}

	public void getIdeas() {
		formatter.header("Ideias", 100);

		if (this.ideas.size() == 0) {
			System.out.println("\nNao ha ideias!");
		} else {
			for (int i = 0; i < this.ideas.size(); i++) {
				System.out.println(i + 1 + " | " + this.ideas.get(i));
			}
		}
	}

	public void addIdea(String idea) {
		this.ideas.add(idea);
		formatter.successEmitter("Ideia adicionada com sucesso!");
	}

	public void deleteIdea(int id) {
		if (id == 0 || id > this.ideas.size()) {
			formatter.errorEmitter("Ideia nao encontrada!");
		} else {
			this.ideas.remove(id - 1);
			formatter.successEmitter("Ideia removida com sucesso!");
		}
	}

	public void setIdea(int id) {
		if (id == 0 || id > ideas.size()) {
			formatter.errorEmitter("Ideia nao encontrada!");
		} else {
			System.out.println("\nDigite sua nova ideia:");
			String newIdea = validator.readString();

			ideas.set(id - 1, newIdea);
			formatter.successEmitter("Ideia editada com sucesso!");
		}
	}
}
