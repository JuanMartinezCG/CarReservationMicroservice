package com.unimag.booking.event;

import java.io.Serializable;

public class CustomEvent implements Serializable {
    
    private String message;

    // Constructor, getters y setters
    public CustomEvent() {
    }

    public CustomEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
