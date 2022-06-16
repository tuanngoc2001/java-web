<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 6/16/2022
  Time: 3:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit User</title>
</head>
<body>
<p>
    <a style="text-decoration: none" href="/user?action=listuser">Back</a>
</p>
<form method="post">
    <fieldset>
        <legend>User information</legend>
        <table>
            <tr>
                <td>User: </td>
                <td><input type="text" name="username" id="username" value="${requestScope["users"].getUsername()}"></td>
            </tr>
            <tr>
                <td>Email: </td>
                <td><input type="text" name="email" id="email" value="${requestScope["customer"].getEmail()}"></td>
            </tr>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" id="name" ></td>
            </tr>
            <tr>
                <td>Address: </td>
                <td><input type="text" name="address" id="address" ></td>
            </tr>
            <tr>
                <td>PhoneNumber: </td>
                <td><input type="text" name="phone" id="phone" ></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update customer"></td>
            </tr>
        </table>
    </fieldset>
</form>

</body>
</html>
