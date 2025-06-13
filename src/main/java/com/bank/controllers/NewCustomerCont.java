package com.bank.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import com.bank.dao.NewCustomerDao;
import com.bank.model.NewCustomerBean;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NewCustomerCont
 */
@WebServlet("/")
public class NewCustomerCont extends HttpServlet {
	private static final long serialVersionUID = 1L;

   private NewCustomerDao newCustomerDao;

	@Override
	public void init() {
		newCustomerDao = new NewCustomerDao();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {

			try {
				insertNewCust(request,response);
				
				
			} catch (IOException   e ) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
	}



	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();
		
		switch(action) {
		
		case "/insert":insertNewCust(request,response);
		 	break;
		case "/customer-list": try {
				listCust(request,response);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/delete":deleteCust(request,response);
			break;
		case "/searchById":try {
				selectById(request,response);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		case "/transaction":try {
				transAmount(request,response);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}




	// insert details jsp
	private void insertNewCust(HttpServletRequest request, HttpServletResponse response)
	        throws IOException, ServletException {

	    String firstName = request.getParameter("firstName");
	    String lastName = request.getParameter("lastName");
	    String dob = request.getParameter("dob");
	    String gender = request.getParameter("gender");
	    String email = request.getParameter("email");
	    String phone = request.getParameter("phone");
	    String address = request.getParameter("address");
	    String accountType = request.getParameter("accountType");

	    double initialDeposit = 0.0;

	    // Validate deposit input
	    try {
	        initialDeposit = Double.parseDouble(request.getParameter("initialDeposit"));
	    } catch (NumberFormatException e) {
	        request.setAttribute("errorMessage", "Invalid deposit amount.");
	        request.getRequestDispatcher("open-account.jsp").forward(request, response);
	        return;
	    }

	    // Validate deposit amount based on account type
	    if ("current".equalsIgnoreCase(accountType) && initialDeposit < 5000) {
	        request.setAttribute("errorMessage", "Initial deposit for a Current Account must be at least 5000.");
	        request.getRequestDispatcher("open-account.jsp").forward(request, response);
	        return;
	    } else if ("savings".equalsIgnoreCase(accountType) && initialDeposit < 1000) {
	        request.setAttribute("errorMessage", "Initial deposit for a Savings Account must be at least 1000.");
	        request.getRequestDispatcher("open-account.jsp").forward(request, response);
	        return;
	    }

	    // Create a new customer bean
	    NewCustomerBean newCustBean = new NewCustomerBean(firstName, lastName, dob, gender, email, phone, address, accountType, initialDeposit);

	    try {
	        newCustomerDao.insertCustomer(newCustBean);
	        request.setAttribute("customer", newCustBean);

	        // Forward to success page
	        request.getRequestDispatcher("registration-successfull.jsp").forward(request, response);
	    } catch (SQLException | ClassNotFoundException e) {
	        // Log the error instead of printing stack trace
	        request.setAttribute("errorMessage", "Database error occurred. Please try again later.");
	        request.getRequestDispatcher("open-account.jsp").forward(request, response);
	    }
	}


//	// delete cust jsp
	private void deleteCust(HttpServletRequest request, HttpServletResponse response) {

		int id = Integer.parseInt(request.getParameter("id"));

		try {
			newCustomerDao.deleteUser(id);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			response.sendRedirect("showAll");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


	}


//	//show data by id
	private void selectById(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {

   	 int id = Integer.parseInt(request.getParameter("id"));
   	
   	List<NewCustomerBean> newCustomerBean;
		 newCustomerBean = newCustomerDao.selectCustomer(id);
		request.setAttribute("custBean",newCustomerBean);
		RequestDispatcher rd = request.getRequestDispatcher("searchCustomer.jsp");
		
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
//
//	// default
	
	private void listCust(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {

		List<NewCustomerBean> newCustomerBean = newCustomerDao.selectAllCustomer();
		request.setAttribute("listCust", newCustomerBean);

		RequestDispatcher rd = request.getRequestDispatcher("customer-list.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	// deposite amount
	private void transAmount(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException{
		
		int id = Integer.parseInt(request.getParameter("id"));
		double amount = Double.parseDouble(request.getParameter("amount"));
		String action = request.getParameter("action");
		
		Random random = new Random();
        int transactionId = 100000 + random.nextInt(900000);
		
        NewCustomerBean custBean = new NewCustomerBean();
        custBean.setId(id);
        
        if(newCustomerDao.validating(custBean) ) {
        
		request.setAttribute("transactionId",transactionId );
		request.setAttribute("id", id);
		request.setAttribute("amount", amount);
		
		
				if ("deposit".equals(action)) {
					    newCustomerDao.deposit(id,amount);
					    request.setAttribute("transactionType", "Credit");
		            } else if ("withdrawal".equals(action) && newCustomerDao.findAmount(id) >amount) {
		        	    newCustomerDao.Withdrawal(id, amount);
		        	    request.setAttribute("transactionType", "Debit");
		            }else {
		    		    request.setAttribute("errorMessage", "Insufficent Balance");
		                RequestDispatcher dispatcher = request.getRequestDispatcher("deposit-withdrawal.jsp");
		               
		    			dispatcher.forward(request, response);
		    		    
		            }
				
					request.getRequestDispatcher("transaction-status.jsp").forward(request, response);
				
			
		        }
		else {
		request.setAttribute("errorMessage", "Invalid Account number !!");
        RequestDispatcher dispatcher = request.getRequestDispatcher("deposit-withdrawal.jsp");
       
			dispatcher.forward(request, response);
		
	      }
	
        }
	
  }
	











