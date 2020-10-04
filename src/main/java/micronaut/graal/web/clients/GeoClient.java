package micronaut.graal.web.clients;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Flowable;
import io.reactivex.Single;

@Client("https://get.geojs.io/v1/ip/geo/")
public interface GeoClient {

	@Get("/{ip}.json")
	Single<GeoResponse> findGeo(String ip);
}
