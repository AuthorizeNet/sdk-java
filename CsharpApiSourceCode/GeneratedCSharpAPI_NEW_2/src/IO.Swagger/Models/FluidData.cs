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
    /// This object contains encrypted payment data that can be submitted in the following types of payments&amp;#58; * Authorize.Net Accept * Visa Checkout * Apple Pay * Android Pay
    /// </summary>
    [DataContract]
    public partial class FluidData : IEquatable<FluidData>
    { 
        /// <summary>
        /// Only for Visa Checkout payments. This data is received from the JavaScript Visa Checkout integration&#x27;s &#x60;encKey&#x60; field. &lt;br /&gt;&lt;br /&gt; 128-character maximum.
        /// </summary>
        /// <value>Only for Visa Checkout payments. This data is received from the JavaScript Visa Checkout integration&#x27;s &#x60;encKey&#x60; field. &lt;br /&gt;&lt;br /&gt; 128-character maximum.</value>

        [DataMember(Name="key")]
        public string Key { get; set; }

        /// <summary>
        /// Specifies how the request should be processed. The value of &#x60;dataDescriptor&#x60; is based on the source of the value of &#x60;dataValue&#x60;. For example, for Accept, the value is &#x60;COMMON.ACCEPT.INAPP.PAYMENT&#x60;. &lt;br /&gt;&lt;br /&gt; 128 characters.
        /// </summary>
        /// <value>Specifies how the request should be processed. The value of &#x60;dataDescriptor&#x60; is based on the source of the value of &#x60;dataValue&#x60;. For example, for Accept, the value is &#x60;COMMON.ACCEPT.INAPP.PAYMENT&#x60;. &lt;br /&gt;&lt;br /&gt; 128 characters.</value>
        [Required]

        [DataMember(Name="descriptor")]
        public string Descriptor { get; set; }

        /// <summary>
        /// Base64 encoded data that contains encrypted payment data. The payment gateway expects the encrypted payment data and meta data for the encryption keys. &lt;br /&gt;&lt;br /&gt; 8192 characters.
        /// </summary>
        /// <value>Base64 encoded data that contains encrypted payment data. The payment gateway expects the encrypted payment data and meta data for the encryption keys. &lt;br /&gt;&lt;br /&gt; 8192 characters.</value>
        [Required]

        [DataMember(Name="value")]
        public string Value { get; set; }

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            var sb = new StringBuilder();
            sb.Append("class FluidData {\n");
            sb.Append("  Key: ").Append(Key).Append("\n");
            sb.Append("  Descriptor: ").Append(Descriptor).Append("\n");
            sb.Append("  Value: ").Append(Value).Append("\n");
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
            return obj.GetType() == GetType() && Equals((FluidData)obj);
        }

        /// <summary>
        /// Returns true if FluidData instances are equal
        /// </summary>
        /// <param name="other">Instance of FluidData to be compared</param>
        /// <returns>Boolean</returns>
        public bool Equals(FluidData other)
        {
            if (ReferenceEquals(null, other)) return false;
            if (ReferenceEquals(this, other)) return true;

            return 
                (
                    Key == other.Key ||
                    Key != null &&
                    Key.Equals(other.Key)
                ) && 
                (
                    Descriptor == other.Descriptor ||
                    Descriptor != null &&
                    Descriptor.Equals(other.Descriptor)
                ) && 
                (
                    Value == other.Value ||
                    Value != null &&
                    Value.Equals(other.Value)
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
                    if (Key != null)
                    hashCode = hashCode * 59 + Key.GetHashCode();
                    if (Descriptor != null)
                    hashCode = hashCode * 59 + Descriptor.GetHashCode();
                    if (Value != null)
                    hashCode = hashCode * 59 + Value.GetHashCode();
                return hashCode;
            }
        }

        #region Operators
        #pragma warning disable 1591

        public static bool operator ==(FluidData left, FluidData right)
        {
            return Equals(left, right);
        }

        public static bool operator !=(FluidData left, FluidData right)
        {
            return !Equals(left, right);
        }

        #pragma warning restore 1591
        #endregion Operators
    }
}