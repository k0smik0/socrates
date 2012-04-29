package net.iubris.socrates.model.data.geocoding;

import com.google.android.maps.GeoPoint;
import com.google.api.client.util.Key;

public class Location {
	
	@Key("lat")
	private double latitude;
	@Key("lng")
	private double longitude;
	public double getLatitude() {
		return latitude;
	}
	public double getLongitude() {
		return longitude;
	}	
	public GeoPoint toGeoPoint(){		
		return new GeoPoint((int)(latitude*1E6), (int)(longitude*1E6));
	}
	/*
	public String toString() {
		return Verboser.reflectiveToString(this);
	}*/
}
