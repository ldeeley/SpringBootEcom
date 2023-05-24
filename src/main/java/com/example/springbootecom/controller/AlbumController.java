package com.example.springbootecom.controller;

import com.example.springbootecom.dto.AlbumDTO;
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
        AlbumDTO albumDTO = albumService.findAlbumById(id);
        return new ResponseEntity<>(albumDTO,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveAlbumById(@RequestBody AlbumDTO albumDTO){
        AlbumDTO newAlbumDTO = albumService.addNewAlbum(albumDTO);
        return new ResponseEntity<>(newAlbumDTO, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<?> findAllAlbums(){
        List<AlbumDTO> albumlist = albumService.findAllAlbums();
        return new ResponseEntity<>(albumlist,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAlbumById(@PathVariable Integer id){
        albumService.deleteAlbumById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateAlbumById(@PathVariable Integer id, @RequestBody AlbumDTO albumDTO){
        return new ResponseEntity<>(albumService.updateAlbum(id, albumDTO),HttpStatus.OK);
    }

}
