package org.apache.ibatis.session;

import java.io.Reader;

import org.apache.ibatis.BaseDataTest;
import org.apache.ibatis.io.Resources;
import org.junit.BeforeClass;

public class SqlSessionTest extends BaseDataTest {
	
	private static SqlSessionFactory sqlMapper;
	
	@BeforeClass
	public static void setup() throws Exception {
		createBlogDataSource();
	    final String resource = "org/apache/ibatis/builder/MapperConfig.xml";
	    final Reader reader = Resources.getResourceAsReader(resource);
	    sqlMapper = new SqlSessionFactoryBuilder().build(reader);
	}

}