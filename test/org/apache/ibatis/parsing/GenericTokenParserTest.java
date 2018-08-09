package org.apache.ibatis.parsing;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class GenericTokenParserTest {
	
	public static class VariableTokenHandler implements TokenHandler {
		
		private Map<String, String> variables = new HashMap<String, String>();
		
		public VariableTokenHandler(Map<String, String> variables) {
			this.variables = variables;
		}
 
		@Override
		public String handleToken(String content) {
			return variables.get(content);
		}
		
	}
	
	@Test
	public void shouldDemonstrateGenericTokenReplacement() {
		Map<String, String> variablesMap = new HashMap<String, String>();
		variablesMap.put("first_name", "James");
		variablesMap.put("initial", "T");
		variablesMap.put("last_name", "Kirk");
		variablesMap.put("", "");
		TokenHandler handler = new VariableTokenHandler(variablesMap);
		
		GenericTokenParser parser = new GenericTokenParser("${", "}", handler);
		
		Assert.assertEquals("James T Kirk reporting.", parser.parse("${first_name} ${initial} ${last_name} reporting."));
		Assert.assertEquals("Hello captain James T Kirk", parser.parse("Hello captain ${first_name} ${initial} ${last_name}"));
		Assert.assertEquals("James T Kirk", parser.parse("${first_name} ${initial} ${last_name}"));
		Assert.assertEquals("JamesTKirk", parser.parse("${first_name}${initial}${last_name}"));
		Assert.assertEquals("{}JamesTKirk", parser.parse("{}${first_name}${initial}${last_name}"));
		Assert.assertEquals("}JamesTKirk", parser.parse("}${first_name}${initial}${last_name}"));
		Assert.assertEquals("}James{{T}}Kirk", parser.parse("}${first_name}{{${initial}}}${last_name}"));
		Assert.assertEquals("}James}T{Kirk", parser.parse("}${first_name}}${initial}{${last_name}"));
		Assert.assertEquals("}James}T{Kirk{{}}", parser.parse("}${first_name}}${initial}{${last_name}{{}}"));
		Assert.assertEquals("}James}T{Kirk{{}}", parser.parse("}${first_name}}${initial}{${last_name}{{}}${}"));
		
		Assert.assertEquals("{$$something}JamesTKirk", parser.parse("{$$something}${first_name}${initial}${last_name}"));
		Assert.assertEquals("${", parser.parse("${"));
		Assert.assertEquals("}", parser.parse("}"));
		Assert.assertEquals("Hello ${ this is a test.", parser.parse("Hello ${ this is a test."));
		Assert.assertEquals("Hello } this is a test.", parser.parse("Hello } this is a test."));
		Assert.assertEquals("Hello } ${ this is a test.", parser.parse("Hello } ${ this is a test."));
	}
	
	@Test
	public void shallNotInterpolateSkippedVaiables() {
		GenericTokenParser parser = new GenericTokenParser("${", "}", new VariableTokenHandler(new HashMap<String, String>()));
		Assert.assertEquals("${skipped} variable", parser.parse("\\${skipped} variable"));
		Assert.assertEquals("This is a ${skipped} variable", parser.parse("This is a \\${skipped} variable"));
		Assert.assertEquals("null ${skipped} variable", parser.parse("${skipped} \\${skipped} variable"));
		Assert.assertEquals("The null is ${skipped} variable", parser.parse("The ${skipped} is \\${skipped} variable"));
	}
	
	@Test(timeout = 1000)
	public void shouldParseFastOnJdk7u6() {
		GenericTokenParser parser = new GenericTokenParser("${", "}", new VariableTokenHandler(new HashMap<String, String>() {
			private static final long serialVersionUID = -1234811649085410855L;
			{
				put("first_name", "James");
				put("initial", "T");
				put("last_name", "Kirk");
				put("", "");
			}
		}));
		StringBuilder input = new StringBuilder();
		for(int i = 0; i < 10000; i++) {
			input.append("${first_name} ${initial} ${last_name} reporting. ");
		}
		StringBuilder expected = new StringBuilder();
		for(int i = 0; i < 10000; i++) {
			expected.append("James T Kirk reporting. ");
		}
		Assert.assertEquals(expected.toString(), parser.parse(input.toString()));
	}
	
}