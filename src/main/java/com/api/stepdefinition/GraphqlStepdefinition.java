package com.api.stepdefinition;

import static org.junit.Assert.assertNotNull;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.api.model.BookingDTO;
import com.api.utils.JsonReader;
import com.api.utils.ResponseHandler;
import com.api.utils.TestContext;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class GraphqlStepdefinition {
	
	
	
	private TestContext context;
	private static final Logger LOG = LogManager.getLogger(GraphqlStepdefinition.class);
	
	public GraphqlStepdefinition(TestContext context) {
		this.context = context;
	}
	@Given("user has to access the endpoint url {string}")
	public void user_has_to_access_the_endpoint_url(String endpoint) {
	    
		context.session.put("endpoint", endpoint);
	}
	
	@When("user creates a queryrequest using data {string} from JSON file {string}")
	public void userCreatesABookingUsingDataFromJSONFile(String dataKey, String JSONFile) {
		context.response = context.requestSetup1().body(JsonReader.getRequestBody(JSONFile,dataKey))
				.when().post(context.session.get("endpoint").toString());

//		BookingDTO bookingDTO = ResponseHandler.deserializedResponse(context.response, BookingDTO.class);
//		assertNotNull("Booking not created", bookingDTO);
//		LOG.info("Newly created booking ID: "+bookingDTO.getBookingid());	
//		context.session.put("bookingID", bookingDTO.getBookingid());
	}

}
