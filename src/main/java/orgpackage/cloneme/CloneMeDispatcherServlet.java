package orgpackage.cloneme;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.datarouter.inject.DatarouterInjector;
import io.datarouter.web.config.BaseDatarouterWebDispatcherServlet;
import io.datarouter.web.config.RouteSetRegistry;

@Singleton
@SuppressWarnings("serial")
public class CloneMeDispatcherServlet extends BaseDatarouterWebDispatcherServlet{

	@Inject
	public CloneMeDispatcherServlet(DatarouterInjector injector, RouteSetRegistry routeSetRegistry){
		super(injector);
		routeSetRegistry.get().forEach(this::addRouteSet);
	}

}
