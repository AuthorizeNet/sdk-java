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
using System.Collections.Generic;
using Microsoft.AspNetCore.Mvc;
using Swashbuckle.AspNetCore.Annotations;
using Swashbuckle.AspNetCore.SwaggerGen;
using Newtonsoft.Json;
using System.ComponentModel.DataAnnotations;
using IO.Swagger.Attributes;
using IO.Swagger.Security;
using Microsoft.AspNetCore.Authorization;
using IO.Swagger.Models;

namespace IO.Swagger.Controllers
{ 
    /// <summary>
    /// 
    /// </summary>
    [ApiController]
    public class CustomersPaymentMethodsApiController : ControllerBase
    { 
        /// <summary>
        /// Create A Payment Method
        /// </summary>
        /// <remarks>Create and payment method associated with a customer profile.</remarks>
        /// <param name="body">This object creates a payment method associated with a payment profile.</param>
        /// <param name="customerId">Unique identifier of the customer profile, from the original profile-creation response.</param>
        /// <response code="200">OK</response>
        /// <response code="404">PaymentMethod not created</response>
        /// <response code="0">Unexpected error.</response>
        [HttpPost]
        [Route("//v1/customers/{customerId}/paymentmethods")]
        [Authorize(AuthenticationSchemes = BasicAuthenticationHandler.SchemeName)]
        [ValidateModelState]
        [SwaggerOperation("CreatePaymentMethod")]
        [SwaggerResponse(statusCode: 200, type: typeof(PaymentMethod), description: "OK")]
        [SwaggerResponse(statusCode: 404, type: typeof(ErrorResponse), description: "PaymentMethod not created")]
        [SwaggerResponse(statusCode: 0, type: typeof(ErrorResponse), description: "Unexpected error.")]
        public virtual IActionResult CreatePaymentMethod([FromBody]CreatePaymentMethod body, [FromRoute][Required]string customerId)
        { 
            //TODO: Uncomment the next line to return response 200 or use other options such as return this.NotFound(), return this.BadRequest(..), ...
            // return StatusCode(200, default(PaymentMethod));

            //TODO: Uncomment the next line to return response 404 or use other options such as return this.NotFound(), return this.BadRequest(..), ...
            // return StatusCode(404, default(ErrorResponse));

            //TODO: Uncomment the next line to return response 0 or use other options such as return this.NotFound(), return this.BadRequest(..), ...
            // return StatusCode(0, default(ErrorResponse));
            string exampleJson = null;
            exampleJson = "{\r\n  \"default\" : true,\r\n  \"_links\" : {\r\n    \"self\" : {\r\n      \"method\" : \"method\",\r\n      \"href\" : \"href\",\r\n      \"title\" : \"title\"\r\n    }\r\n  },\r\n  \"billTo\" : {\r\n    \"country\" : \"country\",\r\n    \"firstName\" : \"firstName\",\r\n    \"lastName\" : \"lastName\",\r\n    \"phoneNumber\" : \"phoneNumber\",\r\n    \"address1\" : \"address1\",\r\n    \"postalCode\" : \"postalCode\",\r\n    \"locality\" : \"locality\",\r\n    \"company\" : \"company\",\r\n    \"administrativeArea\" : \"administrativeArea\"\r\n  },\r\n  \"id\" : \"id\",\r\n  \"paymentInformation\" : {\r\n    \"bankAccount\" : {\r\n      \"eCheckType\" : \"eCheckType\",\r\n      \"routingNumber\" : \"routingNumber\",\r\n      \"nameOnAccount\" : \"nameOnAccount\",\r\n      \"checkNumber\" : \"checkNumber\",\r\n      \"accountType\" : \"accountType\",\r\n      \"bankName\" : \"bankName\",\r\n      \"accountNumber\" : \"accountNumber\"\r\n    },\r\n    \"tokenizedCard\" : {\r\n      \"expirationYear\" : \"expirationYear\",\r\n      \"number\" : \"number\",\r\n      \"expirationMonth\" : \"expirationMonth\",\r\n      \"cryptogram\" : \"cryptogram\"\r\n    },\r\n    \"card\" : {\r\n      \"expirationYear\" : \"expirationYear\",\r\n      \"number\" : \"number\",\r\n      \"securityCode\" : \"securityCode\",\r\n      \"expirationMonth\" : \"expirationMonth\",\r\n      \"type\" : \"type\"\r\n    },\r\n    \"fluidData\" : {\r\n      \"descriptor\" : \"descriptor\",\r\n      \"value\" : \"value\",\r\n      \"key\" : \"key\"\r\n    },\r\n    \"customer\" : {\r\n      \"paymentMethodId\" : \"paymentMethodId\",\r\n      \"customerId\" : \"customerId\"\r\n    },\r\n    \"validate\" : true\r\n  }\r\n}";
            
                        var example = exampleJson != null
                        ? JsonConvert.DeserializeObject<PaymentMethod>(exampleJson)
                        : default(PaymentMethod);            //TODO: Change the data returned
            return new ObjectResult(example);
        }

        /// <summary>
        /// Delete a Customer Payment Method
        /// </summary>
        /// <remarks>Deletes a payment method from a payment profile.</remarks>
        /// <param name="customerId">Unique identifier of the customer profile.</param>
        /// <param name="paymentMethodId">Unique identifier of the payment method.</param>
        /// <response code="200">OK</response>
        [HttpDelete]
        [Route("//v1/customers/{customerId}/paymentmethods/{paymentMethodId}")]
        [Authorize(AuthenticationSchemes = BasicAuthenticationHandler.SchemeName)]
        [ValidateModelState]
        [SwaggerOperation("DeletePaymentmethod")]
        public virtual IActionResult DeletePaymentmethod([FromRoute][Required]string customerId, [FromRoute][Required]string paymentMethodId)
        { 
            //TODO: Uncomment the next line to return response 200 or use other options such as return this.NotFound(), return this.BadRequest(..), ...
            // return StatusCode(200);

            throw new NotImplementedException();
        }

        /// <summary>
        /// Get a Customer Payment Method
        /// </summary>
        /// <remarks>Get the payment method for a sinlge customer profile.</remarks>
        /// <param name="customerId">Unique identifier of the customer profile.</param>
        /// <param name="paymentMethodId">Unique identifier of the payment method.</param>
        /// <response code="200">OK</response>
        [HttpGet]
        [Route("//v1/customers/{customerId}/paymentmethods/{paymentMethodId}")]
        [Authorize(AuthenticationSchemes = BasicAuthenticationHandler.SchemeName)]
        [ValidateModelState]
        [SwaggerOperation("GetCustomerPaymentMethod")]
        [SwaggerResponse(statusCode: 200, type: typeof(PaymentMethod), description: "OK")]
        public virtual IActionResult GetCustomerPaymentMethod([FromRoute][Required]string customerId, [FromRoute][Required]string paymentMethodId)
        { 
            //TODO: Uncomment the next line to return response 200 or use other options such as return this.NotFound(), return this.BadRequest(..), ...
            // return StatusCode(200, default(PaymentMethod));
            string exampleJson = null;
            exampleJson = "{\r\n  \"default\" : true,\r\n  \"_links\" : {\r\n    \"self\" : {\r\n      \"method\" : \"method\",\r\n      \"href\" : \"href\",\r\n      \"title\" : \"title\"\r\n    }\r\n  },\r\n  \"billTo\" : {\r\n    \"country\" : \"country\",\r\n    \"firstName\" : \"firstName\",\r\n    \"lastName\" : \"lastName\",\r\n    \"phoneNumber\" : \"phoneNumber\",\r\n    \"address1\" : \"address1\",\r\n    \"postalCode\" : \"postalCode\",\r\n    \"locality\" : \"locality\",\r\n    \"company\" : \"company\",\r\n    \"administrativeArea\" : \"administrativeArea\"\r\n  },\r\n  \"id\" : \"id\",\r\n  \"paymentInformation\" : {\r\n    \"bankAccount\" : {\r\n      \"eCheckType\" : \"eCheckType\",\r\n      \"routingNumber\" : \"routingNumber\",\r\n      \"nameOnAccount\" : \"nameOnAccount\",\r\n      \"checkNumber\" : \"checkNumber\",\r\n      \"accountType\" : \"accountType\",\r\n      \"bankName\" : \"bankName\",\r\n      \"accountNumber\" : \"accountNumber\"\r\n    },\r\n    \"tokenizedCard\" : {\r\n      \"expirationYear\" : \"expirationYear\",\r\n      \"number\" : \"number\",\r\n      \"expirationMonth\" : \"expirationMonth\",\r\n      \"cryptogram\" : \"cryptogram\"\r\n    },\r\n    \"card\" : {\r\n      \"expirationYear\" : \"expirationYear\",\r\n      \"number\" : \"number\",\r\n      \"securityCode\" : \"securityCode\",\r\n      \"expirationMonth\" : \"expirationMonth\",\r\n      \"type\" : \"type\"\r\n    },\r\n    \"fluidData\" : {\r\n      \"descriptor\" : \"descriptor\",\r\n      \"value\" : \"value\",\r\n      \"key\" : \"key\"\r\n    },\r\n    \"customer\" : {\r\n      \"paymentMethodId\" : \"paymentMethodId\",\r\n      \"customerId\" : \"customerId\"\r\n    },\r\n    \"validate\" : true\r\n  }\r\n}";
            
                        var example = exampleJson != null
                        ? JsonConvert.DeserializeObject<PaymentMethod>(exampleJson)
                        : default(PaymentMethod);            //TODO: Change the data returned
            return new ObjectResult(example);
        }

        /// <summary>
        /// Get Customer Payment Methods
        /// </summary>
        /// <remarks>Get a list of payment methods associated with a customer profile.</remarks>
        /// <param name="customerId">Unique identifier of the customer profile, returned in the response to the request that created the profile.</param>
        /// <param name="offset">The number of the page to return results from. For example, if limit is set to 100, and offset is set to 2, the function will return 100 transactions starting with the transaction that would otherwise be the transaction numbered 101 in the result set. Accepted values are 1-100000.</param>
        /// <param name="limit">The number of transactions per page. Accepted values are 1-1000.</param>
        /// <response code="200">OK</response>
        [HttpGet]
        [Route("//v1/customers/{customerId}/paymentmethods")]
        [Authorize(AuthenticationSchemes = BasicAuthenticationHandler.SchemeName)]
        [ValidateModelState]
        [SwaggerOperation("GetCustomerPaymentMethods")]
        [SwaggerResponse(statusCode: 200, type: typeof(PaymentMethodCollection), description: "OK")]
        public virtual IActionResult GetCustomerPaymentMethods([FromRoute][Required]string customerId, [FromQuery]int? offset, [FromQuery]int? limit)
        { 
            //TODO: Uncomment the next line to return response 200 or use other options such as return this.NotFound(), return this.BadRequest(..), ...
            // return StatusCode(200, default(PaymentMethodCollection));
            string exampleJson = null;
            exampleJson = "{\r\n  \"_links\" : {\r\n    \"self\" : {\r\n      \"method\" : \"method\",\r\n      \"href\" : \"href\",\r\n      \"title\" : \"title\"\r\n    }\r\n  },\r\n  \"_embedded\" : {\r\n    \"paymentMethods\" : [ {\r\n      \"default\" : true,\r\n      \"_links\" : {\r\n        \"self\" : {\r\n          \"method\" : \"method\",\r\n          \"href\" : \"href\",\r\n          \"title\" : \"title\"\r\n        }\r\n      },\r\n      \"id\" : \"id\",\r\n      \"paymentInformation\" : {\r\n        \"bankAccount\" : {\r\n          \"eCheckType\" : \"eCheckType\",\r\n          \"routingNumber\" : \"routingNumber\",\r\n          \"nameOnAccount\" : \"nameOnAccount\",\r\n          \"checkNumber\" : \"checkNumber\",\r\n          \"accountType\" : \"accountType\",\r\n          \"bankName\" : \"bankName\",\r\n          \"accountNumber\" : \"accountNumber\"\r\n        },\r\n        \"tokenizedCard\" : {\r\n          \"expirationYear\" : \"expirationYear\",\r\n          \"number\" : \"number\",\r\n          \"expirationMonth\" : \"expirationMonth\",\r\n          \"cryptogram\" : \"cryptogram\"\r\n        },\r\n        \"card\" : {\r\n          \"expirationYear\" : \"expirationYear\",\r\n          \"number\" : \"number\",\r\n          \"securityCode\" : \"securityCode\",\r\n          \"expirationMonth\" : \"expirationMonth\",\r\n          \"type\" : \"type\"\r\n        },\r\n        \"fluidData\" : {\r\n          \"descriptor\" : \"descriptor\",\r\n          \"value\" : \"value\",\r\n          \"key\" : \"key\"\r\n        },\r\n        \"customer\" : {\r\n          \"paymentMethodId\" : \"paymentMethodId\",\r\n          \"customerId\" : \"customerId\"\r\n        },\r\n        \"validate\" : true\r\n      }\r\n    }, {\r\n      \"default\" : true,\r\n      \"_links\" : {\r\n        \"self\" : {\r\n          \"method\" : \"method\",\r\n          \"href\" : \"href\",\r\n          \"title\" : \"title\"\r\n        }\r\n      },\r\n      \"id\" : \"id\",\r\n      \"paymentInformation\" : {\r\n        \"bankAccount\" : {\r\n          \"eCheckType\" : \"eCheckType\",\r\n          \"routingNumber\" : \"routingNumber\",\r\n          \"nameOnAccount\" : \"nameOnAccount\",\r\n          \"checkNumber\" : \"checkNumber\",\r\n          \"accountType\" : \"accountType\",\r\n          \"bankName\" : \"bankName\",\r\n          \"accountNumber\" : \"accountNumber\"\r\n        },\r\n        \"tokenizedCard\" : {\r\n          \"expirationYear\" : \"expirationYear\",\r\n          \"number\" : \"number\",\r\n          \"expirationMonth\" : \"expirationMonth\",\r\n          \"cryptogram\" : \"cryptogram\"\r\n        },\r\n        \"card\" : {\r\n          \"expirationYear\" : \"expirationYear\",\r\n          \"number\" : \"number\",\r\n          \"securityCode\" : \"securityCode\",\r\n          \"expirationMonth\" : \"expirationMonth\",\r\n          \"type\" : \"type\"\r\n        },\r\n        \"fluidData\" : {\r\n          \"descriptor\" : \"descriptor\",\r\n          \"value\" : \"value\",\r\n          \"key\" : \"key\"\r\n        },\r\n        \"customer\" : {\r\n          \"paymentMethodId\" : \"paymentMethodId\",\r\n          \"customerId\" : \"customerId\"\r\n        },\r\n        \"validate\" : true\r\n      }\r\n    } ]\r\n  },\r\n  \"totalPaymentMethods\" : 0\r\n}";
            
                        var example = exampleJson != null
                        ? JsonConvert.DeserializeObject<PaymentMethodCollection>(exampleJson)
                        : default(PaymentMethodCollection);            //TODO: Change the data returned
            return new ObjectResult(example);
        }

        /// <summary>
        /// Update a Customer Payment Method
        /// </summary>
        /// <remarks>Update a payment method associated with a payment profile.</remarks>
        /// <param name="body">Contains the updated payment method information.</param>
        /// <param name="customerId">Unique identifier of the customer profile.</param>
        /// <param name="paymentMethodId">Unique identifier of the payment method.</param>
        /// <response code="200">OK</response>
        /// <response code="404">Payment Method not updated</response>
        /// <response code="0">Unexpected error.</response>
        [HttpPut]
        [Route("//v1/customers/{customerId}/paymentmethods/{paymentMethodId}")]
        [Authorize(AuthenticationSchemes = BasicAuthenticationHandler.SchemeName)]
        [ValidateModelState]
        [SwaggerOperation("UpdatePaymentMethod")]
        [SwaggerResponse(statusCode: 200, type: typeof(PaymentMethod), description: "OK")]
        [SwaggerResponse(statusCode: 404, type: typeof(ErrorResponse), description: "Payment Method not updated")]
        [SwaggerResponse(statusCode: 0, type: typeof(ErrorResponse), description: "Unexpected error.")]
        public virtual IActionResult UpdatePaymentMethod([FromBody]CreatePaymentMethod body, [FromRoute][Required]string customerId, [FromRoute][Required]string paymentMethodId)
        { 
            //TODO: Uncomment the next line to return response 200 or use other options such as return this.NotFound(), return this.BadRequest(..), ...
            // return StatusCode(200, default(PaymentMethod));

            //TODO: Uncomment the next line to return response 404 or use other options such as return this.NotFound(), return this.BadRequest(..), ...
            // return StatusCode(404, default(ErrorResponse));

            //TODO: Uncomment the next line to return response 0 or use other options such as return this.NotFound(), return this.BadRequest(..), ...
            // return StatusCode(0, default(ErrorResponse));
            string exampleJson = null;
            exampleJson = "{\r\n  \"default\" : true,\r\n  \"_links\" : {\r\n    \"self\" : {\r\n      \"method\" : \"method\",\r\n      \"href\" : \"href\",\r\n      \"title\" : \"title\"\r\n    }\r\n  },\r\n  \"billTo\" : {\r\n    \"country\" : \"country\",\r\n    \"firstName\" : \"firstName\",\r\n    \"lastName\" : \"lastName\",\r\n    \"phoneNumber\" : \"phoneNumber\",\r\n    \"address1\" : \"address1\",\r\n    \"postalCode\" : \"postalCode\",\r\n    \"locality\" : \"locality\",\r\n    \"company\" : \"company\",\r\n    \"administrativeArea\" : \"administrativeArea\"\r\n  },\r\n  \"id\" : \"id\",\r\n  \"paymentInformation\" : {\r\n    \"bankAccount\" : {\r\n      \"eCheckType\" : \"eCheckType\",\r\n      \"routingNumber\" : \"routingNumber\",\r\n      \"nameOnAccount\" : \"nameOnAccount\",\r\n      \"checkNumber\" : \"checkNumber\",\r\n      \"accountType\" : \"accountType\",\r\n      \"bankName\" : \"bankName\",\r\n      \"accountNumber\" : \"accountNumber\"\r\n    },\r\n    \"tokenizedCard\" : {\r\n      \"expirationYear\" : \"expirationYear\",\r\n      \"number\" : \"number\",\r\n      \"expirationMonth\" : \"expirationMonth\",\r\n      \"cryptogram\" : \"cryptogram\"\r\n    },\r\n    \"card\" : {\r\n      \"expirationYear\" : \"expirationYear\",\r\n      \"number\" : \"number\",\r\n      \"securityCode\" : \"securityCode\",\r\n      \"expirationMonth\" : \"expirationMonth\",\r\n      \"type\" : \"type\"\r\n    },\r\n    \"fluidData\" : {\r\n      \"descriptor\" : \"descriptor\",\r\n      \"value\" : \"value\",\r\n      \"key\" : \"key\"\r\n    },\r\n    \"customer\" : {\r\n      \"paymentMethodId\" : \"paymentMethodId\",\r\n      \"customerId\" : \"customerId\"\r\n    },\r\n    \"validate\" : true\r\n  }\r\n}";
            
                        var example = exampleJson != null
                        ? JsonConvert.DeserializeObject<PaymentMethod>(exampleJson)
                        : default(PaymentMethod);            //TODO: Change the data returned
            return new ObjectResult(example);
        }
    }
}