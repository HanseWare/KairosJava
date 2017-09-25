package com.innobraves.kairosjava.models.requests;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * Request for the Verify operation.
 * @author P. Willnow
 * @version 0.0.1
 */
public class VerifyRequest extends Request {
    private String image;
    private String galleryName;
    private String subjectId;

    /**
     * Constructor taking required parameters
     * @param imageURL Publicly accessible URL.
     * @param galleryName Defined by you. Is used to identify the gallery.
     * @param subjectId Defined by you. Is used as an identifier for the face.
     */
    public VerifyRequest(String imageURL, String galleryName, String subjectId) {
        this.image = imageURL;
        this.galleryName = galleryName;
        this.subjectId = subjectId;
    }

    /**
     * Constructor taking required parameters
     * @param imageBytes Base64 encoded photo.
     * @param galleryName Defined by you. Is used to identify the gallery.
     * @param subjectId Defined by you. Is used as an identifier for the face.
     */
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
