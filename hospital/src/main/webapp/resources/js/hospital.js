$(document).ready(function(){
    $("addRowBtn").click(function(){
        $.get("/hospital/ajax/patientBillingFormRow", function(data, status){
            //alert("Data: " + data + "\nStatus: " + status);
        	jQuery('#billingTable').append(data);
        	
        });
    });
});