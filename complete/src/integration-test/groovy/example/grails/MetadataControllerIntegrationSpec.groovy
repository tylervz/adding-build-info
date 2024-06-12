package example.grails

import grails.gorm.transactions.Rollback
import grails.testing.mixin.integration.Integration
import groovy.json.JsonSlurper
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import spock.lang.Shared
import spock.lang.Specification

@Integration
@Rollback
class MetadataControllerIntegrationSpec extends Specification {

    @Shared HttpClient client

    void setup() { // <1>
        // serverPort is automatically injected when the test file is run
        String baseUrl = "http://localhost:$serverPort"
        this.client = HttpClient.create(baseUrl.toURL())
    }

    void "test the index method of MetadataController returns 200"() {
        when:
        HttpRequest request = HttpRequest.GET("/Metadata")
        HttpResponse<String> resp = this.client.toBlocking().exchange(request, String) // <2>
        Map json = new JsonSlurper().parseText(resp.body()) as Map // <3>

        then: "we get a success status"
        resp.status == HttpStatus.OK // <4>
        json != null
        json.grailsVersion == "6.2.0"
        json.containsKey("applicationBuildTS")
        json.containsKey("buildGitRevision")
        !json.containsKey("foo")
    }
}
