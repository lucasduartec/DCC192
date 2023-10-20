<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu</title>
    </head>
    <body>
        <% String usuario = (String) request.getSession().getAttribute("usuario");
        Integer userCounter = (Integer) getServletContext().getAttribute("userCounter");
        if(usuario!=null){
        %>
        <h1>Laboratorio de Programação de Sistemas Web</h1>
        <h2>Bem-vindo <%= usuario%>!</h2>
        <h3>Usuários conectados: <%= userCounter%>!</h3>
        <% 
        } 
        %>
        <form action="Controller" method="post">
            <input type="hidden" name="operacao" value="welcome">
            <button type="submit">Welcome</button>
        </form>
        <form action="Controller" method="post">
            <input type="hidden" name="operacao" value="erroJava">
            <button type="submit">Erro Java</button>
        </form>
        <form action="Controller" method="post">
            <input type="hidden" name="operacao" value="erroHtml">
            <button type="submit">Erro HTML</button>
        </form>
        <form action="Controller" method="post">
            <input type="hidden" name="operacao" value="sair">
            <button type="submit">Sair</button>
        </form>
    </body>
</html>
