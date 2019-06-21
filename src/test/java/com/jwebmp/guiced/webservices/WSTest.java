package com.jwebmp.guiced.webservices;

import com.jwebmp.logger.LogFactory;
import com.jwebmp.undertow.GuicedUndertow;
import org.junit.jupiter.api.Test;

import java.util.logging.Level;

class WSTest
{
	public static void main(String[] args) throws Exception
	{
		LogFactory.configureConsoleColourOutput(Level.FINE);
		GuicedUndertow.boot("localhost", 6004);
	}

	@Test
	void testMe() throws Exception
	{
		LogFactory.configureConsoleColourOutput(Level.FINE);
		GuicedUndertow.boot("localhost", 6004);
	}
}
