
$(document).ready(function() {
 $("#sal").click(function(){

var lstname=$("#lastname").val();

/*Snažil som sa to urobiť cez POST a pomocou dataType : json, zatial mi to funguje len s tým pluginom do Chrome, ktorý povoli Cross-Origin.
Ale cez postmana to funguje všetko ako má
*/

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





