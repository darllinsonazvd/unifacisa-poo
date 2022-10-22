package com.unifacisa.ouvidoria.domains;

import java.util.*;

import com.unifacisa.ouvidoria.database.FeedbackDAO;
import com.unifacisa.ouvidoria.gateway.Feedback;
import com.unifacisa.ouvidoria.utils.Formatter;
import com.unifacisa.ouvidoria.utils.Validator;

public class Claims {

	Formatter formatter = new Formatter();
	Validator validator = new Validator();

	public ArrayList<String> claims;
	public ArrayList<Integer> idsOfClaims;

	public Claims() {
	}

	public void getClaims() {
		this.claims = new ArrayList<String>();
		this.idsOfClaims = new ArrayList<Integer>();
		
		formatter.header("Reclamacoes", 100);
		
		try {
			FeedbackDAO fbDAO = new FeedbackDAO();
			ArrayList<Feedback> listOfFeedbacks = fbDAO.getFeedbacks("Reclamacao");
			
			for (int count = 0; count < listOfFeedbacks.size(); count++) {
				int idOfFeedback = listOfFeedbacks.get(count).getId();
				String typeOfFeedback = listOfFeedbacks.get(count).getType();
				String authorOfFeedback = listOfFeedbacks.get(count).getAuthor();
				String feedbackDescription = listOfFeedbacks.get(count).getFeedback();
				
				this.claims.add(feedbackDescription);
				this.idsOfClaims.add(idOfFeedback);
				
				if (this.claims.size() == 0) {
					System.out.println("\nNao ha reclamacoes!");
				} else {
					System.out.println(
						count + 1 + " | " +
						typeOfFeedback + " | " +
						authorOfFeedback + " | " +
						feedbackDescription
					);
				}
				
			}
		} catch (Exception err) {
			System.out.println("Feedback on getFeedbacks" + err.getMessage());
		}
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
			String newClaim = validator.readString("\nDigite sua nova reclamacao:\n");

			claims.set(id - 1, newClaim);
			formatter.successEmitter("Reclamacao editada com sucesso!");
		}
	}
}
