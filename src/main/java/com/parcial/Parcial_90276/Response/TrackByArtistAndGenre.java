package com.parcial.Parcial_90276.Response;

import com.parcial.Parcial_90276.Dominio.Models.Track;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TrackByArtistAndGenre {
    Integer trackId;
    String name;
    String albumTitle;
    String artistName;
    Integer milliseconds;

    public static TrackByArtistAndGenre from (Track track){
        return TrackByArtistAndGenre.builder()
                .trackId(track.getId())
                .name(track.getName())
                .albumTitle(track.getAlbum().getTitle())
                .artistName(track.getAlbum().getArtist().getName())
                .milliseconds(track.getMilliseconds())
                .build();
    }

}
