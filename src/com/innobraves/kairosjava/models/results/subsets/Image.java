package com.innobraves.kairosjava.models.results.subsets;

import javax.json.JsonObject;

/**
 * @author Hex-3-En
 * @version 0.0.1
 */
public class Image {
    private Attributes attributes;
    private Transaction transaction;

    private Image(){}

    public Attributes getAttributes() {
        return attributes;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public static Image create(JsonObject raw){
        Image image = new Image();
        image.attributes = Attributes.create(raw);
        image.transaction = Transaction.create(raw);
        return image;
    }
}
