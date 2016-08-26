package com.peoplenet.argonath.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Created by mporter on 8/26/16.
 */
@Configuration
public class JiraConfig {

    @Value("${jira.server}")
    public String server;

    @Value("${jira.username}")
    public String username;

    @Value("${jira.password}")
    public String password;

    @Value("${jira.apiPath}")
    public String apiPath;
}
