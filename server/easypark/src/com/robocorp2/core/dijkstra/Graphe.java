package com.robocorp2.core.dijkstra;

import java.util.List;

public class Graphe {

	private final List<Sommet> vertexes;
	  private final List<Arc> edges;

	  public Graphe(List<Sommet> vertexes, List<Arc> edges) {
	    this.vertexes = vertexes;
	    this.edges = edges;
	  }

	  public List<Sommet> getVertexes() {
	    return vertexes;
	  }

	  public List<Arc> getEdges() {
	    return edges;
	  }
    
}