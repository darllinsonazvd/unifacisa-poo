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

	/**
	 * @apiNote Recuperar elogios do banco de dados
	 *
	 * @author Darllinson Azevedo
	 */
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
				
				System.out.println(
					count + 1 + " | " +
					typeOfFeedback + " | " +
					authorOfFeedback + " | " +
					feedbackDescription
				);
			}
		} catch (Exception err) {
			System.out.println("Feedback on getFeedbacks: " + err.getMessage());
		}
	}

	/**
	 * @apiNote Excluir um elogio no banco de dados
	 *
	 * @author Darllinson Azevedo
	 *
	 * @param id Id do elogio
	 */
	public void deleteCompliment(int id) {
		if (id == 0 || id > this.compliments.size()) {
			formatter.errorEmitter("Elogio nao encontrado!");
		} else {
			int selectedId = this.idsOfCompliments.get(id - 1);
			
			FeedbackDAO fbDAO = new FeedbackDAO();
			fbDAO.deleteFeedback(selectedId);
		}
	}

	/**
	 * @apiNote Editar um elogio no banco de dados
	 *
	 * @author Darllinson Azevedo
	 *
	 * @param id Id do elogio
	 */
	public void setCompliment(int id) {
		if (id == 0 || id > this.compliments.size()) {
			formatter.errorEmitter("Elogio nao encontrado!");
		} else {
			String newCompliment = validator.readString("\nDigite seu novo elogio:\n");
			int selectedId = this.idsOfCompliments.get(id - 1);
			
			FeedbackDAO fbDAO = new FeedbackDAO();
			fbDAO.editFeedback(selectedId, newCompliment);
		}
	}
}
