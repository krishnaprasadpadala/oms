# oms

Assignment Summary

1) Created two Micro services order-service & order-item-service.
2) order-service has 2 REST APIs. One is Get Order by Id and the other is Create an Order
3) order-item-service has also 2 APIs. One is Get Order Items and the other is Create Order Items.
4) While creating an Order, the POST API of order-service is called and an order is created here and then using Feign Client API call is made to Order-item-service 
   to create order Items.
5) Similary when a GET order API is called the call goes from order-service to order-item-service and fetches order items and then sent to order-service and and 
   then finally they add up to response.
6) Added a POSTMAN collection of test results.
