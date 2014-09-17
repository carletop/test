package com.library.model;

import com.vividsolutions.jts.geom.MultiLineString;

public final class CountyTripMap {

  private int id;
  private String agencyId;
  private String agencyId_def;
  private String tripId; 
  private String routeId;
  private String countyId;
  private String serviceId;
  private double length;
  private int stopscount;
  private MultiLineString shape;
  private String uid;
    
      
  public CountyTripMap() {	
}

public CountyTripMap(CountyTripMap a) {
    this.id = a.id;
    this.agencyId = a.agencyId;
    this.agencyId_def = a.agencyId_def;
    this.tripId = a.tripId;
    this.routeId = a.routeId;
    this.countyId = a.countyId;
    this.length = a.length;
    this.shape = a.shape;
    this.uid = a.uid;
  }

  public int getId() {
    return id;
  }
  
  public void setId(int id) {
	    this.id = id;
	  }
  
  public String getTripId() {
	    return tripId;
	  }
  
  public void setTripId(String tripId) {
	    this.tripId= tripId;
	  }
  
  public String getRouteId() {
		return routeId;
	}

	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}
  
  public String getagencyId() {
    return agencyId;
  }
  
  public void setagencyId(String agencyId) {
    this.agencyId = agencyId;
  }
  
  public String getagencyId_def() {
	    return agencyId;
	  }
	  
  public void setagencyId_def(String agencyId_def) {
    this.agencyId_def = agencyId_def;
  }
  
  public String getCountyId() {
    return countyId;
  }

  public void setCountyId(String countyId) {
    this.countyId = countyId;
  }
  
  public String getServiceId() {
	    return serviceId;
	  }

  public void setServiceId(String serviceId) {
    this.serviceId = serviceId;
  }
  
  public int getStopscount() {
	    return stopscount;
	  }

  public void setStopscount(int stopscount) {
    this.stopscount = stopscount;
  }
  
  public double getLength() {
	    return length;
	  }

 public void setLength(double length) {
  this.length = length;
 	 }

  public MultiLineString getShape(){
	  return shape;
  }
  
  public void setShape(MultiLineString shape){
	  this.shape = shape;
  }
  
  public String getUid(){
	  return uid;
  }
  
  public void setUid(String uid){
	  this.uid = uid;
  }
  
  public String toString() {
    return "<Trip " + this.tripId + "Intersects with county "+ this.countyId+ ">";
  }
}
