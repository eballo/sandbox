package com.bluecodex.java.service.loader.file;

import java.io.File;
import java.io.IOException;

public interface IFile {

    /**
     * Loads the given file and return the content String
     *
     * @param path path
     * @return the content
     */
    public String load(String path) throws IOException;

}
