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
public class VerifyRequest extends Request {
    private String image;
    private String galleryName;
    private String subjectId;

    public VerifyRequest(String imageURL, String galleryName, String subjectId) {
        this.image = imageURL;
        this.galleryName = galleryName;
        this.subjectId = subjectId;
    }

    public VerifyRequest(byte[] imageBytes, String galleryName, String subjectId) {
        this.image = Base64.getEncoder().encodeToString(imageBytes);
        this.galleryName = galleryName;
        this.subjectId = subjectId;
    }
    @Override
    public HttpRequestBase getRequest() throws UnsupportedEncodingException {
        HttpPost request = new HttpPost(Request.BASE_URL + "/verify");
        JsonObjectBuilder bodyBuilder = Json.createObjectBuilder()
                .add("image", this.image)
                .add("gallery_name", this.galleryName)
                .add("subject_id", this.subjectId);
        request.setEntity(new StringEntity(bodyBuilder.build().toString()));
        return request;
    }
}
