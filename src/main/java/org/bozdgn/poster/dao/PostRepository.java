package org.bozdgn.poster.dao;

import org.bozdgn.poster.model.Category;
import org.bozdgn.poster.model.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository
        extends CrudRepository<Post, Long> {
    // NOTE(bora): Metotların içini Spring dolduruyor.
    List<Post> findByAuthor(String author);

    // NOTE(bora): bkz. https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.query-creation
    List<Post> findByCategoriesContaining(Category category);

    // NOTE(bora): Büyücülük resmen..
    List<Post> findFirst3ByOrderByCreatedAtDesc();  // = "get latest 3 posts"
}
