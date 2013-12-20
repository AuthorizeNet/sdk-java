package net.authorize.reporting;

import net.authorize.AuthNetField;
import net.authorize.Merchant;
import net.authorize.data.xml.reporting.ReportingDetails;
import net.authorize.util.BasicXmlDocument;
import net.authorize.util.StringUtils;

import org.w3c.dom.Element;

/**
 * Transaction object for Reporting.
 *
 */
public class Transaction extends net.authorize.Transaction {

	private static final long serialVersionUID = 1L;
	public static String XML_NAMESPACE = "AnetApi/xml/v1/schema/AnetApiSchema.xsd";

	private Merchant merchant;
	private TransactionType transactionType;

	private ReportingDetails reportingDetails;

	private BasicXmlDocument currentRequest = null;
	private BasicXmlDocument currentResponse = null;

	/**
	 * Private constructor.
	 *
	 * @param merchant
	 * @param transactionType
	 */
	private Transaction(Merchant merchant, TransactionType transactionType) {
		this.merchant = merchant;
		this.transactionType = transactionType;
	}

	/**
	 * Creates a transaction.
	 *
	 * @param merchant
	 * @param transactionType
	 *
	 * @return Transaction
	 */
	public static Transaction createTransaction(Merchant merchant, TransactionType transactionType) {
		return new Transaction(merchant, transactionType);
	}

	/**
	 * Create a transaction from a response.
	 *
	 * @param transaction
	 * @param response
	 * @return a Transaction
	 */
	public static final Transaction createTransaction(Transaction transaction, BasicXmlDocument response) {

		transaction.currentResponse = response;

		return transaction;
	}

	/**
	 * @return the transactionType
	 */
	public TransactionType getTransactionType() {
		return transactionType;
	}

	/**
	 * Returns the current request.
	 *
	 * @return BasicXmlDocument containing the request
	 */
	public BasicXmlDocument getCurrentRequest(){
		return currentRequest;

	}

	/**
	 * Returns the current response.
	 *
	 * @return BasicXmlDocument containing the response
	 */
	public BasicXmlDocument getCurrentResponse(){
		return currentResponse;
	}

	/**
	 * Add authentication to the subscription request.
	 *
	 * @param document
	 */
	private void addAuthentication(BasicXmlDocument document){
		Element auth_el = document.createElement(AuthNetField.ELEMENT_MERCHANT_AUTHENTICATION.getFieldName());
		Element name_el = document.createElement(AuthNetField.ELEMENT_NAME.getFieldName());
		name_el.appendChild(document.getDocument().createTextNode(merchant.getLogin()));
		Element trans_key = document.createElement(AuthNetField.ELEMENT_TRANSACTION_KEY.getFieldName());
		trans_key.appendChild(document.getDocument().createTextNode(merchant.getTransactionKey()));
		auth_el.appendChild(name_el);
		auth_el.appendChild(trans_key);
		document.getDocumentElement().appendChild(auth_el);
	}

	/**
	 * Add reporting batch list options.
	 *
	 * @param document
	 */
	private void addReportingBatchListOptions(BasicXmlDocument document) {
		if(this.reportingDetails != null) {
			Element include_statistics_el = document.createElement(AuthNetField.ELEMENT_INCLUDE_STATISTICS.getFieldName());
			include_statistics_el.appendChild(document.getDocument().createTextNode(
					this.reportingDetails.isBatchIncludeStatistics()?TRUE.toLowerCase():FALSE.toLowerCase()));
			document.getDocumentElement().appendChild(include_statistics_el);

			if(this.reportingDetails.getBatchFirstSettlementDate() != null) {
				Element first_settlement_date_el = document.createElement(AuthNetField.ELEMENT_FIRST_SETTLEMENT_DATE.getFieldName());
				first_settlement_date_el.appendChild(document.getDocument().createTextNode(
						net.authorize.util.DateUtil.getFormattedDate(this.reportingDetails.getBatchFirstSettlementDate(),
						ReportingDetails.DATE_FORMAT)));
				document.getDocumentElement().appendChild(first_settlement_date_el);
			}

			if(this.reportingDetails.getBatchLastSettlementDate() != null) {
				Element last_settlement_date_el = document.createElement(AuthNetField.ELEMENT_LAST_SETTLEMENT_DATE.getFieldName());
				last_settlement_date_el.appendChild(document.getDocument().createTextNode(
						net.authorize.util.DateUtil.getFormattedDate(this.reportingDetails.getBatchLastSettlementDate(),
						ReportingDetails.DATE_FORMAT)));
				document.getDocumentElement().appendChild(last_settlement_date_el);
			}
		}
	}

	/**
	 * Add a reporting transId to the document request.
	 *
	 * @param document
	 */
	private void addReportingTransactionId(BasicXmlDocument document) {
		if(this.reportingDetails != null && StringUtils.isNotEmpty(this.reportingDetails.getTransactionId())) {
			Element transid_el = document.createElement(AuthNetField.ELEMENT_TRANS_ID.getFieldName());
			transid_el.appendChild(document.getDocument().createTextNode(
					this.reportingDetails.getTransactionId()));
			document.getDocumentElement().appendChild(transid_el);
		}
	}

	/**
	 * Add a reporting transId to the document request.
	 *
	 * @param document
	 */
	private void addReportingBatchId(BasicXmlDocument document) {
		if(this.reportingDetails != null && StringUtils.isNotEmpty(this.reportingDetails.getBatchId())) {
			Element batchid_el = document.createElement(AuthNetField.ELEMENT_BATCH_ID.getFieldName());
			batchid_el.appendChild(document.getDocument().createTextNode(
					this.reportingDetails.getBatchId()));
			document.getDocumentElement().appendChild(batchid_el);
		}
	}

	/**
	 * Convert request to XML.
	 */
	public String toXMLString() {
		switch (this.transactionType) {
		case GET_SETTLED_BATCH_LIST :
			getSettledBatchListRequest();
			break;
		case GET_TRANSACTION_DETAILS :
			getTransactionDetailsRequest();
			break;
		case GET_TRANSACTION_LIST :
			getTransactionListRequest();
			break;
		case GET_BATCH_STATISTICS :
			getBatchStatisticsRequest();
			break;
		case GET_UNSETTLED_TRANSACTION_LIST :
			getUnsettledTransactionListRequest();
			break;
		default:
			break;
		}

		return currentRequest.dump();
	}

	/**
	 * Returns Batch ID, Settlement Time, & Settlement State for all settled
	 * batches with an optional range of dates.
	 */
	private void getSettledBatchListRequest() {
		BasicXmlDocument document = new BasicXmlDocument();
		document.parseString("<" + TransactionType.GET_SETTLED_BATCH_LIST.getValue()
				+ " xmlns = \"" + XML_NAMESPACE + "\" />");

		addAuthentication(document);
		addReportingBatchListOptions(document);

		currentRequest = document;
	}

	/**
	 * Return data for all transactions in a specified batch
	 */
	private void getTransactionListRequest() {
		BasicXmlDocument document = new BasicXmlDocument();
		document.parseString("<" + TransactionType.GET_TRANSACTION_LIST.getValue()
				+ " xmlns = \"" + XML_NAMESPACE + "\" />");

		addAuthentication(document);
		addReportingBatchId(document);

		currentRequest = document;
	}

	/**
	 * Get detailed information about one specific transaction.
	 */
	private void getTransactionDetailsRequest() {
		BasicXmlDocument document = new BasicXmlDocument();
		document.parseString("<" + TransactionType.GET_TRANSACTION_DETAILS.getValue()
				+ " xmlns = \"" + XML_NAMESPACE + "\" />");

		addAuthentication(document);
		addReportingTransactionId(document);

		currentRequest = document;
	}

	/**
	 * Return batch statistical data for all transactions in a specified batch
	 */
	private void getBatchStatisticsRequest() {
		BasicXmlDocument document = new BasicXmlDocument();
		document.parseString("<" + TransactionType.GET_BATCH_STATISTICS.getValue()
				+ " xmlns = \"" + XML_NAMESPACE + "\" />");

		addAuthentication(document);
		addReportingBatchId(document);

		currentRequest = document;
	}

	/**
	 * Return the most recent 1000 unsettled transactions.
	 */
	private void getUnsettledTransactionListRequest() {
		BasicXmlDocument document = new BasicXmlDocument();
		document.parseString("<" + TransactionType.GET_UNSETTLED_TRANSACTION_LIST.getValue()
				+ " xmlns = \"" + XML_NAMESPACE + "\" />");

		addAuthentication(document);

		currentRequest = document;
	}

	/**
	 * @param reportingDetails the reportingDetails to set
	 */
	public void setReportingDetails(ReportingDetails reportingDetails) {
		this.reportingDetails = reportingDetails;
	}

	/**
	 * @return the reportingDetails
	 */
	public ReportingDetails getReportingDetails() {
		return reportingDetails;
	}



}
