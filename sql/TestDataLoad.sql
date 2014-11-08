--set your vendorID variable by finding the groupID in the Group_ table for the site you have in your local environment
declare @vendorID int
set @vendorID = '12106'

Delete dbo.eCreekRidge_CreditApp
DELETE dbo.eCreekRidge_CreditAppBankReference
DELETE dbo.eCreekRidge_CreditAppDocument
DELETE dbo.eCreekRidge_CreditAppPrincipal
DELETE dbo.eCreekRidge_CreditAppStatus
DELETE dbo.eCreekRidge_ProposalOption
DELETE dbo.eCreekRidge_PurchaseOption
DELETE dbo.eCreekRidge_RateFactorRule
DELETE dbo.eCreekRidge_Product;
DELETE dbo.eCreekRidge_Term
DELETE dbo.eCreekridge_PurchaseOption
DELETE dbo.eCreekridge_Vendor


INSERT INTO .[dbo].[eCreekRidge_Vendor] (
   [vendorId]
      ,[companyId]
      ,[userId]
      ,[userName]
      ,[createDate]
      ,[modifiedDate]
      ,[groupId]
      ,[multiSelectProduct]
      ,[multiSelectPurchaseOption]
      ,[multiSelectTerm])
	VALUES (@vendorID, 10157, 10201, 'test', SYSDATETIME(), SYSDATETIME(), null, 1, 1, 1)



--Status

  INSERT INTO [dbo].[eCreekRidge_CreditAppStatus] ([CreditAppStatusId]
      ,[companyId]
      ,[userId]
      ,[userName]
      ,[createDate]
      ,[modifiedDate]
      ,[creditAppStatusName]) VALUES
	  (1, 10157, 10201, 'test', SYSDATETIME(), SYSDATETIME(), 'Draft')

INSERT INTO [dbo].[eCreekRidge_CreditAppStatus] ([CreditAppStatusId]
      ,[companyId]
      ,[userId]
      ,[userName]
      ,[createDate]
      ,[modifiedDate]
      ,[creditAppStatusName]) VALUES
	  (2, 10157, 10201, 'test', SYSDATETIME(), SYSDATETIME(), 'Saved')

INSERT INTO [dbo].[eCreekRidge_CreditAppStatus] ([CreditAppStatusId]
      ,[companyId]
      ,[userId]
      ,[userName]
      ,[createDate]
      ,[modifiedDate]
      ,[creditAppStatusName]) VALUES
	  (3, 10157, 10201, 'test', SYSDATETIME(), SYSDATETIME(), 'Submitted')
INSERT INTO [dbo].[eCreekRidge_CreditAppStatus] ([CreditAppStatusId]
      ,[companyId]
      ,[userId]
      ,[userName]
      ,[createDate]
      ,[modifiedDate]
      ,[creditAppStatusName]) VALUES
	  (4, 10157, 10201, 'test', SYSDATETIME(), SYSDATETIME(), 'Cancelled')

-- 

---- Purchase Options

  INSERT INTO dbo.eCreekRidge_PurchaseOption (purchaseOptionId, companyId, userId, userName, createDate, modifiedDate, purchaseOptionName, sequenceNumber)
	VALUES (101,10157, 10201, 'test', SYSDATETIME(),  SYSDATETIME(), 'FMV',	1)
	
INSERT INTO dbo.eCreekRidge_PurchaseOption (purchaseOptionId, companyId, userId, userName, createDate, modifiedDate, purchaseOptionName, sequenceNumber)
	VALUES (102,10157, 10201, 'test', SYSDATETIME(),  SYSDATETIME(), '25% Purchase Option',	2)

  INSERT INTO dbo.eCreekRidge_PurchaseOption (purchaseOptionId, companyId, userId, userName, createDate, modifiedDate, purchaseOptionName, sequenceNumber)
	VALUES (103,10157, 10201, 'test', SYSDATETIME(),  SYSDATETIME(), '$1 Out',	3)

-- Product
INSERT [dbo].[eCreekRidge_Product] ([productId], [companyId], [userId], [userName], [createDate], [modifiedDate], [productName], [sequenceNumber]) VALUES (501, 10157, NULL, NULL, NULL, NULL, N'Financed Lease', 1)

INSERT [dbo].[eCreekRidge_Product] ([productId], [companyId], [userId], [userName], [createDate], [modifiedDate], [productName], [sequenceNumber]) VALUES (502, 10157, NULL, NULL, NULL, NULL, N'0% for 6 months', 2)

INSERT [dbo].[eCreekRidge_Product] ([productId], [companyId], [userId], [userName], [createDate], [modifiedDate], [productName], [sequenceNumber]) VALUES (503, 10157, NULL, NULL, NULL, NULL, N'Loan', 3)


-- Term


INSERT [dbo].[eCreekRidge_Term] ([termId], [companyId], [userId], [userName], [createDate], [modifiedDate], [termMonths], [termName], [sequenceNumber]) VALUES (101, 10157, NULL, NULL, NULL, NULL, 24, N'24 mo', NULL)

INSERT [dbo].[eCreekRidge_Term] ([termId], [companyId], [userId], [userName], [createDate], [modifiedDate], [termMonths], [termName], [sequenceNumber]) VALUES (102, 10157, NULL, NULL, NULL, NULL, 36, N'36 mo', NULL)

INSERT [dbo].[eCreekRidge_Term] ([termId], [companyId], [userId], [userName], [createDate], [modifiedDate], [termMonths], [termName], [sequenceNumber]) VALUES (103, 10157, NULL, NULL, NULL, NULL, 48, N'48 mo', NULL)

INSERT [dbo].[eCreekRidge_Term] ([termId], [companyId], [userId], [userName], [createDate], [modifiedDate], [termMonths], [termName], [sequenceNumber]) VALUES (104, 10157, NULL, NULL, NULL, NULL, 60, N'60 mo', NULL)

INSERT [dbo].[eCreekRidge_Term] ([termId], [companyId], [userId], [userName], [createDate], [modifiedDate], [termMonths], [termName], [sequenceNumber]) VALUES (105, 10157, NULL, NULL, NULL, NULL, 72, N'72 mo', NULL)


-- Rate Factor Rule

INSERT INTO [dbo].[eCreekRidge_RateFactorRule] (
	   [rateFactorRuleId] ,[companyId],[userId] ,[userName] ,[createDate] ,[modifiedDate] ,[productId] ,[termId] ,[purchaseOptionId] ,[vendorId]
      ,[minPrice]
      ,[rateFactor]
      ,[effectiveDate]
      ,[active_]
      ,[expirationDate]) VALUES
	  (1, 10157, 10201, 'test', SYSDATETIME(), SYSDATETIME(), 501, 101, 101, @vendorID, 0, .005, DATEFROMPARTS ( 2014, 01, 01 ), 1, DATEFROMPARTS ( 2016, 01, 01 ))

--000 Rates
INSERT INTO [dbo].[eCreekRidge_RateFactorRule] ( [rateFactorRuleId] ,[companyId],[userId] ,[userName] ,[createDate] ,[modifiedDate] ,[productId] ,[termId] ,[purchaseOptionId] ,[vendorId]
      ,[minPrice]
      ,[rateFactor]
      ,[effectiveDate]
      ,[active_]
      ,[expirationDate]) VALUES
	  (3, 10157, 10201, 'test', SYSDATETIME(), SYSDATETIME(), 0, 0, 0, @vendorID, 0, .005, DATEFROMPARTS ( 2014, 01, 01 ), 1, DATEFROMPARTS ( 2016, 01, 01 ))
	
	INSERT INTO [dbo].[eCreekRidge_RateFactorRule] (
		   [rateFactorRuleId] ,[companyId],[userId] ,[userName] ,[createDate] ,[modifiedDate] ,[productId] ,[termId] ,[purchaseOptionId] ,[vendorId]
	      ,[minPrice]
	      ,[rateFactor]
	      ,[effectiveDate]
	      ,[active_]
	      ,[expirationDate]) VALUES
		  (2, 10157, 10201, 'test', SYSDATETIME(), SYSDATETIME(), 502, 102, 102, @vendorID, 0, .005, DATEFROMPARTS ( 2014, 01, 01 ), 1, DATEFROMPARTS ( 2016, 01, 01 ))
		
INSERT INTO [dbo].[eCreekRidge_RateFactorRule] (
	   [rateFactorRuleId] ,[companyId],[userId] ,[userName] ,[createDate] ,[modifiedDate] ,[productId] ,[termId] ,[purchaseOptionId] ,[vendorId]
      ,[minPrice]
      ,[rateFactor]
      ,[effectiveDate]
      ,[active_]
      ,[expirationDate]) VALUES
	  (11, 10157, 10201, 'test', SYSDATETIME(), SYSDATETIME(), 503, 103, 103, @vendorID, 0, .005, DATEFROMPARTS ( 2014, 01, 01 ), 1, DATEFROMPARTS ( 2016, 01, 01 ))

INSERT INTO [dbo].[eCreekRidge_RateFactorRule] ( [rateFactorRuleId] ,[companyId],[userId] ,[userName] ,[createDate] ,[modifiedDate] ,[productId] ,[termId] ,[purchaseOptionId] ,[vendorId]
      ,[minPrice]
      ,[rateFactor]
      ,[effectiveDate]
      ,[active_]
      ,[expirationDate]) VALUES
	  (4, 10157, 10201, 'test', SYSDATETIME(), SYSDATETIME(), 501, 102, 101, @vendorID, 0, .005, DATEFROMPARTS ( 2014, 01, 01 ), 1, DATEFROMPARTS ( 2016, 01, 01 ))
	
	INSERT INTO [dbo].[eCreekRidge_RateFactorRule] (   [rateFactorRuleId] ,[companyId],[userId] ,[userName] ,[createDate] ,[modifiedDate] ,[productId] ,[termId] ,[purchaseOptionId] ,[vendorId]
	      ,[minPrice]
	      ,[rateFactor]
	      ,[effectiveDate]
	      ,[active_]
	      ,[expirationDate]) VALUES
		  (5, 10157, 10201, 'test', SYSDATETIME(), SYSDATETIME(), 501, 103, 101, @vendorID, 0, .005, DATEFROMPARTS ( 2014, 01, 01 ), 1, DATEFROMPARTS ( 2016, 01, 01 ))
	
	INSERT INTO [dbo].[eCreekRidge_RateFactorRule] (
		   [rateFactorRuleId] ,[companyId],[userId] ,[userName] ,[createDate] ,[modifiedDate] ,[productId] ,[termId] ,[purchaseOptionId] ,[vendorId]
	      ,[minPrice]
	      ,[rateFactor]
	      ,[effectiveDate]
	      ,[active_]
	      ,[expirationDate]) VALUES
		  (6, 10157, 10201, 'test', SYSDATETIME(), SYSDATETIME(), 502, 101, 101, @vendorID, 0, .005, DATEFROMPARTS ( 2014, 01, 01 ), 1, DATEFROMPARTS ( 2016, 01, 01 ))
	
	INSERT INTO [dbo].[eCreekRidge_RateFactorRule] (
		   [rateFactorRuleId] ,[companyId],[userId] ,[userName] ,[createDate] ,[modifiedDate] ,[productId] ,[termId] ,[purchaseOptionId] ,[vendorId]
	      ,[minPrice]
	      ,[rateFactor]
	      ,[effectiveDate]
	      ,[active_]
	      ,[expirationDate]) VALUES
		  (7, 10157, 10201, 'test', SYSDATETIME(), SYSDATETIME(), 502, 102, 101, @vendorID, 0, .005, DATEFROMPARTS ( 2014, 01, 01 ), 1, DATEFROMPARTS ( 2016, 01, 01 ))
		
		INSERT INTO [dbo].[eCreekRidge_RateFactorRule] (   [rateFactorRuleId] ,[companyId],[userId] ,[userName] ,[createDate] ,[modifiedDate] ,[productId] ,[termId] ,[purchaseOptionId] ,[vendorId]
		      ,[minPrice]
		      ,[rateFactor]
		      ,[effectiveDate]
		      ,[active_]
		      ,[expirationDate]) VALUES
			  (8, 10157, 10201, 'test', SYSDATETIME(), SYSDATETIME(), 502, 103, 101, @vendorID, 0, .005, DATEFROMPARTS ( 2014, 01, 01 ), 1, DATEFROMPARTS ( 2016, 01, 01 ))
			
	INSERT INTO [dbo].[eCreekRidge_RateFactorRule] ( [rateFactorRuleId] ,[companyId],[userId] ,[userName] ,[createDate] ,[modifiedDate] ,[productId] ,[termId] ,[purchaseOptionId] ,[vendorId]
	      ,[minPrice]
	      ,[rateFactor]
	      ,[effectiveDate]
	      ,[active_]
	      ,[expirationDate]) VALUES

  (10, 10157, 10201, 'test', SYSDATETIME(), SYSDATETIME(), 502, 101, 103, @vendorID, 0, .005, DATEFROMPARTS ( 2014, 01, 01 ), 1, DATEFROMPARTS ( 2016, 01, 01 ))