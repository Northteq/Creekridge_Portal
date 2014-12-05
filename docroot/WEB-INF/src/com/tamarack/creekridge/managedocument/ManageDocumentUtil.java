/**
 * Copyright (c) 2000-present Tamarack, Inc. All rights reserved.
 * @author tamarack
 * @description Utility class for generating documents
 */

package com.tamarack.creekridge.managedocument;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.jdbc.OutputBlob;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DocumentConversionUtil;
import com.liferay.portal.model.Address;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.User;
import com.liferay.portal.service.AddressLocalServiceUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.tamarack.creekridge.model.CreditApp;
import com.tamarack.creekridge.model.CreditAppBankReference;
import com.tamarack.creekridge.model.CreditAppDocument;
import com.tamarack.creekridge.model.CreditAppPrincipal;
import com.tamarack.creekridge.model.Product;
import com.tamarack.creekridge.model.ProposalOption;
import com.tamarack.creekridge.model.PurchaseOption;
import com.tamarack.creekridge.model.Term;
import com.tamarack.creekridge.service.CreditAppBankReferenceLocalServiceUtil;
import com.tamarack.creekridge.service.CreditAppDocumentLocalServiceUtil;
import com.tamarack.creekridge.service.CreditAppLocalServiceUtil;
import com.tamarack.creekridge.service.CreditAppPrincipalLocalServiceUtil;
import com.tamarack.creekridge.service.ProductLocalServiceUtil;
import com.tamarack.creekridge.service.ProposalOptionLocalServiceUtil;
import com.tamarack.creekridge.service.PurchaseOptionLocalServiceUtil;
import com.tamarack.creekridge.service.TermLocalServiceUtil;

public class ManageDocumentUtil {
	private static Log _log = LogFactory.getLog(ManageDocumentUtil.class);
	
	public static void generateDocument(String creditAppId, long userId, String documentType, String realPath) {
		CreditApp creditApp = null;
		
		try {
			creditApp = CreditAppLocalServiceUtil.getCreditApp(Long.valueOf(creditAppId).longValue());
			String path = realPath + "html\\manageDocument\\";
			
			if (documentType.equals("creditApp")) {
				generateCreditApp(creditApp, path);
			} else if (documentType.equals("proposal")) {
				generateProposalLetter(creditApp, path);
			}
		}
		catch (PortalException pe) {
			_log.error(pe);
		}
		catch (SystemException se) {
			_log.error(se);
		}
	}
	
	private static void generateCreditApp(CreditApp creditApp, String path) {
		Scanner scanner = null;
		
		try {
			HashMap<String, Object> tokenMap = new HashMap<String, Object>();
			File file = new File(path + "CreditAppTemplate_Section1.html");
			scanner = new Scanner(file);
			String templateSection = scanner.useDelimiter("\\A").next();
			updateTokenMapCreditApp(tokenMap, creditApp);
			String generatedTemplate = replaceTokens(templateSection, tokenMap);
			scanner.close();
			
			file = new File(path + "CreditAppTemplate_Section2.html");
			scanner = new Scanner(file);
			templateSection = scanner.useDelimiter("\\A").next();
			
			List<CreditAppPrincipal> principals = CreditAppPrincipalLocalServiceUtil.getCreditAppPrincipalByCreditAppId(creditApp.getCreditAppId());
			for (CreditAppPrincipal principal : principals) {
				updateTokenMapPrincipal(tokenMap, principal);
				generatedTemplate += replaceTokens(templateSection, tokenMap);
			}
			
			if (principals.size() == 0) {
				updateTokenMapPrincipal(tokenMap, null);
				generatedTemplate += replaceTokens(templateSection, tokenMap);
			}
			
			scanner.close();
			
			file = new File(path + "CreditAppTemplate_Section3.html");
			scanner = new Scanner(file);
			templateSection = scanner.useDelimiter("\\A").next();
			generatedTemplate += replaceTokens(templateSection, tokenMap);
			scanner.close();
			
			file = new File(path + "CreditAppTemplate_Section4.html");
			scanner = new Scanner(file);
			templateSection = scanner.useDelimiter("\\A").next();
			
			List<CreditAppBankReference> bankReferences = CreditAppBankReferenceLocalServiceUtil.getCreditAppBankReferenceByCreditApp(creditApp.getCreditAppId());
			for (CreditAppBankReference bankReference : bankReferences) {
				updateTokenMapBankReference(tokenMap, bankReference);
				generatedTemplate += replaceTokens(templateSection, tokenMap);
			}
			
			if (bankReferences.size() == 0) {
				updateTokenMapBankReference(tokenMap, null);
				generatedTemplate += replaceTokens(templateSection, tokenMap);
			}
			
			scanner.close();
			
			file = new File(path + "CreditAppTemplate_Section5.html");
			scanner = new Scanner(file);
			templateSection = scanner.useDelimiter("\\A").next();
			generatedTemplate += replaceTokens(templateSection, tokenMap);
			scanner.close();
			
			file = new File(path + "CreditAppTemplate_Section6.html");
			scanner = new Scanner(file);
			templateSection= scanner.useDelimiter("\\A").next();
			
			for (CreditAppPrincipal principal : principals) {
				updateTokenMapPrincipal(tokenMap, principal);
				generatedTemplate += replaceTokens(templateSection, tokenMap);
			}
			
			if (principals.size() == 0) {
				updateTokenMapPrincipal(tokenMap, null);
				generatedTemplate += replaceTokens(templateSection, tokenMap);
			}
				
			scanner.close();
			
			File generatedFile = new File(path + "CreditApp.html");
	        FileWriter fileWriter = new FileWriter(generatedFile);
	        fileWriter.write(generatedTemplate);
	        fileWriter.close();
			
			Timestamp stamp = new Timestamp(System.currentTimeMillis());
			InputStream inputStream = new FileInputStream(generatedFile);
			File convertedFile = DocumentConversionUtil.convert(String.valueOf(stamp.getTime()), inputStream, "html", "pdf");
			saveDocument(creditApp, convertedFile, "CreditApp");
			convertedFile.delete();
		}
		catch (FileNotFoundException fnfe) {
			_log.error(fnfe);
		}
		catch (IOException ioe) {
			_log.error(ioe);
		}
		catch (Exception e) {
			_log.error(e);
		}
		finally {
			if (scanner != null)
				scanner.close();
		}
	}
	
	private static void generateProposalLetter(CreditApp creditApp, String path) {
		Scanner scanner = null;
		
		try {
			HashMap<String, Object> tokenMap = new HashMap<String, Object>();
			File file = new File(path + "ProposalLetterTemplate_Section1.html");
			scanner = new Scanner(file);
			String templateSection = scanner.useDelimiter("\\A").next();
			updateTokenMapProposalLetter(tokenMap, creditApp);
			String generatedTemplate = replaceTokens(templateSection, tokenMap);
			scanner.close();
			
			file = new File(path + "ProposalLetterTemplate_Section2.html");
			scanner = new Scanner(file);
			templateSection = scanner.useDelimiter("\\A").next();
			
			List<ProposalOption> options = ProposalOptionLocalServiceUtil.getProposalOptionByCreditAppId(creditApp.getCreditAppId());
			int counter = 0;
			for (ProposalOption option : options) {
				counter++;
				Product product = ProductLocalServiceUtil.getProduct(option.getProductId());
				PurchaseOption purchaseOption = PurchaseOptionLocalServiceUtil.getPurchaseOption(creditApp.getPurchaseOptionId());
				Term term = TermLocalServiceUtil.getTerm(creditApp.getTermId());
				updateTokenMapProposalOption(tokenMap, option, product, purchaseOption, term, counter + "");
				generatedTemplate += replaceTokens(templateSection, tokenMap);
			}
			
			if (options.size() == 0) {
				updateTokenMapProposalOption(tokenMap, null, null, null, null, counter + "");
				generatedTemplate += replaceTokens(templateSection, tokenMap);
			}
			
			scanner.close();
			
			file = new File(path + "ProposalLetterTemplate_Section3.html");
			scanner = new Scanner(file);
			templateSection = scanner.useDelimiter("\\A").next();
			generatedTemplate += replaceTokens(templateSection, tokenMap);
			scanner.close();
			
			File generatedFile = new File(path + "ProposalLetter.html");
	        FileWriter fileWriter = new FileWriter(generatedFile);
	        fileWriter.write(generatedTemplate);
	        fileWriter.close();
			
			Timestamp stamp = new Timestamp(System.currentTimeMillis());
			InputStream inputStream = new FileInputStream(generatedFile);
			File convertedFile = DocumentConversionUtil.convert(String.valueOf(stamp.getTime()), inputStream, "html", "pdf");
			saveDocument(creditApp, convertedFile, "Proposal");
			convertedFile.delete();
		}
		catch (FileNotFoundException fnfe) {
			_log.error(fnfe);
		}
		catch (IOException ioe) {
			_log.error(ioe);
		}
		catch (Exception e) {
			_log.error(e);
		}
		finally {
			if (scanner != null)
				scanner.close();
		}
	}
	
	private static void updateTokenMapCreditApp(HashMap<String, Object> tokenMap, CreditApp creditApp) {
		tokenMap.putAll(creditApp.getModelAttributes());
		tokenMap.put("customerName", creditApp.getCustomerName());
		tokenMap.put("DBA", creditApp.getCustomerDBAName());
		tokenMap.put("CustomerAddressLine1", creditApp.getCustomerAddress1());
		tokenMap.put("customerAddressLine2", creditApp.getCustomerAddress2());
		tokenMap.put("customerCity", creditApp.getCustomerCity());
		tokenMap.put("customerState", creditApp.getCustomerState());
		tokenMap.put("customerZip", creditApp.getCustomerZip());
		tokenMap.put("businessFederalTaxID", creditApp.getCustomerBusinessFederalTaxID());
		tokenMap.put("businessDesc", creditApp.getCustomerBusinessDesc());
		tokenMap.put("customerContact", creditApp.getCustomerContact());
		tokenMap.put("contactPhone", creditApp.getCustomerContactPhone());
		tokenMap.put("contactFax", creditApp.getCustomerContactFax());
		tokenMap.put("contactEmail", creditApp.getCustomerContactEmail());
		tokenMap.put("businessIncorporatedState", creditApp.getCustomerBusinessIncorporatedState());
		tokenMap.put("businessType", creditApp.getCustomerBusinessType());
		tokenMap.put("equipmentDescription", creditApp.getEquipmentDesc());
		tokenMap.put("equipmentAddressLine1", creditApp.getEquipmentAddress1());
		tokenMap.put("equipmentAddressLine2", creditApp.getEquipmentAddress2());

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		tokenMap.put("businessStartDate", dateFormat.format(creditApp.getCustomerBusinessStartDate()));

		tokenMap.put("groupName", "");
		try {
			Group group = GroupLocalServiceUtil.getGroup(creditApp.getGroupId());
			tokenMap.put("groupName", group.getName());
		}
		catch (Exception e) {
			_log.error(e);
		}
		
		tokenMap.put("userFirstName", "");
		tokenMap.put("userLastName", "");
		tokenMap.put("userFirstName and userLastName", "");
		tokenMap.put("user's email address in Liferay", "");
		try {
			User user = UserLocalServiceUtil.getUser(creditApp.getUserId());
			tokenMap.put("userFirstName", user.getFirstName());
			tokenMap.put("userLastName", user.getLastName());
			tokenMap.put("userFirstName and userLastName", user.getFirstName() + " " + user.getLastName());
			tokenMap.put("user's email address in Liferay", user.getEmailAddress());
		}
		catch (Exception e) {
			_log.error(e);
		}
		
		tokenMap.put("purchaseOption", "");
		try {
			PurchaseOption purchaseOption = PurchaseOptionLocalServiceUtil.getPurchaseOption(creditApp.getPurchaseOptionId());
			tokenMap.put("purchaseOption", purchaseOption.getPurchaseOptionName());
		}
		catch (Exception e) {
			_log.error(e);
		}
		
		tokenMap.put("term", "");
		try {
			Term term = TermLocalServiceUtil.getTerm(creditApp.getTermId());
			tokenMap.put("term", term.getTermName());
		}
		catch (Exception e) {
			_log.error(e);
		}
		
		tokenMap.put("pricingProduct", "");
		try {
			Product product = ProductLocalServiceUtil.getProduct(creditApp.getProductId());
			tokenMap.put("pricingProduct", product.getProductName());
		}
		catch (Exception e) {
			_log.error(e);
		}
		
		DecimalFormat decimalFormat = new DecimalFormat("###,##0.00");
		tokenMap.put("equipmentPrice", decimalFormat.format(creditApp.getEquipmentPrice()));
		tokenMap.put("paymentAmount in decimal format", decimalFormat.format(creditApp.getPaymentAmount()));
		
	}
	
	private static void updateTokenMapPrincipal(HashMap<String, Object> tokenMap, CreditAppPrincipal principal) {
		if (principal == null) {
			tokenMap.put("principalFirstName", "");
			tokenMap.put("principalMiddleName", "");
			tokenMap.put("principalLastName", "");
			tokenMap.put("principalAddress1", "");
			tokenMap.put("principalAddress2", "");
			tokenMap.put("principalCity", "");
			tokenMap.put("principalState", "");
			tokenMap.put("principalZip", "");
			tokenMap.put("principalHomePhoneNumber", "");
			tokenMap.put("principalEmail", "");
			tokenMap.put("principalSSN", "");
		}
		else
			tokenMap.putAll(principal.getModelAttributes());
	}
	
	private static void updateTokenMapBankReference(HashMap<String, Object> tokenMap, CreditAppBankReference bankReference) {
		if (bankReference == null) {
			tokenMap.put("bankReferenceName", "");
			tokenMap.put("bankReferenceAccountNumber", "");
			tokenMap.put("bankReferenceContact", "");
			tokenMap.put("bankReferencePhone", "");
		}
		else
			tokenMap.putAll(bankReference.getModelAttributes());
	}
	
	private static void updateTokenMapProposalLetter(HashMap<String, Object> tokenMap, CreditApp creditApp) {
		tokenMap.putAll(creditApp.getModelAttributes());
		tokenMap.put("CustomerLegalName", creditApp.getCustomerName());
		tokenMap.put("CustomerAddressLine1", creditApp.getCustomerAddress1());
		tokenMap.put("CustomerAddressLine2", creditApp.getCustomerAddress2());
		tokenMap.put("City", creditApp.getCustomerCity());
		tokenMap.put("State", creditApp.getCustomerState());
		tokenMap.put("Zip", creditApp.getCustomerZip());
		tokenMap.put("EquipmentDescription", creditApp.getEquipmentDesc());

		DateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy");
		tokenMap.put("Date", dateFormat.format(new Date()));

		tokenMap.put("userID firstName", "");
		tokenMap.put("userID lastName", "");
		tokenMap.put("user FirstName", "");
		tokenMap.put("user LastName", "");
		try {
			User user = UserLocalServiceUtil.getUser(creditApp.getUserId());
			tokenMap.put("userID firstName", user.getFirstName());
			tokenMap.put("userID lastName", user.getLastName());
			tokenMap.put("user FirstName", user.getFirstName());
			tokenMap.put("user LastName", user.getLastName());
		}
		catch (Exception e) {
			_log.error(e);
		}

		tokenMap.put("VendorName", "");
		tokenMap.put("VendorAddress", "");
		tokenMap.put("VendorCity", "");
		tokenMap.put("VendorState", "");
		tokenMap.put("VendorZip", "");
		try {
			Group group = GroupLocalServiceUtil.getGroup(creditApp.getVendorId());
			tokenMap.put("VendorName", group.getName());
			
			List<Address> addresses = new ArrayList<Address>();
			addresses.add(AddressLocalServiceUtil.getAddressByUuidAndCompanyId(group.getUuid(), group.getCompanyId()));//.getAddresses(group.getCompanyId(), group.getClassName(), group.getClassPK());

			for (Address address : addresses) {
				tokenMap.put("VendorAddress", address.getStreet1() + " " + address.getStreet2());
				tokenMap.put("VendorCity", address.getCity());
				tokenMap.put("VendorState", address.getRegion().getRegionCode());
				tokenMap.put("VendorZip", address.getZip());
				break;
			}
		}
		catch (Exception e) {
			_log.error(e);
		}
		
		DecimalFormat decimalFormat = new DecimalFormat("###,##0.00");
		tokenMap.put("EquipmentPrice", decimalFormat.format(creditApp.getEquipmentPrice()));
	}
	
	private static void updateTokenMapProposalOption(HashMap<String, Object> tokenMap, ProposalOption option, Product product, PurchaseOption purchaseOption, Term term, String counter) {
		if (option == null) {
			tokenMap.put("loop iteration starting at 1", "");
			tokenMap.put("ProductName", "");
			tokenMap.put("PurchaseOptionName", "");
			tokenMap.put("TermName", "");
			tokenMap.put("Payment Amount", "");
		}
		else {
			tokenMap.put("loop iteration starting at 1", counter);
			tokenMap.put("ProductName", product.getProductName());
			tokenMap.put("PurchaseOptionName", purchaseOption.getPurchaseOptionName());
			tokenMap.put("TermName", term.getTermName());
			DecimalFormat decimalFormat = new DecimalFormat("###,##0.00");
			tokenMap.put("Payment Amount", decimalFormat.format(option.getPaymentAmount()));
		}
	}
	
	private static String replaceTokens(String text, Map<String, Object> replacements) {
		Pattern pattern = Pattern.compile("\\[(.+?)\\]");
		Matcher matcher = pattern.matcher(text);
		StringBuffer buffer = new StringBuffer();
		
		while (matcher.find()) {
			String replacement = (String)replacements.get(matcher.group(1));
			
			if (replacement != null) {
				matcher.appendReplacement(buffer, "");
				buffer.append(replacement);
			}
		}
		
		matcher.appendTail(buffer);
		return buffer.toString();
	}
	
	private static void saveDocument(CreditApp creditApp, File file, String documentType) {
		try {
			DateFormat dateFormat = new SimpleDateFormat("MMddyyyy_HHmm");
			String fileName = documentType + "_" + creditApp.getCustomerName()  + "_" +  dateFormat.format(new Date()) + ".pdf";
			InputStream fis = new FileInputStream(file);
			OutputBlob dataOutputBlob = new OutputBlob(fis, file.length());
		
			CreditAppDocument creditAppDocument = CreditAppDocumentLocalServiceUtil.createCreditAppDocument(CounterLocalServiceUtil.increment(CreditAppDocument.class.getName()));
			creditAppDocument.setDocumentFileName(fileName);
			creditAppDocument.setDocumentTitle(fileName);
			creditAppDocument.setDocumentFileContent(dataOutputBlob);
			creditAppDocument.setCompanyId(creditApp.getCompanyId());
			creditAppDocument.setCreateDate(new Date());
			creditAppDocument.setModifiedDate(new Date());
			creditAppDocument.setCreditAppId(creditApp.getCreditAppId());
			CreditAppDocumentLocalServiceUtil.addCreditAppDocument(creditAppDocument);
		} catch (FileNotFoundException fnfe) {
			_log.error(fnfe);
		} catch (SystemException se) {
			_log.error(se);
		}
	}
}