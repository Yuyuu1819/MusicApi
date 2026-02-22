package com.musicapi.repositorio;

import com.musicapi.model.Artista;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Repositorio de artistas
 * Clase donde almacenamos los datos
 */
@Service
public class ArtistaRepository {
    // No hay inyección de dependencias ya que no tiene dependencoa
    // Lista donde almacenamos los artistas
    private List<Artista> artistas = new ArrayList<>(List.of(new Artista("Laufey", true, "Jazz/Pop")));
    //Función para obtener a todos los artistas
    public List<Artista> getArtistas() {return artistas;}
    public void deleteArtista(Artista artista) {
        artistas.remove(artista);
    }
    public Artista verArtista(String nombre) {
        for (Artista artista : artistas) {
            if (artista.getNombre().equals(nombre)) { return artista; }
        }
         return null;
    }
}
