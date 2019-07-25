package com.stackroute.Muzixapp.service;

import com.stackroute.Muzixapp.domain.Track;
import com.stackroute.Muzixapp.exception.TrackNotFoundException;
import com.stackroute.Muzixapp.exception.UserAlreadyExistsException;
import com.stackroute.Muzixapp.exception.UserAlreadyExistsException;
import com.stackroute.Muzixapp.exception.TrackNotFoundException;
import com.stackroute.Muzixapp.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@PropertySource("classpath:application.properties")
public class TrackServiceImpl implements TrackService{
    @Value("${Track.trackId}")
    int trackId;
    @Value("${Track.trackName}")
    String trackName;
    @Value("${Track.trackComments}")
    String trackComments;
    TrackRepository trackRepository;
    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository)
    {
        this.trackRepository=trackRepository;
    }
    @Override
    public Track saveTrack(Track track)  throws UserAlreadyExistsException {
        if (trackRepository.existsById(track.getTrackId())){ ;
            throw new UserAlreadyExistsException("track already exists");
        }
        Track savedTrack = trackRepository.save(track);
        if(savedTrack==null){
            throw new UserAlreadyExistsException("Track already exists");
        }
        return savedTrack;
    }

    @Override
    public List<Track> getAllTracks()
    {
        Track t=new Track(trackId,trackName,trackComments);
        trackRepository.save(t);
        return trackRepository.findAll();
    }

    @Override
    public Track getTrackById(int id) throws TrackNotFoundException
    {
        if(!trackRepository.findById(id).isPresent()) {
            throw new TrackNotFoundException("Does not exist");
        }
        return trackRepository.getOne(id);
    }

    @Override
    public void deleteTrack(int id){
        trackRepository.deleteById(id);
    }
    @Override
    public Track updateTrack(Track track){
        return trackRepository.save(track);
    }

    @Override
    public List<Track> findByName(String name) {
        return trackRepository.findByName(name);
    }

}