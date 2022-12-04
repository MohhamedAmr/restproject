package project.rest;

import Steps.Generate;
import data.GetData;
import data.GetJson;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import pojoclasses.Error;
import pojoclasses.ModelPojo;

import java.io.File;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

public class CreateStoreProject {
    @Test
    public void loginWithPartner() {

        ModelPojo body = new ModelPojo("muhamed.elsarky@gmail.com " , "12345678");
        Response response = GetData.login(body);
      // ModelPojo getBody = response.body().as(ModelPojo.class);

        assertThat(response.statusCode(), equalTo(200));
        //assertThat(response.path("userId"), not(equalTo("KFC")));
        assertThat(response.path("userId"), not(equalTo("KFC")));
        //assertThat(getBody.getUserName() ,not( equalTo("KFC")));

        //.assertThat().statusCode(200)
        //.assertThat().body("userId", not(equalTo("KFC")))
        //String auth = JsonPath.from(response.asString()).getString("accessToken");


    }

    @Test
    public void NewStore() {


        ModelPojo body = new ModelPojo("12345678", "muhhhhamed.elsarky@gmail.com", true, "mohhhhhhaammeed", "mohhhhaaameed", "12345678", "+201271022226", "", "", "https://dev.cdn.shgardi.app/catalog/StoreLogoImages/4f703f47-14f7-4b8d-b708-5a7b409e7489_2022-06-20_09-56-41-AM.jpg", 5);
        //String tok = GetData.getPartnerToken(body);
        Response response = GetData.createNewStore(body);
                //.header("Authorization", "bearer " + tok)

        assertThat(response.statusCode(), equalTo(200));

    }

    //@Test
   /* public void NewDashboardStore() throws IOException, ParseException {
        //JSONObject json1 = GetJson.readAsJASONObject("CreateNewStore3.json");


        //String tok = GetData.getPartnerToken();
        assertThat();
                //.assertThat().statusCode(200);


    }*/


}
