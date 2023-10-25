package com.parcial.Parcial_90276.Response;

import com.parcial.Parcial_90276.Dominio.Models.Playlist;
import com.parcial.Parcial_90276.Dominio.Models.Track;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.stream.Stream;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlaylistFullResponse {
    String name;
    Integer artistId;
    Integer genreId;
    Stream<String> tracks;

    public static PlaylistFullResponse from (Playlist playlist){
        PlaylistFullResponseBuilder builder = PlaylistFullResponse.builder()
                .name((playlist.getName()))
//                .artistId(playlist.getTracks().get(0).getAlbum().getArtist().getId())
//                .genreId(playlist.getTracks().get(0).getGenre().getId())
                .tracks(playlist.getTracks().stream().map(Track::getName));

        if (!playlist.getTracks().isEmpty()){
            builder.artistId(playlist.getTracks().get(0).getAlbum().getArtist().getId())
            .genreId(playlist.getTracks().get(0).getGenre().getId());
        }
        else {
            builder.artistId(null);
            builder.genreId(null);
        }

        return builder.build();
    }
}
