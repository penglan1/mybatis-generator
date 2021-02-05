package pers.penglan.mybatisgenerator.main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 * pers.penglan.mybatisgenerator.main.Generator
 */
public class Generator {
	public static void main(String[] args) throws Exception {
		List<String> warnings = new ArrayList<String>();
		ConfigurationParser cp = new ConfigurationParser(warnings);
		String path = Generator.class.getResource("/mybatisConfig/generatorSystemConfig.xml").getPath();
		Configuration config = cp.parseConfiguration(new File(path));
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, new DefaultShellCallback(true), warnings);
		
		myBatisGenerator.generate(null);
        for (String warning : warnings) {
            System.out.println(warning);
        }

	}
}
