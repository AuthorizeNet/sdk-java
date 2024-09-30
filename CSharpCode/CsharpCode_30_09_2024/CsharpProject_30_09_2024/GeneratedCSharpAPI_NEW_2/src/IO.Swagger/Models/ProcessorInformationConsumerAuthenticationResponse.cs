/*
 * Authorize.Net REST API
 *
 * Authorize.Net REST API
 *
 * OpenAPI spec version: 1.0
 * 
 * Generated by: https://github.com/swagger-api/swagger-codegen.git
 */
using System;
using System.Linq;
using System.IO;
using System.Text;
using System.Collections;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.ComponentModel.DataAnnotations;
using System.Runtime.Serialization;
using Newtonsoft.Json;

namespace IO.Swagger.Models
{ 
    /// <summary>
    /// 
    /// </summary>
    [DataContract]
    public partial class ProcessorInformationConsumerAuthenticationResponse : IEquatable<ProcessorInformationConsumerAuthenticationResponse>
    { 
        /// <summary>
        /// Cardholder authentication verification response code.  **Note:** Mastercard transactions always return a null result for this element. Consequently, transaction details for Mastercard transactions do not contain CAVV results.  String, 1 character. Valid values include:  * Blank or not present - - CAVV not validated.  * &#x60;0&#x60; - - CAVV was not validated because erroneous data was submitted.  * &#x60;1&#x60; - - CAVV failed validation.  * &#x60;2&#x60; - - CAVV passed validation.  * &#x60;3&#x60; - - CAVV validation could not be performed; issuer attempt incomplete.  * &#x60;4&#x60; - - CAVV validation could not be performed; issuer system error.  * &#x60;5&#x60; - - Reserved for future use.  * &#x60;6&#x60; - - Reserved for future use.  * &#x60;7&#x60; - - CAVV failed validation, but the issuer is available. Valid for U.S.-issued card submitted to non-U.S acquirer.  * &#x60;8&#x60; - - CAVV passed validation and the issuer is available. Valid for U.S.-issued card submitted to non-U.S. acquirer.  * &#x60;9&#x60; - - CAVV failed validation and the issuer is unavailable. Valid for U.S.-issued card submitted to non-U.S acquirer.  * &#x60;A&#x60; - - CAVV passed validation but the issuer unavailable. Valid for U.S.-issued card submitted to non-U.S acquirer.  * &#x60;B&#x60; - - CAVV passed validation, information only, no liability shift.
        /// </summary>
        /// <value>Cardholder authentication verification response code.  **Note:** Mastercard transactions always return a null result for this element. Consequently, transaction details for Mastercard transactions do not contain CAVV results.  String, 1 character. Valid values include:  * Blank or not present - - CAVV not validated.  * &#x60;0&#x60; - - CAVV was not validated because erroneous data was submitted.  * &#x60;1&#x60; - - CAVV failed validation.  * &#x60;2&#x60; - - CAVV passed validation.  * &#x60;3&#x60; - - CAVV validation could not be performed; issuer attempt incomplete.  * &#x60;4&#x60; - - CAVV validation could not be performed; issuer system error.  * &#x60;5&#x60; - - Reserved for future use.  * &#x60;6&#x60; - - Reserved for future use.  * &#x60;7&#x60; - - CAVV failed validation, but the issuer is available. Valid for U.S.-issued card submitted to non-U.S acquirer.  * &#x60;8&#x60; - - CAVV passed validation and the issuer is available. Valid for U.S.-issued card submitted to non-U.S. acquirer.  * &#x60;9&#x60; - - CAVV failed validation and the issuer is unavailable. Valid for U.S.-issued card submitted to non-U.S acquirer.  * &#x60;A&#x60; - - CAVV passed validation but the issuer unavailable. Valid for U.S.-issued card submitted to non-U.S acquirer.  * &#x60;B&#x60; - - CAVV passed validation, information only, no liability shift.</value>

        [DataMember(Name="code")]
        public string Code { get; set; }

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            var sb = new StringBuilder();
            sb.Append("class ProcessorInformationConsumerAuthenticationResponse {\n");
            sb.Append("  Code: ").Append(Code).Append("\n");
            sb.Append("}\n");
            return sb.ToString();
        }

        /// <summary>
        /// Returns the JSON string presentation of the object
        /// </summary>
        /// <returns>JSON string presentation of the object</returns>
        public string ToJson()
        {
            return JsonConvert.SerializeObject(this, Formatting.Indented);
        }

        /// <summary>
        /// Returns true if objects are equal
        /// </summary>
        /// <param name="obj">Object to be compared</param>
        /// <returns>Boolean</returns>
        public override bool Equals(object obj)
        {
            if (ReferenceEquals(null, obj)) return false;
            if (ReferenceEquals(this, obj)) return true;
            return obj.GetType() == GetType() && Equals((ProcessorInformationConsumerAuthenticationResponse)obj);
        }

        /// <summary>
        /// Returns true if ProcessorInformationConsumerAuthenticationResponse instances are equal
        /// </summary>
        /// <param name="other">Instance of ProcessorInformationConsumerAuthenticationResponse to be compared</param>
        /// <returns>Boolean</returns>
        public bool Equals(ProcessorInformationConsumerAuthenticationResponse other)
        {
            if (ReferenceEquals(null, other)) return false;
            if (ReferenceEquals(this, other)) return true;

            return 
                (
                    Code == other.Code ||
                    Code != null &&
                    Code.Equals(other.Code)
                );
        }

        /// <summary>
        /// Gets the hash code
        /// </summary>
        /// <returns>Hash code</returns>
        public override int GetHashCode()
        {
            unchecked // Overflow is fine, just wrap
            {
                var hashCode = 41;
                // Suitable nullity checks etc, of course :)
                    if (Code != null)
                    hashCode = hashCode * 59 + Code.GetHashCode();
                return hashCode;
            }
        }

        #region Operators
        #pragma warning disable 1591

        public static bool operator ==(ProcessorInformationConsumerAuthenticationResponse left, ProcessorInformationConsumerAuthenticationResponse right)
        {
            return Equals(left, right);
        }

        public static bool operator !=(ProcessorInformationConsumerAuthenticationResponse left, ProcessorInformationConsumerAuthenticationResponse right)
        {
            return !Equals(left, right);
        }

        #pragma warning restore 1591
        #endregion Operators
    }
}
