/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labarotior.pkg10;

/**
 *
 * @author larzekao
 */


public class Lista {
    private ListaDoEnlazada[] listas;
    private int max;
    private int canElem;

    public Lista(int max) {
        this.max = max;
        this.canElem = max;
        this.listas = new ListaDoEnlazada[max];
        for (int i = 0; i < max; i++) {
            listas[i] = new ListaDoEnlazada(); 
        }
    }
        // Método que inserta el valor x al final de la última lista disponible
    public void insertarUlt(int x) {
       
        this.listas[max - 1].insertarUlt(x); 
    }


    // Método que inserta el valor x en orden ascendente según el número de dígitos
    public void insertarAsc(int x) {
        int cont = 0;
        int aux = x;
       
        while (aux > 0) {
            aux = aux / 10;
            cont++;
        }
      
        this.listas[cont].insertarAsc(x);
    }

    // Método que inserta el valor x en orden descendente según el número de dígitos
    public void insertarDec(int x) {
        int cont = 0;
        int aux = x;
        // Contar los dígitos de x usando el bucle while
        while (aux > 0) {
            aux = aux / 10;
            cont++;
        }
        
        this.listas[cont].insertarDes(x);
    }

      
   @Override
    public String toString() {
        StringBuilder cad = new StringBuilder();
        for (int i = 0; i < this.canElem; i++) {
            if (!listas[i].vacio()) { 
                cad.append(this.listas[i].toString()).append("\n");
            }
        }
        return cad.toString().trim(); 
    }


}

