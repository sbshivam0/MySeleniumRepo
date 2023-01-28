package launcher;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentManager extends Launcher {
	public static ExtentHtmlReporter htmlReport;
	public static ExtentReports reports;
	
	public static ExtentReports getInstance()
	{
		if(htmlReport==null)
		{
			htmlReport = new ExtentHtmlReporter(projectPath+"\\htmlReports\\+report.html");
			htmlReport.config().setDocumentTitle("Automation Report");
			htmlReport.config().setReportName("Funtional Report");
			htmlReport.config().setTheme(Theme.DARK);
			
			reports = new ExtentReports();
			reports.attachReporter(htmlReport);
			reports.setSystemInfo("OS", "Windows10");
			reports.setSystemInfo("Tester", "Shivam");
			reports.setSystemInfo("Browser", "Chrome");
			
			
		}
		return reports;
	}

}
