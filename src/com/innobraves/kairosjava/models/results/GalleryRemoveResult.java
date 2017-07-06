package com.innobraves.kairosjava.models.results;

import com.innobraves.kairosjava.models.Error;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

import javax.json.Json;
import javax.json.JsonObject;
import java.io.IOException;

/**
 * @author Hex-3-En
 * @version 0.0.1
 */
public class GalleryRemoveResult extends Result{
    private String status;
    private String message;

    public GalleryRemoveResult(Error error) {
        super(error);
    }

    public GalleryRemoveResult(HttpResponse response) throws IOException {
        super(response);
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
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
            this.setError(Error.getByErrCode(responseObject.getJsonArray("Errors").getJsonObject(0).getJsonNumber("ErrCode").bigDecimalValue().intValue()));
            return;
        }
        this.status = responseObject.getJsonString("status").getString();
        this.message = responseObject.getJsonString("message").getString();
    }

    @Override
    public String toString() {
        return "GalleryRemoveResult{\n" +
                "status:\t'" + status + '\'' + "\n" +
                "message:\t'" + message + '\'' + "\n" +
                '}';
    }
}
