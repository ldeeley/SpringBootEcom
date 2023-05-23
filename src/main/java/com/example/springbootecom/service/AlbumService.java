package com.example.springbootecom.service;

import com.example.springbootecom.dto.Album;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AlbumService {

    private List<Album> albumList = new ArrayList<>();

//    save Album to DB
    public Album addNewAlbum(Album album){
        album.setAlbumID(new Random().nextInt(3756));
        albumList.add(album);
        return album;
    }

//    return All Albums in DB
    public List<Album> findAllAlbums(){
        return albumList;
    }

//    find an Album by ID - or else Null (handle this later)
    public Album findAlbumById(Integer albumId){
        return albumList.stream().filter(album -> album.getAlbumID()==albumId).findFirst().orElse(null);
    }

    public void deleteAlbumById(Integer albumId){
        Album album =findAlbumById(albumId);
        albumList.remove(album);
    }

    public Album updateAlbum(Integer albumId,Album album){
        addNewAlbum(album);
        return album;
    }

}
