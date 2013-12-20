package net.authorize;

import net.authorize.util.StringUtils;


/**
 * Response Reason Code is a numeric representation of a more specific reason for the transaction status.
 *
 */
public enum ResponseReasonCode {

	RRC_1_1(ResponseCode.APPROVED, 1,"This transaction has been approved.", ""),
	RRC_2_2(ResponseCode.DECLINED, 2,"This transaction has been declined.", ""),
	RRC_2_3(ResponseCode.DECLINED, 3,"This transaction has been declined.", ""),
	RRC_2_4(ResponseCode.DECLINED, 4,"This transaction has been declined.", "The code returned from the processor indicating that the card used needs to be picked up."),
	RRC_3_5(ResponseCode.ERROR, 5,"A valid amount is required.", "The value submitted in the amount field did not pass validation for a number."),
	RRC_3_6(ResponseCode.ERROR, 6,"The credit card number is invalid.",""),
	RRC_3_7(ResponseCode.ERROR, 7,"The credit card expiration date is invalid.","The format of the date submitted was incorrect."),
	RRC_3_8(ResponseCode.ERROR, 8,"The credit card has expired.",""),
	RRC_3_9(ResponseCode.ERROR, 9,"The ABA code is invalid.","The value submitted in the x_bank_aba_code field did not pass validation or was not for a valid financial institution."),
	RRC_3_10(ResponseCode.ERROR, 10,"The account number is invalid.","The value submitted in the x_bank_acct_num field did not pass validation."),
	RRC_3_11(ResponseCode.ERROR, 11,"A duplicate transaction has been submitted.","A transaction with identical amount and credit card information was submitted two minutes prior."),
	RRC_3_12(ResponseCode.ERROR, 12 , "An authorization code is required but not present.", "A transaction that required x_auth_code to be present was submitted without a value."),
	RRC_3_13(ResponseCode.ERROR, 13, "The merchant API Login ID is invalid or the account is inactive.", ""),
	RRC_3_14(ResponseCode.ERROR, 14,  "The Referrer or Relay Response URL is invalid.", "The Relay Response or Referrer URL does not match the merchant'ges configured value"),
	RRC_3_15(ResponseCode.ERROR, 15, "The transaction ID is invalid.", "The transaction ID value is non-numeric or was not present for a transaction that requires it."),
	RRC_3_16(ResponseCode.ERROR, 16, "The transaction was not found.", "The transaction ID sent in was properly formatted but the gateway had no record of the transaction."),
	RRC_3_17(ResponseCode.ERROR, 17, "The merchant does not accept this type of credit card.", "The merchant was not configured to accept the credit card submitted in the transaction."),
	RRC_3_18(ResponseCode.ERROR, 18, "ACH transactions are not accepted by this merchant.", "The merchant does not accept electronic checks."),
	RRC_3_19(ResponseCode.ERROR, 19,  "An error occurred during processing. Please try again in 5 minutes.",""),
	RRC_3_20(ResponseCode.ERROR, 20, "An error occurred during processing. Please try again in 5 minutes.",""),
	RRC_3_21(ResponseCode.ERROR, 21, "An error occurred during processing. Please try again in 5 minutes.",""),
	RRC_3_22(ResponseCode.ERROR, 22, "An error occurred during processing. Please try again in 5 minutes.",""),
	RRC_3_23(ResponseCode.ERROR, 23, "An error occurred during processing. Please try again in 5 minutes.",""),
	RRC_3_24(ResponseCode.ERROR, 24, "The Nova Bank Number or Terminal ID is incorrect. Call Merchant Service Provider.",""),
	RRC_3_25(ResponseCode.ERROR, 25, "An error occurred during processing. Please try again in 5 minutes.",""),
	RRC_3_26(ResponseCode.ERROR, 26, "An error occurred during processing. Please try again in 5 minutes.",""),
	RRC_2_27(ResponseCode.DECLINED, 27, "The transaction resulted in an AVS mismatch. The address provided does not match billing address of cardholder.",""),
	RRC_2_28(ResponseCode.DECLINED, 28, "The merchant does not accept this type of credit card.", "The Merchant ID at the processor was not configured to accept this card type."),
	RRC_2_29(ResponseCode.DECLINED, 29, "The Paymentech identification numbers are incorrect. Call Merchant Service Provider.",""),
	RRC_2_30(ResponseCode.DECLINED, 30, "The configuration with the processor is invalid. Call Merchant Service Provider.",""),
	RRC_2_31(ResponseCode.DECLINED, 31, "The FDC Merchant ID or Terminal ID is incorrect. Call Merchant Service Provider.", "The merchant was incorrectly set up at the processor."),
	RRC_3_32(ResponseCode.ERROR, 32, "This reason code is reserved or not applicable to this API.",""),
	RRC_3_33(ResponseCode.ERROR, 33, "FIELD cannot be left blank.", "The word FIELD will be replaced by an actual field name. This error indicates that a field the merchant specified as required was not filled in. Please see the Form Fields section of the Merchant Integration Guide for details."),
	RRC_2_34(ResponseCode.DECLINED, 34, "The VITAL identification numbers are incorrect. Call Merchant Service Provider.", "The merchant was incorrectly set up at the processor."),
	RRC_2_35(ResponseCode.DECLINED, 35, "An error occurred during processing. Call Merchant Service Provider.", "The merchant was incorrectly set up at the processor."),
	RRC_3_36(ResponseCode.ERROR, 36, "The authorization was approved, but settlement failed.",""),
	RRC_2_37(ResponseCode.DECLINED, 37, "The credit card number is invalid.",""),
	RRC_2_38(ResponseCode.DECLINED, 38, "The Global Payment System identification numbers are incorrect. Call Merchant Service Provider.", "The merchant was incorrectly set up at the processor."),
	RRC_3_40(ResponseCode.ERROR, 40, "This transaction must be encrypted.",""),
	RRC_2_41(ResponseCode.DECLINED, 41, "This transaction has been declined.", "Only merchants set up for the FraudScreen.Net service would receive this decline. This code will be returned if a given transaction'ges fraud score is higher than the threshold set by the merchant."),
	RRC_3_43(ResponseCode.ERROR, 43, "The merchant was incorrectly set up at the processor. Call your Merchant Service Provider.", "The merchant was incorrectly set up at the processor."),
	RRC_2_44(ResponseCode.DECLINED, 44, "This transaction has been declined.", "The card code submitted with the transaction did not match the card code on file at the card issuing bank and the transaction was declined."),
	RRC_2_45(ResponseCode.DECLINED, 45, "This transaction has been declined.", "This error would be returned if the transaction received a code from the processor that matched the rejection criteria set by the merchant for both the AVS and Card Code filters."),
	RRC_3_46(ResponseCode.ERROR, 46, "Your session has expired or does not exist. You must log in to continue working.", ""),
	RRC_3_47(ResponseCode.ERROR, 47, "The amount requested for settlement may not be greater than the original amount authorized.", "This occurs if the merchant tries to capture funds greater than the amount of the original authorization-only transaction."),
	RRC_3_48(ResponseCode.ERROR, 48, "This processor does not accept partial reversals.", "The merchant attempted to settle for less than the originally authorized amount."),
	RRC_3_49(ResponseCode.ERROR, 49, "A transaction amount greater than [amount] will not be accepted.", "The transaction amount submitted was greater than the maximum amount allowed."),
	RRC_3_50(ResponseCode.ERROR, 50, "This transaction is awaiting settlement and cannot be refunded.", "Credits or refunds can only be performed against settled transactions. The transaction against which the credit/refund was submitted has not been settled, so a credit cannot be issued."),
	RRC_3_51(ResponseCode.ERROR, 51, "The sum of all credits against this transaction is greater than the original transaction amount.",""),
	RRC_3_52(ResponseCode.ERROR, 52, "The transaction was authorized, but the client could not be notified; the transaction will not be settled.",""),
	RRC_3_53(ResponseCode.ERROR, 53, "The transaction type was invalid for ACH transactions.", "If x_method ECHECK, x_type cannot be set to CAPTURE_ONLY."),
	RRC_3_54(ResponseCode.ERROR, 54, "The referenced transaction does not meet the criteria for issuing a credit.",""),
	RRC_3_55(ResponseCode.ERROR, 55, "The sum of credits against the referenced transaction would exceed the original debit amount.", "The transaction is rejected if the sum of this credit and prior credits exceeds the original debit amount"),
	RRC_3_56(ResponseCode.ERROR, 56, "This merchant accepts ACH transactions only; no credit card transactions are accepted.", "The merchant processes eCheck.Net transactions only and does not accept credit cards."),
	RRC_3_57(ResponseCode.ERROR, 57, "An error occurred in processing. Please try again in 5 minutes.",""),
	RRC_3_58(ResponseCode.ERROR, 58, "An error occurred in processing. Please try again in 5 minutes.",""),
	RRC_3_59(ResponseCode.ERROR, 59, "An error occurred in processing. Please try again in 5 minutes.",""),
	RRC_3_60(ResponseCode.ERROR, 60, "An error occurred in processing. Please try again in 5 minutes.",""),
	RRC_3_61(ResponseCode.ERROR, 61, "An error occurred in processing. Please try again in 5 minutes.",""),
	RRC_3_62(ResponseCode.ERROR, 62, "An error occurred in processing. Please try again in 5 minutes.",""),
	RRC_3_63(ResponseCode.ERROR, 63, "An error occurred in processing. Please try again in 5 minutes.",""),
	RRC_2_65(ResponseCode.DECLINED, 65, "This transaction has been declined.", "The transaction was declined because the merchant configured their account through the Merchant Interface to reject transactions with certain values for a Card Code mismatch."),
	RRC_3_66(ResponseCode.ERROR, 66, "This transaction cannot be accepted for processing.", "The transaction did not meet gateway security guidelines."),
	RRC_3_68(ResponseCode.ERROR, 68, "The version parameter is invalid.", "The value submitted in x_version was invalid."),
	RRC_3_69(ResponseCode.ERROR, 69, "The transaction type is invalid.", "The value submitted in x_type was invalid."),
	RRC_3_70(ResponseCode.ERROR, 70, "The transaction method is invalid.", "The value submitted in x_method was invalid."),
	RRC_3_71(ResponseCode.ERROR, 71, "The bank account type is invalid.", "The value submitted in x_bank_acct_type was invalid."),
	RRC_3_72(ResponseCode.ERROR, 72, "The authorization code is invalid.", "The value submitted in x_auth_code was more than six characters in length."),
	RRC_3_73(ResponseCode.ERROR, 73, "The driver'ges license date of birth is invalid.", "The format of the value submitted in x_drivers_license_dob was invalid."),
	RRC_3_74(ResponseCode.ERROR, 74, "The duty amount is invalid.", "The value submitted in x_duty failed format validation."),
	RRC_3_75(ResponseCode.ERROR, 75, "The freight amount is invalid.", "The value submitted in x_freight failed format validation."),
	RRC_3_76(ResponseCode.ERROR, 76, "The tax amount is invalid.", "The value submitted in x_tax failed format validation."),
	RRC_3_77(ResponseCode.ERROR, 77, "The SSN or tax ID is invalid.", "The value submitted in x_customer_tax_id failed validation."),
	RRC_3_78(ResponseCode.ERROR, 78, "The Card CodeCVV2/CVC2/CID) is invalid.", "The value submitted in x_card_code failed format validation."),
	RRC_3_79(ResponseCode.ERROR, 79, "The driver'ges license number is invalid.", "The value submitted in x_drivers_license_num failed format validation."),
	RRC_3_80(ResponseCode.ERROR, 80, "The driver'ges license state is invalid.", "The value submitted in x_drivers_license_state failed format validation."),
	RRC_3_81(ResponseCode.ERROR, 81, "The requested form type is invalid.", "The merchant requested an integration method not compatible with the AIM API."),
	RRC_3_82(ResponseCode.ERROR, 82, "Scripts are only supported in version 2.5.", "The system no longer supports version 2.5; requests cannot be posted to scripts."),
	RRC_3_83(ResponseCode.ERROR, 83, "The requested script is either invalid or no longer supported.", "The system no longer supports version 2.5; requests cannot be posted to scripts."),
	RRC_3_84(ResponseCode.ERROR, 84, "This reason code is reserved or not applicable to this API.",""),
	RRC_3_85(ResponseCode.ERROR, 85, "This reason code is reserved or not applicable to this API.",""),
	RRC_3_86(ResponseCode.ERROR, 86, "This reason code is reserved or not applicable to this API.",""),
	RRC_3_87(ResponseCode.ERROR, 87, "This reason code is reserved or not applicable to this API.",""),
	RRC_3_88(ResponseCode.ERROR, 88, "This reason code is reserved or not applicable to this API.",""),
	RRC_3_89(ResponseCode.ERROR, 89, "This reason code is reserved or not applicable to this API.",""),
	RRC_3_90(ResponseCode.ERROR, 90, "This reason code is reserved or not applicable to this API.",""),
	RRC_3_91(ResponseCode.ERROR, 91, "Version 2.5 is no longer supported.",""),
	RRC_3_92(ResponseCode.ERROR, 92, "The gateway no longer supports the requested method of integration.",""),
	RRC_3_97(ResponseCode.ERROR, 97, "This transaction cannot be accepted.", "Applicable only to SIM API. Fingerprints are only valid for a short period of time. If the fingerprint is more than one hour old or more than 15 minutes into the future, it will be rejected. This code indicates that the transaction fingerprint has expired."),
	RRC_3_98(ResponseCode.ERROR, 98, "This transaction cannot be accepted.", "Applicable only to SIM API. The transaction fingerprint has already been used."),
	RRC_3_99(ResponseCode.ERROR, 99, "This transaction cannot be accepted.", "Applicable only to SIM API. The server-generated fingerprint does not match the merchant-specified fingerprint in the x_fp_hash field."),
	RRC_3_100(ResponseCode.ERROR, 100, "The eCheck.Net type is invalid.", "Applicable only to eCheck.Net. The value specified in the x_echeck_type field is invalid."),
	RRC_3_101(ResponseCode.ERROR, 101, "The given name on the account and/or the account type does not match the actual account.", "Applicable only to eCheck.Net. The specified name on the account and/or the account type do not match the NOC record for this account."),
	RRC_3_102(ResponseCode.ERROR, 102, "This request cannot be accepted.", "A password or Transaction Key was submitted with this WebLink request. This is a high security risk."),
	RRC_3_103(ResponseCode.ERROR, 103, "This transaction cannot be accepted.", "A valid fingerprint, Transaction Key, or password is required for this transaction."),
	RRC_3_104(ResponseCode.ERROR, 104, "This transaction is currently under review.", "Applicable only to eCheck.Net. The value submitted for country failed validation."),
	RRC_3_105(ResponseCode.ERROR, 105, "This transaction is currently under review.", "Applicable only to eCheck.Net. The values submitted for city and country failed validation."),
	RRC_3_106(ResponseCode.ERROR, 106, "This transaction is currently under review.", "Applicable only to eCheck.Net. The value submitted for company failed	validation."),
	RRC_3_107(ResponseCode.ERROR, 107, "This transaction is currently under review.", "Applicable only to eCheck.Net. The value submitted for bank account name failed validation."),
	RRC_3_108(ResponseCode.ERROR, 108, "This transaction is currently under review.", "Applicable only to eCheck.Net. The values submitted for first name and last name failed validation."),
	RRC_3_109(ResponseCode.ERROR, 109, "This transaction is currently under review.", "Applicable only to eCheck.Net. The values submitted for first name and last name failed validation."),
	RRC_3_110(ResponseCode.ERROR, 110, "This transaction is currently under review.", "Applicable only to eCheck.Net. The value submitted for bank account name does not contain valid characters."),
	RRC_3_116(ResponseCode.ERROR, 116, "The authentication indicator is invalid.", "This error is only applicable to Verified by Visa and MasterCard SecureCode transactions. The ECI value for a Visa transaction; or the UCAF indicator for a MasterCard transaction submitted in the x_authentication_indicator field is invalid."),
	RRC_3_117(ResponseCode.ERROR, 117, "The cardholder authentication value is invalid.", "This error is only applicable to Verified by Visa and MasterCard SecureCode transactions. The CAVV for a Visa transaction; or the AVV/UCAF for a MasterCard transaction is invalid."),
	RRC_3_118(ResponseCode.ERROR, 118, "The combination of authentication indicator and cardholder authentication value is invalid.", "This error is only applicable to Verified by Visa and MasterCard SecureCode transactions. The combination of authentication indicator and cardholder authentication value for a Visa or MasterCard transaction is invalid. For more information, see the Cardholder Authentication section of this document."),
	RRC_3_119(ResponseCode.ERROR, 119, "Transactions having cardholder authentication values cannot be marked as recurring.", "This error is only applicable to Verified by Visa and MasterCard SecureCode transactions. Transactions submitted with a value in x_authentication_indicator and x_recurring_billing=YES will be rejected."),
	RRC_3_120(ResponseCode.ERROR, 120, "An error occurred during processing. Please try again.", "The system-generated void for the original timed-out transaction failed.The original transaction timed out while waiting for a response from the authorizer.)"),
	RRC_3_121(ResponseCode.ERROR, 121, "An error occurred during processing. Please try again.", "The system-generated void for the original errored transaction failed.The original transaction experienced a database error."),
	RRC_3_122(ResponseCode.ERROR, 122, "An error occurred during processing. Please try again.", "The system-generated void for the original errored transaction failed.The original transaction experienced a processing error."),
	RRC_3_123(ResponseCode.ERROR, 123, "This account has not been given the permission",""),
	RRC_2_127(ResponseCode.DECLINED, 127, "The transaction resulted in an AVS mismatch. The address provided does not match billing address of cardholder.", "The system-generated void for the original AVS-rejected transaction failed."),
	RRC_3_128(ResponseCode.ERROR, 128, "This transaction cannot be processed.", "The customer'ges financial institution does not currently allow transactions for this account."),
	RRC_3_130(ResponseCode.ERROR, 130, "This payment gateway account has been closed.", "IFT: The payment gateway account status is Blacklisted."),
	RRC_3_131(ResponseCode.ERROR, 131, "This transaction cannot be accepted at this time.", "IFT: The payment gateway account status is Suspended-STA."),
	RRC_3_132(ResponseCode.ERROR, 132, "This transaction cannot be accepted at this time.", "IFT: The payment gateway account status is Suspended-Blacklist."),
	RRC_2_141(ResponseCode.DECLINED, 141, "This transaction has been declined.", "The system-generated void for the original FraudScreen-rejected transaction failed."),
	RRC_2_145(ResponseCode.DECLINED, 145, "This transaction has been declined.", "The system-generated void for the original card code-rejected and AVS-rejected transaction failed."),
	RRC_3_152(ResponseCode.ERROR, 152, "The transaction was authorized, but the client could not be notified; the transaction will not be settled.", "The system-generated void for the original transaction failed. The response for the original transaction could not be communicated to the client."),
	RRC_2_165(ResponseCode.DECLINED, 165, "This transaction has been declined.", "The system-generated void for the original card code-rejected transaction failed."),
	RRC_3_170(ResponseCode.ERROR, 170, "An error occurred during processing. Please contact the merchant.", "Concord EFS Provisioning at the processor has not been completed."),
	RRC_2_171(ResponseCode.DECLINED, 171, "An error occurred during processing. Please contact the merchant.", "Concord EFS This request is invalid."),
	RRC_2_172(ResponseCode.DECLINED, 172, "An error occurred during processing. Please contact the merchant.", "Concord EFS The store ID is invalid."),
	RRC_3_173(ResponseCode.ERROR, 173, "An error occurred during processing. Please contact the merchant.", "Concord EFS The store key is invalid."),
	RRC_2_174(ResponseCode.DECLINED, 174, "The transaction type is invalid. Please contact the merchant.", "Concord EFS This transaction type is not accepted by the processor."),
	RRC_3_175(ResponseCode.ERROR, 175, "The processor does not allow voiding of credits.", "Concord EFS This transaction is not allowed. The Concord EFS processing platform does not support voiding credit transactions. Please debit the credit card instead of voiding the credit."),
	RRC_3_180(ResponseCode.ERROR, 180, "An error occurred during processing. Please try again.", "The processor response format is invalid."),
	RRC_3_181(ResponseCode.ERROR, 181, "An error occurred during processing. Please try again.", "The system-generated void for the original invalid transaction failed.The original transaction included an invalid processor response format.)"),
	RRC_3_185(ResponseCode.ERROR, 185, "This reason code is reserved or not applicable to this API.", ""),
	RRC_4_193(ResponseCode.REVIEW, 193, "The transaction is currently under review.", "The transaction was placed under review by the risk management system."),
	RRC_2_200(ResponseCode.DECLINED, 200, "This transaction has been declined.", "This error code applies only to merchants on FDC Omaha. The credit card number is invalid."),
	RRC_2_201(ResponseCode.DECLINED, 201, "This transaction has been declined.", "This error code applies only to merchants on FDC Omaha. The expiration date is invalid."),
	RRC_2_202(ResponseCode.DECLINED, 202, "This transaction has been declined.", "This error code applies only to merchants on FDC Omaha. The transaction type is invalid."),
	RRC_2_203(ResponseCode.DECLINED, 203, "This transaction has been declined.", "This error code applies only to merchants on FDC Omaha. The value submitted in the amount field is invalid."),
	RRC_2_204(ResponseCode.DECLINED, 204, "This transaction has been declined.", "This error code applies only to merchants on FDC Omaha. The department code is invalid."),
	RRC_2_205(ResponseCode.DECLINED, 205, "This transaction has been declined.", "This error code applies only to merchants on FDC Omaha. The value submitted in the merchant number field is invalid."),
	RRC_2_206(ResponseCode.DECLINED, 206, "This transaction has been declined.", "This error code applies only to merchants on FDC Omaha. The merchant is not on file."),
	RRC_2_207(ResponseCode.DECLINED, 207, "This transaction has been declined.", "This error code applies only to merchants on FDC Omaha. The merchant account is closed."),
	RRC_2_208(ResponseCode.DECLINED, 208, "This transaction has been declined.", "This error code applies only to merchants on FDC Omaha. The merchant is not on file."),
	RRC_2_209(ResponseCode.DECLINED, 209, "This transaction has been declined.", "This error code applies only to merchants on FDC Omaha. Communication with the processor could not be established."),
	RRC_2_210(ResponseCode.DECLINED, 210, "This transaction has been declined.", "This error code applies only to merchants on FDC Omaha. The merchant type is incorrect."),
	RRC_2_211(ResponseCode.DECLINED, 211, "This transaction has been declined.", "This error code applies only to merchants on FDC Omaha. The cardholder is not on file."),
	RRC_2_212(ResponseCode.DECLINED, 212, "This transaction has been declined.", "This error code applies only to merchants on FDC Omaha. The bank configuration is not on file"),
	RRC_2_213(ResponseCode.DECLINED, 213, "This transaction has been declined.", "This error code applies only to merchants on FDC Omaha. The merchant assessment code is incorrect."),
	RRC_2_214(ResponseCode.DECLINED, 214, "This transaction has been declined.", "This error code applies only to merchants on FDC Omaha. This function is currently unavailable."),
	RRC_2_215(ResponseCode.DECLINED, 215, "This transaction has been declined.", "This error code applies only to merchants on FDC Omaha. The encrypted PIN field format is invalid."),
	RRC_2_216(ResponseCode.DECLINED, 216, "This transaction has been declined.", "This error code applies only to merchants on FDC Omaha. The ATM term ID is invalid."),
	RRC_2_217(ResponseCode.DECLINED, 217, "This transaction has been declined.", "This error code applies only to merchants on FDC Omaha. This transaction experienced a general message format problem."),
	RRC_2_218(ResponseCode.DECLINED, 218, "This transaction has been declined.", "This error code applies only to merchants on FDC Omaha. The PIN block format or PIN availability value is invalid."),
	RRC_2_219(ResponseCode.DECLINED, 219, "This transaction has been declined.", "This error code applies only to merchants on FDC Omaha. The ETC void is unmatched."),
	RRC_2_220(ResponseCode.DECLINED, 220, "This transaction has been declined.", "This error code applies only to merchants on FDC Omaha. The primary CPU is not available."),
	RRC_2_221(ResponseCode.DECLINED, 221, "This transaction has been declined.", "This error code applies only to merchants on FDC Omaha. The SE number is invalid."),
	RRC_2_222(ResponseCode.DECLINED, 222, "This transaction has been declined.", "This error code applies only to merchants on FDC Omaha. Duplicate auth requestfrom INAS)."),
	RRC_2_223(ResponseCode.DECLINED, 223, "This transaction has been declined.", "This error code applies only to merchants on FDC Omaha. This transaction experienced an unspecified error."),
	RRC_2_224(ResponseCode.DECLINED, 224, "This transaction has been declined.", "This error code applies only to merchants on FDC Omaha. Please re-enter the transaction."),
	RRC_3_243(ResponseCode.ERROR, 243, "Recurring billing is not allowed for this eCheck.Net type.", "The combination of values submitted for x_recurring_billing and x_echeck_type is not allowed."),
	RRC_3_244(ResponseCode.ERROR, 244, "This eCheck.Net type is not allowed for this Bank Account Type.", "The combination of values submitted for x_bank_acct_type and x_echeck_type is not allowed."),
	RRC_3_245(ResponseCode.ERROR, 245, "This eCheck.Net type is not allowed when using the payment gateway hosted payment form.", "The value submitted for x_echeck_type is not allowed when using the payment gateway hosted payment form."),
	RRC_3_246(ResponseCode.ERROR, 246, "This eCheck.Net type is not allowed.", "The merchant'ges payment gateway account is not enabled to submit the eCheck.Net type."),
	RRC_3_247(ResponseCode.ERROR, 247, "This eCheck.Net type is not allowed.", "The combination of values submitted for x_type and x_echeck_type is not allowed."),
	RRC_3_248(ResponseCode.ERROR, 248, "The check number is invalid.", "Invalid check number. Check number can only consist of letters and numbers and not more than 15 characters."),
	RRC_2_250(ResponseCode.DECLINED, 250, "This transaction has been declined.", "This transaction was submitted from a blocked IP address."),
	RRC_2_251(ResponseCode.DECLINED, 251, "This transaction has been declined.", "The transaction was declined as a result of triggering a Fraud Detection Suite filter."),
	RRC_4_252(ResponseCode.REVIEW, 252, "Your order has been received. Thank you for your business!", "The transaction was accepted, but is being held for merchant review. The merchant can customize the customer response in the Merchant Interface."),
	RRC_4_253(ResponseCode.REVIEW, 253, "Your order has been received. Thank you for your business!", "The transaction was accepted and was authorized, but is being held for merchant review. The merchant can customize the customer response in the Merchant Interface."),
	RRC_2_254(ResponseCode.DECLINED, 254, "Your transaction has been declined.", "The transaction was declined after manual review."),
	RRC_3_261(ResponseCode.ERROR, 261, "An error occurred during processing. Please try again.", "The transaction experienced an error during sensitive data encryption and was not processed. Please try again."),
	RRC_3_270(ResponseCode.ERROR, 270, "The line itemitem number] is invalid.", "A value submitted in x_line_item for the item referenced is invalid."),
	RRC_3_271(ResponseCode.ERROR, 271, "The number of line items submitted is not allowed. A maximum of 30 line items can be submitted.", "The number of line items submitted exceeds the allowed maximum of 30."),
	RRC_3_288(ResponseCode.ERROR, 288, "Merchant is not registered as a Cardholder Authentication participant. This transaction cannot be accepted.", "The merchant has not indicated participation in any Cardholder Authentication Programs in the Merchant Interface."),
	RRC_3_289(ResponseCode.ERROR, 289, "This processor does not accept zero dollar authorization for this card type.", "Your credit card processing service does not yet accept zero dollar authorizations for Visa credit cards. You can find your credit card processor listed on your merchant profile."),
	RRC_3_290(ResponseCode.ERROR, 290, "One or more required AVS values for zero dollar authorization were not submitted.", "When submitting authorization requests for Visa, the address and zip code fields must be entered."),
	RRC_4_295(ResponseCode.REVIEW, 295, "The amount of this request was only partially approved on the given prepaid card. Additional payments are required to complete the balance of this transaction.", " The merchant must have partial authorization enabled in the merchant interface in order to receive this error."),
	RRC_3_296(ResponseCode.ERROR, 296, "The specified SplitTenderId is not valid.", ""),
	RRC_3_297(ResponseCode.ERROR, 297, "A Transaction ID and a Split Tender ID cannot both be used in a single transaction request.", ""),
	RRC_3_300(ResponseCode.ERROR, 300, "The device ID is invalid.", "The value submitted for x_device_id is invalid."),
	RRC_3_301(ResponseCode.ERROR, 301, "The device batch ID is invalid.", "The value submitted for x_device_batch_id is invalid."),
	RRC_3_302(ResponseCode.ERROR, 302, "The reversal flag is invalid.", "The value submitted for x_reversal is invalid."),
	RRC_3_303(ResponseCode.ERROR, 303, "The device batch is full. Please close the batch.", "The current device batch must be closed manually from the POS device."),
	RRC_3_304(ResponseCode.ERROR, 304, "The original transaction is in a closed batch.", "The original transaction has been settled and cannot be reversed."),
	RRC_3_305(ResponseCode.ERROR, 305, "The merchant is configured for auto-close.", "This merchant is configured for auto-close and cannot manually close batches."),
	RRC_3_306(ResponseCode.ERROR, 306, "The batch is already closed.", "The batch is already closed."),
	RRC_1_307(ResponseCode.APPROVED, 307, "The reversal was processed successfully.", "The reversal was processed successfully."),
	RRC_1_308(ResponseCode.APPROVED, 308, "Original transaction for reversal not found.", "The transaction submitted for reversal was not found."),
	RRC_3_309(ResponseCode.ERROR, 309, "The device has been disabled.", "The device has been disabled."),
	RRC_1_310(ResponseCode.APPROVED, 310, "This transaction has already been voided.", "This transaction has already been voided."),
	RRC_1_311(ResponseCode.APPROVED, 311, "This transaction has already been captured", "This transaction has already been captured."),
	RRC_2_315(ResponseCode.DECLINED, 315, "The credit card number is invalid.", "This is a processor-issued decline."),
	RRC_2_316(ResponseCode.DECLINED, 316, "The credit card expiration date is invalid.", "This is a processor-issued decline."),
	RRC_2_317(ResponseCode.DECLINED, 317, "The credit card has expired.", "This is a processor-issued decline."),
	RRC_2_318(ResponseCode.DECLINED, 318, "A duplicate transaction has been submitted.", "This is a processor-issued decline."),
	RRC_2_319(ResponseCode.DECLINED, 319, "The transaction cannot be found.", "This is a processor-issued decline."),
	RRC_0_0(ResponseCode.UNKNOWN, 0, "Unknown.","");


	final private ResponseCode responseCode;
	final private int responseReasonCode;
	private String reasonText;
	final private String notes;

	private ResponseReasonCode(ResponseCode responseCode, int responseReasonCode, String reasonText, String notes) {
		this.responseCode = responseCode;
		this.responseReasonCode = responseReasonCode;
		this.reasonText = reasonText;
		this.notes = notes;
	}

	/**
	 * Lookup a response reason code by the reason response code itself.
	 *
	 * @param reasonCode
	 * @return Returns a ResponseReasonCode if a reasonCode match is found.
	 */
	public static ResponseReasonCode findByReasonCode(int reasonCode) {
		for(ResponseReasonCode responseReasonCode : values()) {
			if(responseReasonCode.responseReasonCode == reasonCode) {
				return responseReasonCode;
			}
		}

		return ResponseReasonCode.RRC_0_0;
	}

	/**
	 * Lookup a response reason code by the reason response code itself.
	 *
	 * @param reasonCode
	 * @return Returns a ResponseReasonCode if a reasonCode match is found.
	 */
	public static ResponseReasonCode findByReasonCode(String reasonCode) {
		if(StringUtils.isNotEmpty(reasonCode)) {
			return findByReasonCode(Integer.parseInt(reasonCode));
		}

		return ResponseReasonCode.RRC_0_0;
	}

	/**
	 * @return the responseCode
	 */
	public ResponseCode getResponseCode() {
		return responseCode;
	}

	/**
	 * @return the responseReasonCode
	 */
	public int getResponseReasonCode() {
		return responseReasonCode;
	}

	/**
	 * @return the reasonText
	 */
	public String getReasonText() {
		return reasonText;
	}

	/**
	 * Set the reasonText.
	 *
	 * @param reasonText
	 */
	public void setReasonText(String reasonText) {
		if(StringUtils.isNotEmpty(reasonText)) {
			this.reasonText = reasonText;
		}
	}

	/**
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}

}
