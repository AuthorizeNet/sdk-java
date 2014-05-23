package net.authorize.apicore.helper.test;

import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import junit.framework.Assert;
import net.authorize.apicore.contract.v1.ARBGetSubscriptionReportRequest;
import net.authorize.apicore.contract.v1.ARBGetSubscriptionReportResponse;
import net.authorize.apicore.contract.v1.ARBSubscriptionReportOrderFieldEnum;
import net.authorize.apicore.contract.v1.ARBSubscriptionReportSearchTypeEnum;
import net.authorize.apicore.contract.v1.ArrayOfSubscriptionInfo;
import net.authorize.apicore.contract.v1.CustomerPaymentProfileType;
import net.authorize.apicore.contract.v1.DeleteCustomerProfileRequest;
import net.authorize.apicore.contract.v1.DeleteCustomerProfileResponse;
import net.authorize.apicore.contract.v1.MessageTypeEnum;
import net.authorize.apicore.contract.v1.ValidationModeEnum;
import net.authorize.apicore.helper.ARBGetSubscriptionReportController;
import net.authorize.apicore.helper.DeleteCustomerProfileController;
import net.authorize.apicore.contract.v1.SubscriptionInfo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ArbSubscription extends ApiCoreTestBase {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ApiCoreTestBase.setUpBeforeClass();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		ApiCoreTestBase.tearDownAfterClass();
	}

	@Before
	public void setUp() throws Exception {
		super.setUp();
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testGetSubscriptionReport() throws DatatypeConfigurationException {
		logger.debug("Starting test");
		DatatypeFactory datatypeFactory = DatatypeFactory.newInstance();
		GregorianCalendar startDate = new GregorianCalendar(2010, 01, 01);
		GregorianCalendar endDate = new GregorianCalendar();

		//create a new customer profile
		ARBGetSubscriptionReportRequest reportRequest = new ARBGetSubscriptionReportRequest();
		reportRequest.setMerchantAuthentication(cnpMerchantAuthenticationType);
		reportRequest.setRefId(refId);
		reportRequest.setUserId(10);
		reportRequest.setMerchantId(21435);
		reportRequest.setExpDateHash(null);
		reportRequest.setStartReportDate(datatypeFactory.newXMLGregorianCalendar(startDate));
		reportRequest.setEndReportDate(datatypeFactory.newXMLGregorianCalendar(endDate));
		reportRequest.setSearchType(ARBSubscriptionReportSearchTypeEnum.WILL_EXPIRE);
		reportRequest.setOrderBy(ARBSubscriptionReportOrderFieldEnum.CREATE_TIME);
		reportRequest.setOrderDescending(false);
		reportRequest.setPageNumberBeingRetrieved(1);
		reportRequest.setNumItemsInResultSet(100);
		
		logger.debug(String.format("Created Request: %s", reportRequest));

		ARBGetSubscriptionReportController report = new ARBGetSubscriptionReportController(reportRequest);
		ARBGetSubscriptionReportResponse reportResponse = report.executeWithApiResponse(environment);
		logger.info(String.format("GetSubscriptionReport ResultCode: %s", report.getResultCode()));
		logger.info(String.format("GetSubscriptionReport Results:    %s", report.getResults()));

		Assert.assertEquals( MessageTypeEnum.OK, report.getResultCode());
		Assert.assertNull(report.getErrorResponse());
		Assert.assertNotNull(reportResponse);
		Assert.assertTrue( 0 < reportResponse.getTotalNumInResultSet());
		ArrayOfSubscriptionInfo subscriptionInfoArray = reportResponse.getSubscriptionInfoList();
		Assert.assertNotNull( subscriptionInfoArray);

		for( SubscriptionInfo si : subscriptionInfoArray.getSubscriptionInfo()) {
			Assert.assertTrue( 0 < si.getId());
		}
		logger.debug("Test Finished");
	}
}
