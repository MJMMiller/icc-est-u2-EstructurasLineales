package controllers;

import java.util.EmptyStackException;
import models.Node;
import models.NodeGeneric;

public class ColaG<T> {

    private NodeGeneric<T> primero;
    private NodeGeneric<T> ultimo;
    private int size;

    public ColaG() {
        this.primero = null;
        this.ultimo = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return primero == null;
    }

    public void add(T valor) {
        NodeGeneric<T> nuevo = new NodeGeneric<T>(valor);
        if (isEmpty()) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            ultimo.setNext(nuevo);
            ultimo = nuevo;
        }
        size++;
    }

    public T remove() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T valor = primero.getValue();
        primero = primero.getNext();
        if (primero == null) {
            ultimo = null;
        }
        size--;
        return valor;
    }

    public T peek() {
        if (isEmpty())
            throw new EmptyStackException();
        return primero.getValue();
    }

    public int size() {
        return size;
    }

    public void printCola() {
        if (isEmpty()) {
            System.out.println("La cola está vacía.");
            return;
        }
        NodeGeneric<T> current = primero;
        while (current != null) {
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        }
        System.out.println();
    }
}