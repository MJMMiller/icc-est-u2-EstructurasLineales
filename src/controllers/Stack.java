package controllers;

import java.util.EmptyStackException;
import models.Node;

public class Stack {

    private Node top;
    private int size;

    public Stack() {
        this.top = null;
        this.size = 0;
    }

    //Metodo que ingrese un valor
    public void push(int value) {
        Node nuevoNodo = new Node(value);
        nuevoNodo.setNext(top);
        top = nuevoNodo;
        size++;
    }

    public int pop(){

        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int value = top.getValue();
        top = top.getNext();
        size--;
        return value;
    }

    public int peek(){
        if (isEmpty()) 
            throw new EmptyStackException();
        return top.getValue();
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void printStack(){
        Node current = top;
        while (current != null) {
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

    public int size(){
        return size;
    }
}