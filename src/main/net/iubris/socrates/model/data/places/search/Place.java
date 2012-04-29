package net.iubris.socrates.model.data.places.search;

import java.util.Set;

import net.iubris.socrates.model.data.geocoding.Geometry;
import net.iubris.socrates.model.data.places.PlaceType;


import com.google.api.client.util.Key;

public class Place {	

	@Key("geometry")
	private Geometry geometry;
	
	@Key("icon")
	private String icon;
	
	@Key("id")
	private String id;	
	  
	@Key("name")
	private String name;	 
	
	@Key("rating")
	private float rating;
	 
	@Key("reference")
	private String referenceForDetails;
	
	@Key("types")
	private Set<PlaceType> types;
		 
	@Key("vicinity")
	private String vicinity;
	 
	
	
	public String getIcon() {
		return icon;
	}	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public float getRating() {		
		return rating;
	}
	public Geometry getGeometry() {
		return geometry;
	}	
	public Set<PlaceType> getTypes() {		
		return types;
	}	
	public String getVicinity() {
		return vicinity;
	}
	public String getReferenceForDetails() {
		return referenceForDetails;
	}
	/*public String toString() {
		return "--\n"+Verboser.reflectiveToString(this)+"--\n";
	}*/
}
