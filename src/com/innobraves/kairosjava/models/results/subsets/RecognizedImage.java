package com.innobraves.kairosjava.models.results.subsets;


import javax.json.JsonObject;
import java.util.LinkedList;
import java.util.List;

/**
 * Representation of recognized image
 * @author P. Willnow
 * @version 0.0.1
 */
public class RecognizedImage {
    private Transaction transaction;
    private List<Candidate> candidates;

    /**
     * Empty private constructor, so it can't be called from outside the class.
     */
    private RecognizedImage() {
        candidates = new LinkedList<>();
    }

//--------------------------------------------------------------------------------------------------------
//---------------------------Getters and Setters for all fields in this class-----------------------------
//--------------------------------------------------------------------------------------------------------
    public Transaction getTransaction() {
        return transaction;
    }

    public List<Candidate> getCandidates() {
        return candidates;
    }
//--------------------------------------------------------------------------------------------------------
//--------------------------------------End of Getters and Setters----------------------------------------
//--------------------------------------------------------------------------------------------------------

    /**
     * Creator method, taking raw JSON data and filling fields with it
     * @param raw raw JSON data with result data
     * @return instance of this class filled with data
     */
    public static RecognizedImage create(JsonObject raw) {
        RecognizedImage img = new RecognizedImage();
        img.transaction = Transaction.create(raw.getJsonObject("transaction"));
        if(raw.containsKey("candidates")){
            raw.getJsonArray("candidates").getValuesAs(JsonObject.class).forEach(c -> img.candidates.add(Candidate.create(c)));
        }
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
