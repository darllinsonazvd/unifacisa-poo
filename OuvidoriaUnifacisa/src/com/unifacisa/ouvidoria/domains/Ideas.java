package com.unifacisa.ouvidoria.domains;

import java.util.*;

import com.unifacisa.ouvidoria.database.FeedbackDAO;
import com.unifacisa.ouvidoria.gateway.Feedback;
import com.unifacisa.ouvidoria.utils.Formatter;
import com.unifacisa.ouvidoria.utils.StringAlignUtils;
import com.unifacisa.ouvidoria.utils.StringAlignUtils.Alignment;
import com.unifacisa.ouvidoria.utils.Validator;

public class Ideas {

	Formatter formatter = new Formatter();
	Validator validator = new Validator();

	public ArrayList<String> ideas;
	public ArrayList<Integer> idsOfIdeas;

	public Ideas() {
	}

	/**
	 * @apiNote Recuperar ideias do banco de dados
	 *
	 * @author Darllinson Azevedo
	 */
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
				
				System.out.println(
					count + 1 + " | " +
					typeOfFeedback + " | " +
					authorOfFeedback + " | " +
					feedbackDescription
				);
			}

			if (this.ideas.isEmpty()) {
				StringAlignUtils textCenter = new StringAlignUtils(100, Alignment.CENTER);
				System.out.println(textCenter.format("Nao ha elogios para exibir!"));
			}
		} catch (Exception err) {
			System.out.println("Feedback on getFeedbacks: " + err.getMessage());
		}
	}

	/**
	 * @apiNote Excluir uma ideia no banco de dados
	 *
	 * @author Darllinson Azevedo
	 *
	 * @param id Id do elogio
	 */
	public void deleteIdea(int id) {
		if (id == 0 || id > this.ideas.size()) {
			formatter.errorEmitter("Ideia nao encontrada!");
		} else {
			int selectedId = this.idsOfIdeas.get(id - 1);
			
			FeedbackDAO fbDAO = new FeedbackDAO();
			fbDAO.deleteFeedback(selectedId);
		}
	}

	/**
	 * @apiNote Editar uma ideia no banco de dados
	 *
	 * @author Darllinson Azevedo
	 *
	 * @param id Id do elogio
	 */
	public void setIdea(int id) {
		if (id == 0 || id > this.ideas.size()) {
			formatter.errorEmitter("Ideia nao encontrada!");
		} else {
			String newIdea = validator.readString("\nDigite sua nova ideia:\n");
			int selectedId = this.idsOfIdeas.get(id - 1);
			
			FeedbackDAO fbDAO = new FeedbackDAO();
			fbDAO.editFeedback(selectedId, newIdea);
		}
	}
}
