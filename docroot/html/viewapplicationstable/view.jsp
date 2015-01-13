<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>

<%@page import="com.liferay.util.*"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.model.UserGroup"%>
<%@page import="com.liferay.portal.model.UserGroupRole"%>
<%@page import="com.liferay.portal.model.RoleConstants"%>
<%@page import="com.liferay.portal.service.UserGroupRoleLocalServiceUtil"%>


<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>

<portlet:defineObjects />

<portlet:resourceURL var="creditApplicationsJsonURL"
	id="getCreditApplicationsJson" />


<portlet:actionURL name="changeApplicationStatus"
	var="changeApplicationStatusURL">
</portlet:actionURL>



<script src="<%=request.getContextPath() %>/js/jquery-1.11.1.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/jquery.dataTables.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/jquery.dataTables.columnFilter.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/moment.min.js" type="text/javascript"></script>

<link href="<%=request.getContextPath() %>/css/jquery.dataTables.min.css" rel="stylesheet">



<aui:form method="post" name="changeApplicationStatus" action="<%=changeApplicationStatusURL%>">
	<aui:input inlineField="true" name="creditAppId" type="hidden"/>
	<aui:input inlineField="true" name="statusId" type="hidden"/>
</aui:form>


<div>
	<!-- title -->
	<aui:row>
		<h4 class="screenTitle">View Credit Applications</h4>
	</aui:row>
	
	<!-- new app button -->
	<aui:row>
	
		<div class="span3" style="margin-bottom: 30px">
			<a class="btn btn-info btn-block" href="payment-calculator"><i class="icon-pencil"></i> New Application</a>
		</div>
	</aui:row>
	
	<!-- filters  -->
	<aui:row style="margin-top:15px">
		<label style="display:inline">Status </label>
		<span id="creditApplicationStatusFilter"></span>
		
		<div style="display:none" id="salesRepFilterSection">
			<label style="display:inline">Sales Rep </label>
			<span id="salesRepFilter"></span>
		</div>
		
	</aui:row>
	
	<!-- apps table  -->
	
	<div class="table-responsive">
		<table id="appTable" class="table  table-striped table-bordered">
				<thead>
			            <tr>
			                <th>Status</th>
			                <th>Sales Rep</th>
			                <th>Customer Name</th>
			                <th>Created Date</th>
			                <th>Modified Date</th>
			                <th style="background:#fff">Actions</th>
			                
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
						</tr>
					</tfoot>
			</table>
		</div>
	
</div>

<style>
	.dataTables_length, .dataTables_filter {
		margin-top: 10px;
	}
</style>

<script type="text/javascript">

var isVendorSaleRep = ${isVendorSaleRep};
var isCreekRidgeSalesManager  = ${isCreekRidgeSalesManager};

$(document).ready(function() {
	
	var repNames = ${siteUsers};
	
	if (isVendorSaleRep == false) {
		$("#salesRepFilterSection").show();
	}
	
    $('#appTable').dataTable( {
        "ajax": "<%=creditApplicationsJsonURL%>",
        "columns": [
            { "data": "statusName" },
            { "data": "salesRepName" },
            { "data": "creditApp.customerName",
	           	"render": function ( data, type, full, meta ) {
	           		return data;
	           	}
            },
            { "data": "creditApp.createDate",
            	"render": function ( data, type, full, meta ) {
            		return moment(data).format('MM/DD/YYYY');
            	}
            },
            { "data": "creditApp.modifiedDate",
            	"render": function ( data, type, full, meta ) {
            		return moment(data).format('MM/DD/YYYY');
            	}
            },
            
         
        ],
        "columnDefs": [ {
        		"targets": 1,
        		"visible": !isVendorSaleRep,
        	},{
            "targets": 5,
            "data": "creditApp.creditAppId",
            "orderable" : false,
            "render" : function ( data, type, full, meta ) {
            	
            	var href = '<a name="View" value="View" class="btn"  href="payment-calculator?viewOnly=true&creditAppId='+ full.creditAppId +'"><i class="icon-search"></i> View</a> '
            	
            	if (full.statusName != "Submitted" && full.statusName != "Cancelled")		
            	href += '<a name="edit" value="Edit" class="btn" href="payment-calculator?creditAppId='+ data +'" ><i class="icon-pencil"></i> Edit</a> '
            	
            	href += '<a name="manage" value="Manage Docs" class="btn" href="manage-documents?creditAppId='+ data +'"><i class="icon-file"></i> Docs</a> '
            	
            	if (full.statusName != "Cancelled" && full.statusName != "Submitted")
            	href += '<a name="cancel"  value="Cancel" class="btn" onclick="processApp('+ data +', 4)"><i class="icon-trash"></i> Cancel</a> ';
            	
            	if (full.statusName == "Cancelled")
            	href += '<a name="reenable"  value="re-enable" class="btn" onclick="processApp('+ data +', 2)"><i class="icon-refresh"></i> Re-Enable</a> ';
            	
       	      	return href; 
				       
            }
        } ]
    }).columnFilter({
    		//sPlaceHolder: "head:before",
             aoColumns: [
                 
				{ type:"select", 
					sSelector: "#creditApplicationStatusFilter", 
					values:["Draft","Saved","Submitted","Cancelled"], 
					selected: 'Saved',
					
				},{ type:"select", 
					sSelector: "#salesRepFilter",
					values: repNames
					
				}
				/* { type:"select", 
					sSelector: "#salesRepFilter", 
					values:["Draft","Saved","Submitted","Cancelled"], 
					selected: 'Saved',
					
				}, 
				null,
				null,
				 */
             ]
       });
   
    
} );

var processApp = function (appId, status) {
	$("#<portlet:namespace />creditAppId").val(appId);
	$("#<portlet:namespace />statusId").val(status);
	$("#<portlet:namespace />changeApplicationStatus").submit();
};

</script>