package org.apache.ibatis.parsing;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.junit.Assert;
import org.junit.Test;

public class XPathParserTest {
	
	@Test
	public void shouldTestXPathParserMethods() throws Exception {
		String resource = "nodelet_test.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		XPathParser parser = new XPathParser(inputStream, false, null, null);
		Assert.assertEquals((Long) 1970l, parser.evalLong("/employee/birth_date/year"));
		Assert.assertEquals((short) 6, (short) parser.evalShort("/employee/birth_date/month"));
		Assert.assertEquals((Integer) 15, parser.evalInteger("/employee/birth_date/day"));
		Assert.assertEquals((Float) 5.8f, parser.evalFloat("/employee/height"));
		Assert.assertEquals((Double) 5.8d, parser.evalDouble("/employee/height"));
		Assert.assertEquals("${id_var}", parser.evalString("/employee/@id"));
		Assert.assertEquals(Boolean.TRUE, parser.evalBoolean("/employee/active"));
		Assert.assertEquals("<id>${id_var}</id>", parser.evalNode("/employee/@id").toString().trim());
		Assert.assertEquals(7, parser.evalNodes("/employee/*").size());
		XNode node = parser.evalNode("/employee/height");
		Assert.assertEquals("employee/height", node.getPath());
		Assert.assertEquals("employee[${id_var}]_height", node.getValueBasedIdentifier());
	}

}