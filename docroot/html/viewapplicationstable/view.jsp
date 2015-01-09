<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>

<%@page import="com.liferay.util.*"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>

<portlet:defineObjects />

<portlet:resourceURL var="creditApplicationsJsonURL"
	id="getCreditApplicationsJson" />

<portlet:actionURL name="cancelApplication"
	var="cancelApplicationURL">
	<portlet:param name="creditAppId" value="${creditApp.creditAppId}" />
</portlet:actionURL>

<%

boolean isVendorSaleRep=false;


%>


<script src="<%=request.getContextPath() %>/js/jquery-1.11.1.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/jquery.dataTables.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/jquery.dataTables.columnFilter.js" type="text/javascript"></script>


<link href="<%=request.getContextPath() %>/css/jquery.dataTables.min.css" rel="stylesheet">


<form id="cancelAppForm" action="<%=cancelApplicationURL%>">
	
</form>


<div>
	<!-- title -->
	<aui:row>
		<h4 class="screenTitle">View Credit Applications</h4>
	</aui:row>
	
	<!-- new app button -->
	<aui:row>
	
		<div class="span3">
			<a class="btn btn-info btn-block" href="payment-calculator"><i class="icon-pencil"></i> New Application</a>
		</div>
	</aui:row>
	
	<!-- filters  -->
	<aui:row style="margin-top:15px">
		<label style="display:inline">Status </label>
		<span id="creditApplicationStatusFilter"></span>
		
		<label style="display:inline">Sales Rep </label>
		<span id="salesRepFilter"></span>
		
	</aui:row>
	
	<!-- apps table  -->
	
	
	<table id="appTable" class="table hover table-striped">
			<thead>
		            <tr>
		                <th>Status</th>
		                <th>Sales Rep</th>
		                <th>Customer Name</th>
		                <th>Modified Date</th>
		                <th>Actions</th>
		                
		            </tr>
		        </thead>
		 		<tfoot>
				    <tr>
						<th></th>
						<th></th>
						<th></th>
					</tr>
				</tfoot>
		</table>
	
</div>

<style>
	.dataTables_length, .dataTables_filter {
		margin-top: 10px;
	}
</style>

<script type="text/javascript">

$(document).ready(function() {
    $('#appTable').dataTable( {
        "ajax": "<%=creditApplicationsJsonURL%>",
        "columns": [
            { "data": "statusName" },
            { "data": "salesRepName" },
            { "data": "creditApp.customerName" },
            { "data": "creditApp.createDate" },
            
         
        ],
        "columnDefs": [ {
            "targets": 4,
            "data": "creditApp.creditAppId",
            "orderable" : false,
            "render" : function ( data, type, full, meta ) {
            	console.log (data);
            	
            	var href = '<a name="View" value="View"  href="payment-calculator?viewOnly=true&creditAppId='+ full.creditAppId +'"><i class="icon-search"></i> View</a>|'
            	href += '<a name="edit" value="Edit" href="payment-calculator?creditAppId='+ data +'" ><i class="icon-pencil"></i> Edit</a>|'
            	href += '<a name="manage" value="Manage Docs" href="manage-documents?creditAppId='+ data +'"><i class="icon-file"></i> Docs</a>|'
            	href += '<a name="cancel"  value="Cancel" href="#" onclick="$(\'#cancelAppForm\').submit()"><i class="icon-trash"></i> Cancel</a>';
            	
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
					sSelector: "#salesRepFilter"
					
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
</script>