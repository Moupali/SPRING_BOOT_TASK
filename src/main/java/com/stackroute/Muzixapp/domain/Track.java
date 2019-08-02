package com.stackroute.Muzixapp.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Data
@NoArgsConstructor
@Document(collection = "track")
@Builder
@AllArgsConstructor

public class Track  {
    @Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
    int trackId;
    @JsonProperty("name")
    String trackName;
    String trackComments;


}