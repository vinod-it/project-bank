<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bank Employee Dashboard</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            
        }
        .dashboard-container {
            background-color: #ffffff;
            border-radius: 12px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
            padding: 30px;
            max-width: 600px;
            margin: auto;
        }
        .dashboard-title {
            text-align: center;
            margin-bottom: 25px;
            color: #007bff;
            font-weight: bold;
        }
        .btn-custom {
            width: 100%;
            margin-bottom: 15px;
            padding: 12px;
            font-size: 16px;
            transition: all 0.3s ease;
        }
       
        .header {
            background-color: #007bff;
            color: white;
            padding: 15px;
            text-align: center;
            font-size: 20px;
            font-weight: bold;
        }
        
    </style>
</head>
<body>

<!-- Header Section -->
<div class="header">
    <h2>Welcome to ADB Bank</h2>
</div>

<div class="dashboard-container">
    <h2 class="dashboard-title">Employee's Dashboard</h2>

    <div class="d-grid gap-2">
        <a href="<%= request.getContextPath() %>/open-account.jsp" class="btn btn-primary btn-custom">
            Open a New Account
        </a>

        <a href="<%= request.getContextPath() %>/searchCustomer.jsp" class="btn btn-info btn-custom">
            View Customer Details
        </a>

        <a href="<%= request.getContextPath() %>/customer-list" class="btn btn-success btn-custom">
            Show All Customers
        </a>

        <a href="<%= request.getContextPath() %>/deposit-withdrawal.jsp" class="btn btn-dark btn-custom">
           Deposit Amount and Withdrawal Amount
        </a>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
