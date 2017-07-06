package com.innobraves.kairosjava.models.results.subsets;

import javax.json.JsonObject;

/**
 * @author Hex-3-En
 * @version 0.0.1
 */
public class Attributes {
    private String lips;
    private double asian;
    private Gender gender;
    private int age;
    private double hispanic;
    private double other;
    private double black;
    private double white;
    private String glasses;

    private Attributes(){}

    public String getLips() {
        return lips;
    }

    public double getAsian() {
        return asian;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public double getHispanic() {
        return hispanic;
    }

    public double getOther() {
        return other;
    }

    public double getBlack() {
        return black;
    }

    public double getWhite() {
        return white;
    }

    public String getGlasses() {
        return glasses;
    }

    public static Attributes create(JsonObject raw){
        Attributes att = new Attributes();
        att.lips = raw.getJsonString("lips").getString();
        att.asian = raw.getJsonNumber("asian").doubleValue();
        att.hispanic = raw.getJsonNumber("hispanic").doubleValue();
        att.other = raw.getJsonNumber("other").doubleValue();
        att.black = raw.getJsonNumber("black").doubleValue();
        att.white = raw.getJsonNumber("white").doubleValue();
        att.gender = Gender.create(raw.getJsonObject("gender"));
        att.age = raw.getJsonNumber("age").intValue();
        att.glasses = raw.getJsonString("glasses").getString();
        return att;
    }

    @Override
    public String toString() {
        return "Attributes{\n" +
                "lips:\t'" + lips + '\'' + "\n" +
                "asian:\t" + asian + "\n" +
                "gender:\t" + gender + "\n" +
                "age:\t" + age + "\n" +
                "hispanic:\t" + hispanic + "\n" +
                "other:\t" + other + "\n" +
                "black:\t" + black + "\n" +
                "white:\t" + white + "\n" +
                "glasses:\t'" + glasses + '\'' + "\n" +
                '}';
    }
}
