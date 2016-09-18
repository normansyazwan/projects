/* 
  jQuery ready function. Specify a function to 
  execute when the DOM is fully loaded.
 */
$(document).ready(function() {

	/* ajax request */

	// callback handler for form submit
	$("#ajaxform").submit(function(e) {
		var postData = $(this).serializeArray();
		var formURL = $(this).attr("action");
		$.ajax({
			url : formURL,
			type : "POST",
			data : postData,
			success : function(data, textStatus, jqXHR) {
				// data: return data from server
				$("#outp").html(data[0].firstName);
			},
			error : function(jqXHR, textStatus, errorThrown) {
				// if fails
			}
		});
		e.preventDefault(); // STOP default action
		e.unbind(); // unbind. to stop multiple form submit.
	});

});
