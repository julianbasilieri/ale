package com.parcial.Parcial_90276.Response;

import com.parcial.Parcial_90276.Dominio.Models.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.stream.Stream;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TrackResponse {
    Integer id;
    String name;
    String album;
    Media_type mediaType;
    Genre genre;
    String composer;
    Integer milliseconds;
    Integer bytes;
    Float unitPrice;
    Stream<String> playlists;

//    public static TrackResponse from (Track track){
//        return TrackResponse.builder()
//                .id(track.getId())
//                .name(track.getName())
//                .album(track.getAlbum().getTitle())
//                .mediaType(track.getMediaType())
//                .genre(track.getGenre())
//                .composer(track.getComposer())
//                .milliseconds(track.getMilliseconds())
//                .bytes(track.getBytes())
//                .unitPrice(track.getUnitPrice())
//                .playlists(track.getPlaylists().stream().map(Playlist::getName))
//                .build();
//    }

    public static TrackResponse from(Track track) {
        TrackResponseBuilder builder = TrackResponse.builder()
                .id(track.getId())
                .name(track.getName())
                .mediaType(track.getMediaType())
                .genre(track.getGenre())
                .composer(track.getComposer())
                .milliseconds(track.getMilliseconds())
                .bytes(track.getBytes())
                .unitPrice(track.getUnitPrice());

        if (track.getAlbum() != null) {
            builder.album(track.getAlbum().getTitle());
        }
        else {
            //Si no hay album asigno null
            builder.album(null);
        }

        if (track.getPlaylists() != null) {
            builder.playlists(track.getPlaylists().stream().map(Playlist::getName));
        }
        else {
            //Si no hay playlists asigno empty
            builder.playlists(Stream.empty());
        }

        return builder.build();
    }


}