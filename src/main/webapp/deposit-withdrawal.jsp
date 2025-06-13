<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Deposit and  Withdrawal - New Asian Development Bank</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" 
          >

    <style>
        body {
            background-color: #f8f9fa;
        }
        .transaction-container {
            margin-top: 80px;
            padding: 30px;
            background-color: white;
            border-radius: 12px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
        }
        h2 {
            color: #007bff;
        }
        .form-control {
            max-width: 400px;
            margin: auto;
        }
        .btn-container {
            display: flex;
            flex-direction: column;
            gap: 10px;
            margin-top: 20px;
        }
        .btn-primary, .btn-danger {
            font-size: 16px;
            padding: 10px;
        }
        .home-button {
            margin-top: 20px;
            font-size: 16px;
            padding: 10px;
        }
        .transaction-message {
            color: red;
            font-weight: bold;
            margin-top: 15px;
        }
    </style>
</head>

<body>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="transaction-container text-center">
                <h2 class="mb-4">Deposit and Withdrawal</h2>

                <!-- Transaction Form -->
                <form action="transaction" method="get" class="text-start">
                    <div class="mb-3">
                        <label for="accountId" class="form-label">Account ID</label>
                        <input type="text" name="id" class="form-control" id="accountId" placeholder="Enter Account ID" required>
                    </div>

                    <div class="mb-3">
                        <label for="amount" class="form-label">Amount</label>
                        <input type="number" name="amount" class="form-control" id="amount" placeholder="Enter Amount" required>
                    </div>
                    
                    <div class="btn-container">
                        <button type="submit" name="action" value="deposit" class="btn btn-primary">Deposit</button>
                        <button type="submit" name="action" value="withdrawal" class="btn btn-danger">Withdraw</button>
                    </div>
                </form>

                <!-- Transaction Message -->
                <p class="transaction-message">${transactionMessage}</p>
                <p style="color: red;">${errorMessage}</p>

                <!-- Home Button -->
                <a href="<%= request.getContextPath() %>/employeeutil.jsp" class="btn btn-secondary home-button">Home</a>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>

