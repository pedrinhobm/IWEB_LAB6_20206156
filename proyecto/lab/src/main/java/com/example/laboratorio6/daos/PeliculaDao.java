package com.example.laboratorio6.daos;

import com.example.laboratorio6.beans.Genero;
import com.example.laboratorio6.beans.Pelicula;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PeliculaDao {
    private Connection connection;

    public PeliculaDao(Connection connection) {
        this.connection = connection;
    }

    public List<Pelicula> obtenerPeliculas() throws SQLException {
        List<Pelicula> peliculas = new ArrayList<>();

        String query = "SELECT p.idPelicula, p.titulo, p.director, p.anoPublicacion, p.rating, p.boxOffice, g.nombre " +
                "FROM Pelicula p " +
                "INNER JOIN Genero g ON p.idGenero = g.idGenero " +
                "ORDER BY p.rating DESC, p.boxOffice DESC";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int idPelicula = rs.getInt("idPelicula");
                String titulo = rs.getString("titulo");
                String director = rs.getString("director");
                int anoPublicacion = rs.getInt("anoPublicacion");
                double rating = rs.getDouble("rating");
                double boxOffice = rs.getDouble("boxOffice");
                String nombreGenero = rs.getString("nombre");

                Genero genero = new Genero(0, nombreGenero);
                Pelicula pelicula = new Pelicula(idPelicula, titulo, director, anoPublicacion, rating, boxOffice, genero);
                peliculas.add(pelicula);
            }
        }

        return peliculas;
    }

    public Pelicula obtenerPeliculaPorId(int idPelicula) throws SQLException {
        Pelicula pelicula = null;
        String query = "SELECT p.titulo, p.director, p.anoPublicacion, p.rating, p.boxOffice, g.nombre " +
                "FROM Pelicula p " +
                "INNER JOIN Genero g ON p.idGenero = g.idGenero " +
                "WHERE p.idPelicula = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, idPelicula);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String titulo = rs.getString("titulo");
                String director = rs.getString("director");
                int anoPublicacion = rs.getInt("anoPublicacion");
                double rating = rs.getDouble("rating");
                double boxOffice = rs.getDouble("boxOffice");
                String nombreGenero = rs.getString("nombre");

                Genero genero = new Genero(0, nombreGenero);
                pelicula = new Pelicula(idPelicula, titulo, director, anoPublicacion, rating, boxOffice, genero);
            }
        }
        return pelicula;
    }

}
