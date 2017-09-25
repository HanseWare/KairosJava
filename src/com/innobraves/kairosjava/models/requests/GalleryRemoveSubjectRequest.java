package com.innobraves.kairosjava.models.requests;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import java.io.UnsupportedEncodingException;

/**
 * Request for the GalleryRemoveSubject operation.
 * @author P. Willnow
 * @version 0.0.1
 */
public class GalleryRemoveSubjectRequest extends Request {
    private String galleryName;
    private String subjectId;
    private String faceId;

    /**
     * Constructor taking required parameters
     * @param galleryName Defined by you. Is used to identify the gallery.
     * @param subjectId Defined by you. Is used as an identifier for the face.
     */
    public GalleryRemoveSubjectRequest(String galleryName, String subjectId){
        this.galleryName = galleryName;
        this.subjectId = subjectId;
    }

    /**
     * Method for adding optional parameter to request
     * @param face_id A unique ID from the enroll output when an image has been enrolled.
     * @return object instance for method chaining
     */
    public GalleryRemoveSubjectRequest withFaceId(String face_id){
        this. faceId = face_id;
        return this;
    }

    @Override
    public HttpRequestBase getRequest() throws UnsupportedEncodingException {
        HttpPost request = new HttpPost(Request.BASE_URL + "/gallery/remove_subject");
        JsonObjectBuilder bodyBuilder = Json.createObjectBuilder()
                .add("subject_id", this.subjectId)
                .add("gallery_name", this.galleryName);
        if(faceId != null)bodyBuilder.add("face_id", this.faceId);
        request.setEntity(new StringEntity(bodyBuilder.build().toString()));
        return request;
    }
}
