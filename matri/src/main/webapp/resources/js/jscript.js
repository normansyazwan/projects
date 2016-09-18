/* 
  jQuery ready function. Specify a function to 
  execute when the DOM is fully loaded.
*/
$(document).ready( function ()
{
  /* we are assigning change event handler for select box */
	/* it will run when selectbox options are changed */
	$('#treatment').change(function()
	{
		/* setting currently changed option value to option variable */
		var option = $(this).find('option:selected').val();
		/* setting input box value to selected option value */
		$('#fees').val(option);
	});
	
	

	
	

		
});

/*
	This is to handle delete funcationality on Assessment history. Copies assessmentId to the hidden textbox in modal's form.
*/
function copyAssessmentIdToModal(el) {
    var assId = $(el).attr('assId');
    document.getElementById("assessmentIdToDelete").value = assId;
}
