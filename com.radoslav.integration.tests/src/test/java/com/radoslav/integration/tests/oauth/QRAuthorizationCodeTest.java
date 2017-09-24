package com.radoslav.integration.tests.oauth;

import org.junit.Test;

import com.radoslav.integration.tests.oauth.clients.PublicClient;
import com.radoslav.integration.tests.oauth.code.AuthorizationCode;
import com.radoslav.integration.tests.oauth.code.QRCodeMode;
import com.radoslav.integration.tests.oauth.flows.AuthorizationCodeFlow;
import com.radoslav.integration.tests.oauth.tokens.AccessToken;

public class QRAuthorizationCodeTest {

	@Test
	public void test() throws Exception {
		AccessToken token = new AccessToken(
			new AuthorizationCodeFlow(
				new AuthorizationCode(
					new QRCodeMode(
						new PublicClient()
					)
				)
			)
		);

		token.generate();
	}
}
