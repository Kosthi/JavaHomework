package com.kosthi.movieticketsystem.entity;

import java.io.Serializable;

public class TicketRequest implements Serializable {
    String windowName;

    String movieName;

    String seatName;

    boolean isBuy;

    public TicketRequest(String windowName, String movieName, String seatName, boolean isBuy) {
        this.windowName = windowName;
        this.movieName = movieName;
        this.seatName = seatName;
        this.isBuy = isBuy;
    }

    public String getWindowName() {
        return windowName;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getSeatName() {
        return seatName;
    }

    public boolean isBuy() {
        return isBuy;
    }
}
