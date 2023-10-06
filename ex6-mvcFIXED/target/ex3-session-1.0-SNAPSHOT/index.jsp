<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
        <h1>Exercício de LDSW - Semana 6</h1>
        <%
            String msg =(String) session.getAttribute("msg");
            if(msg!=null){
                session.removeAttribute("msg"); 
        %>
            <p><%=msg%></p>
        <%}%>
        <p>Digite seu usuário e a senha</p>
        <form action="menu" method="POST">
            <input type="text" name="user" placeholder="Digite o usuário">
            <input type="password" name="password" placeholder="Digite a senha">
            <input type="submit" value="Entrar">
        </form>
    </body>
</html>
