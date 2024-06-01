package com.example.laboratorio6.beans;

public class Protagonistas {
    private Pelicula pelicula;
    private Actor actor;

    // Constructor
    public Protagonistas(Pelicula pelicula, Actor actor) {
        this.pelicula = pelicula;
        this.actor = actor;
    }

    // Getters y setters
    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    // Método toString
    @Override
    public String toString() {
        return "Protagonistas{" +
                "pelicula=" + pelicula +
                ", actor=" + actor +
                '}';
    }
}
