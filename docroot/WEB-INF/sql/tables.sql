create table eCreekRidge_CreditApp (
	creditAppId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	vendorId LONG,
	creditAppStatusId LONG,
	productId LONG,
	termId LONG,
	purchaseOptionId LONG,
	rateFactorRuleId LONG,
	paymentAmount DOUBLE,
	equipmentPrice DOUBLE,
	equipmentDesc VARCHAR(75) null,
	equipmentLocAsCustomerFlag BOOLEAN,
	equipmentAddress1 VARCHAR(75) null,
	equipmentAddress2 VARCHAR(75) null,
	equipmentCity VARCHAR(75) null,
	equipmentState VARCHAR(75) null,
	equipmentZip VARCHAR(75) null,
	CustomerName VARCHAR(75) null,
	CustomerDBAName VARCHAR(75) null,
	CustomerAddress1 VARCHAR(75) null,
	CustomerAddress2 VARCHAR(75) null,
	CustomerCity VARCHAR(75) null,
	CustomerState VARCHAR(75) null,
	CustomerZip VARCHAR(75) null,
	CustomerContact VARCHAR(75) null,
	CustomerContactPhone VARCHAR(75) null,
	CustomerContactFax VARCHAR(75) null,
	CustomerContactEmail VARCHAR(75) null,
	CustomerBusinessDesc VARCHAR(75) null,
	CustomerBusinessType VARCHAR(75) null,
	CustomerBusinessStartDate DATE null,
	CustomerBusinessIncorporatedState VARCHAR(75) null,
	CustomerBusinessFederalTaxID VARCHAR(75) null
);

create table eCreekRidge_CreditAppBankReference (
	bankReferenceId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	creditAppId LONG,
	sequenceNumber LONG,
	bankReferenceName VARCHAR(75) null,
	bankReferenceContact VARCHAR(75) null,
	bankReferencePhone VARCHAR(75) null,
	bankReferencAccountType VARCHAR(75) null,
	bankReferenceAccountNumber VARCHAR(75) null
);

create table eCreekRidge_CreditAppDocument (
	CreditAppDocumentId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	creditAppId LONG,
	sequenceNumber LONG,
	documentTitle VARCHAR(75) null,
	documentFileName VARCHAR(75) null,
	documentFileLocation VARCHAR(75) null
);

create table eCreekRidge_CreditAppPrincipal (
	principalId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	creditAppId LONG,
	sequenceNumber LONG,
	principalFirstName VARCHAR(75) null,
	principalMiddleName VARCHAR(75) null,
	principalLastName VARCHAR(75) null,
	principalSSN VARCHAR(75) null,
	principalHomePhoneNumber VARCHAR(75) null,
	principalAddress1 VARCHAR(75) null,
	principalAddress2 VARCHAR(75) null,
	principalCity VARCHAR(75) null,
	principalState VARCHAR(75) null,
	principalZip VARCHAR(75) null,
	principalEmail VARCHAR(75) null
);

create table eCreekRidge_CreditAppStatus (
	CreditAppStatusId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	creditAppStatusName VARCHAR(75) null
);

create table eCreekRidge_Product (
	productId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	productName VARCHAR(75) null,
	sequenceNumber LONG
);

create table eCreekRidge_ProposalOption (
	proposalOptionId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	creditAppId LONG,
	productId LONG,
	termId LONG,
	purchaseOptionId LONG,
	rateFactorRuleId LONG,
	paymentAmount DOUBLE,
	equipmentPrice DOUBLE,
	includeInProposal BOOLEAN
);

create table eCreekRidge_PurchaseOption (
	purchaseOptionId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	purchaseOptionName VARCHAR(75) null,
	sequenceNumber LONG
);

create table eCreekRidge_RateFactorRule (
	rateFactorRuleId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	productId LONG,
	termId LONG,
	purchaseOptionId LONG,
	vendorId LONG,
	minPrice DOUBLE,
	rateFactor DOUBLE,
	effectiveDate DATE null,
	active_ BOOLEAN,
	expirationDate DATE null
);

create table eCreekRidge_Term (
	termId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	termMonths LONG,
	termName VARCHAR(75) null,
	sequenceNumber LONG
);

create table eCreekRidge_Vendor (
	vendorId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	groupId LONG,
	multiSelectProduct BOOLEAN,
	multiSelectPurchaseOption BOOLEAN,
	multiSelectTerm BOOLEAN
);

create table eCreekRidge_VendorMessage (
	vendorId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	key_ VARCHAR(75) null,
	value VARCHAR(75) null
);