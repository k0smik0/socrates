package net.iubris.socrates.model.http.request.url.service.events.method;

public enum EventMethod {
	
	add("add"),
	delete("delete"),
	details("details"),
	checkin("check-in");
	
	private String methodName;
	
	private EventMethod(String methodName) {
		this.methodName = methodName;
	}
	
	public String getMethodName() {
		return methodName;
	}
	
}
