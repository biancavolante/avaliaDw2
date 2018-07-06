<%-- 
    Document   : produto2
    Created on : 30/05/2018, 09:56:00
    Author     : Jaque
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style type="text/css">
            body{background-collor: #696969; color:white }
            #b {background-color: #000000; color:white}
            #c{background-color: #FF8C00}
        </style>
    </head>
    <body>
        <form method="post" action="${pageContext.request.contextPath}/CadastroMaquinaServlet">
         <table>
             <tr>  <input type="submit" name="ok"/> </tr>
             <tr>
               <th id ="b" width="40%">Digite o ID: </th>
               <th id ="c">Digite o nome:</th>
               <th id="b" width="50%" >Digite o valor hora: </th>
             </tr>
             <tr >
               <td id ="b" width="40%" align="justify"> <input type="text" name="idmaquina" size="100"/>  </td>
               <td id ="c" align="justify"><input type="text" name="nomemaquina"/> </td>
               <td id ="b" align="justify"> <input type="text" name="hora" size="100"/></td>
             </tr>
             
           </table> 
         <form method="post" action="${pageContext.request.contextPath}/CadastroMaquinaServlet">
         </form>
      
       
       
    </body>
</html>
