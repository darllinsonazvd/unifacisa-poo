package com.unifacisa.ouvidoria.gateway;

import com.unifacisa.ouvidoria.domains.Claims;
import com.unifacisa.ouvidoria.domains.Compliments;
import com.unifacisa.ouvidoria.domains.Ideas;

import com.unifacisa.ouvidoria.database.FeedbackDAO;

public class Feedback {
	Claims claims = new Claims();
	Compliments compliments = new Compliments();
	Ideas ideas = new Ideas();
	
	int id;
	String author;
	String type;
	String feedback;

	public Feedback() {
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	/**
	 * @apiNote Recuperar feedbacks do banco de dados
	 *
	 * @author Darllinson Azevedo
	 *
	 * @param type Tipo do feedback
	 */
	public void getFeedbacks(String type) {
		switch (type) {
			case "Reclamacao" -> claims.getClaims();
			case "Elogio" -> compliments.getCompliments();
			case "Ideia" -> ideas.getIdeas();
			case "All" -> {
				claims.getClaims();
				compliments.getCompliments();
				ideas.getIdeas();
			}
		}
	}

	/**
	 * @apiNote Enviar feedback
	 *
	 * @author Darllinson Azevedo
	 */
	public void sendFeedback() {
		FeedbackDAO fbDAO = new FeedbackDAO();
		fbDAO.addFeedback(this.type, this.author, this.feedback);
	}

	/**
	 * @apiNote Excluir feedback
	 *
	 * @author Darllinson Azevedo
	 *
	 * @param id Id do feedback
	 */
	public void deleteFeedback(int id) {
		switch (this.type) {
			case "Reclamacao" -> claims.deleteClaim(id);
			case "Elogio" -> compliments.deleteCompliment(id);
			case "Ideia" -> ideas.deleteIdea(id);
		}
	}

	/**
	 * @apiNote Editar feedback
	 *
	 * @author Darllinson Azevedo
	 *
	 * @param id Id do feedback
	 */
	public void editFeedback(int id) {
		switch (this.type) {
			case "Reclamacao" -> claims.setClaim(id);
			case "Elogio" -> compliments.setCompliment(id);
			case "Ideia" -> ideas.setIdea(id);
		}
	}
}
