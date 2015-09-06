package com.robocorp2.core.dijkstra;

public class Arc  {
	  private final String id; 
	  private final Sommet source;
	  private final Sommet destination;
	  private final double weight; 
	  
	  public Arc(String id, Sommet source, Sommet destination, double weight) {
	    this.id = id;
	    this.source = source;
	    this.destination = destination;
	    this.weight = weight;
	  }
	  
	  public String getId() {
	    return id;
	  }
	  public Sommet getDestination() {
	    return destination;
	  }

	  public Sommet getSource() {
	    return source;
	  }
	  public double getWeight() {
	    return weight;
	  }
	  
	  @Override
	  public String toString() {
	    return source + " " + destination;
	  }
	  
	  
	}
