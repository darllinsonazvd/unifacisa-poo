package com.unifacisa.ouvidoria.domains;

import java.util.*;

import com.unifacisa.ouvidoria.utils.Formatter;
import com.unifacisa.ouvidoria.utils.Validator;

public class Claims {

	Formatter formatter = new Formatter();
	Validator validator = new Validator();

	public ArrayList<String> claims;

	public Claims() {
		this.claims = new ArrayList<String>();
	}

	public void getClaims() {
		formatter.header("Reclamacoes", 100);

		if (this.claims.size() == 0) {
			System.out.println("\nNao ha reclamacoes!");
		} else {
			for (int i = 0; i < this.claims.size(); i++) {
				System.out.println(i + 1 + " | " + this.claims.get(i));
			}
		}
	}

	public void addClaim(String claim) {
		this.claims.add(claim);
		formatter.successEmitter("Reclamacao adicionada com sucesso!");
	}

	public void deleteClaim(int id) {
		if (id == 0 || id > this.claims.size()) {
			formatter.errorEmitter("Reclamacao nao encontrada!");
		} else {
			this.claims.remove(id - 1);
			formatter.successEmitter("Reclamacao removida com sucesso!");
		}
	}

	public void setClaim(int id) {
		if (id == 0 || id > claims.size()) {
			formatter.errorEmitter("Reclamacao nao encontrada!");
		} else {
			System.out.println("\nDigite sua nova reclamacao:");
			String newClaim = validator.readString();

			claims.set(id - 1, newClaim);
			formatter.successEmitter("Reclamacao editada com sucesso!");
		}
	}
}
