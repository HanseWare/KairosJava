package com.innobraves.kairosjava.models.results.subsets;

import javax.json.JsonObject;

/**
 * @author Hex-3-En
 * @version 0.0.1
 */
public class Subject {
    private String faceId;
    private long enrollmentTimestamp;

    private Subject(){}

    public static Subject create(JsonObject raw){
        Subject sub = new Subject();
        sub.faceId = raw.getJsonString("face_id").getString();
        sub.enrollmentTimestamp = raw.getJsonNumber("enrollment_timestamp").longValue();
        return sub;
    }

    @Override
    public String toString() {
        return "Subject{\n" +
                "faceId:\t'" + faceId + '\'' + "\n" +
                "enrollmentTimestamp:\t" + enrollmentTimestamp + "\n" +
                '}';
    }
}
