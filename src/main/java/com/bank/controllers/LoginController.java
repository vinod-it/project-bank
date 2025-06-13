package com.bank.controllers;

import java.io.IOException;

import com.bank.dao.LoginDao;
import com.bank.model.LoginBean;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 */

@WebServlet("/employeelogin")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private LoginDao loginDao;

    @Override
	public void init() {
        loginDao = new LoginDao();
    }
 
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       response.sendRedirect("employeelogin.jsp");
    }

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        authenticate(request, response);
    }

    private void authenticate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        LoginBean loginBean = new LoginBean();
        loginBean.setUsername(username);
        loginBean.setPassword(password);

        try {
            if (loginDao.validate(loginBean)) {
            	RequestDispatcher rd = request.getRequestDispatcher("employeeutil.jsp");
            	rd.forward(request, response);
            } else {
            	request.setAttribute("errorMessage", "Invalid username or password!");
                RequestDispatcher dispatcher = request.getRequestDispatcher("employeelogin.jsp");
                dispatcher.forward(request,response);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
