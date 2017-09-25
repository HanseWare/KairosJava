package com.innobraves.kairosjava.models.results;

import com.innobraves.kairosjava.models.Error;
import com.innobraves.kairosjava.models.results.subsets.Transaction;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.IOException;
import java.io.InputStream;

/**
 * Representation of a verification result
 * @author P. Willnow
 * @version 0.0.1
 */
public class VerifyResult extends Result {
    private Transaction transaction;

    /**
     * Constructor to be used in case of an error while executing the request
     * @param error Error received
     */
    public VerifyResult(Error error) {
        super(error);
    }

    /**
     * Constructor handling a HttpResponse after successful receiving a response
     * @param response HTTP response received
     * @throws IOException
     */
    public VerifyResult(HttpResponse response) throws IOException {
        super(response);
    }
//--------------------------------------------------------------------------------------------------------
//---------------------------Getters and Setters for all fields in this class-----------------------------
//--------------------------------------------------------------------------------------------------------
    public Transaction getTransaction() {
        return transaction;
    }
//--------------------------------------------------------------------------------------------------------
//--------------------------------------End of Getters and Setters----------------------------------------
//--------------------------------------------------------------------------------------------------------
    @Override
    void parseResponse(HttpResponse response) throws IOException {
        HttpEntity entity = response.getEntity();
        if (entity == null) {
            this.setError(Error.ERR_9000);
            return;
        }
        InputStream is = entity.getContent();
        JsonReader reader = Json.createReader(is);
        JsonObject responseObject = reader.readObject();
        reader.close();
        is.close();
        if (responseObject.containsKey("Errors")) {
            this.setError(Error.getByErrCode(responseObject.getJsonArray("Errors").getJsonObject(0).getJsonNumber("ErrCode").intValue()));
            return;
        }
        this.transaction = Transaction.create(responseObject.getJsonArray("images").getJsonObject(0).getJsonObject("transaction"));
    }

    @Override
    public String toString() {
        return "VerifyResult{\n" +
                "transaction:\t" + transaction + "\n" +
                '}';
    }
}
