package com.meetup.hotel_management_system.repository.entity;

public class ExceptionResponse {

    static final long serialVersionUID = -7034897190745766939L;
    private String message;
    private String msgType;

//    public ExceptionResponse(){
//
//    }
    public ExceptionResponse(String message, String msgType) {
        this.message = message;
        this.msgType = msgType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }
}
