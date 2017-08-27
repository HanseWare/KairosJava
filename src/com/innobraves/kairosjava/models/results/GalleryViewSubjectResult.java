package com.innobraves.kairosjava.models.results;

import com.innobraves.kairosjava.models.Error;
import com.innobraves.kairosjava.models.results.subsets.Subject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

import javax.json.Json;
import javax.json.JsonObject;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Hex-3-En
 * @version 0.0.1
 */
public class GalleryViewSubjectResult extends Result {
    private String status;
    private List<Subject> subjects;
    public GalleryViewSubjectResult(Error error) {
        super(error);
    }

    public GalleryViewSubjectResult(HttpResponse response) throws IOException {
        super(response);
    }

    public String getStatus() {
        return status;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    @Override
    void parseResponse(HttpResponse response) throws IOException {
        HttpEntity entity = response.getEntity();
        if (entity == null) {
            this.setError(Error.ERR_9000);
            return;
        }
        JsonObject responseObject = Json.createReader(entity.getContent()).readObject();
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
