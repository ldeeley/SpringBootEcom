package com.example.springbootecom.controller;

import com.example.springbootecom.dto.AlbumDTORequest;
import com.example.springbootecom.dto.AlbumDTOResponse;
import com.example.springbootecom.dto.ServiceResponse;
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
    public ServiceResponse<AlbumDTOResponse> findAlbumById(@PathVariable Integer id){
        AlbumDTOResponse albumDTOResponse = albumService.findAlbumById(id);
        return new ServiceResponse<>(HttpStatus.OK,albumDTOResponse);
    }

    @PostMapping
    public ServiceResponse<AlbumDTOResponse> saveAlbumById(@RequestBody AlbumDTORequest albumDTORequest){
        AlbumDTOResponse newAlbumDTOResponse = albumService.addNewAlbum(albumDTORequest);
        return new ServiceResponse<>(HttpStatus.CREATED,newAlbumDTOResponse);
    }

    @GetMapping()
    public ServiceResponse<List<AlbumDTOResponse>> findAllAlbums(){
        List<AlbumDTOResponse> albumlist = albumService.findAllAlbums();
        return new ServiceResponse<>(HttpStatus.OK,albumlist);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAlbumById(@PathVariable Integer id){
        albumService.deleteAlbumById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PutMapping("/{id}")
    public ServiceResponse<AlbumDTOResponse> updateAlbumById(@PathVariable Integer id, @RequestBody AlbumDTORequest albumDTORequest){
        AlbumDTOResponse albumDTOResponse = albumService.updateAlbum(id,albumDTORequest);
        return new ServiceResponse<>(HttpStatus.OK,albumDTOResponse);
    }

}
