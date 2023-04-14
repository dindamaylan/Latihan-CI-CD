package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class Get {
    protected static String url = "https://reqres.in/api/";

    @Step("I set GET api endpoints")
    public String setGetApiEndpoints(){
        return url + "users/2";
    }

    @Step("I send GET HTTP Request")
    public void iSendGETHTTPRequest(){
        SerenityRest.given().when().get(setGetApiEndpoints());
    }

    @Step("I receive valid HTTP response code 200")
    public void validateHTTPResponseCode200(){
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I receive valid data for detail user")
    public void validateDataDetailUser(){
        restAssuredThat(response -> response.body("data.id", equalTo(2)));
        restAssuredThat(response -> response.body("data.first_name", equalTo("Janet")));
    }
}
