package com.codeclan.mvpizza.models;

public class Cooking {


    private boolean cooked = false;

    private String messageForFrontEnd;

    public Cooking() {

    }


    public boolean isCooked() {
        return cooked;
    }

    public void setCooked(boolean cooked) {
        this.cooked = cooked;
    }

    public String getMessageForFrontEnd() {
        return messageForFrontEnd;
    }

    public void setMessageForFrontEnd(String messageForFrontEnd) {
        this.messageForFrontEnd = messageForFrontEnd;
    }

}
