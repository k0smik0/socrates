package net.iubris.socrates.model.http.request.url.parameters.optional.search;

import net.iubris.socrates.model.http.request.url.ParameterKey;

public enum SearchOptionalParameter implements ParameterKey {
	types,
	names,
	keyword,
	language,
	radius,
	rankby,
	pagetoken;/* {
		@Override
		public String getName() {
			return "pagetoken";
		}
	};

	@Override
	public String getName() {
		return name();
	}
*/
}
