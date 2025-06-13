<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Transaction Successful - New Asian Development Bank</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" 
         >

    <style>
        body {
            background-color: #f8f9fa;
        }
        .success-container {
            margin-top: 100px;
            padding: 30px;
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        h2 {
            color: #28a745;
        }
        .btn-primary {
            width: 100%;
        }
    </style>
</head>

<body>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="success-container">
                <h2>Transaction Successful!</h2>
                <p>Your transaction has been successfully completed.</p>
                <p><strong>Transaction ID:</strong> ${transactionId}</p>
                <p><strong>Account ID:</strong> ${id}</p>
                <p><strong>Amount:</strong> ${amount}</p>
                <p><strong>Transaction Type:</strong> ${transactionType}</p>
                
                <a href="employeeutil.jsp" class="btn btn-primary mt-3">Back to Home</a>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/2.11.6/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/5.3.0-alpha1/js/bootstrap.min.js"></script>

</body>
</html>
