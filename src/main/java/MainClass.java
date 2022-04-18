import api.GitResponse;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.codec.binary.Base64;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.sound.midi.Soundbank;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;

public class MainClass {
    public static void main(String[] args) {
//        System.setProperty("webdriver.chrome.driver","C:\\Users\\yevgen.omelchenko\\IdeaProjects\\MyProject\\drivers\\chromedriver.exe");
//
//        WebDriver driver = new ChromeDriver();
//
//        driver.get("https://www.google.com/");
//        driver.navigate().to("https://www.google.com/");
//        driver.navigate().back();
//        driver.navigate().forward();
//
//        driver.quit(); // close window after test
//
//        driver.manage().window().maximize(); // open browser window maximize
//
//        driver.manage().window().setSize(new Dimension(900, 500));
//        driver.navigate().refresh();
//
//        var a = driver.getTitle();
//
//        var b = driver.getCurrentUrl();
//
//        /* Implicit Waite */
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //
//        ///////////////////////
//
//        driver.findElement(By.xpath(""));
//        driver.findElement(By.xpath("")).click();
//        driver.findElement(By.xpath("")).getText();
//        driver.findElement(By.xpath("")).getAttribute("class");
//        driver.findElement(By.xpath("")).submit();
        int fibonachi = 0;
            int [] fibArray = new int[30];
        for (int i = 0; i < 30; i++) {

            
            if (fibonachi==0){
                fibArray[i] = fibonachi;
                fibonachi += 1;
            }else if (i == 1){
                fibArray[i] = fibonachi;
            }
             else {
                fibonachi = fibArray[i-2] + fibArray[i-1];
                fibArray[i] = fibonachi;
            }
        }
int y = 0;
        for (int as :
                fibArray) {
            System.out.println("fibo"+ (y+=1) + " " + as);
        }
    }

    public String getToken() throws IOException {
        //pave the path to the folder with credentials
        Properties PROP = new Properties();
        FileInputStream fis;
        fis = new FileInputStream("src/test/java/config/token.properties");
        PROP.load(fis);

        //Get Authorization key
        String credentials = PROP.getProperty("login")+":"+PROP.getProperty("secret");
        String encodedCredentials = new String(Base64.encodeBase64(credentials.getBytes()));

        //POST request to get token
        RestAssured.baseURI="https://loginint.int.psl-nagini.com/auth/realms/NaginiInternalKeycloak/protocol/openid-connect/token";
        RequestSpecification request = given().accept(ContentType.JSON).contentType(ContentType.URLENC);
        request.header("authorization", "Basic " + encodedCredentials);

        Response response = request.formParam("grant_type", "client_credentials")
                .queryParam("scope", "email")
                .post();
        response.prettyPrint();

        GitResponse token = response.getBody().as(GitResponse.class);
        //System.out.println(token.accessToken);
        return token.accessToken;
    }


    public String getUser(){

        given()
                .baseUri("https://api.github.com")
                .basePath("")
                .contentType(ContentType.JSON)
                .when().get()
                .then().statusCode(200);
        return "ds";
    }

}
