package com.innobraves.kairosjava.models.results;

import com.innobraves.kairosjava.models.Error;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.IOException;
import java.io.InputStream;

/**
 * Representation of a remove subject from gallery result
 * @author P. Willnow
 * @version 0.0.1
 */
public class GalleryRemoveSubjectResult extends Result {
    private String status;
    private String message;

    /**
     * Constructor to be used in case of an error while executing the request
     * @param error Error received
     */
    public GalleryRemoveSubjectResult(Error error) {
        super(error);
    }

    /**
     * Constructor handling a HttpResponse after successful receiving a response
     * @param response HTTP response received
     * @throws IOException
     */
    public GalleryRemoveSubjectResult(HttpResponse response) throws IOException {
        super(response);
    }
//--------------------------------------------------------------------------------------------------------
//---------------------------Getters and Setters for all fields in this class-----------------------------
//--------------------------------------------------------------------------------------------------------
    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
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
        this.status = responseObject.getJsonString("status").getString();
        this.message = responseObject.getJsonString("message").getString();
    }

    @Override
    public String toString() {
        return "GalleryRemoveSubjectResult{\n" +
                "status:\t'" + status + '\'' + "\n" +
                "message:\t'" + message + '\'' + "\n" +
                '}';
    }
}
