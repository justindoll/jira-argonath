package com.peoplenet.argonath.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mporter on 8/26/16.
 */
@Component
public class Backlog {

    public ArrayList<Story> stories;

    public List<Story> getStories() {
        return stories;
    }

    public void setStories(ArrayList<Story> stories) {
        this.stories = stories;
    }

}
