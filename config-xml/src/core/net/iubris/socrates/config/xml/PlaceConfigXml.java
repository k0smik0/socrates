/*******************************************************************************
 * Copyleft 2012 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * PlaceConfigXml.java is part of socrates_config-xml.
 * 
 * socrates_config-xml is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 * 
 * socrates_config-xml is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with socrates_config-xml ; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301 USA
 ******************************************************************************/
package net.iubris.socrates.config.xml;


import java.util.List;
import java.util.Set;

import net.iubris.socrates.model.http.request.url.output.HttpParserOutputType;
import net.iubris.socrates.model.http.response.data.search.PlaceType;

@Root
public class PlaceConfigXml implements PlaceConfig {	
	
	
	@Element(name="api_key") private  String key;
	@Element(name="radius",type=Integer.class) private  int radius;
	@Element(name="use_sensor",type=Boolean.class) private  boolean useSensor;
	@Element(name="output",type=HttpParserOutputType.class) private  HttpParserOutputType output;
	@Element(name="application_name") private  String applicationName;
	@ElementList(name="types",required=false) private  Set<PlaceType> types;
	@ElementList(name="names",required=false) private  List<String> names;
		
/*
	public PlaceConfigXml( 
			@Element(name="api_key") String key, 
			@Element(name="radius") int radius, 
			@Element(name="use_sensor") boolean useSensor,
			@Element(name="output") HttpParserOutputType output, 
			@Element(name="application_name") String applicationName,
			@ElementList(name="types",required=false) Set<PlaceType> types,
			@ElementList(name="names",required=false) List<String> names ) {
		this.key = key;		
		this.radius = radius;
		this.useSensor = useSensor;
		this.output = output;
		this.applicationName = applicationName;
		this.types = types;
		this.names = names;
	}*/
	
	//@Element(name="api_key")
	public String getKey() {		
		return key;
	}
	//@Element(name="radius",type=Integer.class)
	public int getRadius() {
		return radius;
	}
	//@Element(name="use_sensor",type=Boolean.class)
	public boolean isUseSensor() {
		return useSensor;
	}
	//@Element(name="output",type=HttpParserOutputType.class)
	public HttpParserOutputType getOutput() {
		return output;
	}
	//@Element(name="application_name")
	public String getApplicationName() {
		return applicationName;
	}	
	//@ElementList(name="types",required=false)
	public Set<PlaceType> getTypes() {
		return types;
	}
	//@ElementList(name="names",required=false)
	public List<String> getNames() {
		return names;
	}	
}
