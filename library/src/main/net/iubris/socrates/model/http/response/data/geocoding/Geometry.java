/*******************************************************************************
 * Copyleft 2013 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * Geometry.java is part of 'Socrates'.
 * 
 * 'Socrates' is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 * 
 * 'Socrates' is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with 'Socrates'; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301 USA
 ******************************************************************************/
package net.iubris.socrates.model.http.response.data.geocoding;


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
