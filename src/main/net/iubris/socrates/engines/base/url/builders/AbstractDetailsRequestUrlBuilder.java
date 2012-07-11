package net.iubris.socrates.engines.base.url.builders;

import net.iubris.socrates.model.url.parameters.DetailsConfigParameter;

import com.google.api.client.http.GenericUrl;

public abstract class AbstractDetailsRequestUrlBuilder<B> extends AbstractRequestUrlBuilder<B> {

	public AbstractDetailsRequestUrlBuilder(GenericUrl requestMandatoryUrl) {
		super(requestMandatoryUrl);
	}
	
	@SuppressWarnings("unchecked")
	public B setReference(String reference) {
		//setValue(buildedUrl, PlaceUrlConfigParameter.reference, reference);
		setValue(DetailsConfigParameter.reference, reference);
		return (B) this;
	}

}
