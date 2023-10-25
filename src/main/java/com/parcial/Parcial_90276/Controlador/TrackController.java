package com.parcial.Parcial_90276.Controlador;

import com.parcial.Parcial_90276.Dominio.Service.TrackService;
import com.parcial.Parcial_90276.Request.CreateTrackRequest;
import com.parcial.Parcial_90276.Request.UpdateTrackRequest;
import com.parcial.Parcial_90276.Response.TrackByArtistAndGenre;
import com.parcial.Parcial_90276.Response.TrackResponse;
import com.parcial.Parcial_90276.ResponseHandler;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.hibernate.query.QueryParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("/api/track")
public class TrackController {

    @Autowired
    TrackService trackService;

    @GetMapping("/")
    public ResponseEntity<Object> getAll(){
        try {
            val tracks = trackService.getAll()
                    .stream()
                    .map(TrackResponse::from)
                    .toList();
            return ResponseHandler.success(tracks);
        }
        catch (Exception e){
           return ResponseHandler.internalError();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Integer id){
        try {
            return trackService.getById(id)
                    .map(TrackResponse::from)
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
    public ResponseEntity<Object> addTrack(@RequestBody CreateTrackRequest trackRequest){
        try {
            val track = trackService.addTrack(trackRequest.getName(),trackRequest.getMediaTypeId(),trackRequest.getGenreId(),
                    trackRequest.getComposer(),trackRequest.getMilliseconds(),trackRequest.getBytes(),trackRequest.getUnitPrice());
            return ResponseHandler.success(track);
        }
        catch (IllegalArgumentException e){
            return ResponseHandler.badRequest(e.getMessage());
        }
        catch (Exception e){
            return ResponseHandler.internalError();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateTrack(@PathVariable Integer id, @RequestBody UpdateTrackRequest updateTrackRequest){
        try {
            trackService.updateTrack(id,updateTrackRequest.getName(), updateTrackRequest.getMediaTypeId(), updateTrackRequest.getGenreId(),
                    updateTrackRequest.getComposer(), updateTrackRequest.getMilliseconds(), updateTrackRequest.getBytes(),
                    updateTrackRequest.getUnitPrice());
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
    public ResponseEntity<Object> deleteTrack(@PathVariable Integer id){
        try {
            trackService.deleteTrack(id);
            return ResponseHandler.noContent();
        }
        catch (IllegalArgumentException e){
            //El track ya fue borrado previamente
            return ResponseHandler.noContent();
        }
        catch (Exception e){
            return ResponseHandler.internalError();
        }
    }

    @GetMapping("/{idArtist}/{idGenre}")
    public ResponseEntity<Object> getTrackByArtistAndGenre(@PathVariable Integer idArtist, @PathVariable Integer idGenre){
        try {

            val tracks = trackService.getAllByArtistAndGenre(idArtist, idGenre)
                    .stream()
                    .map(TrackByArtistAndGenre::from)
                    .toList();
            return ResponseHandler.success(tracks);
        }
        catch (IllegalArgumentException e){
            return ResponseHandler.badRequest(e.getMessage());
        }
        catch (Exception e){
            return ResponseHandler.internalError();
        }

    }

}
