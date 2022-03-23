package io.quarkiverse.quinoa.it;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.TestProfile;

@QuarkusTest
@TestProfile(QuinoaTestProfiles.EnableAndRunUITests.class)
public class QuinoaUITest {

    @Test
    public void testUIIndex() {
        given()
                .when().get("/")
                .then()
                .statusCode(200)
                .body(containsString("<title>React App</title>"));
        given()
                .when().get("/index.html")
                .then()
                .statusCode(200)
                .body(containsString("<title>React App</title>"));
    }

    @Test
    public void testHelloEndpoint() {
        given()
                .when().get("/api/quinoa")
                .then()
                .statusCode(200)
                .body(is("Hello Quinoa"));
    }
}