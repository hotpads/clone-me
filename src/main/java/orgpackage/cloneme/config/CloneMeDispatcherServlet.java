package orgpackage.cloneme.config;

import io.datarouter.inject.DatarouterInjector;
import io.datarouter.web.config.BaseDatarouterWebDispatcherServlet;
import io.datarouter.web.config.RouteSetRegistry;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
@SuppressWarnings("serial")
public class CloneMeDispatcherServlet extends BaseDatarouterWebDispatcherServlet{

	@Inject
	public CloneMeDispatcherServlet(DatarouterInjector injector, RouteSetRegistry routeSetRegistry){
		super(injector);
		routeSetRegistry.get().forEach(this::addRouteSet);
	}

}
