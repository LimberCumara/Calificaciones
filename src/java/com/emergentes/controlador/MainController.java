package com.emergentes.controlador;

import com.emergentes.modelo.Estudiante;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //recuperando el parametro op de los enlaces
        String op = request.getParameter("op");
        //Similar a un if -> (condicion) ? Verdadero : Falso
        String opcion = (op == null) ? "view" : op;

        //Creando el objeto sesion
        HttpSession ses = request.getSession();

        //Preguntamos si existe el atributo id
        if (ses.getAttribute("id") == null) {
            int contador = 0;
            ses.setAttribute("id", contador);
        }

        int contador = (int) ses.getAttribute("id");

        //Preguntando si existe el atributo
        if (ses.getAttribute("listaest") == null) {

            //creando la lista de objetos
            ArrayList<Estudiante> listaux = new ArrayList<Estudiante>();

            //colocar la lista como atributo
            ses.setAttribute("listaest", listaux);

        }

        //Obteniendo los datos de la listaux
        ArrayList<Estudiante> lista = (ArrayList<Estudiante>) ses.getAttribute("listaest");

        Estudiante obj1 = new Estudiante();
        int id, pos;

        switch (opcion) {
            case "nuevo":
                request.setAttribute("miEstudiante", obj1);
                request.setAttribute("id", contador + 1);
                ses.setAttribute("id", contador + 1);
                //segunda forma de redireccionar o de transferencia mandando objetos
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
            case "editar":
                id = Integer.parseInt(request.getParameter("id"));
                pos = buscarIndice(request, id);
                obj1 = lista.get(pos);
                request.setAttribute("miEstudiante", obj1);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
            case "eliminar":
                pos = buscarIndice(request, Integer.parseInt(request.getParameter("id")));
                lista.remove(pos);
                ses.setAttribute("listaest", lista);
                response.sendRedirect("index.jsp");
                break;
            case "view":
                //primera forma de rediccionar o de transferencia
                response.sendRedirect("index.jsp");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String nombres = request.getParameter("nombres");
        int parcial1 = Integer.parseInt(request.getParameter("parcial1"));
        int parcial2 = Integer.parseInt(request.getParameter("parcial2"));
        int examenfinal = Integer.parseInt(request.getParameter("examenfinal"));

        Estudiante objest = new Estudiante();
        objest.setId(id);
        objest.setNombres(nombres);
        objest.setParcial1(parcial1);
        objest.setParcial2(parcial2);
        objest.setExamenFinal(examenfinal);

        HttpSession ses = request.getSession();
        ArrayList<Estudiante> lista = (ArrayList<Estudiante>) ses.getAttribute("listaest");
        
        int idt = objest.getId();
        
        if (idt == 0) {
            int ultId;
            ultId = ultimoId(request);
            objest.setId(ultId);
            lista.add(objest);
        } else {
            lista.set(buscarIndice(request, idt), objest);
        }
        
        ses.setAttribute("listaest", lista);
        response.sendRedirect("index.jsp");
    }
    
    private int buscarIndice(HttpServletRequest request, int id) {
        HttpSession ses = request.getSession();
        ArrayList<Estudiante> lista = (ArrayList<Estudiante>) ses.getAttribute("listaest");
        
        int i = 0;
        if (lista.size() > 0) {
            
            while (i < lista.size()) {                
                if (lista.get(i).getId() == id) {
                    break;
                } else {
                    i++;
                }
            }
        }
        
        return i;
    }
    
    private int ultimoId(HttpServletRequest request) {
        HttpSession ses = request.getSession();
        ArrayList<Estudiante> lista = (ArrayList<Estudiante>) ses.getAttribute("listaest");
        
        int idaux = 0;
        
        for (Estudiante item : lista) {
            idaux = item.getId();
        }
        
        return idaux + 1;
    }

}
