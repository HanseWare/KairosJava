package com.innobraves.kairosjava.models.results.subsets;

import javax.json.JsonObject;

/**
 * Representation of recognized candidate
 * @author P. Willnow
 * @version 0.0.1
 */
public class Candidate {
    private String subjectId;
    private double confidence;
    private long enrollmentTimestamp;

    /**
     * Empty private constructor, so it can't be called from outside the class.
     */
    private Candidate(){}
//--------------------------------------------------------------------------------------------------------
//---------------------------Getters and Setters for all fields in this class-----------------------------
//--------------------------------------------------------------------------------------------------------
    public String getSubjectId() {
        return subjectId;
    }

    public double getConfidence() {
        return confidence;
    }

    public long getEnrollmentTimestamp() {
        return enrollmentTimestamp;
    }
//--------------------------------------------------------------------------------------------------------
//--------------------------------------End of Getters and Setters----------------------------------------
//--------------------------------------------------------------------------------------------------------

    /**
     * Creator method, taking raw JSON data and filling fields with it
     * @param raw raw JSON data with result data
     * @return instance of this class filled with data
     */
    public static Candidate create(JsonObject raw){
        Candidate cand = new Candidate();
        cand.subjectId = raw.getJsonString("subject_id").getString();
        cand.confidence = raw.getJsonNumber("confidence").doubleValue();
        cand.enrollmentTimestamp = Long.parseLong(raw.getJsonString("enrollment_timestamp").getString());
        return cand;
    }

    @Override
    public String toString() {
        return "Candidate{\n" +
                "subjectId:\t'" + subjectId + '\'' + "\n" +
                "confidence:\t" + confidence + "\n" +
                "enrollmentTimestamp:\t" + enrollmentTimestamp + "\n" +
                '}';
    }
}
