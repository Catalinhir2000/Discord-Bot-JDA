package org.example;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AtomReader {
    List<String> entries = new ArrayList<>();
    public List<String> readAtom() throws IOException {

        URL url = new URL("https://www.javacodegeeks.com/feed");
        XmlReader xmlReader = null;

        try {

            xmlReader = new XmlReader(url);
            SyndFeed feeder = new SyndFeedInput().build(xmlReader);
            System.out.println("Title Value " + feeder.getAuthor());

            for (Iterator iterator = feeder.getEntries().iterator(); iterator
                    .hasNext();) {
                SyndEntry syndEntry = (SyndEntry) iterator.next();
//                System.out.println(syndEntry.getTitle());
//                System.out.println(syndEntry.getDescription().getValue());
//                System.out.println(syndEntry.getLink());
                entries.add(syndEntry.getTitle());
                entries.add(syndEntry.getDescription().getValue());
                entries.add(syndEntry.getLink());

            }

        } catch (FeedException | IOException e) {
            e.printStackTrace();
        } finally {
            if (xmlReader != null)
                xmlReader.close();
        }
        return entries;
    }
}
