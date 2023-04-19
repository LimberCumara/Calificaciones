<%@page import="com.emergentes.modelo.Estudiante"%>
<%
    Estudiante item = (Estudiante) request.getAttribute("miEstudiante");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <center><div style="border: 2px solid black; display: inline-block; padding: 10px; margin: 10px;">
        <h2>PRIMER PARCIAL  TEM-742</h2>
        <h3>Nombre : Limber Cumara Mamani</h3>
        <h3>Carnet: 9141399 </h3>
        </div></center>
        <h2><center><%= (item.getId() == 0) ? "Registro de calificaciones" : "Editar calificaciones" %></center></h2>
        <div style="text-align: center;">
            <form action="MainController" method="post">
                <input type="hidden" name="id" value="<%= item.getId()%>">
                <div style="border: 2px solid black; display: inline-block; padding: 20px; text-align: left;">
                    <table>
                        <tr>                            
                            <td style="text-align: right">Nombre del estudiante:&nbsp;&nbsp;&nbsp;&nbsp;</td>
                            <td><input type="text" name="nombres" value="<%= item.getNombres()%>" size="80"></td>
                        </tr>
                        <tr>
                            <td style="text-align: right">Primer parcial (sobre 30 pts):&nbsp;&nbsp;&nbsp;&nbsp;</td>
                            <td><input type="text" name="parcial1" value="<%= item.getParcial1()%>" size="10"></td>
                        </tr>
                        <tr>
                            <td style="text-align: right">Segundo parcial (sobre 30 pts):&nbsp;&nbsp;&nbsp;&nbsp;</td>
                            <td><input type="text" name="parcial2" value="<%= item.getParcial2()%>" size="10"></td>
                        </tr>
                        <tr>
                            <td style="text-align: right">Examen final (sobre 40 pts):&nbsp;&nbsp;&nbsp;&nbsp;</td>
                            <td><input type="text" name="examenfinal" value="<%= item.getExamenFinal()%>" size="10"></td>
                        </tr>
                    </table>
                </div>
                <div style="text-align: center; padding: 10px">
                    <input type="submit" value="Enviar">
                </div>
            </form> 
        </div>




    </body>
</html>
