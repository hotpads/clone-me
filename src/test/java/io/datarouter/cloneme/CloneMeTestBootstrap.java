package io.datarouter.cloneme;

import io.datarouter.testng.TestNgModuleFactory;

public class CloneMeTestBootstrap{

	public static class CloneMeTestNgModuleFactory extends TestNgModuleFactory{
		public CloneMeTestNgModuleFactory(){
			super(CloneMeBootstrap.CONFIG.getModules());
		}
	}

}
