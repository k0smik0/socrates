package socrates.test.vanilla;

import java.util.Iterator;
import java.util.List;

import net.iubris.socrates.config.ConfigMandatory;
import net.iubris.socrates.config.SearchOptions;
import net.iubris.socrates.engines.details.DetailsRetriever;
import net.iubris.socrates.engines.details.exception.DetailsRetrieverException;
import net.iubris.socrates.engines.search.Searcher;
import net.iubris.socrates.engines.search.exception.MalformedSearchUrlConfigException;
import net.iubris.socrates.engines.search.exception.PlacesSearcherException;
import net.iubris.socrates.factory.base.SocratesBaseFactory;
import net.iubris.socrates.model.http.response.data.details.Details;
import net.iubris.socrates.model.http.response.data.details.OpeningHours;
import net.iubris.socrates.model.http.response.data.details.Period;
import net.iubris.socrates.model.http.response.data.details.review.AspectRating;
import net.iubris.socrates.model.http.response.data.details.review.Review;
import net.iubris.socrates.model.http.response.data.events.Event;
import net.iubris.socrates.model.http.response.data.search.GooglePlace;
import net.iubris.socrates.model.http.response.details.DetailsResponse;
import net.iubris.socrates.model.http.response.search.SearchResponse;

import org.junit.Before;
import org.junit.Test;

import socrates.test.config.ConfigMandatoryImpl;
import socrates.test.config.SearchOptionsImpl;
import android.location.Location;


//@RunWith(RobolectricTestRunner.class)
public class SocratesTest {

	private Searcher placeSearcher;
	private DetailsRetriever placeDetailsRetriever;
	
	private Location location;
	
	private SearchResponse searchResponse;

	private int placeNumber = 1;
	
	private double latitude;
	private double longitude;
	
	public SocratesTest() {
//		location = new Location("GPS");
//		location.setLatitude(44.4937382342);
//		location.setLongitude(11.3769477681);
		
		latitude = 44.4937382342;
		longitude = 11.3769477681;
		
		SearchOptions searchOptions = new SearchOptionsImpl();
		ConfigMandatory configMandatory = new ConfigMandatoryImpl();
		
		try {
			placeSearcher = SocratesBaseFactory.getSearcher(searchOptions, configMandatory);
			placeDetailsRetriever = SocratesBaseFactory.getDetailsRetriever(searchOptions, configMandatory);
		} catch (MalformedSearchUrlConfigException e) {
			e.printStackTrace();
		}
	}
		
	@Before
	public void searchLocations() {
		try {
//			placeSearcher.initFromConfig(configOptional);
//			System.out.println( "RequestUrl: "+placeSearcher.getRequestUrl() );
//			searchResponse = placeSearcher.search(location);
			searchResponse = placeSearcher.search(latitude, longitude);
			
			System.out.println( "RequestUrl: "+placeSearcher.getRequestUrl() );
			System.out.println( "status reason:" +searchResponse.getStatus().getReason());			
		} catch (PlacesSearcherException e) {
			e.printStackTrace();
		}/* catch (LocationNullException e) {
			e.printStackTrace();
		}*/
	}
	
	
	@Test
	public void findLocationsWithDetails() {
		System.out.println("\n");
		printCalledMethod("");
		try {
			printResultsWithDetail(searchResponse.getResults(),placeNumber);
		} catch (DetailsRetrieverException e) {
			e.printStackTrace();
		}
		//System.out.println("-- findLocationsDetails --\n");
		printCalledMethod("\n");
	}
	
	private void printCalledMethod(String newLine){
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();		
		System.out.println("--"+stackTrace [ 2 ].getMethodName()+" --"+newLine);		
	}
	
	
	private void printResults(List<GooglePlace> places,int i) {
		for (GooglePlace p: places) {
			System.out.print(i+" ");
			System.out.print(p.getName()+" ");
			//System.out.println(p.getGeometry().getGeoPoint());
			net.iubris.socrates.model.http.response.data.geocoding.Location loc = p.getGeometry().getLocation();
			System.out.println(loc.getLatitude()+","+loc.getLongitude());
			i++;
		}
	}
	
	
	
	private void printResultsWithDetail(List<GooglePlace> places,int i) throws DetailsRetrieverException {
		for (GooglePlace p: places) {
			System.out.print(i+" ");
			System.out.print(p.getName()+" ");			
			//System.out.println(p.getGeometry().getGeoPoint());
			System.out.print(p.getGeometry().getLocation().getLatitude()+" "+p.getGeometry().getLocation().getLongitude()+" ");
			
			String reference = p.getPlaceId();
			//System.out.println(reference);
			DetailsResponse placeDetailsResponse = placeDetailsRetriever.retrieve(reference);
			
			Details result = placeDetailsResponse.getResult();
			
			System.out.println( result.getUri()+" "+result.getFormattedAddress() +" "+result.getWebsite()+" ");
			printOpening( result.getOpeningHours() );
			printEvents( result.getEvents() );			
			printReviews(result.getReviews());
			
			System.out.println("");
			
			i++;
		}
	}
	
	private void printOpening(OpeningHours openingHours) {
		if (openingHours == null) return;
		System.out.println("Opening:");
		for (Period p: openingHours.getPeriods()) {
			try {
			System.out.println( "\t"+p.getOpen().getDay() + ": " +p.getOpen().getTime() + " - "+p.getClose().getTime() );
			} catch (NullPointerException e) {}
		}		
	}

	private void printEvents(List<Event> events){
		if (events==null) return;
		if (events.isEmpty()) return;
		System.out.println("Events:");
		Iterator<Event> iterator = events.iterator();
		while(iterator.hasNext()) {
			Event event = iterator.next();
			System.out.println( "\t"+event.getSummary()+" "+event.getStartTime() );
		}
	}
	
	private void printReviews(List<Review> reviews){
		if (reviews==null) return;
		if (reviews.isEmpty()) return;
		System.out.println("Reviews:");
		Iterator<Review> iterator = reviews.iterator();
		while(iterator.hasNext()) {
			Review review = iterator.next();
			System.out.println( "\t"+review.getAuthorName()+": "+review.getText() );
			List<AspectRating> aspects = review.getAspects();
			
			if(aspects==null) break;
			//System.out.println(aspects.size());
			Iterator<AspectRating> iterator2 = aspects.iterator();
			while (iterator2.hasNext() ){
				AspectRating aspectRating = iterator2.next();
				System.out.println( "\t\t"+aspectRating.getType() + " " +aspectRating.getRating() );
			}
		}
	}
	
	@Test
	public void findNext() throws InterruptedException {
		System.out.println("\n");
		printCalledMethod("");
		System.out.println( "searchResponse: "+searchResponse.toString() );
		String nextPageToken = searchResponse.getNextPageToken();
		if (nextPageToken!=null) {
			Thread.sleep(10*1000);
			//System.out.println("token not null");
			SearchResponse nextSearchResponse =null;
			try {
				nextSearchResponse = placeSearcher.search(nextPageToken);
				System.out.println( "nextSearchResponse.getStatus(): "+ nextSearchResponse.getStatus() );
			} catch (PlacesSearcherException e) {
				e.printStackTrace();
			}
			printResults(nextSearchResponse.getResults(),placeNumber);
		}
		printCalledMethod("\n");
	}
	
	
	
	//@Test
	public void retrieveDetails() {
		System.out.println("-- findLocationsDetails --");			
		try {
			SearchResponse  placeList = 
//					placeSearcher.search(location);
					placeSearcher.search(latitude, longitude);
			for (GooglePlace place: placeList.getResults()) {
				String reference = place.getPlaceId();
				DetailsResponse placeDetailsResponse = placeDetailsRetriever.retrieve(reference);
				System.out.print("InternationalPhoneNumber: "+placeDetailsResponse.getResult().getInternationalPhoneNumber()+" ");
				System.out.println("details: "+placeDetailsResponse.getResult().getUri());
				
				List<Event> events = placeDetailsResponse.getResult().getEvents();
				while (events != null && events.iterator().hasNext()) {
					System.out.println("event: "+events.iterator().next());
				}
			}
		} catch (PlacesSearcherException e) {				
			e.printStackTrace();
		} catch (DetailsRetrieverException e) {				
			e.printStackTrace();
		}/* catch (LocationNullException e) {
			e.printStackTrace();
		}*/
		System.out.println("-- findLocationsDetails --\n");
	}
	/*
	@Test
	public void findLocationsOtherType() {
		System.out.println("-- findLocationsOtherType --");
		try {
			Set<PlaceType> placeTypes = new HashSet<PlaceType>();
			placeTypes.add( PlaceType.hospital);
			PlacesSearchResponse placeList = placeFinder.findPlaces(location,placeTypes);
			System.out.println(placeList.getStatus().getReason());
			for (GooglePlace p: placeList.getResults()) {
				System.out.println(p);
			}
		} catch (PlacesFinderException e) {
			e.printStackTrace();
		}
		System.out.println("-- findLocationsOtherType --\n");
	}
	*/
}

