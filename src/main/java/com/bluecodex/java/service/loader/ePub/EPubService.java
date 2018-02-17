package com.bluecodex.java.service.loader.ePub;

import nl.siegmann.epublib.domain.Book;
import nl.siegmann.epublib.domain.Resource;
import nl.siegmann.epublib.epub.EpubReader;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.*;
import java.util.List;
import java.util.Scanner;

/**
 * Load the content from an EPub file
 */
public class EPubService {

    public String load(String path) throws IOException {
        File fileName = new File(path);
        return load(fileName);
    }

    /**
     * Return a String with all the content from the book
     *
     * @param bookName
     * @return
     * @throws IOException
     */
    public String load(File bookName) throws IOException {
        String content = "";

        // read epub file
        EpubReader epubReader = new EpubReader();
        Book book = epubReader.readEpub(new FileInputStream(bookName.getAbsolutePath()));

        String entireContent = "";
        String textContent = "";
        int fileNumber = book.getContents().size();


        for(int i=0; i<fileNumber; i++) {
            InputStream inputStream = book.getContents().get(i).getInputStream(); // file .html
            try {
                Scanner scanner = new Scanner(inputStream).useDelimiter("\\A");
                entireContent = scanner.hasNext() ? scanner.next() : "";
            } finally {
                inputStream.close();
            }

            Document doc = Jsoup.parse(entireContent);
            textContent += doc.body().text();
            textContent += "\n\n";
        }

        return textContent;
    }

}
