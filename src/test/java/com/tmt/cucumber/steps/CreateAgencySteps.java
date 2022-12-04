package com.tmt.cucumber.steps;

import com.tmt.cucumber.utils.TestContext;
import com.tmt.domain.request.CreateAgency;
import com.tmt.domain.response.LightAgency;
import io.cucumber.java.en.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CreateAgencySteps {

    private final TestContext<CreateAgency, LightAgency, LightAgency> testContext;

    public CreateAgencySteps() {
        testContext = new TestContext<>();
    }

    /**
     * Post new Agency steps
     */
    @Given("a valid agency {string}")
    public void a_valid_agency_with_body(String body) {


    }

    @When("submit, a new agency should be added to catalog")
    public void submit_a_new_agency_should_be_added_to_catalog() {


    }

    @Then("we should verify the added agency is equal to {string}")
    public void we_should_verify_the_added_agency_is_equal_to(String body) {


    }

    @Then("we should map in {string} the saved agency id")
    public void we_should_map_in_the_saved_agency_id(String mapKeyId) {


    }

    @Then("response status should be succeeded {string} and message {string}")
    public void response_status_should_be_succeeded_and_message(String statusCode, String responseMsg) {

    }


    @When("submit, an exception should be throw")
    public void submit_an_exception_should_be_throw() {


    }

    @Then("response status should be conflict  {string} and message {string}")
    public void response_status_should_be_conflict_and_message(String statusCode, String reasonMsg) {


    }

    @When("user {string} submit, an exception should be throw")
    public void user_submit_an_exception_should_be_throw(String roles) {

    }

    @Then("response status should be access denied  {string} and message {string}")
    public void response_status_should_be_access_denied_and_message(String statusCode, String reasonMsg) {

    }

    @Then("we should verify the added agency is publish {string}")
    public void we_should_verify_the_added_agency_is_publish(String string) {

    }

    @Given("an invalid agency {string}")
    public void an_invalid_agency(String body) {

    }


    @Then("response status should be bad request  {string} and message {string}")
    public void responseStatusShouldBeBadRequestAndMessage(String statusCode, String reasonMsg) {
    }
}
