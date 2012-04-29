package net.iubris.socrates.model.data.geocoding;

import java.util.Set;

import com.google.api.client.util.Key;

public class AddressComponent {
	
	@Key("long_name")
	private String longName;
	
	@Key("short_name")
	private String shortName;
	
	@Key("types")
	//private Set<String> addressTypesStrings;	
	private Set<AddressType> addressTypes;

	public String getLongName() {
		return longName;
	}
	public String getShortName() {
		return shortName;
	}
	public Set<AddressType> getAddressTypes() {
		/*if (addressTypes == null) {
			addressTypes = new HashSet<AddressType>();
			for (String addressTypeString: addressTypesStrings) {
				addressTypes.add( AddressType.valueOf(addressTypeString));
			}
		}*/
		return addressTypes;
	}
	
	/*public String toString() {
		//return "--\n"+Verboser.reflectiveToString(this)+"\n"+"addressTypes: "+getAddressTypes()+"--\n";		
		return "--\n"+Verboser.reflectiveToString(this)+"--\n";
	}*/
}
