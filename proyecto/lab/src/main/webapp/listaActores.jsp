<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Actores de la Película</title>
    </head>
    <body>
        <h1>Actores de la Película</h1>
        <c:forEach var="actor" items="${actores}">
            <table border="1">
                <tr>
                    <th>Nombre</th>
                    <td>${actor.nombre}</td>
                </tr>
                <tr>
                    <th>Apellido</th>
                    <td>${actor.apellido}</td>
                </tr>
                <tr>
                    <th>Año de Nacimiento</th>
                    <td>${actor.anioNacimiento}</td>
                </tr>
                <tr>
                    <th>Premio Oscar</th>
                    <td>${actor.premioOscar}</td>
                </tr>
            </table>
        </c:forEach>
    </body>
</html>
