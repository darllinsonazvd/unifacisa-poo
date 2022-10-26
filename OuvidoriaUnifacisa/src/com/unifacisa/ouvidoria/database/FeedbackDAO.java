package com.unifacisa.ouvidoria.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.unifacisa.ouvidoria.gateway.Feedback;
import com.unifacisa.ouvidoria.utils.Formatter;

public class FeedbackDAO {
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;
	ArrayList<Feedback> listOfFeedbacks = new ArrayList<>();
	
	Formatter formatter = new Formatter();
	
	public ArrayList<Feedback> getFeedbacks(String type) {
		conn = new ConnectionDAO().connectDB();
		
		String sql = "";
		switch (type) {
			case "Reclamacao":
				sql = "SELECT * FROM feedbacks WHERE type='Reclamacao'";
				break;
			case "Elogio":
				sql = "SELECT * FROM feedbacks WHERE type='Elogio'";
				break;
			case "Ideia":
				sql = "SELECT * FROM feedbacks WHERE type='Ideia'";
				break;
			case "All":
				sql = "SELECT * FROM feedbacks";
				break;
		}
		
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				Feedback fb = new Feedback();
				fb.setId(rs.getInt("id"));
				fb.setType(rs.getString("type"));
				fb.setAuthor(rs.getString("author"));
				fb.setFeedback(rs.getString("feedback"));
				
				listOfFeedbacks.add(fb);
			}
		} catch (SQLException err) {
			formatter.errorEmitter("Nao foi possivel listar os feedbacks!");
			System.out.println("FeedbackDAO on getFeedbacks: " + err.getMessage());
		}
		
		return listOfFeedbacks;
	}
	
	public void addFeedback(String type, String author, String feedback) {
		conn = new ConnectionDAO().connectDB();
		
		String sql = "INSERT INTO feedbacks (type, author, feedback) VALUES (?, ?, ?)";
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, type);
			pstm.setString(2, author);
			pstm.setString(3, feedback);
			
			pstm.execute();
			pstm.close();
			formatter.successEmitter("Feedback adicionado com sucesso!");
		} catch (SQLException err) {
			formatter.errorEmitter("Nao foi possivel adicionar o feedback!");
			System.out.println("FeedbackDAO on addFeedback: " + err.getMessage());
		}
	}
	
	public void deleteFeedback(int id) {
		conn = new ConnectionDAO().connectDB();
		
		String sql = "DELETE FROM feedbacks WHERE id = ?";
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			
			pstm.execute();
			pstm.close();
			formatter.successEmitter("Feedback removido com sucesso!");
		} catch (SQLException err) {
			formatter.errorEmitter("Nao foi possivel remover o feedback!");
			System.out.println("FeedbackDAO on deleteFeedback: " + err.getMessage());
		}
	}
	
	public void editFeedback(int id, String newFeedback) {
		conn = new ConnectionDAO().connectDB();
		
		String sql = "UPDATE feedbacks SET feedback = ? WHERE id = ?";
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, newFeedback);
			pstm.setInt(2, id);
			
			pstm.execute();
			pstm.close();
			formatter.successEmitter("Feedback editado com sucesso!");
		} catch (SQLException err) {
			formatter.errorEmitter("Nao foi possivel editar o feedback!");
			System.out.println("FeedbackDAO on editFeedback: " + err.getMessage());
		}
	}
}
