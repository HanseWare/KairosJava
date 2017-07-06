package com.innobraves.kairosjava.models.requests;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;

import java.io.UnsupportedEncodingException;

/**
 * @author Hex-3-En
 * @version 0.0.1
 */
public class GalleryListAllRequest extends Request {
    @Override
    public HttpRequestBase getRequest() throws UnsupportedEncodingException {
        HttpPost request = new HttpPost(Request.BASE_URL + "/gallery/list_all");
        request.setEntity(new StringEntity("{}"));
        return request;
    }
}
