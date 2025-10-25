package org.example.synchronizationBasics.waitnotify;

public class Message {

    private String message;

    public Message(String m){
        this.message = m;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "message='" + message + '\'' +
                '}';
    }


}
