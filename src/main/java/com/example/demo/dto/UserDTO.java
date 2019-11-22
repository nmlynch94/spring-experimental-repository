package com.example.demo.dto;

import java.io.Serializable;

public class UserDTO extends DTOObject implements Serializable {

    private Long id;

    private String username;

    private String matchStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMatchStatus() {
        return matchStatus;
    }

    public void setMatchStatus(String matchStatus) {
        this.matchStatus = matchStatus;
    }
}
