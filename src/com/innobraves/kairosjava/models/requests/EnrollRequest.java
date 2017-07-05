package com.innobraves.kairosjava.models.requests;

import org.apache.http.client.methods.HttpRequestBase;

import java.util.Base64;

/**
 * @author Hex-3-En
 * @version 0.0.1
 */
public class EnrollRequest extends Request {

    private String image;
    private String subjectID;
    private String galleryName;

    private Float minHeadScale = null;
    private Boolean multipleFaces = null;

    public EnrollRequest(String imageURL, String subjectID, String galleryName){
        this.image = image;
        this.subjectID = subjectID;
        this.galleryName = galleryName;
    }

    public EnrollRequest(byte[] imageBytes, String subjectID, String galleryName){
        this.image = Base64.getEncoder().encodeToString(imageBytes);
        this.subjectID = subjectID;
        this.galleryName = galleryName;
    }

    public EnrollRequest withMinHeadScale(float minHeadScale){
        this.minHeadScale = minHeadScale;
        return this;
    }

    public EnrollRequest withMultipleFaces(boolean multipleFaces){
        this.multipleFaces = multipleFaces;
        return this;
    }

    @Override
    public HttpRequestBase getRequest(){
        return null;
    }
}
