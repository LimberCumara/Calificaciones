package com.emergentes.modelo;

public class Estudiante {
    
    private int id;
    private String nombres;
    private int parcial1;
    private int parcial2;
    private int examenFinal;

    public Estudiante() {
    }

    public Estudiante(int id, String nombres, int parcial1, int parcial2, int examenFinal) {
        this.id = id;
        this.nombres = nombres;
        this.parcial1 = parcial1;
        this.parcial2 = parcial2;
        this.examenFinal = examenFinal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public int getParcial1() {
        return parcial1;
    }

    public void setParcial1(int parcial1) {
        this.parcial1 = parcial1;
    }

    public int getParcial2() {
        return parcial2;
    }

    public void setParcial2(int parcial2) {
        this.parcial2 = parcial2;
    }

    public int getExamenFinal() {
        return examenFinal;
    }

    public void setExamenFinal(int examenFinal) {
        this.examenFinal = examenFinal;
    }
    
    public int getNota() {
        int sumaDeNotas = parcial1 + parcial2 + examenFinal;
        return sumaDeNotas;
    }
    
}
