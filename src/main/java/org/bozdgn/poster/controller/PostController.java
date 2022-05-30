package org.bozdgn.poster.controller;

import org.bozdgn.poster.dao.PostRepository;
import org.bozdgn.poster.dto.PostRequestModel;
import org.bozdgn.poster.model.Category;
import org.bozdgn.poster.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class PostController {

    @Autowired
    PostRepository postRepository;

    @GetMapping("/posts")
    public List<Post> listPosts() {
        var result = new ArrayList<Post>();
        postRepository.findAll().forEach(result::add);

        return result;
    }
    @GetMapping("/posts/latest")
    public List<Post> getLatestPosts() {
        return postRepository.findFirst3ByOrderByCreatedAtDesc();
    }

    @GetMapping("/posts/{id}")
    public Post showPost(@PathVariable Long id) {
        Optional<Post> result = postRepository.findById(id);
        return result.orElse(null);
    }

    @GetMapping({"/posts/of/{author}",
            "/posts/by/author/{author}"})
    public List<Post> findPostByAuthor(@PathVariable String author) {
        return postRepository.findByAuthor(author);
    }

    @GetMapping({"/posts/in/{category}",
            "/posts/by/category/{category}"})
    public List<Post> findPostBCategory(@PathVariable Category category) {
        return postRepository.findByCategoriesContaining(category);
    }

    @PostMapping("/posts")
    public Post createPost(@RequestBody PostRequestModel postRequest) {
        var post = new Post(
                postRequest.author(),
                postRequest.title(),
                LocalDate.now(),
                postRequest.author(),
                LocalDate.now(),
                postRequest.author(),
                postRequest.text(),
                postRequest.categories());

        postRepository.save(post);
        return post;
    }

    @PutMapping("/posts/{id}")
    public Post updatePost(
            @PathVariable Long id,
            @RequestBody PostRequestModel postRequest
    ) {
        var potentialPost = postRepository.findById(id);

        if(potentialPost.isPresent()) {
            var post = potentialPost.get();
            post.setTitle(postRequest.title());
            post.setUpdatedAt(LocalDate.now());
            post.setUpdatedBy(postRequest.author());
            post.setText(postRequest.text());

            return post;
        } else {
            throw new IllegalStateException("Attempting to modify a non-existent post.");
        }
    }
}
