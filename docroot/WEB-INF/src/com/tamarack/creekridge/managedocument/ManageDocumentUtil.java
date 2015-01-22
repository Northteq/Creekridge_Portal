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
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
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
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.ExpandoTable;
import com.liferay.portlet.expando.model.ExpandoTableConstants;
import com.liferay.portlet.expando.model.ExpandoValue;
import com.liferay.portlet.expando.service.ExpandoTableLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil;
import com.tamarack.creekridge.model.CreditApp;
import com.tamarack.creekridge.model.CreditAppBankReference;
import com.tamarack.creekridge.model.CreditAppDocument;
import com.tamarack.creekridge.model.CreditAppPrincipal;
import com.tamarack.creekridge.model.Product;
import com.tamarack.creekridge.model.ProposalOption;
import com.tamarack.creekridge.model.PurchaseOption;
import com.tamarack.creekridge.model.Term;
import com.tamarack.creekridge.model.impl.CreditAppBankReferenceModelImpl;
import com.tamarack.creekridge.model.impl.CreditAppModelImpl;
import com.tamarack.creekridge.model.impl.CreditAppPrincipalModelImpl;
import com.tamarack.creekridge.model.impl.ProductModelImpl;
import com.tamarack.creekridge.model.impl.ProposalOptionModelImpl;
import com.tamarack.creekridge.model.impl.PurchaseOptionModelImpl;
import com.tamarack.creekridge.model.impl.TermModelImpl;
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
	
	public static boolean getShowBankRefs (Group group) {
		boolean show = false;
		try {
			ExpandoTable table = ExpandoTableLocalServiceUtil.getTable(group.getCompanyId(),  group.getClassNameId(), ExpandoTableConstants.DEFAULT_TABLE_NAME);
			
			ExpandoValue includeBankRefsExpando = ExpandoValueLocalServiceUtil.getValue(group.getCompanyId(), group.getClassNameId(), table.getName(), "Include Bank References", group.getPrimaryKey());
			_log.info("includeBankRefsExpando: " + includeBankRefsExpando);
			
			if (includeBankRefsExpando != null) {
				show = includeBankRefsExpando.getBoolean();
			}
		} catch (Exception e) {
			_log.error(e);
		}
		
		return show;
	}
	
	public static boolean getShowPrincipals (Group group) {
		boolean show = false;
		try {
			
			
			ExpandoTable table = ExpandoTableLocalServiceUtil.getTable(group.getCompanyId(),  group.getClassNameId(), ExpandoTableConstants.DEFAULT_TABLE_NAME);
			
			ExpandoValue includePrincipalsExpando = ExpandoValueLocalServiceUtil.getValue(group.getCompanyId(), group.getClassNameId(), table.getName(), "Include Principals", group.getPrimaryKey());
			_log.info("includePrincipalsExpando: " + includePrincipalsExpando);
			
			if (includePrincipalsExpando != null) {
				show = includePrincipalsExpando.getBoolean();
			}
		} catch (Exception e) {
			_log.error(e);
		}
		return show;
	}
	
	public static ExpandoValue getExpandoValue (Group group, String fieldName) {
		
		
		try {
			ExpandoTable table = ExpandoTableLocalServiceUtil.getTable(group.getCompanyId(),  group.getClassNameId(), ExpandoTableConstants.DEFAULT_TABLE_NAME);
			
			ExpandoValue expando = ExpandoValueLocalServiceUtil.getValue(group.getCompanyId(), group.getClassNameId(), table.getName(), fieldName, group.getPrimaryKey());
			_log.info("getExpandoValue: " + expando);
			return expando;
			
		} catch (Exception e) {
			_log.error(e);
			return null;
		}
		
	}	
	public static void generateDocument(String htmlFile, String title, CreditApp creditApp, String path, String companyLogoURL, boolean showPrincipals, boolean showBankReferences) {
		try {
			Scanner scanner = null;
			HashMap<String, Object> tokenMap = new HashMap<String, Object>();
			tokenMap.put("companyLogoURL", companyLogoURL);

			DateFormat dateFormat2 = new SimpleDateFormat("MMM d, yyyy");
			tokenMap.put("Date", dateFormat2.format(new Date()));
			
			File file = new File(path + htmlFile);
			scanner = new Scanner(file);
			String template;
			template = scanner.useDelimiter("\\A").next();
			
			if (template == null) 
				template = scanner.useDelimiter("/A").next();
			
			_log.info (template);
			
			updateTokenMap(tokenMap, creditApp);
			String generatedTemplate = replaceTokens(creditApp, path, template, tokenMap);
			scanner.close();
			
			if (!showPrincipals || CreditAppPrincipalLocalServiceUtil.getCreditAppPrincipalByCreditAppId(creditApp.getCreditAppId()).size() == 0) {
				int indexStartPrincipals = generatedTemplate.indexOf("<!-- PRINCIPALS SECTION START -->");
				int indexEndPrincipals = generatedTemplate.indexOf("<!-- PRINCIPALS SECTION END -->");
				
				if (indexStartPrincipals != -1 && indexEndPrincipals != -1) {
					String generatedTemplateStart = generatedTemplate.substring(0, indexStartPrincipals);
					String generatedTemplateEnd = generatedTemplate.substring(indexEndPrincipals, generatedTemplate.length());
					generatedTemplate = generatedTemplateStart + generatedTemplateEnd;
				}
			}
			
			if (!showBankReferences || CreditAppBankReferenceLocalServiceUtil.getCreditAppBankReferenceByCreditApp(creditApp.getCreditAppId()).size() == 0) {
				int indexStartBankReferences = generatedTemplate.indexOf("<!-- BANK REFERENCES SECTION START -->");
				int indexEndBankReferences = generatedTemplate.indexOf("<!-- BANK REFERENCES SECTION END -->");
				
				if (indexStartBankReferences != -1 && indexEndBankReferences != -1) {
					String generatedTemplateStart = generatedTemplate.substring(0, indexStartBankReferences);
					String generatedTemplateEnd = generatedTemplate.substring(indexEndBankReferences, generatedTemplate.length());
					generatedTemplate = generatedTemplateStart + generatedTemplateEnd;
				}
			}
			
			File generatedFile = new File(path + title + ".html");
	        FileWriter fileWriter = new FileWriter(generatedFile);
	        fileWriter.write(generatedTemplate);
	        fileWriter.close();
			
			Timestamp stamp = new Timestamp(System.currentTimeMillis());
			InputStream inputStream = new FileInputStream(generatedFile);
			File convertedFile = DocumentConversionUtil.convert(String.valueOf(stamp.getTime()), inputStream, "html", "pdf");
			saveDocument(creditApp, convertedFile, title);
			convertedFile.delete();
		} catch (Exception e) {
			_log.error(e);
		}
	}
	
	private static String generateSection(CreditApp creditApp, String path, String htmlFile) {
		Scanner scanner = null;
		String generatedTemplate = "";
		
		try {
			HashMap<String, Object> tokenMap = new HashMap<String, Object>();
			File file = new File(path + htmlFile);
			scanner = new Scanner(file);
			String templateSection = scanner.useDelimiter("\\A").next();
			
			if (htmlFile.contains("Principals")) {
				List<CreditAppPrincipal> principals = CreditAppPrincipalLocalServiceUtil.getCreditAppPrincipalByCreditAppId(creditApp.getCreditAppId());
				for (CreditAppPrincipal principal : principals) {
					updateTokenMapPrincipal(tokenMap, principal);
					generatedTemplate += replaceTokens(creditApp, path, templateSection, tokenMap);
				}
				
				if (principals.size() == 0) {
					//updateTokenMapPrincipal(tokenMap, null);
					//generatedTemplate += replaceTokens(creditApp, path, templateSection, tokenMap);
				}
			} else if (htmlFile.contains("BankReferences")) {
				List<CreditAppBankReference> bankReferences = CreditAppBankReferenceLocalServiceUtil.getCreditAppBankReferenceByCreditApp(creditApp.getCreditAppId());
				for (CreditAppBankReference bankReference : bankReferences) {
					updateTokenMapBankReference(tokenMap, bankReference);
					generatedTemplate += replaceTokens(creditApp, path, templateSection, tokenMap);
				}
				
				if (bankReferences.size() == 0) {
					//updateTokenMapBankReference(tokenMap, null);
					//generatedTemplate += replaceTokens(creditApp, path, templateSection, tokenMap);
				}
			} else if (htmlFile.contains("ProposalOptions")) {
				List<ProposalOption> options = ProposalOptionLocalServiceUtil.getProposalOptionByCreditAppId(creditApp.getCreditAppId());
				int counter = 0;
				for (ProposalOption option : options) {
					counter++;
					Product product = ProductLocalServiceUtil.getProduct(option.getProductId());
					PurchaseOption purchaseOption = PurchaseOptionLocalServiceUtil.getPurchaseOption(creditApp.getPurchaseOptionId());
					Term term = TermLocalServiceUtil.getTerm(creditApp.getTermId());
					updateTokenMapProposalOption(tokenMap, option, product, purchaseOption, term, counter + "");
					generatedTemplate += replaceTokens(creditApp, path, templateSection, tokenMap);
				}
				
				if (options.size() == 0) {
					//updateTokenMapProposalOption(tokenMap, null, null, null, null, counter + "");
					//generatedTemplate += replaceTokens(creditApp, path, templateSection, tokenMap);
				}
			}
			
			scanner.close();
		}catch (Exception e) {
			_log.error(e);
		}finally {
			if (scanner != null)
				scanner.close();
		}
		return generatedTemplate;
	}
	
	private static HashMap<String, Object> addTableName(String tableName, Map<String, Object> attributes) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		Iterator<String> keysIter = attributes.keySet().iterator();
		String key = "";
		
		while (keysIter.hasNext()) {
			key = keysIter.next();
			map.put(tableName + "." + key, attributes.get(key));
		}
		
		return map;
	}
	
	private static void updateTokenMap(HashMap<String, Object> tokenMap, CreditApp creditApp) {
		HashMap<String, Object> creditAppMap = addTableName(CreditAppModelImpl.TABLE_NAME, creditApp.getModelAttributes());
		tokenMap.putAll(creditAppMap);
		
		updateTokenMapVendor(tokenMap, creditApp);
		updateTokenMapUser(tokenMap, creditApp);
		
		try {
			PurchaseOption purchaseOption = PurchaseOptionLocalServiceUtil.getPurchaseOption(creditApp.getPurchaseOptionId());
			HashMap<String, Object> purchaseOptionMap = addTableName(PurchaseOptionModelImpl.TABLE_NAME, purchaseOption.getModelAttributes());
			tokenMap.putAll(purchaseOptionMap);
		}
		catch (Exception e) {
			_log.error(e);
		}
		
		try {
			Term term = TermLocalServiceUtil.getTerm(creditApp.getTermId());
			HashMap<String, Object> termMap = addTableName(TermModelImpl.TABLE_NAME, term.getModelAttributes());
			tokenMap.putAll(termMap);
		}
		catch (Exception e) {
			_log.error(e);
		}
		
		try {
			Product product = ProductLocalServiceUtil.getProduct(creditApp.getProductId());
			HashMap<String, Object> productMap = addTableName(ProductModelImpl.TABLE_NAME, product.getModelAttributes());
			tokenMap.putAll(productMap);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}
	
	private static void updateTokenMapVendor(HashMap<String, Object> tokenMap, CreditApp creditApp) {
		try {
			Group group = GroupLocalServiceUtil.getGroup(creditApp.getVendorId());
			
			
			
			tokenMap.put("Vendor Name", group.getName());
			
			if (getExpandoValue(group, "VendorAddress") != null)
				tokenMap.put("Vendor Address", getExpandoValue(group, "VendorAddress").getData());
			
			if (getExpandoValue(group, "Vendor Address 2") != null)
				tokenMap.put("Vendor Address 2", getExpandoValue(group, "Vendor Address 2").getData());
			
			if (getExpandoValue(group, "Vendor City") != null)
				tokenMap.put("Vendor City", getExpandoValue(group, "Vendor City").getData());
			
			if (getExpandoValue(group, "Vendor State") != null)
				tokenMap.put("Vendor State", getExpandoValue(group, "Vendor State").getData());
			
			if (getExpandoValue(group, "Vendor Zip") != null)
				tokenMap.put("Vendor Zip", getExpandoValue(group, "Vendor Zip").getData());
			
			if (getExpandoValue(group, "Vendor Phone") != null)
				tokenMap.put("Vendor Phone", getExpandoValue(group, "Vendor Phone").getData());
			
		}
		catch (Exception e) {
			_log.error(e);
		}
	}
	
	private static void updateTokenMapUser(HashMap<String, Object> tokenMap, CreditApp creditApp) {
		try {
			User user = UserLocalServiceUtil.getUser(creditApp.getUserId());
			HashMap<String, Object> userMap = addTableName("User_", user.getModelAttributes());
			tokenMap.putAll(userMap);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}
	
	private static void updateTokenMapPrincipal(HashMap<String, Object> tokenMap, CreditAppPrincipal principal) {
		HashMap<String, Object> principalMap = addTableName(CreditAppPrincipalModelImpl.TABLE_NAME, principal.getModelAttributes());
		tokenMap.putAll(principalMap);
	}
	
	private static void updateTokenMapBankReference(HashMap<String, Object> tokenMap, CreditAppBankReference bankReference) {
		HashMap<String, Object> bankReferenceMap = addTableName(CreditAppBankReferenceModelImpl.TABLE_NAME, bankReference.getModelAttributes());
		tokenMap.putAll(bankReferenceMap);
	}
	
	private static void updateTokenMapProposalOption(HashMap<String, Object> tokenMap, ProposalOption option, Product product, PurchaseOption purchaseOption, Term term, String counter) {
		tokenMap.put("Proposal Option Number", counter);
		
		HashMap<String, Object> productMap = addTableName(ProductModelImpl.TABLE_NAME, product.getModelAttributes());
		tokenMap.putAll(productMap);
		
		HashMap<String, Object> purchaseOptionMap = addTableName(PurchaseOptionModelImpl.TABLE_NAME, purchaseOption.getModelAttributes());
		tokenMap.putAll(purchaseOptionMap);
		
		HashMap<String, Object> termMap = addTableName(TermModelImpl.TABLE_NAME, term.getModelAttributes());
		tokenMap.putAll(termMap);

		HashMap<String, Object> optionMap = addTableName(ProposalOptionModelImpl.TABLE_NAME, option.getModelAttributes());
		tokenMap.putAll(optionMap);
	}
	
	private static String replaceTokens(CreditApp creditApp, String path, String text, Map<String, Object> replacements) {
		Pattern pattern = Pattern.compile("\\[(.+?)\\]");
		Matcher matcher = pattern.matcher(text);
		StringBuffer buffer = new StringBuffer();
		
		while (matcher.find()) {
			String match = matcher.group(1);
			String replacement = null;
			
			if (match.startsWith("@")) {
				replacement = generateSection(creditApp, path, match.substring(1));
			} else { 
				Object replacementMatch = replacements.get(match);

				if (replacementMatch == null) {
					replacement = "";
				} else if (replacementMatch instanceof Date) {
					DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
					replacement = dateFormat.format(replacementMatch);
				} else if (replacementMatch instanceof Double) {
					DecimalFormat decimalFormat = new DecimalFormat("###,##0.00");
					replacement = decimalFormat.format(replacementMatch);
				} else {
					replacement = (String)replacementMatch;
				}
			}
				
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
