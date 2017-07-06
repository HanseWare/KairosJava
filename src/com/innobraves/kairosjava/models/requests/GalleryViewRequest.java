package com.innobraves.kairosjava.models.requests;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import java.io.UnsupportedEncodingException;

/**
 * @author Hex-3-En
 * @version 0.0.1
 */
public class GalleryViewRequest extends Request {
    private String galleryName;

    public GalleryViewRequest(String galleryName){
        this.galleryName = galleryName;
    }

    @Override
    public HttpRequestBase getRequest() throws UnsupportedEncodingException {
        HttpPost request = new HttpPost(Request.BASE_URL + "/gallery/view");
        JsonObjectBuilder bodyBuilder = Json.createObjectBuilder()
                .add("gallery_name", this.galleryName);
        request.setEntity(new StringEntity(bodyBuilder.build().toString()));
        return request;
    }
}
