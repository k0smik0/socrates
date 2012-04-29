package net.iubris.ulysses.config;

import com.google.inject.Inject;

import net.iubris.ulysses.config.xml.PlaceConfigXml;

public class PlaceConfigFactory {
	
	private PlaceConfigXml placeConfigXml;

	/*
	 * To improve with Preferences
	 */
	@Inject	
	public PlaceConfigFactory(PlaceConfigXml placeConfigXml) {
		this.placeConfigXml = placeConfigXml;
	}
	
	public PlaceConfig getPlaceConfig() {
		return placeConfigXml;/*
			new PlaceConfig() {				
				@Override
				public boolean isUseSensor() {
					return placeConfigXml.isUseSensor();
				}				
				@Override
				public Set<PlaceType> getTypes() {
					return placeConfigXml.getTypes();
				}				
				@Override
				public int getRadius() {
					return placeConfigXml.getRadius();
				}				
				@Override
				public HttpParserOutputType getOutput() {
					return placeConfigXml.getOutput();
				}				
				@Override
				public List<String> getNames() {
					return placeConfigXml.getNames();
				}				
				@Override
				public String getKey() {
					return placeConfigXml.getKey();
				}				
				@Override
				public String getApplicationName() {
					return placeConfigXml.getApplicationName();
				}
			};	
			*/
	}

}
