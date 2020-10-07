package org.autotest.crawl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.jsoup.HttpStatusException;
import org.jsoup.UnsupportedMimeTypeException;

public class WebSite {

	private final String domainUrl;

	private final Map<String, Set<String>> unsupportedMimeTypes = new HashMap<String, Set<String>>();

	private final Map<Integer, Set<String>> brokenUrls = new HashMap<Integer, Set<String>>();

	private final Set<String> malformedURLExceptions = new HashSet<String>();

	private final Map<String, Set<String>> otherIOExceptions = new HashMap<String, Set<String>>();

	private final DiGraph internalLinks = new DiGraph();

	private final DiGraph externalLinks = new DiGraph();

	public WebSite(String domainUrl) {
		this.domainUrl = domainUrl;
	}

	public void addInternalLink(String fromUrl, String toInternalUrl) {
		internalLinks.addEdge(fromUrl, toInternalUrl);
	}

	public void addExternalLink(String fromUrl, String toExternalUrl) {
		this.externalLinks.addEdge(fromUrl, toExternalUrl);
	}

	public void addHttpStatusException(int statusCode, String url) {
		if (!this.brokenUrls.containsKey(statusCode)) {
			this.brokenUrls.put(statusCode, new HashSet<String>());
		}
		this.brokenUrls.get(statusCode).add(url);
	}

	public void addUnsupportedMimeType(String mimeType, String url) {
		if (!this.unsupportedMimeTypes.containsKey(mimeType)) {
			this.unsupportedMimeTypes.put(mimeType, new HashSet<String>());
		}
		this.unsupportedMimeTypes.get(mimeType).add(url);
	}

	public void addMalformedUrl(String url) {
		this.malformedURLExceptions.add(url);
	}

	public String getDomainUrl() {
		return this.domainUrl;
	}

	public Set<String> getUnsupportedMimeTypes() {
		return this.unsupportedMimeTypes.keySet();
	}

	public Set<String> getUrlsWithUnsupportedMimeType(String mimeType) {
		return this.unsupportedMimeTypes.get(mimeType);
	}

	public Set<Integer> getErrorCodes() {
		return this.brokenUrls.keySet();
	}

	public Set<String> getUrlsWithErrorCode(int errorCode) {
		return this.brokenUrls.get(errorCode);
	}

<<<<<<< HEAD
	public Set<String> getMalformedURLExceptions() {
		return malformedURLExceptions;
	}

	public Map<String, Set<String>> getOtherIOExceptions() {
		return otherIOExceptions;
	}

=======
>>>>>>> 4b856a2063223b14919a67e419af4c1d4a34b27e
	public int getNumberOfInternalLinks() {
		return this.internalLinks.getNumberOfEdges();
	}

	public int getNumberOfUrls() {
		return this.internalLinks.getNumberOfNodes();
	}

	public int getNumberOfExternalLinks() {
		return this.externalLinks.getNumberOfEdges();
	}

	public void addIOException(IOException ex, String url) {
		if ((ex instanceof MalformedURLException) || (ex instanceof UnsupportedMimeTypeException)
				|| (ex instanceof HttpStatusException)) {
			throw new IllegalArgumentException("use specific method to register an exception " + ex);
		}
		String exceptionClassName = ex.getClass().getName();
		if (!this.otherIOExceptions.containsKey(exceptionClassName)) {
			this.otherIOExceptions.put(exceptionClassName, new HashSet<String>());
		}
		this.otherIOExceptions.get(exceptionClassName).add(url);
	}

	public Set<String> getReverseLinks(String toUrl) {
		Set<String> fromUrls = new HashSet<String>();
		for (String fromUrl : this.internalLinks.getNodes()) {
			if (this.internalLinks.hasLinks(fromUrl) && this.internalLinks.getLinks(fromUrl).contains(toUrl)) {
				fromUrls.add(fromUrl);
			}
		}
		return fromUrls;
	}
}
