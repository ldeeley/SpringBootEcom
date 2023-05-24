package com.example.springbootecom.service;

import com.example.springbootecom.dto.AlbumDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AlbumService {

    private List<AlbumDTO> albumDTOList = new ArrayList<>();

//    save Album to DB
    public AlbumDTO addNewAlbum(AlbumDTO albumDTO){
        albumDTO.setAlbumID(new Random().nextInt(3756));
        albumDTOList.add(albumDTO);
        return albumDTO;
    }

//    return All Albums in DB
    public List<AlbumDTO> findAllAlbums(){
        return albumDTOList;
    }

//    find an Album by ID - or else Null (handle this later)
    public AlbumDTO findAlbumById(Integer albumId){
        return albumDTOList.stream().filter(albumDTO -> albumDTO.getAlbumID()==albumId).findFirst().orElse(null);
    }

    public void deleteAlbumById(Integer albumId){
        AlbumDTO albumDTO =findAlbumById(albumId);
        albumDTOList.remove(albumDTO);
    }

    public AlbumDTO updateAlbum(Integer albumId, AlbumDTO albumDTO){
        addNewAlbum(albumDTO);
        return albumDTO;
    }

}
