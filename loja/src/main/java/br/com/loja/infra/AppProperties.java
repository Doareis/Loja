package br.com.loja.infra;

import java.io.InputStream;
import java.util.Properties;

public class AppProperties {

	private static final String FILE_NAME = "src/main/resources/app.properties";
	private Properties props;
	
	public AppProperties(){
		
		props = new Properties();
		try {
			InputStream file = getClass().getResourceAsStream(FILE_NAME);
			props.load(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String getPropriedade(String nome){
		return props.getProperty(nome);
	}
	
}
