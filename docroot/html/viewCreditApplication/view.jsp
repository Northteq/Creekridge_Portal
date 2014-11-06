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
<portlet:renderURL var="viewCreditApplicationUrl">
	<portlet:param name="jspPage" value="/web/vendor1/payment-calculator" />
</portlet:renderURL>
<head>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.1/jquery.min.js"></script>
<%-- <script src="<%=request.getContextPath() %>/js/jquery.dataTables.min.js"></script> --%>
<!-- <link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.3/css/jquery.dataTables.css"> -->
<!-- jQuery -->
<!-- <script type="text/javascript" charset="utf8" src="//code.jquery.com/jquery-1.10.2.min.js"></script> -->
<!-- DataTables -->
<!-- <script type="text/javascript" charset="utf8" src="//cdn.datatables.net/1.10.3/js/jquery.dataTables.js"></script> -->
 <style type="text/css" title="currentStyle">
            @import "<%=request.getContextPath() %>/css/viewCreditApp_page.css";
			@import "<%=request.getContextPath() %>/css/viewCreditApp_table.css";
			@import "http://jquery-datatables-column-filter.googlecode.com/svn/trunk/media/css/themes/base/jquery-ui.css";
			@import "http://jquery-datatables-column-filter.googlecode.com/svn/trunk/media/css/themes/smoothness/jquery-ui-1.7.2.custom.css";
		</style>
        <script src="<%=request.getContextPath() %>/js/jquery-1.4.4.min.js" type="text/javascript"></script>
        <script src="<%=request.getContextPath() %>/js/jquery.dataTables.js" type="text/javascript"></script>

        <script src="<%=request.getContextPath() %>/js/jquery-ui.js" type="text/javascript"></script>

        <script src="<%=request.getContextPath() %>/js/jquery.dataTables.columnFilter.js" type="text/javascript"></script>


<script>
   $(document).ready(function () {
	   $.datepicker.regional[""].dateFormat = 'yy-mm-dd';
       $.datepicker.setDefaults($.datepicker.regional['']);
	   $('#creditAppView').DataTable()
	   .columnFilter({aoColumns:[
								    { type:"date-range", sSelector: "#createdDate" },
									{ type:"date-range", sSelector: "#lastSavedDate" },
									{ type:"date-range", sSelector: "#submittedDate" },
									{ type:"text", sSelector: "#customerName" },
									{ type:"text", sSelector: "#equipmentPrice" },
									{ type:"text", sSelector: "#creditApplicationStatus" }
									]}
								);

		
}); 


   function assignActionType(actionType, creditAppId) {
		
		
	   	document.<portlet:namespace />creditApp.<portlet:namespace />actionType.value = actionType;
	   	document.<portlet:namespace />creditApp.<portlet:namespace />creditAppId.value = creditAppId;
	   	document.<portlet:namespace />creditApp.submit();

	}

</script>
<style type="text/css">

.displayFilterTemp {
 
  border: 1px solid black ;
  margin: 5px;
  padding: 5px;
}

</style>
</head>



<div align="center" width="100%"  id="calculatorResults">
	<H4><font style="background-color: lightgrey">View Credit Application</font></H4>
</div>
<aui:form name="creditApp" action="<%=updateCreditAppUrl %>" method="post">
<aui:input type="hidden" value="" name="creditAppId" />
<aui:input type="hidden" value="" name="actionType" />

</aui:form>
<div id="creditAppFilter">
<table  class="display" ID="main">
<tr><td>
<table style="background-color: lightgrey; border: 1px solid black ; margin: 5px;  padding: 5px;" class="display" ID="Table1">
			<thead>
			<th>
			<b>Filters</b>
			</th>
			</thead>
			<tbody>
				<tr id="filter_global">
					<td align="center"><b>Created Date:</b></td>
				</tr>
				<tr>
					<td align="center" id="createdDate"></td>
				</tr>
				<tr id="filter_col1">
					<td align="center"><b>Last Saved Date:</b></td>
				</tr>
				<tr>
					<td align="center" id="lastSavedDate"></td>
				</tr>
				<tr id="filter_col2">
					<td align="center"><b>Submitted Date:</b></td>
				</tr>
				<tr>	
					<td align="center" id="submittedDate"></td>
				</tr>
				<tr id="filter_col3">
					<td align="center"><b>Customer Name:</b></td>
				 </tr>
				<tr>
					<td align="center" id="customerName"></td>
				</tr>
				<tr id="filter_col4">
					<td align="center">Equipment Price:</td>
				</tr>
				<tr>
					<td align="center" id="equipmentPrice"></td>
				</tr>
				<tr id="filter_col4">
					<td align="center"><b>Credit Application Status:</b></td>
				</tr>
				<tr>
					<td align="center" id="creditApplicationStatus"></td>
				</tr>
			</tbody>
		</table>
</td>
<td>		
 <table   id="creditAppView" class="display" >
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
<tfoot>

    <tr>
			<th></th>
			<th></th>
			<th></th>
			<th></th>
			<th></th>
			<th></th>
			<th></th>
			<th></th>
    </tr>
</tfoot>

<tbody>

	<%  
	
      for (int i=0;i<creditAppList.size();i++) {
       if( !"Cancelled".equalsIgnoreCase(statusMap.get(creditAppList.get(i).getCreditAppStatusId())) && !"Draft".equalsIgnoreCase(statusMap.get(creditAppList.get(i).getCreditAppStatusId()))){
    	  
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
			 <td><button  type="button"  name="edit" value="Edit" onclick="<%="javascript:window.location.href='/web/vendor1/payment-calculator?creditAppId="+creditAppList.get(i).getCreditAppId() +"'" %>" ><img src='<%= renderRequest.getContextPath() + "/images/edit.png" %>'/></button></td>
		     <td><button  type="button"  name="cancel"  value="Cancel" onclick="javascript:assignActionType('cancel','<%=creditAppList.get(i).getCreditAppId() %>')" ><img src='<%= renderRequest.getContextPath() + "/images/remove.png" %>' /></button></td>
	
		</tr>
	<%} 
	}%>
	</tbody>
	</table>
</td>
</tr>
</table>
</div>
<div class="spacer"></div>

</html>