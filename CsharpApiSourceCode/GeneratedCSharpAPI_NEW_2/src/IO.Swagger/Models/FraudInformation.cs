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
    /// Contains fraud information for a transaction.
    /// </summary>
    [DataContract]
    public partial class FraudInformation : IEquatable<FraudInformation>
    { 
        /// <summary>
        /// Gets or Sets FraudFilterList
        /// </summary>

        [DataMember(Name="fraudFilterList")]
        public List<FraudFilter> FraudFilterList { get; set; }

        /// <summary>
        /// The action applied to the transaction by the merchant&#x27;s Advanced Fraud Detection Suite (AFDS) settings.&lt;br /&gt; When multiple filters apply to a transaction, we will take the most restrictive action. For example, if a transaction triggers two AFDS filters, and one filter returns hold while the other filter returns reject, we will reject the transaction instead of holding it. &lt;br /&gt; Actions include &amp;#58; &lt;br /&gt; * &#x60;reject&#x60; &#x27;“ Ignores the transaction outright, except for AFDS reporting. &lt;br /&gt;&lt;br /&gt; * &#x60;decline&#x60; &#x27;“ Marks the transaction as declined but include it in the merchant&#x27;s transaction reporting. &lt;br /&gt;&lt;br /&gt; * &#x60;hold&#x60; â€“ Holds the transaction for manual review, and do not authorize unless the merchant approves it. &lt;br /&gt;&lt;br /&gt; * &#x60;authAndHold&#x60; â€“ Submits the transaction for authorization, but hold it for manual review, and do not settle unless the merchant approves it. &lt;br /&gt;&lt;br /&gt; * &#x60;report&#x60; â€“ Records the filter action but take no other action. 
        /// </summary>
        /// <value>The action applied to the transaction by the merchant&#x27;s Advanced Fraud Detection Suite (AFDS) settings.&lt;br /&gt; When multiple filters apply to a transaction, we will take the most restrictive action. For example, if a transaction triggers two AFDS filters, and one filter returns hold while the other filter returns reject, we will reject the transaction instead of holding it. &lt;br /&gt; Actions include &amp;#58; &lt;br /&gt; * &#x60;reject&#x60; &#x27;“ Ignores the transaction outright, except for AFDS reporting. &lt;br /&gt;&lt;br /&gt; * &#x60;decline&#x60; &#x27;“ Marks the transaction as declined but include it in the merchant&#x27;s transaction reporting. &lt;br /&gt;&lt;br /&gt; * &#x60;hold&#x60; â€“ Holds the transaction for manual review, and do not authorize unless the merchant approves it. &lt;br /&gt;&lt;br /&gt; * &#x60;authAndHold&#x60; â€“ Submits the transaction for authorization, but hold it for manual review, and do not settle unless the merchant approves it. &lt;br /&gt;&lt;br /&gt; * &#x60;report&#x60; â€“ Records the filter action but take no other action. </value>

        [DataMember(Name="fraudAction")]
        public string FraudAction { get; set; }

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            var sb = new StringBuilder();
            sb.Append("class FraudInformation {\n");
            sb.Append("  FraudFilterList: ").Append(FraudFilterList).Append("\n");
            sb.Append("  FraudAction: ").Append(FraudAction).Append("\n");
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
            return obj.GetType() == GetType() && Equals((FraudInformation)obj);
        }

        /// <summary>
        /// Returns true if FraudInformation instances are equal
        /// </summary>
        /// <param name="other">Instance of FraudInformation to be compared</param>
        /// <returns>Boolean</returns>
        public bool Equals(FraudInformation other)
        {
            if (ReferenceEquals(null, other)) return false;
            if (ReferenceEquals(this, other)) return true;

            return 
                (
                    FraudFilterList == other.FraudFilterList ||
                    FraudFilterList != null &&
                    FraudFilterList.SequenceEqual(other.FraudFilterList)
                ) && 
                (
                    FraudAction == other.FraudAction ||
                    FraudAction != null &&
                    FraudAction.Equals(other.FraudAction)
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
                    if (FraudFilterList != null)
                    hashCode = hashCode * 59 + FraudFilterList.GetHashCode();
                    if (FraudAction != null)
                    hashCode = hashCode * 59 + FraudAction.GetHashCode();
                return hashCode;
            }
        }

        #region Operators
        #pragma warning disable 1591

        public static bool operator ==(FraudInformation left, FraudInformation right)
        {
            return Equals(left, right);
        }

        public static bool operator !=(FraudInformation left, FraudInformation right)
        {
            return !Equals(left, right);
        }

        #pragma warning restore 1591
        #endregion Operators
    }
}