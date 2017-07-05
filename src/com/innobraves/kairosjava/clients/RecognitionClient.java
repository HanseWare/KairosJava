package com.innobraves.kairosjava.clients;

import com.google.api.client.http.apache.ApacheHttpTransport;
import com.innobraves.kairosjava.models.Error;
import com.innobraves.kairosjava.models.requests.EnrollRequest;
import com.innobraves.kairosjava.models.results.EnrollResult;
import org.apache.http.Header;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.message.BasicHeader;

import java.io.IOException;

/**
 * @author Hex-3-En
 * @version 0.0.1
 */
public class RecognitionClient implements Recognition {
    private HttpClient client;
    private Header[] headers;

    public RecognitionClient(String appID, String appKey){
        this.client =(new ApacheHttpTransport.Builder()).build().getHttpClient();
        headers = new Header[3];
        headers[0] = new BasicHeader("Content-Type", "application/json");
        headers[1] = new BasicHeader("app_id", appID);
        headers[2] = new BasicHeader("app_key", appKey);
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
}
