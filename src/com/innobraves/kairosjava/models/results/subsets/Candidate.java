package com.innobraves.kairosjava.models.results.subsets;

import javax.json.JsonObject;

/**
 * @author Hex-3-En
 * @version 0.0.1
 */
public class Candidate {
    private String subjectId;
    private double confidence;
    private long enrollmentTimestamp;

    private Candidate(){}

    public String getSubjectId() {
        return subjectId;
    }

    public double getConfidence() {
        return confidence;
    }

    public long getEnrollmentTimestamp() {
        return enrollmentTimestamp;
    }

    public static Candidate create(JsonObject raw){
        Candidate cand = new Candidate();
        cand.subjectId = raw.getJsonString("subject_id").getString();
        cand.confidence = raw.getJsonNumber("confidence").doubleValue();
        cand.enrollmentTimestamp = raw.getJsonNumber("enrollment_timestamp").longValue();
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
