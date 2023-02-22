package restfulBookerPosts;

import io.restassured.http.ContentType;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;

//public class GetPost {
//
//
//    @Test
//    public void getPostFromRestfulBooker() {
//
//        given().contentType(ContentType.JSON).log().all().
//
//                when().get("https://restful-booker.herokuapp.com/booking/925").
//
//                then().statusCode(200).log().all().
//body("firstname", is("Josh")).
//        body("lastname",is("Allen")).
//        body("depositpaid",is(true));
//    }
//
//    @Test
//    public void getAnotherPost(){
//
//
//        given().contentType(ContentType.JSON).log().all().
//                when().get("https://restful-booker.herokuapp.com/booking/7").
//                 then().statusCode(200).
//                 body("firstname",is("Eric")).
//                 body("lastname",is("Wilson")).
//                 body("depositpaid",is(true)).
//                 body("totalprice",is(891));
//
//    }


//    public void createAPostInRestfulBooker(){
//        HashMap<String,String>PostBody=new HashMap<>();
//        PostBody.put("firstname","Nnenna");
//        PostBody.put("lasttname","Bright");
//        PostBody.put("totalprice","300");
//        PostBody.put("depositpaid","true");
//
//        given().contentType(ContentType.JSON).log().all().with().body(PostBody).
//                when().post("https://restful-booker.herokuapp.com/booking/6556").
//                then().statusCode(200).log().all().
//                body("lastname",is("Bright"));
//
//}
//}