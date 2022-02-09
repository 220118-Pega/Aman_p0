package com.revature.p0.storage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.p0.models.reimbursement;

import io.javalin.http.Handler;

public class reimbursementDAO {
	public List<reimbursement> getAllreimbursement() {
		List<reimbursement> allreimbursement = new ArrayList<reimbursement>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			String query ="select * from reimbursement";
			// statement -- string based query, executes the database, 
			// prepared statement -- parameterized
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				allreimbursement.add(
						new reimbursement(
								rs.getString("refundname"),
								rs.getString("refundtype"),
								rs.getString("description"),
								rs.getInt("amount"),
								rs.getString("status"),
								rs.getInt("id"))
						);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allreimbursement;
	}
	public reimbursement getreimbursementbyId(int id) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "Select * from reimbursement where id = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return new reimbursement(
						rs.getString("refundname"),
						rs.getString("refundtype"),
						rs.getString("description"),
						rs.getInt("amount"),
						rs.getString("status"),
						rs.getInt("id"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void addreimbursement(reimbursement newreimbursement) {
		try (Connection conn =ConnectionFactory.getInstance().getConnection()){
			String query = "insert into reimbursement (refundname, refundtype, description, Amount, status) values(?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, newreimbursement.getName());
			pstmt.setString(2, newreimbursement.getType());
			pstmt.setString(3, newreimbursement.getDescription());
			pstmt.setInt(4, newreimbursement.getAmount());
			pstmt.setString(5, newreimbursement.getStatus());
			pstmt.execute();
		}
	catch (SQLException e) {
		e.printStackTrace();
	}
	}
	public void updatereimbursement(reimbursement newreimbursement) {
		try (Connection conn =ConnectionFactory.getInstance().getConnection()){
			String query = "update reimbursement set refundname=?,status=?  where id = ? ";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, newreimbursement.getName());
			pstmt.setString(2, newreimbursement.getStatus());
			pstmt.setInt(3,newreimbursement.getId());
			pstmt.execute();
		}
	catch (SQLException e) {
		e.printStackTrace();
	}
	}
	
}
