package com.example.laboratorio6.servlets;

import com.example.laboratorio6.beans.Pelicula;
import com.example.laboratorio6.beans.Actor;
import com.example.laboratorio6.daos.PeliculaDao;
import com.example.laboratorio6.daos.ActorDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "DetallesServlet", urlPatterns = "/viewPelicula")
public class DetallesServlet extends HttpServlet {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String user = "root";
    private static final String password = "root";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idPelicula = Integer.parseInt(request.getParameter("id"));

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PeliculaDao peliculaDao = new PeliculaDao(connection);
            Pelicula pelicula = peliculaDao.obtenerPeliculaPorId(idPelicula);
            ActorDao actorDao = new ActorDao(connection);
            List<Actor> actores = actorDao.obtenerActoresPorPelicula(idPelicula);
            request.setAttribute("pelicula", pelicula);
            request.setAttribute("actores", actores);
            request.getRequestDispatcher("/viewPelicula.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
