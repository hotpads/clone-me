package orgpackage.cloneme.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import io.datarouter.instrumentation.test.TestableService;
import io.datarouter.scanner.Scanner;
import io.datarouter.storage.dao.Daos;
import io.datarouter.testng.TestNgModuleFactory;
import io.datarouter.web.test.TestableServiceClassRegistry;
import jakarta.inject.Inject;

public class CloneMeTestBootstrap{

	public static class CloneMeTestNgModuleFactory extends TestNgModuleFactory{
		public CloneMeTestNgModuleFactory(){
			super(CloneMeBootstrap.CONFIG.getModules());
		}
	}

	@Guice(moduleFactory = CloneMeTestNgModuleFactory.class)
	public static class CloneMeBootstrapTests{
		private static final Logger logger = LoggerFactory.getLogger(CloneMeBootstrapTests.class);

		@SuppressWarnings("unused") // not used but initialized
		@Inject
		private Daos daos;
		@Inject
		private TestableServiceClassRegistry registry;

		public void afterClass(){
			registry.get().forEach(TestableService::afterClass);
		}

		@Test
		public void testAll(){
			Scanner.of(registry.get())
					.distinct()
					.each(instance -> logger.warn("Running tests for {}", instance.getClass().getSimpleName()))
					.forEach(TestableService::testAll);
		}

	}

}
