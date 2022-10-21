package com.unifacisa.ouvidoria;

import java.util.Arrays;
import java.util.List;

import com.unifacisa.ouvidoria.utils.Formatter;
import com.unifacisa.ouvidoria.utils.Validator;
import com.unifacisa.ouvidoria.gateway.Feedback;

public class Main {

	public static void main(String[] args) {

		String name = "";
		String type = "";
		String feedback = "";
		
		Formatter formatter = new Formatter();
		Validator validator = new Validator();
		
		Feedback fb = new Feedback(name, type, feedback);
		
		String[] options = {
			"Listar feedbacks",
			"Adicionar feedback",
			"Remover feedback",
			"Editar feedback",
			"Sair\n"
		};
		List<String> optionsList = Arrays.asList(options);
		
		String[] categories = { "Reclamacao", "Elogio", "Ideia" };
		List<String> categoriesList = Arrays.asList(categories);
		
		boolean running = true;
		
		formatter.header("Bem-vindo ao Sistema de Ouvidoria da Unifacisa!", 100);
		
		System.out.print("\nDigite seu nome: ");
		name = validator.readString();
		formatter.header("Bem-vindo " + name.substring(0, 1).toUpperCase() + name.substring(1) + "!", 100);
		
		while (running) {
			formatter.line(100);
			formatter.menu("Selecione uma opcao:", optionsList);
			formatter.line(100);

			System.out.print("\nOpcao: ");
			int option = validator.readInt();

			if (option == 1) {
				fb.setType("All");
				fb.getFeedbacks();
			} else if (option == 2) {
				formatter.menu("Categorias:", categoriesList);

				System.out.print("\nQual categoria deseja listar? (1 / 2 / 3): ");
				int optionToAdd = validator.readInt();

				if (optionToAdd == 1) {
					System.out.println("\nDigite sua reclamacao:");
					feedback = validator.readString();
					
					fb.setType("Reclamacao");
					fb.setFeedback(feedback);
					fb.sendFeedback();
				} else if (optionToAdd == 2) {
					System.out.println("\nDigite seu elogio:");
					feedback = validator.readString();
					
					fb.setType("Elogio");
					fb.setFeedback(feedback);
					fb.sendFeedback();
				} else if (optionToAdd == 3) {
					System.out.println("\nDigite sua ideia:");
					feedback = validator.readString();
					
					fb.setType("Ideia");
					fb.setFeedback(feedback);
					fb.sendFeedback();
				} else {
					System.out.println("\nOpcao invalida!\n");
				}
			} else if (option == 3) {
				formatter.menu("Categorias:", categoriesList);

				System.out.print("\nQual a categoria do feedback deseja remover? (1 / 2 / 3): ");
				int optionToRemove = validator.readInt();

				if (optionToRemove == 1) {
					System.out.println("\nQual reclamacao deseja remover?\n");
					fb.setType("Reclamacao");
					fb.getFeedbacks();

					System.out.print("\nNumero da reclamacao: ");
					int claimId = validator.readInt();

					fb.deleteFeedback(claimId);
				} else if (optionToRemove == 2) {
					System.out.println("\nQual elogio deseja remover?\n");
					fb.setType("Elogio");
					fb.getFeedbacks();

					System.out.print("\nNumero do elogio: ");
					int complimentId = validator.readInt();

					fb.deleteFeedback(complimentId);
				} else if (optionToRemove == 3) {
					System.out.println("\nQual ideia deseja remover?\n");
					fb.setType("Ideia");
					fb.getFeedbacks();

					System.out.print("\nNumero da ideia: ");
					int ideaId = validator.readInt();

					fb.deleteFeedback(ideaId);
				} else {
					System.out.println("\nOpcao invalida!\n");
				}
			} else if (option == 4) {
				formatter.menu("Categorias:", categoriesList);

				System.out.print("\nQual a categoria do feedback deseja editar? (1 / 2 / 3): ");
				int optionToEdit = validator.readInt();

				if (optionToEdit == 1) {
					System.out.println("\nQual reclamacao deseja editar?\n");
					fb.setType("Reclamacao");
					fb.getFeedbacks();

					System.out.print("\nNumero da reclamacao: ");
					int claimId = validator.readInt();

					fb.editFeedback(claimId);
				} else if (optionToEdit == 2) {
					System.out.println("\nQual elogio deseja editar?\n");
					fb.setType("Elogio");
					fb.getFeedbacks();

					System.out.print("\nNumero do elogio: ");
					int compId = validator.readInt();

					fb.editFeedback(compId);
				} else if (optionToEdit == 3) {
					System.out.println("\nQual ideia deseja editar?\n");
					fb.setType("Ideia");
					fb.getFeedbacks();

					System.out.print("\nNumero da ideia: ");
					int ideaId = validator.readInt();

					fb.editFeedback(ideaId);
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
