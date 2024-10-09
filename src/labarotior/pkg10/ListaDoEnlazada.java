package labarotior.pkg10;

public class ListaDoEnlazada {

    private int cantElem;
    public Nodo ult;
    public Nodo prim;

    public ListaDoEnlazada() {
        prim = ult = null;
        cantElem = 0;
    }
    

    // Método que devuelve una cadena representando los elementos de la lista
    @Override
  public String toString() {
    String s = "["; 
    Nodo p = prim;
    while (p != null) {
        s += p.elem; 
        if (p.prox != null) {
            s += ", ";
        }
        p = p.prox; 
    }
    s += "]"; 
    return s; 
}


    // Método que inserta un nodo entre dos nodos existentes
    public void insertarNodo(int x, Nodo ap, Nodo p) {
        Nodo nuevo = new Nodo(ap, x, p);
        if (ap == null) {
            prim = nuevo;
        } else {
            ap.prox = nuevo;
        }
        if (p == null) {
            ult = nuevo;
        } else {
            p.ant = nuevo;
        }
        cantElem++;
    }

    // Método que inserta el elemento x al principio de la lista
    public void insertarPrim(int x) {
        insertarNodo(x, null, prim);
    }

    // Método que inserta el elemento x al final de la lista
    public void insertarUlt(int x) {
        insertarNodo(x, ult, null);
    }

    // Método que inserta el elemento x en la posición i de la lista
    public void insertarIesimo(int x, int i) {
        Nodo p = prim, ap = null;
        int k = 0;
        while (p != null && k < i) {
            ap = p;
            p = p.prox;
            k++;
        }
        insertarNodo(x, ap, p);
    }

    // Método que inserta todos los elementos de L2 en la lista L1, desde la posición i
    public void insertarIesimo(ListaDoEnlazada L2, int i) {
        Nodo p = L2.prim;
        while (p != null) {
            insertarIesimo(p.elem, i);
            p = p.prox;
            i++;
        }
    }
     // Método que devuelve el mayor elemento de la lista
    public int mayorElem() {
        if (prim == null) return Integer.MIN_VALUE; // Si la lista está vacía
        int max = prim.elem;
        Nodo p = prim.prox;
        while (p != null) {
            if (p.elem > max) {
                max = p.elem;
            }
            p = p.prox;
        }
        return max;
    }

    // Método que devuelve el menor elemento de la lista
    public int menorElem() {
        if (prim == null) return Integer.MAX_VALUE; // Si la lista está vacía
        int min = prim.elem;
        Nodo p = prim.prox;
        while (p != null) {
            if (p.elem < min) {
                min = p.elem;
            }
            p = p.prox;
        }
        return min;
    }

    // Método que verifica si todos los elementos de L1 son diferentes
    public boolean diferentes() {
        Nodo p = prim;
        while (p != null && p.prox != null) {
            Nodo aux = p.prox;
            while (aux != null) {
                if (p.elem == aux.elem) {
                    return false;
                }
                aux = aux.prox;
            }
            p = p.prox;
        }
        return true;
    }

    // Método que verifica si la lista es un palíndromo
    public boolean palindrome() {
        if (prim == null || prim == ult) return true; // Lista vacía o de un elemento es palíndromo
        Nodo p1 = prim;
        Nodo p2 = ult;
        while (p1 != null && p2 != null && p1 != p2 && p1.prox != p2) {
            if (p1.elem != p2.elem) {
                return false;
            }
            p1 = p1.prox;
            p2 = p2.ant;
        }
        return true;
    }


    // Método que inserta todos los elementos de L2 al principio de L1
    public void insertarPrim(ListaDoEnlazada L2) {
        Nodo p = L2.ult;
        while (p != null) {
            insertarPrim(p.elem);
            p = p.ant;
        }
    }

    // Método que inserta todos los elementos de L2 al final de L1
    public void insertarUlt(ListaDoEnlazada L2) {
        Nodo p = L2.prim;
        while (p != null) {
            insertarUlt(p.elem);
            p = p.prox;
        }
    }

    // Método que inserta un elemento en su lugar correspondiente en orden ascendente
    public void insertarAsc(int x) {
        Nodo p = prim, ap = null;
        while (p != null && x > p.elem) {
            ap = p;
            p = p.prox;
        }
        insertarNodo(x, ap, p);
    }

    // Método que inserta un elemento en su lugar correspondiente en orden descendente
    public void insertarDes(int x) {
        Nodo p = prim, ap = null;
        while (p != null && x < p.elem) {
            ap = p;
            p = p.prox;
        }
        insertarNodo(x, ap, p);
    }
     public void concatenar(ListaDoEnlazada L2, ListaDoEnlazada L3) {
        this.insertarUlt(L2);
        this.insertarUlt(L3);
    }

    public void intercalar(ListaDoEnlazada L2, ListaDoEnlazada L3) {
        Nodo p1 = L2.prim;
        Nodo p2 = L3.prim;
        while (p1 != null || p2 != null) {
            if (p1 != null) {
                this.insertarUlt(p1.elem);
                p1 = p1.prox;
            }
            if (p2 != null) {
                this.insertarUlt(p2.elem);
                p2 = p2.prox;
            }
        }
    }

    public void merge(ListaDoEnlazada L2, ListaDoEnlazada L3) {
        Nodo p1 = L2.prim;
        Nodo p2 = L3.prim;
        while (p1 != null && p2 != null) {
            if (p1.elem <= p2.elem) {
                this.insertarUlt(p1.elem);
                p1 = p1.prox;
            } else {
                this.insertarUlt(p2.elem);
                p2 = p2.prox;
            }
        }
        while (p1 != null) {
            this.insertarUlt(p1.elem);
            p1 = p1.prox;
        }
        while (p2 != null) {
            this.insertarUlt(p2.elem);
            p2 = p2.prox;
        }
    }

    public boolean ordenado() {
        if (prim == null || prim.prox == null) return true;

        boolean ascendente = true, descendente = true;
        Nodo p = prim;

        while (p.prox != null) {
            if (p.elem > p.prox.elem) ascendente = false;
            if (p.elem < p.prox.elem) descendente = false;
            p = p.prox;
        }

        return ascendente || descendente;
    }
       // Método que devuelve la posición de la primera ocurrencia del elemento x
    public int indexOf(int x) {
        Nodo p = prim;
        int index = 0;
        while (p != null) {
            if (p.elem == x) {
                return index;
            }
            p = p.prox;
            index++;
        }
        return -1; // No se encuentra el elemento
    }

    // Método que devuelve la posición de la primera ocurrencia del elemento x desde la posición i
    public int indexOf(int x, int i) {
        Nodo p = prim;
        int index = 0;

        // Saltar los primeros i elementos
        while (p != null && index < i) {
            p = p.prox;
            index++;
        }

        // Buscar desde la posición i
        while (p != null) {
            if (p.elem == x) {
                return index;
            }
            p = p.prox;
            index++;
        }
        return -1; // No se encuentra el elemento
    }

    // Método que devuelve la posición de la última ocurrencia del elemento x
    public int lastIndexOf(int x) {
        Nodo p = ult;
        int index = cantElem - 1; // Empezamos desde el final
        while (p != null) {
            if (p.elem == x) {
                return index;
            }
            p = p.ant;
            index--;
        }
        return -1; // No se encuentra el elemento
    }

    // Método que devuelve la posición de la primera ocurrencia del elemento x desde la posición i, buscando hacia la izquierda
    public int lastIndexOf(int x, int i) {
        Nodo p = ult;
        int index = cantElem - 1;

        // Saltar hasta la posición i
        while (p != null && index > i) {
            p = p.ant;
            index--;
        }

        // Buscar hacia la izquierda
        while (p != null) {
            if (p.elem == x) {
                return index;
            }
            p = p.ant;
            index--;
        }
        return -1; // No se encuentra el elemento
    }

    // Método que reemplaza todas las ocurrencias del elemento x por el elemento y
    public void reemplazar(int x, int y) {
        Nodo p = prim;
        while (p != null) {
            if (p.elem == x) {
                p.elem = y;
            }
            p = p.prox;
        }
    }

    // Método que verifica si el elemento x se encuentra en la lista
    public boolean seEncuentra(int x) {
        Nodo p = prim;
        while (p != null) {
            if (p.elem == x) {
                return true;
            }
            p = p.prox;
        }
        return false;
    }

    // Método que devuelve la cantidad de veces que aparece el elemento x
    public int frecuencia(int x) {
        int count = 0;
        Nodo p = prim;
        while (p != null) {
            if (p.elem == x) {
                count++;
            }
            p = p.prox;
        }
        return count;
    }

    // Método que devuelve true si existe algún elemento que se repite exactamente k veces
    public boolean existeFrec(int k) {
        Nodo p = prim;
        while (p != null) {
            if (frecuencia(p.elem) == k) {
                return true;
            }
            p = p.prox;
        }
        return false;
    }

    // Método que devuelve true si todos los elementos tienen la misma frecuencia
    public boolean mismasFrec() {
        if (prim == null) return true; // Si la lista está vacía
        int freq = frecuencia(prim.elem); // Obtener frecuencia del primer elemento
        Nodo p = prim.prox;
        while (p != null) {
            if (frecuencia(p.elem) != freq) {
                return false; // Si cualquier otro elemento tiene frecuencia distinta
            }
            p = p.prox;
        }
        return true;
    }

    // Método que devuelve true si la lista contiene al menos un elemento par
    public boolean existePar() {
        Nodo p = prim;
        while (p != null) {
            if (p.elem % 2 == 0) {
                return true;
            }
            p = p.prox;
        }
        return false;
    }

    // Método que devuelve true si la lista contiene al menos un elemento impar
    public boolean existeImpar() {
        Nodo p = prim;
        while (p != null) {
            if (p.elem % 2 != 0) {
                return true;
            }
            p = p.prox;
        }
        return false;
    }

    // Método que devuelve true si todos los elementos de la lista son pares
    public boolean todoPares() {
        Nodo p = prim;
        while (p != null) {
            if (p.elem % 2 != 0) {
                return false;
            }
            p = p.prox;
        }
        return true;
    }

    // Método que devuelve true si todos los elementos de la lista son impares
    public boolean todoImpares() {
        Nodo p = prim;
        while (p != null) {
            if (p.elem % 2 == 0) {
                return false;
            }
            p = p.prox;
        }
        return true;
    }
    
    // Método que verifica si la lista está vacía
public boolean vacio() {
    return prim == null;
}


    public void invertir() {
        Nodo actual = prim;
        Nodo temp = null;

        while (actual != null) {
            temp = actual.ant;
            actual.ant = actual.prox;
            actual.prox = temp;
            actual = actual.ant;
        }

        if (temp != null) {
            prim = temp.ant;
        }
    }

    // Método auxiliar para eliminar un nodo entre dos nodos
    public Nodo eliminarNodo(Nodo ap, Nodo p) {
        if (p == null) return null;

        if (ap == null) { // Si se elimina el primer nodo
            prim = p.prox;
            if (prim != null) {
                prim.ant = null;
            } else {
                ult = null;
            }
        } else {
            ap.prox = p.prox;
        }

        if (p.prox != null) {
            p.prox.ant = ap;
        } else {
            ult = ap; // Si se elimina el último nodo
        }

        cantElem--;
        return ap != null ? ap.prox : prim;
    }

    // Método que elimina el primer nodo
    public void eliminarPrim() {
        if (prim != null) {
            eliminarNodo(null, prim);
        }
    }

    // Método que elimina el último nodo
    public void eliminarUlt() {
        if (ult != null) {
            eliminarNodo(ult.ant, ult);
        }
    }

    // Método que elimina el i-ésimo nodo
    public void eliminarIesimo(int i) {
        if (i < 0 || i >= cantElem) return;
        Nodo p = prim, ap = null;
        for (int k = 0; k < i; k++) {
            ap = p;
            p = p.prox;
        }
        eliminarNodo(ap, p);
    }

    // Método que elimina la primera ocurrencia del valor x
    public void eliminarPrim(int x) {
        Nodo p = prim, ap = null;
        while (p != null) {
            if (p.elem == x) {
                eliminarNodo(ap, p);
                return;
            }
            ap = p;
            p = p.prox;
        }
    }

    // Método que elimina la última ocurrencia del valor x
    public void eliminarUlt(int x) {
        Nodo p = ult, ap = null;
        while (p != null) {
            if (p.elem == x) {
                eliminarNodo(p.ant, p);
                return;
            }
            p = p.ant;
        }
    }

    // Método que elimina todas las ocurrencias del valor x
    public void eliminarTodo(int x) {
        Nodo p = prim, ap = null;
        while (p != null) {
            if (p.elem == x) {
                p = eliminarNodo(ap, p);
            } else {
                ap = p;
                p = p.prox;
            }
        }
    }

  // Método que elimina los primeros n nodos
public void eliminarPrimeros(int n) {
    while (n > 0 && prim != null) {
        prim = eliminarNodo(null, prim); // Usamos eliminarNodo para eliminar el primer nodo
        n--;
    }
}

// Método que elimina los últimos n nodos
public void eliminarUltimos(int n) {
    while (n > 0 && ult != null) {
        ult = eliminarNodo(ult.ant, ult); // Usamos eliminarNodo para eliminar el último nodo
        n--;
    }
}



    // Método que elimina los n nodos a partir de la posición i
    public void eliminarIesimo(int i, int n) {
        while (n > 0 && i < cantElem) {
            eliminarIesimo(i);
            n--;
        }
    }

    // Método que elimina los primeros n y los últimos n nodos
    public void eliminarExtremos(int n) {
        eliminarPrim(n);
        eliminarUlt(n);
    }

    // Método que elimina todos los nodos con valores pares
    public void eliminarPares() {
        Nodo p = prim, ap = null;
        while (p != null) {
            if (p.elem % 2 == 0) {
                p = eliminarNodo(ap, p);
            } else {
                ap = p;
                p = p.prox;
            }
        }
    }

    // Método que elimina todos los nodos únicos
    public void eliminarUnicos() {
        Nodo p = prim, ap = null;
        while (p != null) {
            if (frecuencia(p.elem) == 1) {
                p = eliminarNodo(ap, p);
            } else {
                ap = p;
                p = p.prox;
            }
        }
    }

    // Método que elimina todos los elementos de L1 que aparecen en L2
    public void eliminarTodo(ListaDoEnlazada L2) {
        Nodo p = L2.prim;
        while (p != null) {
            eliminarTodo(p.elem);
            p = p.prox;
        }
    }

    // Método que elimina los elementos que se repiten k veces
    public void eliminarVeces(int k) {
        Nodo p = prim, ap = null;
        while (p != null) {
            if (frecuencia(p.elem) == k) {
                p = eliminarNodo(ap, p);
            } else {
                ap = p;
                p = p.prox;
            }
        }
    }

    // Método que elimina nodos en posiciones alternas
public void eliminarAlternos() {
    boolean eliminar = false;  // Inicializamos para no eliminar el primer nodo
    Nodo p = prim, ap = null;
    while (p != null) {
        if (eliminar) {
            p = eliminarNodo(ap, p); // Elimina el nodo actual si eliminar es true
        } else {
            ap = p;  // Guardamos la referencia al nodo anterior
            p = p.prox;  // Avanzamos al siguiente nodo
        }
        eliminar = !eliminar;  // Alternamos entre true y false
    }
}

    

   public static void main(String[] args) {
    ListaDoEnlazada L1 = new ListaDoEnlazada();

    // Insertar al final
    System.out.println("Insertar al final:");
    L1.insertarUlt(3);
    L1.insertarUlt(2);
    L1.insertarUlt(1);
    System.out.println(L1.toString()); // [3, 2, 1]

    // Insertar al principio
    System.out.println("\nInsertar al principio:");
    L1.insertarPrim(4);
    L1.insertarPrim(5);
    System.out.println(L1.toString()); // [5, 4, 3, 2, 1]

    // Insertar en una posición específica (i-ésimo)
    System.out.println("\nInsertar en posición 2:");
    L1.insertarIesimo(6, 2);
    System.out.println(L1.toString()); // [5, 4, 6, 3, 2, 1]

    // Eliminar el primer nodo
    System.out.println("\nEliminar el primer nodo:");
    L1.eliminarPrim();
    System.out.println(L1.toString()); // [4, 6, 3, 2, 1]

    // Eliminar el último nodo
    System.out.println("\nEliminar el último nodo:");
    L1.eliminarUlt();
    System.out.println(L1.toString()); // [4, 6, 3, 2]

    // Eliminar el i-ésimo nodo (posición 2)
    System.out.println("\nEliminar el nodo en posición 2:");
    L1.eliminarIesimo(2);
    System.out.println(L1.toString()); // [4, 6, 2]

    // Eliminar los primeros n nodos (2 nodos)
    System.out.println("\nEliminar los primeros 2 nodos:");
    L1.eliminarPrimeros(2);
    System.out.println(L1.toString()); // [2]

    // Insertar de nuevo para otras pruebas
    System.out.println("\nReinsertar valores para más pruebas:");
    L1.insertarUlt(5);
    L1.insertarUlt(7);
    L1.insertarUlt(9);
    L1.insertarUlt(11);
    System.out.println(L1.toString()); // [2, 5, 7, 9, 11]

    // Verificación de si está ordenado en forma ascendente
    System.out.println("\n¿Está ordenado de forma ascendente?");
    System.out.println(L1.ordenado()); // true

    // Insertar en orden descendente
    System.out.println("\nInsertar en orden descendente:");
    L1.insertarDes(10);
    System.out.println(L1.toString()); // [2, 5, 7, 9, 10, 11]

    // Verificar mayor y menor elemento
    System.out.println("\nMayor elemento:");
    System.out.println(L1.mayorElem()); // 11
    System.out.println("Menor elemento:");
    System.out.println(L1.menorElem()); // 2

    // Verificar si todos los elementos son diferentes
    System.out.println("\n¿Todos los elementos son diferentes?");
    System.out.println(L1.diferentes()); // true

    // Eliminar nodos alternos
    System.out.println("\nEliminar nodos alternos:");
    L1.eliminarAlternos();
    System.out.println(L1.toString()); // [2, 7, 10]

    // Insertar de nuevo para verificar si es palíndromo
    System.out.println("\nInsertar valores para verificar palíndromo:");
    L1.insertarUlt(7);
    L1.insertarUlt(2);
    System.out.println(L1.toString()); // [2, 7, 10, 7, 2]

    // Verificar si es palíndromo
    System.out.println("\n¿Es palíndromo?");
    System.out.println(L1.palindrome()); // true

    // Eliminar todos los nodos con valor 7
    System.out.println("\nEliminar todos los nodos con valor 7:");
    L1.eliminarTodo(7);
    System.out.println(L1.toString()); // [2, 10, 2]

    // Eliminar últimos 2 nodos
    System.out.println("\nEliminar los últimos 2 nodos:");
    L1.eliminarUltimos(2);
    System.out.println(L1.toString()); // [2]
}

}


