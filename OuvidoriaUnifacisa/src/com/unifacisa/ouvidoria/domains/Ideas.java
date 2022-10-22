package com.unifacisa.ouvidoria.domains;

import java.util.*;

import com.unifacisa.ouvidoria.database.FeedbackDAO;
import com.unifacisa.ouvidoria.gateway.Feedback;
import com.unifacisa.ouvidoria.utils.Formatter;
import com.unifacisa.ouvidoria.utils.Validator;

public class Ideas {

	Formatter formatter = new Formatter();
	Validator validator = new Validator();

	public ArrayList<String> ideas;
	public ArrayList<Integer> idsOfIdeas;

	public Ideas() {
	}

	public void getIdeas() {
		this.ideas = new ArrayList<String>();
		this.idsOfIdeas = new ArrayList<Integer>();
		
		formatter.header("Ideias", 100);

		try {
			FeedbackDAO fbDAO = new FeedbackDAO();
			ArrayList<Feedback> listOfFeedbacks = fbDAO.getFeedbacks("Ideia");
			
			for (int count = 0; count < listOfFeedbacks.size(); count++) {
				int idOfFeedback = listOfFeedbacks.get(count).getId();
				String typeOfFeedback = listOfFeedbacks.get(count).getType();
				String authorOfFeedback = listOfFeedbacks.get(count).getAuthor();
				String feedbackDescription = listOfFeedbacks.get(count).getFeedback();
				
				this.ideas.add(feedbackDescription);
				this.idsOfIdeas.add(idOfFeedback);
				
				if (this.ideas.size() == 0) {
					System.out.println("\nNao ha ideias!");
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
			String newIdea = validator.readString("\nDigite sua nova ideia:\n");

			ideas.set(id - 1, newIdea);
			formatter.successEmitter("Ideia editada com sucesso!");
		}
	}
}
