package com.demo.mybatis;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class CreateSqlXML {
	public static void main(String[] args) throws Exception
	{
		List warnings = new ArrayList();
		boolean overwrite = true;
		String genCfg = "mbgConfiguration.xml";
		ClassLoader classLoader = CreateSqlXML.class.getClassLoader();
		System.out.println(classLoader+"=========");
		URL url =classLoader.getResource(genCfg);
		File configFile = new File(url.getPath());
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = null;
		config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = null;
		myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);

		System.out.println("生成成功，请刷新后查看。。。。。。。");
	}
}