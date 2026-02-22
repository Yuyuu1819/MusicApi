package com.musicapi.controlador;

import com.musicapi.model.Artista;
import com.musicapi.repositorio.ArtistaRepository;
import com.musicapi.servicio.ArtistaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Clase de entrada para los requests HTTP
 * /artistas marca la ruta base para el url, por ende se
 * usaría 'http://localhost:8080/artistas' para acceder a los endpoints de esta clase
 */
@RestController
@RequestMapping("/artistas")
public class ArtistaController {
    //Servicio al que llama donde ejecutamos la lógica de negocio (validaciones, errores, etc.)
    private ArtistaService artistaService;
    //constructor
    public ArtistaController(ArtistaService artistaService) { this.artistaService = artistaService; }

    @PostMapping
    public ResponseEntity<String> getArtistas(@RequestBody Artista artista) {
        return new ResponseEntity<>("Se agregó al nuevo artista: \n" + artista + " \n A la lista: \n" + artistaService.getArtistas(), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Artista>> verArtistas() {
        List<Artista> artistas = artistaService.getArtistas();
        return new ResponseEntity<>(artistas, HttpStatus.OK); //siempre returneamos el response entity!
    }

    @GetMapping("{nombre}")
    public ResponseEntity<Artista> getArtistasByNombre(@PathVariable String nombre) {
        Artista artista = artistaService.verArtista(nombre);
        if (artista != null){return new ResponseEntity<>(artista, HttpStatus.OK);}
        else{return new ResponseEntity<>(artista, HttpStatus.NOT_FOUND);}
    }
    @PutMapping
    public ResponseEntity<String> updateArtistas(@RequestBody Artista artista) {
        return new ResponseEntity<>("Artista actualizado c:", HttpStatus.OK); //siempre returneamos el response entity!

    }
    @DeleteMapping
    public ResponseEntity<String> deleteArtista(@RequestBody Artista artista) {
        artistaService.deleteArtista(artista);
        return new ResponseEntity<>("Se eliminó al nuevo artista: \n" + artista, HttpStatus.OK);
    }
}
