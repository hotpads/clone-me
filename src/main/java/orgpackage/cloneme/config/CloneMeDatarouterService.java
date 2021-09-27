package orgpackage.cloneme.config;

public enum CloneMeDatarouterService{
	CLONE_ME("clone-me", "", "");

	private final String name;
	private final String privateDomain;
	private final String publicDomain;

	CloneMeDatarouterService(String name, String privateDomain, String publicDomain){
		this.name = name;
		this.privateDomain = privateDomain;
		this.publicDomain = publicDomain;
	}

	public String getServiceName(){
		return name;
	}

	public String getPrivateDomain(){
		return privateDomain;
	}

	public String getPublicDomain(){
		return publicDomain;
	}

	public String getContextName(){
		return name;
	}

}
