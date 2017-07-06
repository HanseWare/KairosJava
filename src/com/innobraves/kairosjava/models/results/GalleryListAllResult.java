package com.innobraves.kairosjava.models.results;

import com.innobraves.kairosjava.models.Error;
import com.innobraves.kairosjava.models.Errors;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonString;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Hex-3-En
 * @version 0.0.1
 */
public class GalleryListAllResult extends Result {
    private String status;
    private List<String> galleryNames;
    public GalleryListAllResult(Error error) {
        super(error);
    }

    public GalleryListAllResult(HttpResponse response) throws IOException {
        super(response);
    }

    public String getStatus() {
        return status;
    }

    public List<String> getGalleryNames() {
        return galleryNames;
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
            this.setError(Errors.INSTANCE.getError(responseObject.getJsonArray("Errors").getJsonObject(0).getJsonNumber("ErrCode").intValue()));
            return;
        }
        this.galleryNames = new LinkedList<>();
        this.status = responseObject.getJsonString("status").getString();
        responseObject.getJsonArray("gallery_ids").getValuesAs(JsonString.class).forEach(o -> this.galleryNames.add(o.getString()));
    }

    @Override
    public String toString() {
        return "GalleryListAllResult{\n" +
                "status:\t'" + status + '\'' + "\n" +
                "galleryNames:\t" + galleryNames + "\n" +
                '}';
    }
}
