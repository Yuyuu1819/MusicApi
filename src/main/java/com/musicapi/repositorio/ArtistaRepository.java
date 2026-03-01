package com.musicapi.repositorio;

import com.musicapi.model.Artista;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Repositorio de artistas
 * Clase donde almacenamos los datos
 *  En este caso, no hay inyección de dependencias ya que no tiene dependencia
 */
@Service
public class ArtistaRepository {
    // Lista donde almacenamos los artistas
    private List<Artista> artistas = new ArrayList<>(List.of(new Artista("Laufey", true, "Jazz/Pop")));

    //Función para obtener a todos los artistas
    public List<Artista> getArtistas() {return artistas;}

    //FUnción para obtener el id
    public int getId(Artista artista) { return artista.getArtistaId();}

    //Función para agregar un artista nuevo
    public void addArtista(Artista artista){ artistas.add(artista);}

    //Función para borrar un artista
    public boolean deleteArtista(int id) {
        for (Artista artista : artistas) {
            if (artista.getArtistaId() == id ) {
                artistas.remove(artista);
                return true; }
        } return false;
    }

    //Función para encontrar un artista por su nombre
    public Artista verArtista(String nombre) {
        for (Artista artista : artistas) {
            if (artista.getNombre().equals(nombre)) { return artista; }
        } return null;
    }

    //Función para aactualizar el artista con su id
    public boolean actualizarArtista(int id, Artista artistaReload) {
        for (Artista artista : artistas) {
            if (artista.getArtistaId() == id) {
                artista.setNombre(artistaReload.getNombre());
                artista.setGeneroPrincipal(artistaReload.getGeneroPrincipal());
                artista.setSolitsta(artistaReload.getSolitsta());
                return true; }
        }  return false;
    }

}
