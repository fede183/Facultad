package org.autotest.crawl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class DiGraph {

	private final Map<String, Set<String>> edges = new HashMap<String, Set<String>>();

	public void addEdge(String fromUrl, String toUrl) {
		if (!edges.containsKey(fromUrl)) {
			edges.put(fromUrl, new HashSet<String>());
		}
		edges.get(fromUrl).add(toUrl);
	}

	public int getNumberOfEdges() {
		int numberOfEdges = 0;
		for (Set<String> toUrls : edges.values()) {
			numberOfEdges += toUrls.size();
		}
		return numberOfEdges;
	}

	public int getNumberOfNodes() {
		Set<String> nodes = new HashSet<String>();
		nodes.addAll(this.edges.keySet());
		nodes.addAll(this.edges.values().stream().flatMap(s -> s.stream()).collect(Collectors.toSet()));
		return nodes.size();
	}
	
	public Set<String> getNodes() {
		Set<String> nodes = new HashSet<String>();
		nodes.addAll(this.edges.keySet());
		nodes.addAll(this.edges.values().stream().flatMap(s -> s.stream()).collect(Collectors.toSet()));
		return nodes;
	}

	public Set<String> getLinks(String fromUrl) {
		return this.edges.get(fromUrl);
	}
	
	public boolean hasLinks(String fromUrl) {
		return this.edges.containsKey(fromUrl);
	}

}
