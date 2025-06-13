<%@ page import="java.sql.*, java.util.List" %>
<%@ page import="com.bank.model.NewCustomerBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Customer List - Bank</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="card shadow">
        <div class="card-header bg-primary text-white">
            <h3 class="mb-0">Existing Customers</h3>
        </div>
        <div class="card-body">
            <div class="table-responsive"> 
                <table class="table table-bordered table-striped table-hover w-100">
                    <thead class="table-dark">
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Date of Birth</th>
                            <th>Gender</th>
                            <th>Email</th>
                            <th>Phone</th>
                            <th>Account Type</th>
                            <th>Initial Deposit</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                        @SuppressWarnings("unchecked")
                        List<NewCustomerBean> customersDetails = (List<NewCustomerBean>) request.getAttribute("listCust");
                        if (customersDetails != null) {
                            for (NewCustomerBean customer : customersDetails) {
                        %>
                        <tr>
                            <td><%= customer.getId() %></td>
                            <td><%= customer.getFirst_name() %> <%= customer.getLast_name() %></td>
                            <td><%= customer.getDob() %></td>
                            <td><%= customer.getGender() %></td>
                            <td><%= customer.getEmail() %></td>
                            <td><%= customer.getPhone() %></td>
                            <td><%= customer.getAccount_type() %></td>
                            <td>₹<%= customer.getInitial_deposit() %></td>
                            <td><a href="delete?id=<%= customer.getId() %>" class="btn btn-danger btn-sm">Delete</a></td>
                        </tr>
                        <%
                            }
                        } else {
                        %>
                        <tr>
                            <td colspan="9" class="text-center">No customer records found.</td>
                        </tr>
                        <%
                        }
                        %>
                    </tbody>
                </table>
            </div>

            <!-- Home Button -->
            <div class="text-center mt-4">
                <a href="<%= request.getContextPath() %>/employeeutil.jsp" class="btn btn-primary">Home</a>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>


