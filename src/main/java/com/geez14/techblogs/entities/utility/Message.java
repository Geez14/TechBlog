package com.geez14.techblogs.entities.utility;

/**
 * Send Server Message as bootstrap alert dynamically
 */
public class Message {
    private String content;
    private String type;
    private String cssClass;

    public Message() {
        content = "empty message";
        type="";
        cssClass="";
    }
    public Message(String content, String type, String cssClass) {
        this.content = content;
        this.type = type;
        this.cssClass = cssClass;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCssClass() {
        return cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }
}
