package com.library.model;


public class Urban {
	private String urbanId;
	private String name;
    private long population;
    private long housing;
    private double latitude;
    private double longitude;
    private long landarea;
    private long waterarea;
    
    public Urban(){    	
    }
    
    public Urban(Urban u) {
		this.urbanId = u.urbanId;
		this.name = u.name;
		this.population = u.population;
		this.housing = u.housing;
		this.latitude = u.latitude;
		this.longitude = u.longitude;
		this.landarea = u.landarea;
		this.waterarea = u.waterarea;
	}

	public String getUrbanId() {
		return urbanId;
	}

	public void setUrbanId(String urbanId) {
		this.urbanId = urbanId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPopulation() {
		return population;
	}

	public void setPopulation(long population) {
		this.population = population;
	}

	public long getHousing() {
		return housing;
	}

	public void setHousing(long housing) {
		this.housing = housing;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public long getLandarea() {
		return landarea;
	}

	public void setLandarea(long landarea) {
		this.landarea = landarea;
	}

	public long getWaterarea() {
		return waterarea;
	}

	public void setWaterarea(long waterarea) {
		this.waterarea = waterarea;
	}    
}
