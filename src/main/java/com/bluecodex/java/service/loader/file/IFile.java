package com.bluecodex.java.service.loader.file;

import java.io.File;

public interface IFile {

    /**
     * Loads the given file and return the content String
     * @param path path
     * @return the content
     */
    public String load(String path);

    /**
     * Write into a file the given content.
     * @param path
     * @param text
     */
    public void write(String path, String text);

}
