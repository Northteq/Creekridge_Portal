<%@page import="com.tamarack.creekridge.service.CreditAppPrincipalLocalServiceUtil"%>
<%@page import="com.tamarack.creekridge.model.CreditAppPrincipal"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@page import="java.util.*"%>
<portlet:defineObjects />

<%


%>
<portlet:actionURL var="updatePurchaseOptionLookUpValuesUrl" >
<portlet:param name="<%= javax.portlet.ActionRequest.ACTION_NAME %>" value="updatePurchaseOptionLookUpValues" />
</portlet:actionURL>

<portlet:actionURL var="updateTermLookUpValuesUrl" >
<portlet:param name="<%= javax.portlet.ActionRequest.ACTION_NAME %>" value="updateTermLookUpValues" />
</portlet:actionURL>

<portlet:actionURL var="updateProductLookUpValuesUrl" >
<portlet:param name="<%= javax.portlet.ActionRequest.ACTION_NAME %>" value="updateProductLookUpValues" />
</portlet:actionURL>

<portlet:actionURL var="updateCreditStatusLookUpValuesUrl" >
<portlet:param name="<%= javax.portlet.ActionRequest.ACTION_NAME %>" value="updateCreditStatusLookUpValues" />
</portlet:actionURL>



<portlet:actionURL var="updateRateFactorRuleTableLookUpValuesUrl" >
  <portlet:param name="<%= javax.portlet.ActionRequest.ACTION_NAME %>" value="updateRateFactorRuleLookUpValues" />
</portlet:actionURL>

<div>
<aui:form id="ProductLookUp" name="UpdateProductOptions"  method="post" action="<%=updateProductLookUpValuesUrl.toString()%>">

	<table>
		<tr>
			<td>
				<div><h4><b>Product Price Look Up  Info:</b></h4></div>
				<div>
				
				 <aui:input type="text" name="productName" label="Product Name" value=""></aui:input>
				
			    </div>
			    <div>
				
				 <aui:input type="text"  name="sequenceNumber" label="Sequence Number" vale=""></aui:input><br>
			    </div>
			    
				
			</td>
			
		</tr>
	</table>
	<aui:button type="submit" name="Submit Product Option"  label="Submit Product Option"/>

</aui:form>
</div>
<hr>
<br>
<aui:form name="updatePurchaseOptionLookUpValues" method="post" action="<%=updatePurchaseOptionLookUpValuesUrl%>">
<div>
	<table>
		<tr>
			<td>
				<div><h4><b>Purchase Option Look Up  Info:</b></h4></div>
				
				<div>
				
				 <aui:input type="text"  name="purchaseOptionName" label="Purchase Option Name" />
				
			    </div>
			    <div>
				
				 <aui:input type="text"  name="sequenceNumber" label="Sequence Number"/><br>
			    </div>
			</td>
			
		</tr>
	</table>
</div>
<aui:input type="submit" name="Submit Purchase Option"/>
</aui:form>
<hr>
<br>
<aui:form name="updateTermLookUpValues" method="post" action="<%=updateTermLookUpValuesUrl%>">
<div>
	<table>
		<tr>
			<td>
				<div><h4><b>Term Option Look Up  Info:</b></h4></div>
				<div>
				 <aui:input type="text"  name="termName" value="" label="Term Option Name"/>
				
			    </div>
			    <div>
				
				 <aui:input type="text"  name="termMonths" label="Term Months" />
				 </div>
			    <div>
				 <aui:input type="text"  name="sequenceNumber"  label="Sequence Number" /><br>
			    </div>
			</td>
			
		</tr>
	</table>
</div>
<aui:input type="submit" name="Submit Purchase Option" />
</aui:form>
<hr>
<br>
<div>
<aui:form id="CreditStatusLookUp" name="UpdateCreditStatuOptions"  method="post" action="<%=updateCreditStatusLookUpValuesUrl.toString()%>">

	<table>
		<tr>
			<td>
				<div><h4><b>Credit Status Look Up  Info:</b></h4></div>
				<div>
				
				 <aui:input type="text" name="creditAppStatusName"  label="Credit Application Status" value=""></aui:input>
				
			    </div>
			   
				
			</td>
			
		</tr>
	</table>
	<aui:button type="submit" name="Submit Credit App Status"  value="Submit Credit App Status"/>

</aui:form>
</div>
<hr>
<br>
<div>
<aui:form id="CreditStatusLookUp" name="UpdateRateFactorTable"  method="post" action="<%=updateRateFactorRuleTableLookUpValuesUrl.toString()%>">

	<table>
		<tr>
			<td>
				<div><h4><b>Rate Factor Rule Table Look Up  Info:</b></h4></div>
				<div>
				
				 <aui:input type="text" name="creditAppStatusName"  value=""></aui:input>
				
			    </div>
			   
				
			</td>
			
		</tr>
	</table>
	<aui:button type="submit" name="Submit Credit App Status"  value="Submit Credit App Status"/>

</aui:form>
</div>