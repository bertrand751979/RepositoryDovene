package com.example.repositorydovene.model;

import java.io.Serializable;

public class Repos implements Serializable {
    private String name;
    private String html_url;

    public Repos(String name, String html_url) {
        this.name = name;
        this.html_url = html_url;
    }

    public Repos(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }
}
