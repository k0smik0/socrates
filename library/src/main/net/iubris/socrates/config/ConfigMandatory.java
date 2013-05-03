package net.iubris.socrates.config;

import net.iubris.socrates.model.http.request.url.output.HttpParserOutputType;

public interface ConfigMandatory {
	public String getKey();
	public String getApplicationName();	
	public HttpParserOutputType getOutput();
	public boolean isUseSensor();
}
