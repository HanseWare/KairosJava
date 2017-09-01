package com.innobraves.kairosjava.models.results;

import com.innobraves.kairosjava.models.Error;
import com.innobraves.kairosjava.models.results.subsets.Face;
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
public class DetectResult extends Result {
    private String status;
    private int width;
    private int height;
    private String file;
    private List<Face> faces;

    public DetectResult(Error error) {
        super(error);
    }

    public DetectResult(HttpResponse response) throws IOException {
        super(response);
    }

    public String getStatus() {
        return status;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getFile() {
        return file;
    }

    public List<Face> getFaces() {
        return faces;
    }

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
        JsonObject image = responseObject.getJsonArray("images").getJsonObject(0);
        this.status = image.getJsonString("status").getString();
        this.height = image.getJsonNumber("height").intValue();
        this.width = image.getJsonNumber("width").intValue();
        this.file = image.getJsonString("file").getString();
        this.faces = new LinkedList<>();
        image.getJsonArray("faces").getValuesAs(JsonObject.class).forEach(o -> this.faces.add(Face.create(o)));
    }

    @Override
    public String toString() {
        return "DetectResult{\n" +
                "status:\t'" + status + '\'' + "\n" +
                "width:\t" + width + "\n" +
                "height:\t" + height + "\n" +
                "file:\t'" + file + '\'' + "\n" +
                "faces:\t" + faces + "\n" +
                '}';
    }
}
