package com.example.laboratorio6.daos;

import com.example.laboratorio6.beans.Actor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActorDao {
    private Connection connection;

    public ActorDao(Connection connection) {
        this.connection = connection;
    }

    public List<Actor> obtenerActoresPorPelicula(int idPelicula) throws SQLException {
        List<Actor> actores = new ArrayList<>();
        String query = "SELECT a.nombre, a.apellido, a.anioNacimiento, a.premioOscar " +
                "FROM Actor a " +
                "INNER JOIN Protagonistas p ON a.idActor = p.idActor " +
                "WHERE p.idPelicula = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, idPelicula);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int anioNacimiento = rs.getInt("anioNacimiento");
                boolean premioOscar = rs.getBoolean("premioOscar");

                Actor actor = new Actor(nombre, apellido, anioNacimiento, premioOscar);
                actores.add(actor);
            }
        }

        return actores;
    }
}
