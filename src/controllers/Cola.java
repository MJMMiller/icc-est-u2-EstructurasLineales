package controllers;

import java.util.EmptyStackException;
import models.Node;

public class Cola {

    private Node primero;
    private Node ultimo;
    public int size;

    public Cola() {
        this.primero = null;
        this.ultimo = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return primero == null;
    }

    public void add(int valor) {
        Node nuevo = new Node(valor);
        if (isEmpty()) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            ultimo.setNext(nuevo);
            ultimo = nuevo;
        }
        size++;
    }

    public int remove(){
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int valor = primero.getValue();
        primero = primero.getNext();
        if (primero == null) {
            ultimo = null;
        }
        size--;
        return valor;
    }

    public int peek() {
        if (isEmpty())
            throw new EmptyStackException();
        return primero.getValue();
    }

    public void printCola(){
        if (isEmpty()) {
            System.out.println("La cola está vacía.");
            return;
        }
        Node current = primero;
        while (current != null) {
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        }
        System.out.println();
    }
}
