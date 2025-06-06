import controllers.Cola;
import controllers.ColaG;
import controllers.Stack;
import controllers.StackG;
import models.Persona;

public class App {
    public static void main(String[] args) throws Exception {

        //LIFO - ULTIMO EN ENTRAR, PRIMERO EN SALIR
        // Stack no generica
        System.out.println("Stack no generica");

        Stack stack = new Stack();
        stack.push(10);
        stack.push(-1);
        stack.push(5);
        stack.push(8);
        System.out.println("Tam = " + stack.size());
        stack.printStack();
        stack.pop();
        System.out.println("Tam = " + stack.size());
        stack.printStack();

        //Stack Generica
        System.out.println("\nStack Generica");

        StackG<Integer> stackG = new StackG<Integer>();
        stackG.push(1);
        stackG.push(4);
        stackG.printStack();

        StackG<String> stackG1 = new StackG<String>();
        stackG1.push("Uno");
        stackG1.push("Cuatro");
        stackG1.printStack();

        //FIFO  - PRIMERO EN ENTRAR, PRIMERO EN SALIR
        //Colas
        System.out.println("\nColas");

        // Cola no generica
        Cola cola = new Cola();
        cola.add(5);
        cola.add(7);
        cola.add(10);
        System.out.println("Tam = " + cola.size);
        cola.printCola();
        cola.remove();
        System.out.println("Tam = " + cola.size);
        cola.printCola();

        // Cola generica

        Persona p1 = new Persona("Pablo");
        Persona p2 = new Persona("Juan");
        Persona p3 = new Persona("Maria");

        System.out.println("\nCola Generica");

        ColaG<Persona> colaPersonas = new ColaG<Persona>();
        colaPersonas.add(p1);
        colaPersonas.add(p2);
        colaPersonas.add(p3);
        System.out.println("Tam = " + colaPersonas.size());
        colaPersonas.printCola();
        System.out.println("Atiende a la persona: " + colaPersonas.remove().getNombre());
        System.out.println("Tam = " + colaPersonas.size());
        colaPersonas.printCola();

        System.out.println("\nBusqueda por nombre");
        Persona encontrada = colaPersonas.findByName("David");

        if (encontrada != null){
            System.out.println( "Encontrada--- " + encontrada);
        }else{
            System.out.println("No se encontró persona con ese nombre");
        }

        Persona pEliminada = colaPersonas.removeByName("David");
        System.out.println("Eliminada por nombre: " + pEliminada);
        colaPersonas.printCola();

        // Ejercicio 01 - Validar signos

        System.out.println("\nEjercicio 01 - Validar signos");
        Ejercicio_01_sign.SignValidator signValidator = new Ejercicio_01_sign.SignValidator();
        String cadena = "([]){}";
        boolean valido1 = signValidator.isValid(cadena);
        System.out.println("Cadena: " + cadena + " es valida ? :  " + valido1);
        String cadena2 = "({)}";
        boolean valido2 = signValidator.isValid(cadena2);
        System.out.println("Cadena: " + cadena2 + " es valida ? :  " + valido2);

        // Ejercicio 02 - Ordenar un Stack
        System.out.println("\nEjercicio 02 - Ordenar un Stack");
        Ejercicio_02_sorting.StackSorter stackSorter = new Ejercicio_02_sorting.StackSorter();
        Stack stackOrdenar = new Stack();
        stackOrdenar.push(5);
        stackOrdenar.push(1);
        stackOrdenar.push(4);
        stackOrdenar.push(2);

        System.out.println("Stack original:");
        stackOrdenar.printStack();

        stackSorter.sortStack(stackOrdenar);

        System.out.println("Stack ordenado:");
        stackOrdenar.printStack();

    }
}