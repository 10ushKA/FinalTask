<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 29.12.2021
  Time: 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
</head>
<body>
    <div style="text-align: center">
        <h1>Login</h1>
        <form action="login" method="post">
            <%--@declare id="login"--%><%--@declare id="password"--%><label for="login">Login:</label>
            <input name="email" size="30" />
            <br><br>
            <label for="password">Password:</label>
            <input type="password" name="password" size="30" />
            <br>${message}
            <br><br>
            <button type="submit">Login</button>

















<%-- <table>
    <tr>
        <td>Login</td>
        <td><input type="text" name="login" value= "${user.login}" /> </td>
    </tr>
    <tr>
        <td>Password</td>
        <td><input type="text" name="password" value= "${user.password}" /> </td>
    </tr>
    <br>${message}<%--an EL expressionto display the message sent from the srver(the login/password failed) --%>
    <%--<br><br>
    <tr>
        <td colspan ="2">
            <input type="submit" value= "Sign in" />
        </td>
    </tr>
</table>--%>
</form>
    </div>
</body>

<script type="text/javascript">
<%--This script validates the email and password fields are not empty, and the user must enter a valid email address --%>
    $(document).ready(function() {
        $("#loginForm").validate({
            rules: {
                email: {
                    required: true,
                    email: true
                },

                password: "required",
            },

            messages: {
                email: {
                    required: "Please enter email",
                    email: "Please enter a valid email address"
                },

                password: "Please enter password"
            }
        });

    });
</script>
</html>
