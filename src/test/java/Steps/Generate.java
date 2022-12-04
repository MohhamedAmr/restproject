package Steps;

import com.github.javafaker.Faker;
import pojoclasses.ModelPojo;

public class Generate {

    public static ModelPojo generateUser(){
        Faker faker = new Faker();
        String phoneNumber = faker.numerify("+2012########");
        String userName = faker.internet().emailAddress();
        String loginName = faker.name().name();
        String name = faker.name().name();
        String password = "123456";
        ModelPojo body = new ModelPojo(userName , password );

        return body;
    }


}
