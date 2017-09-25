package com.innobraves.kairosjava.models.results;

import com.innobraves.kairosjava.models.Error;
import org.apache.http.HttpResponse;

import java.io.IOException;

/**
 * Abstract result class to be extended by any specific result class.
 * Ensures equal handling of all results.
 * @author P. Willnow
 * @version 0.0.1
 */
abstract class Result {
    private Error error;

    /**
     * Constructor to be used in case of an error while executing the request
     * @param error Error received
     */
    Result(Error error){
        this.error = error;
    }

    /**
     * Constructor handling a HttpResponse after successful receiving a response
     * @param response HTTP response received
     * @throws IOException
     */
    Result(HttpResponse response) throws IOException {
        parseResponse(response);
    }

    /**
     * Parses JSON content from received HTTP response object
     * @param response http response
     * @throws IOException
     */
    abstract void parseResponse(HttpResponse response) throws IOException;

    /**
     * Getter to check whether http transaction failed
     * @return
     */
    public boolean failed(){
        return error != null;
    }

    /**
     * Setter for error in case transmission is successful, but api submitted internal error
     * @param error error received
     */
    void setError(Error error){
        this.error = error;
    }

    /**
     * Getter for results error
     * @return error enumerator, or null if completely successful
     */
    public Error getError() {
        return error;
    }
}
