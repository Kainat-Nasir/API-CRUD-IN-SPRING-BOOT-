package com.joblisting.joblistingApp.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;
@Document(collection = "JobPost")
@Data                                           // FOR GETTER SETTERS
public class Post {
    private String id;
    private String profile;
    private String desc;
    private int exp;
    private String techs[];
}
