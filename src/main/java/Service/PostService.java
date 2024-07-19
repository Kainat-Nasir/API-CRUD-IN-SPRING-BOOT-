package Service;

import com.joblisting.joblistingApp.PostRepository;
import com.joblisting.joblistingApp.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }


    public Post addPost(Post post) {
        return postRepository.save(post);
    }


    public Post updatePost(Post post) {
        Optional<Post> update = postRepository.findById(post.getId());

        if (post.getId() == null || update.isEmpty()) {
            System.out.println("No record found!");
            return null;
        }

        return postRepository.save(post);
    }


    public String deletePost(String id) {
        Optional<Post> post = postRepository.findById(String.valueOf(id));

        if (post.isEmpty()) {
            return "No record found!";
        }

        postRepository.deleteById(String.valueOf(id));
        return "Post deleted successfully!";
    }
}
