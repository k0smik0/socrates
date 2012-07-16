/*******************************************************************************
 * Copyleft 2012 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * SearchRequestUrlBuilder.java is part of 'Socrates'
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
package net.iubris.socrates.engines.search.url;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import net.iubris.socrates.engines.base.url.builders.AbstractRequestUrlBuilder;
import net.iubris.socrates.engines.search.url.annotation.SearchRequestMandatoryUrl;
import net.iubris.socrates.model.http.request.url.language.Language;
import net.iubris.socrates.model.http.request.url.parameters.mandatory.search.SearchMandatoryParameter;
import net.iubris.socrates.model.http.request.url.parameters.optional.search.SearchOptionalParameter;
import net.iubris.socrates.model.http.request.url.parameters.optional.search.values.RankBy;
import net.iubris.socrates.model.http.response.data.search.PlaceType;
import android.location.Location;

import com.google.api.client.http.GenericUrl;
import com.google.inject.Inject;

public class SearchRequestUrlBuilder extends AbstractRequestUrlBuilder<SearchRequestUrlBuilder> {
	
	//private final PlaceConfig placeConfig;

	//@Inject
	/*
	public PlacesSearchRequestUrlBuilder(PlacesSearchRequestMandatoryUrlBuilder requestUrlMandatory, 
			PlaceConfig placeConfig) {
		super(requestUrlMandatory
		//placesConfig
		);
		this.placeConfig = placeConfig;
	}*/
	
	@Inject
	public SearchRequestUrlBuilder(@SearchRequestMandatoryUrl GenericUrl requestUrl) {
		super(requestUrl);
	}
	
	/*
	@Override
	public SearchRequestUrlBuilder resetUrl() {
		resetUrlFromSuperClass();
		return this;
	}*/
	
	public SearchRequestUrlBuilder setRadius(Integer radius) {
		//setValue(buildedUrl, PlaceUrlConfigParameter.radius, radius);
		setParameterValue(SearchOptionalParameter.radius, ""+radius );
		return this;
	}
	public SearchRequestUrlBuilder removeRadius() {
		//setValue(buildedUrl, PlaceUrlConfigParameter.radius, radius);
		buildedUrl.set(SearchOptionalParameter.radius.name(),"");
		//setParameterValue(SearchOptionalParameter.radius);
		//System.out.println("SearchRequestUrlBuilder: "+buildedUrl);
		return this;
	}
	
	/*
	public SearchRequestUrlBuilder setRadius() {
		setRadius( placeConfig.getRadius() );
		return this;
	}
	*/
	
	public SearchRequestUrlBuilder setLocation(Location location) {
		//if (location != null) {
			//setValue(buildedUrl,  PlaceUrlConfigParameter.location, location.getLatitude()+","+location.getLongitude());		
			setParameterValue(SearchMandatoryParameter.location, location.getLatitude()+","+location.getLongitude());		
		//}
		return this;
	}
	
	public SearchRequestUrlBuilder setNames(List<String> names) {
		if (checkCollection(names)) {
			//setValue(buildedUrl, PlaceUrlConfigParameter.names, buildNamesValueString(names));
			setParameterValue(SearchOptionalParameter.names, buildNamesValueString(names));
		}
		return this;
	}
	
	public SearchRequestUrlBuilder setTypes(Set<PlaceType> types) {		
		//setValue(buildedUrl, PlaceUrlConfigParameter.types, buildTypesValueString(types));
		setParameterValue(SearchOptionalParameter.types, buildTypesValueString(types));
		return this;
	}	
	
	/*
	public SearchRequestUrlBuilder setRadiusAndTypesAndNames() {
		setRadius( placeConfig.getRadius()).
			setTypes( placeConfig.getTypes() ).
				setNames( placeConfig.getNames() );
		return this;		
	}*/
	
	
	public SearchRequestUrlBuilder setLanguage(Language language) {
		setParameterValue(SearchOptionalParameter.language, language.getLanguageCode());
		return this;
	}
	
	public SearchRequestUrlBuilder setKeyword(String keyword) {
		setParameterValue(SearchOptionalParameter.keyword, keyword);
		return this;
	}
	
	public SearchRequestUrlBuilder setRankBy(RankBy rankBy) {
		setParameterValue(SearchOptionalParameter.rankby, rankBy.name());
		return this;
	}
	
	
	public SearchRequestUrlBuilder setNextPageToken(String nextPageToken) {
		setParameterValue(SearchOptionalParameter.pagetoken, nextPageToken);
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
