package com.example.integration;

import com.example.SpringBootPostgresApplication;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Header;
import com.jayway.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootPostgresApplication.class, webEnvironment = RANDOM_PORT)
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:beforeTestRun.sql")
})
public class ProductControllerIT {

    @LocalServerPort
    private int port;

    private String authCredentials;

    @Before
    public void setUp() {
        RestAssured.port = port;
        Response response =
                given().
                        body("{\"username\":\"user\",\"password\":\"password\"}").
                        contentType(ContentType.JSON).
                when().
                        post("/auth").
                then().
                        statusCode(HttpStatus.OK.value()).
                        extract().response();

        this.authCredentials = response.getBody().jsonPath().getString("token");
    }

    @Test
    public void getProductList() {

        given().
                header(new Header("Authorization", this.authCredentials)).
                contentType(ContentType.JSON).
        when().
                get("/products").
        then().
                statusCode(HttpStatus.OK.value()).
                body("productName", hasSize(4)).
                body("productName", hasItems("iPhone", "iPhone SE", "iPhone 7", "iPhone 8"));

    }

}
