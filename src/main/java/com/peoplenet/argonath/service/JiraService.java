package com.peoplenet.argonath.service;

import com.peoplenet.argonath.dao.JiraDao;
import com.peoplenet.argonath.model.Backlog;
import com.peoplenet.argonath.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Created by mporter on 8/25/16.
 */
@Component
public class JiraService {

    @Autowired
    JiraDao jiraDao;

    public Backlog getProjectBacklog(Project project) {
        return jiraDao.getBacklog(project);
    }

    public ArrayList<Project> getProjects() {
        return jiraDao.getProjects();
    }

}
