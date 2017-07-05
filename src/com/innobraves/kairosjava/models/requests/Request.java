package com.innobraves.kairosjava.models.requests;

import org.apache.http.client.methods.HttpRequestBase;

/**
 * @author Hex-3-En
 * @version 0.0.1
 */
public abstract class Request {
    public static final String BASE_URL = "api.kairos.com";

    public abstract HttpRequestBase getRequest();
}
