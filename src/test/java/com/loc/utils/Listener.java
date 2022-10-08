package com.loc.utils;

import com.loc.base.BaseTest;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener extends BaseTest implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("I am in onTestStart method");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("I am in onTestSuccess method succeed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("I am in onTestFailure method failed");
    }
}
