/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

/**
 *
 * @author Cris
 */
public class Tarea {

    private String nombreTarea;
    private String estado;
    private String descripcion;
    private String prioridad;

    public Tarea(String nombretarea, String estado, String descripcion, String prioridad) {
        this.nombreTarea = nombretarea;
        this.estado = estado;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
    }

    //Metodo para devolver lista de tareas en formato separado por comas para la creacion de un archivo.
    public static Tarea fromString(String tareaString) {
        String[] atributos = tareaString.split(","); //Los atributos están separados por ","
        String nombreTarea = atributos[0];
        String estado = atributos[1];
        String descripcion = atributos[2];
        String prioridad = atributos[3];
        return new Tarea(nombreTarea, estado, descripcion, prioridad);
    }

    // getters y setters
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getNombreTarea() {
        return nombreTarea;
    }

    public void setNombreTarea(String nombreTarea) {
        this.nombreTarea = nombreTarea;
    }

    public String toString() {
        return nombreTarea + ","+ estado + "," + descripcion + "," + prioridad;
    }
}
