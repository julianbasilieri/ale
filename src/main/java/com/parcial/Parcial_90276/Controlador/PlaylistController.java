package com.parcial.Parcial_90276.Controlador;

import com.parcial.Parcial_90276.Dominio.Service.PlaylistService;
import com.parcial.Parcial_90276.Request.CreatePlaylistFullRequest;
import com.parcial.Parcial_90276.Request.CreatePlaylistRequest;
import com.parcial.Parcial_90276.Request.UpdatePlaylistRequest;
import com.parcial.Parcial_90276.Response.PlaylistFullResponse;
import com.parcial.Parcial_90276.Response.PlaylistResponse;
import com.parcial.Parcial_90276.ResponseHandler;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("/api/playlist")
public class PlaylistController {

    @Autowired
    PlaylistService playlistService;

    @GetMapping("/")
    public ResponseEntity<Object> getAll(){
        try {
            val playlists = playlistService.getAll()
                    .stream()
                    .map(PlaylistResponse::from)
                    .toList();
            return ResponseHandler.success(playlists);
        }
        catch (Exception e){
            return ResponseHandler.internalError();
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Integer id){
        try {
            return playlistService.getById(id)
                    .map(PlaylistResponse::from)
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
    public ResponseEntity<Object> addPlaylist(@RequestBody CreatePlaylistRequest playlistRequest){
        try {
            val playlist = playlistService.addPlaylist(playlistRequest.getName());
            return ResponseHandler.success(PlaylistResponse.from(playlist));
        }
        catch (IllegalArgumentException e){
            return ResponseHandler.badRequest(e.getMessage());
        }
        catch (Exception e){
            return ResponseHandler.internalError();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePlaylist(@PathVariable Integer id, @RequestBody UpdatePlaylistRequest updatePlaylistRequest){
        try {
            playlistService.updatePlaylist(id, updatePlaylistRequest.getName());
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
    public ResponseEntity<Object> deletePlaylist(@PathVariable Integer id){
        try {
            playlistService.deletePlaylist(id);
            return ResponseHandler.noContent();
        }
        catch (IllegalArgumentException e){
            return ResponseHandler.noContent();
        }
        catch (Exception e){
            return ResponseHandler.internalError();
        }
    }

    @PutMapping
    public ResponseEntity<Object> createPlaylist(@RequestBody CreatePlaylistFullRequest createPlaylistFullRequest){
        try {
            val playlist = playlistService.createPlaylist(createPlaylistFullRequest.getNombre(),
                    createPlaylistFullRequest.getArtistId(), createPlaylistFullRequest.getGenreId(),
                    createPlaylistFullRequest.getMinutos());
            return ResponseHandler.success(PlaylistFullResponse.from(playlist));
        }
        catch (IllegalArgumentException e){
            return ResponseHandler.noContent();
        }
        catch (Exception e){
            return ResponseHandler.internalError();
        }
    }
}
