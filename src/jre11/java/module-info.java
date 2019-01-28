module com.jwebmp.guiced.webservices {
	exports com.jwebmp.guiced.webservices;

	requires undertow.servlet;
	requires javax.servlet.api;
	requires com.jwebmp.guicedservlets;
	requires webservices.rt;
	requires webservices.api;

	provides com.jwebmp.guicedservlets.services.IGuiceSiteBinder with com.jwebmp.guiced.webservices.implementations.WebServiceServletModule;
	provides com.jwebmp.guicedinjection.interfaces.IGuiceDefaultBinder with com.jwebmp.guiced.webservices.implementations.GuicedWebServiceTypeBinder;
}
