$(document).ready(function()
{
if ($("#alertSuccess").text().trim() == "")
{
$("#alertSuccess").hide();
}
$("#alertError").hide();



});



// SAVE ============================================

$(document).on("click", "#btnSave", function(event)
		{
		// Clear alerts---------------------
		$("#alertSuccess").text("");
		$("#alertSuccess").hide();
		$("#alertError").text("");
		$("#alertError").hide();
		// Form validation-------------------
		var status = validateItemForm();
		if (status != true)
		{
		$("#alertError").text(status);
		$("#alertError").show();
		return;
		}
		// If valid------------------------
		var type = ($("#hidItemIDSave").val() == "") ? "POST" : "PUT";
		
		
		$.ajax(
				{
				url : "userAPI",
				type : type,
				data : $("#formItem").serialize(),
				dataType : "text",
				complete : function(response, status)
				{
				onItemSaveComplete(response.responseText, status);
				}
				});
			});





	function onItemSaveComplete(response, status)
	{
				if (status == "success")
				{
				var resultSet = JSON.parse(response);
				if (resultSet.status.trim() == "success")
				{
				$("#alertSuccess").text("Successfully saved.");
				$("#alertSuccess").show();
				$("#divItemsGrid").html(resultSet.data);
				} else if (resultSet.status.trim() == "error")
				{
				$("#alertError").text(resultSet.data);
				$("#alertError").show();
				}
				} else if (status == "error")
				{
				$("#alertError").text("Error while saving.");
				$("#alertError").show();
				} else
				{
				$("#alertError").text("Unknown error while saving..");
				$("#alertError").show();
				}
				
				$("#hidItemIDSave").val("");
				$("#formItem")[0].reset();
	}
//Admin INSERT---------------------------------------
$(document).on("click", "#btnSaveA", function(event)
		{
		// Clear alerts---------------------
		$("#alertSuccess").text("");
		$("#alertSuccess").hide();
		$("#alertError").text("");
		$("#alertError").hide();
		// Form validation-------------------
		var status = validateItemForm();
		if (status != true)
		{
		$("#alertError").text(status);
		$("#alertError").show();
		return;
		}
		// If valid------------------------
		var type = ($("#hidItemIDSaveA").val() == "") ? "POST" : "PUT";
		
		
		$.ajax(
				{
				url : "adminAPI",
				type : type,
				data : $("#formItem").serialize(),
				dataType : "text",
				complete : function(response, status)
				{
				onItemSaveComplete(response.responseText, status);
				}
				});
			});





	function onItemSaveComplete(response, status)
	{
				if (status == "success")
				{
				var resultSet = JSON.parse(response);
				if (resultSet.status.trim() == "success")
				{
				$("#alertSuccess").text("Successfully saved.");
				$("#alertSuccess").show();
				$("#divItemsGrid").html(resultSet.data);
				} else if (resultSet.status.trim() == "error")
				{
				$("#alertError").text(resultSet.data);
				$("#alertError").show();
				}
				} else if (status == "error")
				{
				$("#alertError").text("Error while saving.");
				$("#alertError").show();
				} else
				{
				$("#alertError").text("Unknown error while saving..");
				$("#alertError").show();
				}
				
				$("#hidItemIDSaveA").val("");
				$("#formItem")[0].reset();
	}
	
//RESEARCHER INSERT------------------------------------

$(document).on("click", "#btnSaveR", function(event)
		{
		// Clear alerts---------------------
		$("#alertSuccess").text("");
		$("#alertSuccess").hide();
		$("#alertError").text("");
		$("#alertError").hide();
		// Form validation-------------------
		var status = validateItemForm();
		if (status != true)
		{
		$("#alertError").text(status);
		$("#alertError").show();
		return;
		}
		// If valid------------------------
		var type = ($("#hidItemIDSaveR").val() == "") ? "POST" : "PUT";
		
		
		$.ajax(
				{
				url : "researchAPI",
				type : type,
				data : $("#formItem").serialize(),
				dataType : "text",
				complete : function(response, status)
				{
				onItemSaveComplete(response.responseText, status);
				}
				});
			});





	function onItemSaveComplete(response, status)
	{
				if (status == "success")
				{
				var resultSet = JSON.parse(response);
				if (resultSet.status.trim() == "success")
				{
				$("#alertSuccess").text("Successfully saved.");
				$("#alertSuccess").show();
				$("#divItemsGrid").html(resultSet.data);
				} else if (resultSet.status.trim() == "error")
				{
				$("#alertError").text(resultSet.data);
				$("#alertError").show();
				}
				} else if (status == "error")
				{
				$("#alertError").text("Error while saving.");
				$("#alertError").show();
				} else
				{
				$("#alertError").text("Unknown error while saving..");
				$("#alertError").show();
				}
				
				$("#hidItemIDSaveR").val("");
				$("#formItem")[0].reset();
	}	
	
	

//UPDATE==========================================
$(document).on("click", ".btnUpdate", function(event)
{ 
$("#hidItemIDSave").val($(this).data("id")); 
$("#first_name").val($(this).closest("tr").find('td:eq(0)').text()); 
$("#last_name").val($(this).closest("tr").find('td:eq(1)').text()); 
$("#em").val($(this).closest("tr").find('td:eq(2)').text()); 
$("#usern").val($(this).closest("tr").find('td:eq(3)').text()); 
$("#pass").val($(this).closest("tr").find('td:eq(4)').text()); 
});

//ADMIN UPDATE==========================================
$(document).on("click", ".btnUpdateA", function(event)
{ 
$("#hidItemIDSaveA").val($(this).data("id")); 
$("#first_name").val($(this).closest("tr").find('td:eq(0)').text()); 
$("#last_name").val($(this).closest("tr").find('td:eq(1)').text()); 
$("#em").val($(this).closest("tr").find('td:eq(2)').text()); 
$("#usern").val($(this).closest("tr").find('td:eq(3)').text()); 
$("#pass").val($(this).closest("tr").find('td:eq(4)').text()); 
});

//UPDATE RESEARCHER----------------------------------------
$(document).on("click", ".btnUpdateR", function(event)
{ 
$("#hidItemIDSaveR").val($(this).data("id")); 
$("#first_name").val($(this).closest("tr").find('td:eq(0)').text()); 
$("#last_name").val($(this).closest("tr").find('td:eq(1)').text()); 
$("#em").val($(this).closest("tr").find('td:eq(2)').text()); 
$("#usern").val($(this).closest("tr").find('td:eq(3)').text()); 
$("#pass").val($(this).closest("tr").find('td:eq(4)').text()); 
});

//delete====================================================
$(document).on("click", ".btnRemove", function(event)
{ 
 $.ajax( 
 { 
 url : "userAPI", 
 type : "DELETE", 
 data : "id=" + $(this).data("id"),
 dataType : "text", 
 complete : function(response, status) 
 { 
 onItemDeleteComplete(response.responseText, status); 
 } 
 }); 
});

//DELTE ADMIN-------------------------------------
$(document).on("click", ".btnRemoveA", function(event)
{ 
 $.ajax( 
 { 
 url : "adminAPI", 
 type : "DELETE", 
 data : "id=" + $(this).data("id"),
 dataType : "text", 
 complete : function(response, status) 
 { 
 onItemDeleteComplete(response.responseText, status); 
 } 
 }); 
});

//DELETE RESEARCHER-------------------------------
$(document).on("click", ".btnRemoveR", function(event)
{ 
 $.ajax( 
 { 
 url : "researchAPI", 
 type : "DELETE", 
 data : "id=" + $(this).data("id"),
 dataType : "text", 
 complete : function(response, status) 
 { 
 onItemDeleteComplete(response.responseText, status); 
 } 
 }); 
})



function onItemDeleteComplete(response, status)
{ 
if (status == "success") 
 { 
 var resultSet = JSON.parse(response); 
 if (resultSet.status.trim() == "success") 
 { 
 $("#alertSuccess").text("Successfully deleted."); 
 $("#alertSuccess").show(); 
 $("#divItemsGrid").html(resultSet.data); 
 } else if (resultSet.status.trim() == "error") 
 { 
 $("#alertError").text(resultSet.data); 
 $("#alertError").show(); 
 } 
 } else if (status == "error") 
 { 
 $("#alertError").text("Error while deleting."); 
 $("#alertError").show(); 
 } else
 { 
 $("#alertError").text("Unknown error while deleting.."); 
 $("#alertError").show(); 
 } 
}






//CLIENT-MODEL================================================================
function validateItemForm()
{
// CODE
if ($("#first_name").val().trim() == "")
{
return "Insert first name.";
}
// NAME
if ($("#last_name").val().trim() == "")
{
return "Insert last name.";
}


//PRICE-------------------------------
if ($("#em").val().trim() == "")
{
return "Insert email.";
}

// DESCRIPTION------------------------
if ($("#usern").val().trim() == "")
{
return "Insert username.";
}
// DESCRIPTION------------------------
if ($("#pass").val().trim() == "")
{
return "Insert password.";
}
return true;
}

//Uset Log-----------------------
 
