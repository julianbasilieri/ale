package com.parcial.Parcial_90276.Controlador;

import com.parcial.Parcial_90276.Dominio.Service.AlbumService;
import com.parcial.Parcial_90276.Request.CreateAlbumRequest;
import com.parcial.Parcial_90276.Request.UpdateAlbumRequest;
import com.parcial.Parcial_90276.Response.AlbumByArtistResponse;
import com.parcial.Parcial_90276.Response.AlbumResponse;
import com.parcial.Parcial_90276.ResponseHandler;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("/api/album")
public class AlbumController {

    @Autowired
    AlbumService albumService;

    @GetMapping("/")
    public ResponseEntity<Object> getAll(){
        try {
            val albums = albumService.getAll()
                    .stream()
                    .map(AlbumResponse::from)
                    .toList();
            return ResponseHandler.success(albums);

        }
        catch (Exception e){
            return ResponseHandler.internalError();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Integer id){
        try {
            return albumService.getById(id)
                    .map(AlbumResponse::from)
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
    public ResponseEntity<Object> addAlbum(@RequestBody CreateAlbumRequest albumRequest){
        try {
            val album = albumService.addAlbum(albumRequest.getTitle(),albumRequest.getArtistId());
            return ResponseHandler.success(AlbumResponse.from(album));
        }
        catch (IllegalArgumentException e){
            return ResponseHandler.badRequest(e.getMessage());
        }
        catch (Exception e){
            return ResponseHandler.internalError();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateAlbum(@PathVariable Integer id, @RequestBody UpdateAlbumRequest updateAlbumRequest){
        try {
            albumService.updateAlbum(id,updateAlbumRequest.getTitle(),updateAlbumRequest.getArtistId());
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
    public ResponseEntity<Object> deleteAlbum(@PathVariable Integer id){
        try {
            albumService.deleteAlbum(id);
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
