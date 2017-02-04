package com.lpaulino.memetrix.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Luis Alonso Paulino Flores on 3/02/17.
 */

public class Group {

    private String name;
    private String description;
    private String image;
    private int members;
    private List<Meme> memes;

    public Group(String name, String description, int members, String image, List<Meme> memes) {
        this.name = name;
        this.description = description;
        this.members = members;
        this.image = image;
        this.memes = memes;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getMembers() {
        return members;
    }

    public String getImage() {
        return image;
    }

    public List<Meme> getMemes() {
        return memes;
    }

    public void addMeme(Meme meme) {
        if (memes == null) {
            memes = new ArrayList<>();
        }
        memes.add(meme);
        meme.setGroup(this);
    }

    public void setMemes(List<Meme> memes) {
        this.memes = memes;
    }

    public static Group mock() {
        List<Meme> memes = Meme.mocks();
        Group group = new Group("FIS", "Memes creados durante las horas de trabajo en FIS xD", 80,
                "https://mobilepaymentconference.com/sites/mobilepaymentconference.com/files/styles/large/public/2619FIS_Logo_0.png?itok=zhO0kyUM", Meme.mocks());
        for (Meme meme : memes) {
            meme.setGroup(group);
        }
        return group;
    }

    public static List<Group> mocks() {
        List<Group> groups = new ArrayList<>();
        final int total = 5;
        for (int i = 0; i < total; ++i) {
            groups.add(Group.mock());
        }
        return groups;
    }
}
