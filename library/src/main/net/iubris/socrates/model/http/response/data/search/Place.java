/*******************************************************************************
 * Copyleft 2013 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * Place.java is part of 'Socrates'.
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
package net.iubris.socrates.model.http.response.data.search;

import java.io.Serializable;
import java.net.URI;
import java.util.Set;

import net.iubris.socrates.engines.base.url.UrlUtils;
import net.iubris.socrates.model.http.response.data.geocoding.Geometry;

import com.google.api.client.util.Key;

public class Place implements Serializable {	

	private static final long serialVersionUID = -5569731947240088246L;

	@Key("geometry")
	private Geometry geometry;
	
	@Key("icon")
	private String iconString;
	
	private URI icon;
	
	@Key("id")
	private String id;	
	  
	@Key("name")
	private String name;	 
	
	@Key("rating")
	private float rating;
	 
	@Key("reference")
	private String reference;
	
	@Key("types")
	private Set<PlaceType> types;
		 
	@Key("vicinity")
	private String vicinity;
	
	
	
	public URI getIcon() {
		if (icon == null) 
			icon = UrlUtils.buildURI(iconString);
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
	public String getReference() {
		return reference;
	}
	
	/*public String toString() {
		return "--\n"+Verboser.reflectiveToString(this)+"--\n";
	}*/
}
