package com.unifacisa.ouvidoria;

import java.util.*;

import com.unifacisa.ouvidoria.domains.Claims;
import com.unifacisa.ouvidoria.domains.Compliments;
import com.unifacisa.ouvidoria.domains.Ideas;
import com.unifacisa.ouvidoria.utils.Formatter;
import com.unifacisa.ouvidoria.utils.Validator;

public class Main {

	public static void main(String[] args) {

		Formatter formatter = new Formatter();
		Validator validator = new Validator();

		Claims claims = new Claims();
		Compliments compliments = new Compliments();
		Ideas ideas = new Ideas();
		
		String[] options = { "Listar feedbacks", "Adicionar feedback", "Remover feedback", "Editar feedback", "Sair\n" };
		List<String> optionsList = Arrays.asList(options);
		
		String[] categories = { "Reclamacao", "Elogio", "Ideia" };
		List<String> categoriesList = Arrays.asList(categories);
		
		boolean running = true;
		
		formatter.header("Bem-vindo ao Sistema de Ouvidoria da Unifacisa!", 100);
		
		System.out.print("\nDigite seu nome: ");
		String name = validator.readString();
		formatter.header("Bem-vindo " + name.substring(0, 1).toUpperCase() + name.substring(1) + "!", 100);

		while (running) {
			formatter.line(100);
			formatter.menu("Selecione uma opcao:", optionsList);
			formatter.line(100);

			System.out.print("\nOpcao: ");
			int option = validator.readInt();

			if (option == 1) {
				claims.getClaims();
				compliments.getCompliments();
				ideas.getIdeas();
			} else if (option == 2) {
				formatter.menu("Categorias:", categoriesList);

				System.out.print("\nQual categoria deseja listar? (1 / 2 / 3): ");
				int optionToAdd = validator.readInt();

				if (optionToAdd == 1) {
					System.out.println("\nDigite sua reclamacao:");
					String claim = validator.readString();
					claims.addClaim(claim);
				} else if (optionToAdd == 2) {
					System.out.println("\nDigite seu elogio:");
					String compliment = validator.readString();
					compliments.addCompliment(compliment);
				} else if (optionToAdd == 3) {
					System.out.println("\nDigite sua ideia:");
					String idea = validator.readString();
					ideas.addIdea(idea);
				} else {
					System.out.println("\nOpcao invalida!\n");
				}
			} else if (option == 3) {
				formatter.menu("Categorias:", categoriesList);

				System.out.print("\nQual a categoria do feedback deseja remover? (1 / 2 / 3): ");
				int optionToRemove = validator.readInt();

				if (optionToRemove == 1) {
					System.out.println("\nQual reclamacao deseja remover?\n");
					claims.getClaims();

					System.out.print("\nNumero da reclamacao: ");
					int claimId = validator.readInt();

					claims.deleteClaim(claimId);
				} else if (optionToRemove == 2) {
					System.out.println("\nQual elogio deseja remover?\n");
					compliments.getCompliments();

					System.out.print("\nNumero do elogio: ");
					int complimentId = validator.readInt();

					compliments.deleteCompliment(complimentId);
				} else if (optionToRemove == 3) {
					System.out.println("\nQual ideia deseja remover?\n");
					ideas.getIdeas();

					System.out.print("\nNumero da ideia: ");
					int ideaId = validator.readInt();

					ideas.deleteIdea(ideaId);
				} else {
					System.out.println("\nOpcao invalida!\n");
				}
			} else if (option == 4) {
				formatter.menu("Categorias:", categoriesList);

				System.out.print("\nQual a categoria do feedback deseja editar? (1 / 2 / 3): ");
				int optionToEdit = validator.readInt();

				if (optionToEdit == 1) {
					System.out.println("\nQual reclamacao deseja editar?\n");
					claims.getClaims();

					System.out.print("\nNumero da reclamacao: ");
					int claimId = validator.readInt();

					claims.setClaim(claimId);
				} else if (optionToEdit == 2) {
					System.out.println("\nQual elogio deseja editar?\n");
					compliments.getCompliments();

					System.out.print("\nNumero do elogio: ");
					int compId = validator.readInt();

					compliments.setCompliment(compId);
				} else if (optionToEdit == 3) {
					System.out.println("\nQual ideia deseja editar?\n");
					ideas.getIdeas();

					System.out.print("\nNumero da ideia: ");
					int ideaId = validator.readInt();

					ideas.setIdea(ideaId);
				} else {
					System.out.println("\nOpcao invalida!\n");
				}
			} else if (option == 5) {
				formatter.header("Obrigado por utilizar o Sistema de Ouvidoria da Unifacisa!", 100);

				running = false;
			} else {
				System.out.println("\nOpcao invalida!\n");
			}
		}
	}
}
