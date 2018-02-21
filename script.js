
$(document).ready(function() {
 $("#sal").click(function(){

var lstname=$("#lastname").val();



$.ajax({
        url : "http://localhost:8080/employees/salary",

        type: "POST",
        data: JSON.stringify({"name": lstname}),
        contentType: "application/json; charset=utf-8",
        dataType   : "json",

   
        success : function(data_response){
    $("#salary").text(data_response+"€");
          }  
        
    });




});
  


    

   
   

 
});





