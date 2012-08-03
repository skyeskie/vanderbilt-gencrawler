// Copyright 2010 Google Inc. All Rights Reserved.
package com.crawljax.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.apache.commons.configuration.ConfigurationException;
import org.junit.Test;

import com.crawljax.core.configuration.CrawlSpecification;

/**
 * This test checks that all iframes are ignored using crawlspec call.
 * 
 * @author Stefan Lenselink <slenselink@google.com>
 * @version $Id: DisableCrawlIFrameTest.java 399 2010-08-04 17:08:16Z slenselink@google.com $
 */
public class DisableCrawlIFrameTest extends IFrameSuper {

	@Override
	protected CrawlSpecification getCrawlSpecification() {
		CrawlSpecification spec = super.getCrawlSpecification();
		spec.disableCrawlFrames();
		return spec;
	}

	@Test
	public void testIFramesNotCrawled() {
		try {
			crawljax.run();
			assertEquals("Clickables", 3,
			        crawljax.getSession().getStateFlowGraph().getAllEdges().size());
			assertEquals(
			        "States", 4, crawljax.getSession().getStateFlowGraph().getAllStates().size());
		} catch (ConfigurationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (CrawljaxException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}