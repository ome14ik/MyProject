import api.GitResponse;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.codec.binary.Base64;
import org.junit.After;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class TestClass {

    @Test
    public void getUser(){

       var a =given()
                .baseUri("https://api.github.com/search")
                .basePath("/users?q=q")
                .contentType(ContentType.JSON)
                .when().get()
                .then()
                .statusCode(200)
               .extract().jsonPath().getList("items.login")
                ;


    }

}
