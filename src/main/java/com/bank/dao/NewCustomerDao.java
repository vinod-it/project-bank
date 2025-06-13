package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bank.model.NewCustomerBean;
import com.bank.utils.DatabaseConnection;

public class NewCustomerDao {

	public static final String INSERT_NEW_CUSTOMER = "INSERT INTO customers" + "(first_name,last_name,dob,gender,email,phone,address,account_type,initial_deposit) values " + "(?,?,?,?,?,?,?,?,?)";

	public static final String SELECT_CUSTOMER_BY_ID = "SELECT id,first_name,last_name,dob,gender,email,phone,address,account_type,initial_deposit from customers where id = ? ";
//
	public static final String SELECT_ALL_CUSTOMERS = "SELECT * FROM customers";
//
	public static final String DEPOSIT_AMOUNT = "UPDATE customers set initial_deposit=initial_deposit + ? where id = ?";
//
	public static final String WITHDRAWAL_AMOUNT = "UPDATE customers set initial_deposit=initial_deposit - ? where id = ?";
	//

	public static final String DELETE_CUSTOMER = "DELETE FROM customers where id = ?";




	public NewCustomerDao() {
		super();
	}





	//insert function
	public void insertCustomer(NewCustomerBean customerBean) throws ClassNotFoundException, SQLException {

    try (Connection con = DatabaseConnection.initializeDatabase();
		PreparedStatement ps = con.prepareStatement(INSERT_NEW_CUSTOMER)){
		ps.setString(1, customerBean.getFirst_name());
		ps.setString(2, customerBean.getLast_name());
		ps.setString(3, customerBean.getDob());
		ps.setString(4, customerBean.getGender());
		ps.setString(5, customerBean.getEmail());
		ps.setString(6, customerBean.getPhone());
		ps.setString(7, customerBean.getAddress());
		ps.setString(8, customerBean.getAccount_type());
		ps.setDouble(9, customerBean.getInitial_deposit());
		System.out.println(ps);
		ps.executeUpdate();
     }catch(SQLException e) {
    	 System.out.println(e.getMessage());
     }
	}


//	// select the user by its id
	public List<NewCustomerBean> selectCustomer(int id) throws SQLException, ClassNotFoundException {
		List<NewCustomerBean> cusbean = new ArrayList<>();
		
		Connection con = DatabaseConnection.initializeDatabase();
				PreparedStatement ps = con.prepareStatement(SELECT_CUSTOMER_BY_ID);
				ps.setInt(1,id);
				System.out.println(ps);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					int ids = rs.getInt("id");
					String first_name = rs.getString("first_name");
				     String last_name = rs.getString("last_name");
				     String dob = rs.getString("dob");
				     String gender = rs.getString("gender");
				     String email = rs.getString("email");
				     String phone = rs.getString("phone");
				     String address = rs.getString("address");
				     String account_type = rs.getString("account_type");
				     Double initial_deposit = rs.getDouble("initial_deposit");
				     
				     cusbean.add(new NewCustomerBean(ids,first_name, last_name, dob, gender, email, phone, address, account_type, initial_deposit));

				}
		    
		return cusbean;
	}
//
//
	// show all customers
	public List<NewCustomerBean> selectAllCustomer() throws ClassNotFoundException, SQLException{

		List<NewCustomerBean> customerList = new ArrayList<>();

		Connection con = DatabaseConnection.initializeDatabase();
				PreparedStatement ps = con.prepareStatement(SELECT_ALL_CUSTOMERS);
				System.out.println(ps);
				ResultSet rs = ps.executeQuery();

				while(rs.next()) {
					         int id = rs.getInt("id");
					String firstName = rs.getString("first_Name");
				     String lastName = rs.getString("last_Name");
				     String dob = rs.getString("dob");
				     String gender = rs.getString("gender");
				     String email = rs.getString("email");
				     String phone = rs.getString("phone");
				     String address = rs.getString("address");
				     String accountType = rs.getString("account_type");
				     Double initialDeposit = rs.getDouble("initial_deposit");
				     customerList.add(new NewCustomerBean(id,firstName, lastName, dob, gender, email, phone, address, accountType, initialDeposit));
				}


		return customerList;


	}
//
//	// update the customer details
//
//	public boolean updateCustomer(NewCustomerBean newCustomerBean) throws ClassNotFoundException, SQLException {
//
//
//		boolean rowUpdate;
//
//		Connection con = DatabaseConnection.initializeDatabase();
//				PreparedStatement ps = con.prepareStatement(UPDATE_CUSTOMER_DETAILS);
//			ps.setString(1, newCustomerBean.getFirst_name());
//			ps.setString(2, newCustomerBean.getLast_name());
//			ps.setString(3, newCustomerBean.getDob());
//			ps.setString(4, newCustomerBean.getGender());
//			ps.setString(5, newCustomerBean.getEmail());
//			ps.setString(6, newCustomerBean.getPhone());
//			ps.setString(7, newCustomerBean.getAddress());
//			ps.setString(8, newCustomerBean.getAccount_type());
//			ps.setDouble(9, newCustomerBean.getInitial_deposit());
//            ps.setInt(10, newCustomerBean.getId());
//		rowUpdate = ps.executeUpdate()>0;
//		return rowUpdate;
//	}
//
//	// delete customer
	public boolean deleteUser(int id) throws ClassNotFoundException, SQLException {

		boolean rowDelete;

		Connection con = DatabaseConnection.initializeDatabase();
		PreparedStatement ps = con.prepareStatement(DELETE_CUSTOMER);
		ps.setInt(1, id);

		rowDelete = ps.executeUpdate()>0;

		return rowDelete;

	}

	
	public boolean deposit(int id,double amount) throws ClassNotFoundException, SQLException {
		 boolean  rowUpdate;
		Connection con = DatabaseConnection.initializeDatabase();
		PreparedStatement ps = con.prepareStatement(DEPOSIT_AMOUNT);
		ps.setDouble(1, amount);
		ps.setInt(2,  id );
		System.out.println(ps);
		rowUpdate = ps.executeUpdate() >0;
		
		return rowUpdate;
		
	}
	

	public boolean Withdrawal(int id,double amount) throws ClassNotFoundException, SQLException {
		 boolean rowUpdate;
		Connection con = DatabaseConnection.initializeDatabase();
		PreparedStatement ps = con.prepareStatement(WITHDRAWAL_AMOUNT);
		ps.setDouble(1,  amount );
		ps.setInt(2, id);
		System.out.println(ps);
		rowUpdate = ps.executeUpdate()>0;
		
	return rowUpdate;
		
	}
	
	public boolean validating(NewCustomerBean custBean) throws ClassNotFoundException {
        boolean status = false;

        try (Connection connection = DatabaseConnection.initializeDatabase();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection
            .prepareStatement("select * from customers where id = ? ")) {
            preparedStatement.setInt(1, custBean.getId());
            

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();
            preparedStatement.close();

        } catch (SQLException e) {
            // process sql exception
        	System.out.println(e.getMessage());
        }finally {
        	try {
				DatabaseConnection.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // Always close the connection
        }

        return status;
    }
	
	
	public double findAmount(int id) throws ClassNotFoundException, SQLException {
		double initial_deposit = 0.0;
		Connection con = DatabaseConnection.initializeDatabase();
		PreparedStatement ps = con.prepareStatement("select initial_deposit from customers where id = ?");
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			initial_deposit = rs.getDouble("initial_deposit");
		}
		 
		return initial_deposit;
	}
}
	













