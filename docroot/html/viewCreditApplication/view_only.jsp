<%@page import="com.tamarack.creekridge.service.CreditAppStatusLocalServiceUtil"%>
<%@page import="com.tamarack.creekridge.model.CreditAppStatus"%>
<%@page import="com.tamarack.creekridge.service.CreditAppLocalServiceUtil"%>
<%@page import="com.tamarack.liferay.payment.TempBankAccount"%>
<%@page import="com.liferay.util.*"%>
<%@page import="com.tamarack.liferay.payment.TempProposalOption"%>
<%@page import="com.tamarack.liferay.payment.TempPrincipal"%>
<%@page import="com.tamarack.creekridge.service.TermLocalServiceUtil"%>
<%@page import="com.tamarack.creekridge.service.PurchaseOptionLocalServiceUtil"%>
<%@page import="com.tamarack.creekridge.service.ProductLocalServiceUtil"%>
<%@page import="com.tamarack.creekridge.service.ProposalOptionLocalServiceUtil"%>
<%@page import="com.tamarack.creekridge.model.ProposalOption"%>
<%@page import="com.tamarack.creekridge.service.CreditAppPrincipalLocalServiceUtil"%>
<%@page import="com.tamarack.creekridge.model.CreditAppBankReference"%>
<%@page import="com.tamarack.creekridge.model.CreditApp"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@page import="java.util.*"%>
<portlet:defineObjects />

<%
ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
List<CreditApp> creditAppList=CreditAppLocalServiceUtil.getCreditApps(-1, -1);
List<CreditAppStatus> creditAppStatusList=CreditAppStatusLocalServiceUtil.getCreditAppStatuses(-1, -1);
boolean isOmniAdmin=themeDisplay.getPermissionChecker().isOmniadmin();
boolean isGroupOwner = themeDisplay.getPermissionChecker().isGroupOwner(themeDisplay.getScopeGroupId());
boolean isCreekRidgeSalesManager=false;
User user = themeDisplay.getUser();
for (int i=0;i<user.getRoles().size();i++){
	System.out.println(user.getRoles().get(i).getName());
	if("CreekRidge Sales Manager".equalsIgnoreCase(user.getRoles().get(i).getName())){
		isCreekRidgeSalesManager=true;
		break;
	}
}
Map<Long,String> statusMap= new HashMap<Long,String>();
for (int j=0;j<creditAppStatusList.size();j++){
	statusMap.put(creditAppStatusList.get(j).getCreditAppStatusId(), creditAppStatusList.get(j).getCreditAppStatusName());
}

%>
<portlet:actionURL var="updateCreditAppUrl" >
  <portlet:param name="<%= javax.portlet.ActionRequest.ACTION_NAME %>" value="updateCreditApp" />
</portlet:actionURL>
<html>

<head>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.1/jquery.min.js"></script>
<%-- <script src="<%=request.getContextPath() %>/js/jquery.dataTables.min.js"></script> --%>

<link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.3/css/jquery.dataTables.css">
  
<!-- jQuery -->
<!-- <script type="text/javascript" charset="utf8" src="//code.jquery.com/jquery-1.10.2.min.js"></script> -->
  
<!-- DataTables -->
<script type="text/javascript" charset="utf8" src="//cdn.datatables.net/1.10.3/js/jquery.dataTables.js"></script>


<script>
   $(document).ready(function () {
    
	   $('#creditAppView').DataTable();
  });

</script>
<!-- <style type="text/css">.boxed { -->
/*   border: 1px solid black ; */
/*   margin: 5px; */
/*   padding: 5px; */
/* } */
<!-- </style> -->
</head>



<div align="center" width="100%"  id="calculatorResults">
	<H4><font style="background-color: lightgrey">View Credit Application</font></H4>
</div>

 <table  id="creditAppView" class="display">
 <thead>
    <tr>
			<th>Created Date</th>
			<th>Last Saved Date</th>
			<th>Submitted Date	</th>
			<th>Customer Name</th>
			<th>Equipment Price</th>
			<th>Credit Application Status</th>
			<th>View Action</th>
			<th>Cancel Action</th>
    </tr>
</thead>
<tbody>
	<%  
	
      for (int i=0;i<creditAppList.size();i++) {
       if(!"Draft".equalsIgnoreCase(statusMap.get(creditAppList.get(i).getCreditAppStatusId()))){
    	  
      %>

		<tr>
			<td> <%=creditAppList.get(i).getCreateDate()%>

			</td>
			<td><%=creditAppList.get(i).getModifiedDate()%>

			</td>
			<td><%=creditAppList.get(i).getModifiedDate()%>

			</td>
			<td><%=creditAppList.get(i).getCustomerName()%>
			</td>
			<td> <%=creditAppList.get(i).getEquipmentPrice()%>
			</td>
			<td> <%=statusMap.get(creditAppList.get(i).getCreditAppStatusId())%>
			</td>
			 <td><aui:form action="" method="post"><aui:button  type="button"  onclick="javascript:assignPrincipalActionType('view','<%=creditAppList.get(i).getCreditAppId() %> %>')" ><img src='<%= renderRequest.getContextPath() + "/images/edit.png" %>'/></aui:button></aui:form></td>
		     <td><aui:form action="" method="post"><aui:button  type="button"  onclick="javascript:assignPrincipalActionType('edit','<%=creditAppList.get(i).getCreditAppId() %> %>')" ><img src='<%= renderRequest.getContextPath() + "/images/remove.png" %>' /></aui:button></aui:form></td>
	
		</tr>
	<%} 
	}%>
	</tbody>
	</table>

</html>