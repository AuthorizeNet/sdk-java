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
    public partial class Link : IEquatable<Link>
    { 
        /// <summary>
        /// URI of the linked resource.
        /// </summary>
        /// <value>URI of the linked resource.</value>

        [DataMember(Name="href")]
        public string Href { get; set; }

        /// <summary>
        /// Label of the linked resource.
        /// </summary>
        /// <value>Label of the linked resource.</value>

        [DataMember(Name="title")]
        public string Title { get; set; }

        /// <summary>
        /// HTTP method of the linked resource.
        /// </summary>
        /// <value>HTTP method of the linked resource.</value>

        [DataMember(Name="method")]
        public string Method { get; set; }

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            var sb = new StringBuilder();
            sb.Append("class Link {\n");
            sb.Append("  Href: ").Append(Href).Append("\n");
            sb.Append("  Title: ").Append(Title).Append("\n");
            sb.Append("  Method: ").Append(Method).Append("\n");
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
            return obj.GetType() == GetType() && Equals((Link)obj);
        }

        /// <summary>
        /// Returns true if Link instances are equal
        /// </summary>
        /// <param name="other">Instance of Link to be compared</param>
        /// <returns>Boolean</returns>
        public bool Equals(Link other)
        {
            if (ReferenceEquals(null, other)) return false;
            if (ReferenceEquals(this, other)) return true;

            return 
                (
                    Href == other.Href ||
                    Href != null &&
                    Href.Equals(other.Href)
                ) && 
                (
                    Title == other.Title ||
                    Title != null &&
                    Title.Equals(other.Title)
                ) && 
                (
                    Method == other.Method ||
                    Method != null &&
                    Method.Equals(other.Method)
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
                    if (Href != null)
                    hashCode = hashCode * 59 + Href.GetHashCode();
                    if (Title != null)
                    hashCode = hashCode * 59 + Title.GetHashCode();
                    if (Method != null)
                    hashCode = hashCode * 59 + Method.GetHashCode();
                return hashCode;
            }
        }

        #region Operators
        #pragma warning disable 1591

        public static bool operator ==(Link left, Link right)
        {
            return Equals(left, right);
        }

        public static bool operator !=(Link left, Link right)
        {
            return !Equals(left, right);
        }

        #pragma warning restore 1591
        #endregion Operators
    }
}