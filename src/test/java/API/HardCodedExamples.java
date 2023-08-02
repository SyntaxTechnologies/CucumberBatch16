package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class HardCodedExamples {

    //baseURI = baseURL + endpoint
    //given - preparation
    //when - hitting the endpoint
    //base URI = base URL

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    // value of token should be same as postman
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2OTA5MzIzNzEsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY5MDk3NTU3MSwidXNlcklkIjoiNTYxNSJ9.xQAoWkfKQTzhnTUSOwi-f0WLMZxmxusDR_yjUHw8E8s";

    //in this method we are going to create an employee
    //we need headers, body to prepare the request
    @Test
    public void createEmployee(){
        //preparing the request
    RequestSpecification request = given().header("Content-Type","application/json").
                header("Authorization", token).body("{\n" +
                        "  \"emp_firstname\": \"justin\",\n" +
                        "  \"emp_lastname\": \"azzuri\",\n" +
                        "  \"emp_middle_name\": \"ms\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"2000-07-21\",\n" +
                        "  \"emp_status\": \"happy\",\n" +
                        "  \"emp_job_title\": \"QA\"\n" +
                        "}");
    //hitting the endpoint
          Response response = request.when().post("/createEmployee.php");
    //verifying the response
          response.then().assertThat().statusCode(201);
      //  System.out.println(response);
        //this method we use to print the response of API in console
        response.prettyPrint();
        //verify all the values and headers from response
        response.then().assertThat().body("Employee.emp_firstname",
                equalTo("justin"));
        response.then().assertThat().body("Employee.emp_middle_name",
                equalTo("ms"));
        response.then().assertThat().body("Message",
                equalTo("Employee Created"));
        response.then().assertThat().header("X-Powered-By","PHP/7.2.18");



    }




}

