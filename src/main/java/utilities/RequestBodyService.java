package utilities;

import com.jayway.jsonpath.DocumentContext;
import stepDefs.BaseSteps;

public class RequestBodyService extends BaseSteps {
    public void setRequestBodyForComment(DocumentContext requestBody, String postId, String name, String email, String body) {
        requestBody.set("postId", postId);
        requestBody.set("name", name);
        requestBody.set("email", email);
        requestBody.set("body", body);
      setRequestBodyJson(requestBody);
    }
//    public void setRequestBodyForpost(DocumentContext requestBody, String postId, String name, String email, String body) {
//        requestBody.set("postId", postId);
//        requestBody.set("name", name);
//        requestBody.set("email", email);
//        requestBody.set("body", body);
//        setRequestBodyJson(requestBody);
//    }
}
