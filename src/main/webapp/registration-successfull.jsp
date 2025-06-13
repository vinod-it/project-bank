<%@ page import="java.util.*" %>
<%@ page import="com.bank.model.NewCustomerBean" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Confirmation</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="card shadow-lg border-0 rounded">
        <div class="card-header bg-success text-white text-center">
            <h3 class="mb-0">Registration Successful</h3>
        </div>
        <div class="card-body p-4">
        
        <% NewCustomerBean nc = (NewCustomerBean) request.getAttribute("customer"); %> 
            
            <div class="mb-3">
                <p><strong>Name:</strong> <%= nc.getFirst_name() %> <%= nc.getLast_name() %></p>
                <p><strong>Date of Birth:</strong> <%= nc.getDob() %></p>
                <p><strong>Gender:</strong> <%= nc.getGender() %></p>
                <p><strong>Email:</strong> <%= nc.getEmail() %></p>
                <p><strong>Contact Number:</strong> <%= nc.getPhone() %></p>
                <p><strong>Address:</strong> <%= nc.getAddress() %></p>
                <p><strong>Account Type:</strong> <%= nc.getAccount_type() %></p>
                <p><strong>Initial Deposit:</strong> <%= nc.getInitial_deposit() %></p>
            </div>
            
            <div class="text-center">
                <p class="mt-3 text-success">Thank you for registering with our bank!</p>
                <a href="employeeutil.jsp" class="btn btn-primary">Home</a>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
