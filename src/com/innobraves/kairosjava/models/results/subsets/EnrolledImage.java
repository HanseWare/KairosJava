package com.innobraves.kairosjava.models.results.subsets;

import javax.json.JsonObject;

/**
 * @author Hex-3-En
 * @version 0.0.1
 */
public class EnrolledImage {
    private Attributes attributes;
    private Transaction transaction;

    private EnrolledImage(){}

    public Attributes getAttributes() {
        return attributes;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public static EnrolledImage create(JsonObject raw){
        EnrolledImage enrolledImage = new EnrolledImage();
        enrolledImage.attributes = Attributes.create(raw.getJsonObject("attributes"));
        enrolledImage.transaction = Transaction.create(raw.getJsonObject("transaction"));
        return enrolledImage;
    }

    @Override
    public String toString() {
        return "Enrolled Image:\n" +
                this.attributes + this.transaction + "\n";
    }
}
