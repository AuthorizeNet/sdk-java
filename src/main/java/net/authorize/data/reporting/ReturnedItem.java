package net.authorize.data.reporting;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import net.authorize.data.xml.reporting.ReportingDetails;
import net.authorize.util.LogHelper;
import net.authorize.util.StringUtils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
* ReturnedItem container.
*/
@XmlRootElement
public class ReturnedItem implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id = null;
	private Date dateUTC = null;
	private Date dateLocal = null;
	private String code = null;
	private String description = null;
	
	private static Log logger = LogFactory.getLog(ReturnedItem.class);

	/**
    * Default C'tor
    */
	protected ReturnedItem() {

	}

	/**
	 * Create a returnedItem.
	 *
	 * @return ReturnedItem with empty fields 
	 */
	public static ReturnedItem createReturnedItem() {
		return new ReturnedItem();
	}

	/**
	 * Creates a populated ReturnedItem
	 * @param id returned item id
	 * @param dateUTC UTC date
	 * @param dateLocal local date
	 * @param code returned item code
	 * @param description returned item description
	 * @return ReturnedItem with fields populated
	 */
	public static ReturnedItem createReturnedItem(String id, Date dateUTC, Date dateLocal, String code, String description) {
		ReturnedItem returnedItem = new ReturnedItem();

		returnedItem.setId( id);
		returnedItem.setDateUTC( dateUTC);
		returnedItem.setDateLocal( dateLocal);
		returnedItem.setCode( code);
		returnedItem.setDescription( description);

		LogHelper.debug(logger, "Created: '%s'", returnedItem);
		
		return returnedItem;
	}
	
	public String toString() {
		 StringBuilder builder = new StringBuilder();
		 builder.append("ReturnedItem:");
		 builder.append(",Id: ").append(this.id);
		 builder.append(",DateUTC: ").append(this.dateUTC);
		 builder.append(",DateLocal: ").append(this.dateLocal);
		 builder.append(",Code: ").append(this.code);
		 builder.append(",Description: ").append(this.description);

	     return builder.toString();
    }

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the dateUTC
	 */
	public Date getDateUTC() {
		return dateUTC;
	}

	/**
	 * @param dateUTC the dateUTC to set
	 */
	public void setDateUTC(Date dateUTC) {
		this.dateUTC = dateUTC;
	}

	/**
	 * @param dateUTC the dateUTC to set
	 */
	public void setDateUTC(String dateUTC) {
		if(StringUtils.isNotEmpty(dateUTC)) {
			Date date = net.authorize.util.DateUtil.getDateFromFormattedDate(dateUTC, ReportingDetails.DATE_FORMAT);
			this.setDateUTC( date);
		}
	}
	
	/**
	 * @return the dateLocal
	 */
	public Date getDateLocal() {
		return dateLocal;
	}

	/**
	 * @param dateLocal the dateLocal to set
	 */
	public void setDateLocal(Date dateLocal) {
		this.dateLocal = dateLocal;
	}

	/**
	 * @param dateLocal the dateLocal to set
	 */
	public void setDateLocal(String dateLocal) {
		if(StringUtils.isNotEmpty(dateLocal)) {
			Date date = net.authorize.util.DateUtil.getDateFromFormattedDate(dateLocal, ReportingDetails.DATE_FORMAT);
			this.setDateLocal( date);
		}
	}
	
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}
