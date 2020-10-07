package org.autotest.crawler;

import java.io.IOException;

import org.autotest.crawl.BabyCrawler;
import org.autotest.crawl.Logger;
import org.autotest.crawl.WebSite;
import org.junit.Test;

public class BabyCrawlerTest {

	@Test
<<<<<<< HEAD
=======
	public void testCrawler() throws IOException {
		Logger logger = new Logger();
		BabyCrawler crawler = new BabyCrawler(logger);
		WebSite website = crawler.crawl("https://www.dc.uba.ar/");
		logger.logResults(website);
	}

	@Test
>>>>>>> 4b856a2063223b14919a67e419af4c1d4a34b27e
	public void testCrawlerEjercicio1() throws IOException {
		Logger logger = new Logger();
		BabyCrawler crawler = new BabyCrawler(logger);
		WebSite website = crawler.crawl("https://sbst2017.lafhis.dc.uba.ar/");
		logger.logResults(website);
	}

	@Test
	public void testCrawlerEjercicio2() throws IOException {
		Logger logger = new Logger();
		BabyCrawler crawler = new BabyCrawler(logger);
		WebSite website = crawler.crawl("https://icc.fcen.uba.ar/");
		logger.logResults(website);
	}

	@Test
	public void testCrawlerEjercicio3() throws IOException {
		Logger logger = new Logger();
		BabyCrawler crawler = new BabyCrawler(logger);
		WebSite website = crawler.crawl("https://www.dc.uba.ar/");
		logger.logResults(website);
	}
}
