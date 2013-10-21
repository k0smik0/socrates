#Socrates, a sage google places client.

Did you search for a component responsible for Google Places query
and retrieving result and, finally, bind it into java class? 
There is Socrates.

Why *Socrates*? Because, as homonim philosopher said:
*"sage goes to the market to see, not to buy".*

And so Socrates component just search (google) places.  

 - a simple [video demo](http://www.youtube.com/watch?v=qAdaGxsNMzA)  
 - or you can try the demo:  
    - [apk from "master" branch, on github](https://github.com/k0smik0/socrates/blob/master/demo/build_signed/net.iubris.socrates_demo.apk?raw=true)
  
    
	- [apk from play store](https://play.google.com/store/apps/details?id=net.iubris.socrates_demo) or scan <img src="http://chart.googleapis.com/chart?cht=qr&chs=100x100&choe=UTF-8&chld=H|0&chl=http://goo.gl/O4D3NU"/>
  
  
  
<br/>
###usage:
<pre>
Location here = ... // my last best location
Searcher placesSearcher = ... // manually istanced via getInstance, or use @Inject
placesSearcher.initFromConfig(); // see below for details about config
SearchResponse searchResponse = placesSearcher.search( here ); // or placesSearcher.initFromConfig.search(here);
List&lt;Place&gt; places = searchResponse.getStatus().handleStatusAndGetData(searchResponse);
</pre>
Place is a class mapping json/xml response fields by google search response: [see here](http://developers.google.com/maps/documentation/places/#PlaceSearchResults)

<br/>
do you want Place Details ?
<pre>
String reference = place.getReference();
DetailsRetriever detailsRetriever = .. // manually istanced via getInstance, or use @Inject
DetailsResponse placeDetailsResponse = detailsRetriever.retrieveDetails( reference );
Details placeDetails = placeDetailsResponse.getStatus().handleStatusAndGetData(placeDetailsResponse);
</pre>
Details is (again) a class mapping json/xml response fields by google detail response: [see here](https://developers.google.com/maps/documentation/places/#PlaceDetailsResults)
  
  
  

And something about ConfigMandatory and ConfigOptional:<br/>
they are interfaces used by components Searcher and DetailRetriever, and they provide needed values 
in order to build request 
[(see here)](https://developers.google.com/maps/documentation/places/#PlaceSearchRequests):


<pre>
public interface ConfigMandatory {
	public String getKey(); // Google Places api key
	public String getApplicationName(); // clear, isn't ?
	public HttpParserOutputType getOutput();	// json or xml
	public boolean isUseSensor(); // true if use location sensor (always with android)
}
</pre>
and
<pre>
public interface SearcOptions {
	public Integer getRadius(); // radius within into we search
	public Set<PlaceType> getTypes(); // types we're interesting for: see [types](https://developers.google.com/maps/documentation/places/supported_types)
	public List<String> getNames(); // words within places name - for accurate filter query search
	public RankBy getRankBy(); // the order in which results are listed: distance or prominence (achtung - default if not specified)
	public String getKeyword(); // A term to be matched against
	public Language getLanguage(); // The language code, for localized results
}
</pre>

 
in your application you have to implements these two interfaces, in your preferred way.

Simple classes wrapping all values? Any xml parsers reading values from xml conf files? Other solutions?<br/>

If you use roboguice:
Choise, implement and finally bind via module (and i recommend as singleton) ;D

First interface methods implementation is all mandatory (as the name), while the second not:<br/>
your class will return only really used options, and "null" elsewhere.<br/>
But careful! According to [reference](https://developers.google.com/places/documentation/search?hl=pl#PlaceSearchRequests)
you have to provide radius if rankby is not specified (and it is "prominence" as default), or you have not to include it if "rankby" is "prominence", but one or more of "keyword","name","types" if rankby is "distance" have to be included
<br/><br/>

Searcher class provides a method "setSearchOptions" requesting SearchOptions, if u want change (temporary) your target search<br/>
With "resetSearchOptions" method you can return to default config provided via constructor.

<br/><br/>
In order to compile correctly you have to put various jar in "libs" directory (then move all them in main project "libs" directory):    
  
from [google api java client](http://code.google.com/p/google-api-java-client/wiki/Setup):

- google-api-client-LAST_VERSION.jar 
- google-http-client-LAST_VERSION.jar
- google-http-client-extensions-android2-LAST_VERSION.jar
- [jackson-mini-1.9.LAST_MINOR_VERSION.jar](http://jackson.codehaus.org/1.9.11/jackson-mini-1.9.11.jar)
  
from [roboguice](http://repo1.maven.org/maven2/org/roboguice/roboguice/2.0):
  
- [roboguice-2.0.jar](http://repo1.maven.org/maven2/org/roboguice/roboguice/2.0/roboguice-2.0.jar)
- [javax.inject.jar](http://mavenhub.com/mvn/central/javax.inject/javax.inject/1) 
- [sisu-guice-3.0.3-no_aop.jar](http://mavenhub.com/mvn/central/org.sonatype.sisu/sisu-guice/3.0.0)

  
  
and don't forget to change place api key with your own!


<br/><br/><br/><br/><br/>
heavily ispired by:
[http://ddewaele.blogspot.it/2011/05/introducing-google-places-api.html](http://ddewaele.blogspot.it/2011/05/introducing-google-places-api.html)