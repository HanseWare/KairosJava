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
    private int yaw;
    private int pitch;
    private int roll;
    private int height;
    private int width;
    private double quality;
    private double confidence;
    private int faceId;
    private Attributes attributes;

    private Face(){}

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
}
