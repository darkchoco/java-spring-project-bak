<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Calculate BMI</title>
</head>
<body>

<form name="bmiForm" action="calculateServlet" method="POST">
    <table>
        <tr>
            <td>Your Weight (kg) :</td>
            <td><label>
                <input type="text" name="weight"/>
            </label></td>
        </tr>
        <tr>
            <td>Your Height (m) :</td>
            <td><label>
                <input type="text" name="height"/>
            </label></td>
        </tr>
        <th><input type="submit" value="Submit" name="find"/></th>
        <th><input type="reset" value="Reset" name="reset" /></th>
    </table>
    <h2>${bmi}</h2>
</form>

</body>
</html>