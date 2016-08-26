package com.peoplenet.argonath.model;

import org.springframework.stereotype.Component;

/**
 * Created by mporter on 8/26/16.
 */
@Component
public class Project {

    public Project() {}

    public Project(String name) {
        this.name = name;
    }

    public Project(String name, String id, String key) {
        this.name=name;
        this.id=id;
        this.key=key;
    }

    public String name;

    public String id;

    public String key;
}
