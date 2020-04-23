package br.com.btg.game.jokenpo.dto.api;

import java.sql.Timestamp;

public class Meta {

    private Timestamp timestamp;
    private String status;

    public Meta() {}

    public Meta(Timestamp timestamp, String status) {
        this.timestamp = timestamp;
        this.status = status;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
