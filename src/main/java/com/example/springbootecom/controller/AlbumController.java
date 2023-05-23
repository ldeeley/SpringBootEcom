package com.example.springbootecom.controller;

import com.example.springbootecom.dto.Album;
import com.example.springbootecom.service.AlbumService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/album")
public class AlbumController {


    private AlbumService albumService;

    @GetMapping("/{id}")
    public ResponseEntity<?> findAlbumById(@PathVariable Integer id){
        Album album = albumService.findAlbumById(id);
        return new ResponseEntity<>(album,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveAlbumById(@RequestBody Album album){
        Album newAlbum = albumService.addNewAlbum(album);
        return new ResponseEntity<>(newAlbum, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<?> findAllAlbums(){
        List<Album> albumlist = albumService.findAllAlbums();
        return new ResponseEntity<>(albumlist,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAlbumById(@PathVariable Integer id){
        albumService.deleteAlbumById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateAlbumById(@PathVariable Integer id, @RequestBody Album album){
        return new ResponseEntity<>(albumService.updateAlbum(id,album),HttpStatus.OK);
    }

}
