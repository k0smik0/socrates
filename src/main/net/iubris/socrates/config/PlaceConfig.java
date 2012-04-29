package net.iubris.socrates.config;

import java.util.List;
import java.util.Set;

import net.iubris.socrates.model.data.places.PlaceType;
import net.iubris.socrates.url.HttpParserOutputType;

public interface PlaceConfig {
	public String getKey();
	public int getRadius();
	public String getApplicationName();
	public HttpParserOutputType getOutput();	
	public Set<PlaceType> getTypes();	
	public List<String> getNames();
	public boolean isUseSensor();
}
