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

package qa.hooks;

import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

//Test Rail Implementation
//import cucumber.api.Result;
//import io.cucumber.core.api.Scenario;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import io.cucumber.java.After;
//import org.junit.Rule;
//import org.junit.rules.TestName;
import qa.context.TestContext;
import qa.factory.DriverFactory;
import qa.utils.ZipUtils;

import static qa.constants.FrameworkConstants.BROWSER_CHROME;
import static qa.constants.FrameworkConstants.BROWSER_FIREFOX;
import static qa.constants.FrameworkConstants.PARAMETER_BROWSER;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MyHooks {
//	private static APIClient client = null;
//    private static String runId = getProperties().getProperty("runIdTestRail" );
//    private static final int FAIL_STATE = 5;
//    private static final int SUCCESS_STATE = 1;
//    private static final String SUCCESS_COMMENT = "This test passed with Selenium";
//    private static final String FAILED_COMMENT = "This test failed with Selenium";
	private WebDriver driver;
	private final TestContext context;

	/**
	 * Dependency Injection using Pico container
	 */
	public MyHooks(TestContext context) {
		this.context = context;
	}

	@Before
	public void before(Scenario scenario) {

		// ExtentReport.createTest(scenario.getName());

		System.out.println(
				"BEFORE: THREAD ID : " + Thread.currentThread().getId() + "," + "SCENARIO NAME: " + scenario.getName());

		/*
		 * System.getProperty("browser" -> This is for test execution using Maven
		 * Command Line file
		 */
		/*
		 * Setting Edge browser as default
		 */
//		driver = DriverFactory.initializeDriver(System.getProperty("browser", "edge"));
		 driver = DriverFactory.initializeDriver(System.getProperty(PARAMETER_BROWSER,
		 BROWSER_CHROME));
//		driver = DriverFactory.initializeDriver(System.getProperty(PARAMETER_BROWSER, BROWSER_FIREFOX));
//		driver = DriverFactory.initializeDriver(System.getProperty(PARAMETER_BROWSER, BROWSER_EDGE));
		// driver = DriverFactory.initializeDriver(System.getProperty(PARAMETER_BROWSER,
		// BROWSER_OPERA));
		// driver = DriverFactory.initializeDriver(System.getProperty(PARAMETER_BROWSER,
		// BROWSER_SAFARI));

		context.driver = driver;
	}

	@After
	public void after(Scenario scenario) {
		System.out.println(
				"AFTER: THREAD ID : " + Thread.currentThread().getId() + "," + "SCENARIO NAME: " + scenario.getName());

		/* If Scenario fails */
		/* This is for attaching the screenshot in Cucumber report */
		if (scenario.isFailed()) {
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}

		// doExtentReportWork(scenario);

		driver.quit();
	}

//	private void logResultToTestRail(Scenario scenario) {
//        String caseId = "";
//        System.out.println(scenario.getSourceTagNames());
//
//        for (String s : scenario.getSourceTagNames()) {
//            if (s.contains("TestRail" )) {
//
//                String[] res = s.split("(\\(.*?)" );
//
//                caseId = res[1].substring(0, res[1].length() - 1); // Removing the last parenthesis
//            }
//        }
//
//        Map<String, Serializable> data = new HashMap<>();
//
//        if (!scenario.isFailed()) {
//            data.put("status_id", SUCCESS_STATE);
//            data.put("comment", SUCCESS_COMMENT);
//
//        } else {
//            data.put("status_id", FAIL_STATE);
//            data.put("comment", logError(scenario));
//        }
//
//        if (!caseId.equals("" )) {
//            try {
//
//                if (System.getenv("runIdTestRail" ) != null && System.getenv("runTestRailId" ).equals("" )) {
//                    runId = System.getenv("runIdTestRail" );
//                }
//
//                client = testRailApiClient();
//                client.sendPost("add_result_for_case/" + runId + "/" + caseId, data);
//            } catch (IOException | APIException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
////   As per https://stackoverflow.com/a/58506614/6654475
//    private static String logError(Scenario scenario) {
//        try {
//            Class clasz = ClassUtils.getClass("cucumber.runtime.java.JavaHookDefinition$ScenarioAdaptor" );
//            Field fieldScenario = FieldUtils.getField(clasz, "scenario", true);
//            if (fieldScenario != null) {
//
//                fieldScenario.setAccessible(true);
//                Object objectScenario = fieldScenario.get(scenario);
//
//                Field fieldStepResults = objectScenario.getClass().getDeclaredField("stepResults" );
//                fieldStepResults.setAccessible(true);
//
//                ArrayList<Result> results = (ArrayList<Result>) fieldStepResults.get(objectScenario);
//                for (Result result : results) {
//                    if (result.getError() != null) {
//                        return FAILED_COMMENT + "\n" + result.getErrorMessage();
//                    }
//                }
//            }
//
//            return FAILED_COMMENT;
//
//        } catch (IllegalAccessException | NoSuchFieldException | ClassNotFoundException e) {
//            return FAILED_COMMENT;
//        }
//    }

//	private void doExtentReportWork(Scenario scenario) {
//
//		if (scenario.getStatus().toString().equals("PASSED")) {
//			ExtentLogger.pass("<b><i>" + scenario.getName() + "</i></b>");
//			ExtentLogger.pass("<b><i>" + scenario.getStatus().PASSED + "</i></b>");
//		}
//
//		if (scenario.getStatus().toString().equals("SKIPPED")) {
//			ExtentLogger.skip("<b><i>" + scenario.getName() + "</i></b>");
//			ExtentLogger.skip("<b><i>" + scenario.getStatus().SKIPPED + "</i></b>");
//		}
//
//		if (scenario.isFailed()) {
//			ExtentLogger.fail("<b><i>" + scenario.getName() + "</i></b>");
//			ExtentLogger.fail("<b><i>" + scenario.getStatus().FAILED + "</i></b>");
//		}
//
//	}

//	@BeforeStep
//	public static void beforeStep() {
//		ExtentLogger.pass("<b><i>" + "BEFORE STEP" + "</i></b>");
//	}

	@BeforeAll
	public static void beforeAll() {
		// ExtentReport.initReports();
	}

	@AfterAll
	public static void afterAll() {
		// ExtentReport.flushReports();
		ZipUtils.zip();
		// EmailSendUtils.sendEmail();

	}

}
