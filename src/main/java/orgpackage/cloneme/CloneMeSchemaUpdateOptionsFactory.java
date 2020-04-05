package orgpackage.cloneme;

import java.util.Properties;

import javax.inject.Singleton;

import io.datarouter.storage.config.schema.SchemaUpdateOptionsBuilder;
import io.datarouter.storage.config.schema.SchemaUpdateOptionsFactory;

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
