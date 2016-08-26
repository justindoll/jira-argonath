package com.peoplenet.argonath.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Created by mporter on 8/26/16.
 */

@Component
public class Story {

    public String id;
    public String description;
    public ArrayList<String> acceptanceCriteria;

}
