package com.innobraves.kairosjava.models.results;

import com.innobraves.kairosjava.models.Error;
import com.innobraves.kairosjava.models.results.subsets.EnrolledImage;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

/**
 * Representation of an enrollment result
 * @author P. Willnow
 * @version 0.0.1
 */
public class EnrollResult extends Result{
    private String faceId;
    private List<EnrolledImage> enrolledImages;

    /**
     * Constructor to be used in case of an error while executing the request
     * @param error Error received
     */
    public EnrollResult(Error error) {
        super(error);
    }

    /**
     * Constructor handling a HttpResponse after successful receiving a response
     * @param response HTTP response received
     * @throws IOException
     */
    public EnrollResult(HttpResponse response) throws IOException {
        super(response);
    }
//--------------------------------------------------------------------------------------------------------
//---------------------------Getters and Setters for all fields in this class-----------------------------
//--------------------------------------------------------------------------------------------------------
    public String getFaceId() {
        return faceId;
    }

    public List<EnrolledImage> getEnrolledImages() {
        return enrolledImages;
    }
//--------------------------------------------------------------------------------------------------------
//--------------------------------------End of Getters and Setters----------------------------------------
//--------------------------------------------------------------------------------------------------------
    @Override
    void parseResponse(HttpResponse response) throws IOException {
        HttpEntity entity = response.getEntity();
        if (entity == null) {
            this.setError(Error.ERR_9000);
            return;
        }
        InputStream is = entity.getContent();
        JsonReader reader = Json.createReader(is);
        JsonObject responseObject = reader.readObject();
        reader.close();
        is.close();
        if (responseObject.containsKey("Errors")) {
            this.setError(Error.getByErrCode(responseObject.getJsonArray("Errors").getJsonObject(0).getJsonNumber("ErrCode").intValue()));
            return;
        }
        this.enrolledImages = new LinkedList<>();
        this.faceId = responseObject.getJsonString("face_id").getString();
        responseObject.getJsonArray("images").getValuesAs(JsonObject.class).forEach(o -> this.enrolledImages.add(EnrolledImage.create(o)));
    }

    @Override
    public String toString() {
        return "EnrollResult{\n" +
                "faceId:\t'" + faceId + '\'' + "\n" +
                "enrolledImages:\t" + enrolledImages + "\n" +
                '}';
    }
}
