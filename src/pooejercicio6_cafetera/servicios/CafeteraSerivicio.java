/*
 Método llenarCafetera(): hace que la cantidad actual sea igual a la capacidad 
máxima. 
 Método servirTaza(int): se pide el tamaño de una taza vacía, el método recibe el 
tamaño de la taza y simula la acción de servir la taza con la capacidad indicada. Si la 
cantidad actual de café “no alcanza” para llenar la taza, se sirve lo que quede. El 
método le informará al usuario si se llenó o no la taza, y de no haberse llenado en 
cuanto quedó la taza. 
 Método vaciarCafetera(): pone la cantidad de café actual en cero. 
 Método agregarCafe(int): se le pide al usuario una cantidad de café, el método lo 
recibe y se añade a la cafetera la cantidad de café indicada. 
 */
package pooejercicio6_cafetera.servicios;

import java.util.Scanner;
import pooejercicio6_cafetera.entidades.Cafetera;


public class CafeteraSerivicio {
    
    Scanner leer = new Scanner(System.in);
    
    
    public Cafetera llenarCafet()
    {
        
        Cafetera cafe = new Cafetera();
        
        System.out.println("Cuál es la capacidad máxima de la cafetera en onzas.");
        cafe.setCapMax(leer.nextDouble());
        
        cafe.setCantAct(cafe.getCapMax());
        
        System.out.println("La capacidad actual de la cafetera es: "+cafe.getCantAct());
        System.out.println(" ");
        
        return cafe;
    }
    
    public void servTaza(Cafetera cafe){
               
        System.out.println("Ingrese el tamaño de la taza. En onzas.");
        double servTaza = leer.nextDouble();
        
        if (cafe.getCantAct() < servTaza) {
            System.out.println("La cantidad actual de café no alcanza para su pedido.");
            System.out.println(" ");
        } else {
            cafe.setCantAct(cafe.getCantAct() - servTaza);
            System.out.println("La nueva cantidad de café es: " + cafe.getCantAct());
            System.out.println(" ");
        }
    }
    
    public Cafetera vaciaCafe(Cafetera cafe){
        double vaciaCafe;
        
        vaciaCafe = cafe.getCantAct() - cafe.getCantAct();
        
        System.out.println("La cafetera se encuentra vacía.");
        System.out.println(" ");
        
        return cafe;
    }
    
    public Cafetera agregaCafe(Cafetera cafe){
        
        System.out.println("Qué cantidad de café desea agregar. En onzas.");
        int agregaCafe = leer.nextInt();
        
        cafe.setCantAct(agregaCafe+cafe.getCantAct()); 
        
        System.out.println("La cantidad de café es: "+cafe.getCantAct());
        System.out.println(" ");
        
        return cafe;
    }
    
    public void menu(Cafetera cafe) {

        int op;
        
        do {

            System.out.println("Menú: \n 1.Llenar cafetera.\n 2.Servir café.\n 3.Vaciar Cafetera\n "
                    + "4.Agregar Café\n 5.Salir\n");
            System.out.println("Elija una opción del menú.");
            op = leer.nextInt();

            switch (op) {
                case 1: {
                    llenarCafet();
                    break;
                }
                case 2: {
                    servTaza(cafe);
                    break;
                }
                case 3: {
                    vaciaCafe(cafe);
                    break;
                }
                case 4: {
                    agregaCafe(cafe);
                    break;
                }
                case 5: {
                    System.out.println("¿Está seguro que desea salir del programa (S/N)?");
                    String confirma = leer.next();

                    if (confirma.equalsIgnoreCase("s")) {
                        System.out.println("Gracias por utilizar el servicio.");
                    } else {
                        op = 6;
                        System.out.println(" ");
                    }
                    break;
                }
            }

        } while (op != 5);
    }
}
