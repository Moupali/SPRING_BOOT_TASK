package com.stackroute.Muzixapp.service;

import com.stackroute.Muzixapp.domain.Track;
import com.stackroute.Muzixapp.exception.TrackNotFoundException;
import com.stackroute.Muzixapp.exception.UserAlreadyExistsException;
//import com.stackroute.Muzixapp.exceptions.TrackAlreadyExistsException;

import java.util.List;
import java.util.Optional;

public interface TrackService {
    public Track saveTrack(Track track) throws UserAlreadyExistsException; //throws TrackAlreadyExistsException;
    public List<Track> getAllTracks();
    //public Optional<Track> getTrackById(Integer id) throws TrackNotFoundException;
    public void deleteTrack(int id);
    public Track updateTrack(Track track);
    //public List<Track> findByName(String name);

}
