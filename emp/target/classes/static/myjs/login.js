$( document ).ready(function() {
    $(".actionBtn").click(function(){
    	var action = $(this).attr("action");
    	alert(action);
    	if(action=="LS")
    	{
    		$("#loginForm").submit();
    	}
    	else if(action=="SR")
    	{
    		$("#signupDivId").show();
    		$("#loginDivId").hide();
    	}
    	else if(action=="LR")
    	{
    		$("#signupDivId").hide();
    		$("#loginDivId").show();
    	}
    		
    	
    });
});