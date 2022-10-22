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

	public void getFeedbacks(String type) {
		switch (type) {
			case "Reclamacao":
				claims.getClaims();
				break;
			case "Elogio":
				compliments.getCompliments();
				break;
			case "Ideia":
				ideas.getIdeas();
				break;
			case "All":
				claims.getClaims();
				compliments.getCompliments();
				ideas.getIdeas();
				break;
		}
	}

	public void sendFeedback() {
		FeedbackDAO fbDAO = new FeedbackDAO();
		fbDAO.addFeedback(this.type, this.author, this.feedback);
	}

	public void deleteFeedback(int id) {
		switch (this.type) {
			case "Reclamacao":
				claims.deleteClaim(id);
				break;
			case "Elogio":
				compliments.deleteCompliment(id);
				break;
			case "Ideia":
				ideas.deleteIdea(id);
				break;
		}
	}

	public void editFeedback(int id) {
		switch (this.type) {
			case "Reclamacao":
				claims.setClaim(id);
				break;
			case "Elogio":
				compliments.setCompliment(id);
				break;
			case "Ideia":
				ideas.setIdea(id);
				break;
		}
	}
}
