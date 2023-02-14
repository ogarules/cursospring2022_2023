<%@ page language="java" contentType="text/html charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Created person detail</title>
    </head>
    <body>
        <h1>Persona registrada!!!</h1>
        <h2>${personCreated} was created at: ${servertime}</h2>

        <a href="${pageContext.request.contextPath}/person">Regresar</a>
    </body>
</html>