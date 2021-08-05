package orgpackage.cloneme.config;

import io.datarouter.httpclient.client.DatarouterService;

public enum CloneMeDatarouterService implements DatarouterService{
	CLONE_ME("clone-me", "", "");

	private final String name;
	private final String privateDomain;
	private final String publicDomain;

	CloneMeDatarouterService(String name, String privateDomain, String publicDomain){
		this.name = name;
		this.privateDomain = privateDomain;
		this.publicDomain = publicDomain;
	}

	@Override
	public String getServiceName(){
		return name;
	}

	@Override
	public String getPrivateDomain(){
		return privateDomain;
	}

	@Override
	public String getPublicDomain(){
		return publicDomain;
	}

	@Override
	public String getContextName(){
		return name;
	}

}
