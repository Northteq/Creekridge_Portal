create index IX_B4C9CC50 on eCreekRidge_CreditApp (creditAppId);
create index IX_56FBE922 on eCreekRidge_CreditApp (creditAppStatusId);

create index IX_EF07967B on eCreekRidge_CreditAppBankReference (creditAppId);
create index IX_EEFE44F6 on eCreekRidge_CreditAppBankReference (sequenceNumber);

create index IX_C2F626B5 on eCreekRidge_CreditAppDocument (creditAppId);
create index IX_ADE0127C on eCreekRidge_CreditAppDocument (sequenceNumber);

create index IX_C32C535C on eCreekRidge_CreditAppPrincipal (creditAppId);
create index IX_6A712822 on eCreekRidge_CreditAppPrincipal (principalId);
create index IX_4E365075 on eCreekRidge_CreditAppPrincipal (sequenceNumber);

create unique index IX_13CEFAC0 on eCreekRidge_CreditAppStatus (creditAppStatusName);

create index IX_2F82B5B0 on eCreekRidge_Product (productId);

create index IX_9301C25B on eCreekRidge_ProposalOption (creditAppId);
create index IX_FD49EBAE on eCreekRidge_ProposalOption (proposalOptionId);

create index IX_FD38944C on eCreekRidge_PurchaseOption (purchaseOptionId);
create unique index IX_99E231FC on eCreekRidge_PurchaseOption (purchaseOptionName);

create unique index IX_8E4796B6 on eCreekRidge_RateFactorRule (active_, vendorId, productId);
create unique index IX_6A940E7B on eCreekRidge_RateFactorRule (active_, vendorId, productId, purchaseOptionId);
create unique index IX_B9CDF552 on eCreekRidge_RateFactorRule (active_, vendorId, productId, termId, purchaseOptioId);
create unique index IX_81EEB016 on eCreekRidge_RateFactorRule (active_, vendorId, productId, termId, purchaseOptionId);
create index IX_A1D46776 on eCreekRidge_RateFactorRule (rateFactorRuleId);
create index IX_ACEDFE53 on eCreekRidge_RateFactorRule (vendorId);
create index IX_A6DEDE16 on eCreekRidge_RateFactorRule (vendorId, active_);

create index IX_BFB875F8 on eCreekRidge_Term (termId);

create index IX_6AD4FF11 on eCreekRidge_Vendor (groupId);
create index IX_CDF54530 on eCreekRidge_Vendor (vendorId);

create index IX_49190AEE on eCreekRidge_VendorMessage (key_);