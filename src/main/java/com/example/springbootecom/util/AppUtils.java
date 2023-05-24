package com.example.springbootecom.util;

import com.example.springbootecom.dto.AlbumDTORequest;
import com.example.springbootecom.dto.AlbumDTOResponse;
import com.example.springbootecom.model.AlbumEntity;

public class AppUtils {

    public static AlbumEntity mapAlbumDTORequestToAlbumEntity(AlbumDTORequest albumDTORequest){
        return AlbumEntity.builder()
                .albumTitle(albumDTORequest.getAlbumTitle())
                .artist(albumDTORequest.getArtist())
                .releaseDate(albumDTORequest.getReleaseDate())
                .price(albumDTORequest.getPrice())
                .build();
    }

    public static AlbumDTOResponse mapAlbumEntityToAlbumDTOResponse(AlbumEntity albumEntity){
        return AlbumDTOResponse.builder()
                .albumTitle(albumEntity.getAlbumTitle())
                .artist(albumEntity.getArtist())
                .releaseDate(albumEntity.getReleaseDate())
                .price(albumEntity.getPrice())
                .build();
    }

}
