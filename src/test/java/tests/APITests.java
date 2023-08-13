package tests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class APITests {
    private final String endpoint = "https://jsonplaceholder.typicode.com/users";

    @Test
    public void getStatusCode(){
        given().when().get(endpoint).then().assertThat()
                .statusCode(200);
    }

    @Test
    public void getResponseHeaders(){
        given().when().get(endpoint).then().assertThat()
                .header("Content-Type", notNullValue())
                .header("Content-Type", equalTo("application/json; charset=utf-8"));
    }

    @Test
    public void getResponseBody(){
        given().when().get(endpoint).then().assertThat()
                .body("size()", equalTo(10));
    }
}
