Zapathon
========

####Goal
---------
Get familiar with Zappos API, specially product API. It provides detailed product information 
for different SKUs (or product ID). For example on this page http://www.zappos.com/sebago-docksides-brown-elk~2 the 
SKU is 104691.

That program will accept a filename on the command line. That file will be a text file that contains a list of SKUs, one per line. When you run the application, it will use the Zappos API to find the URL for each product's default image (defaultImageUrl in the product API). The program will download each image and write it into an "images" directory underneath the current directory. All images should be returned after the program runs. The application should create that directory if it does not yet exist. Your application should also include sufficient error handling code so it does not crash if a bad product ID is found in the file. Use the attached SKU file (skus.txt) as a sample of what an SKU file might be like.

Please note that we are primarily a Mac/Linux shop here, so your application should be platform-agnostic (in case you are primarily a Windows coder). Please write this in the same way as you would write production code for us at Zappos, taking into account the developers that would take over your project in the future (if this was in fact a real production application you were writing). Be prepared to explain what your program does and walk through the code with us if requested. 

In order to make calls to the Zappos API, you will need to use an API key. Please use the following API key when making these calls: "52ddafbe3ee659bad97fcce7c53592916a6bfd73" (without quotes). Feel free to include any additional documentation as you see fit.
