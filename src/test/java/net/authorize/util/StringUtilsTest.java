package net.authorize.util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringUtilsTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testXSSString() {
		String xss = "<script>I HACK YOU!</script>";

		Assert.assertNotSame(xss, StringUtils.sanitizeString(xss));
		Assert.assertEquals("&lt;script&gt;I HACK YOU&#033;&lt;&#047;script&gt;", StringUtils.sanitizeString(xss));
	}

}
