package com.peoplenet.argonath.controller;

import com.peoplenet.argonath.model.Project;
import com.peoplenet.argonath.service.JiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Created by mporter on 8/26/16.
 */
@RestController
public class ProjectController {

    @Autowired
    JiraService jiraService;

    @RequestMapping(value="/projects", method=RequestMethod.GET)
    ResponseEntity<?> getProjects() {
        ArrayList<Project> projects = jiraService.getProjects();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }


}
