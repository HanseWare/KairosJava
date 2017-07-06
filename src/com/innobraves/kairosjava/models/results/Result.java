package com.innobraves.kairosjava.models.results;

import com.innobraves.kairosjava.models.Error;
import org.apache.http.HttpResponse;

import java.io.IOException;

/**
 * @author Hex-3-En
 * @version 0.0.1
 */
abstract class Result {
    private Error error;

    Result(Error error){
        this.error = error;
    }

    Result(HttpResponse response) throws IOException {
        parseResponse(response);
    }

    abstract void parseResponse(HttpResponse response) throws IOException;

    public boolean failed(){
        return error != null;
    }

    void setError(Error error){
        this.error = error;
    }

    public Error getError() {
        return error;
    }
}
