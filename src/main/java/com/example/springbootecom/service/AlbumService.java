package com.example.springbootecom.service;

import com.example.springbootecom.dto.AlbumDTORequest;
import com.example.springbootecom.dto.AlbumDTOResponse;
import com.example.springbootecom.model.AlbumEntity;
import com.example.springbootecom.repository.AlbumRepository;
import com.example.springbootecom.util.AppUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AlbumService {

    private AlbumRepository albumRepository;

//    save Album to DB
    public AlbumDTOResponse addNewAlbum(AlbumDTORequest albumDTORequest){
        AlbumEntity albumEntity = albumRepository.save(AppUtils.mapAlbumDTORequestToAlbumEntity(albumDTORequest));
        return AppUtils.mapAlbumEntityToAlbumDTOResponse(albumEntity);
    }

//    return All Albums in DB
    public List<AlbumDTOResponse> findAllAlbums(){
        ArrayList<AlbumEntity> albumEntityList = new ArrayList<>();
        albumRepository.findAll().forEach(albumEntityList::add);
        return albumEntityList.stream().map(AppUtils::mapAlbumEntityToAlbumDTOResponse).collect(Collectors.toList());
    }

//    find an Album by ID - or else Null (handle this later)
    public AlbumDTOResponse findAlbumById(Integer albumId){
        AlbumEntity albumEntity = albumRepository.findById(albumId).orElseThrow(()->new RuntimeException("No such Album with AlbumId "+albumId));
        return AppUtils.mapAlbumEntityToAlbumDTOResponse(albumEntity);
    }

    public void deleteAlbumById(Integer albumId){
        albumRepository.deleteById(albumId);
    }

    public AlbumDTOResponse updateAlbum(Integer albumId, AlbumDTORequest albumDTORequest){
        AlbumEntity albumEntity = albumRepository.save(AppUtils.mapAlbumDTORequestToAlbumEntity(albumDTORequest));
        return AppUtils.mapAlbumEntityToAlbumDTOResponse(albumEntity);
    }

}
