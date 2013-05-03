package net.iubris.socrates_sample._roboguice.module;

import net.iubris.socrates._roboguice.module.SocratesModule;
import net.iubris.socrates.config.ConfigMandatory;
import net.iubris.socrates.config.ConfigOptional;
import net.iubris.socrates.engines.search.url.annotation.Config;
import net.iubris.socrates_sample.config.ConfigMandatoryImpl;
import net.iubris.socrates_sample.config.ConfigOptionalImpl;

public class SocratesModuleSample extends SocratesModule {

	@Override
	protected void ownConfigure() {
		bind(ConfigMandatory.class).toInstance(new ConfigMandatoryImpl());
		bind(ConfigMandatoryImpl.class).asEagerSingleton();		

		bind(ConfigOptional.class).annotatedWith(Config.class).toInstance(new ConfigOptionalImpl());
		bind(ConfigOptionalImpl.class).asEagerSingleton();
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
