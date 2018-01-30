package com.bluecodex.java.service.loader.file;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Load contents from a file
 */
public class FileService implements IFile{


    public String load(String path) {
        String content = null;
        try {
            content = load(path, StandardCharsets.UTF_8);
        }catch(IOException e){
            e.printStackTrace();
        }
        return content;
    }

    public void write(String path, String text) {

    }

    protected String load(String path, Charset encoding) throws IOException{

        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);

    }
}
