package com.tc911.common.core;

import java.net.MalformedURLException;
import java.net.URL;

import br.eti.kinoshita.testlinkjavaapi.TestLinkAPI;
import br.eti.kinoshita.testlinkjavaapi.constants.ExecutionStatus;

public class TestLink {
	public static final String DEV_KEY = "f58d8a1b4bfe5325276d693c9163fa0b"; //Your API 
    public static final String SERVER_URL = "http://tinpham-pc:81/testlink/lib/api/xmlrpc/v1/xmlrpc.php"; //http://anphan:8081/testlink/index.php
    public static final String PROJECT_NAME = "LogiTrak automation";
    public static final String PLAN_NAME = "Login plan";
    public static final String BUILD_NAME = "build 1.0";
    public static String result = "";
    public static String exception = null;
    public static void updateTestLinkResult(Integer testCaseId, Integer planId, ExecutionStatus executionStatus, 
    		Integer buildId, String note ){
    	URL url = null;
    	try {
            url = new URL(SERVER_URL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        TestLinkAPI testlinkAPIClient = new TestLinkAPI(url,DEV_KEY);
        testlinkAPIClient.setTestCaseExecutionResult(testCaseId,testCaseId,planId, executionStatus, buildId, null, note, false, 
        		null, null, null, null, false);
    }
}
