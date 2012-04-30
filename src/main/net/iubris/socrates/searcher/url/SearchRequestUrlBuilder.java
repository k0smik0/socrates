/*******************************************************************************
 * Copyleft 2012 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * SearchRequestUrlBuilder.java is part of socrates.
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
package net.iubris.socrates.searcher.url;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import net.iubris.socrates.config.PlaceConfig;
import net.iubris.socrates.model.data.places.PlaceType;
import net.iubris.socrates.url.PlaceUrlConfigParameter;
import net.iubris.socrates.url.builders.AbstractPlacesRequestUrlBuilder;
import android.location.Location;

import com.google.inject.Inject;

public class SearchRequestUrlBuilder extends AbstractPlacesRequestUrlBuilder<SearchRequestUrlBuilder> {
	
	@Inject
	public SearchRequestUrlBuilder(SearchRequestUrlMandatoryBuilder requestUrlMandatory, 
			PlaceConfig placesConfig) {
		super(requestUrlMandatory,placesConfig);
	}
	
	@Override
	public SearchRequestUrlBuilder resetUrl() {
		resetUrlFromSuperClass();
		//super.resetUrl();
		return this;
	}
	
	public SearchRequestUrlBuilder buildUrl(Integer radius) {
		//setValue(buildedUrl, PlaceUrlConfigParameter.radius, radius);
		setValue(PlaceUrlConfigParameter.radius, radius);
		return this;
	}
	
	public SearchRequestUrlBuilder buildUrl(Location location) {
		//if (location != null) {
			//setValue(buildedUrl,  PlaceUrlConfigParameter.location, location.getLatitude()+","+location.getLongitude());		
			setValue(PlaceUrlConfigParameter.location, location.getLatitude()+","+location.getLongitude());		
		//}
		return this;
	}
	
	public SearchRequestUrlBuilder buildUrl(List<String> names) {
		if (checkCollection(names)) {
			//setValue(buildedUrl, PlaceUrlConfigParameter.names, buildNamesValueString(names));
			setValue(PlaceUrlConfigParameter.names, buildNamesValueString(names));
		}
		return this;
	}
	
	public SearchRequestUrlBuilder buildUrl(Set<PlaceType> types) {		
		//setValue(buildedUrl, PlaceUrlConfigParameter.types, buildTypesValueString(types));
		setValue(PlaceUrlConfigParameter.types, buildTypesValueString(types));
		return this;
	}
	
	public SearchRequestUrlBuilder initConfigRadius() {
		buildUrl( placeConfig.getRadius());
		return this;
	}
	
	public SearchRequestUrlBuilder initConfigRadiusTypesNames() {
		buildUrl( placeConfig.getRadius()).
			buildUrl( placeConfig.getTypes() ).
				buildUrl( placeConfig.getNames() );
		return this;		
	} 	

	private boolean checkCollection(Collection<?> collection) {
		if (collection != null && collection.size() > 0) return true;
		return false;
	}
	
	private String buildNamesValueString(List<String> list) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i=0;i<list.size()-1;i++) {
			stringBuilder.append(list.get(i));
			stringBuilder.append(LIST_SEPARATOR);
		}
		stringBuilder.append(list.get(list.size()-1));		
		//return Uri.encode( stringBuilder.toString() );
		return stringBuilder.toString();
	}
	
	private String buildTypesValueString(Set<PlaceType> types) {		
		List<String> stringList = new ArrayList<String>();
		for (PlaceType pt: types) {
			stringList.add(pt.name());
		}
		return buildNamesValueString(stringList);
	}
	
	private static final String LIST_SEPARATOR = "|";

}
