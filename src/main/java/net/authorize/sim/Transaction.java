package net.authorize.sim;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import net.authorize.AuthNetField;
import net.authorize.Environment;
import net.authorize.Merchant;
import net.authorize.TransactionType;
import net.authorize.sim.button.Button;
import net.authorize.sim.button.ImageButton;
import net.authorize.sim.button.TextButton;
import net.authorize.sim.data.HostedPaymentFormSettings;
import net.authorize.sim.data.HostedReceiptPageSettings;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Transaction extends net.authorize.aim.Transaction {

	private static final long serialVersionUID = 1L;

	private static Log logger = LogFactory.getLog(Transaction.class);

	public static final int MAX_RECEIPT_LINK_TEXT_LENGTH = 50;
	public static final String PAYMENT_FORM = "PAYMENT_FORM";

	private LinkedHashMap<String,String> formInputMap = new LinkedHashMap<String, String>();
	private Map<String, String> fieldsToRename = new HashMap<String,String>();
	private Fingerprint fingerprint;
	private HostedPaymentFormSettings hostedPaymentFormSettings;
	private HostedReceiptPageSettings hostedReceiptPageSettings;
	private Environment environment;

	/**
	 * Constructor.
	 *
	 * @param merchant
	 * @param transactionType
	 * @param amount
	 */
	protected Transaction(Merchant merchant, TransactionType transactionType,
			BigDecimal amount) {
		super(merchant, transactionType, amount);

		// remove data that is sensitive for SIM
		this.requestMap.remove(AuthNetField.X_TRAN_KEY.getFieldName());

		// Indicates whether a delimited transaction response is required
		this.requestMap.put(AuthNetField.X_DELIM_DATA.getFieldName(), FALSE);
		this.environment = merchant.getEnvironment();
	}

	/**
	 * Create a Transaction for a given merchant.
	 *
	 * @param merchant
	 * @param transactionType
	 * @param fingerPrintSequence
	 * @param amount
	 *
	 * @return a Transaction
	 */
	public static Transaction createTransaction(Merchant merchant,
			TransactionType transactionType, long fingerPrintSequence, BigDecimal amount) {

		Transaction transaction = new Transaction(merchant, transactionType, amount);

		transaction.fingerprint = Fingerprint.createFingerprint(merchant, fingerPrintSequence, amount);
		transaction.requestMap.put(AuthNetField.X_FP_SEQUENCE.getFieldName(), Long.toString(transaction.fingerprint.getSequence()));
		transaction.requestMap.put(AuthNetField.X_FP_TIMESTAMP.getFieldName(),Long.toString(transaction.fingerprint.getTimeStamp()));
		transaction.requestMap.put(AuthNetField.X_FP_HASH.getFieldName(),transaction.fingerprint.getFingerprintHash());

		return transaction;
	}


	/**
	 * @return the fingerprint
	 */
	public Fingerprint getFingerprint() {
		return fingerprint;
	}

	/**
	 * @return the environment
	 */
	public Environment getEnvironment() {
		return environment;
	}

	/**
	 * If true, will populate a field that indicates that the merchant would like to
	 * use the payment gateway hosted payment form to collect payment data.
	 *
	 * @param showForm
	 */
	public void setShowPaymentForm(boolean showForm) {
		if(showForm) {
			this.requestMap.put(AuthNetField.X_SHOW_FORM.getFieldName(), PAYMENT_FORM);
		} else {
			this.requestMap.remove(AuthNetField.X_SHOW_FORM.getFieldName());
		}
	}

	/**
	 * Returns true if the payment data collection form should be displayed/used.
	 *
	 * @return boolean
	 */
	public boolean isShowPaymentForm() {

		return this.requestMap.containsKey(AuthNetField.X_SHOW_FORM.getFieldName()) &&
			PAYMENT_FORM.equals(this.requestMap.get(AuthNetField.X_SHOW_FORM.getFieldName()));
	}

	/**
	 * Get the field names that should not be auto populated
	 * in the createForm method.  The developer can then offer
	 * these as customized input fields in the form.
	 *
	 * @return the fieldsToRemoveFromForm
	 */
	public Map<String, String> getFormInputs() {
		return this.formInputMap;
	}

	/**
	 * Add an input name and replacement data to the list of fields that should
	 * not be auto populated in the createForm method.  If the optionsMap is
	 * empty, then no input element will be created in the form for the
	 * specified inputName.
	 *
	 * Example:
	 *
	 * If "notes" was passed in as the inputName, the htmlInputData provided
	 * could look like
	 *
	 * "<div>
	 *   <label>Notes</label>
	 *   <input type='text' class='text' name='notes' size='45'></input>
     * </div>"
	 *
	 * @param inputName
	 * @param htmlInputData
	 */
	public void addFormInput(String inputName, String htmlInputData) {
		this.formInputMap.put(inputName, htmlInputData);
	}

	/**
	 * @param formInputs the form input names and input options that should not
	 * be auto populated in the createForm method.
	 */
	public void setFormInputs(LinkedHashMap<String, String> formInputs) {
		this.formInputMap = formInputs;
	}

	/**
	 * @return the hostedPaymentFormSettings
	 */
	public HostedPaymentFormSettings getHostedPaymentFormSettings() {
		return hostedPaymentFormSettings;
	}

	/**
	 * @param hostedPaymentFormSettings the hostedPaymentFormSettings to set
	 */
	public void setHostedPaymentFormSettings(
			HostedPaymentFormSettings hostedPaymentFormSettings) {
		this.hostedPaymentFormSettings = hostedPaymentFormSettings;
		if(hostedPaymentFormSettings != null) {
			this.requestMap.put(AuthNetField.X_HEADER_HTML_PAYMENT_FORM.getFieldName(),
				hostedPaymentFormSettings.getHeader() != null?hostedPaymentFormSettings.getHeader():EMPTY_STRING);
			this.requestMap.put(AuthNetField.X_FOOTER_HTML_PAYMENT_FORM.getFieldName(),
				hostedPaymentFormSettings.getFooter() != null?hostedPaymentFormSettings.getFooter():EMPTY_STRING);
			this.requestMap.put(AuthNetField.X_COLOR_BACKGROUND.getFieldName(),
				hostedPaymentFormSettings.getBackgroundColor() != null?hostedPaymentFormSettings.getBackgroundColor():EMPTY_STRING);
			this.requestMap.put(AuthNetField.X_COLOR_LINK.getFieldName(),
				hostedPaymentFormSettings.getLinkColor() != null?hostedPaymentFormSettings.getLinkColor():EMPTY_STRING);
			this.requestMap.put(AuthNetField.X_COLOR_TEXT.getFieldName(),
				hostedPaymentFormSettings.getTextColor() != null?hostedPaymentFormSettings.getTextColor():EMPTY_STRING);
			this.requestMap.put(AuthNetField.X_LOGO_URL.getFieldName(),
				hostedPaymentFormSettings.getMerchantLogoUrl() != null?hostedPaymentFormSettings.getMerchantLogoUrl():EMPTY_STRING);
			this.requestMap.put(AuthNetField.X_BACKGROUND_URL.getFieldName(),
				hostedPaymentFormSettings.getBackgroundUrl() != null?hostedPaymentFormSettings.getBackgroundUrl():EMPTY_STRING);
		}
	}

	/**
	 * @return the fieldsToRename
	 */
	public Map<String, String> getFieldsToRename() {
		return fieldsToRename;
	}

	/**
	 * @param fieldsToRename the fieldsToRename to set
	 */
	public void setFieldsToRename(Map<String, String> fieldsToRename) {
		this.fieldsToRename = fieldsToRename;
		this.requestMap.put(AuthNetField.X_RENAME.getFieldName(), EMPTY_STRING);
	}

	/**
	 * Add a field to rename.
	 *
	 * @param fieldToRename
	 * @param replacementName
	 */
	public void addFieldToRename(String fieldToRename, String replacementName) {
		this.fieldsToRename.put(fieldToRename, replacementName);
		this.requestMap.put(AuthNetField.X_RENAME.getFieldName(), EMPTY_STRING);
	}

	/**
	 * @return the hostedReceiptPageSettings
	 */
	public HostedReceiptPageSettings getHostedReceiptPageSettings() {
		return hostedReceiptPageSettings;
	}

	/**
	 * @param hostedReceiptPageSettings the hostedReceiptPageSettings to set
	 */
	public void setHostedReceiptPageSettings(
			HostedReceiptPageSettings hostedReceiptPageSettings) {
		this.hostedReceiptPageSettings = hostedReceiptPageSettings;

		if(hostedReceiptPageSettings != null) {

			// set the link back method
			if(hostedReceiptPageSettings.getLinkMethod() != null) {
				this.requestMap.put(AuthNetField.X_RECEIPT_LINK_METHOD.getFieldName(),
						hostedReceiptPageSettings.getLinkMethod().name());
			}
			this.requestMap.put(AuthNetField.X_RECEIPT_LINK_TEXT.getFieldName(),
					hostedReceiptPageSettings.getLinkText() != null?hostedReceiptPageSettings.getLinkText():EMPTY_STRING);
			this.requestMap.put(AuthNetField.X_RECEIPT_LINK_URL.getFieldName(),
					hostedReceiptPageSettings.getLinkUrl() != null?hostedReceiptPageSettings.getLinkUrl():EMPTY_STRING);
		}
	}

	/**
	 * SIM applications use relay response to redirect the user back to the merchant server.
	 *
	 * @param relayResponseUrl
	 */
	public void setRelayResponseUrl(String relayResponseUrl) {

		if(relayResponseUrl == null || relayResponseUrl.equals(EMPTY_STRING)) {
			this.requestMap.put(AuthNetField.X_RELAY_RESPONSE.getFieldName(), FALSE);
			this.requestMap.remove(AuthNetField.X_RELAY_URL.getFieldName());
		} else {
			this.requestMap.put(AuthNetField.X_RELAY_RESPONSE.getFieldName(), TRUE);
			this.requestMap.put(AuthNetField.X_RELAY_URL.getFieldName(), relayResponseUrl);
		}
	}

	/**
	 * SIM applications use relay response. Set this to false (default) if you are using AIM.
	 *
	 * @return the relayResponseUrl
	 */
	public String getRelayResponseUrl() {
		return this.requestMap.get(AuthNetField.X_RELAY_URL.getFieldName());
	}

	/**
	 * Filters the request mappings based on the formInputMap keys.
	 *
	 * @param requestMappings
	 * @return a HashMap of filtered request map data.
	 */
	private HashMap<String, String> filterRequestMappings(Map<String, String>... requestMappings) {
		HashMap<String, String> filteredRequestMap = new HashMap<String, String>();

		// loop through the rest and put on
		for(Map<String, String> requestMap : requestMappings) {
			for(String key : requestMap.keySet()) {
				if(!filteredRequestMap.containsKey(key) &&
						!this.formInputMap.containsKey(key)) {
					filteredRequestMap.put(key, requestMap.get(key));
				}
			}
		}

		return filteredRequestMap;
	}

	/**
	 * Prepare the form inputs based on the Map(s) provided.
	 *
	 * @param requestMappings
	 *
	 * @return a StringBuilder object
	 */
	private StringBuilder prepareFormInputs(Map<String, String>... requestMappings) {
		StringBuilder inputsBuilder = new StringBuilder();

		// loop on the formInputs
		for(String key : formInputMap.keySet()) {
			String htmlInputData = formInputMap.get(key);
			if(htmlInputData != null) {
				inputsBuilder.append(htmlInputData).append("\n");
			}
		}

		// loop on the request mappings
		HashMap<String, String> requestMapping = filterRequestMappings(requestMappings);
		Set<String> keys = requestMapping.keySet();

		for(String key : keys) {
			try {
				String value = requestMapping.get(key).toString();
				boolean addBreak = false;

				// used for renaming fields on the form
				if("x_rename".equals(key)) {
					Set<String> renameKeys = this.fieldsToRename.keySet();
					for(String renameKey : renameKeys) {
						String renameValue = this.fieldsToRename.get(renameKey).toString();

						inputsBuilder.append("<INPUT TYPE='").append("HIDDEN")
						.append("' NAME='").append(key)
						.append("' VALUE='").append(renameKey).append(",").append(renameValue).append("'>\n");
					}
				} else {
					inputsBuilder.append("<INPUT TYPE='").append("HIDDEN")
					.append("' NAME='").append(key).append("' VALUE='").append(value)
					.append("'>\n").append(addBreak?"<BR/>":EMPTY_STRING);
				}
			} catch (Exception e) {
				logger.warn("NVP encoding failed: " + e.getMessage());
			}
		}

		return inputsBuilder;
	}

	/**
	 * Return an HTML form with all inputs.  All the data collected in the Transaction
	 * will be added as inputs.
	 *
	 * @return A string containing the html FORM
	 */
	@SuppressWarnings("unchecked")
	public String createForm(String formName, String formId, Button button) {
		StringBuilder htmlFormBuffer = new StringBuilder();

		if(formName == null) {
			formName = "order_form";
		}
		if(formId == null) {
			formId = formName;
		}

		htmlFormBuffer.append("<FORM NAME='").append(formName);
		htmlFormBuffer.append("' ID='").append(formId);
		htmlFormBuffer.append("' ACTION='").append(this.environment.getBaseUrl() + "/gateway/transact.dll");
		htmlFormBuffer.append("' METHOD='POST'>\n");
		htmlFormBuffer.append(
				prepareFormInputs(this.requestMap,
						this.merchantDefinedMap));
		switch (button.getButtonType()) {
		case TEXT:
			htmlFormBuffer.append("<INPUT TYPE='SUBMIT'");
			htmlFormBuffer.append(" NAME='").append(((TextButton)button).getName()).append("'");
			htmlFormBuffer.append(" VALUE='").append(((TextButton)button).getValue()).append("'");
			htmlFormBuffer.append(" CLASS='").append(((TextButton)button).getCssClass()).append("'>\n");
			break;
		case IMAGE:
			htmlFormBuffer.append("<INPUT TYPE='IMAGE'");
			htmlFormBuffer.append(" ALT='").append(((ImageButton)button).getAlt()).append("'");
			htmlFormBuffer.append(" WIDTH='").append(((ImageButton)button).getWidth()).append("'");
			htmlFormBuffer.append(" HEIGHT='").append(((ImageButton)button).getHeight()).append("'");
			htmlFormBuffer.append(" SRC='").append(((ImageButton)button).getSrc()).append("' >\n");
			break;
		default:
			break;
		}
		htmlFormBuffer.append("</FORM>\n");

		return htmlFormBuffer.toString();
	}

	/**
	 * Build a relay response url for the relay response redirect.
	 *
	 * @param relayResponseUrl
	 * @param requestParameterMap
	 *
	 * @return a string that is the relay response redirect url
	 */
	public static String createRelayResponseRedirectUrl(String relayResponseUrl,
			Map<String,String[]> requestParameterMap) {

		StringBuilder 	htmlFormBuffer = new StringBuilder();

		if(requestParameterMap != null) {
			htmlFormBuffer.append("?");
		    for(String fieldName : requestParameterMap.keySet()) {
		      String[] value = requestParameterMap.get(fieldName);
		      htmlFormBuffer.append(fieldName).append("=").append(value.length>0?value[0]:EMPTY_STRING);
		      htmlFormBuffer.append("&");
		    }
		    htmlFormBuffer.deleteCharAt(htmlFormBuffer.length()-1);
		}

		return htmlFormBuffer.toString();
	}

}
