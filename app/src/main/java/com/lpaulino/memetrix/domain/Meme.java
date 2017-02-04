package com.lpaulino.memetrix.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Luis Alonso Paulino Flores on 3/02/17.
 */

public class Meme {

    private String title;
    private String description;
    private String image;
    private Group group;

    public Meme(String title, String description, String image) {
        this.title = title;
        this.description = description;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public static Meme mock() {
        Group group = new Group("My Personal Group", "My Personal Group", 20, "https://mobilepaymentconference.com/sites/mobilepaymentconference.com/files/styles/large/public/2619FIS_Logo_0.png?itok=zhO0kyUM" ,null);
        Meme meme =  new Meme("Meme de Prueba", "Este meme fue construido para la demo de Memetrix",
                "https://i2.wp.com/blogs.techsmith.com/wp-content/uploads/2016/09/generate-a-meme.jpg?resize=855%2C494");
        group.addMeme(meme);
        return meme;
    }

    public static List<Meme> mocks() {
        final int total = 20;
        List<Meme> memes = new ArrayList<>();
        for (int i = 0; i < total; ++i) {
            memes.add(Meme.mock());
        }
        return memes;
    }
}
