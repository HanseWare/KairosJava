package com.innobraves.kairosjava.models.requests;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * Request for the Enroll operation.
 * @author P. Willnow
 * @version 0.0.1
 */
public class EnrollRequest extends Request {

    private String image;
    private String subjectID;
    private String galleryName;

    private Float minHeadScale = null;
    private Boolean multipleFaces = null;

    /**
     * Constructor taking required parameters
     * @param imageURL Publicly accessible URL.
     * @param subjectID Defined by you. Is used as an identifier for the face.
     * @param galleryName Defined by you. Is used to identify the gallery.
     */
    public EnrollRequest(String imageURL, String subjectID, String galleryName){
        this.image = imageURL;
        this.subjectID = subjectID;
        this.galleryName = galleryName;
    }

    /**
     * Constructor taking required parameters
     * @param imageBytes Base64 encoded photo.
     * @param subjectID Defined by you. Is used as an identifier for the face.
     * @param galleryName Defined by you. Is used to identify the gallery.
     */
    public EnrollRequest(byte[] imageBytes, String subjectID, String galleryName){
        this.image = Base64.getEncoder().encodeToString(imageBytes);
        this.subjectID = subjectID;
        this.galleryName = galleryName;
    }

    /**
     * Method for adding optional parameter to request
     * @param minHeadScale Defined by you. Is used to set the ratio of the smallest face we should look for in the photo. Accepts a value between .015 (1:64 scale) and .5 (1:2 scale). By default it is set at .015 (1:64 scale) if not specified.
     * @return object instance for method chaining
     */
    public EnrollRequest withMinHeadScale(float minHeadScale){
        this.minHeadScale = minHeadScale;
        return this;
    }

    /**
     * Method for adding optional parameter to request
     * @param multipleFaces If set to true lets the API enroll every face found in your photo under the same subject_id.
     * @return object instance for method chaining
     */
    public EnrollRequest withMultipleFaces(boolean multipleFaces){
        this.multipleFaces = multipleFaces;
        return this;
    }

    @Override
    public HttpRequestBase getRequest() throws UnsupportedEncodingException {
        HttpPost request = new HttpPost(Request.BASE_URL + "/enroll");
        JsonObjectBuilder bodyBuilder = Json.createObjectBuilder()
                .add("image", this.image)
                .add("subject_id", this.subjectID)
                .add("gallery_name", this.galleryName);
        if(minHeadScale != null)bodyBuilder.add("minHeadScale", this.minHeadScale);
        if(multipleFaces != null)bodyBuilder.add("multiple_faces", this.multipleFaces);
        request.setEntity(new StringEntity(bodyBuilder.build().toString()));
        return request;
    }
}
