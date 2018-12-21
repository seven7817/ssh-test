$("#ajax").bind("input propertychange",function(){
	  $("#myTable").empty();
	  $.post("ajax",
	  {
	    name:$("#ajax").val()
	  },
	  function(data,status){
		  var obj = eval ("(" + data + ")");
		  for(var i = 0; i < obj.length; i++){
			  $("#myTable").append("<tr><td>用户id："+obj[i].id+"</td><td>用户名："+obj[i].name+"</td></tr>");
			}
	  });
	});
/* function loadXMLDoc()
{
var xmlhttp;
if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
	  $("#myDiv").text(xmlhttp.responseText);
    }
  }
xmlhttp.open("POST","ajax",true);
xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
xmlhttp.send("name="+$("#ajax").val());
} */