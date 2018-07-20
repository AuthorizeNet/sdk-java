package net.authorize.data.reporting;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import net.authorize.util.LogHelper;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
* Solution container for Solution-Type.
* 
* @deprecated since version 1.9.8
* @deprecated We have reorganized and simplified the Authorize.Net API to ease integration and to focus on merchants' needs.
* @deprecated We have deprecated AIM, ARB, CIM, and Reporting as separate options, in favor of AuthorizeNet::API.
* @deprecated We have also deprecated SIM as a separate option, in favor of Accept Hosted. See https://developer.authorize.net/api/reference/features/accept_hosted.html for details on Accept Hosted.
* @deprecated For details on AIM, see https://github.com/AuthorizeNet/sample-code-php/tree/master/PaymentTransactions.
* @deprecated For details on the deprecation and replacement of legacy Authorize.Net methods, visit https://developer.authorize.net/api/upgrade_guide/.
*
*/
@Deprecated
@XmlRootElement
public class Solution implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id = null;
	private String name = null;

	private static Log logger = LogFactory.getLog(Solution.class);

	/**
    * Default C'tor
    */
	protected Solution() {

	}

	/**
	 * Create a solution.
	 *
	 * @return Solution with empty fields 
	 */
	public static Solution createSolution() {
		return new Solution();
	}

	/**
	 * Creates a populated Solution
	 * @param id Sets the solution Id for solution
	 * @param name Sets the name number for solution
	 * @return Solution with fields populated
	 */
	public static Solution createSolution(String id, String name) {
		Solution solution = new Solution();
		solution.setId(id);
		solution.setName(name);

		LogHelper.debug(logger, "Created: '%s'", solution);
		
		return solution;
	}

	public String toString() {
		 StringBuilder builder = new StringBuilder();
		 builder.append("Solution:");
		 builder.append(" Id: ").append(this.id);
		 builder.append(",Name: ").append(this.name);
		 
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
