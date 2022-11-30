package data;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoclasses.ModelPojo;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

public class GetData {
    public static String getPartnerToken() {
        ModelPojo body = new ModelPojo("muhamed.elsarky@gmail.com", "12345678");

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

    public static String getNewStoreId() {
        ModelPojo body = new ModelPojo("12345678", "muhhamed.elsarky@gmail.com", false, "mohhhammed", "mohhamed", "12345678", "+201271022228", "", "", "https://dev.cdn.shgardi.app/catalog/StoreLogoImages/4f703f47-14f7-4b8d-b708-5a7b409e7489_2022-06-20_09-56-41-AM.jpg", 5);
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
        return response.getBody().jsonPath().getString("response.id");

    }
}
