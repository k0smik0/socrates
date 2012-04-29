package net.iubris.ulysses._roboguice.providers.base;

import net.iubris.prometeus.assets.XmlAssetReader;
import net.iubris.prometeus.assets.exceptions.XmlAssetReaderFileNotFoundException;
import net.iubris.prometeus.base.exceptions.XmlReaderParsingException;
import net.iubris.ulysses.config.xml.PlaceConfigXml;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class PlaceConfigXmlProvider implements Provider<PlaceConfigXml> {

	private XmlAssetReader<PlaceConfigXml> xmlAssetReader;
	
	private static PlaceConfigXml placeConfig;
	
	@Inject
	public PlaceConfigXmlProvider(XmlAssetReader<PlaceConfigXml> xmlAssetReader) {
		this.xmlAssetReader = xmlAssetReader;
	}

	@Override
	public PlaceConfigXml get() {
		if (placeConfig == null) {
			try {
	//Ln.d(xmlAssetReader.toString());				
				placeConfig = xmlAssetReader.parse("places_config.xml", PlaceConfigXml.class);
			} catch (XmlAssetReaderFileNotFoundException e) {
				e.printStackTrace();
			} catch (XmlReaderParsingException e) {
				e.printStackTrace();
			}
		}
		return placeConfig;
	}
}
