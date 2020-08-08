package edu.educationapi.educationapi.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long videoId;

    private String videoName;

    private String videoType;

    @Lob
    private byte[] videoData;

    @JsonManagedReference
    @ManyToOne
    private Section section;
}
