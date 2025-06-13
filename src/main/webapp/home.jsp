<%--
  Created by IntelliJ IDEA.
  User: Achintha
  Date: 5/29/2025
  Time: 1:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JTA BANK | Account</title>
</head>
<body>
<h1>Hello, ${sessionScope.user}</h1>
<form action="transfer" method="post">
    <table>
        <tr>
            <th>Source Account No</th>
            <td><input type="text" name="sourceAccountNo"></td>
        </tr>
        <tr>
            <th>Destination Account No</th>
            <td><input type="text" name="destinationAccountNo"></td>
        </tr>
        <tr>
            <th>Amount</th>
            <td><input type="text" name="amount"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Transfer"></td>
        </tr>
    </table>
</form>

</body>
</html>
