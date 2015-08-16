/*******************************************************************************
 * 
 * Copyleft 2013 Massimiliano Leone - massimiliano.leone@iubris.net .
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

import java.net.URI;
import java.util.List;
import java.util.Set;

import net.iubris.socrates.engines.base.url.UrlUtils;
import net.iubris.socrates.model.http.response.common.Photo;
import net.iubris.socrates.model.http.response.common.Scope;
import net.iubris.socrates.model.http.response.common.ScopedID;
import net.iubris.socrates.model.http.response.data.geocoding.Geometry;

import com.google.api.client.util.Key;

/**
 * Java mapping of <a href="https://developers.google.com/places/webservice/search#PlaceSearchResults">Place's search result</a>
 */
public class GooglePlace {	

	@Key("geometry")
	private Geometry geometry;
	
	@Key("name")
	private String name;
	
	@Key("reference")
	private String reference;
	
	@Key("icon")
	private String iconString;
	private URI icon;
	
	@Key("id")
	private String id;
	
	@Key("place_id")
	private String placeId;
	
	@Key("alt_ids")
	private Set<ScopedID> scopedIds;
//	
	@Key("scope")
	private String scopeString;
	private Scope scope;
	
	@Key("rating")
	private float rating;
	
	@Key("types")
	private Set<GooglePlaceType> types;
		 
	@Key("vicinity")
	private String vicinity;
	
	@Key("photos")
	private List<Photo> photos;
	
	@Key("permanently_closed")
	private boolean permanentlyClosed;
	
	
	public Geometry getGeometry() {
		return geometry;
	}
	public String getName() {
		return name;
	}
	@Deprecated
	public String getReference() {
		return reference;
	}
	
	public URI getIcon() {
		if (icon == null) 
			icon = UrlUtils.buildURI(iconString);
		return icon;
	}
	public List<Photo> getPhotos() {
		return photos;
	}
	@Deprecated
	public String getId() {
		return id;
	}
	public String getPlaceId() {
		return placeId;
	}
	
	public Scope getScope() {
		if (scope==null) {
			try { 
				scope = Scope.valueOf(Scope.class, scopeString);
			} catch (IllegalArgumentException e) {
				scope = Scope.NULL;
			}
		}
		return scope;
	}
	public Set<ScopedID> getScopedIds() {
		return scopedIds;
	}
	
	public float getRating() {		
		return rating;
	}
	
	public Set<GooglePlaceType> getTypes() {		
		return types;
	}
	public String getVicinity() {
		return vicinity;
	}
	
	public boolean isPermanentlyClosed() {
		return permanentlyClosed;
	}
	
	/*public String toString() {
		return "--\n"+Verboser.reflectiveToString(this)+"--\n";
	}*/
	
	@Override
	public boolean equals(Object o) {
		if ( placeId.equals(((GooglePlace)o).getPlaceId()) )
				return true;
		return false;
	}
}
