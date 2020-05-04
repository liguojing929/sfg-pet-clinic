package guru.springframework.sfgpetclinic;

import java.util.Stack;

public class MinStack {

    public static void main(String[] args) {

    }


    /**
     * Approach 1: Creating customized linkedlist, to keep track of the min value for each position
     * in stack.
     * Time Complexity for pop, push, getMin: O(1)
     * Space Complexity:
     */
    private class Node {
        int val;
        int min;
        Node next;
        Node(int v, Node n) {
            val = v;
            next = n;
        }
    }

    private Node node;
    public MinStack() {

    }

    public void push_v1(int x) {
        Node head = new Node(x, node);
        head.min = (node != null && node.min < x) ? node.min : x;
        node = head;
    }

    public int pop_v1() throws Exception {
        if(node == null) {
            throw new RuntimeException("Current Stack is empty.");
        }
        else {
            int v = node.val;
            node = node .next;
            return v;
        }
    }

    public int getMin_v1() throws Exception {
        if(node == null) {
            throw new NullPointerException("Current Stack is empty.");
        }
        return node.min;
    }

    /**
     * Approach 2:
     * Two Stacks
     * Time Complexity: O(1)
     * Space Complexity: O(n)
     */

    private Stack<Integer> normal = new Stack<>();
    private Stack<Integer> mins = new Stack<>();

    public void push_v2(int x) {
        if(mins.isEmpty() || x <= mins.peek()) mins.push(x);
        normal.push(x);
    }

    public void pop_v2() {
        if(normal.peek().equals(mins.peek())) mins.pop();
        normal.pop();
    }

    public int getMin_v2() {
        return mins.peek();
    }








}
