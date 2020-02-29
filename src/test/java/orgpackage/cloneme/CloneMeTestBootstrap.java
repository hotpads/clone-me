package orgpackage.cloneme;

import io.datarouter.testng.TestNgModuleFactory;
import orgpackage.cloneme.CloneMeBootstrap;

public class CloneMeTestBootstrap{

	public static class CloneMeTestNgModuleFactory extends TestNgModuleFactory{
		public CloneMeTestNgModuleFactory(){
			super(CloneMeBootstrap.CONFIG.getModules());
		}
	}

}
