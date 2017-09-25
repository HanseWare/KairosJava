package com.innobraves.kairosjava.models.results.subsets;

import javax.json.JsonObject;

/**
 * Representation of enrolled image
 * @author P. Willnow
 * @version 0.0.1
 */
public class EnrolledImage {
    private Attributes attributes;
    private Transaction transaction;

    /**
     * Empty private constructor, so it can't be called from outside the class.
     */
    private EnrolledImage(){}

//--------------------------------------------------------------------------------------------------------
//---------------------------Getters and Setters for all fields in this class-----------------------------
//--------------------------------------------------------------------------------------------------------
    public Attributes getAttributes() {
        return attributes;
    }

    public Transaction getTransaction() {
        return transaction;
    }
//--------------------------------------------------------------------------------------------------------
//--------------------------------------End of Getters and Setters----------------------------------------
//--------------------------------------------------------------------------------------------------------

    /**
     * Creator method, taking raw JSON data and filling fields with it
     * @param raw raw JSON data with result data
     * @return instance of this class filled with data
     */
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
