﻿using System;
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
    public class CreateCustomerAddressNEW
    {
        /// <summary>
        /// The customer&#x27;s street address.
        /// </summary>
        /// <value>The customer&#x27;s street address.</value>
        [Required]

        [DataMember(Name = "address1")]
        public string Address1 { get; set; }

        /// <summary>
        /// State or administrative area of the customer&#x27;s address.
        /// </summary>
        /// <value>State or administrative area of the customer&#x27;s address.</value>

        [DataMember(Name = "administrativeArea")]
        public string AdministrativeArea { get; set; }

        /// <summary>
        /// Name of the company associated with the customer&#x27;s address, if any.
        /// </summary>
        /// <value>Name of the company associated with the customer&#x27;s address, if any.</value>

        [DataMember(Name = "company")]
        public string Company { get; set; }

        /// <summary>
        /// Country associated with the customer&#x27;s address.
        /// </summary>
        /// <value>Country associated with the customer&#x27;s address.</value>

        [DataMember(Name = "country")]
        public string Country { get; set; }

        /// <summary>
        /// Setting this to &#x60;true&#x60; makes this address the customer&#x27;s default address.
        /// </summary>
        /// <value>Setting this to &#x60;true&#x60; makes this address the customer&#x27;s default address.</value>

        [DataMember(Name = "default")]
        public bool? _Default { get; set; }

        /// <summary>
        /// First name associated with the customer&#x27;s address.
        /// </summary>
        /// <value>First name associated with the customer&#x27;s address.</value>

        [DataMember(Name = "firstName")]
        public string FirstName { get; set; }

        /// <summary>
        /// Last name associated with the customer&#x27;s address.
        /// </summary>
        /// <value>Last name associated with the customer&#x27;s address.</value>

        [DataMember(Name = "lastName")]
        public string LastName { get; set; }

        /// <summary>
        /// City or town name associated with the customer&#x27;s address.
        /// </summary>
        /// <value>City or town name associated with the customer&#x27;s address.</value>

        [DataMember(Name = "locality")]
        public string Locality { get; set; }

        /// <summary>
        /// Phone number associated with the customer&#x27;s address.
        /// </summary>
        /// <value>Phone number associated with the customer&#x27;s address.</value>

        [DataMember(Name = "phoneNumber")]
        public string PhoneNumber { get; set; }

        /// <summary>
        /// ZIP or postal code of the customer&#x27;s address.
        /// </summary>
        /// <value>ZIP or postal code of the customer&#x27;s address.</value>

        [DataMember(Name = "postalCode")]
        public string PostalCode { get; set; }

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            var sb = new StringBuilder();
            sb.Append("class CreateCustomerAddress {\n");
            sb.Append("  Address1: ").Append(Address1).Append("\n");
            sb.Append("  AdministrativeArea: ").Append(AdministrativeArea).Append("\n");
            sb.Append("  Company: ").Append(Company).Append("\n");
            sb.Append("  Country: ").Append(Country).Append("\n");
            sb.Append("  _Default: ").Append(_Default).Append("\n");
            sb.Append("  FirstName: ").Append(FirstName).Append("\n");
            sb.Append("  LastName: ").Append(LastName).Append("\n");
            sb.Append("  Locality: ").Append(Locality).Append("\n");
            sb.Append("  PhoneNumber: ").Append(PhoneNumber).Append("\n");
            sb.Append("  PostalCode: ").Append(PostalCode).Append("\n");
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
            return obj.GetType() == GetType() && Equals((CreateCustomerAddress)obj);
        }

        /// <summary>
        /// Returns true if CreateCustomerAddress instances are equal
        /// </summary>
        /// <param name="other">Instance of CreateCustomerAddress to be compared</param>
        /// <returns>Boolean</returns>
        public bool Equals(CreateCustomerAddress other)
        {
            if (ReferenceEquals(null, other)) return false;
            if (ReferenceEquals(this, other)) return true;

            return
                (
                    Address1 == other.Address1 ||
                    Address1 != null &&
                    Address1.Equals(other.Address1)
                ) &&
                (
                    AdministrativeArea == other.AdministrativeArea ||
                    AdministrativeArea != null &&
                    AdministrativeArea.Equals(other.AdministrativeArea)
                ) &&
                (
                    Company == other.Company ||
                    Company != null &&
                    Company.Equals(other.Company)
                ) &&
                (
                    Country == other.Country ||
                    Country != null &&
                    Country.Equals(other.Country)
                ) &&
                (
                    _Default == other._Default ||
                    _Default != null &&
                    _Default.Equals(other._Default)
                ) &&
                (
                    FirstName == other.FirstName ||
                    FirstName != null &&
                    FirstName.Equals(other.FirstName)
                ) &&
                (
                    LastName == other.LastName ||
                    LastName != null &&
                    LastName.Equals(other.LastName)
                ) &&
                (
                    Locality == other.Locality ||
                    Locality != null &&
                    Locality.Equals(other.Locality)
                ) &&
                (
                    PhoneNumber == other.PhoneNumber ||
                    PhoneNumber != null &&
                    PhoneNumber.Equals(other.PhoneNumber)
                ) &&
                (
                    PostalCode == other.PostalCode ||
                    PostalCode != null &&
                    PostalCode.Equals(other.PostalCode)
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
                if (Address1 != null)
                    hashCode = hashCode * 59 + Address1.GetHashCode();
                if (AdministrativeArea != null)
                    hashCode = hashCode * 59 + AdministrativeArea.GetHashCode();
                if (Company != null)
                    hashCode = hashCode * 59 + Company.GetHashCode();
                if (Country != null)
                    hashCode = hashCode * 59 + Country.GetHashCode();
                if (_Default != null)
                    hashCode = hashCode * 59 + _Default.GetHashCode();
                if (FirstName != null)
                    hashCode = hashCode * 59 + FirstName.GetHashCode();
                if (LastName != null)
                    hashCode = hashCode * 59 + LastName.GetHashCode();
                if (Locality != null)
                    hashCode = hashCode * 59 + Locality.GetHashCode();
                if (PhoneNumber != null)
                    hashCode = hashCode * 59 + PhoneNumber.GetHashCode();
                if (PostalCode != null)
                    hashCode = hashCode * 59 + PostalCode.GetHashCode();
                return hashCode;
            }
        }

        #region Operators
#pragma warning disable 1591

        public static bool operator ==(CreateCustomerAddressNEW left, CreateCustomerAddress right)
        {
            return Equals(left, right);
        }

        public static bool operator !=(CreateCustomerAddressNEW left, CreateCustomerAddress right)
        {
            return !Equals(left, right);
        }

#pragma warning restore 1591
        #endregion Operators
    }
}
