<%@page contentType="text/html; charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Form example</title>
    </head>
    <body>
        <form>
            Nazwisko: <input type="text" name="last_name"/>
            <input type="submit" value="wyślij"/>
        </form><br/>
        <% request.setCharacterEncoding("UTF-8"); %>
        <% if (request.getParameter("last_name") != null) { %>
        Przesłane nazwisko to <%= request.getParameter("last_name") %>
        <% } %>
    </body>
</html>