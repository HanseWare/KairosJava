package com.innobraves.kairosjava.models.results.subsets;

import javax.json.JsonObject;

/**
 * @author Hex-3-En
 * @version 0.0.1
 */
public class Face {
    private int topLeftX;
    private int topLeftY;
    private int chinTipX;
    private int chinTipY;
    private int leftEyeCenterX;
    private int leftEyeCenterY;
    private int rightEyeCenterX;
    private int rightEyeCenterY;
    private int eyeDistance;
    private int yaw;
    private int pitch;
    private int roll;
    private int height;
    private int width;
    private double quality;
    private double confidence;
    private int faceId;
    private Attributes attributes;

    /**
     * Empty private constructor, so it can't be called from outside the class.
     */
    private Face(){}

//--------------------------------------------------------------------------------------------------------
//---------------------------Getters and Setters for all fields in this class-----------------------------
//--------------------------------------------------------------------------------------------------------
    public int getTopLeftX() {
        return topLeftX;
    }

    public int getTopLeftY() {
        return topLeftY;
    }

    public int getChinTipX() {
        return chinTipX;
    }

    public int getChinTipY() {
        return chinTipY;
    }

    public int getLeftEyeCenterX() {
        return leftEyeCenterX;
    }

    public int getLeftEyeCenterY() {
        return leftEyeCenterY;
    }

    public int getRightEyeCenterX() {
        return rightEyeCenterX;
    }

    public int getRightEyeCenterY() {
        return rightEyeCenterY;
    }

    public int getEyeDistance(){ return eyeDistance; }

    public int getYaw() {
        return yaw;
    }

    public int getPitch() {
        return pitch;
    }

    public int getRoll() {
        return roll;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public double getQuality() {
        return quality;
    }

    public double getConfidence() {
        return confidence;
    }

    public int getFaceId() {
        return faceId;
    }

    public Attributes getAttributes() {
        return attributes;
    }
//--------------------------------------------------------------------------------------------------------
//--------------------------------------End of Getters and Setters----------------------------------------
//--------------------------------------------------------------------------------------------------------

    /**
     * Creator method, taking raw JSON data and filling fields with it
     * @param raw raw JSON data with result data
     * @return instance of this class filled with data
     */
    public static Face create(JsonObject raw){
        Face face = new Face();
        face.topLeftX = raw.getJsonNumber("topLeftX").intValue();
        face.topLeftY = raw.getJsonNumber("topLeftY").intValue();
        face.chinTipX = raw.getJsonNumber("chinTipX").intValue();
        face.chinTipY = raw.getJsonNumber("chinTipY").intValue();
        face.leftEyeCenterX = raw.getJsonNumber("leftEyeCenterX").intValue();
        face.leftEyeCenterY = raw.getJsonNumber("leftEyeCenterY").intValue();
        face.rightEyeCenterX = raw.getJsonNumber("rightEyeCenterX").intValue();
        face.rightEyeCenterY = raw.getJsonNumber("rightEyeCenterY").intValue();
        face.eyeDistance = raw.getJsonNumber("eyeDistance").intValue();
        face.yaw = raw.getJsonNumber("yaw").intValue();
        face.pitch = raw.getJsonNumber("pitch").intValue();
        face.roll = raw.getJsonNumber("roll").intValue();
        face.height = raw.getJsonNumber("height").intValue();
        face.width = raw.getJsonNumber("width").intValue();
        face.quality = raw.getJsonNumber("quality").doubleValue();
        face.confidence = raw.getJsonNumber("confidence").doubleValue();
        face.faceId = raw.getJsonNumber("face_id").intValue();
        face.attributes = Attributes.create(raw.getJsonObject("attributes"));
        return face;
    }


    @Override
    public String toString() {
        return "Face{\n" +
                "topLeftX:\t" + topLeftX + "\n" +
                "topLeftY:\t" + topLeftY + "\n" +
                "chinTipX:\t" + chinTipX + "\n" +
                "chinTipY:\t" + chinTipY + "\n" +
                "leftEyeCenterX:\t" + leftEyeCenterX + "\n" +
                "leftEyeCenterY:\t" + leftEyeCenterY + "\n" +
                "rightEyeCenterX:\t" + rightEyeCenterX + "\n" +
                "rightEyeCenterY:\t" + rightEyeCenterY + "\n" +
                "eyeDistance:\t" + eyeDistance + "\n" +
                "yaw:\t" + yaw + "\n" +
                "pitch:\t" + pitch + "\n" +
                "roll:\t" + roll + "\n" +
                "height:\t" + height + "\n" +
                "width:\t" + width + "\n" +
                "quality:\t" + quality + "\n" +
                "confidence:\t" + confidence + "\n" +
                "faceId:\t" + faceId + "\n" +
                "attributes:\t" + attributes + "\n" +
                '}';
    }
}
