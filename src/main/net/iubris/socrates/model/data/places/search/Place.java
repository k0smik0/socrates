/*******************************************************************************
 * Copyleft 2012 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * Place.java is part of 'Socrates'.
 * 
 * socrates is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 * 
 * socrates is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with socrates ; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301 USA
 ******************************************************************************/
package net.iubris.socrates.model.data.places.search;

import java.util.Set;

import net.iubris.socrates.model.data.geocoding.Geometry;
import net.iubris.socrates.model.data.places.PlaceType;


import com.google.api.client.util.Key;

public class Place {	

	@Key("geometry")
	private Geometry geometry;
	
	@Key("icon")
	private String icon;
	
	@Key("id")
	private String id;	
	  
	@Key("name")
	private String name;	 
	
	@Key("rating")
	private float rating;
	 
	@Key("reference")
	private String referenceForDetails;
	
	@Key("types")
	private Set<PlaceType> types;
		 
	@Key("vicinity")
	private String vicinity;
	 
	
	
	public String getIcon() {
		return icon;
	}	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public float getRating() {		
		return rating;
	}
	public Geometry getGeometry() {
		return geometry;
	}	
	public Set<PlaceType> getTypes() {		
		return types;
	}	
	public String getVicinity() {
		return vicinity;
	}
	public String getReferenceForDetails() {
		return referenceForDetails;
	}
	/*public String toString() {
		return "--\n"+Verboser.reflectiveToString(this)+"--\n";
	}*/
}
