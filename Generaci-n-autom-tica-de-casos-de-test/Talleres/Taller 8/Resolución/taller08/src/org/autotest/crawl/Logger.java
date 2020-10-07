package org.autotest.crawl;

import java.util.Set;
<<<<<<< HEAD
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
=======
>>>>>>> 4b856a2063223b14919a67e419af4c1d4a34b27e

public class Logger {

	private long startingTimeInMillis;

	private static void log(String line) {
		System.out.println(line);
	}

	public void logVisitingUrl(String url) {
		log("Visiting " + url);
	}

	public void logStatistics(int numberOfVisitedUrls, int numberOfUrlsToVisit) {
		log("Visited=" + numberOfVisitedUrls + " to visit=" + numberOfUrlsToVisit);
	}

	public void logNumberOfLinks(String url, int numberOfLinks, int addedLinks) {
		log("Found " + numberOfLinks + " (" + addedLinks + " new) links in page " + url);
	}

	public void logResults(WebSite website) {
		log("Results for Domain:" + website.getDomainUrl());
		log("#Urls:" + website.getNumberOfUrls());
		log("#Internal Links:" + website.getNumberOfInternalLinks());
		log("#External Links:" + website.getNumberOfExternalLinks());
		log("Found unsupported  MIMETypes:" + website.getUnsupportedMimeTypes());
		for (String mimeType : website.getUnsupportedMimeTypes()) {
			Set<String> urls = website.getUrlsWithUnsupportedMimeType(mimeType);
			log(mimeType + "->" + urls.size() + " urls");
		}
		log("Found error codes:" + website.getErrorCodes());
		for (int errorCode : website.getErrorCodes()) {
			Set<String> brokenUrls = website.getUrlsWithErrorCode(errorCode);
			log(errorCode + "->" + brokenUrls.size() + " urls");
<<<<<<< HEAD

			log("Broken Urls:");
			brokenUrls.stream().forEach(new Consumer<String>() {
                @Override
                public void accept(String brokenUrl) {
                    log(brokenUrl);
                    log("Page where is use: " + website.getReverseLinks(brokenUrl).size());
                }
            });
		}
        log("Other IO Exceptions:");
        website.getOtherIOExceptions().forEach(new BiConsumer<String, Set<String>>() {
            @Override
            public void accept(String s, Set<String> strings) {
                log(s);
            }
        });
=======
		}
>>>>>>> 4b856a2063223b14919a67e419af4c1d4a34b27e
	}

	public void logStart() {
		log("Crawled started ");
		startingTimeInMillis = System.currentTimeMillis();
	}

	public void logEnd() {
		long endTimeInMillis = System.currentTimeMillis();
		long elapsedTimeInSeconds = (endTimeInMillis - startingTimeInMillis) / 1000;
		log("Crawled finished. Total time " + elapsedTimeInSeconds + " seconds");
	}

}
