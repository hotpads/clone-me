package orgpackage.cloneme.config;

import java.util.Properties;

import io.datarouter.storage.config.schema.SchemaUpdateOptionsBuilder;
import io.datarouter.storage.config.schema.SchemaUpdateOptionsFactory;
import jakarta.inject.Singleton;

@Singleton
public class CloneMeSchemaUpdateOptionsFactory implements SchemaUpdateOptionsFactory{

	@Override
	public Properties getInternalConfigDirectoryTypeSchemaUpdateOptions(String internalConfigDirectory){
		switch(internalConfigDirectory){
		case "dev-docker":
			return new SchemaUpdateOptionsBuilder(true)
					.enableAllSchemaUpdateExecuteOptions()
					.build();
		default:
			return new Properties();
		}
	}

}
