/*******************************************************************************
 * Copyleft 2012 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * SocratesModuleDemo.java is part of 'Socrates'
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
package socrates.test._roboguice.module;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.iubris.socrates.config.PlaceConfig;
import net.iubris.socrates.model.data.search.PlaceType;
import net.iubris.socrates.model.url.output.HttpParserOutputType;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.inject.AbstractModule;

public class SocratesModuleDemo extends AbstractModule /*SocratesModule*/ {

	@Override
	protected void configure() {
		
		/*
		bind(new TypeLiteral<PlacesFinderGeneric<PlacesList>>() {}).
			toProvider( new TypeLiteral<PlaceFinderProviderGeneric<PlacesList>>(){});
		*/
		
		//super.configure();
		
		//bind(PlaceConfig.class).to(PlaceConfigXml.class);
		//bind(PlaceConfigXml.class).toProvider(PlaceConfigXmlProvider.class);
		
		bind(PlaceConfig.class).toInstance(new PlaceConfig() {			
			@Override
			public boolean isUseSensor() {
				return true;
			}			
			@Override
			public Set<PlaceType> getTypes() {
				HashSet<PlaceType> hashSet = new HashSet<PlaceType>();
				hashSet.add(PlaceType.bar);
				hashSet.add(PlaceType.cafe);
				return hashSet;
			}			
			@Override
			public int getRadius() {
				return 3000;
			}			
			@Override
			public HttpParserOutputType getOutput() {				
				return HttpParserOutputType.json;
			}			
			@Override
			public List<String> getNames() {				
				return null;
			}			
			@Override
			public String getKey() {				
				return "AIzaSyAfOlNmRr5G-4BPDd1faYsn9kvkV5ebBRk";
			}			
			@Override
			public String getApplicationName() {				
				return "SocratesTest";
			}
		});
		
		//bindConstant().annotatedWith(PlacesKeyPassphrase.class).to("ulyss3sd3m0pl4c3s4p|k3y");
	}
	
	/*@Provides @PlacesHttpTransport
	public HttpTransport providesHttpTransport() {
		return  new NetHttpTransport();
		//return AndroidHttp.newCompatibleTransport();
	}*/
	
	//@Override
	public HttpTransport providesHttpTransport() {
		return  new NetHttpTransport();
		//return super.providesHttpTransport();
	}
	
	/*
	@Provides
	Class<PlacesList> providePlaceListClass() {
		return PlacesList.class;
	}*/
	
	

}
