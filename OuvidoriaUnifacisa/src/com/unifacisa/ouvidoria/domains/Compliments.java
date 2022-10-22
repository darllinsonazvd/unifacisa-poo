package com.unifacisa.ouvidoria.domains;

import java.util.*;

import com.unifacisa.ouvidoria.database.FeedbackDAO;
import com.unifacisa.ouvidoria.gateway.Feedback;
import com.unifacisa.ouvidoria.utils.Formatter;
import com.unifacisa.ouvidoria.utils.Validator;

public class Compliments {

	Formatter formatter = new Formatter();
	Validator validator = new Validator();

	public ArrayList<String> compliments;
	public ArrayList<Integer> idsOfCompliments;

	public Compliments() {
	}

	public void getCompliments() {
		this.compliments = new ArrayList<String>();
		this.idsOfCompliments = new ArrayList<Integer>();
		
		formatter.header("Elogios", 100);

		try {
			FeedbackDAO fbDAO = new FeedbackDAO();
			ArrayList<Feedback> listOfFeedbacks = fbDAO.getFeedbacks("Elogio");
			
			for (int count = 0; count < listOfFeedbacks.size(); count++) {
				int idOfFeedback = listOfFeedbacks.get(count).getId();
				String typeOfFeedback = listOfFeedbacks.get(count).getType();
				String authorOfFeedback = listOfFeedbacks.get(count).getAuthor();
				String feedbackDescription = listOfFeedbacks.get(count).getFeedback();
				
				this.compliments.add(feedbackDescription);
				this.idsOfCompliments.add(idOfFeedback);
				
				if (this.compliments.size() == 0) {
					System.out.println("\nNao ha elogios!");
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
