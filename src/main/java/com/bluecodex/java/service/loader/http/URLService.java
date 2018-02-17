package com.bluecodex.java.service.loader.http;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Retrieve Content from a URL
 */
public class URLService {

    OkHttpClient client = new OkHttpClient();

    private String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    /**
     * Return a string for the given url
     * @param url
     * @return
     */
    public String load(String url) throws IOException {
        String output = run(url);
        Document doc = Jsoup.parse(output);
        return doc.body().text();
    }
}
