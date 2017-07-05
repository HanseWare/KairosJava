package com.innobraves.kairosjava.models.results;

import com.innobraves.kairosjava.models.Error;
import org.apache.http.HttpResponse;

/**
 * @author Hex-3-En
 * @version 0.0.1
 */
public class GalleryRemoveSubjectResult extends Result {
    public GalleryRemoveSubjectResult(Error error) {
        super(error);
    }

    public GalleryRemoveSubjectResult(HttpResponse response) {
        super(response);
    }

    @Override
    void parseResponse(HttpResponse response) {

    }
}
