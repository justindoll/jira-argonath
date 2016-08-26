package com.peoplenet.argonath.dao;

import com.peoplenet.argonath.model.Backlog;
import com.peoplenet.argonath.model.Project;
import org.springframework.stereotype.Component;

/**
 * Created by mporter on 8/26/16.
 */

@Component
public class JiraDao {

    public Backlog getBacklog(Project p) {
        return new Backlog();
    }
}
