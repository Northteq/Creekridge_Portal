package com.tamarack.creekridge.managedocument;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.util.Date;

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
import com.liferay.portal.kernel.dao.jdbc.OutputBlob;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.upload.UploadRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.tamarack.creekridge.model.CreditAppDocument;
import com.tamarack.creekridge.service.CreditAppDocumentLocalServiceUtil;

/**
 * Portlet implementation class PaymentCalculatorTable
 */
public class ManageDocumentPortlet extends MVCPortlet {
	private static Logger _log = Logger.getLogger(ManageDocumentPortlet.class); 
    /**
     * @see MVCPortlet#MVCPortlet()
     */
    public ManageDocumentPortlet() {
        super();
    }
   

@Override
public void doView(RenderRequest renderRequest,	RenderResponse renderResponse) throws IOException, PortletException {

	HttpServletRequest request = PortalUtil.getHttpServletRequest(renderRequest);
	
	String passedCreditAppId=PortalUtil.getOriginalServletRequest(request).getParameter("creditAppId");
	System.out.println("passedCreditAppId " +passedCreditAppId);
	if(passedCreditAppId != null && !"".equalsIgnoreCase(passedCreditAppId)){
		//Set creditAppId in memory so can be used in view manage document jsp.
		Long viewCreditAppId = new Long(passedCreditAppId).longValue();
		request.getSession().setAttribute("creditAppId",viewCreditAppId); 
	}
	
	super.doView(renderRequest, renderResponse);
   
  }


@Override
public void serveResource(ResourceRequest resourceRequest,	ResourceResponse resourceResponse) throws IOException,	PortletException {
	 HttpServletRequest request = PortalUtil.getHttpServletRequest(resourceRequest);
	   String actionType=PortalUtil.getOriginalServletRequest(request).getParameter("actionType");
	   String creditDocumentId=PortalUtil.getOriginalServletRequest(request).getParameter("creditDocumentId");
	  _log.info("DocumentId "+creditDocumentId);
       long fileAttachmentId=new Long(creditDocumentId).longValue();
	   System.out.println("actionType "+actionType);
	     
     if("deleteAction".equalsIgnoreCase(actionType)) {
     	try {
     		   CreditAppDocumentLocalServiceUtil.deleteCreditAppDocument(fileAttachmentId);
				OutputStream o = resourceResponse.getPortletOutputStream();
              o.write("deleted".getBytes(), 0, "deleted".getBytes().length);
              o.flush();
              o.close();
			} catch (PortalException e) {
				_log.error("Error deleting file  with file id " + fileAttachmentId);
				e.printStackTrace();
			} catch (SystemException e) {
				_log.error("Error deleting file  with file id " + fileAttachmentId);
				e.printStackTrace();
			}
 		
     } else if("downloadAction".equalsIgnoreCase(actionType)) {
     	
    	 String fileName="";
		   try {
			   		CreditAppDocument fileAttachment=CreditAppDocumentLocalServiceUtil.fetchCreditAppDocument(fileAttachmentId);
			   		fileName =  fileAttachment.getDocumentFileName();
			   		String contentDispositionValue = "attachment; filename=\"" + fileName + "\"";
			   		resourceResponse.addProperty("Content-Disposition", contentDispositionValue);
               	
			   		OutputStream out = resourceResponse.getPortletOutputStream();
	             	
		              Blob fileContent=fileAttachment.getDocumentFileContent();
		              byte[ ] content = fileContent.getBytes(1,(int)fileContent.length());
		              
		              out.write(content);
		              out.flush();
		              out.close();

	          
	  
	      } catch (Exception e) {
	    	  _log.error("Error downloading file  with filename " + fileName);
			  e.printStackTrace();
	    }	 
	  }  else if("printAction".equalsIgnoreCase(actionType)) {
	     	
	  	  
			   try {
				   		CreditAppDocument creditAppDocument=CreditAppDocumentLocalServiceUtil.fetchCreditAppDocument(fileAttachmentId);
				   		String fileName =  creditAppDocument.getDocumentFileName();
				   		String contentDispositionValue = "attachment; filename=\"" + fileName + "\"";
				   		resourceResponse.addProperty("Content-Disposition", contentDispositionValue);
	               		OutputStream out = resourceResponse.getPortletOutputStream();
		             	
			              Blob fileContent=creditAppDocument.getDocumentFileContent();
			              byte[ ] content = fileContent.getBytes(1,(int)fileContent.length());
			              
			              out.write(content);
			              out.flush();
			              out.close();

		          
		  
		      } catch (Exception e) {
		    	  //_log.error("Error downloading file attachment with filename " + fileName);
				  e.printStackTrace();
		    }	 
		  }
	}

public void manageDocument(ActionRequest actionRequest, ActionResponse response) throws IOException, PortalException, SystemException {
	ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
	long userId=themeDisplay.getUserId();
	HttpServletRequest request = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(actionRequest));	
	String documentType=PortalUtil.getOriginalServletRequest(request).getParameter("documentType");
	String creditAppDocumentId=PortalUtil.getOriginalServletRequest(request).getParameter("creditAppId");
	//Here you have userId, documentType, creditAppDocumentId
	//Generate CreditApp Document API
	//Generate CreditApp Proposal API
	
  }

public void uploadToCreditAppDocument(ActionRequest actionRequest, ActionResponse response) throws IOException, PortalException, SystemException {
	    UploadRequest uploadRequest=PortalUtil.getUploadPortletRequest(actionRequest);
	    ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
	    File uploadedFile = uploadRequest.getFile("uploadedFile");
	    String uploadfileName = uploadRequest.getFileName("uploadedFile");
	    long creditId = ParamUtil.getLong(uploadRequest, "creditAppId");		
		InputStream fis =new FileInputStream(uploadedFile);
		OutputBlob dataOutputBlob = new OutputBlob(fis, uploadedFile.length());
	
		CreditAppDocument creditAppDocument=CreditAppDocumentLocalServiceUtil.createCreditAppDocument(CounterLocalServiceUtil.increment(CreditAppDocument.class.getName()));
		creditAppDocument.setDocumentFileName(uploadfileName);
		creditAppDocument.setDocumentTitle(uploadfileName);
		creditAppDocument.setDocumentFileContent(dataOutputBlob);
		creditAppDocument.setCompanyId(themeDisplay.getCompanyId());
		creditAppDocument.setCreateDate(new Date());
		creditAppDocument.setModifiedDate(new Date());
		creditAppDocument.setCreditAppId(creditId);
		CreditAppDocumentLocalServiceUtil.addCreditAppDocument(creditAppDocument);
	
 }

public void emailCreditAppDocument(ActionRequest actionRequest, ActionResponse response) throws IOException, PortalException, SystemException {
	ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
	UploadRequest uploadRequest=PortalUtil.getUploadPortletRequest(actionRequest);
	long creditId = ParamUtil.getLong(uploadRequest, "creditId");				
    File uploadedFile = uploadRequest.getFile("uploadedFile");
    String uploadfileName = uploadRequest.getFileName("uploadedFile");
	InputStream fis =new FileInputStream(uploadedFile);
	OutputBlob dataOutputBlob = new OutputBlob(fis, uploadedFile.length());

	CreditAppDocument creditAppDocument=CreditAppDocumentLocalServiceUtil.createCreditAppDocument(CounterLocalServiceUtil.increment(CreditAppDocument.class.getName()));
	creditAppDocument.setDocumentFileName(uploadfileName);
	creditAppDocument.setDocumentFileContent(dataOutputBlob);
	creditAppDocument.setCompanyId(themeDisplay.getCompanyId());
	creditAppDocument.setCreateDate(new Date());
	creditAppDocument.setModifiedDate(new Date());
	creditAppDocument.setCreditAppId(creditId);
	CreditAppDocumentLocalServiceUtil.addCreditAppDocument(creditAppDocument);

}
}

