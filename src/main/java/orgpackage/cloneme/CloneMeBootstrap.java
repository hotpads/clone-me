package orgpackage.cloneme;

import java.util.Properties;

import javax.inject.Singleton;
import javax.servlet.annotation.WebListener;

import org.apache.logging.log4j.web.Log4jServletContextListener;

import io.datarouter.client.mysql.config.DatarouterMysqlPlugin.DatarouterMysqlPluginBuilder;
import io.datarouter.client.mysql.factory.MysqlClientOptionsBuilder;
import io.datarouter.secret.config.DatarouterSecretPlugin.DatarouterSecretPluginBuilder;
import io.datarouter.storage.client.ClientId;
import io.datarouter.storage.client.ClientOptionsFactory;
import io.datarouter.storage.servertype.BaseServerTypes;
import io.datarouter.storage.servertype.ServerType;
import io.datarouter.storage.servertype.ServerTypeDetector.NoOpServerTypeDetector;
import io.datarouter.tasktracker.config.DatarouterTaskTrackerPlugin.DatarouterTaskTrackerPluginBuilder;
import io.datarouter.web.config.DatarouterBootstrap;
import io.datarouter.web.config.DatarouterWebListener;
import io.datarouter.web.config.DatarouterWebWebappBuilder;
import io.datarouter.web.config.DatarouterWebappConfig;
import io.datarouter.web.filter.https.InsecureHttpsConfiguration;
import orgpackage.cloneme.CloneMeBootstrap.CloneMeClientIds.CloneMeClientOptionsFactory;

public class CloneMeBootstrap implements DatarouterBootstrap{

	@Singleton
	public static class CloneMeServerType extends BaseServerTypes{
		
		private static final ServerType CLONE_ME = makeProduction("clone-me");

		public CloneMeServerType(){
			super(CLONE_ME);
		}
		
	}

	public static class CloneMeClientIds{
		
		public static final ClientId MYSQL = new ClientId("mysql", true, false);

		@Singleton
		public static class CloneMeClientOptionsFactory implements ClientOptionsFactory{

			private static final String MYSQL_SCHEMA = "cloneme";

			@Override
			public Properties getInternalConfigDirectoryTypeOptions(String internalConfigDirectory){
				switch(internalConfigDirectory){
				case "dev-docker":
					return buildDevDockerOptions();
				default:
					return new Properties();
				}
			}

			private Properties buildDevDockerOptions(){
				return new MysqlClientOptionsBuilder(MYSQL)
						.withUrl("percona.docker:3306/" + MYSQL_SCHEMA)
						.build();
			}

		}
		
	}
	
	public static final DatarouterWebappConfig CONFIG = new DatarouterWebWebappBuilder(
			CloneMeDatarouterService.CLONE_ME,
			new CloneMeServerType(),
			new CloneMeDatarouterProperties(new CloneMeServerType()),
			CloneMeClientIds.MYSQL,
			new Log4jServletContextListener())
			.addWebPlugin(new DatarouterMysqlPluginBuilder().build())
			.addWebPlugin(new DatarouterSecretPluginBuilder(CloneMeClientIds.MYSQL).build())
			.addWebPlugin(new DatarouterTaskTrackerPluginBuilder(CloneMeClientIds.MYSQL).build())
			.setAuthenticationConfig(CloneMeAuthenticationConfig.class)
			.setClientOptionsFactory(CloneMeClientOptionsFactory.class)
			.setHttpsConfiguration(InsecureHttpsConfiguration.class)
			.setServerTypeDetector(NoOpServerTypeDetector.class)
			.build();

	@WebListener
	public static class CloneMeWebListener extends DatarouterWebListener{
		
		public CloneMeWebListener(){
			super(CONFIG);
		}
		
	}

}
