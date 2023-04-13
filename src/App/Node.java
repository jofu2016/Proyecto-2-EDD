package App;

import java.util.LinkedList;

public class Node {

    String data;
    Node next;
    Node prev;
    Node head;
    Node first;
    LinkedList<Tarea> tareas;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public LinkedList<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(LinkedList<Tarea> tareas) {
        this.tareas = tareas;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getFirst() {
        return head;
    }

    public void setFirst(Node first) {
        this.first = first;
    }

}
