package com.innobraves.kairosjava.models.requests;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * @author Hex-3-En
 * @version 0.0.1
 */
public class DetectRequest extends Request {
    private String image;
    private Double minHeadScale = null;
    private String selector = null;

    public DetectRequest(String imageURL) {
        this.image = imageURL;
    }

    public DetectRequest(byte[] imageBytes) {
        this.image = Base64.getEncoder().encodeToString(imageBytes);
    }

    public DetectRequest withMinHeadScale(double minHeadScale) {
        if(minHeadScale >= 0.015 && minHeadScale <= 0.5)this.minHeadScale = minHeadScale;
        return this;
    }

    public DetectRequest withSelector(String selector) {
        this.selector = selector;
        return this;
    }

    @Override
    public HttpRequestBase getRequest() throws UnsupportedEncodingException {
        HttpPost request = new HttpPost(Request.BASE_URL + "/detect");
        JsonObjectBuilder bodyBuilder = Json.createObjectBuilder()
                .add("image", this.image);
        if (minHeadScale != null) bodyBuilder.add("minHeadScale", this.minHeadScale);
        if (selector != null) bodyBuilder.add("selector", this.selector);
        request.setEntity(new StringEntity(bodyBuilder.build().toString()));
        return request;
    }
}
