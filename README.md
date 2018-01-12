# CurrencyServer

## Available APIs

Following APIs are available for you to use -

###1 Get all Currencies

**URL: /api/currency**

**Method: GET**

**Response:**

A list of Currency Object. Each currency object has – 
1. code – 3 alphabet code of currency
2. country – name of the country
3. name – name of the currency
4. flagPath - path to the image of flag
5. rate - equivalent conversion to USD rate

**Example Response:**
```
[{
    "code": "CHF",
    "country": "Switzerland",
    "name": "Swiss Franc",
    "flagPath": "/flags/ch.png",
    "rate": 1.0369
}, {
    "code": "CNY",
    "country": "China",
    "name": "Chinese Yuan Renminbi",
    "flagPath": "/flags/cn.png",
    "rate": 0.1528

}]
```
{
  
###2. Get Exchange Rate

**URL: /api/exchange?baseCode=<baseCode>&targetCode=<targetCode>**

Note that baseCode and targetCode are required parameters and refers to the 3-alphabet code of the currency.
For example, to convert Japanese Yen to Indian Rupee your request should be: /api/exchange?baseCode=JPY&targetCode=INR

**Method: GET**

**Response:**

An exchange object. Exchange object contains the following fields.
1. baseCode: The currency you want to convert from.
2. targetCode: The currency you want to convert to.
3. rate: effective conversion rate.

**Example Response:**

```
{
     "baseCode": "CNY",
     "targetCode": "MYR",
     "rate": 0.64201677
}
```
This means 1 CNY equals to 0.64201677 MYR

###3. Create Alert

**URL: /api/alert**

**Method: POST**

**Request:**

Request body should contain following fields:

1. code - Refers to 3-alphabet code of currency.
2. targetRate - A float value referring to the value at which alert should be sent.

**Response:**

A message object. Each message object has following fields.
1. message - A simple message to be displayed

**Example Request**

```$xslt
{
    "code": "INR",
    "targetRate": 1.2
}
```

**Example Response**

```$xslt
{
    "message": "Alert created successfully"
}
```