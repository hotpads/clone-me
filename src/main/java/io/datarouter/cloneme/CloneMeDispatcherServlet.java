package io.datarouter.cloneme;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.datarouter.inject.DatarouterInjector;
import io.datarouter.web.config.BaseDatarouterWebDispatcherServlet;
import io.datarouter.web.config.RootRouteSetsSupplier;

@Singleton
@SuppressWarnings("serial")
public class CloneMeDispatcherServlet extends BaseDatarouterWebDispatcherServlet{

	@Inject
	public CloneMeDispatcherServlet(DatarouterInjector injector, RootRouteSetsSupplier routeSets){
		super(injector);
		routeSets.get().forEach(this::addRouteSet);
	}

}
