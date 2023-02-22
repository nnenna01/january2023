package stepDefs;
import com.jayway.jsonpath.DocumentContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import utilities.RequestBodyService;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;



public class JsonPaceStepDef extends BaseSteps {


    Response getCommentResponse;
    Response postCommentResponse;
    DocumentContext requestBody;
    RequestBodyService requestBodyService;



    @Given("JsonPlaceHolder is up and running")
    public void json_place_holder_is_up_and_running() {
        setHeadersWithContentType();
        setEndpointPath(ServiceURL);
        Response getServiceResponse = getCall();
        assertThat(getServiceResponse.statusCode(), equalTo(200));


    }

    @When("Get request is sent to get a specific comment with {string}")
    public void get_request_is_sent_to_get_a_specific_comment_with(String id) {
        setHeadersWithContentType();
        setEndpointPath(CommentsURL + id); //then add the below response to grab the  comment that i just added
        getCommentResponse = getCall();

    }
    @Then("specific comment details with {string}, {string}, {string} is returned with statusCode of {int}")
    public void specific_comment_details_with_is_returned_with_status_code_of(String id, String name, String email, Integer sCode) {
        assertThat(getCommentResponse.statusCode(), equalTo(sCode));
        assertThat(getCommentResponse.body().jsonPath().get("name"), equalTo(name));
        assertThat(getCommentResponse.body().jsonPath().get("email"), equalTo(email));
        assertThat(getCommentResponse.body().jsonPath().get("id"), equalTo(Integer.parseInt(id)));



        //To convert an inter to a string or a string to an integer you use
        //equalTo(Integer.parse(id)));
        // i guess (String.parse(nameOfObject)));
    }

    @When("I create a new comment with details  {string}, {string}, {string} and {string} using post method")
    public void iCreateANewCommentWithDetailsAndUsingPostMethod(String postId, String name,String email, String body) {
        setHeadersWithContentType();
        setEndpointPath(CommentsURL);
        requestBody = loadJsonTemplate(MakeACommentPayload);
        requestBodyService = new RequestBodyService();
        requestBodyService.setRequestBodyForComment(requestBody, postId, name, email, body);
        postCommentResponse = getPostCall();

    }

    @Then("details with {string}, {string},{string} and {string} are returned with status code of {int}")
    public void detailsWithAndAreReturnedWithStatusCodeOf(String postId, String name, String email, String body, Integer sCode) {
        assertThat(postCommentResponse.statusCode(), equalTo(sCode));
        assertThat(postCommentResponse.body().jsonPath().get("postId"), equalTo(postId));
        assertThat(postCommentResponse.body().jsonPath().get("name"), equalTo(name));
        assertThat(postCommentResponse.body().jsonPath().get("email"), equalTo(email));
        assertThat(postCommentResponse.body().jsonPath().get("body"), equalTo(body));
    }




}



