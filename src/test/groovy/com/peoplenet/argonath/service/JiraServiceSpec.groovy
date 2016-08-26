package com.peoplenet.argonath.service

import com.peoplenet.argonath.dao.JiraDao
import com.peoplenet.argonath.model.Backlog
import com.peoplenet.argonath.model.Project
import org.springframework.beans.factory.annotation.Autowired
import spock.lang.Specification


/**
 * Created by mporter on 8/26/16.
 */
class JiraServiceSpec extends Specification{


    JiraService jiraService
    JiraDao jiraDao

    def setup() {
        jiraService = new JiraService()
        jiraDao = Mock(JiraDao)
        jiraService.jiraDao=jiraDao
    }

    def "Test that I can get a backlog"() {
        given: "I have a jira service"
        jiraService!=null
        when: "I call the get backlog method"
        Project p = new Project()
        Backlog b = jiraService.getProjectBacklog(p)
        then: "The backlog exists and has stories."
        1 * jiraDao.getBacklog(_) >> new Backlog()
    }

    def "Test that I can get a list of projects"() {
        given: "I have access to a jiraService"
        jiraService!=null;
        when: "I call getProjects"
        ArrayList<Project> projects = jiraService.getProjects()
        then:
        1 * jiraDao.getProjects() >> getFakeProjectList()
        projects.size()==3
    }

    def getFakeProjectList() {
        ArrayList<Project> projects = new ArrayList<>()
        projects.add(new Project("Fake Project 1"))
        projects.add(new Project("Fake Project 2"))
        projects.add(new Project("Fake Project 3"))
        return projects
    }

}
