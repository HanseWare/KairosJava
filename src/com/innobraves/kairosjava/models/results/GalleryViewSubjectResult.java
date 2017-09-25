package com.innobraves.kairosjava.models.results;

import com.innobraves.kairosjava.models.Error;
import com.innobraves.kairosjava.models.results.subsets.Subject;
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
 * @author Hex-3-En
 * @version 0.0.1
 */
public class GalleryViewSubjectResult extends Result {
    private String status;
    private List<Subject> subjects;

    /**
     * Constructor to be used in case of an error while executing the request
     * @param error Error received
     */
    public GalleryViewSubjectResult(Error error) {
        super(error);
    }

    /**
     * Constructor handling a HttpResponse after successful receiving a response
     * @param response HTTP response received
     * @throws IOException
     */
    public GalleryViewSubjectResult(HttpResponse response) throws IOException {
        super(response);
    }
//--------------------------------------------------------------------------------------------------------
//---------------------------Getters and Setters for all fields in this class-----------------------------
//--------------------------------------------------------------------------------------------------------
    public String getStatus() {
        return status;
    }

    public List<Subject> getSubjects() {
        return subjects;
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
        this.subjects = new LinkedList<>();
        this.status = responseObject.getJsonString("status").getString();
        responseObject.getJsonArray("face_ids").getValuesAs(JsonObject.class).forEach(o -> this.subjects.add(Subject.create(o)));
    }

    @Override
    public String toString() {
        return "GalleryViewSubjectResult{\n" +
                "status:\t'" + status + '\'' + "\n" +
                "subjects:\t" + subjects + "\n" +
                '}';
    }
}
