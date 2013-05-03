package net.iubris.socrates_sample.config;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.iubris.socrates.config.ConfigOptional;
import net.iubris.socrates.model.http.request.url.language.Language;
import net.iubris.socrates.model.http.request.url.parameters.optional.search.values.RankBy;
import net.iubris.socrates.model.http.response.data.search.PlaceType;

public final class ConfigOptionalImpl implements ConfigOptional {
	public ConfigOptionalImpl() {
		System.out.println("ConfigOptionalImpl: "+this.hashCode());
	}
	

	@Override
	public Set<PlaceType> getTypes() {
		HashSet<PlaceType> hashSet = new HashSet<PlaceType>();
		hashSet.add(PlaceType.bar);
		hashSet.add(PlaceType.cafe);
		return hashSet;
	}

	

	@Override
	public List<String> getNames() {				
		return null;
	}

	@Override
	public Integer getRadius() {
		return 5000;
		//return null;
	}
	
	@Override
	public RankBy getRankBy() {
		//return RankBy.distance;
		return RankBy.prominence;
	}
	@Override
	public String getKeyword() {
		return "";
	}
	@Override
	public Language getLanguage() {
		return Language.italian;
	}
}