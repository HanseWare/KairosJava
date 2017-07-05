package com.innobraves.kairosjava.models;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hex-3-En
 * @version 0.0.1
 */
public enum Errors {
    INSTANCE;

    private final Map<Integer, Error> errors = new HashMap<>();

    void add(int key, Error e){
        this.errors.put(key, e);
    }

    public Error getError(int code){
        return errors.get(code);
    }
}
