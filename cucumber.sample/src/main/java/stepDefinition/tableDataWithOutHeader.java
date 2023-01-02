package stepDefinition;

import java.util.List;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class tableDataWithOutHeader {
	@Given("enetering the browser.")
	public void enetering_the_browser() throws Throwable {
		System.out.println("--------one--------");
	}

	@When("Username  and enter the password.")
	public void username_and_enter_the_password_too(DataTable dataTable) throws Throwable {
		List<List<String>> list = dataTable.asLists(String.class);
		System.out.println("My first name " + list.get(1) + ". And my initial is " + list.get(2));

	}

	@When("click the login.")
	public void click_the_login() throws Throwable {
		System.out.println("--------three--------");
	}

	@Then("reach the dashboard.")
	public void reach_the_dashboard() throws Throwable {
		System.out.println("--------four--------");
	}
}
