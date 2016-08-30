package org.batch.integration.spring_integration.model;

/**
 * Created by iurii.dziuban on 17.08.2016.
 *
 * Notification message data class to be send
 */
public class Notification {

    private String message;

    private boolean failure;

    public Notification(String message, boolean failure) {
        this.message = message;
        this.failure = failure;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isFailure() {
        return failure;
    }

    public void setFailure(boolean failure) {
        this.failure = failure;
    }

    @Override
    public String toString() {
        return "Notification [message=" + message + ", failure=" + failure
                + "]";
    }
}
