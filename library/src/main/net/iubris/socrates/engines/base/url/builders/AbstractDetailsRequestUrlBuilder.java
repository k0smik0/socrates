package net.iubris.socrates.engines.base.url.builders;

import net.iubris.socrates.model.http.request.url.parameters.mandatory.details.DetailsMandatoryParameters;

import com.google.api.client.http.GenericUrl;

public abstract class AbstractDetailsRequestUrlBuilder<B> extends AbstractRequestUrlBuilder<B> {

	public AbstractDetailsRequestUrlBuilder(GenericUrl requestMandatoryUrl) {
		super(requestMandatoryUrl);
	}
	
	@SuppressWarnings("unchecked")
	public B setReference(String reference) {
		//setValue(buildedUrl, PlaceUrlConfigParameter.reference, reference);
		setParameterValue(DetailsMandatoryParameters.reference, reference);
		return (B) this;
	}

}
