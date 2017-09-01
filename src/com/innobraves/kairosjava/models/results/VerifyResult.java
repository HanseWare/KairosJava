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
 * @author Hex-3-En
 * @version 0.0.1
 */
public class VerifyResult extends Result {
    private Transaction transaction;
    public VerifyResult(Error error) {
        super(error);
    }

    public VerifyResult(HttpResponse response) throws IOException {
        super(response);
    }

    public Transaction getTransaction() {
        return transaction;
    }

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
