package com.innobraves.kairosjava.models.results;

import com.innobraves.kairosjava.models.Error;
import com.innobraves.kairosjava.models.results.subsets.RecognizedImage;
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
public class RecognizeResult extends Result {
    private List<RecognizedImage> recognizedImages;

    public RecognizeResult(Error error) {
        super(error);
    }

    public RecognizeResult(HttpResponse response) throws IOException {
        super(response);
    }

    public List<RecognizedImage> getRecognizedImages() {
        return recognizedImages;
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
        this.recognizedImages = new LinkedList<>();
        responseObject.getJsonArray("images").getValuesAs(JsonObject.class).forEach(i -> recognizedImages.add(RecognizedImage.create(i)));
    }

    @Override
    public String toString() {
        return "RecognizeResult{\n" +
                "recognizedImages:\t" + recognizedImages + "\n" +
                '}';
    }
}
