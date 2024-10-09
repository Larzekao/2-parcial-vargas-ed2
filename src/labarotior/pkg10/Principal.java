/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labarotior.pkg10;

/**
 *
 * @author Larzekao
 */
public class Principal {
    
    
     public static void main(String[] args) {
       Lista obj = new Lista(10);
       
       /// este mishel este es para orden de menor a mayor
       obj.insertarAsc(8);
        obj.insertarAsc(15);
         obj.insertarAsc(156);
          obj.insertarAsc(1548);
           obj.insertarAsc(14);
            obj.insertarAsc(2);
          obj.insertarAsc(15);
           obj.insertarAsc(189);
            System.out.println(obj.toString());
          
       /*//este para de mayor  a menor
       obj.insertarDec(8);
        obj.insertarDec(15);
         obj.insertarDec(156);
          obj.insertarDec(1548);
           obj.insertarDec(14);
            obj.insertarDec(2);
          obj.insertarDec(15);
           obj.insertarDec(189);
            System.out.println(obj.toString());
         */    
}
}
