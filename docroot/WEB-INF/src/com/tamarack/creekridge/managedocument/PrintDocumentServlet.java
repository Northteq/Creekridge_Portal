package com.tamarack.creekridge.managedocument;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.tamarack.creekridge.model.CreditAppDocument;
import com.tamarack.creekridge.service.CreditAppDocumentLocalServiceUtil;

public class PrintDocumentServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	//If there is no parameter passed DO NOTHING.
	if(request.getParameter("creditAppDocumentId") != null) {
		long creditAppDocumentId= new Long(request.getParameter("creditAppDocumentId"));
		CreditAppDocument creditAppDocument;
		try {
			creditAppDocument = CreditAppDocumentLocalServiceUtil.getCreditAppDocument(creditAppDocumentId);
			Blob fileContent=creditAppDocument.getDocumentFileContent();
		    InputStream in = fileContent.getBinaryStream();
		 
		    OutputStream out = response.getOutputStream();  
		    response.setContentType( "application/pdf" );   
		    response.setHeader("Content-Disposition","attachment; filename=\""+ creditAppDocument.getDocumentFileName() +"\""); 
		    response.setContentLength(new Long(fileContent.length()).intValue());
		    byte[] buf = new byte[new Long(fileContent.length()).intValue()];  
		   
		    int c;  
		    while ((c = in.read(buf, 0, buf.length)) > 0) {  
		    	out.write(buf, 0, c);  
		    }  
		    out.flush();  
		    in.close();  
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
		
	}
	

}
