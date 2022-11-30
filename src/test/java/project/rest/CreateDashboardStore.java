package project.rest;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

@Test
public class CreateDashboardStore {

    public void NewDashboardStore() {
        File body = new File("src/test/resources/CreateNewStore3.json");
        String tok = LoginWithPartner.getPartnerToken();
        given().baseUri("https://api-dev.shgardi.app")
                .header("Authorization", "bearer " + tok)
                .headers("Accept-Language", "en-US", "CountryId", 2)
                .body(body)
                .contentType(ContentType.JSON)
                .log().all()
                .when().post("/catalog/api/1/StoreDashboard/Create")
                .then().log().all()
                .assertThat().statusCode(200);


    }
}
