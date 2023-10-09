Testing APIs in Postman
1. Category Controller
Get all categories
Method: GET
URL: http://localhost:8080/api/all
To get all categories, simply send a GET request to the provided URL.

Create a category
Method: POST
URL: http://localhost:8080/api/create
Body:
Update a category
Method: POST
URL: http://localhost:8080/api/update
Body:

Delete a category by ID
Method: DELETE
URL: http://localhost:8080/api/delete/{id}
Replace {id} with the category ID you wish to delete.

Get category by ID
Method: GET
URL: http://localhost:8080/api/getcategorybyid/{id}
Replace {id} with the category ID you wish to retrieve.

2. Customer Controller
Repeat the same steps as the Category Controller but with the following base URL: http://localhost:8080/api/customer.

3. Login Controller
Login
Method: POST
URL: http://localhost:8080/api/login
Body:
4. Subscription Controller
Get all subscriptions
Method: GET
URL: http://localhost:8080/api/subscription
Get subscription by ID
Method: GET
URL: http://localhost:8080/api/subscription/{id}
Replace {id} with the subscription ID you wish to retrieve.

Delete subscription by ID
Method: DELETE
URL: http://localhost:8080/api/subscriptionDel/{id}
Replace {id} with the subscription ID you wish to delete.

Share subscription
Method: POST
URL: http://localhost:8080/api/share
Body:
4. Subscription Controller
Get all subscriptions
Method: GET
URL: http://localhost:8080/api/subscription
Get subscription by ID
Method: GET
URL: http://localhost:8080/api/subscription/{id}
Replace {id} with the subscription ID you wish to retrieve.

Delete subscription by ID
Method: DELETE
URL: http://localhost:8080/api/subscriptionDel/{id}
Replace {id} with the subscription ID you wish to delete.

Share subscription
Method: POST
URL: http://localhost:8080/api/share
Body: