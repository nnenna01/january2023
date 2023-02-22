package restAssuredDemo;

import org.junit.Test;


import io.cucumber.java.hu.Ha;
import io.restassured.http.ContentType;
import org.junit.Test;


import java.util.HashMap;

import static io.restassured.RestAssured.given;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.is;

public class SocialNetworkingPost {

    @Test
    public void getSpecificSocialNetworkingPost() {
        given().contentType(ContentType.JSON).log().all().
                when().get("https://jsonplaceholder.typicode.com/post/6").
                then().statusCode(200).log().all().
                body("title", is("dolorem eum magni eos aperiam quia")).
                body("body", is("ut aspernatur corporis harum nihil quis provident sequi\nmollitia nobis aliquid molestiae\nperspiciatis et ea nemo ab reprehenderit accusantium quas\nvoluptate dolores velit et doloremque molestiae"));

    }

    @Test
    public void getAnotherPost() {
        given().contentType(ContentType.JSON).log().all().
                when().get("https://jsonplaceholder.typicode.com/posts/10").
                then().statusCode(200).log().all().
                body("id", is(10)).
                body("title", is("optio molestias id quia eum")).
                body("body", is("quo et expedita modi cum officia vel magni\ndoloribus qui repudiandae\nvero nisi sit\nquos veniam quod sed accusamus veritatis error"));
    }


    public void GetThirdPostForMyRestAssured() {
        given().contentType(ContentType.JSON).log().all().
                when().get("https://jsonplaceholder.typicode.com/posts/20").
                then().statusCode(200).log().all().
                body("id", is(20)).
                body("body", is("qui consequuntur ducimus possimus quisquam amet similique\nsuscipit porro ipsam amet\neos veritatis officiis exercitationem vel fugit aut necessitatibus totam\nomnis rerum consequatur expedita quidem cumque explicabo")).
                body("title", is("doloribus ad provident suscipit at"));

    }

    @Test
    public void fetchAPostFromNet() {

        given().contentType(ContentType.JSON).log().all().
                when().get("https://jsonplaceholder.typicode.com/posts/14").
                then().statusCode(200).log().all().
                body("userId", is(2)).
                body("id", is(14)).
                body("title", is("voluptatem eligendi optio")).
                body("body", is("fuga et accusamus dolorum perferendis illo voluptas\nnon doloremque neque facere\nad qui dolorum molestiae beatae\nsed aut voluptas totam sit illum"));
    }

    @Test

    public void createASocialNetworkingPost() {
        HashMap<String, String> PostRequestBody = new HashMap<>();
        PostRequestBody.put("userid", "2");
        PostRequestBody.put("id", "40");
        PostRequestBody.put("title", "I have had a very busy time this past few months");
        PostRequestBody.put("body", "I think it is time I get a help from someone who knows this thing");


        given().contentType(ContentType.JSON).log().all().with().body(PostRequestBody).
                when().post("https://jsonplaceholder.typicode.com/posts").

                then().statusCode(201).log().all().
                body("title", is("I have had a very busy time this past few months"));
        //    body( "body", is("I think it is time I get a help from someone who knows this thing"));

    }

    @Test
    public void putNewPostUp() {
        HashMap<String, String> AboutMyself = new HashMap<>();
        AboutMyself.put("postid", "1");
        AboutMyself.put("id", "501");
        AboutMyself.put("name", "Nnenna Gere");
        AboutMyself.put("email", "NnennaGere@hahahah.com");
        AboutMyself.put("body", "my body is the best body and i love the gift of my body as it is esy to look after");


        given().contentType(ContentType.JSON).log().all().with().body(AboutMyself).
                when().post("https://jsonplaceholder.typicode.com/posts/1/comments").
                then().statusCode(201).log().all().
                body("postid", is("1")).
                body("name", is("Nnenna Gere")).
                body("email", is("NnennaGere@hahahah.com")).
                body("body", is("my body is the best body and i love the gift of my body as it is esy to look after"));

    }
    @Test
    public void createNewPostWithLateef() {

        HashMap<String, String> AboutLateef = new HashMap<>();
        AboutLateef.put("postid", "1");
        AboutLateef.put("id", "501");
        AboutLateef.put("name", "Lateef Abdulsalam");
        AboutLateef.put("email", "Lateef@gmail.co.uk");
        AboutLateef.put("body", "Lateef lives very far from me o i can not get a one on one tutoring  but i know that i will get there some day some how");

        given().contentType(ContentType.JSON).log().all().with().body(AboutLateef).
                when().put("https://jsonplaceholder.typicode.com/posts/1/comments").
                then().statusCode(201).log().all().
                body("postid", is("1")).
                body("id", is(501)).
                body("name", is("Lateef Abdulsalam")).
                body("email", is("Lateef@gmail.co.uk")).
                body("body", is("Lateef lives very far from me o i can not get a one on one tutoring  but i know that i will get there some day some how"));


    }

}
