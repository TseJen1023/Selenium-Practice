package listenerspackage;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

public class CustomerListener2 implements IInvokedMethodListener, ITestListener, ISuiteListener {
	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		// �ڲ���������ÿһ����������֮ǰ��
		System.out.println("before Invocation:" + testResult.getTestClass().getName() + " -> "
				+ method.getTestMethod().getMethodName());
	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		// �ڲ���������ÿһ����������֮����
		System.out.println("after Invocation:" + testResult.getTestClass().getName() + " -> "
				+ method.getTestMethod().getMethodName());

	}

	@Override
	public void onFinish(ITestContext arg0) {

		System.out.println("onFinish-> test tag name:" + arg0.getName());
	}

	@Override
	public void onStart(ITestContext arg0) {
		System.out.println("onStart-> test tag name:" + arg0.getName());
		ITestNGMethod methods[] = arg0.getAllTestMethods();
		System.out.println("test��ǩ����Ҫִ�еĲ��Է���");
		for (ITestNGMethod method : methods) {
			System.out.println(method.getMethodName());
		}
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		System.out.println("onTestFailure-> test name:" + arg0.getName());
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		System.out.println("onTestStart-> test name:" + arg0.getName());
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		System.out.println("onTestSuccess-> test name:" + arg0.getName());
	}

	@Override
	public void onFinish(ISuite arg0) {
		System.out.println("onFinish:suite ִ����֮��");
	}

	@Override
	public void onStart(ISuite arg0) {
		System.out.println("onStart:suite ��ʼִ��֮ǰ");
	}

}
