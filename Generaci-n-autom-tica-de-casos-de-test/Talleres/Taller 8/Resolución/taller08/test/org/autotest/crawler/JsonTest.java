package org.autotest.crawler;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

public class JsonTest {

	@Test
	public void testGetPage() throws IOException {
		String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64)";
		USER_AGENT += " AppleWebKit/535.1 (KHTML, like Gecko)";
		USER_AGENT += " Chrome/13.0.782.112 Safari/535.1";
		String url = "https://www.dc.uba.ar/";
		Connection connection = Jsoup.connect(url).userAgent(USER_AGENT);

		Document htmlDocument = connection.get();
		int statuCode =  connection.response().statusCode();
		String mimeType = connection.response().contentType();
		String bodyText = htmlDocument.body().text();
		Elements linksOnPage = htmlDocument.select("a[href]");
		Element aLink = linksOnPage.iterator().next();
		String aUrl = aLink.absUrl("href");
	}

}
