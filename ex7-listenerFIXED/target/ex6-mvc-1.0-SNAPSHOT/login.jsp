<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <style>
            input {
                display: block;
                margin-bottom: 10px;
            }

            input[type="submit"] {
                display: block;
                margin-top: 10px;
            }
        </style>
        <title>JSP Page</title>
    </head>
    <body>

        <h1>Exercício de LDSW - Semana 7</h1>
        <%
            String msg =(String) session.getAttribute("msg");
            if(msg!=null){
                session.removeAttribute("msg"); 
        %>
        <p><%=msg%></p>
        <%}%>
        <p>Digite seu usuário e a senha</p>
        <form action="Controller" method="POST">
            <input type="text" name="userName" placeholder="Digite o usuário">
            <input type="password" name="password" placeholder="Digite a senha">
            <input type="hidden" name="operacao" value="login">
            <input type="submit" value="Entrar">
        </form>

    </body>
</html>
