package tools.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;

@ConfigurationProperties("stsds")
public class DbProp {
	private Map<String,DataSourceProperties> schemas = new HashMap<String, DataSourceProperties>();

	public Map<String, DataSourceProperties> getSchemas() {
		return schemas;
	}

	public void setSchemas(Map<String, DataSourceProperties> schemas) {
		this.schemas = schemas;
	}

}
