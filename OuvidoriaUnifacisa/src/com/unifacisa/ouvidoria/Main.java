package com.unifacisa.ouvidoria;

import java.util.Arrays;
import java.util.List;

import com.unifacisa.ouvidoria.gateway.Feedback;
import com.unifacisa.ouvidoria.utils.Formatter;
import com.unifacisa.ouvidoria.utils.Validator;

public class Main {

	public static void main(String[] args) {

		String name;
		String feedback;
		
		Formatter formatter = new Formatter();
		Validator validator = new Validator();
		
		Feedback fb = new Feedback();
		
		final String[] OPTIONS = {
			"Listar feedbacks",
			"Adicionar feedback",
			"Remover feedback",
			"Editar feedback",
			"Sair\n"
		};
		final List<String> OPTIONS_LIST = Arrays.asList(OPTIONS);
		
		final String[] CATEGORIES = { "Reclamacao", "Elogio", "Ideia" };
		final List<String> CATEGORIES_LIST = Arrays.asList(CATEGORIES);
		
		boolean running = true;
		
		formatter.header("Bem-vindo ao Sistema de Ouvidoria da Unifacisa!", 100);
		
		name = validator.readString("\nDigite seu nome: ");
		String capitalizedName = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
		formatter.header("Bem-vindo(a) " + capitalizedName, 100);
		fb.setAuthor(capitalizedName);
		
		while (running) {
			formatter.line(100);
			formatter.menu("Selecione uma opcao:", OPTIONS_LIST);
			formatter.line(100);

			int option = validator.readInt("\nOpcao: ");

			if (option == 1) {
				fb.getFeedbacks("All");
			} else if (option == 2) {
				formatter.menu("Categorias:", CATEGORIES_LIST);

				int optionToAdd = validator.readInt("\nQual a categoria do feedback deseja adicionar? (1 / 2 / 3): ");

				switch (optionToAdd) {
					case 1 -> {
						feedback = validator.readString("\nDigite sua reclamacao:\n");
						fb.setType("Reclamacao");
						fb.setFeedback(feedback);
						fb.sendFeedback();
					}
					case 2 -> {
						feedback = validator.readString("\nDigite seu elogio:\n");
						fb.setType("Elogio");
						fb.setFeedback(feedback);
						fb.sendFeedback();
					}
					case 3 -> {
						feedback = validator.readString("\nDigite sua ideia:\n");
						fb.setType("Ideia");
						fb.setFeedback(feedback);
						fb.sendFeedback();
					}
					default -> formatter.errorEmitter("Categoria invalida!");
				}
			} else if (option == 3) {
				formatter.menu("Categorias:", CATEGORIES_LIST);

				int optionToRemove = validator.readInt("\nQual a categoria do feedback deseja remover? (1 / 2 / 3): ");

				switch (optionToRemove) {
					case 1 -> {
						System.out.println("\nQual reclamacao deseja remover?\n");
						fb.getFeedbacks("Reclamacao");
						int claimId = validator.readInt("\nNumero da reclamacao: ");
						fb.setType("Reclamacao");
						fb.deleteFeedback(claimId);
					}
					case 2 -> {
						System.out.println("\nQual elogio deseja remover?\n");
						fb.getFeedbacks("Elogio");
						int complimentId = validator.readInt("\nNumero do elogio: ");
						fb.setType("Elogio");
						fb.deleteFeedback(complimentId);
					}
					case 3 -> {
						System.out.println("\nQual ideia deseja remover?\n");
						fb.getFeedbacks("Ideia");
						int ideaId = validator.readInt("\nNumero da ideia: ");
						fb.setType("Ideia");
						fb.deleteFeedback(ideaId);
					}
					default -> formatter.errorEmitter("Categoria invalida!");
				}
			} else if (option == 4) {
				formatter.menu("Categorias:", CATEGORIES_LIST);

				int optionToEdit = validator.readInt("\nQual a categoria do feedback deseja editar? (1 / 2 / 3): ");

				switch (optionToEdit) {
					case 1 -> {
						System.out.println("\nQual reclamacao deseja editar?\n");
						fb.getFeedbacks("Reclamacao");
						int claimId = validator.readInt("\nNumero da reclamacao: ");
						fb.setType("Reclamacao");
						fb.editFeedback(claimId);
					}
					case 2 -> {
						System.out.println("\nQual elogio deseja editar?\n");
						fb.getFeedbacks("Elogio");
						int compId = validator.readInt("\nNumero do elogio: ");
						fb.setType("Elogio");
						fb.editFeedback(compId);
					}
					case 3 -> {
						System.out.println("\nQual ideia deseja editar?\n");
						fb.getFeedbacks("Ideia");
						int ideaId = validator.readInt("\nNumero da ideia: ");
						fb.setType("Ideia");
						fb.editFeedback(ideaId);
					}
					default -> formatter.errorEmitter("Categoria invalida!");
				}
			} else if (option == 5) {
				formatter.header("Obrigado por utilizar o Sistema de Ouvidoria da Unifacisa!", 100);
				running = false;
			} else {
				formatter.errorEmitter("Opcao invalida!");
			}
		}
	}
}
