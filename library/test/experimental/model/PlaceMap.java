/*******************************************************************************
 * Copyleft 2012 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * PlaceMap.java is part of 'Socrates'
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
 * along with 'Socrates' ; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301 USA
 ******************************************************************************/
package socrates.test.model;

import java.util.List;

import net.iubris.demetrio.Verboser;
import net.iubris.socrates.model.data.places.geocoding.Geometry;

import com.google.api.client.util.ArrayMap;
import com.google.api.client.util.Key;

public class PlaceMap extends ArrayMap<String, String>{

	@Key("id")
	 private String id;
	  
	 @Key("name")
	 private String name;
	  
	 @Key
	 private List<String> types;
	 
	 @Key("geometry")
	 private Geometry geometry;
	 
	 @Key("reference")
	 private String reference;
	 
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Geometry getGeometry() {
		return geometry;
	}	
	public List<String> getTypes() {
		return types;
	}
	public String getReference() {
		return reference;
	}	
	public String toString() {
		return Verboser.reflectiveToString(this);
	}
}
