package micronaut.graal.web;

import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.annotation.MicronautTest;
import micronaut.graal.web.clients.GeoClient;
import micronaut.graal.web.clients.GeoResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import javax.inject.Inject;

@MicronautTest
public class MicronautGraalWebTest {

    @Inject
    GeoClient geoClient;

    @Test
    void testItWorks() {
        GeoResponse response = geoClient.findGeo("173.63.239.230").blockingGet();
        System.out.println(response.getLatitude()+","+response.getLongitude());

    }

}
