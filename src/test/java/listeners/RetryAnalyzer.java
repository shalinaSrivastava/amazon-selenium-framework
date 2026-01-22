package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{
	int maxTry=2;
	int count=0;
	@Override
	public boolean retry(ITestResult result) {
		if(count<=maxTry) {
			count++;
			return true;
		}
		return false;
	}
	

}