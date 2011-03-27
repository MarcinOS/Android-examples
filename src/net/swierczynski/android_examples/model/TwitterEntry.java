package net.swierczynski.android_examples.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TwitterEntry {
    @JsonProperty("from_user")
    private String fromUser;

    @JsonProperty
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("From: ").append(this.getFromUser()).append("\n");
        stringBuilder.append("Message: ").append(this.getText()).append("\n");
        stringBuilder.append("\n\n");
        return stringBuilder.toString();
    }
}
