package net.iubris.socrates.model.data.places.details;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import net.iubris.socrates.model.data.geocoding.AddressComponent;

import com.google.api.client.util.Key;

public class PlaceDetails {
	
	@Key("address_components")
	private List<AddressComponent> addressComponents;
	
	@Key("formatted_address")
	private String formattedAddress;	
	
	@Key("id")
	private String id;
	
	@Key("international_phone_number")
	private String internationalPhoneNumber;
		
	@Key("url")
	private String urlString;
	
	private URI uri;
	
	@Key("website")
	private String websiteString;		
	
	private URI website;
	
	@Key("reference")
	private String reference;
	

	public List<AddressComponent> getAddressComponents() {
		return addressComponents;
	}

	public String getFormattedAddress() {
		return formattedAddress;
	}

	public String getId() {
		return id;
	}

	public String getInternationalPhoneNumber() {
		return internationalPhoneNumber.replaceAll(" ","");
	}

	public URI getUri() {
		if (uri == null) {
			uri = buildURI(urlString);
		}
		return uri;
	}

	public URI getWebsite() {
		if (website == null) {
			website = buildURI(websiteString);
		}
		return website;
	}
	
	public String getReference() {
		return reference;
	}
	
	/*public String toString() {
		return 
			"--\n"+Verboser.reflectiveToString(this)+"--\n";
			"--\n"+
			getInternationalPhoneNumber()+"\n"+
			getUri()+"\n"+
			getWebsite()+"\n"+
			"--\n";
	}*/
	
	private static URI buildURI(String urlString) {
		try {
			if (urlString != null) {			
				return new URI(urlString);
			}
		} catch (URISyntaxException e) {
			System.out.println(e.getClass());
			e.printStackTrace();		 
		}
		return null;
	}
	
	/*	 
	@Key("formatted_phone_number")
	private String formattedPhoneNumber;
	 
	public String getFormattedPhoneNumber() {
		return formattedPhoneNumber;
	}*/
	
}
