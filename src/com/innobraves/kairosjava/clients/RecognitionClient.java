package com.innobraves.kairosjava.clients;

import com.google.api.client.http.apache.ApacheHttpTransport;
import com.innobraves.kairosjava.models.Error;
import com.innobraves.kairosjava.models.requests.*;
import com.innobraves.kairosjava.models.results.*;
import org.apache.http.Header;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.message.BasicHeader;

import java.io.IOException;

/**
 * Client class synchronously handling HTTP requests to API based on Recognition-Interface
 * @author P. Willnow
 * @version 0.0.1
 */
public class RecognitionClient implements Recognition {
    private HttpClient client;
    private Header[] headers;

    /**
     * Constructor initializing HTTP client and basic headers with credentials
     * @param appID AppID as String
     * @param appKey AppKey as String
     */
    public RecognitionClient(String appID, String appKey){
        this.client =(new ApacheHttpTransport.Builder()).build().getHttpClient();
        headers = new Header[3];
        headers[0] = new BasicHeader("Content-Type", "application/json");
        headers[1] = new BasicHeader("app_id", appID);
        headers[2] = new BasicHeader("app_key", appKey);
    }

    @Override
    public DetectResult detect(DetectRequest detectRequest) {
        try{
            HttpRequestBase req = detectRequest.getRequest();
            req.setHeaders(this.headers);
            return new DetectResult(client.execute(req));
        }catch(IOException e){
            e.printStackTrace();
            return new DetectResult(Error.ERR_9000);
        }
    }

    @Override
    public EnrollResult enroll(EnrollRequest enrollRequest) {
        try{
            HttpRequestBase req = enrollRequest.getRequest();
            req.setHeaders(this.headers);
            return new EnrollResult(client.execute(req));
        }catch(IOException e){
            e.printStackTrace();
            return new EnrollResult(Error.ERR_9000);
        }
    }

    @Override
    public GalleryListAllResult galleryListAll(GalleryListAllRequest galleryListAllRequest) {
        try{
            HttpRequestBase req = galleryListAllRequest.getRequest();
            req.setHeaders(this.headers);
            return new GalleryListAllResult(client.execute(req));
        }catch(IOException e){
            e.printStackTrace();
            return new GalleryListAllResult(Error.ERR_9000);
        }
    }

    @Override
    public GalleryRemoveResult galleryRemove(GalleryRemoveRequest galleryRemoveRequest) {
        try{
            HttpRequestBase req = galleryRemoveRequest.getRequest();
            req.setHeaders(this.headers);
            return new GalleryRemoveResult(client.execute(req));
        }catch(IOException e){
            e.printStackTrace();
            return new GalleryRemoveResult(Error.ERR_9000);
        }
    }

    @Override
    public GalleryRemoveSubjectResult galleryRemoveSubject(GalleryRemoveSubjectRequest galleryRemoveSubjectRequest) {
        try{
            HttpRequestBase req = galleryRemoveSubjectRequest.getRequest();
            req.setHeaders(this.headers);
            return new GalleryRemoveSubjectResult(client.execute(req));
        }catch(IOException e){
            e.printStackTrace();
            return new GalleryRemoveSubjectResult(Error.ERR_9000);
        }
    }

    @Override
    public GalleryViewResult galleryView(GalleryViewRequest galleryViewRequest) {
        try{
            HttpRequestBase req = galleryViewRequest.getRequest();
            req.setHeaders(this.headers);
            return new GalleryViewResult(client.execute(req));
        }catch(IOException e){
            e.printStackTrace();
            return new GalleryViewResult(Error.ERR_9000);
        }
    }

    @Override
    public GalleryViewSubjectResult galleryViewSubject(GalleryViewSubjectRequest galleryViewSubjectRequest) {
        try{
            HttpRequestBase req = galleryViewSubjectRequest.getRequest();
            req.setHeaders(this.headers);
            return new GalleryViewSubjectResult(client.execute(req));
        }catch(IOException e){
            e.printStackTrace();
            return new GalleryViewSubjectResult(Error.ERR_9000);
        }
    }

    @Override
    public RecognizeResult recognize(RecognizeRequest recognizeRequest) {
        try{
            HttpRequestBase req = recognizeRequest.getRequest();
            req.setHeaders(this.headers);
            return new RecognizeResult(client.execute(req));
        }catch(IOException e){
            e.printStackTrace();
            return new RecognizeResult(Error.ERR_9000);
        }
    }

    @Override
    public VerifyResult verify(VerifyRequest verifyRequest) {
        try{
            HttpRequestBase req = verifyRequest.getRequest();
            req.setHeaders(this.headers);
            return new VerifyResult(client.execute(req));
        }catch(IOException e){
            e.printStackTrace();
            return new VerifyResult(Error.ERR_9000);
        }
    }
}
