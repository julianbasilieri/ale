package com.parcial.Parcial_90276.Controlador;

import com.parcial.Parcial_90276.Dominio.Service.ArtistService;
import com.parcial.Parcial_90276.Request.CreateArtistRequest;
import com.parcial.Parcial_90276.Request.UpdateArtistRequest;
import com.parcial.Parcial_90276.Response.ArtistReponse;
import com.parcial.Parcial_90276.ResponseHandler;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("/api/artist")
public class ArtistController {

    @Autowired
    ArtistService artistService;

    @GetMapping("/")
    public ResponseEntity<Object> getAll(){
        try {
            val artists = artistService.getAll()
                    .stream()
                    .map(ArtistReponse::from)
                    .toList();
            return ResponseHandler.success(artists);
        }
        catch (Exception e){
            return ResponseHandler.internalError();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Integer id){
        try {
            return artistService.getById(id)
                    .map(ArtistReponse::from)
                    .map(ResponseHandler::success)
                    .orElseGet(ResponseHandler::notFound);
        }
        catch (IllegalArgumentException e){
            return ResponseHandler.badRequest(e.getMessage());
        }
        catch (Exception e){
            return ResponseHandler.internalError();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Object> addArtist(@RequestBody CreateArtistRequest artistRequest){
        try {
            val artist = artistService.addArtist(artistRequest.getName());
            return ResponseHandler.success(ArtistReponse.from(artist));
        }
        catch (IllegalArgumentException e){
            return ResponseHandler.badRequest(e.getMessage());
        }
        catch (Exception e){
            return ResponseHandler.internalError();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateArtist(@PathVariable Integer id, @RequestBody UpdateArtistRequest updateArtistRequest){
        try {
            artistService.updateArtist(id,updateArtistRequest.getName());
            return ResponseHandler.noContent();
        }
        catch (IllegalArgumentException e){
            return ResponseHandler.badRequest(e.getMessage());
        }
        catch (Exception e){
            return ResponseHandler.internalError();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteArtist(@PathVariable Integer id){
        try {
            artistService.deleteArtist(id);
            return ResponseHandler.noContent();
        }
        catch (IllegalArgumentException e){
            //El album ya fue borrado previamente
            return ResponseHandler.noContent();
        }
        catch (Exception e){
            return ResponseHandler.internalError();
        }

    }

}
