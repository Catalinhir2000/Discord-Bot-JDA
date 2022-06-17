package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Searcher {
    String url = "https://www.google.com/search" + "?q=";
    String encoding = "UTF-8";

    StringBuilder urlAuxiliar = new StringBuilder();
    List<String> results = new ArrayList<>();

    public List<String> cautare(List<String> args){
        for(String s : args) {
            urlAuxiliar.append(s);
            urlAuxiliar.append("+");
        }
        urlAuxiliar.deleteCharAt(urlAuxiliar.length() - 1);

        try {
            Document doc = Jsoup.connect(url + URLEncoder.encode(String.valueOf(urlAuxiliar), encoding)).get();

            Elements urls = doc.select("#search > div > div > div");

            for(Element link : urls) {
                results.add(link.select("a").attr("href"));
                results.add(link.select("h3").text());
                break;
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        urlAuxiliar.setLength(0);
        return results;

    }





}

