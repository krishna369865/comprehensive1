Feature:  Load Urban Ladder



Scenario: signup the page
Given Initialize chrome browser
And Navigate to "https://www.urbanladder.com/" site
When Navigate to Login and enter username "esakonunaidu09@gmail.com"  and password "NaiduKris"
Then click on submit
Then close the driver

Scenario: navigate to sale and check study chairs
Given Initialize chrome browser
And Navigate to "https://www.urbanladder.com/" site
When Navigate to sale and click studychairs
Then print products
Then close the driver

Scenario: navigate to storage and check Tv units
Given Initialize chrome browser
And Navigate to "https://www.urbanladder.com/" site
When Navigate to sale and click Tvunits
Then add to cart
Then close the driver

Scenario: navigate to sale and check weekly deals
Given Initialize chrome browser
And Navigate to "https://www.urbanladder.com/" site
When Navigate to sale and click weekly deals
Then print deals products
Then close the driver

Scenario: Search for tables and select one
Given Initialize chrome browser
And Navigate to "https://www.urbanladder.com/" site
When Search for tables in search box
Then print all tables 
Then close the driver

Scenario: navigate to decor and select pouffe
Given Initialize chrome browser
And Navigate to "https://www.urbanladder.com/" site
When Navigate to decor and select pouffe
Then select low to high from recommended 
Then close the driver

Scenario: navigate to matresses and select Queen matresses
Given Initialize chrome browser
And Navigate to "https://www.urbanladder.com/" site
When navigate to matresses and select Queen matresses
Then print name and details of matresses 
Then close the driver

Scenario: navigate to matresses and print products
Given Initialize chrome browser
And Navigate to "https://www.urbanladder.com/" site
When navigate to matresses 
Then print productes 
Then close the driver

Scenario: navigate to help and click faqs
Given Initialize chrome browser
And Navigate to "https://www.urbanladder.com/" site
When navigate to help and click faqs 
Then select cancellation and print ans 
Then close the driver

Scenario: navigate to store and print address
Given Initialize chrome browser
And Navigate to "https://www.urbanladder.com/" site
When navigate to store and click first store 
Then  print address 
Then close the driver