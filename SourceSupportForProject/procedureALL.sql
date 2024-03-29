
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'sp_insert_DEPARTMENT')AND type in (N'P', N'PC'))
DROP PROCEDURE sp_insert_DEPARTMENT
GO

 CREATE PROCEDURE sp_insert_DEPARTMENT

@in_NAME varchar(250)  
AS

BEGIN
	Insert into DEPARTMENT ([NAME])
	values(@in_NAME)
END 
GO

IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'sp_update_DEPARTMENT')AND type in (N'P', N'PC'))
DROP PROCEDURE sp_update_DEPARTMENT
GO

 CREATE PROCEDURE sp_update_DEPARTMENT
@in_ID int,
@in_NAME varchar(250) 

AS
BEGIN

	UPDATE [dbo].DEPARTMENT SET [NAME]=@in_NAME 
	WHERE ID=@in_ID

END
GO

IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'sp_update_StatusComplain')AND type in (N'P', N'PC'))
DROP PROCEDURE sp_update_StatusComplain
GO

 CREATE PROCEDURE sp_update_StatusComplain
@in_ID int,
@in_NAME varchar(250) 

AS
BEGIN

	UPDATE [dbo].STATUS_COMPLAIN SET [NAME]=@in_NAME 
	WHERE ID=@in_ID

END
GO

IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'sp_update_StatusOrder')AND type in (N'P', N'PC'))
DROP PROCEDURE sp_update_StatusOrder
GO

 CREATE PROCEDURE sp_update_StatusOrder
@in_ID int,
@in_NAME varchar(250) 

AS
BEGIN

	UPDATE [dbo].STATUS_ORDER SET [NAME]=@in_NAME 
	WHERE ID=@in_ID

END
GO

IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'sp_insert_ROLE')AND type in (N'P', N'PC'))
DROP PROCEDURE sp_insert_ROLE
GO

 CREATE PROCEDURE sp_insert_ROLE

@in_NAME varchar(250)  
AS
BEGIN
	Insert into [ROLE] ([NAME])
	values(@in_NAME)
END
GO

IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'sp_update_ROLE')AND type in (N'P', N'PC'))
DROP PROCEDURE sp_update_ROLE
GO

 CREATE PROCEDURE sp_update_ROLE
@in_NAME varchar(250) ,
@p_ID int,
@p_NAME varchar(250) 
AS
BEGIN
	UPDATE [dbo].[ROLE] SET [NAME]=@in_NAME 
	WHERE ID=@p_ID AND NAME=@p_NAME
END
GO

IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'sp_insert_STATUS_COMPLAIN')AND type in (N'P', N'PC'))
DROP PROCEDURE sp_insert_STATUS_COMPLAIN
GO

 CREATE PROCEDURE sp_insert_STATUS_COMPLAIN
@in_NAME varchar(250)  
AS
BEGIN
	Insert into STATUS_COMPLAIN ([NAME])
	values(@in_NAME)
END
GO

IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'sp_update_STATUS_COMPLAIN')AND type in (N'P', N'PC'))
DROP PROCEDURE sp_update_STATUS_COMPLAIN
GO

 CREATE PROCEDURE sp_update_STATUS_COMPLAIN
@in_NAME varchar(250) ,
@p_ID int,
@p_NAME varchar(250) 
AS
BEGIN
	UPDATE [dbo].STATUS_COMPLAIN SET [NAME]=@in_NAME 
	WHERE ID=@p_ID AND NAME=@p_NAME

END
GO

IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'sp_insert_STATUS_ORDER')AND type in (N'P', N'PC'))
DROP PROCEDURE sp_insert_STATUS_ORDER
GO

 CREATE PROCEDURE sp_insert_STATUS_ORDER
@in_NAME varchar(250)  
AS
BEGIN
	Insert into STATUS_ORDER ([NAME])
	values(@in_NAME)
END
GO

IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'sp_update_STATUS_ORDER')AND type in (N'P', N'PC'))
DROP PROCEDURE sp_update_STATUS_ORDER
GO

 CREATE PROCEDURE sp_update_STATUS_ORDER
@in_NAME varchar(250) ,
@p_ID int,
@p_NAME varchar(250) 
AS
BEGIN
	UPDATE [dbo].STATUS_ORDER SET [NAME]=@in_NAME 
	WHERE ID=@p_ID AND NAME=@p_NAME
END
GO

IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'sp_insert_ACCOUNT')AND type in (N'P', N'PC'))
DROP PROCEDURE sp_insert_ACCOUNT
GO

 CREATE PROCEDURE sp_insert_ACCOUNT
@in_USERNAME varchar(100),
@in_PASSWORD varchar(100),
@in_NAME nvarchar(250),
@in_GENDER bit,
@in_EMAIL varchar(250),
@in_PHONE varchar(12),
@in_ADDRESS varchar(250),
@in_ROLE_ID int,
@in_DEPARTMENT_ID int  
AS
BEGIN
	Insert into ACCOUNT (USERNAME,[PASSWORD],[NAME],GENDER,EMAIL,PHONE,ADDRESS,ROLE_ID,DEPARTMENT_ID)
	values(@in_USERNAME,@in_PASSWORD,@in_NAME,@in_GENDER,@in_EMAIL,@in_PHONE,@in_ADDRESS,@in_ROLE_ID,@in_DEPARTMENT_ID)
END
GO

IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'sp_update_ACCOUNT')AND type in (N'P', N'PC'))
DROP PROCEDURE sp_update_ACCOUNT
GO

 CREATE PROCEDURE sp_update_ACCOUNT

@in_PASSWORD varchar(100),
@in_NAME nvarchar(250),
@in_GENDER bit,
@in_EMAIL varchar(250),
@in_PHONE varchar(12),
@in_ADDRESS varchar(250),
@in_ROLE_ID int,
@in_DEPARTMENT_ID int,
@p_ID int,
@p_USERNAME varchar(100)

AS
BEGIN
	UPDATE [dbo].ACCOUNT SET [PASSWORD]=@in_PASSWORD,[NAME]=@in_NAME,GENDER=@in_GENDER,EMAIL=@in_EMAIL,PHONE=@in_PHONE,ADDRESS=@in_ADDRESS,ROLE_ID=@in_ROLE_ID,DEPARTMENT_ID=@in_DEPARTMENT_ID 
	WHERE ID=@p_ID and USERNAME=@p_USERNAME

END
GO
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'sp_insert_CLIENT')AND type in (N'P', N'PC'))
DROP PROCEDURE sp_insert_CLIENT
GO

 CREATE PROCEDURE sp_insert_CLIENT

@in_NAME varchar(250),
@in_PHONE varchar(12),
@in_ADDRESS varchar(250),
@in_COMPANY_NAME varchar(250)  
AS
BEGIN
	Insert into CLIENT ([NAME],PHONE,ADDRESS,COMPANY_NAME)
	values(@in_NAME,@in_PHONE,@in_ADDRESS,@in_COMPANY_NAME)
END
GO

IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'sp_update_CLIENT')AND type in (N'P', N'PC'))
DROP PROCEDURE sp_update_CLIENT
GO

 CREATE PROCEDURE sp_update_CLIENT
@_NAME varchar(250),
@_PHONE varchar(12),
@_ADDRESS varchar(250),
@_COMPANY_NAME varchar(250) ,
@p_ID int
AS
BEGIN
	UPDATE [dbo].CLIENT SET NAME=@_NAME,PHONE=@_PHONE,ADDRESS=@_ADDRESS,COMPANY_NAME=@_COMPANY_NAME 
	WHERE ID=@p_ID

END
GO

IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'sp_insert_PRODUCT_ELEVATION')AND type in (N'P', N'PC'))
DROP PROCEDURE sp_insert_PRODUCT_ELEVATION
GO

 CREATE PROCEDURE sp_insert_PRODUCT_ELEVATION
@in_NAME varchar(250),
@in_TYPE varchar(250),
@in_PRICE int,
@in_DATE_OF_ORDER date,
@in_WARRANTY int,
@in_WARRANTY_EXPIRE_DATE date  
AS
BEGIN
	Insert into PRODUCT_ELEVATION ([NAME],[TYPE],PRICE,DATE_OF_ORDER,WARRANTY,WARRANTY_EXPIRE_DATE)
	values(@in_NAME,@in_TYPE,@in_PRICE,@in_DATE_OF_ORDER,@in_WARRANTY,@in_WARRANTY_EXPIRE_DATE)
END
GO

IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'sp_update_PRODUCT_ELEVATION')AND type in (N'P', N'PC'))
DROP PROCEDURE sp_update_PRODUCT_ELEVATION
GO

 CREATE PROCEDURE sp_update_PRODUCT_ELEVATION
@in_NAME varchar(250),
@in_TYPE varchar(250),
@in_PRICE int,
@in_DATE_OF_ORDER date,
@in_WARRANTY int,
@in_WARRANTY_EXPIRE_DATE date ,
@p_ID int

AS
BEGIN

	UPDATE [dbo].PRODUCT_ELEVATION SET [NAME]=@in_Name,[TYPE]=@in_TYPE,PRICE=@in_PRICE,DATE_OF_ORDER=@in_DATE_OF_ORDER,WARRANTY=@in_WARRANTY,WARRANTY_EXPIRE_DATE=@in_WARRANTY_EXPIRE_DATE 
	WHERE ID=@p_ID

END
GO

IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'sp_insert_ORDER_DETAIL')AND type in (N'P', N'PC'))
DROP PROCEDURE sp_insert_ORDER_DETAIL
GO

 CREATE PROCEDURE sp_insert_ORDER_DETAIL

@in_ORDERS_ID int,
@in_PRODUCT_ID int,
@in_NUM_OF_SYSTEM_INSTALLED int,
@in_PRICE int,
@in_WARRANTY_PERIOD int,
@in_WARRANTY_EXPIRE_DATE date  
AS
BEGIN
	Insert into ORDER_DETAIL (ORDERS_ID,PRODUCT_ID,NUM_OF_SYSTEM_INSTALLED,PRICE,WARRANTY_PERIOD,WARRANTY_EXPIRE_DATE)
	values(@in_ORDERS_ID,@in_PRODUCT_ID,@in_NUM_OF_SYSTEM_INSTALLED,@in_PRICE,@in_WARRANTY_PERIOD,@in_WARRANTY_EXPIRE_DATE)
END
GO

IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'sp_update_ORDER_DETAIL')AND type in (N'P', N'PC'))
DROP PROCEDURE sp_update_ORDER_DETAIL
GO

 CREATE PROCEDURE sp_update_ORDER_DETAIL

@in_NUM_OF_SYSTEM_INSTALLED int,
@in_PRICE int,
@in_WARRANTY_PERIOD int,
@in_WARRANTY_EXPIRE_DATE date ,
@p_ORDERS_ID int,
@p_PRODUCT_ID int
AS
BEGIN

	UPDATE [dbo].ORDER_DETAIL SET NUM_OF_SYSTEM_INSTALLED=@in_NUM_OF_SYSTEM_INSTALLED,PRICE=@in_PRICE,WARRANTY_PERIOD=@in_WARRANTY_PERIOD,WARRANTY_EXPIRE_DATE=@in_WARRANTY_EXPIRE_DATE 
	WHERE ORDERS_ID=@p_ORDERS_ID AND PRODUCT_ID=@p_PRODUCT_ID

END
GO

IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'sp_updateStatus_ORDERS')AND type in (N'P', N'PC'))
DROP PROCEDURE sp_updateStatus_ORDERS
GO

 CREATE PROCEDURE sp_updateStatus_ORDERS

@p_ID int,
@in_STATUS_ID int
AS
BEGIN

	UPDATE [dbo].ORDERS SET STATUS_ID=@in_STATUS_ID
	WHERE ID=@p_ID

END
GO

IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'sp_updateStatus_COMPLAIN')AND type in (N'P', N'PC'))
DROP PROCEDURE sp_updateStatus_COMPLAIN
GO

 CREATE PROCEDURE sp_updateStatus_COMPLAIN

@p_ID int,
@in_STATUS_ID int,
@in_isCharge int
AS
BEGIN

	UPDATE [dbo].COMPLAIN SET IS_CHARGEABLE=@in_isCharge,STATUS_ID=@in_STATUS_ID
	WHERE ID=@p_ID

END
GO

IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'sp_insert_ORDERS')AND type in (N'P', N'PC'))
DROP PROCEDURE sp_insert_ORDERS
GO

 CREATE PROCEDURE sp_insert_ORDERS

@in_CLIENT_ID int,
@in_ACCOUNT_ID int,
@in_TOTAL_PRICE int,
@in_DATE_OF_ORDER date,
@in_DATE_OF_SYSTEM_INSTALLED date,
@in_DATE_OF_COMPLETE date,
@in_STATUS_ID int ,
@outValue int output 
AS
BEGIN

	Insert into ORDERS (CLIENT_ID,ACCOUNT_ID,TOTAL_PRICE,DATE_OF_ORDER,DATE_OF_SYSTEM_INSTALLED,DATE_OF_COMPLETE,STATUS_ID)
	OUTPUT @outValue=INSERTED.ID
	values(@in_CLIENT_ID,@in_ACCOUNT_ID,@in_TOTAL_PRICE,@in_DATE_OF_ORDER,@in_DATE_OF_SYSTEM_INSTALLED,@in_DATE_OF_COMPLETE,@in_STATUS_ID)

END
GO




IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'sp_update_ORDERS')AND type in (N'P', N'PC'))
DROP PROCEDURE sp_update_ORDERS
GO

 CREATE PROCEDURE sp_update_ORDERS

@in_CLIENT_ID int,
@in_ACCOUNT_ID int,
@in_TOTAL_PRICE int,
@in_DATE_OF_ORDER date,
@in_DATE_OF_SYSTEM_INSTALLED date,
@in_DATE_OF_COMPLETE date,
@in_STATUS_ID int ,
@p_ID int,
@p_CLIENT_ID int,
@p_ACCOUNT_ID int,
@p_TOTAL_PRICE int,
@p_DATE_OF_ORDER date,
@p_DATE_OF_SYSTEM_INSTALLED date,
@p_DATE_OF_COMPLETE date,
@p_STATUS_ID int 
AS
BEGIN

	UPDATE [dbo].ORDERS SET CLIENT_ID=@in_CLIENT_ID,ACCOUNT_ID=@in_ACCOUNT_ID,TOTAL_PRICE=@in_TOTAL_PRICE,DATE_OF_ORDER=@in_DATE_OF_ORDER,DATE_OF_SYSTEM_INSTALLED=@in_DATE_OF_SYSTEM_INSTALLED,DATE_OF_COMPLETE=@in_DATE_OF_COMPLETE,STATUS_ID=@in_STATUS_ID 
	WHERE ID=@p_ID AND CLIENT_ID=@p_CLIENT_ID AND ACCOUNT_ID=@p_ACCOUNT_ID AND TOTAL_PRICE=@p_TOTAL_PRICE AND DATE_OF_ORDER=@p_DATE_OF_ORDER AND DATE_OF_SYSTEM_INSTALLED=@p_DATE_OF_SYSTEM_INSTALLED AND DATE_OF_COMPLETE=@p_DATE_OF_COMPLETE AND STATUS_ID=@p_STATUS_ID

END
GO

IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'sp_insert_COMPLAIN')AND type in (N'P', N'PC'))
DROP PROCEDURE sp_insert_COMPLAIN
GO

 CREATE PROCEDURE sp_insert_COMPLAIN

@in_ORDER_ID int,
@in_ACCOUNT_ID int,
@in_IS_CHARGEABLE bit,
@in_PROBLEM varchar(250),
@in_DATE_COMPLAIN date,
@in_STATUS_ID int,
@in_TECHNICIAN_PERSON varchar(250)  
AS
BEGIN

	Insert into COMPLAIN (ORDER_ID,ACCOUNT_ID,IS_CHARGEABLE,PROBLEM,DATE_COMPLAIN,STATUS_ID,TECHNICIAN_PERSON)
	values(@in_ORDER_ID,@in_ACCOUNT_ID,@in_IS_CHARGEABLE,@in_PROBLEM,@in_DATE_COMPLAIN,@in_STATUS_ID,@in_TECHNICIAN_PERSON)

END
GO
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'sp_GetLogin')AND type in (N'P', N'PC'))
DROP PROCEDURE sp_GetLogin
GO
create procedure sp_GetLogin(@username varchar(100) ,@password varchar(100),@count int out)
as
begin
	set @count = (select count(*) from [dbo].ACCOUNT where USERNAME = @username and PASSWORD = @password)
	return @count
end 
go

IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'sp_update_COMPLAIN')AND type in (N'P', N'PC'))
DROP PROCEDURE sp_update_COMPLAIN
GO

 CREATE PROCEDURE sp_update_COMPLAIN

@in_ORDER_ID int,
@in_ACCOUNT_ID int,
@in_IS_CHARGEABLE bit,
@in_PROBLEM varchar(250),
@in_DATE_COMPLAIN date,
@in_STATUS_ID int,
@in_TECHNICIAN_PERSON varchar(250) ,
@p_ID int,
@p_ORDER_ID int,
@p_ACCOUNT_ID int,
@p_IS_CHARGEABLE bit,
@p_PROBLEM varchar(250),
@p_DATE_COMPLAIN date,
@p_STATUS_ID int,
@p_TECHNICIAN_PERSON varchar(250) 
AS
BEGIN

	UPDATE [dbo].COMPLAIN SET ORDER_ID=@in_ORDER_ID,ACCOUNT_ID=@in_ACCOUNT_ID,IS_CHARGEABLE=@in_IS_CHARGEABLE,PROBLEM=@in_PROBLEM,DATE_COMPLAIN=@in_DATE_COMPLAIN,STATUS_ID=@in_STATUS_ID,TECHNICIAN_PERSON=@in_TECHNICIAN_PERSON 
	WHERE ID=@p_ID AND ORDER_ID=@p_ORDER_ID AND ACCOUNT_ID=@p_ACCOUNT_ID AND IS_CHARGEABLE=@p_IS_CHARGEABLE AND PROBLEM=@p_PROBLEM AND DATE_COMPLAIN=@p_DATE_COMPLAIN AND STATUS_ID=@p_STATUS_ID AND TECHNICIAN_PERSON=@p_TECHNICIAN_PERSON

END
GO

IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'sp_find_Department_by_id')AND type in (N'P', N'PC'))
DROP PROCEDURE sp_find_Department_by_id
GO

CREATE PROCEDURE sp_find_Department_by_id
@ID int

AS
BEGIN
SELECT * FROM [dbo].DEPARTMENT
WHERE ID = @ID

END
GO

IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'sp_find_Complain_by_id')AND type in (N'P', N'PC'))
DROP PROCEDURE sp_find_Complain_by_id
GO

CREATE PROCEDURE sp_find_Complain_by_id
@ID int

AS
BEGIN
SELECT * FROM [dbo].COMPLAIN
WHERE ID = @ID

END
GO

CREATE PROCEDURE sp_find_ACCOUNT_by_Username
@Username varchar(100)

AS
BEGIN
SELECT * FROM [dbo].ACCOUNT
WHERE USERNAME = @Username

END
GO

IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'sp_find_ACCOUNT_by_id')AND type in (N'P', N'PC'))
DROP PROCEDURE sp_find_ACCOUNT_by_id
GO

CREATE PROCEDURE sp_find_ACCOUNT_by_id
@ID int

AS
BEGIN
SELECT * FROM [dbo].ACCOUNT
WHERE ID = @ID

END
GO



CREATE PROCEDURE sp_find_CLIENT_by_id
@ID int

AS
BEGIN
SELECT * FROM [dbo].CLIENT
WHERE ID = @ID

END
GO

IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'sp_find_Order_Detail_by_id')AND type in (N'P', N'PC'))
DROP PROCEDURE sp_find_Order_Detail_by_id
GO
CREATE PROCEDURE sp_find_Order_Detail_by_id
@ID int

AS
BEGIN
SELECT * FROM [dbo].ORDER_DETAIL
WHERE ORDERS_ID = @ID

END
GO

IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'sp_find_Product_by_id')AND type in (N'P', N'PC'))
DROP PROCEDURE sp_find_Product_by_id
GO
CREATE PROCEDURE sp_find_Product_by_id
@ID int

AS
BEGIN
SELECT * FROM [dbo].PRODUCT_ELEVATION
WHERE ID = @ID

END
GO


IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'sp_findName_Product_by_id')AND type in (N'P', N'PC'))
DROP PROCEDURE sp_findName_Product_by_id
GO
CREATE PROCEDURE sp_findName_Product_by_id
@ID int

AS
BEGIN
SELECT NAME FROM [dbo].PRODUCT_ELEVATION
WHERE ID = @ID

END
GO

IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'sp_findName_Department_by_id')AND type in (N'P', N'PC'))
DROP PROCEDURE sp_findName_Department_by_id
GO
CREATE PROCEDURE sp_findName_Department_by_id
@ID int

AS
BEGIN
SELECT NAME FROM [dbo].DEPARTMENT
WHERE ID = @ID

END
GO

IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'sp_findName_STATUS_COMPLAIN_by_id')AND type in (N'P', N'PC'))
DROP PROCEDURE sp_findName_STATUS_COMPLAIN_by_id
GO
CREATE PROCEDURE sp_findName_STATUS_COMPLAIN_by_id
@ID int

AS
BEGIN
SELECT NAME FROM [dbo].STATUS_COMPLAIN
WHERE ID = @ID

END
GO

IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'sp_findName_STATUS_ORDERNAME_by_id')AND type in (N'P', N'PC'))
DROP PROCEDURE sp_findName_STATUS_ORDERNAME_by_id
GO
CREATE PROCEDURE sp_findName_STATUS_ORDERNAME_by_id
@ID int

AS
BEGIN
SELECT NAME FROM [dbo].STATUS_ORDER
WHERE ID = @ID

END
GO

IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'sp_delete_ACCOUNT_by_id')AND type in (N'P', N'PC'))
DROP PROCEDURE sp_delete_ACCOUNT_by_id
GO

CREATE PROCEDURE sp_delete_ACCOUNT_by_id
@ID int

AS
BEGIN
DELETE FROM [dbo].ACCOUNT
WHERE ID = @ID

END
GO

IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'sp_delete_StatusOrder_by_id')AND type in (N'P', N'PC'))
DROP PROCEDURE sp_delete_StatusOrder_by_id
GO

CREATE PROCEDURE sp_delete_StatusOrder_by_id
@ID int

AS
BEGIN
DELETE FROM [dbo].STATUS_ORDER
WHERE ID = @ID

END
GO

IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'sp_delete_Role_by_id')AND type in (N'P', N'PC'))
DROP PROCEDURE sp_delete_Role_by_id
GO

CREATE PROCEDURE sp_delete_Role_by_id
@ID int

AS
BEGIN
DELETE FROM [dbo].ROLE
WHERE ID = @ID

END
GO

IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'sp_delete_StatusComplain_by_id')AND type in (N'P', N'PC'))
DROP PROCEDURE sp_delete_StatusComplain_by_id
GO

CREATE PROCEDURE sp_delete_StatusComplain_by_id
@ID int

AS
BEGIN
DELETE FROM [dbo].STATUS_COMPLAIN
WHERE ID = @ID

END
GO

IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'sp_delete_Department_by_id')AND type in (N'P', N'PC'))
DROP PROCEDURE sp_delete_Department_by_id
GO

CREATE PROCEDURE sp_delete_Department_by_id
@ID int

AS
BEGIN
DELETE FROM [dbo].DEPARTMENT
WHERE ID = @ID

END
GO

IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'sp_delete_OrderDetail_by_Order_id')AND type in (N'P', N'PC'))
DROP PROCEDURE sp_delete_OrderDetail_by_Order_id
GO

CREATE PROCEDURE sp_delete_OrderDetail_by_Order_id
@ORDERS_ID int

AS
BEGIN
DELETE FROM [dbo].ORDER_DETAIL
WHERE ORDERS_ID = @ORDERS_ID

END
GO
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'sp_delete_Product_Elevation_by_id')AND type in (N'P', N'PC'))
DROP PROCEDURE sp_delete_Product_Elevation_by_id
GO

CREATE PROCEDURE sp_delete_Product_Elevation_by_id
@ID int

AS
BEGIN
DELETE FROM [dbo].PRODUCT_ELEVATION
WHERE ID = @ID

END
GO

IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'sp_delete_CLIENT_by_id')AND type in (N'P', N'PC'))
DROP PROCEDURE sp_delete_CLIENT_by_id
GO

CREATE PROCEDURE sp_delete_CLIENT_by_id
@ID int

AS
BEGIN
DELETE FROM [dbo].CLIENT
WHERE ID = @ID

END
GO

IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'sp_getLastID_Orders')AND type in (N'P', N'PC'))
DROP PROCEDURE sp_getLastID_Orders
GO

CREATE PROCEDURE sp_getLastID_Orders
@ID int

AS
BEGIN
SELECT MAX(ID) FROM FROM [dbo].ORDERS
END
GO




