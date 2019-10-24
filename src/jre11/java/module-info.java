import com.guicedee.guicedinjection.interfaces.IGuiceConfigurator;
import com.guicedee.guicedinjection.interfaces.IGuicePostStartup;
import com.guicedee.guicedservlets.services.IGuiceSiteBinder;
import com.guicedee.guicedservlets.webservices.implementations.WebServiceScannerConfig;
import com.guicedee.guicedservlets.webservices.implementations.WebServiceServletModule;
import com.guicedee.guicedservlets.webservices.implementations.WebServiceStarterPostLoad;

module com.guicedee.guicedservlets.webservices {
	exports com.guicedee.guicedservlets.webservices;

	requires undertow.servlet;
	requires javax.servlet.api;
	requires com.guicedee.guicedservlets;

	requires jakarta.activation;

	//requires java.ws.rs;

	requires aopalliance;
	requires com.google.common;
	requires javax.inject;
	requires org.apache.cxf;

	requires java.xml.ws;
	requires javax.jws;
	requires io.github.classgraph;
	requires com.fasterxml.jackson.databind;
	requires java.validation;

	provides IGuiceSiteBinder with WebServiceServletModule;


	provides IGuicePostStartup with WebServiceStarterPostLoad;
	provides IGuiceConfigurator with WebServiceScannerConfig;

	opens  com.guicedee.guicedservlets.webservices.implementations to com.google.guice;
	opens  com.guicedee.guicedservlets.webservices to com.google.guice;
}
