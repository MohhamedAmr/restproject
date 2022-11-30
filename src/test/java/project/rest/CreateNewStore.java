package project.rest;

import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapper;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojoclasses.ModelPojo;

import java.io.File;

import static io.restassured.RestAssured.given;

public class CreateNewStore {
    @Test
    public void NewStore() {
        ModelPojo body = new ModelPojo("12345678", "muhhhamed.elsarky@gmail.com", false, "mohhhhammed", "mohhhamed", "12345678", "+201271022227", "", "", "https://dev.cdn.shgardi.app/catalog/StoreLogoImages/4f703f47-14f7-4b8d-b708-5a7b409e7489_2022-06-20_09-56-41-AM.jpg", 5);
        String tok = LoginWithPartner.getPartnerToken();
        Response response = given().baseUri("https://api-dev.shgardi.app")
                .header("Authorization", "bearer " + tok)
                .header("Accept-Language", "en-US", "CountryId", 2)
                .body(body)
                .contentType(ContentType.JSON)
                .log().all()
                .when().post("/identity/api/2/StoreManagement/Stores/CreateStoreUser")
                .then().
                log().all()
                .assertThat().statusCode(200)
                .extract().response();


    }

    public static String getNewStoreId() {
        ModelPojo body = new ModelPojo("12345678", "muhhamed.elsarky@gmail.com", false, "mohhhammed", "mohhamed", "12345678", "+201271022228", "", "", "https://dev.cdn.shgardi.app/catalog/StoreLogoImages/4f703f47-14f7-4b8d-b708-5a7b409e7489_2022-06-20_09-56-41-AM.jpg", 5);
        String tok = LoginWithPartner.getPartnerToken();
        Response response = given().baseUri("https://api-dev.shgardi.app")
                .header("Authorization", "bearer " + tok)
                .header("Accept-Language", "en-US", "CountryId", 2)
                .body(body)
                .contentType(ContentType.JSON)
                .log().all()
                .when().post("/identity/api/2/StoreManagement/Stores/CreateStoreUser")
                .then().
                log().all()
                .assertThat().statusCode(200)
                .extract().response();
        return response.getBody().jsonPath().getString("response.id");

    }
}
