package com.innobraves.kairosjava.models.requests;

import org.apache.http.client.methods.HttpRequestBase;

import java.io.UnsupportedEncodingException;

/**
 * Abstract request class to be extended by any specific request class.
 * Ensures equal handling of all requests.
 * @author P. Willnow
 * @version 0.0.1
 */
public abstract class Request {
    public static final String BASE_URL = "https://api.kairos.com";

    /**
     * Getter for a HTTP request configured by the extending specific request
     * @return abstract HTTP request
     * @throws UnsupportedEncodingException
     */
    public abstract HttpRequestBase getRequest() throws UnsupportedEncodingException;
}
