package com.robocorp2.core.dijkstra;

import com.robocorp2.model.parking.PointGPS;

public class Sommet {
		  final private String id;
		  final private PointGPS pointGPS;
		  
		  
		  public Sommet(String id, PointGPS pointGPS) {
		    this.id = id;
		    this.pointGPS = pointGPS;
		  }
		  public String getId() {
		    return id;
		  }

		  public PointGPS getPointGPS() {
		    return pointGPS;
		  }
		  
		  @Override
		  public int hashCode() {
		    final int prime = 31;
		    int result = 1;
		    result = prime * result + ((id == null) ? 0 : id.hashCode());
		    return result;
		  }
		  
		  @Override
		  public boolean equals(Object obj) {
		    if (this == obj)
		      return true;
		    if (obj == null)
		      return false;
		    if (getClass() != obj.getClass())
		      return false;
		    Sommet other = (Sommet) obj;
		    if (id == null) {
		      if (other.id != null)
		        return false;
		    } else if (!id.equals(other.id))
		      return false;
		    return true;
		  }

		  @Override
		  public String toString() {
		    return pointGPS.toString();
		  }
}
