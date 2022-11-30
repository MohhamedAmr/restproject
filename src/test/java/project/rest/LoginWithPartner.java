package project.rest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojoclasses.ModelPojo;
import pojoclasses.LoginWithPartnerPojo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

public class LoginWithPartner {
    @Test
    public void loginWithPartner() {


        ModelPojo body = new ModelPojo("muhamed.elsarky@gmail.com", "12345678");
        Response response = given().baseUri("https://api-dev.shgardi.app")
                .headers("Accept-Language", "en-US", "CountryId", 2)
                .body(body)
                .contentType(ContentType.JSON)
                .log().all()
                .when().post("/identity/api/2/StoreManagement/Partner/Login")
                .then().log().all()
                .assertThat().statusCode(200)
                .assertThat().body("userId", not(equalTo("KFC")))
                .extract().response();
        //String auth = JsonPath.from(response.asString()).getString("accessToken");


    }

    public static String getPartnerToken() {
        LoginWithPartnerPojo body = new LoginWithPartnerPojo("muhamed.elsarky@gmail.com", "12345678");

        Response response = given().baseUri("https://api-dev.shgardi.app")
                .headers("Accept-Language", "en-US", "CountryId", 2)
                .body(body)
                .contentType(ContentType.JSON)
                .log().all()
                .when().post("/identity/api/2/StoreManagement/Partner/Login");

        response.then().log().all()
                .assertThat().statusCode(200)
                .assertThat().body("userId", not(equalTo("KFC")))
                .extract().response();
        //String auth = JsonPath.from(response.asString()).getString("accessToken");
        return response.getBody().jsonPath().getString("response.accessToken");

    }


}
