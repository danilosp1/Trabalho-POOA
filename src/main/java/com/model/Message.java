package com.model;

import java.util.Date;
import java.util.UUID;

public class Message {
    private UUID id;
    private User sender;
    private String content;
    private Date time;

    public Message(User sender, String content, Date time) {
        this.id = UUID.randomUUID();
        this.sender = sender;
        this.content = content;
        this.time = time;
    }

    public UUID getId() {
        return id;
    }

    public User getSender() {
        return sender;
    }

    public String getContent() {
        return content;
    }

    public Date getTime() {
        return time;
    }
}
