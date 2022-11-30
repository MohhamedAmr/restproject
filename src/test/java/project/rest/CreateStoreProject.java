package project.rest;

import data.GetData;
import data.GetJson;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import pojoclasses.ModelPojo;

import java.io.File;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

public class CreateStoreProject {
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

    @Test
    public void NewStore() {


        ModelPojo body = new ModelPojo("12345678", "muhhhhamed.elsarky@gmail.com", true, "mohhhhhhaammeed", "mohhhhaaameed", "12345678", "+201271022226", "", "", "https://dev.cdn.shgardi.app/catalog/StoreLogoImages/4f703f47-14f7-4b8d-b708-5a7b409e7489_2022-06-20_09-56-41-AM.jpg", 5);
        String tok = GetData.getPartnerToken();
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

    @Test
    public void NewDashboardStore() throws IOException, ParseException {
        JSONObject json1 = GetJson.readAsJASONObject("CreateNewStore3.json");
        json1.replace("id", null ,GetData.getNewStoreId());

        String tok = GetData.getPartnerToken();
        given().baseUri("https://api-dev.shgardi.app")
                .header("Authorization", "bearer " + tok)
                .headers("Accept-Language", "en-US", "CountryId", 2)
                .body(json1)
                .contentType(ContentType.JSON)
                .log().all()
                .when().post("/catalog/api/1/StoreDashboard/Create")
                .then().log().all()
                .assertThat().statusCode(200);


    }


}
