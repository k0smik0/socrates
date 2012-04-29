package net.iubris.socrates.model.data.geocoding;

import com.google.api.client.util.Value;

public enum AddressType {	
	@Value street_address,
	@Value route,
	@Value intersection,
	@Value political,
	@Value country,
	@Value administrative_area_level_1,
	@Value administrative_area_level_2,
	@Value administrative_area_level_3,
	@Value colloquial_area,
	@Value locality,
	@Value sublocality,
	@Value neighborhood,
	@Value premise,
	@Value subpremise,
	@Value postal_code,
	@Value natural_feature,
	@Value airport,
	@Value park,
	@Value point_of_interest,
	@Value In,
	@Value post_box,
	@Value street_number,
	@Value floor,
	@Value room;
}