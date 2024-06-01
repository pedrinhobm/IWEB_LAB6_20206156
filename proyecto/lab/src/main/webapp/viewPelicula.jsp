<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>${pelicula.titulo}</title>
    </head>
    <body>
        <h1>${pelicula.titulo}</h1>
        <table border="1">
            <tr>
                <th>ID Película</th>
                <td>${pelicula.idPelicula}</td>
            </tr>
            <tr>
                <th>Título</th>
                <td>${pelicula.titulo}</td>
            </tr>
            <tr>
                <th>Director</th>
                <td>${pelicula.director}</td>
            </tr>
            <tr>
                <th>Año de Publicación</th>
                <td>${pelicula.anoPublicacion}</td>
            </tr>
            <tr>
                <th>Rating</th>
                <td>${pelicula.rating}/10</td>
            </tr>
            <tr>
                <th>Box Office (USD)</th>
                <td>$${pelicula.boxOffice}</td>
            </tr>
            <tr>
                <th>Género</th>
                <td>${pelicula.genero.nombre}</td>
            </tr>
            <tr>
                <th>Actores</th>
                <td><a href="listaActores.jsp?id=${pelicula.idPelicula}">Ver Actores</a></td>
            </tr>
        </table>
    </body>
</html>

