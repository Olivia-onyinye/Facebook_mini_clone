<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SignUp</title>
    <style> <%@ include file="css/signupStyle.css"%> </style>
</head>
<body>
<form action="SignUpServlet" method="post" style="border:0px solid #ccc">
    <div class="container">
        <h1>Sign Up</h1>
        <p>It's quick and easy.</p>
        <hr>

        <label id="username"><b>UserName</b></label>
        <input type="text" placeholder="Enter Full Name" name="userName" required>

        <label id="email"><b>Email</b></label>
        <input type="text" placeholder="Enter Last Name" name="email" required>

        <label id="gender"><b>Gender</b></label>
        <input type="text" placeholder="Enter Gender" name="gender" required>

        <label id="user_bio"><b>UserBio</b></label>
        <input type="text" placeholder="Bio" name="user_bio" required>

        <label id="psw"><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="password" required>

        <label>
            <input type="checkbox" checked="checked" name="remember" style="margin-bottom:15px"> Remember me
        </label>

        <p>By clicking Sign Up, you agree to our <a href="#" style="color:dodgerblue">Terms, Data Policy</a> and <a href="#" style="color:dodgerblue">Cookie Policy</a>
            You may receive SMS notifications from us and can opt out at any time.</p>

        <div class="clearfix">
            <button type="submit" class="signupbtn">Sign Up</button>
        </div>
        <p class = "para-2">Already have an account? <a href = "loginPage.jsp">Sign Up Here</a></p>
        </div>
    </div>
</form>
</body>
</html>
