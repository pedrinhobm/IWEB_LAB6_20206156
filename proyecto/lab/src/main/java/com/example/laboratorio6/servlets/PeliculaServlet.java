package com.example.laboratorio6.servlets;

import com.example.laboratorio6.beans.Pelicula;
import com.example.laboratorio6.daos.PeliculaDao;

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

@WebServlet(name = "PeliculaServlet", urlPatterns = "/listaPeliculas")
public class PeliculaServlet extends HttpServlet {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String user = "root";
    private static final String password = "root";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (Connection connection = DriverManager.getConnection(url,user, password)) {
            PeliculaDao peliculaDao = new PeliculaDao(connection);
            List<Pelicula> peliculas = peliculaDao.obtenerPeliculas();
            request.setAttribute("peliculas", peliculas);
            request.getRequestDispatcher("/listapeliculas.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
