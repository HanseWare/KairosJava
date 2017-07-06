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
public class GalleryViewSubjectRequest extends Request {
    private String galleryName;
    private String subjectId;

    public GalleryViewSubjectRequest(String galleryName, String subjectId){
        this.galleryName = galleryName;
        this.subjectId = subjectId;
    }

    @Override
    public HttpRequestBase getRequest() throws UnsupportedEncodingException {
        HttpPost request = new HttpPost(Request.BASE_URL + "/gallery/remove");
        JsonObjectBuilder bodyBuilder = Json.createObjectBuilder()
                .add("subject_id", this.subjectId)
                .add("gallery_name", this.galleryName);
        request.setEntity(new StringEntity(bodyBuilder.build().toString()));
        return request;
    }
}
