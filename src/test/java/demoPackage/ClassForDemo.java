package demoPackage;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class ClassForDemo {
    public void getAnotherPost() {
        given().contentType(ContentType.JSON).log().all().
                when().get("https://jsonplaceholder.typicode.com/posts/10").
                then().statusCode(200).log().all().
                body("id", is(10)).
                body("title", is("optio molestias id quia eum")).
                body("body", is("quo et expedita modi cum officia vel magni\ndoloribus qui repudiandae\nvero nisi sit\nquos veniam quod sed accusamus veritatis error"));
    }
}
