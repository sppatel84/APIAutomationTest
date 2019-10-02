package stepDef;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import entityAPI.APIMethod;

public class EntityStepDef {

    APIMethod apiMethod = new APIMethod();

    @When("^user enter the base url \"([^\"]*)\" with passing the mandatory fields$")
    public void user_enter_the_base_url_with_passing_the_mandatory_fields(String baseUrl) {
        apiMethod.enterBaseURL(baseUrl);
    }

    @Then("^user get the response status code as (\\d+) and get the success message as \"([^\"]*)\"$")
    public void user_get_the_response_status_code_as_and_get_the_success_message_as(int statusCode, String message) {
        apiMethod.getPostResponse(statusCode,message);
    }

    @Then("^get the response with status code as (\\d+)$")
    public void get_the_response_with_status_code_as(int statusCode) {
        apiMethod.getResponse(statusCode);
    }

    @Then("^user get the response status code as (\\d+) and get the politician information as \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",(\\d+) and (\\d+)$")
    public void user_get_the_response_status_code_as_and_get_the_politician_information_as_and(int statusCode, String country, String createdDate, String name, String position, int risk, int yob) {
        apiMethod.getThePoliticianInfo(statusCode,country,createdDate,name,position,risk,yob);
    }
}
