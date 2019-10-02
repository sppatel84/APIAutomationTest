package entityAPI;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class APIMethod {

    public void enterBaseURL(String baseUrl){
        RestAssured.baseURI = baseUrl;
    }

    public void getPostResponse(int statusCode, String message){
         given()
                .header("Content-Type","application/json")
                .body("{\t\n" +
                        "\t\"country\": \"UK\",\t\n" +
                        "\t\"name\": \"Blue\",\n" +
                        "    \"position\": \"Tom\",\n" +
                        "    \"risk\": 3,\n" +
                        "\t\"yob\": 1987\n" +
                        "}")
                .when()
                .post("/peps")
                .then()
                .assertThat()
                .statusCode(statusCode)  // validate the status code 201
                .and()
                .body("message",is(equalTo(message)))  // validate the success message
                .and()
                .body("id",is(notNullValue()))  // validate the id value is not null
                 .and()
                 .body("ok",is(true));  // validate the Ok status is true

    }

    public void getResponse(int statusCode){
        given()
                .header("Content-Type","application/json")
                .when()
                .get("/peps")
                .then()
                .assertThat()
                .statusCode(statusCode)  // validate the status code 200
                .and()
                .body("name",hasSize(greaterThanOrEqualTo(5)));   // validate the politician name form Json response
    }

    public void getThePoliticianInfo(int statusCode,String country, String createdDate, String name, String position, int risk, int yob){
        given()
                .header("Content-Type","application/json")
                .when()
                .get("/peps/5d93e77b0f0698107761d566")
                .then()
                .assertThat()
                .statusCode(statusCode)
                .and()
                .body("country",is(equalTo(country)))
                .and()
                .body("createdAt",is(startsWith(createdDate)))
                .and()
                .body("id",is(equalTo("5d93e77b0f0698107761d566")))
                .and()
                .body("name",is(equalTo(name)))
                .and()
                .body("position",is(equalTo(position)))
                .and()
                .body("risk",is(equalTo(risk)))
                .and()
                .body("yob",is(equalTo(yob)));


    }
}
