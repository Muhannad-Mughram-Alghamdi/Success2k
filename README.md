# Success2k
![TUWAIQ LOGO](https://camo.githubusercontent.com/37ca472e2afb74974a0314d89af8f470422a79582bed0d188f9927777230195d/68747470733a2f2f6c61756e63682e73612f6173736574732f696d616765732f6c6f676f732f7475776169712d61636164656d792d6c6f676f2e737667)
# FOCKOS
![FOCKOS LOGO]()

### DEMO
---
![Screenshots]()
### DESCRIPTION
---

FOCKOS is a third party app for flickr meant to delever the best mobile experince to the user, while using flickr platform

### TABLE OF CONTENTS
---
* APPLICATION
* WIREFRAMES AND USER STORIES
* TECHNOLOGY STOCK 
* FEATURS
* INSTALLATION 
* PLANNING
* APIs
* USAGE
* TESTS
* TEAM MEMBERS
* CONTREBUTIONS INSTRUCTIONS

### APPLICATION
---
[github](https://github.com/Muhannad-Mughram-Alghamdi/Success2k/tree/main)
### WIREFRAMES AND USER STORIES
---

### TECHNOLOGY STOCK 
---
|Technology        |Description                                                                                            |
|:---:             |:---:                                                                                                  |
| Android Studio   |Integrated development environment for Google's Android OS                                             |
| Kotlin           |Hight level, crossplateform programming language from Google,  designed to interoperate fully with Java|
| Figma            |Vector graphics editor and prototyping tool helps with designing the UI                                |
| Postman          |used for API testing. It is an HTTP client that tests HTTP requests, utilizing a graphical user interface.|

### FEATURS
---

### INSTALLATION
---
You must have an Android Studio installed on your computer
after installing the Android Studio, open the FOCKOS file in the IDE, and it should configer averything automaticly,
then you will run it, or upload it to your android phone if you allowed the developer mode on it.

The android studio will automaticly recognize the phone and it will show in the top bar on the IDE, then press run.

### PLANNING
---

### APIs
---
#### Introduction

Using Flickr API you can retrieve a plethora of photographs and in turn, may create awesome applications. Moreover, you may upload your application to Flickr's marketplace APP Garden and make bucks and recognition too.

In this tutorial, we will see how to get started with Flickr API. We will create a simple application using Flickr API and in the course, we learn some nuances of how to unleash the potential of Flickr's awesome photo sharing services.

#### Obtaining an API key

Like so many other API's, here too, you have to obtain an API key from Flickr. You must have an Yahoo! account to log in to the flickr.com or if you don't have one, you have to sign up to Flickr. Once you are within Flickr, point your browser to https://www.flickr.com/services/api/. Go to 'Create an APP' for creating an API key. Click on the link "Request an API Key".
/////
This will turn up two options, whether you want to go for a commercial app or a non-commercial one. Click on the appropriate link according to your intention.
/////
That you will take you to a page where you have to provide them with a name for your app and a short description.

You have to acknowledge two trivia regarding rights and terms of use also. Please, the read the Terms Of use document spending a couple of minutes because that will help you take decisions both from entrepreneurs as well as developers point of view. Once you complete, hit Submit and you will be provided with an APP Key and Secret. Preserve these properly because you will need these in future while writing your app.
/////
#### Outline of our app

In this app we will fetch hundred recent photos from Flickr and then filter them according to the current location of the user. 

#### Understanding methods

Flickr API's methods construct an endpoint (an url) which returns data in XML or JSON format. Once that is done, you may decode that data using many programming languages and present that to your users. Every Flickr API method has got several arguments to be passed, Some required and some optional.

Clicking on the flickr.photos.getRecent will take you to [flickr API](https://www.flickr.com/services/api/flickr.photos.getRecent.html). A documentation of the methods is available here. You can see that there four types of arguments can be used with this method. Among them, 'api_key' is required.

You can pass a number of optional arguments as 'extra' to fetch some very useful information like description, license, date_upload, date_taken, owner_name etc. regarding the photos returned.

'per_page another optional argument returns a number of photos to return per page, If this argument is not supplied, a hundred photos are returned by default.

To return the number of pages containing results, another optional argument 'page' may be used. If not used, only a single page of the result will be returned.

Just below this, you will find a link pointing to the API explorer of this method. You can find the structure of the endpoint in Flickr's API Explorer. Click on the link available and you will find a page with instruments to construct the endpoint. For the same of simplicity, we will take the only per_page and assign a value of 10, so ten photos from the band of recent photos will only be returned.

#### Authorization

|Parameter | Type |Description |
|:---:     |:---: |:---:       |
|          |      |            |

### USAGE
---

### TESTS
---

### TEAM MEMBERS
---
- [Muhannad Alghamdi](https://github.com/Muhannad-Mughram-Alghamdi)
- [Abdulaziz Alrajeh](https://github.com/AbdulazizAlrajeh)
- [Abdullah Alfaraj](https://github.com/alfa7158)
- [hassan alwesaibi](https://github.com/hassan1alwesaibi)
- [Nourah Mohammed](https://github.com/Nourah1000)

