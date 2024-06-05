package com.unimag.booking.exceptions.carInventory;

public class CarReserveException extends RuntimeException{

    public CarReserveException() {
        super();
    }

    public CarReserveException(String message) {
        super(message);
    }

    public CarReserveException(String message, Throwable cause) {
        super(message, cause);
    }

    public CarReserveException(Throwable cause) {
        super(cause);
    }

    protected CarReserveException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
