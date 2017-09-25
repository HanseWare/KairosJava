package com.innobraves.kairosjava.models.requests;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * Request for the Detect operation.
 * @author P. Willnow
 * @version 0.0.1
 */
public class DetectRequest extends Request {
    private String image;
    private Double minHeadScale = null;
    private String selector = null;

    /**
     * Constructor taking required parameters
     * @param imageURL Publicly accessible URL.
     */
    public DetectRequest(String imageURL) {
        this.image = imageURL;
    }

    /**
     * Constructor taking required parameters
     * @param imageBytes Base64 encoded photo.
     */
    public DetectRequest(byte[] imageBytes) {
        this.image = Base64.getEncoder().encodeToString(imageBytes);
    }

    /**
     * Method for adding optional parameter to request
     * @param minHeadScale Defined by you. Is used to set the ratio of the smallest face we should look for in the photo. Accepts a value between .015 (1:64 scale) and .5 (1:2 scale). By default it is set at .015 (1:64 scale) if not specified.
     * @return object instance for method chaining
     */
    public DetectRequest withMinHeadScale(double minHeadScale) {
        if(minHeadScale >= 0.015 && minHeadScale <= 0.5)this.minHeadScale = minHeadScale;
        return this;
    }

    /**
     * Method for adding optional parameter to request
     * @param selector Is used to adjust the face detector. If not specified the default of FRONTAL is used. Note that these optional parameters are not reliable for face recognition, but may be useful for face detection uses.
     * @return object instance for method chaining
     */
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
