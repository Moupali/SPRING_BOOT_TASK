package com.stackroute.Muzixapp.repository;

import com.mongodb.Mongo;
import com.stackroute.Muzixapp.domain.Track;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackRepository extends MongoRepository<Track,Integer>
{


   // @Query("select t from Track t where t.trackName=?1")
     //public List<Track> findByName(String name);
}
