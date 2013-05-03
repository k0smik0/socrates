package socrates.test._roboguice.module;

import net.iubris.socrates.config.ConfigMandatory;
import net.iubris.socrates.model.http.request.url.output.HttpParserOutputType;

/*
@Provides
Class<PlacesList> providePlaceListClass() {
	return PlacesList.class;
}*/
public final class ConfigMandatoryImpl implements ConfigMandatory{
	@Override
	public boolean isUseSensor() {
		return true;
	}
	

	@Override
	public HttpParserOutputType getOutput() {				
		return HttpParserOutputType.json;
	}
	@Override
	public String getKey() {				
		return "AIzaSyAfOlNmRr5G-4BPDd1faYsn9kvkV5ebBRk";
	}

	@Override
	public String getApplicationName() {				
		return "SocratesTest";
	}
}