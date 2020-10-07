package org.autotest.crawl;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.util.HashSet;
<<<<<<< HEAD
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
=======
import java.util.Set;
import java.util.Stack;
>>>>>>> 4b856a2063223b14919a67e419af4c1d4a34b27e

import org.jsoup.Connection;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.UnsupportedMimeTypeException;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import sun.awt.image.ImageWatched;

public class BabyCrawler {

	private final Logger logger;
<<<<<<< HEAD
	private Set<String> internalVisited;
	private Set<String> toVisited;
	//private Set<String> externalVisited;
=======
	private Set<String> visited;
>>>>>>> 4b856a2063223b14919a67e419af4c1d4a34b27e

	public BabyCrawler() {
		this(new Logger());
	}

	public BabyCrawler(Logger logger) {
		this.logger = logger;
	}
	
	public WebSite crawl(String domainUrl) throws IOException {

		WebSite website = new WebSite(domainUrl);
		logger.logStart();
		String url = domainUrl;

<<<<<<< HEAD
		internalVisited = new HashSet<String>();
		toVisited = new HashSet<String>();
		//externalVisited = new HashSet<String>();
=======
		visited = new HashSet<String>();
>>>>>>> 4b856a2063223b14919a67e419af4c1d4a34b27e

		searchLinksInUrl(domainUrl, website);

		logger.logResults(website);
<<<<<<< HEAD
=======
		website.getReverseLinks(url);
>>>>>>> 4b856a2063223b14919a67e419af4c1d4a34b27e
		logger.logEnd();
		return website;

	}

	private void searchLinksInUrl(String url, WebSite webSite) throws IOException {
		String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64)";
		USER_AGENT += " AppleWebKit/535.1 (KHTML, like Gecko)";
		USER_AGENT += " Chrome/13.0.782.112 Safari/535.1";

<<<<<<< HEAD
		try {
			Connection connection = Jsoup.connect(url).userAgent(USER_AGENT);
=======
		Connection connection = Jsoup.connect(url).userAgent(USER_AGENT);
		try {
>>>>>>> 4b856a2063223b14919a67e419af4c1d4a34b27e
			Document htmlDocument = connection.get();
			Elements linksOnPage = htmlDocument.select("a[href]");

			logger.logVisitingUrl(url);

<<<<<<< HEAD
			Set<String> urlsOnPage = linksOnPage.stream().map(element ->  element.absUrl("href")).collect(Collectors.toSet());

			Set<String> urlsOnPageToBeVisit = urlsOnPage.stream().filter(new Predicate<String>() {
				@Override
				public boolean test(String aUrl) {
					return needsToBeVisit(aUrl, webSite);
				}
			}).collect(Collectors.toSet());

			Set<String> externalUrlsOnPageToBeVisit = urlsOnPage.stream().filter(new Predicate<String>() {
				@Override
				public boolean test(String aUrl) {
					return !isInternal(aUrl, webSite); //&& !externalVisited.contains(aUrl);
				}
			}).collect(Collectors.toSet());

			toVisited.addAll(urlsOnPageToBeVisit);

			logger.logNumberOfLinks(url, toVisited.size(), urlsOnPageToBeVisit.size());

			for (String externalUrl: externalUrlsOnPageToBeVisit
				 ) {
				addLink(externalUrl, webSite);
				//externalVisited.add(externalUrl);
				//checkConnection(externalUrl, webSite);
			}

			for (String aUrl: urlsOnPageToBeVisit
			) {
				addLink(aUrl, webSite);

				internalVisited.add(aUrl);

				logger.logStatistics(internalVisited.size(), toVisited.size());

				searchLinksInUrl(aUrl, webSite);
			}

		}catch (UnsupportedMimeTypeException ue){
			webSite.addUnsupportedMimeType(ue.getMimeType(), url);

		}catch (MalformedURLException mue){
			webSite.addMalformedUrl(url);

		}catch (HttpStatusException he){
			webSite.addHttpStatusException(he.getStatusCode(), url);
		}
		catch (IOException ioe){
			webSite.addIOException(ioe, url);
		}
	}

	private void checkConnection(String url, WebSite webSite) throws IOException {
		String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64)";
		USER_AGENT += " AppleWebKit/535.1 (KHTML, like Gecko)";
		USER_AGENT += " Chrome/13.0.782.112 Safari/535.1";

		try {
			Connection connection = Jsoup.connect(url).userAgent(USER_AGENT);
			Document htmlDocument = connection.get();
=======
			for (Element aLink: linksOnPage
			) {
				String aUrl = aLink.absUrl("href");
				if(needsToBeVisit(aUrl, webSite, visited)){

					addLink(aUrl, webSite);

					visited.add(aUrl);

					logger.logStatistics(visited.size(), linksOnPage.size());

					searchLinksInUrl(aUrl, webSite);
				}
			}
>>>>>>> 4b856a2063223b14919a67e419af4c1d4a34b27e

		}catch (UnsupportedMimeTypeException ue){
			webSite.addUnsupportedMimeType(ue.getMimeType(), url);

		}catch (MalformedURLException mue){
			webSite.addMalformedUrl(url);

		}catch (HttpStatusException he){
			webSite.addHttpStatusException(he.getStatusCode(), url);
		}
		catch (IOException ioe){
			webSite.addIOException(ioe, url);
		}
	}

<<<<<<< HEAD
	private boolean needsToBeVisit(String aUrl, WebSite webSite){
		return isInternal(aUrl, webSite) && !internalVisited.contains(aUrl) && !toVisited.contains(aUrl);
=======
	private boolean needsToBeVisit(String aUrl, WebSite webSite, Set<String> visited){
		return isInternal(aUrl, webSite) && !visited.contains(aUrl);
>>>>>>> 4b856a2063223b14919a67e419af4c1d4a34b27e
	}

	private boolean isInternal(String aUrl, WebSite webSite){
		return aUrl.startsWith(webSite.getDomainUrl());
	}

	private void addLink(String aUrl, WebSite webSite){

		if(isInternal(aUrl, webSite)){
			webSite.addInternalLink(webSite.getDomainUrl(), aUrl);
		}
		else{
			webSite.addExternalLink(webSite.getDomainUrl(), aUrl);
		}
	}

}

