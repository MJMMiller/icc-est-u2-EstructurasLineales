package Ejercicio_02_sorting;

import controllers.Stack;

public class StackSorter {

    public void sortStack(Stack stack) {

        Stack stack2 = new Stack();
        
        while (!stack.isEmpty()) {
            Integer temporal = stack.pop();
            while (!stack2.isEmpty() && (Integer)stack2.peek() > temporal) {
                stack.push(stack2.pop());
            }
            stack2.push(temporal);
        }
        while (!stack2.isEmpty()) {
            stack.push(stack2.pop());
        }
    }
}
