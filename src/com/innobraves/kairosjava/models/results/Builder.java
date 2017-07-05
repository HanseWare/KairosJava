package com.innobraves.kairosjava.models.results;

/**
 * @author Hex-3-En
 * @version 0.0.1
 */
public abstract class Builder{
    public abstract Builder getBuilder();
    public abstract Builder withError(int errorCode);
    public abstract Result build();
}
