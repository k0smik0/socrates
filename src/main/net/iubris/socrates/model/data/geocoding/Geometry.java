package net.iubris.socrates.model.data.geocoding;


import com.google.api.client.util.Key;

public class Geometry {

	@Key("location")
	/*private GeoPoint geoPoint;
	
	public GeoPoint getGeoPoint(){
		System.out.println( geoPoint.getLatitudeE6() + " " +geoPoint.getLongitudeE6() );
		return geoPoint;
	}*/
	private Location placeLocation;
		
	public Location getLocation() {
		return placeLocation;
	}
	
	
	
	/*private Location location;
	public Location getLocation() {		
		return location;
	}*/
	/*
	public String toString() {
		return Verboser.reflectiveToString(this);
	}*/
}
