package com.musicapi.model;


public class Artista {

    private static int idRef = 0;
    private int artistaId; // no mandar en request, si regresar en response
    private String nombre;
    private Boolean solitsta; // true: solista, false: grupo
    private String generoPrincipal;

    public Artista(String nombre, Boolean solitsta, String generoPrincipal) {
        this.nombre = nombre;
        this.solitsta = solitsta;
        this.generoPrincipal = generoPrincipal;
        artistaId = idRef;
        idRef++;
    }

    public int getArtistaId() {
        return artistaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getSolitsta() {
        return solitsta;
    }

    public void setSolitsta(Boolean solitsta) {
        this.solitsta = solitsta;
    }

    public String getGeneroPrincipal() {
        return generoPrincipal;
    }

    public void setGeneroPrincipal(String generoPrincipal) {
        this.generoPrincipal = generoPrincipal;
    }
}
