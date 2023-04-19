<%@page import="com.emergentes.modelo.Estudiante"%>
<%@page import="java.util.ArrayList"%>
<%
    //recuperando la lsita del servlet de MainController.java
    ArrayList<Estudiante> lista = (ArrayList<Estudiante>) session.getAttribute("listaest");
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
    <center><h1>Registro de calificaciones</h1></center>
    <center><a href="MainController?op=nuevo"><button>Nuevo</button></a></center>
        <h4></h4>
        <center><table border="1">
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Parcial 1(30)</th>
                <th>Pafcial 2(30)</th>
                <th>Examen Fnl(40)</th>
                <th>Nota</th>
                <th></th>
                <th></th>
            </tr>

            <%
                if (lista != null) {

                    for (Estudiante item : lista) {
            %>

            <tr>
                <td> <%= item.getId()%> </td>
                <td> <%= item.getNombres()%> </td>
                <td> <%= item.getParcial1()%> </td>
                <td> <%= item.getParcial2()%> </td>                    
                <td> <%= item.getExamenFinal()%> </td>
                <td> <%= item.getNota()%> </td>
                <td><a href="MainController?op=editar&id=<%= item.getId()%>">Editar</a></td>
                <td><a href="MainController?op=eliminar&id=<%=item.getId()%>" 
                onclick="return confirm('¿Está seguro de eliminar el elemento con el nombre: <%=item.getNombres()%>?')">
                Eliminar
                </a>
                </td>

            <%                    }
                }
            %>

            </table></center>
    </body>
</html>
