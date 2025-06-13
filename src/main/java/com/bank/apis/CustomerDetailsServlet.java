//package com.bank.apis;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.bank.dao.NewCustomerDao;
//import com.bank.model.NewCustomerBean;
//import com.bank.utils.DatabaseConnection;
//import com.google.gson.Gson;
//import com.google.gson.JsonElement;
//import com.google.gson.JsonObject;
//
///**
// * Servlet implementation class CustomerDetailsServlet
// */
//@WebServlet("/CustomerDetailsServlet")
//public class CustomerDetailsServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	public static final String SELECT_CUSTOMER_BY_ID = "SELECT id,first_name,last_name,dob,gender,email,phone,address,account_type,initial_deposit from customers where id = ? ";
//  
//	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//				
//		response.setHeader("Access-Control-Allow-Origin", "*");
//        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
//        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
//		response.setContentType("application/json");
//		PrintWriter out = response.getWriter();
//		int id = Integer.parseInt(request.getParameter("id"));
//		JsonObject responseObject= new JsonObject();
//		
//		try {
//		 List<NewCustomerBean> custList = 	selectCustomer(id);
//		 if(custList!=null) {
//			 Gson gson = new Gson();
//			 responseObject.add("customerData", gson.toJsonTree(custList));
//		 }
//		} catch (ClassNotFoundException | SQLException e) {
//			responseObject.addProperty("message", "you are fucked up!");
//		}
//		out.println(responseObject);
//		
//		
//		response.flushBuffer();
//	}
//
//	private List<NewCustomerBean> selectCustomer(int id) throws SQLException, ClassNotFoundException {
//		List<NewCustomerBean> cusbean = new ArrayList<>();
//		
//		Connection con = DatabaseConnection.initializeDatabase();
//				PreparedStatement ps = con.prepareStatement(SELECT_CUSTOMER_BY_ID);
//				ps.setInt(1,id);
//				System.out.println(ps);
//				ResultSet rs = ps.executeQuery();
//				while(rs.next()) {
//					int ids = rs.getInt("id");
//					String first_name = rs.getString("first_name");
//				     String last_name = rs.getString("last_name");
//				     String dob = rs.getString("dob");
//				     String gender = rs.getString("gender");
//				     String email = rs.getString("email");
//				     String phone = rs.getString("phone");
//				     String address = rs.getString("address");
//				     String account_type = rs.getString("account_type");
//				     Double initial_deposit = rs.getDouble("initial_deposit");
//				     
//				     cusbean.add(new NewCustomerBean(ids,first_name, last_name, dob, gender, email, phone, address, account_type, initial_deposit));
//				}
//		    
//		return cusbean;
//	}
//}
