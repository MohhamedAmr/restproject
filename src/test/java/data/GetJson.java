package data;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;


    public class GetJson {


        public static JSONObject readAsJASONObject(String tcName) throws IOException, ParseException {

            String filePath = System.getProperty("user.dir") + "/src/main/java/Backend/DashboardAPIs/Loyality/V1_0/CreateCourierCategoryDashboard/US_34748CreateCourierCategoryDashboard/TestData/" + tcName;
            File srcFile = new File(filePath);
            JSONParser jsonParser = new JSONParser();
            JSONObject jarray = (JSONObject) jsonParser.parse(new FileReader(srcFile));
            return jarray;

        }
    }
}
