package com.bluecodex.java.service.loader.file;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Load contents from a file
 */
public class FileService implements IFile {

    /**
     * Loads a file with the given path by default is using UTF-8 charset encode
     * @param path path
     * @return content of the file
     * @throws IOException
     */
    public String load(String path) throws IOException {
        String content = load(path, StandardCharsets.UTF_8);
        return content;
    }

    /**
     * Loads a file with the given path and the given encoding
     * @param path
     * @param encoding
     * @return content of the file
     * @throws IOException
     */
    protected String load(String path, Charset encoding) throws IOException {

        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
}
