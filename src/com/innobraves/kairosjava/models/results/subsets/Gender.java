package com.innobraves.kairosjava.models.results.subsets;

import javax.json.JsonObject;

/**
 * Representation of gender attribute
 * @author P. Willnow
 * @version 0.0.1
 */
public class Gender {

    private String type;
    private double maleConfidence;
    private double femaleConfidence;

    /**
     * Empty private constructor, so it can't be called from outside the class.
     */
    private Gender(){}

//--------------------------------------------------------------------------------------------------------
//---------------------------Getters and Setters for all fields in this class-----------------------------
//--------------------------------------------------------------------------------------------------------
    public String getType() {
        return type;
    }

    public double getMaleConfidence() {
        return maleConfidence;
    }

    public double getFemaleConfidence() {
        return femaleConfidence;
    }
//--------------------------------------------------------------------------------------------------------
//--------------------------------------End of Getters and Setters----------------------------------------
//--------------------------------------------------------------------------------------------------------

    /**
     * Creator method, taking raw JSON data and filling fields with it
     * @param raw raw JSON data with result data
     * @return instance of this class filled with data
     */
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
