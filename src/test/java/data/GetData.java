package data;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoclasses.ModelPojo;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.not;

public class GetData {
    public static Response login(ModelPojo body) {


        return given().baseUri("https://api-dev.shgardi.app")
                .headers("Accept-Language", "en-US", "CountryId", 2)
                .body(body)
                .contentType(ContentType.JSON)
                .log().all()
                .when().post("/identity/api/2/StoreManagement/Partner/Login")

                //;response.
                .then().log().all()
                .extract().response();
        //String auth = JsonPath.from(response.asString()).getString("accessToken");
        //return response.getBody().jsonPath().getString("response.accessToken");

    }

    public static Response createNewStore(ModelPojo body) {

        //String tok = GetData.getPartnerToken(body);
        return given().baseUri("https://api-dev.shgardi.app")
                //.header("Authorization", "bearer " + tok)
                .header("Accept-Language", "en-US", "CountryId", 2)
                .body(body)
                .contentType(ContentType.JSON)
                .log().all()
                .when().post("/identity/api/2/StoreManagement/Stores/CreateStoreUser")
                .then().
                log().all()
                .extract().response();
        //return response.getBody().jsonPath().getString("response.id");

    }
    /*public static Response createNewDashboardStore(){
       return given().baseUri("https://api-dev.shgardi.app")
                // .header("Authorization", "bearer " + tok)
                .headers("Accept-Language", "en-US", "CountryId", 2)
                .body()
                .contentType(ContentType.JSON)
                .log().all()
                .when().post("/catalog/api/1/StoreDashboard/Create")
                .then().log().all();


    } */
}
