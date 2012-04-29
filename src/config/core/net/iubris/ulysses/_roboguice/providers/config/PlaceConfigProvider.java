package net.iubris.ulysses._roboguice.providers.config;

import net.iubris.ulysses.config.PlaceConfig;
import net.iubris.ulysses.config.PlaceConfigFactory;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class PlaceConfigProvider implements Provider<PlaceConfig> {

	//private PlaceConfigXmlParser placeConfigXmlParser;
	private PlaceConfigFactory placeConfigFactory;
	
	@Inject	
	public PlaceConfigProvider(PlaceConfigFactory placeConfigFactory) {
		this.placeConfigFactory = placeConfigFactory;
	}

	@Override
	public PlaceConfig get() {
		return placeConfigFactory.getPlaceConfig();
	}	
	
}
