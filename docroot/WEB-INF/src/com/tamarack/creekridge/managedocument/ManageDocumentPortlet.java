package com.tamarack.creekridge.managedocument;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.dao.jdbc.OutputBlob;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.portlet.LiferayPortlet;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.servlet.LiferayFilter;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.ExpandoTable;
import com.liferay.portlet.expando.model.ExpandoTableConstants;
import com.liferay.portlet.expando.model.ExpandoValue;
import com.liferay.portlet.expando.service.ExpandoTableLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.util.portlet.PortletProps;
import com.tamarack.creekridge.model.CreditApp;
import com.tamarack.creekridge.model.CreditAppDocument;
import com.tamarack.creekridge.service.CreditAppDocumentLocalServiceUtil;
import com.tamarack.creekridge.service.CreditAppLocalServiceUtil;


public class ManageDocumentPortlet extends MVCPortlet {
	private static Logger _log = Logger.getLogger(ManageDocumentPortlet.class);
	private Map <String, String> templateWrapperMap;

	/**
	 * @see MVCPortlet#MVCPortlet()
	 */
	public ManageDocumentPortlet() {
		super();
	}

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		HttpServletRequest request = PortalUtil
				.getHttpServletRequest(renderRequest);

		String passedCreditAppId = PortalUtil
				.getOriginalServletRequest(request).getParameter("creditAppId");
		
		if (passedCreditAppId == null)
			passedCreditAppId = ParamUtil.getString(renderRequest, "creditAppId");
		
		_log.info("Manage Documents doView passedCreditAppId = "
				+ passedCreditAppId);
		
		
		if (passedCreditAppId != null
				&& !"".equalsIgnoreCase(passedCreditAppId)) {
			// Set creditAppId in memory so can be used in view manage document
			// jsp.
			Long viewCreditAppId = new Long(passedCreditAppId).longValue();
			request.getSession().setAttribute("creditAppId", viewCreditAppId);
			request.setAttribute("creditAppId", viewCreditAppId);
		}
		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void render(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		HttpServletRequest requestNew = PortalUtil
				.getHttpServletRequest(request);
		if (PortalUtil.getOriginalServletRequest(requestNew).getParameter(
				"creditAppDocumentId") != null) {
			Long creditAppDocumentId = new Long(PortalUtil
					.getOriginalServletRequest(requestNew).getParameter(
							"creditAppDocumentId")).longValue();
			requestNew.getSession().setAttribute("creditAppDocumentId",
					creditAppDocumentId);
		}
		
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		
		long vendorId = themeDisplay.getLayout().getGroupId();
		
		Group group;
		try {
			group = GroupLocalServiceUtil.getGroup(vendorId);
			
			ExpandoTable table = ExpandoTableLocalServiceUtil.getTable(group.getCompanyId(),  group.getClassNameId(), ExpandoTableConstants.DEFAULT_TABLE_NAME);
			
			ExpandoValue htmlTemplateNamesExpando = ExpandoValueLocalServiceUtil.getValue(group.getCompanyId(), group.getClassNameId(), table.getName(), "Vendor Template HTML Files", group.getPrimaryKey());
			_log.info("htmlTemplateNamesExpando: " + htmlTemplateNamesExpando);
			
			ExpandoValue htmlTemplateLabelsExpando = ExpandoValueLocalServiceUtil.getValue(group.getCompanyId(), group.getClassNameId(), table.getName(), "Vendor Template Titles", group.getPrimaryKey());
			_log.info("htmlTemplateLabelsExpando: " + htmlTemplateLabelsExpando);
			
			
			//create a list of templates
			String htmlFiles = "";
			if (htmlTemplateNamesExpando != null && htmlTemplateNamesExpando.getData() != null)
				htmlFiles = (String) htmlTemplateNamesExpando.getData();
			
			String titles = "";
			if (htmlTemplateLabelsExpando != null && htmlTemplateLabelsExpando.getData() != null)
				titles = (String) htmlTemplateLabelsExpando.getData();
			
			_log.info("manage docs render htmlFiles " + htmlFiles);
			_log.info("manage docs render titles " + titles);
			
			String[] htmlFilesArray = htmlFiles.split(";");
			String[] titlesArray = titles.split(";");
			String htmlFile = "";
			String title = "";
			
			List <TemplateWrapper> templateOptions = new ArrayList <TemplateWrapper> ();
			templateWrapperMap = new HashMap <String, String> ();
			
			for (int i = 0; i < htmlFilesArray.length; i++) {
				htmlFile = htmlFilesArray[i];
				title = (i < titlesArray.length ? titlesArray[i] : "");
				_log.info("htmlFile " + htmlFile);
				_log.info("title " + title);
				
				templateOptions.add(new TemplateWrapper(title, htmlFile));
				templateWrapperMap.put(htmlFile, title);
				
			}
			
			request.setAttribute("templateOptions", templateOptions);
			
		} catch (Exception e) {
			_log.error ("manage docs render request error: " + e);
		}
		
		super.render(request, response);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		HttpServletRequest request = PortalUtil
				.getHttpServletRequest(resourceRequest);
		String actionType = PortalUtil.getOriginalServletRequest(request)
				.getParameter("actionType");
		String creditDocumentId = PortalUtil.getOriginalServletRequest(request)
				.getParameter("creditDocumentId");

		_log.info("DocumentId " + creditDocumentId);
		long fileAttachmentId = new Long(creditDocumentId).longValue();
		String fileName = "";

		if ("deleteAction".equalsIgnoreCase(actionType)) {
			try {
				CreditAppDocumentLocalServiceUtil
						.deleteCreditAppDocument(fileAttachmentId);

			} catch (PortalException e) {
				_log.error("Error deleting file  with file id "
						+ fileAttachmentId);
				e.printStackTrace();
			} catch (SystemException e) {
				_log.error("Error deleting file  with file id "
						+ fileAttachmentId);
				e.printStackTrace();
			}

		} else if ("downloadAction".equalsIgnoreCase(actionType)) {

			try {
				CreditAppDocument fileAttachment = CreditAppDocumentLocalServiceUtil
						.fetchCreditAppDocument(fileAttachmentId);
				fileName = fileAttachment.getDocumentFileName();
				String contentDispositionValue = "attachment; filename=\""
						+ fileName + "\"";
				resourceResponse.addProperty("Content-Disposition",
						contentDispositionValue);

				String extension = GetterUtil.getString(FileUtil
						.getExtension(fileName));
				if (extension.equals("pdf")
						|| extension.equalsIgnoreCase("pdf")) {
					contentDispositionValue = StringUtil
							.replace(contentDispositionValue, "attachment; ",
									"inline; ");
					resourceResponse.setContentType("application/pdf");
					System.out.println("Filename " + fileName);
				}
				resourceResponse.setProperty(HttpHeaders.CONTENT_DISPOSITION,
						contentDispositionValue);
				OutputStream out = resourceResponse.getPortletOutputStream();
				Blob fileContent = fileAttachment.getDocumentFileContent();

				byte[] content = fileContent.getBytes(1,
						(int) fileContent.length());

				out.write(content);
				out.flush();
				out.close();

			} catch (Exception e) {
				_log.error("Error downloading file  with filename " + fileName);
				e.printStackTrace();
			}
		} else if ("printAction".equalsIgnoreCase(actionType)) {

			try {
				CreditAppDocument creditAppDocument = CreditAppDocumentLocalServiceUtil
						.fetchCreditAppDocument(fileAttachmentId);
				fileName = creditAppDocument.getDocumentFileName();
				String contentDispositionValue = "attachment; filename=\""
						+ fileName + "\"";
				resourceResponse.addProperty("Content-Disposition",
						contentDispositionValue);
				OutputStream out = resourceResponse.getPortletOutputStream();

				Blob fileContent = creditAppDocument.getDocumentFileContent();
				byte[] content = fileContent.getBytes(1,
						(int) fileContent.length());

				out.write(content);
				out.flush();
				out.close();

			} catch (Exception e) {
				_log.error("Error downloading file attachment with filename "
						+ fileName);
				e.printStackTrace();
			}
		}
	}

	public void generateDocuments (ActionRequest actionRequest, ActionResponse response)  throws IOException, PortletException {
		
		try {
			_log.info("generateDocuments start");
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long userId = themeDisplay.getUserId();
			

			HttpServletRequest request = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(actionRequest));
			
			String creditAppDocumentId = ParamUtil.getString(actionRequest, "creditAppId");
			actionRequest.setAttribute("creditAppId", creditAppDocumentId);
			

			_log.info("creditAppDocumentId " + creditAppDocumentId);
		
			
			String realPath = getPortletContext().getRealPath("/");
			_log.info("realPath " + realPath);
			String companyLogoURL = themeDisplay.getURLHome() + "/../.." + themeDisplay.getCompanyLogo();
			_log.info("companyLogoURL " + companyLogoURL);
			
			
			String [] templatesList = ParamUtil.getParameterValues(actionRequest, "htmlTemplates");
			_log.info("templatesList" + templatesList.toString());
			
			CreditApp creditApp = CreditAppLocalServiceUtil.getCreditApp(new Long (creditAppDocumentId));
			
			if (creditApp != null && templatesList != null) {
				Group group = GroupLocalServiceUtil.getGroup(creditApp.getGroupId());
				
				for (String key: templatesList) {
					String title = "";
					String htmlFile = "";
					
					htmlFile = key;
					title = templateWrapperMap.get(key);
					
					_log.info("htmlFile " + htmlFile);
					_log.info("title " + title);
					
					ManageDocumentUtil.generateDocument(htmlFile, title, creditApp, realPath, companyLogoURL, ManageDocumentUtil.getShowPrincipals(group), ManageDocumentUtil.getShowBankRefs(group));
				}
				
			
				SessionMessages.add(actionRequest, "docGenerated");
						
				
			} else {
				SessionErrors.add(actionRequest, "genericError");
			}
		} catch (Exception e) {
			SessionErrors.add(actionRequest, "genericError");
			_log.error(e);
		}
		
		
	}

	public void uploadToCreditAppDocument(ActionRequest actionRequest,
			ActionResponse response) throws IOException, PortalException,
			SystemException {
		UploadRequest uploadRequest = PortalUtil
				.getUploadPortletRequest(actionRequest);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		File uploadedFile = uploadRequest.getFile("uploadedFile");
		if (uploadedFile != null && uploadedFile.length() > 0) {
			String uploadfileName = uploadRequest.getFileName("uploadedFile");
			long creditId = ParamUtil.getLong(uploadRequest, "creditAppId");
			String documentTitle = ParamUtil.getString(uploadRequest,
					"documentTitle");
			InputStream fis = new FileInputStream(uploadedFile);
			OutputBlob dataOutputBlob = new OutputBlob(fis,
					uploadedFile.length());

			CreditAppDocument creditAppDocument = CreditAppDocumentLocalServiceUtil
					.createCreditAppDocument(CounterLocalServiceUtil
							.increment(CreditAppDocument.class.getName()));
			creditAppDocument.setDocumentFileName(uploadfileName);
			creditAppDocument.setDocumentTitle(!""
					.equalsIgnoreCase(documentTitle) ? documentTitle
					: uploadfileName);
			creditAppDocument.setDocumentFileContent(dataOutputBlob);
			creditAppDocument.setCompanyId(themeDisplay.getCompanyId());
			creditAppDocument.setCreateDate(new Date());
			creditAppDocument.setModifiedDate(new Date());
			creditAppDocument.setCreditAppId(creditId);

			CreditAppDocumentLocalServiceUtil
					.addCreditAppDocument(creditAppDocument);
			SessionMessages.add(actionRequest, "docUploaded");
		}
	}

	public void deleteDocument(ActionRequest actionRequest,
			ActionResponse response) throws IOException, PortalException,
			SystemException {
		HttpServletRequest request = PortalUtil
				.getOriginalServletRequest(PortalUtil
						.getHttpServletRequest(actionRequest));
		String creditDocumentId = PortalUtil.getOriginalServletRequest(request)
				.getParameter("creditAppDocumentId");
		_log.info("DocumentId " + creditDocumentId);
		long fileAttachmentId = new Long(creditDocumentId).longValue();
		CreditAppDocumentLocalServiceUtil
				.deleteCreditAppDocument(fileAttachmentId);
		SessionMessages.add(actionRequest, "docDeleted");
	}

	public void printAttachment(ActionRequest actionRequest,
			ActionResponse response) throws IOException, PortalException,
			SystemException {

		Long creditDocumentId = ParamUtil.getLong(actionRequest,
				"creditAppDocumentId");
		CreditAppDocument creditAppDocument = CreditAppDocumentLocalServiceUtil
				.getCreditAppDocument(creditDocumentId);
		// Get File Content
		Blob fileContent = creditAppDocument.getDocumentFileContent();
		// Write to temporary File Output stream
		try {

			InputStream is = fileContent.getBinaryStream();
			File attachment = new File(PropsUtil.get("fileAttachmentPath")
					+ creditAppDocument.getDocumentFileName());
			FileOutputStream fos = new FileOutputStream(attachment);
			int b = 0;
			while ((b = is.read()) != -1) {
				fos.write(b);
			}

			fos.close();
			fos.flush();

		} catch (Exception e) {

		}
	}

	public void emailCreditAppDocument(ActionRequest actionRequest,
			ActionResponse response) throws IOException, PortalException,
			SystemException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		HttpServletRequest request = PortalUtil
				.getOriginalServletRequest(PortalUtil
						.getHttpServletRequest(actionRequest));
		System.out.println("fileAttachmentPath "
				+ PortletProps.get("fileAttachmentPath"));
		String fromAddress = user.getEmailAddress();
		String toAddress = ParamUtil.getString(actionRequest, "toAddress");
		String subject = ParamUtil.getString(actionRequest, "subject");
		String body = ParamUtil.getString(actionRequest, "body");
		Long creditDocumentId = ParamUtil.getLong(actionRequest,
				"creditAppDocumentId");
		CreditAppDocument creditAppDocument = CreditAppDocumentLocalServiceUtil
				.getCreditAppDocument(creditDocumentId);
		// Get File Content
		Blob fileContent = creditAppDocument.getDocumentFileContent();
		// Write to temporary File Output stream
		try {

			InputStream is = fileContent.getBinaryStream();
			File attachment = new File(PortletProps.get("fileAttachmentPath")
					+ creditAppDocument.getDocumentFileName());
			FileOutputStream fos = new FileOutputStream(attachment);
			int b = 0;
			while ((b = is.read()) != -1) {
				fos.write(b);
			}

			fos.close();
			fos.flush();
			MailMessage mailMessage = new MailMessage();
			mailMessage.setBody(body);
			mailMessage.setFrom(new InternetAddress(fromAddress));
			mailMessage.setSubject(subject);
			String[] toAddressArray = new String[] { "" };
			InternetAddress[] toInternetAddress;
			try {
				toInternetAddress = new InternetAddress[] { new InternetAddress(
						"") };

				if (toAddress != null) {
					if (toAddress.contains(",")) {
						toAddressArray = toAddress.split(",");
					} else if (toAddress.contains(";")) {
						toAddressArray = toAddress.split(";");
					}
				}
				if (toAddressArray.length > 1) {
					for (int i = 0; i < toAddressArray.length; i++) {
						toInternetAddress[i] = new InternetAddress(
								toAddressArray[i]);
					}
				}

				if (toInternetAddress.length > 1) {
					mailMessage.setTo(new InternetAddress(toAddress));
				} else {
					mailMessage.setTo(new InternetAddress(toAddress));
				}
			} catch (AddressException e) {
				_log.error(e);
			}

			mailMessage.addFileAttachment(attachment);
			MailServiceUtil.sendEmail(mailMessage);
			SessionMessages.add(actionRequest, "emailSent");
			response.sendRedirect(themeDisplay.getPathFriendlyURLPrivateGroup()
					+ themeDisplay.getScopeGroup().getFriendlyURL()
					+ "/manage-documents?creditAppId="
					+ request.getSession().getAttribute("creditAppId"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public class TemplateWrapper {
		String name;
		String label;
		
		public TemplateWrapper (String label, String name) {
			this.name = name;
			this.label = label;
		}
		
		public String getLabel () {
			return label;
		}
		
		public String getName () {
			return name;
		}
	}
}
