<!DOCTYPE html>
<html>
<head>
    <title>HR Login</title>
    <style>
        body {
            font-family: "Segoe UI", sans-serif;
            background: #faf6f1;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .box {
            background: #fff;
            padding: 25px 35px;
            border-radius: 10px;
            border: 1px solid #e0d7cc;
        }

        h2 {
            margin: 0 0 15px;
            color: #5a4635;
            text-align: center;
        }

        label {
            font-size: 14px;
            color: #4b3b2e;
            font-weight: 500;
        }

        input[type=text], input[type=password] {
            width: 100%;
            padding: 8px;
            margin-top: 4px;
            margin-bottom: 15px;
            border-radius: 6px;
            border: 1px solid #c8b9a6;
            background: #fff9f3;
        }

        button {
            width: 100%;
            padding: 9px;
            border: none;
            border-radius: 6px;
            background: #d48845;
            color: white;
            cursor: pointer;
        }

        button:hover {
            background: #bb7338;
        }

        .error {
            color: #b03030;
            margin-top: 12px;
            text-align: center;
            font-size: 14px;
        }
    </style>
</head>
<body>

<div class="box">
    <h2>HR Login</h2>

    <form method="post" action="home">
        <input type="hidden" name="action" value="login"/>

        <label>Username</label>
        <input type="text" name="username"/>

        <label>Password</label>
        <input type="password" name="password"/>

        <button type="submit">Login</button>
    </form>

    <% if (request.getAttribute("problem") != null) { %>
        <div class="error"><%= request.getAttribute("problem") %></div>
    <% } %>
</div>

</body>
</html>
