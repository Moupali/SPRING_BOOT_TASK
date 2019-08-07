package com.stackroute.Muzixapp.controller;

import com.stackroute.Muzixapp.domain.Track;
import com.stackroute.Muzixapp.exception.TrackNotFoundException;
import com.stackroute.Muzixapp.exception.UserAlreadyExistsException;
import com.stackroute.Muzixapp.service.TrackService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v2")
public class  TrackController {
    private TrackService trackService;
    
    @Autowired
    public TrackController(TrackService trackService)
    {
        this.trackService=trackService;
    }

    @PostMapping("track")
    public ResponseEntity<?> saveUser(@RequestBody Track track){
        ResponseEntity responseEntity;
        try{
            trackService.saveTrack(track);
            responseEntity=new ResponseEntity<String>("successfully created", HttpStatus.CREATED);
        }
        catch(UserAlreadyExistsException ex){
            responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @GetMapping("track")
    public ResponseEntity<?> getTracks() {
        return new ResponseEntity<List<Track>>(trackService.getAllTracks(),HttpStatus.OK);
    }
    @DeleteMapping("track/{id}")
    public ResponseEntity<?> deleteTrack(@PathVariable(value = "id")int id){
        trackService.deleteTrack(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("track")
    public ResponseEntity<Track> updateUser(@RequestBody Track track){
        trackService.updateTrack(track);
        return new ResponseEntity<Track>(track,HttpStatus.OK);
    }

 
    @PutMapping(value = "/update")
    public ResponseEntity<?> updateTrack(@RequestBody Track track)
    {
        ResponseEntity responseEntity;
        try
        {
            trackService.saveTrack(track);
            responseEntity=new ResponseEntity<String>("Succesfully Updated",HttpStatus.CREATED);
        }
        catch(Exception e)
        {
            responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @PostMapping("tracks")
    public ResponseEntity<?> getTracks(@RequestBody List<Track> track) throws RuntimeException, UserAlreadyExistsException {
        ResponseEntity responseEntity;
        for(Track t:track) {
            trackService.saveTrack(t);
        }
        responseEntity = new ResponseEntity<List<Track>>(trackService.getAllTracks(), HttpStatus.CREATED);
        return responseEntity;
    }

}

