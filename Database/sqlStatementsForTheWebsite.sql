USE dreamycupcakesdb;

-- Get all cupcake flavors - For the shop page
# SELECT * FROM cupcakeflavors;

-- Get all cupcake toppings - For the shop page
# SELECT * FROM cupcaketoppings;

-- Get all users - For the admin customer-list page
# SELECT user_id, firstName, lastName, email, accountBalance
# FROM users
# WHERE fk_userRole_id = 2;

-- Get all orders - For the orders page (only accessible for admins)
# SELECT orders.order_id, orders.fk_user_id, orders.orderDate, orders.pickupDate, orderstatuses.status
# FROM (orders
#     INNER JOIN orderstatuses ON orders.fk_orderStatus_id = orderstatuses.orderStatus_id)
# ORDER BY pickupDate, orderstatuses.orderStatus_id ASC;

-- Get all orders from a specific customer - For the customer-account page
# SELECT orders.order_id, orderstatuses.status, orders.orderDate, orders.pickupDate
# FROM (orders
#     INNER JOIN orderstatuses ON orders.fk_orderStatus_id = orderstatuses.orderStatus_id)
# WHERE fk_user_id = ?
# ORDER BY orders.pickupDate;

-- Get order details for a specific order (what cupcakes were ordered) - For the customer-account page
# SELECT orders.order_id, cupcakeflavors.name AS cupcakeFlavor, cupcaketoppings.name AS cupcakeTopping, orderedcupcakes.amount, orderedcupcakes.price
# FROM (((orderedcupcakes
#     INNER JOIN orders on orderedcupcakes.fk_order_id = orders.order_id)
#     INNER JOIN cupcakeflavors on orderedcupcakes.fk_cupcakeFlavor_id = cupcakeflavors.cupcakeFlavor_id)
#     INNER JOIN cupcaketoppings on orderedcupcakes.fk_cupcakeTopping_id = cupcaketoppings.cupcakeTopping_id)
# WHERE order_id = ?;

-- Create a new user (customer) account - For the sign-up page
# INSERT INTO users (firstName, lastName, email, password) VALUES (?, ?, ?, ?);

-- Create a new order - For the shopping-cart page
# INSERT INTO orders (fk_user_id, orderDate, pickupDate) VALUES (?, ?, ?);

-- Create a new order item - For the shopping-cart page
# INSERT INTO orderItems (fk_order_id, fk_cupcakeFlavor_id, fk_cupcakeTopping_id, amount, price) VALUES (?, ?, ?, ?, ?);
-- Here's an example of how to add multiple rows in one go: https://www.mysqltutorial.org/mysql-insert-multiple-rows/

# -- Subtract cupcake money from a customer's account - For the shoppingCart page
# UPDATE users
# SET accountBalance = (accountBalance - ?)
# WHERE user_id = ?;

# -- Add cupcake money to a customer's account - For the adminAddBalance page
# UPDATE users
# SET accountBalance = (? + accountBalance)
# WHERE user_id = ?;