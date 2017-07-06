package com.innobraves.kairosjava.models.results.subsets;

import javax.json.JsonObject;

/**
 * @author Hex-3-En
 * @version 0.0.1
 */
public class Gender {

    private String type;
    private double maleConfidence;
    private double femaleConfidence;
    private Gender(){}

    public String getType() {
        return type;
    }

    public double getMaleConfidence() {
        return maleConfidence;
    }

    public double getFemaleConfidence() {
        return femaleConfidence;
    }

    static Gender create(JsonObject raw){
        Gender gender = new Gender();
        gender.type = raw.getJsonString("type").getString();
        gender.maleConfidence = raw.getJsonNumber("maleConfidence").doubleValue();
        gender.femaleConfidence = raw.getJsonNumber("femaleConfidence").doubleValue();
        return gender;
    }

    @Override
    public String toString() {
        return "Gender{\n" +
                "type:\t'" + type + '\'' + "\n" +
                "maleConfidence:\t" + maleConfidence + "\n" +
                "femaleConfidence:\t" + femaleConfidence + "\n" +
                '}';
    }
}
