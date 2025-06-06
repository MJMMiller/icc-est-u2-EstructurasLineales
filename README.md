
# Práctica Stacks and Queues

## 📌 Información General

- **Título:** Práctica Ejercicios Logica con Pilas y Colas
- **Asignatura:** Estructura de Datos
- **Carrera:** Computación
- **Estudiante:** Miller Mendez Mateo Josue
- **Fecha:** 06 / 05 / 2025
- **Profesor:** Ing. Pablo Torres

---

## 🛠️ Descripción

Proyecto de Algoritmos con Pilas (Stacks) en Java
Este proyecto implementa dos algoritmos clásicos que utilizan la estructura de datos Pila (Stack), demostrando su aplicación en problemas fundamentales:

1. Validación de Paréntesis Balanceados
Tipo: Algoritmo de verificación sintáctica
Enfoque:
  - Utiliza una pila para rastrear signos de apertura ((, [, {)
  - Compara cada signo de cierre con el último abierto (LIFO)
2. Ordenación de una Pila
Tipo: Algoritmo de ordenación in-place
Enfoque:
  - Emplea una pila auxiliar para reordenamiento
  - Mantiene la pila auxiliar siempre ordenada (menor → mayor)
---

## 🚀 Ejecución

Para ejecutar el proyecto:

1. Compila el código:
    ```bash
    javac App.java
    ```
2. Ejecuta la aplicación:
    ```bash
    java App
    ```
---

## 📦 Versión 2.0.2 - Estructuras Lineales – Ejercicios

Esta versión contiene la implementación de dos ejercicios que utilizan la estructura de datos `Stack`, resolviendo problemas comunes aplicables en validación de expresiones y ordenamiento de datos.

---
### 🧩 Diagrama propuesto
![](https://raw.githubusercontent.com/MJMMiller/EST_DIAGRAMS/refs/heads/main/Ejercicios%20Logica%20con%20Pilas%20y%20Colas.png)
---
### ✅ Ejercicio 01 – Validación de signos

**Clase:** `SignValidator`  
**Ubicación:** `Ejercicio_01_sign/SignValidator.java`

Este ejercicio valida si una cadena de texto tiene correctamente balanceados los signos de agrupación: `()`, `[]`, `{}`.  
Utiliza una pila para almacenar los signos de apertura y los compara con los de cierre.

### 🔧 Lógica del método `isValid`

```java
public boolean isValid(String cadena) {
    Stack stack = new Stack();
    
    for (int i = 0; i < cadena.length(); i++) {
        char c = cadena.charAt(i);
        
        // si el char es de apertura, lo agrega
        if (c == '(' || c == '[' || c == '{') {
            stack.push(c);
        } 
        // si el char es de cierre
        else if (c == ')' || c == ']' || c == '}') {
            // si la pila no contiene elementos, significa que encontramos un cierre sin su apertura correspondiente - la expresión es inválida
            if (stack.isEmpty()) {
                return false;
            }
            
            // saca el último signo de apertura de la pila
            char top = (char) stack.pop();
            
            // verifica si estan con los cierres actales
            if ((c == ')' && top != '(') ||
                (c == ']' && top != '[') ||
                (c == '}' && top != '{')) {
                return false;
            }
        }
    }
    
    //si no quedan elementos en la pila -  todos los signos se cerraron correctamente
    return stack.isEmpty();
}
```
### 🧠 Uso en el método `main`
**Clase:** `App`  
**Ubicación:** `App.java`
```java
        System.out.println("\nEjercicio 01 - Validar signos");
        Ejercicio_01_sign.SignValidator signValidator = new Ejercicio_01_sign.SignValidator();
        String cadena = "([]){}";
        boolean valido1 = signValidator.isValid(cadena);
        System.out.println("Cadena: " + cadena + " es valida ? :  " + valido1);
        String cadena2 = "({)}";
        boolean valido2 = signValidator.isValid(cadena2);
        System.out.println("Cadena: " + cadena2 + " es valida ? :  " + valido2);
```
### 🔎Explicacion
1. Recorre cada carácter de la cadena.
2. Si encuentra un signo de apertura ((, [, {), lo guarda en una pila.
3. Si encuentra un signo de cierre (), ], }):
    * Verifica que haya un signo de apertura correspondiente en la pila.
    * Si no hay (stack.isEmpty()), la cadena es inválida.
    * Si el último signo de apertura no coincide con el cierre actual, también es inválido.
4. Al final, si la pila está vacía, significa que todos los signos estaban correctamente balanceados.
---
### ✅ Ejercicio 02 – Ordenamiento de una pila

**Clase:** `StackSorter`  
**Ubicación:** `Ejercicio_02_sorting/StackSorter.java`

Este ejercicio implementa el ordenamiento de una pila (`Stack`) de números enteros utilizando **únicamente pilas** como estructura de apoyo, sin emplear arreglos, listas u otras estructuras.

El algoritmo sigue el principio del ordenamiento por inserción, desplazando los elementos a una pila auxiliar hasta encontrar la posición correcta para cada valor.

### 🔧 Lógica del método `sortStack`

```java
public void sortStack(Stack stack) {
    Stack stack2 = new Stack(); // ila auxiliar para tener referencia
    
    while (!stack.isEmpty()) {
        Integer temporal = stack.pop(); // saca el elemento del tope
        
        // pasa los  elementos mayores de stack2 a stack
        while (!stack2.isEmpty() && stack2.peek() > temporal) {
            stack.push(stack2.pop());
        }
        
        // agrega el elemento temporal en stack2 en su posición correcta
        stack2.push(temporal);
    }
    
    // pasa cada elemento de stack2 (que ya está ordenado) de vuelta a stack
    while (!stack2.isEmpty()) {
        stack.push(stack2.pop());
    }
}
```
### 🧠 Uso en el método `main`
**Clase:** `App`  
**Ubicación:** `App.java`
```java
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
```
### 🔎Explicacion
1. Extrae elementos de la pila original stack uno por uno.
2. Compara cada elemento temporal con los elementos en stack2:
   - Si stack2 contiene elementos mayores que temporal, los devuelve a stack.
3. Inserta temporal en stack2 en su posición correcta.
4. Repite hasta que stack esté vacía.
5. Transfiere los elementos ordenados de stack2 de vuelta a stack.
---
