/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labarotior.pkg10;

/**
 *
 * @author Lenovo
 */
public class Nodo {
    int elem; // Dato del nodo
    Nodo prox; // Siguiente nodo
    Nodo ant; // Nodo anterior

   public Nodo(Nodo ant, int elem, Nodo prox) {
        this.elem = elem;
        this.prox = prox;
        this.ant = ant;
    }
}
