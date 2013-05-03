/*******************************************************************************
 * Copyleft 2012 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * PlacesConfigXmlAssetReaderProvider.java is part of socrates_config-xml.
 * 
 * socrates_config-xml is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 * 
 * socrates_config-xml is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with socrates_config-xml ; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301 USA
 ******************************************************************************/
package net.iubris.socrates._roboguice.providers.config.xml;


import org.simpleframework.xml.Serializer;

import net.iubris.prometeus.assets.XmlAssetReader;
import net.iubris.socrates.config.xml.PlaceConfigXml;

import android.content.res.AssetManager;

import com.google.inject.Inject;
import com.google.inject.Provider;


public class PlacesConfigXmlAssetReaderProvider 
//extends XmlAssetReaderProvider<PlaceConfigFromXml> {
implements Provider<XmlAssetReader<PlaceConfigXml>>{

	
	 private AssetManager assetManager;
	 private Serializer serializer;	
	
	//private static XmlReader<PlacesConfig> xmlReader;
	
	@Inject
	public PlacesConfigXmlAssetReaderProvider(Serializer serializer, AssetManager assetManager/* ContextScopedProvider<AssetManager> assetManagerProvider,Context context*/) {
		//super(serializer, assetManager);
		this.serializer = serializer;
		this.assetManager = assetManager;
//Ln.d(Verboser.reflectiveToString(this));
	}

	@Override
	public XmlAssetReader<PlaceConfigXml> get() {
		/*if (xmlReader == null) {
			xmlReader = new XmlReader<PlacesConfig>(assetManager, serializer);
		}
		return xmlReader;
		return super.get();*/
		return new XmlAssetReader<PlaceConfigXml>(serializer, assetManager);
	}

	
}
