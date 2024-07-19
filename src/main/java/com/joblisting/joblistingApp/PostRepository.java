package com.joblisting.joblistingApp;

import com.joblisting.joblistingApp.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends MongoRepository<Post,String> {

}
