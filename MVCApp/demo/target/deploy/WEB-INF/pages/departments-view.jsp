<%@ taglib prefix="demo" uri="my.app.tags" %>

<!DOCTYPE html>
<html>
<head>
    <title>Departments</title>
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
            width: 85%;
            margin: auto;
            border-collapse: collapse;
            background: #fff;
            border: 1px solid #e0d7cc;
        }

        th {
            background: #d6c1ab;
            color: #3e2f23;
            padding: 10px;
        }

        td {
            padding: 9px;
            border-bottom: 1px solid #e8dfd4;
            text-align: center;
        }

        tr:hover {
            background: #faf1e6;
        }

        button {
            background: #a57243;
            border: none;
            color: white;
            padding: 5px 12px;
            border-radius: 4px;
            cursor: pointer;
        }

        button:hover {
            background: #8e6237;
        }
    </style>
</head>
<body>

<h2>Department List</h2>

<table>
    <tr>
        <th>Dept No</th>
        <th>Name</th>
        <th>Location</th>
        <th>Action</th>
    </tr>

    <demo:fetchNextDept deptVar="d" deptSource="${departments}">
        <tr>
            <td>${d.deptno}</td>
            <td>${d.dname}</td>
            <td>${d.loc}</td>
            <td>
                <form method="post" action="home">
                    <input type="hidden" name="action" value="employees"/>
                    <input type="hidden" name="deptno" value="${d.deptno}"/>
                    <button type="submit">View</button>
                </form>
            </td>
        </tr>
    </demo:fetchNextDept>

</table>

</body>
</html>
