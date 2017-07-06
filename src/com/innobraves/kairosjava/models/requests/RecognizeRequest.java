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
public class RecognizeRequest extends Request {
    private String image;
    private String galleryName;
    private Double minHeadScale;
    private Double threshold;
    private Integer maxNumResults;

    public RecognizeRequest(String imageURL, String galleryName) {
        this.image = imageURL;
        this.galleryName = galleryName;
    }

    public RecognizeRequest(byte[] imageBytes, String galleryName) {
        this.image = Base64.getEncoder().encodeToString(imageBytes);
        this.galleryName = galleryName;
    }

    public RecognizeRequest withMinHeadScale(double minHeadScale){
        if(minHeadScale >= 0.015 && minHeadScale <= 0.5)this.minHeadScale = minHeadScale;
        return this;
    }

    public RecognizeRequest withThreshold(double threshold){
        this.threshold = threshold;
        return this;
    }

    public RecognizeRequest withMaxNumResults(int maxNumResults){
        if(maxNumResults > 0)this.maxNumResults = maxNumResults;
        return this;
    }

    @Override
    public HttpRequestBase getRequest() throws UnsupportedEncodingException {
        HttpPost request = new HttpPost(Request.BASE_URL + "/recognize");
        JsonObjectBuilder bodyBuilder = Json.createObjectBuilder()
                .add("image", this.image)
                .add("gallery_name", this.galleryName);
        if (minHeadScale != null) bodyBuilder.add("minHeadScale", this.minHeadScale);
        if (threshold != null) bodyBuilder.add("threshold", this.threshold);
        if (maxNumResults != null) bodyBuilder.add("max_num_results", this.maxNumResults);
        request.setEntity(new StringEntity(bodyBuilder.build().toString()));
        return request;
    }
}
