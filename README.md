# CRUD operations:
To insert data we can use save(), persist(), saveOrUpdate()
Save method have return type, it return primary key value(it can be any object return in the serializable format)
persist() method doesn’t return anything. It is void type
 save can execute without transaction boundaries
 persist execute within transaction boundaries only, otherwise data cannot be saved in database
saveOrUpdate() method it select data and compare object data with table data, if it finds any difference it will do update operation based on primary key.

# Update Data
update(), merge(), saveOrUpdate()
Update method will select data based on primary key and compare data with object and updates data in table.(on non primary key fields)
In some cases update() method operation is failed(exception), at that time if we want to perform update operation at any cost we have to use merge method.(on non primary key fields)

Limitations:
Only non primary columns we can update
Complete record we need to update, it is not possible to update one column.

Merge method scenario: update method always checks object present in session or not, if the session contains same object with primary key it means we are trying to perform update on that primary key, update method will throw exception. But merge method doesn’t check session object it will directly do update operation.

# Delete Data from Table
delete(Object which having primary key), by using this method it delete the value in the table.

# SELECT transactions are not required
get(Entity.class, Serializable PrimaryKey) returns Object  → eager
load(Entity.class, Serializable PrimaryKey) returns Object → lazy

Get method will execute at  while calling the method only it will execute. If this method doesn’t find the data in database it will give null value. 
Load method execute at the time of acquiring non primary key values from the object, at that time it will fire the select query. If in case it doesn’t find any data it will throw not found excepion.











 







