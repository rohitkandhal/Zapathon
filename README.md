Zapathon
========

###Goal
Get familiar with Zappos API, specially product API. It provides detailed product information 
for different SKUs (or product ID). For example on this page http://www.zappos.com/sebago-docksides-brown-elk~2 the 
SKU is 104691.

###Requirements
1. A command line java program that will accept a filename as an argument. 
2. That file will be a text file that contains a list of SKUs, one per line. 
3. When you run the application, it will use the Zappos API to find the URL for each product's default image.
4. The program will download each image and write it into an "images" directory underneath the current directory. 
5. All images should be returned after the program runs. 
6. The application should create that directory if it does not yet exist. 
7. Application should be platform-agnostic. 

###Libraries used
1. GSON: Convert JSON string to Java Objects and vice versa. (https://code.google.com/p/google-gson/)
2. Zappos API: http://developer.zappos.com/
