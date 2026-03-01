package com.musicapi.controlador;

import com.musicapi.model.Artista;
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

    //Constructor de la capa controlador
    public ArtistaController(ArtistaService artistaService) { this.artistaService = artistaService; }

    @PostMapping
    public ResponseEntity<String> getArtistas(@RequestBody Artista artista) {
        artistaService.addArtista(artista);
        return new ResponseEntity<>("Se agregó al nuevo artista con el ID: \n" + artistaService.getId(artista), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Artista>> verArtistas() {
        List<Artista> artistas = artistaService.getArtistas();
        return new ResponseEntity<>(artistas, HttpStatus.OK); //siempre returneamos el response entity!
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<Artista> getArtistasByNombre(@PathVariable String nombre) {
        Artista artista = artistaService.verArtista(nombre);
        if (artista != null) { return new ResponseEntity<>(artista, HttpStatus.OK); }
        else { return new ResponseEntity<>(artista, HttpStatus.NOT_FOUND); }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateArtistas(@PathVariable int id, @RequestBody Artista artista) {
        boolean actualizado = artistaService.actualizarArtista(id, artista);
        if (actualizado) { return new ResponseEntity<>("Artista actualizado c:", HttpStatus.OK); }  //response entity yay!
        else { return new ResponseEntity<>("Artista no encontrado :c", HttpStatus.NOT_FOUND); }  //response entity boo!
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteArtista(@PathVariable int id) {
        boolean deleted = artistaService.deleteArtista(id);
        if (deleted) { return new ResponseEntity<>("Se eliminó al nuevo artista con ID: \n" + id, HttpStatus.OK); } //response entity yay!
        else { return new ResponseEntity<>("Artista no encontrado :c", HttpStatus.NOT_FOUND); } //response entity boo!
    }
}
// Beep Boop. Fin del programa - Yuliette y kirby