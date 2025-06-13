<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bank - Customer Registration</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
 
<div class="container mt-5">
    <div class="card shadow">
        <div class="card-header bg-primary text-white">
            <h3 class="mb-0">Customer Registration Form</h3>
            <%
               
            String message = (String)request.getAttribute("errorMessage");
            String color = ""; // Default empty color

            if (message != null) {
                    color = "red"; // Success messages
            } else {
                    color = "blue"; // Other informational messages
                }	
            
            
            
            %>
			       <% if (message != null) { %>
			    <h4 style="color: <%= color %>;">
			        <%= message %>
			                    </h4>
             <% } %>
        </div>
        <div class="card-body">
            <form action="insertCustomer" method="post">
                
                <div class="row mb-3">
                    <div class="col-md-6">
                        <label for="firstName" class="form-label">First Name</label>
                        <input type="text" class="form-control" id="firstName" name="firstName" required>
                    </div>
                    <div class="col-md-6">
                        <label for="lastName" class="form-label">Last Name</label>
                        <input type="text" class="form-control" id="lastName" name="lastName" required>
                    </div>
                </div>

                <div class="mb-3">
                    <label for="dob" class="form-label">Date of Birth</label>
                    <input type="date" class="form-control" id="dob" name="dob" required>
                </div>

                <div class="mb-3">
                    <label for="gender" class="form-label">Gender</label>
                    <select class="form-select" id="gender" name="gender" required>
                        <option value="">-- Select Gender --</option>
                        <option value="Male">Male</option>
                        <option value="Female">Female</option>
                        <option value="Other">Other</option>
                    </select>
                </div>

                <div class="mb-3">
                    <label for="email" class="form-label">Email Address</label>
                    <input type="email" class="form-control" id="email" name="email" required>
                </div>

                <div class="mb-3">
                    <label for="phone" class="form-label">Contact Number</label>
                    <input type="tel" class="form-control" id="phone" name="phone" required pattern="[0-9]{10}" placeholder="10-digit number">
                </div>

                <div class="mb-3">
                    <label for="address" class="form-label">Address</label>
                    <textarea class="form-control" id="address" name="address" rows="3" required></textarea>
                </div>

                <div class="mb-3">
                    <label for="accountType" class="form-label">Account Type</label>
                    <select class="form-select" id="accountType" name="accountType" required>
                        <option value="">-- Select Account Type --</option>
                        <option value="savings">Savings Acoount</option>
                        <option value="current">Current Acoount</option>
                        
                    </select>
                </div>

                <div class="mb-3">
                    <label for="initialDeposit" class="form-label">Initial Deposit Amount</label>
                    <input type="number" class="form-control" id="initialDeposit" name="initialDeposit" required min="1000">
                </div>

                <div class="text-end">
                    <a href="<%= request.getContextPath() %>/employeeutil.jsp" class="btn btn-primary home-button">Home</a>
                  <button class="btn btn-success btn-custom">Submit </button>
                </div>
            </form>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
