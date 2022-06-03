package org.bozdgn.poster.dto;

import org.bozdgn.poster.model.Category;

import java.util.ArrayList;
import java.util.List;

// NOTE(bora): This is the required fields for creating/altering a `Post`.
// Automatically-generated fields are omitted. This is used in controller
// where the API accepts input in form of a `Post`.
public class PostRequestModel {
    private final String author;
    private final String title;
    private final String text;
    private final List<Category> categories = new ArrayList<>();

    public PostRequestModel(
            String author,
            String title,
            String text,
            List<Category> categories) {
        this.author = author;
        this.title = title;
        this.text = text;
        this.categories.addAll(categories);
    }


    public String author() {
        return author;
    }

    public String title() {
        return title;
    }

    public String text() {
        return text;
    }

    public List<Category> categories() {
        return categories;
    }
}
