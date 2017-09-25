package com.innobraves.kairosjava;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Util class holding handy methods to be used with the library
 * @author P. Willnow
 * @version 0.0.1
 */
public final class Utils {
    public static byte[] localImageFileToBytes(File file){
        return localImageFileToBytes(file.toPath());
    }

    public static byte[] localImageFileToBytes(Path path){
        try{
            return Files.readAllBytes(path);
        }catch(IOException e){
            e.printStackTrace();
        }
        return new byte[0];
    }

    public static byte[] localImageFileToBytes(String path){
        return localImageFileToBytes(new File(path));
    }
}
