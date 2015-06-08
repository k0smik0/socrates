/*******************************************************************************
 * Copyleft 2013 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * SocratesModuleSample.java is part of Socrates.
 * 
 * 'Socrates' is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 * 
 * 'Socrates' is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with 'Socrates' ; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301 USA
 ******************************************************************************/
package net.iubris.socrates_demo._roboguice.module;

import net.iubris.socrates._di._roboguice.modules.AbstractSocratesBaseModule;
import net.iubris.socrates.config.ConfigMandatory;
import net.iubris.socrates.config.SearchOptions;
import net.iubris.socrates_demo.config.ConfigMandatoryImpl;
import net.iubris.socrates_demo.config.SearchOptionsImpl;

public class SocratesDemoModule extends AbstractSocratesBaseModule {

	@Override
	protected void bindConfigMandatory() {
		bind(ConfigMandatory.class).to(ConfigMandatoryImpl.class);
		bind(ConfigMandatoryImpl.class).asEagerSingleton();
	}

	@Override
	protected void bindSearchOptions() {
		bind(SearchOptions.class)/*.annotatedWith(Config.class)*/.to(SearchOptionsImpl.class);
		bind(SearchOptionsImpl.class).asEagerSingleton();		
	}

	/*
	@Override
	protected void configure() {
		
		
		
		
//		// generics result
//		bind( new TypeLiteral<net.iubris.ulysses.finder.generics.result.PlacesFinder<Place>>() {}).
//			toProvider( new TypeLiteral<net.iubris.ulysses._roboguice.providers.generics.result.PlacesFinderProvider<Place>>() {});
//		
//		// no generics
//		bind( PlacesFinder.class).toProvider( PlacesFinderProvider.class);
//		
//		// generics list
//		bind( new TypeLiteral<net.iubris.ulysses.finder.generics.list.PlacesFinder<ulysses.model.MyPlacesList>>() {}).
//			toProvider( new TypeLiteral<net.iubris.ulysses._roboguice.providers.generics.list.PlacesFinderProvider<ulysses.model.MyPlacesList<Place>,Place>>() {});
//
//		// reflection by name
//		bind(net.iubris.ulysses.finder.nongenerics.reflectionbyname.PlacesFinder.class).
//			toProvider(net.iubris.ulysses._roboguice.providers.nongenerics.reflectionbyname.PlacesFinderProvider.class);
		
		
//		bind(new TypeLiteral<PlacesSearcherGeneric<PlacesSearchResponse>>() {}).
//			toProvider(new TypeLiteral<PlaceFinderProviderGeneric<PlacesSearchResponse>>() {});
		
		//bind(PlaceConfig.class).toProvider(PlaceConfigProvider.class);//.in(Singleton.class);
		
		//bind(PlaceConfigXml.class).toProvider(PlaceConfigXmlProvider.class);
//		bind(PlaceConfig.class).to(PlaceConfigXml.class);
//		bind(PlaceConfigXml.class).toProvider(PlaceConfigXmlProvider.class);
		//bind(PlaceConfigXmlParser.class).toProvider(PlaceConfigXmlParserProvider.class);
		
		
	}
	*/
	
	/*
	@SuppressWarnings("unchecked")
	@Provides
	public Class<net.iubris.ulysses.model.generics.PlacesList<Place>> providesGenericsPlacePlacesListClass() {
		//Class<PlacesList<Place>> clazz = new TypeLiteral<PlacesList<Place>>() {};
		//Type<Place> p = Place.class;
		//PlacesList<Place> pl = new PlacesList<Place>();
		return  (Class<net.iubris.ulysses.model.generics.PlacesList<Place>>) new net.iubris.ulysses.model.generics.PlacesList<Place>().getClass();
	}*/
	/*
	@Provides @PlacesListClass
	public Class<? extends PlacesList> providesPlacesList() {
		net.iubris.ulysses.model.generics.PlacesList<Place> placeList = new net.iubris.ulysses.model.generics.PlacesList<Place>();
		return placeList.getClass();
	}*/
	/*
	@Provides @PlacesParsingClass
	public TypeLiteral<PlacesList<Place>> providesParsingClass() {
		Class<PlacesList<Place>> clazz = (new TypeLiteral<PlacesList<Place>>() {}).getClass();
		return new TypeLiteral<PlacesList<Place>>() {};
	}*/
	
	/*
	@Provides
	public Class<PlacesList> providesNonGenericsPlacePlacesListClass() {
		return  PlacesList.class;
	}*/

}
