/*******************************************************************************
 * Copyleft 2013 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * Details.java is part of 'Socrates'.
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
package net.iubris.socrates.model.http.response.data.details;

import java.net.URI;
import java.util.List;
import java.util.Set;

import net.iubris.socrates.engines.base.url.UrlUtils;
import net.iubris.socrates.model.http.response.common.Photo;
import net.iubris.socrates.model.http.response.data.details.review.Review;
import net.iubris.socrates.model.http.response.data.events.Event;
import net.iubris.socrates.model.http.response.data.geocoding.AddressComponent;
import net.iubris.socrates.model.http.response.data.geocoding.Geometry;
import net.iubris.socrates.model.http.response.data.search.GooglePlace;
import net.iubris.socrates.model.http.response.data.search.GooglePlaceType;

import com.google.api.client.util.Key;

/**
 * Details for {@link GooglePlace}, honoring 
 * <a href="https://developers.google.com/places/webservice/details#PlaceDetailsResponses">PlaceDetailsResponses</a>
 */
public class Details {
	
	@Key("address_components")
	private List<AddressComponent> addressComponents;
	
	@Key("events")
	private List<Event> events;
	
	@Key("formatted_address")
	private String formattedAddress;
	
	@Key("geometry")
	private Geometry geometry;
	
	@Key("icon")
	private String iconString;
	
	private URI icon;
	
	@Key("id")
	private String id;
	
	@Key("place_id")
	private String placeId;
	
	@Key("international_phone_number")
	private String internationalPhoneNumber;
	
	@Key("name")
	private String name;	 
	
	@Key("opening_hours")
	private OpeningHours openingHours;	 
	
	@Key("rating")
	private float rating;
	
	@Key("reference")
	private String reference;
	
	@Key("reviews")
	private List<Review> reviews;
	
	@Key("types")
	private Set<GooglePlaceType> types;
		
	@Key("url")
	private String urlString;
	
	@Key("photos")
	private List<Photo> photos;
	
	private URI uri;
	
	@Key("website")
	private String websiteString;		
	
	private URI website;

	public List<AddressComponent> getAddressComponents() {
		return addressComponents;
	}
	
	public List<Event> getEvents() {
		return events;
	}

	public String getFormattedAddress() {
		return formattedAddress;
	}
	
	public Geometry getGeometry() {
		return geometry;
	}
	
	public URI getIcon() {
		if (icon == null) {
			icon = UrlUtils.buildURI(iconString);
		}		
		return icon;
	}

	@Deprecated
	public String getId() {
		return id;
	}

	public String getInternationalPhoneNumber() {
		if (internationalPhoneNumber!=null)
			return internationalPhoneNumber.replaceAll(" ","");
		return "";
	}
	
	public String getName() {
		return name;
	}
	
	public OpeningHours getOpeningHours() {
		return openingHours;
	}
	
	public float getRating() {
		return rating;
	}	

	@Deprecated
	public String getReference() {
		return reference;
	}
	
	public List<Review> getReviews() {
		return reviews;
	}
	
	public Set<GooglePlaceType> getTypes() {
		return types;
	}

	public URI getUri() {
		if (uri == null) {
			uri = UrlUtils.buildURI(urlString);
		}
		return uri;
	}

	public URI getWebsite() {
		if (website == null) {
			website = UrlUtils.buildURI(websiteString);
		}
		return website;
	}
	
	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}
	public List<Photo> getPhotos() {
		return photos;
	}
	
	
	/*public String toString() {
		return 
			"--\n"+Verboser.reflectiveToString(this)+"--\n";
			"--\n"+
			getInternationalPhoneNumber()+"\n"+
			getUri()+"\n"+
			getWebsite()+"\n"+
			"--\n";
	}*/
	
	
	
	/*	 
	@Key("formatted_phone_number")
	private String formattedPhoneNumber;
	 
	public String getFormattedPhoneNumber() {
		return formattedPhoneNumber;
	}*/
	
}
