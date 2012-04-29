package net.iubris.ulysses.config.sharedpreferences;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.inject.Inject;

import net.iubris.ulysses.config.PlaceConfigImpl;
import net.iubris.ulysses.model.data.PlaceType;
import net.iubris.ulysses.url.PlaceUrlConfigParameter;
import net.iubris.ulysses.url.PlaceUrlMandatoryParameter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;

public class PlaceConfigPreferencesListener implements OnSharedPreferenceChangeListener {

	private final SharedPreferences sharedPreferences;	
	private final PlaceConfigImpl placeConfigImpl;
	
	@Inject
	public PlaceConfigPreferencesListener(SharedPreferences sharedPreferences,
			PlaceConfigImpl placeConfigImpl) {
		this.sharedPreferences = sharedPreferences;
		this.placeConfigImpl = placeConfigImpl;
	}

	public void register() {
		sharedPreferences.registerOnSharedPreferenceChangeListener(this);
	}
	
	public void unregister() {
		sharedPreferences.unregisterOnSharedPreferenceChangeListener(this);
	}
		
	@Override
	public void onSharedPreferenceChanged(SharedPreferences sharedPreferences,
			String key) {
		/*
		 * se key è un PlaceUrlParameter
		 * 		prendo il valore mappato da key e lo setto nel relativo membro di PlaceConfig
		 */
		if (!isParameterUrl(key)) return ;
		
		switch(PlaceUrlConfigParameter.valueOf(key)) {
			case names:
				final String names = sharedPreferences.getString(PlaceUrlConfigParameter.names.name(), "");
				placeConfigImpl.setNames( stringToStringArray(names) );
				return ;
			case radius:
				final int radius = sharedPreferences.getInt(PlaceUrlConfigParameter.radius.name(), 0);
				placeConfigImpl.setRadius(radius);
				return ;
			case types:
				final String types = sharedPreferences.getString(PlaceUrlConfigParameter.types.name(), "");
				placeConfigImpl.setTypes( stringToPlaceTypeArray(types) );
				return ;								
		}
		
			//getValue(key, placeConfig.getMembersClassMap(PlaceUrlParameter.valueOf(key) ) );
		
		//key(key,PlaceUrlParameter.valueOf(key));
		
	}	
	
	private static List<String> stringToStringArray(String string) {
		return Arrays.asList( string.split(" ") );
	}
	
	private static Set<PlaceType> stringToPlaceTypeArray(String string) {
		final Set<PlaceType> types = new HashSet<PlaceType>();
		final List<String> typesStrings = stringToStringArray(string);
		for (String typesString: typesStrings) {
			types.add( PlaceType.valueOf(typesString));
		}
		return types;
	}
	
		
	public boolean getValue(String key, Boolean bool ) {
		return sharedPreferences.getBoolean(key, false);
	}
		
	public Integer getValue(String key, Integer integer) {
		return sharedPreferences.getInt(key, 0);
	}
		
	private boolean isParameterUrl(String key) {
		if (key.equals(PlaceUrlMandatoryParameter.valueOf(key))) return true;
		return false;
	}
		
	private void key(String key, PlaceUrlMandatoryParameter placeUrlParameter) {
		if (key.equals(PlaceUrlMandatoryParameter. valueOf(key))) {
			sharedPreferences.getInt(key, placeConfigImpl.getRadius());
		}
		//PlaceUrlParameter.key.
	}
		
		
		
		
	
}
