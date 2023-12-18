package com.kosthi.movieticketsystem.entity;

import java.io.Serializable;

public class TicketCountRequest implements Serializable {
    private String movieName;

    private Integer count;

    public TicketCountRequest(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
