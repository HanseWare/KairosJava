package com.innobraves.kairosjava.models.results.subsets;


import javax.json.JsonObject;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Hex-3-En
 * @version 0.0.1
 */
public class RecognizedImage {
    private Transaction transaction;
    private List<Candidate> candidates;

    private RecognizedImage() {
        candidates = new LinkedList<>();
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public List<Candidate> getCandidates() {
        return candidates;
    }

    public static RecognizedImage create(JsonObject raw) {
        RecognizedImage img = new RecognizedImage();
        img.transaction = Transaction.create(raw.getJsonObject("transaction"));
        raw.getJsonArray("candidates").getValuesAs(JsonObject.class).forEach(c -> img.candidates.add(Candidate.create(c)));
        return img;
    }

    @Override
    public String toString() {
        return "RecognizedImage{\n" +
                "transaction:\t" + transaction + "\n" +
                "candidates:\t" + candidates + "\n" +
                '}';
    }
}
