<%--
/**
 * Copyright (c) 2000-present Tamarack, Inc. All rights reserved.
 * @author tamarack
 */
--%>

<%@ include file="init.jsp"%>

<div id="termsAndAgreementSection" class="span8" style="display:none;">

	<p style="padding:25px;">
	By Clicking "I Accept" below, the applicant(s) certifies that all information contained in this application, 
	and all attachments hereto, are true and accurate to the best of the applicant(s) knowledge and are made for 
	the purpose of obtaining credit for business purposes. The applicant(s) hereby authorize Creekridge Capital LLC and/or its 
	assigns to obtain and use business and consumer reports on the undersigned, now and from time to time, as may be needed in the credit 
	evaluation and review process and waives any right or claim the applicant(s) would otherwise have under the Fair Credit Reporting Act in 
	absence of this continuing consent. The applicant(s) further authorize any government agency, bank or financial institution to release credit 
	information on the applicant(s) account to Creekridge Capital LLC and/or its assigns. 
	If credit is extended, Applicant agrees that submitting an electronic, 
	photocopy or facsimile copy of a signed authorization shall be deemed to be binding, 
	valid, genuine and authentic as an original-signature document for all purposes.
	</p>

	<aui:button-row cssClass="offset-3">
		<a class="btn btn-primary" id="agreeBtn">I agree</a>
		<a class="btn" id="dontAgreeBtn">Return to Credit Application</a>
	</aui:button-row>
</div>

<style>
.button-holder{
	margin-left:20px;
}
</style>

<script type="text/javascript">

YUI().use(
		  'aui-datatable',
		  'aui-datatype',
		  'datatable-sort',
		  'panel',
		  'dd-plugin',
			  
	function(A) {
	
		var termsPanel = new A.Panel({
	        srcNode      : '#termsAndAgreementSection',
	        headerContent: 'Terms and Agreement',
	        //width        : 450,
	        zIndex       : 5,
	        centered     : true,
	        constrain	 : true,
	        modal        : true,
	        visible      : false,
	        render       : document.body,
	        plugins      : [A.Plugin.Drag],
	    });
		
		if (A.one('.btn-submit') != null) {
			 $('.btn-submit').on('click', function (e) {
				validateForm();
				
				if (!validator.hasErrors()) {
					$('#termsAndAgreementSection').show();
					 termsPanel.show();
				}
		  });
		}
		  
		if (A.one('#dontAgreeBtn') != null) {
		 A.one('#dontAgreeBtn').on('click', function (e) {
			  termsPanel.hide();
		    });
		}
		if (A.one('#agreeBtn') != null) {
		  
		  A.one('#agreeBtn').on('click', function (e) {
			  processAppButton(3);
			  termsPanel.hide();
		  });
		}
	} 
);


</script>