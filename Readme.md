#Socrates, a sage google places client.

Did you search for a component which is responsible for query Google Places
and retrieves result and, finally, maps into java class? 
There is Socrates.

Why Socrates? Because, as homonim philopher said:
"sage goes to the market to see, not to buy".

And so Socrates component just search (google) places within bound (as parameter).
<br/><br/><br/><br/>
usage:

Location here = ... // my last best location

PlacesSearcher placesSearcher = ... // you can manually istance, or use roboguice

PlacesSearchResponse placesSearchResponse = placesSearcher.searchPlaces( here );

List<Place> places = placesSearchResponse.getStatus().act(placesSearchResponse);

Place is class which maps json/xml response fields from google:

[PlaceSearchResults](http://developers.google.com/maps/documentation/places/#PlaceSearchResults)




do you want place details ?


<p><code>
String reference = place.getReferenceForDetails();

PlaceDetailsRetriever placeDetailsRetriever = .. // manually or by roboguice

PlaceDetailsResponse placeDetailsResponse = placeDetailsRetriever.retrieveDetails( reference );

PlaceDetails placeDetails = placeDetailsResponse.getStatus().act(placeDetailsResponse);
</p></code>

PlaceDetails is class which maps json/xml response fields from google:
[PlaceDetailsResults](https://developers.google.com/maps/documentation/places/#PlaceDetailsResults)


PlaceConfig is interface used by components above, which provides needed values:

<p><code>
public interface PlaceConfig {
	public String getKey(); // places api key
	public int getRadius(); // radius within into we search
	public String getApplicationName(); // clear, isn't ? 
	public HttpParserOutputType getOutput();	// json or xml
	public Set<PlaceType> getTypes();	// 
	types we're interesting for: see [places/supported_types] (https://developers.google.com/maps/documentation/places/supported_types)
	public List<String> getNames(); // words within places name - for accurate filter query search 
	public boolean isUseSensor(); // true if use location sensor (always with android) 
}
</p></code>
 
in your application you have to implements this interface, in way you prefer.
Again, i recommend roboguice for bind PlaceConfig to PlaceConfigImplPreferred.
A simple class which wrap all values? A xml parser which read values from xml conf files? 
Choise, implement and bind.


heavily ispired by:
http://ddewaele.blogspot.it/2011/05/introducing-google-places-api.html
