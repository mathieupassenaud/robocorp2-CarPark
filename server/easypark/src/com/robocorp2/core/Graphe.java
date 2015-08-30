package com.robocorp2.core;

import java.util.List;

public class Graphe {

	private final List<Vertex> vertexes;
	  private final List<Edge> edges;

	  public Graphe(List<Vertex> vertexes, List<Edge> edges) {
	    this.vertexes = vertexes;
	    this.edges = edges;
	  }

	  public List<Vertex> getVertexes() {
	    return vertexes;
	  }

	  public List<Edge> getEdges() {
	    return edges;
	  }
    
}