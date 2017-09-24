package com.radoslav.integration.tests.roles;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;

import com.radoslav.integration.tests.annotations.Descriptor;
import com.radoslav.integration.tests.authentication.OAuthAuthentication;
import com.radoslav.integration.tests.authz.roles.ApplicationRole;
import com.radoslav.integration.tests.authz.roles.Role;
import com.radoslav.integration.tests.rules.AccessTokenRule;

public class PositiveRoleScenarioTest {

	@ClassRule
	public static AccessTokenRule accessTokenRule = new AccessTokenRule();

	private static Role role;

	@BeforeClass
	public static void setUp() {
		role = new ApplicationRole("roleName", new OAuthAuthentication(accessTokenRule.getToken()));
	}
	
	@Test
	@Descriptor("Creating role with name 'roleName' using authorization API")
	public void testThatRoleWouldBeSuccessfullyCreated() {
		role.create();
		
		Role.Entity entity = role.fetch();
		
		assertThat(entity.name(), is(equalTo("roleName")));
	}

	@Test
	@Descriptor("Deleting role with name 'roleName' using authorization API")
	public void testThatRoleWouldBeSuccessfullyDeleted() {
		role.delete();
		
		Role.Entity entity = role.fetch();
		
		assertThat(entity.name(), is(equalTo("roleName")));
	}
	
	//TODO: create also NegativeRoleScenarioTest or RoleValidationScenarioTest (if we should test the response code etc.)
}