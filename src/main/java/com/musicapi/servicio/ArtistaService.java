package com.musicapi.servicio;

import com.musicapi.model.Artista;
import com.musicapi.repositorio.ArtistaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
// Servicio al que llaman donde se guardan los datos
public class ArtistaService {
    private final ArtistaRepository artistaRepository;
    /** Constructor de la clase ArtistaService
     Inyección de dependencias sucede aquí al pasar la dependencia de esta clase
     * en el constructor y no instanciarla manualmente (usando new ArtistaRepository())
     * @param artistaRepository Servicio al que llamar donde se guardan los datos
     */
    public ArtistaService(ArtistaRepository artistaRepository) {this.artistaRepository = artistaRepository;}
    // Obtiene a todos los artistas, @return Lista de artistas
    public List<Artista> getArtistas() {return artistaRepository.getArtistas();}
    public Artista verArtista(String nombre) { return artistaRepository.verArtista(nombre);}
    public void deleteArtista(Artista artista) { artistaRepository.deleteArtista(artista);}
}
