#Socrates, a sage google places client.

Did you search for a component which is responsible for query Google Places
and retrieves result and, finally, maps into java class? 
There is Socrates.

Why *Socrates*? Because, as homonim philosopher said:
*"sage goes to the market to see, not to buy".*

And so Socrates component just search (google) places.

<br/><br/>

###usage:<br/><br/>
<pre>
Location here = ... // my last best location
Searcher placesSearcher = ... // manually istanced via getInstance, or use @Inject
placesSearcher.initFromConfig(); // see below for details about config
SearchResponse searchResponse = placesSearcher.search( here ); // or placesSearcher.initFromConfig.search(here);
List&lt;Place&gt; places = searchResponse.getStatus().act(searchResponse);
</pre>
Place is class which maps json/xml response fields from google: [see here](http://developers.google.com/maps/documentation/places/#PlaceSearchResults)

<br/><br/>
do you want place details ?
<pre>
String reference = place.getReference();
DetailsRetriever detailsRetriever = .. // manually istanced via getInstance, or use @Inject
DetailsResponse placeDetailsResponse = detailsRetriever.retrieveDetails( reference );
Details placeDetails = placeDetailsResponse.getStatus().act(placeDetailsResponse);
</pre>
Details is class mapping json/xml response fields from google: [see here](https://developers.google.com/maps/documentation/places/#PlaceDetailsResults)
<br/><br/><br/><br/>
And something about ConfigMandatory and ConfigOptional, interfaces used by components above and providing needed values in order to build request [(see here)](https://developers.google.com/maps/documentation/places/#PlaceSearchRequests):


<pre>
public interface ConfigMandatory {
	public String getKey(); // places api key
	public String getApplicationName(); // clear, isn't ?
	public HttpParserOutputType getOutput();	// json or xml
	public boolean isUseSensor(); // true if use location sensor (always with android)
}
</pre>
and
<pre>
public interface ConfigOptional {
	public Integer getRadius(); // radius within into we search
	public Set<PlaceType> getTypes(); // types we're interesting for: see [https://developers.google.com/maps/documentation/places/supported_types](https://developers.google.com/maps/documentation/places/supported_types)
	public List<String> getNames(); // words within places name - for accurate filter query search
	public RankBy getRankBy(); // the order in which results are listed: distance or prominence (importance - default if not specified)
	public String getKeyword(); // A term to be matched against
	public Language getLanguage(); // The language code, for results
}
</pre>

 
in your application you have to implements these two interfaces, in way you prefer.

Simple classes wrapping all values? Any xml parsers reading values from xml conf files? Other solutions?<br/>
Choise, implement and finally bind via roboguice module (and i recommend as singleton) ;D

First interface implementation is mandatory (as the name), while the second not.
And for ConfigOptional, you must bind specifiyng its annotation, as below:
<pre>bind(ConfigOptional.class).annotatedWith(Config.class).toInstance(new ConfigOptionalImpl());</pre>
This bind is requested in order to have Searcher's setConfig injected and configOptional field properly assigned (if this field is null initConfig method will throw exception)    
<br/><br/><br/><br/><br/>
heavily ispired by:
[http://ddewaele.blogspot.it/2011/05/introducing-google-places-api.html](http://ddewaele.blogspot.it/2011/05/introducing-google-places-api.html)