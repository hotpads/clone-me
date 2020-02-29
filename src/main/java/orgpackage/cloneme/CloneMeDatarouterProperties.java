package orgpackage.cloneme;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.datarouter.storage.config.DatarouterProperties;
import io.datarouter.storage.servertype.ServerTypes;

@Singleton
public class CloneMeDatarouterProperties extends DatarouterProperties{

	private static final String SERVICE_NAME = "clone-me";
	private static final String DEFAULT_CONFIG_DIRECTORY = "/etc/datarouter/config";
	private static final String CONFIG_DIRECTORY_ENV_VARIABLE = "CONFIG_DIRECTORY";

	public static final String SERVER_CONFIG_FILE_NAME = "server.properties";
	public static final String DATAROUTER_PROPERTIES_FILE_NAME = "datarouter-clone-me.properties";
	public static final String CONFIG_DIRECTORY;
	static{
		String configDirectory = System.getenv(CONFIG_DIRECTORY_ENV_VARIABLE);
		if(configDirectory == null || configDirectory.isEmpty()){
			CONFIG_DIRECTORY = DEFAULT_CONFIG_DIRECTORY;
		}else{
			CONFIG_DIRECTORY = configDirectory + "/config";
		}
	}

	private final String datarouterPropertiesFileLocation;

	@Inject
	public CloneMeDatarouterProperties(ServerTypes serverTypes){
		super(serverTypes, SERVICE_NAME, CONFIG_DIRECTORY, SERVER_CONFIG_FILE_NAME);
		this.datarouterPropertiesFileLocation = findConfigFile(DATAROUTER_PROPERTIES_FILE_NAME);
	}

	@Override
	public String getDatarouterPropertiesFileLocation(){
		return datarouterPropertiesFileLocation;
	}

}
