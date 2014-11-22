 SET @vendorID = 11607;
-- SET @vendorID = 12201;
DELETE FROM eCreekRidge_CreditApp;
DELETE FROM eCreekRidge_CreditAppBankReference;
DELETE FROM eCreekRidge_CreditAppDocument;
DELETE FROM eCreekRidge_CreditAppPrincipal;
DELETE FROM eCreekRidge_CreditAppStatus;
DELETE FROM eCreekRidge_ProposalOption; 
DELETE FROM eCreekRidge_PurchaseOption;
DELETE FROM eCreekRidge_RateFactorRule;
DELETE FROM eCreekRidge_Product;
DELETE FROM eCreekRidge_Term; 
DELETE FROM eCreekRidge_Vendor; 


INSERT INTO eCreekRidge_Vendor (
   vendorId
      ,companyId
      ,userId
      ,userName
      ,createDate
      ,modifiedDate
      ,groupId
      ,multiSelectProduct
      ,multiSelectPurchaseOption
      ,multiSelectTerm)
        VALUES (10204, 10157, 10201, 'test', SYSDATE(), SYSDATE(), null, 1, 1, 1);

-- Status

  INSERT INTO eCreekRidge_CreditAppStatus (CreditAppStatusId
      ,companyId
      ,userId
      ,userName
      ,createDate
      ,modifiedDate
      ,creditAppStatusName) VALUES
          (1, 10157, 10201, 'test', SYSDATE(), SYSDATE(), 'Draft');

INSERT INTO eCreekRidge_CreditAppStatus (CreditAppStatusId
      ,companyId
      ,userId
      ,userName
      ,createDate
      ,modifiedDate
      ,creditAppStatusName) VALUES
          (2, 10157, 10201, 'test', SYSDATE(), SYSDATE(), 'Saved');

INSERT INTO eCreekRidge_CreditAppStatus (CreditAppStatusId
      ,companyId
      ,userId
      ,userName
      ,createDate
      ,modifiedDate
      ,creditAppStatusName) VALUES
          (3, 10157, 10201, 'test', SYSDATE(), SYSDATE(), 'Submitted');

INSERT INTO eCreekRidge_CreditAppStatus (CreditAppStatusId
      ,companyId
      ,userId
      ,userName
      ,createDate
      ,modifiedDate
      ,creditAppStatusName) VALUES
          (4, 10157, 10201, 'test', SYSDATE(), SYSDATE(), 'Cancelled');

-- Product
INSERT eCreekRidge_Product (productId, companyId, userId, userName, createDate, modifiedDate, productName, sequenceNumber) VALUES (501, 10157, NULL, NULL, NULL, NULL, N'Financed Lease', 1);

INSERT eCreekRidge_Product (productId, companyId, userId, userName, createDate, modifiedDate, productName, sequenceNumber) VALUES (502, 10157, NULL, NULL, NULL, NULL, N'0% for 6 months', 2);

INSERT eCreekRidge_Product (productId, companyId, userId, userName, createDate, modifiedDate, productName, sequenceNumber) VALUES (503, 10157, NULL, NULL, NULL, NULL, N'Loan', 3);


-- Purchase Options
INSERT INTO eCreekRidge_PurchaseOption (purchaseOptionId, companyId, userId, userName, createDate, modifiedDate, purchaseOptionName, sequenceNumber)
        VALUES (101,10157, 10201, 'test', SYSDATE(),  SYSDATE(), 'FMV', 1);
        
INSERT INTO eCreekRidge_PurchaseOption (purchaseOptionId, companyId, userId, userName, createDate, modifiedDate, purchaseOptionName, sequenceNumber)
        VALUES (102,10157, 10201, 'test', SYSDATE(),  SYSDATE(), '25% Purchase Option', 2);

INSERT INTO eCreekRidge_PurchaseOption (purchaseOptionId, companyId, userId, userName, createDate, modifiedDate, purchaseOptionName, sequenceNumber)
        VALUES (103,10157, 10201, 'test', SYSDATE(),  SYSDATE(), '$1 Out', 3);


-- Term
INSERT eCreekRidge_Term (termId, companyId, userId, userName, createDate, modifiedDate, termMonths, termName, sequenceNumber) VALUES (101, 10157, NULL, NULL, NULL, NULL, 24, N'24 mo', NULL);

INSERT eCreekRidge_Term (termId, companyId, userId, userName, createDate, modifiedDate, termMonths, termName, sequenceNumber) VALUES (102, 10157, NULL, NULL, NULL, NULL, 36, N'36 mo', NULL);

INSERT eCreekRidge_Term (termId, companyId, userId, userName, createDate, modifiedDate, termMonths, termName, sequenceNumber) VALUES (103, 10157, NULL, NULL, NULL, NULL, 48, N'48 mo', NULL);

INSERT eCreekRidge_Term (termId, companyId, userId, userName, createDate, modifiedDate, termMonths, termName, sequenceNumber) VALUES (104, 10157, NULL, NULL, NULL, NULL, 60, N'60 mo', NULL);

INSERT eCreekRidge_Term (termId, companyId, userId, userName, createDate, modifiedDate, termMonths, termName, sequenceNumber) VALUES (105, 10157, NULL, NULL, NULL, NULL, 72, N'72 mo', NULL);


-- Rate Factor Rule

INSERT INTO eCreekRidge_RateFactorRule (
           rateFactorRuleId ,companyId,userId ,userName ,createDate ,modifiedDate ,productId ,termId ,purchaseOptionId ,vendorId
      ,minPrice
      ,rateFactor
      ,effectiveDate
      ,active_
      ,expirationDate) VALUES
		(1, 10157, 10201, 'test', SYSDATE(), SYSDATE(), 501, 101, 101, @vendorID, 0, .005, str_to_date("03/02/2009","%d/%m/%Y"), 1, str_to_date("03/02/2009","%d/%m/%Y"));

INSERT INTO eCreekRidge_RateFactorRule ( rateFactorRuleId ,companyId,userId ,userName ,createDate ,modifiedDate ,productId ,termId ,purchaseOptionId ,vendorId
      ,minPrice
      ,rateFactor
      ,effectiveDate
      ,active_
      ,expirationDate) VALUES
		(2, 10157, 10201, 'test', SYSDATE(), SYSDATE(), 0, 0, 0, @vendorID, 0, .005, str_to_date("03/02/2009","%d/%m/%Y"), 1,str_to_date("03/02/2015","%d/%m/%Y"));
        
INSERT INTO eCreekRidge_RateFactorRule (
                   rateFactorRuleId 
                   ,companyId
                   ,userId 
                   ,userName 
                   ,createDate 
                   ,modifiedDate 
                   ,productId 
                   ,termId 
                   ,purchaseOptionId 
                   ,vendorId
              ,minPrice
              ,rateFactor
              ,effectiveDate
              ,active_
              ,expirationDate) VALUES
		(3, 10157, 10201, 'test', SYSDATE(), SYSDATE(), 502, 102, 102, @vendorID, 0, .005, str_to_date("03/02/2009","%d/%m/%Y"), 1, str_to_date("03/02/2015","%d/%m/%Y"));
    
INSERT INTO eCreekRidge_RateFactorRule (
           rateFactorRuleId ,companyId,userId ,userName ,createDate ,modifiedDate ,productId ,termId ,purchaseOptionId ,vendorId
      ,minPrice
      ,rateFactor
      ,effectiveDate
      ,active_
      ,expirationDate) VALUES
		(4, 10157, 10201, 'test', SYSDATE(), SYSDATE(), 503, 103, 103, @vendorID, 0, .005, str_to_date("03/02/2009","%d/%m/%Y"), 1, str_to_date("03/02/2009","%d/%m/%Y"));

INSERT INTO eCreekRidge_RateFactorRule (
           rateFactorRuleId ,companyId,userId ,userName ,createDate ,modifiedDate ,productId ,termId ,purchaseOptionId ,vendorId
      ,minPrice
      ,rateFactor
      ,effectiveDate
      ,active_
      ,expirationDate) VALUES
		(5, 10157, 10201, 'test', SYSDATE(), SYSDATE(), 501, 101, 101, @vendorID, 0, .004, str_to_date("03/02/2009","%d/%m/%Y"), 1, str_to_date("03/02/2009","%d/%m/%Y"));
