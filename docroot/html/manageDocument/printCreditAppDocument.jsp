<%--
/**
 * Copyright (c) 2000-present Tamarack, Inc. All rights reserved.
 * @author tamarack
 */
--%>

<%@page import="java.sql.*"%>
<%@page import="java.io.*"%>
<%@page import="com.tamarack.creekridge.service.*"%>
<%@page import="com.liferay.portal.kernel.util.*"%>
<%@page import="com.tamarack.creekridge.model.CreditAppDocument"%>

<%@ include file="init.jsp"%>

<%
long creditAppId= new Long(request.getSession().getAttribute("creditAppId").toString());
long creditAppDocumentId= new Long(request.getSession().getAttribute("creditAppDocumentId").toString());
CreditAppDocument creditAppDocument=CreditAppDocumentLocalServiceUtil.getCreditAppDocument(creditAppDocumentId);
CreditApp creditApp=CreditAppLocalServiceUtil.getCreditApp(creditAppId);
Blob fileContent=creditAppDocument.getDocumentFileContent();

//OutputStream outStream = response.getOutputStream(); 

response.setContentType( "application/pdf" );   
response.setHeader("Content-Disposition","attachment; filename=\""+ creditAppDocument.getDocumentFileName() +"\"");  
byte[ ] content = fileContent.getBytes(1,(int)fileContent.length());  
response.getWriter().print(content);
response.getWriter().flush();   
%>


