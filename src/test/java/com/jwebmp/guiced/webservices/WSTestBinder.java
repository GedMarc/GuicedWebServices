package com.jwebmp.guiced.webservices;

import com.google.inject.AbstractModule;
import com.jwebmp.guicedinjection.interfaces.IGuiceModule;

public class WSTestBinder
		extends AbstractModule
		implements IGuiceModule<WSTestBinder>
{
	@Override
	protected void configure()
	{
		super.configure();
		bind(HelloWorldWebService.class);
	}
}
