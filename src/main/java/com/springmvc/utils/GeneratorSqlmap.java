package com.springmvc.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

public class GeneratorSqlmap {

	public static void main(String[] args) throws Exception {
		List<String> warnings = new ArrayList<>();
		boolean overwrite = true;
//		InputStream inputStream = GeneratorSqlmap.class.getResourceAsStream("/generatorConfig.xml");
		String path = GeneratorSqlmap.class.getClass().getResource("/").getPath();
		File configFile = new File(path+"generatorConfig.xml");
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);
		System.out.println("恭喜，使用MyBatis_Generator生成model、Mapper、Mapper.xml成功。");
	}
}
