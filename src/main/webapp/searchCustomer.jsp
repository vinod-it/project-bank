<%@ page import="java.sql.*, java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.bank.model.NewCustomerBean" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Search Customer - Bank</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    
    <style>
        body {
            background-color: #f8f9fa;
        }
        .card {
            border-radius: 10px;
        }
        .table th {
            width: 30%;
            background-color: #e9ecef;
        }
        .home-button {
            display: block;
            margin: 20px auto;
            width: 200px;
        }
    </style>
</head>
<body>

<div class="container mt-5">
    <div class="card shadow">
        <div class="card-header bg-primary text-white text-center">
            <h3 class="mb-0">Search Customer Details</h3>
        </div>
        <div class="card-body">
            <!-- Search Form -->
            <form action="searchById" method="get" class="mb-4">
                <div class="row g-2">
                    <div class="col-md-8">
                        <input type="text" class="form-control" name="id" placeholder="Enter Customer ID" required>
                    </div>
                    <div class="col-md-4">
                        <button type="submit" class="btn btn-primary w-100">Search</button>
                    </div>
                </div>
            </form> 

            <!-- Customer Details Table -->
            <div class="table-responsive">
                <table class="table table-bordered table-striped">
                    <%
                    @SuppressWarnings("unchecked")
                    List<NewCustomerBean> custBeans = (List<NewCustomerBean>) request.getAttribute("custBean");

                    if (custBeans != null && !custBeans.isEmpty()) {
                        for (NewCustomerBean custBean : custBeans) {
                    %>
                    <tr>
                        <th>ID</th>
                        <td><%= custBean.getId() %></td>
                    </tr>
                    <tr>
                        <th>Name</th>
                        <td><%= custBean.getFirst_name() %> <%= custBean.getLast_name() %></td>
                    </tr>
                    <tr>
                        <th>Date of Birth</th>
                        <td><%= custBean.getDob() %></td>
                    </tr>
                    <tr>
                        <th>Gender</th>
                        <td><%= custBean.getGender() %></td>
                    </tr>
                    <tr>
                        <th>Email</th>
                        <td><%= custBean.getEmail() %></td>
                    </tr>
                    <tr>
                        <th>Contact Number</th>
                        <td><%= custBean.getPhone() %></td>
                    </tr>
                    <tr>
                        <th>Address</th>
                        <td><%= custBean.getAddress() %></td>
                    </tr>
                    <tr>
                        <th>Account Type</th>
                        <td><%= custBean.getAccount_type() %></td>
                    </tr>      
                    <tr>
                        <th>Initial Deposit</th>
                        <td>₹<%= custBean.getInitial_deposit() %></td>
                    </tr>
                    <%
                        }
                    } else {
                    %>
                    <tr>
                        <td colspan="2" class="text-center text-danger">No customer found with the given ID.</td>
                    </tr>
                    <%
                    }
                    %>
                </table>
            </div>

            <!-- Home Button -->
            <div class="text-center">
                <a href="<%= request.getContextPath() %>/employeeutil.jsp" class="btn btn-secondary home-button">Home</a>
            </div>

        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>

