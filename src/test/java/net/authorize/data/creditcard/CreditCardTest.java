package net.authorize.data.creditcard;


import junit.framework.Assert;
import net.authorize.UnitTestData;
import net.authorize.data.creditcard.CreditCard;

import org.junit.Before;
import org.junit.Test;

public class CreditCardTest extends UnitTestData {

	private CreditCard creditCard;

	@Before
	public void setUp() throws Exception {
		this.creditCard = CreditCard.createCreditCard();
	}

	@Test
	public void createCreditCard() {
		Assert.assertNotNull(this.creditCard);
	}

	@Test
	public void checkCreditCardFields() {
		this.creditCard.setAvsCode(avsCode);
		this.creditCard.setCardCodeVerification(cardCodeVerification);
		this.creditCard.setCardholderAuthenticationIndicator(cardholderAuthenticationIndicator);
		this.creditCard.setCardholderAuthenticationValue(cardholderAuthenticationValue);
		this.creditCard.setCardType(cardType);
		this.creditCard.setCreditCardNumber(creditCardNumber);
		this.creditCard.setExpirationMonth(creditCardExpMonth);
		this.creditCard.setExpirationYear(creditCardExpYear);

		Assert.assertEquals(avsCode, this.creditCard.getAvsCode());
		Assert.assertEquals(cardCodeVerification, this.creditCard.getCardCodeVerification());
		Assert.assertEquals(cardholderAuthenticationIndicator, this.creditCard.getCardholderAuthenticationIndicator());
		Assert.assertEquals(cardholderAuthenticationValue, this.creditCard.getCardholderAuthenticationValue());
		Assert.assertEquals(cardType, this.creditCard.getCardType());
		Assert.assertEquals(rawCreditCardNumber, this.creditCard.getCreditCardNumber());
		Assert.assertEquals(creditCardExpMonth, this.creditCard.getExpirationMonth());
		Assert.assertEquals(creditCardExpYear, this.creditCard.getExpirationYear());

		this.creditCard.setMaskedCreditCardNumber(maskedCreditCardNumber);
		Assert.assertEquals(maskedCreditCardNumber, this.creditCard.getCreditCardNumber());
	}



}
