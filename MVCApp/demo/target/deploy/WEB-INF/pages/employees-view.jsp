<%@ taglib prefix="demo" uri="my.app.tags" %>

<!DOCTYPE html>
<html>
<head>
    <title>Employees</title>
    <style>
        body {
            font-family: "Segoe UI", sans-serif;
            background: #faf6f1;
            padding: 25px;
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #4b3b2e;
        }

        table {
            width: 95%;
            margin: auto;
            border-collapse: collapse;
            background: #fff;
            border: 1px solid #e0d7cc;
        }

        th {
            background: #bda48b;
            color: #3f3124;
            padding: 10px;
        }

        td {
            padding: 8px;
            border-bottom: 1px solid #e6dcd2;
            text-align: center;
        }

        tr:hover {
            background: #f4ece3;
        }
    </style>
</head>
<body>

<h2>Employees in Department</h2>

<table>
    <tr>
        <th>Emp No</th>
        <th>Name</th>
        <th>Job</th>
        <th>Mgr</th>
        <th>Hire Date</th>
        <th>Salary</th>
        <th>Comm</th>
    </tr>

    <demo:fetchNextEmp empVar="e" empSource="${employees}">
        <tr>
            <td>${e.empno}</td>
            <td>${e.ename}</td>
            <td>${e.job}</td>
            <td>${e.mgr}</td>
            <td>${e.hiredate}</td>
            <td>${e.sal}</td>
            <td>${e.comm}</td>
        </tr>
    </demo:fetchNextEmp>

</table>

</body>
</html>
