package com.peoplenet.argonath.dao;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.peoplenet.argonath.config.JiraConfig;
import com.peoplenet.argonath.model.Backlog;
import com.peoplenet.argonath.model.Project;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by mporter on 8/26/16.
 */

@Component
public class JiraDao {

    @Autowired
    JiraConfig jiraConfig;

    int READ_TIME_OUT = 1000;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public Backlog getBacklog(Project p) {
        return new Backlog();
    }

    private RestTemplate getTemplate() {
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setReadTimeout(5000);
        requestFactory.setConnectTimeout(5000);
        return new RestTemplate(requestFactory);
    }

    private static HttpComponentsClientHttpRequestFactory useApacheHttpClientWithSelfSignedSupport() {
        CloseableHttpClient httpClient = HttpClients.custom().setSSLHostnameVerifier(new NoopHostnameVerifier()).build();
        HttpComponentsClientHttpRequestFactory useApacheHttpClient = new HttpComponentsClientHttpRequestFactory();
        useApacheHttpClient.setHttpClient(httpClient);
        return useApacheHttpClient;
    }

    //curl -D- -u mporter:AMac4Me! -X GET -H "content-Type: application/json" https://ejira.trimble.com/rest/api/latest/project
    public ArrayList<Project> getProjects() {
        ArrayList<Project> projects = new ArrayList<>();
        try {

            RestTemplate restTemplate = new RestTemplate(useApacheHttpClientWithSelfSignedSupport());
            String plainCreds = jiraConfig.username + ":" + jiraConfig.password;
            byte[] plainCredsBytes = plainCreds.getBytes();
            byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
            String base64Creds = new String(base64CredsBytes);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", "Basic " + base64Creds);
            HttpEntity<String> request = new HttpEntity<String>(headers);

            String requestUrl = jiraConfig.server + jiraConfig.apiPath + "/project";

            ResponseEntity<String> response = restTemplate.exchange(requestUrl, HttpMethod.GET, request, String.class);

            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response.getBody());


            for(int i=0;i<root.size();i++) {
                try {
                    Project p = new Project(root.get(i).get("name").asText(), root.get(i).get("id").asText(), root.get(i).get("key").asText());
                    projects.add(p);
                } catch (NullPointerException npe) {
                    logger.warn("Skipping project that does not contain id, key or name");
                }

            }

        }
        catch (IOException ioException) {
            //  Logg the error.
        }
        return projects;
    }

}
