/**
 * @author Rajat Verma
 * https://www.linkedin.com/in/rajat-v-3b0685128/
 * https://github.com/rajatt95
 * https://rajatt95.github.io/
 *
 * Course: Cucumber BDD Masterclass with Selenium 4 & Java + Framework (https://www.udemy.com/course/cucumber-bdd-masterclass/)
 * Tutor: Omprakash Chavan (https://www.udemy.com/user/omprakash-chavan/)
 */

/***************************************************/

package qa.utils;

import static qa.constants.FrameworkConstants.DIRECTORY_ENV_CONFIG;
import static qa.constants.FrameworkConstants.ENV_CONFIG_DEV;
import static qa.constants.FrameworkConstants.ENV_CONFIG_PROD;
import static qa.constants.FrameworkConstants.ENV_CONFIG_DEMO;
import static qa.constants.FrameworkConstants.ENV_CONFIG_STG;
import static qa.constants.FrameworkConstants.PARAMETER_ENV;

import java.util.Properties;

import qa.enums.EnvType;

/**
 * Singleton Design Pattern is implemented here
 */
public class ConfigLoader {

	private static final String OPS_URL = "OpsUrl";
	private static final String CORP_URL = "CorpUrl";
	private static final String BASE_URL = "baseUrl";
	private static final String SEND_EMAIL_TO_USERS = "send_email_to_users";


	// private final Properties properties;
	private Properties properties;

	private static ConfigLoader configLoader;

	private ConfigLoader() {

		/**
		 * Setting the Environment Parameter here.
		 * 
		 * By default, Stage will be taken
		 */
		// PARAMETER_ENV = "env";
		String env = System.getProperty(PARAMETER_ENV, String.valueOf(EnvType.DEV));

		switch (EnvType.valueOf(env)) {

		case DEMO: {
			properties = PropertyUtils.propertyLoader(DIRECTORY_ENV_CONFIG + ENV_CONFIG_DEMO);
			break;
		}
		case DEV: {
			properties = PropertyUtils.propertyLoader(DIRECTORY_ENV_CONFIG + ENV_CONFIG_DEV);
			break;
		}
		case STG: {
			properties = PropertyUtils.propertyLoader(DIRECTORY_ENV_CONFIG + ENV_CONFIG_STG);
			break;
		}
		case PROD: {
			properties = PropertyUtils.propertyLoader(DIRECTORY_ENV_CONFIG + ENV_CONFIG_PROD);
			break;
		}
		default:
			throw new IllegalStateException("INVALID ENV: " + env);
		}
	}

	public static ConfigLoader getInstance() {
		if (configLoader == null) {
			configLoader = new ConfigLoader();
		}
		return configLoader;
	}

	public String getOpsUrl() {
		return getPropertyValue(OPS_URL);
	}
	public String getCorpUrl() {
		return getPropertyValue(CORP_URL);
	}
	public String getBaseUrl() {
		return getPropertyValue(BASE_URL);
	}
	public String getSendEmailToUsers() {
		return getPropertyValue(SEND_EMAIL_TO_USERS);
	}
	
	private String getPropertyValue(String propertyKey) {
		String prop = properties.getProperty(propertyKey);
		if (prop != null) {
			System.out.println("Property value: "+prop);
			return prop.trim();
		} else {
			throw new RuntimeException("Property " + propertyKey + " is not specified in the config.properties file");
		}
	}
	
	
}
