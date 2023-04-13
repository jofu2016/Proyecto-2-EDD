package App;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import java.util.Collections;
import java.util.Comparator;

public class MyLinkedList {

    Node head;
    LinkedList<Tarea> tareas;

    public MyLinkedList() {
        this.tareas = new LinkedList<>();
    }

    public void insert(String data) {
        Node node = new Node();
        node.data = data;
        node.next = null;

        // pregunta al usuario si quiere agregar una tarea
        this.tareas = new LinkedList<>();
        boolean agregarTarea = true;

        String[] estados = {"Completada", "En Proceso", "Cancelada"};
        String[] prioridades = {"Baja", "Media", "Alta"};

        while (agregarTarea) {
            String nombreTarea;
            do {
                nombreTarea = JOptionPane.showInputDialog("Ingrese el nombre de la tarea:");
                if (nombreTarea == null || nombreTarea.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un nombre de tarea válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } while (nombreTarea == null || nombreTarea.isEmpty());

            String estado;
            do {
                estado = (String) JOptionPane.showInputDialog(null, "Seleccione el estado de la tarea:", "Estado de la tarea", JOptionPane.PLAIN_MESSAGE, null, estados, estados[0]);
                if (estado == null) {
                    return;
                }
            } while (estado == null);

            String descripcion;
            do {
                descripcion = JOptionPane.showInputDialog("Ingrese la descripcion de la tarea:");
                if (descripcion == null || descripcion.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar una descripción de tarea válida.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } while (descripcion == null || descripcion.isEmpty());

            String prioridad;
            do {
                prioridad = (String) JOptionPane.showInputDialog(null, "Seleccione la prioridad de la tarea:", "Prioridad de la tarea", JOptionPane.PLAIN_MESSAGE, null, prioridades, prioridades[0]);
                if (prioridad == null) {
                    return;
                }
            } while (prioridad == null);

            Tarea tarea = new Tarea(nombreTarea, estado, descripcion, prioridad);
            tareas.add(tarea);

            int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea agregar otra tarea?", "", JOptionPane.YES_NO_OPTION);
            agregarTarea = respuesta == JOptionPane.YES_OPTION;
        }

        node.tareas = tareas;
        //node.head = tareas.getFirst();

        if (head == null) {
            head = node;
        } else {
            Node n = head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = node;
        }
    }

    public boolean eliminarLista(int index) {
        if (head == null) {
            return false; // La lista está vacía
        }

        if (index == 0) {
            head = head.getNext(); // Actualiza la cabeza para eliminar la primera lista
            return true;
        }

        Node listaActual = head;
        Node listaAnterior = null;
        int listIndex = 0;

        while (listaActual != null && listIndex != index) {
            listaAnterior = listaActual;
            listaActual = listaActual.getNext();
            listIndex++;
        }

        if (listaActual == null) {
            return false; // El índice está fuera de rango
        }

        listaAnterior.setNext(listaActual.getNext()); // Actualiza el puntero "next" de la lista anterior para eliminar la lista actual
        return true;
    }

    public boolean editarLista(int index) {
        String nuevoNombre;
        if (head == null) {
            return false; // La lista está vacía
        }

        Node listaActual = head;
        int listIndex = 0;

        while (listaActual != null && listIndex != index) {
            listaActual = listaActual.getNext();
            listIndex++;
        }

        if (listaActual == null) {
            return false; // El índice está fuera de rango
        }

        nuevoNombre = JOptionPane.showInputDialog(null, "Ingrese el nuevo nombre de la lista de tareas");

        if (nuevoNombre == null || nuevoNombre.isBlank()) {
            JOptionPane.showMessageDialog(null, "nombre ingresado no es válido.");
            return false;
        }

        listaActual.setData(nuevoNombre); // Actualizar el nombre de la lista seleccionada
        JOptionPane.showMessageDialog(null, "La lista está actualizada");
        return true;
    }

    public void agregarTarea(int index) {
        if (head == null) {
            JOptionPane.showMessageDialog(null, "La lista está vacía.");
            return;
        }

        Node listaActual = head;
        int listIndex = 0;

        while (listaActual != null && listIndex != index) {
            listaActual = listaActual.getNext();
            listIndex++;
        }

        if (listaActual == null) {
            JOptionPane.showMessageDialog(null, "índice está fuera de rango.");
            return;
        }
        
        String[] prioridades = {"Baja", "Media", "Alta"};
        String[] estados = {"Completada", "En Proceso", "Cancelada"};
        

        String nombreTarea;
        do {
            nombreTarea = JOptionPane.showInputDialog("Ingrese el nombre de la tarea:");
            if (nombreTarea == null) {
                return; // Salir de la función si se presiona "cancelar"
            } else if (nombreTarea.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un nombre de tarea válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (nombreTarea.isEmpty());

        String estado;
        do {
            estado = (String) JOptionPane.showInputDialog(null, "Seleccione el estado de la tarea:", "Estado de la tarea", JOptionPane.PLAIN_MESSAGE, null, estados, estados[0]);
            if (estado == null) {
                return;
            }
        } while (estado == null);

        String descripcion;
        do {
            descripcion = JOptionPane.showInputDialog("Ingrese la descripcion de la tarea:");
            if (descripcion == null || descripcion.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe ingresar una descripción de tarea válida.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (descripcion == null || descripcion.isEmpty());

        String prioridad;
        do {
            prioridad = (String) JOptionPane.showInputDialog(null, "Seleccione la prioridad de la tarea:", "Prioridad de la tarea", JOptionPane.PLAIN_MESSAGE, null, prioridades, prioridades[0]);
            if (prioridad == null) {
                return;
            }
        } while (prioridad == null);

        Tarea tareaNueva = new Tarea(nombreTarea, estado, descripcion, prioridad);
        listaActual.getTareas().add(tareaNueva);

        JOptionPane.showMessageDialog(null, "Tarea agregada exitosamente.");
    }

    public void eliminarTarea(int index, int tareaIndex) {
        Node listaActual = head;
        int listIndex = 0;

        while (listaActual != null && listIndex != index) {
            listaActual = listaActual.getNext();
            listIndex++;
        }

        if (listaActual == null) {
            JOptionPane.showMessageDialog(null, "El índice de lista está fuera de rango.");
            return;
        }

        LinkedList<Tarea> tareas = listaActual.getTareas();

        if (tareas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La lista de tareas está vacía.");
            return;
        }

        if (tareaIndex < 0 || tareaIndex >= tareas.size()) {
            JOptionPane.showMessageDialog(null, "El índice de tarea está fuera de rango.");
            return;
        }

        tareas.remove(tareaIndex);

        JOptionPane.showMessageDialog(null, "Tarea eliminada exitosamente.");
    }

    public void editarTareaPorIndice(int indexLista, int indexTarea) {
        if (head == null) {
            JOptionPane.showMessageDialog(null, "La lista está vacía.");
            return;
        }

        Node listaActual = head;
        int listIndex = 0;

        while (listaActual != null && listIndex != indexLista) {
            listaActual = listaActual.getNext();
            listIndex++;
        }

        if (listaActual == null) {
            JOptionPane.showMessageDialog(null, "El índice de la lista está fuera de rango.");
            return;
        }

        if (listaActual.getTareas().size() <= indexTarea) {
            JOptionPane.showMessageDialog(null, "El índice de la tarea está fuera de rango.");
            return;
        }

        // Obtener los detalles de la tarea
        Tarea tareaActual = listaActual.getTareas().get(indexTarea);
        String nombreActual = tareaActual.getNombreTarea();
        String estadoActual = tareaActual.getEstado();
        String descripcionActual = tareaActual.getDescripcion();
        String prioridadActual = tareaActual.getPrioridad();

        // Mostrar menú para seleccionar el valor a editar
        String[] opcionesMenu = {"Nombre", "Estado", "Descripción", "Prioridad"};
        // Crear un mensaje que muestre la información actual de la tarea
        String mensaje = "Información actual de la tarea:\n\n";
        mensaje += "    Nombre: " + tareaActual.getNombreTarea() + "\n";
        mensaje += "    Estado: " + tareaActual.getEstado() + "\n";
        mensaje += "    Descripción: " + tareaActual.getDescripcion() + "\n";
        mensaje += "    Prioridad: " + tareaActual.getPrioridad() + "\n\n";

        // Mostrar el cuadro de diálogo para que el usuario seleccione qué valor editar
        String opcionSeleccionada = (String) JOptionPane.showInputDialog(null, mensaje + "Seleccione el valor que desea editar:", "Editar tarea", JOptionPane.PLAIN_MESSAGE, null, opcionesMenu, opcionesMenu[0]);

        // Pedir al usuario el nuevo valor para la tarea
        String nuevoValor = "";
        switch (opcionSeleccionada) {
            case "Nombre":
                nuevoValor = JOptionPane.showInputDialog("Ingrese el nuevo nombre de la tarea:", nombreActual);
                break;
            case "Estado":
                String[] estados = {"Completada", "En Proceso", "Cancelada"};
                String estadoNuevo = (String) JOptionPane.showInputDialog(null, "Seleccione el nuevo estado de la tarea:", "Estado de la tarea", JOptionPane.PLAIN_MESSAGE, null, estados, estadoActual);
                nuevoValor = estadoNuevo;
                break;
            case "Descripción":
                nuevoValor = JOptionPane.showInputDialog("Ingrese la nueva descripcion de la tarea:", descripcionActual);
                break;
            case "Prioridad":
                String[] prioridades = {"Baja", "Media", "Alta"};
                String prioridadNueva = (String) JOptionPane.showInputDialog(null, "Seleccione la nueva prioridad de la tarea:", "Prioridad de la tarea", JOptionPane.PLAIN_MESSAGE, null, prioridades, prioridadActual);
                nuevoValor = prioridadNueva;
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción inválida.");
                return;
        }

        // Actualizar la tarea en la lista
        switch (opcionSeleccionada) {
            case "Nombre":
                tareaActual.setNombreTarea(nuevoValor);
                break;
            case "Estado":
                tareaActual.setEstado(nuevoValor);
                break;
            case "Descripción":
                tareaActual.setDescripcion(nuevoValor);
                break;
            case "Prioridad":
                tareaActual.setPrioridad(nuevoValor);
                break;
        }

        JOptionPane.showMessageDialog(null, "Tarea editada exitosamente.");
    }

    public String getListasYTareasInfo() {
        Node listaActual = head;
        if (head == null) {
            return "No hay listas creadas.";
        }

        String mensaje = "  Lista      Tarea\n";
        mensaje += "------------------------------------------------------\n";
        int i = 0;
        while (listaActual != null) {
            LinkedList<Tarea> tareas = listaActual.getTareas();
            mensaje += "(" + i + ") " + listaActual.getData() + ":\n";

            if (tareas.isEmpty()) {
                mensaje += "\tNo hay tareas por mostrar.\n";
            } else {
                for (int j = 0; j < tareas.size(); j++) {
                    Tarea tareaActual = tareas.get(j);
                    mensaje += "\t(" + j + ") " + tareaActual.getNombreTarea() + "(Prioridad: " + tareaActual.getPrioridad() + ", Estado: " + tareaActual.getEstado() + ")\n";
                }
            }

            listaActual = listaActual.getNext();
            i++;
        }

        return mensaje;
    }

    public void reportePorEstado() {
        // lista para almacenar todas las tareas de todas las listas
        LinkedList<Tarea> todasLasTareas = new LinkedList<>();
        Node node = head;
        while (node != null) {
            todasLasTareas.addAll(node.tareas);
            node = node.next;
        }

        // Ordenar las tareas por estado
        Collections.sort(todasLasTareas, new Comparator<Tarea>() {
            @Override
            public int compare(Tarea tarea1, Tarea tarea2) {
                return tarea1.getEstado().compareTo(tarea2.getEstado());
            }
        });

        // Mostrar las tareas ordenadas por estado
        String reporte = "";
        String estadoAnterior = "";

        for (Tarea tarea : todasLasTareas) {
            String estadoActual = "                " + tarea.getEstado().toUpperCase();

            if (!estadoActual.equals(estadoAnterior)) {
                if (!estadoAnterior.equals("")) {
                    reporte += "-o--o--o--o--o--o--o--o--o--o--o--o--o--o-\n\n";
                }
                reporte += estadoActual + ":\n";
                estadoAnterior = estadoActual;
            }

            reporte += tarea.getNombreTarea() + ":\n";
            reporte += "            Descripcion: " + tarea.getDescripcion() + "\n";
            reporte += "            Prioridad: " + tarea.getPrioridad() + "\n";
            reporte += "\n";
        }

        JOptionPane.showMessageDialog(null, reporte);
    }

    public void reportePorPrioridad() {

        LinkedList<Tarea> todasLasTareas = new LinkedList<>();
        Node node = head;
        while (node != null) {
            todasLasTareas.addAll(node.tareas);
            node = node.next;
        }

        // Ordenar las tareas por prioridad
        Collections.sort(todasLasTareas, new Comparator<Tarea>() {
            @Override
            public int compare(Tarea tarea1, Tarea tarea2) {
                return tarea1.getPrioridad().compareTo(tarea2.getPrioridad());
            }
        });

        String reporte = "";
        String prioridadAnterior = "";

        for (Tarea tarea : todasLasTareas) {
            String prioridadActual = "                " + tarea.getPrioridad().toUpperCase();

            if (!prioridadActual.equals(prioridadAnterior)) {
                if (!prioridadAnterior.equals("")) {
                    reporte += "-o--o--o--o--o--o--o--o--o--o--o--o--o--o-\n\n";
                }
                reporte += prioridadActual + ":\n";
                prioridadAnterior = prioridadActual;
            }

            reporte += tarea.getNombreTarea() + ":\n";
            reporte += "            Descripcion: " + tarea.getDescripcion() + "\n";
            reporte += "            Estado: " + tarea.getEstado() + "\n";
            reporte += "\n";
        }

        JOptionPane.showMessageDialog(null, reporte);
    }

    public void guardarEnArchivo(String nombreArchivo) {
        try {
            FileWriter fileWriter = new FileWriter(nombreArchivo);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            Node node = head;
            while (node != null) {
                bufferedWriter.write(node.data);
                bufferedWriter.newLine();
                for (Tarea tarea : node.tareas) {
                    bufferedWriter.write("\t" + tarea.toString());
                    bufferedWriter.newLine();
                }
                node = node.next;
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarDesdeArchivo(String nombreArchivo) {
        try {
            FileReader fileReader = new FileReader(nombreArchivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linea;
            Node node = null;
            Node lastNode = null; // variable para guardar el último nodo agregado

            while ((linea = bufferedReader.readLine()) != null) {
                if (node == null) {
                    node = new Node();
                    node.data = linea;
                    node.tareas = new LinkedList<>();
                    lastNode = node; // establecer el último nodo como el primer nodo
                    head = node;
                } else if (linea.startsWith("\t")) { // Si la línea comienza con una tabulación, se trata de una tarea
                    String[] tareaData = linea.substring(1).split(",");
                    Tarea tarea = new Tarea(tareaData[0], tareaData[1], tareaData[2], tareaData[3]); // Se elimina la tabulación antes de pasar la línea a fromString
                    node.tareas.add(tarea);
                } else { // Si la línea no comienza con una tabulación, se trata del nombre de una lista
                    node = new Node();
                    node.data = linea;
                    node.tareas = new LinkedList<>();
                    lastNode.next = node; // agregar el nuevo nodo después del último nodo existente
                    node.prev = lastNode; // establecer el anterior del nuevo nodo como el último nodo existente
                    lastNode = node; // establecer el último nodo como el nuevo nodo
                }
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}// fin del programa

