package orgpackage.cloneme.config;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import io.datarouter.auth.authenticate.authenticator.DatarouterAuthenticator;
import io.datarouter.auth.authenticate.authenticator.impl.DatarouterAnonymousNonPersistentAuthenticator;
import io.datarouter.web.user.authenticate.authenticator.impl.DatarouterSessionAuthenticator;
import io.datarouter.web.user.authenticate.config.BaseDatarouterAuthenticationConfig;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class CloneMeAuthenticationConfig extends BaseDatarouterAuthenticationConfig{

	@Inject
	private DatarouterAnonymousNonPersistentAuthenticator datarouterAnonymousNonPersistentAuthenticator;
	@Inject
	private DatarouterSessionAuthenticator datarouterSessionAuthenticator;

	@Override
	public List<DatarouterAuthenticator> getAuthenticators(HttpServletRequest request){
		return List.of(
				datarouterSessionAuthenticator,
				datarouterAnonymousNonPersistentAuthenticator);
	}

	@Override
	public boolean useDatarouterAuthentication(){
		return false;
	}

}
