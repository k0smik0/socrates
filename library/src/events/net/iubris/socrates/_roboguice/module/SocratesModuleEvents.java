package net.iubris.socrates._roboguice.module;

import net.iubris.socrates._roboguice.providers.url.services.EventDetailsRequestMandatoryUrlProvider;
import net.iubris.socrates.engines.events.details.url.annotation.EventDetailsRequestMandatoryUrl;
import net.iubris.socrates.engines.events.details.url.annotation.ServiceTypeEvent;
import net.iubris.socrates.model.http.request.url.service.ServiceType;

import com.google.api.client.http.GenericUrl;

public class SocratesModuleEvents extends SocratesModule {

	@Override
	protected void ownConfigure() {
		bind(ServiceType.class).annotatedWith(ServiceTypeEvent.class).toInstance(ServiceType.event);
		bind(GenericUrl.class).annotatedWith(EventDetailsRequestMandatoryUrl.class).toProvider(EventDetailsRequestMandatoryUrlProvider.class);
	}
}
