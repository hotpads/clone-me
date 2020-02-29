package io.datarouter.cloneme;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.servlet.http.HttpServletRequest;

import io.datarouter.web.user.authenticate.authenticator.DatarouterAuthenticator;
import io.datarouter.web.user.authenticate.authenticator.impl.DatarouterAnonymousNonPersistentAuthenticator;
import io.datarouter.web.user.authenticate.authenticator.impl.DatarouterSessionAuthenticator;
import io.datarouter.web.user.authenticate.config.BaseDatarouterAuthenticationConfig;

@Singleton
public class CloneMeAuthenticationConfig extends BaseDatarouterAuthenticationConfig{

	@Inject
	private DatarouterAnonymousNonPersistentAuthenticator datarouterAnonymousNonPersistentAuthenticator;
	@Inject
	private DatarouterSessionAuthenticator datarouterSessionAuthenticator;

	@Override
	public List<DatarouterAuthenticator> getAuthenticators(HttpServletRequest request){
		return Arrays.asList(
				datarouterSessionAuthenticator,
				datarouterAnonymousNonPersistentAuthenticator);
	}

	@Override
	public boolean useDatarouterAuthentication(){
		return false;
	}

}
