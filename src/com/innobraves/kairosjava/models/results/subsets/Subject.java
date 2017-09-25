package com.innobraves.kairosjava.models.results.subsets;

import javax.json.JsonObject;

/**
 * Representation of a single subject in a gallery
 * @author P. Willnow
 * @version 0.0.1
 */
public class Subject {
    private String faceId;
    private long enrollmentTimestamp;

    /**
     * Empty private constructor, so it can't be called from outside the class.
     */
    private Subject(){}

//--------------------------------------------------------------------------------------------------------
//---------------------------Getters and Setters for all fields in this class-----------------------------
//--------------------------------------------------------------------------------------------------------
    public String getFaceId() {
        return faceId;
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
    public static Subject create(JsonObject raw){
        Subject sub = new Subject();
        sub.faceId = raw.getJsonString("face_id").getString();
        sub.enrollmentTimestamp = Long.parseLong(raw.getJsonString("enrollment_timestamp").getString());
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
