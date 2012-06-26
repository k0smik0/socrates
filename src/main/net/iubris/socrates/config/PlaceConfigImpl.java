/*******************************************************************************
 * Copyleft 2012 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * PlaceConfigImpl.java is part of 'Socrates'
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
package net.iubris.socrates.config;

import java.util.List;
import java.util.Set;

import net.iubris.ulysses.model.data.PlaceType;
import net.iubris.ulysses.url.HttpParserOutputType;

public class PlaceConfigImpl implements PlaceConfig {
		
	private String key;
	private int radius;
	private boolean useSensor;
	private HttpParserOutputType output;
	private String applicationName;
	private Set<PlaceType> types;
	private List<String> names;
	//private Map<PlaceUrlParameter,Object> map;
	
	public PlaceConfigImpl(){}
	
	public PlaceConfigImpl(String key, 
			int radius, 
			boolean useSensor,
			HttpParserOutputType output, 
			String applicationName,
			Set<PlaceType> types,
			List<String> names ) {
		//map = new HashMap<PlaceUrlParameter, Object>();
		this.key = key;
			//map.put(PlaceUrlParameter.key, key);
		this.radius = radius;
		this.useSensor = useSensor;
		this.output = output;
		this.applicationName = applicationName;
		this.types = types;
		this.names = names;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public boolean isUseSensor() {
		return useSensor;
	}

	public void setUseSensor(boolean useSensor) {
		this.useSensor = useSensor;
	}

	public HttpParserOutputType getOutput() {
		return output;
	}

	public void setOutput(HttpParserOutputType output) {
		this.output = output;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public Set<PlaceType> getTypes() {
		return types;
	}

	public void setTypes(Set<PlaceType> types) {
		this.types = types;
	}

	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}	
	
	
	/*
	public String toString() {
		return Verboser.reflectiveToString(this);
	}*/

	
	/*
	public Object getMembersClassMap(PlaceUrlParameter placeUrlParameter) {
		return map.get(placeUrlParameter);
		//return null;
	}*/	
}
