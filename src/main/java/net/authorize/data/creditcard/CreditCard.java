package net.authorize.data.creditcard;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import net.authorize.util.Luhn;

/**
 * Credit card specific information.
 *
 */
public class CreditCard implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public static String ARB_EXPIRY_DATE_FORMAT = "yyyy-MM";
	private static String EXPIRY_DATE_FORMAT = "MM/yyyy";

	private String creditCardNumber;
	private String expirationMonth;
	private String expirationYear;
	private Date expirationDate;
	private CardType cardType;
	private String cardCode;

	private String cardholderAuthenticationIndicator;
	private String cardholderAuthenticationValue;

	private AVSCode avsCode;
	private String track1;
	private String track2;
	private boolean cardPresent;

	protected CreditCard() {

	}

	public static CreditCard createCreditCard() {
		return new CreditCard();
	}

	/**
	 * @return the creditCardNumber
	 */
	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	/**
	 * @param creditCardNumber
	 *            the creditCardNumber to set
	 */
	public void setCreditCardNumber(String creditCardNumber) {
		this.cardType = Luhn.getCardType(creditCardNumber);

		this.creditCardNumber = Luhn.stripNonDigits(creditCardNumber);
	}

	/**
	 * Used in the response that comes back to offer access to the partial credit card number.
	 *
	 * @param maskedCreditCardNumber
	 */
	public void setMaskedCreditCardNumber(String maskedCreditCardNumber) {
		this.creditCardNumber = maskedCreditCardNumber;
	}

	/**
	 * @return the expirationMonth
	 */
	public String getExpirationMonth() {
		return expirationMonth;
	}

	/**
	 * @param expirationMonth
	 *            the expirationMonth to set
	 */
	public void setExpirationMonth(String expirationMonth) {
		this.expirationMonth = expirationMonth;
		setExpirationDate();
	}

	/**
	 * @return the expirationYear
	 */
	public String getExpirationYear() {
		return expirationYear;
	}

	/**
	 * @param expirationYear
	 *            the expirationYear to set
	 */
	public void setExpirationYear(String expirationYear) {
		this.expirationYear = expirationYear;
		setExpirationDate();
	}

	/**
	 * Return the expiration date.
	 *
	 * @return expirationDate
	 */
	public Date getExpirationDate() {
		return expirationDate;
	}

	/**
	 * Set the expiration date.
	 *
	 * @param expirationDate
	 */
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
		extractMonthYearFromExpiration();
	}

	/**
	 * Set the expiration date using yyyy-MM as the format.
	 *
	 * @param expiration_date
	 */
	public void setExpirationDate(String expiration_date) {
		this.expirationDate = net.authorize.util.DateUtil.getDateFromFormattedDate(expiration_date, ARB_EXPIRY_DATE_FORMAT);
		extractMonthYearFromExpiration();
	}

	/**
	 * Sets the expiration date using the MM/YYYY format.
	 */
	private void setExpirationDate() {
		if(this.expirationMonth != null && this.expirationYear != null) {
			this.expirationDate = net.authorize.util.DateUtil.getDateFromFormattedDate(
					this.expirationMonth+"/"+this.expirationYear, EXPIRY_DATE_FORMAT);
		}
	}

	/**
	 * Extract the month and year from the expiration date.
	 */
	private void extractMonthYearFromExpiration() {
		if(this.expirationDate != null) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(this.expirationDate);
			this.expirationMonth = Integer.toString(cal.get(Calendar.MONTH)+1);
			this.expirationYear = Integer.toString(cal.get(Calendar.YEAR));
		}
	}

	/**
	 * @return the cardType
	 */
	public CardType getCardType() {
		return cardType;
	}

	/**
	 * @param cardType
	 *            the cardType to set
	 */
	public void setCardType(CardType cardType) {
		this.cardType = cardType;
	}

	/**
	 * @return the cardCodeVerification
	 * @deprecated As of release 1.4.2, replaced by {@link #getCardCode()}
	 */
	@Deprecated
	public String getCardCodeVerification() {
		return cardCode;
	}

	/**
	 * @param cardCodeVerification the cardCodeVerification to set
	 * @deprecated As of release 1.4.2, replaced by {@link #setCardCode(String)}
	 */
	@Deprecated
	public void setCardCodeVerification(String cardCodeVerification) {
		this.cardCode = cardCodeVerification;
	}

	/**
	 *
	 * @return the card code
	 */
	public String getCardCode() {
		return cardCode;
	}

	/**
	 * @param cardCode the card code to set
	 */
	public void setCardCode(String cardCode) {
		this.cardCode = cardCode;
	}

	/**
	 * @return the cardholderAuthenticationIndicator
	 */
	public String getCardholderAuthenticationIndicator() {
		return cardholderAuthenticationIndicator;
	}

	/**
	 * @param cardholderAuthenticationIndicator the cardholderAuthenticationIndicator to set
	 */
	public void setCardholderAuthenticationIndicator(
			String cardholderAuthenticationIndicator) {
		this.cardholderAuthenticationIndicator = cardholderAuthenticationIndicator;
	}

	/**
	 * @return the cardholderAuthenticationValue
	 */
	public String getCardholderAuthenticationValue() {
		return cardholderAuthenticationValue;
	}

	/**
	 * @param cardholderAuthenticationValue
	 *            the cardholderAuthenticationValue to set
	 */
	public void setCardholderAuthenticationValue(
			String cardholderAuthenticationValue) {
		this.cardholderAuthenticationValue = cardholderAuthenticationValue;
	}

	/**
	 * @return the avsCode
	 */
	public AVSCode getAvsCode() {
		return avsCode;
	}

	/**
	 * @param avsCode the avsCode to set
	 */
	public void setAvsCode(AVSCode avsCode) {
		this.avsCode = avsCode;
	}

	/**
	 * @return the track1
	 */
	public String getTrack1() {
		return track1;
	}

	/**
	 * @param track1 the track1 to set
	 */
	public void setTrack1(String track1) {
		this.track1 = track1;
		if(this.track1 != null) {
			this.track1 = this.track1.replaceAll("(^[%]|[?]$)","");
		}
	}

	/**
	 * @return the track2
	 */
	public String getTrack2() {
		return track2;
	}

	/**
	 * @param track2 the track2 to set
	 */
	public void setTrack2(String track2) {
		this.track2 = track2;
		if(this.track2 != null) {
			this.track2 = this.track2.replaceAll("(^[;]|[?]$)","");
		}
	}

	/**
	 * @return the cardPresent
	 */
	public boolean isCardPresent() {
		return cardPresent;
	}

	/**
	 * @param cardPresent the cardPresent to set
	 */
	public void setCardPresent(boolean cardPresent) {
		this.cardPresent = cardPresent;
	}

}
