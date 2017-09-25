package com.innobraves.kairosjava.models.requests;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * Request for the Recognize operation.
 * @author P. Willnow
 * @version 0.0.1
 */
public class RecognizeRequest extends Request {
    private String image;
    private String galleryName;
    private Double minHeadScale;
    private Double threshold;
    private Integer maxNumResults;

    /**
     * Constructor taking required parameters
     * @param imageURL Publicly accessible URL.
     * @param galleryName Defined by you. Is used to identify the gallery.
     */
    public RecognizeRequest(String imageURL, String galleryName) {
        this.image = imageURL;
        this.galleryName = galleryName;
    }

    /**
     * Constructor taking required parameters
     * @param imageBytes Base64 encoded photo.
     * @param galleryName Defined by you. Is used to identify the gallery.
     */
    public RecognizeRequest(byte[] imageBytes, String galleryName) {
        this.image = Base64.getEncoder().encodeToString(imageBytes);
        this.galleryName = galleryName;
    }

    /**
     * Method for adding optional parameter to request
     * @param minHeadScale Defined by you. Is used to set the ratio of the smallest face we should look for in the photo. Accepts a value between .015 (1:64 scale) and .5 (1:2 scale). By default it is set at .015 (1:64 scale) if not specified.
     * @return object instance for method chaining
     */
    public RecognizeRequest withMinHeadScale(double minHeadScale){
        if(minHeadScale >= 0.015 && minHeadScale <= 0.5)this.minHeadScale = minHeadScale;
        return this;
    }

    /**
     * Method for adding optional parameter to request
     * @param threshold Is used to determine a valid facial match.
     * @return object instance for method chaining
     */
    public RecognizeRequest withThreshold(double threshold){
        this.threshold = threshold;
        return this;
    }

    /**
     * Method for adding optional parameter to request
     * @param maxNumResults Is the maximum number of potential matches that are returned. By default it is set to 10 if not supplied.
     * @return object instance for method chaining
     */
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
