package net.authorize.data.xml;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
* 
* @deprecated since version 1.9.8
* @deprecated We have reorganized and simplified the Authorize.Net API to ease integration and to focus on merchants' needs.
* @deprecated We have deprecated AIM, ARB, CIM, and Reporting as separate options, in favor of AuthorizeNet::API (package: net.authorize.api.*).
* @deprecated We have also deprecated SIM as a separate option, in favor of Accept Hosted. See https://developer.authorize.net/api/reference/features/accept_hosted.html for details on Accept Hosted.
* @deprecated For details on AIM, see https://github.com/AuthorizeNet/sample-code-java/tree/master/src/main/java/net/authorize/sample/PaymentTransactions.
* @deprecated For details on the deprecation and replacement of legacy Authorize.Net methods, visit https://developer.authorize.net/api/upgrade_guide/.
*
*/
@Deprecated
@XmlRootElement
public class DriversLicense  implements Serializable {

	private static final long serialVersionUID = 1L;

    private String number;
    private String state;
    private Date birth_date;
    public static String LICENSE_DATE_FORMAT = "yyyy-MM-dd";

    public DriversLicense(){
	}


	public Date getBirthDate() {
		return birth_date;
	}

	public void setBirthDate(String date){
		this.birth_date = net.authorize.util.DateUtil.getDateFromFormattedDate(date, LICENSE_DATE_FORMAT);
	}
	public void setBirthDate(Date birth_date) {
		this.birth_date = birth_date;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
