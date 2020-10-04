package micronaut.graal.web.controllers;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import io.reactivex.Single;
import micronaut.graal.web.clients.GeoClient;

@Controller("/sample")
@ExecuteOn(TaskExecutors.IO)
public class SampleController {

	private final GeoClient geoClient;

	public SampleController(GeoClient geoClient) {
		this.geoClient = geoClient;
	}

	@Get
	public Single<String> sample(HttpRequest request) {
		String remoteAddress = request.getHeaders().get("X-Forwarded-For");
		if(remoteAddress == null) {
			remoteAddress = request.getRemoteAddress().getAddress().getHostAddress();
		}
		return geoClient.findGeo(remoteAddress).map(geoResponse -> String.format("Hello there from %s, %s, %s",  geoResponse.getCity(), geoResponse.getRegion(), geoResponse.getCountry()));
	}
}
