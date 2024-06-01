<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Películas</title>
    </head>
    <body>
        <h1>Listado de Películas</h1>
        <form action="listaPeliculas" method="get">
            <label for="buscar">Buscar Película:</label>
            <input type="text" id="buscar" name="buscar">
            <input type="submit" value="Buscar">
        </form>
        <table border="1">
            <tr>
                <th>Título</th>
                <th>Director</th>
                <th>Año de Publicación</th>
                <th>Rating</th>
                <th>Box Office (USD)</th>
                <th>Género</th>
                <th>Actores</th>
            </tr>
            <c:forEach var="pelicula" items="${peliculas}">
                <tr>
                    <td><a href="viewPelicula.jsp?id=${pelicula.idPelicula}">${pelicula.titulo}</a></td>
                    <td>${pelicula.director}</td>
                    <td>${pelicula.anoPublicacion}</td>
                    <td>${pelicula.rating}/10</td>
                    <td>$${pelicula.boxOffice}</td>
                    <td>${pelicula.genero.nombre}</td>
                    <td><a href="listaActores.jsp?id=${pelicula.idPelicula}">Ver Actores</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
