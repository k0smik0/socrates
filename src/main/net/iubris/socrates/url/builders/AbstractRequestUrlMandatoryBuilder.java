package net.iubris.socrates.url.builders;

import net.iubris.socrates.config.PlaceConfig;
import net.iubris.socrates.url.AbstractPlaceUrl;
import net.iubris.socrates.url.PlaceUrlMandatoryParameter;

import com.google.api.client.http.GenericUrl;

public abstract class AbstractRequestUrlMandatoryBuilder {

	private final GenericUrl genericUrl;
	
	public AbstractRequestUrlMandatoryBuilder(AbstractPlaceUrl placeUrl, PlaceConfig placeConfig) {
		genericUrl = placeUrl.getUrl();//.clone();
		genericUrl.appendRawPath("/"+placeConfig.getOutput().name());

		setValue(PlaceUrlMandatoryParameter.key, placeConfig.getKey());
		setValue(PlaceUrlMandatoryParameter.sensor, placeConfig.isUseSensor());	
	}
	
	private void setValue(PlaceUrlMandatoryParameter placeUrlParameter, Object value) {
		genericUrl.put(placeUrlParameter.name(), value);
	}
	
	public GenericUrl getUrl() {
		return genericUrl;
	}
	
}
