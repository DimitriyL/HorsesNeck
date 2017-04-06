//Adeebur Rahman
//APCS2 pd1
//HW29 -- Stress is the Best
//2017-04-05

import java.util.NoSuchElementException;
import java.lang.NullPointerException;
import java.util.ArrayList;
import java.util.Iterator;

public class DequeTester2 {

    public static void main(String[] args) {
	
	System.out.println("\n\nException Checking");
	System.out.println("Deque<String> deck = new DLDeque<String>()");
	Deque<String> deck = new DLDeque<String>();
	String s = "test";

	/*
	get and element not in HorsesNeck Implementation
	//get testing
	try {
	    s = deck.getFirst(); //should throw exception. s should still be test.
	    if (!s.equals("test")) { System.out.println("getFirst() wrongly returned a value"); }
	}
	catch (NoSuchElementException e) {
	    System.out.println("getFirst() properly threw an exception");
	}

	//element testing
	s = "test";
	try {
	    s = deck.element(); //should throw exception. s should still be test.
	    if (!s.equals("test")) { System.out.println("element() wrongly returned a value"); }
	}
	catch (NoSuchElementException e) {
	    System.out.println("element() properly threw an exception");
	}
	*/
	
	//peek testing
	s = "test";
	try {
	    s = deck.peek(); //s should be null;
	    if (s == null) { System.out.println("peek() properly returned null"); }
	}
	catch (NoSuchElementException e) {
	    System.out.println("peek() wrongly threw an exception");
	}

	/*
	//remove not included inHorsesNeck implementation.
	//removeFirst testing
	s = "test";
	try {
	    s = deck.removeFirst(); //should throw exception. s should still be test.
	    if (!s.equals("test")) { System.out.println("removeFirst() wrongly returned a value"); }
	}
	catch (NoSuchElementException e) {
	    System.out.println("removeFirst() properly threw an exception");
	}

	//pop not included inHorsesNeck implementation.
	//pop  testing
	s = "test";
	try {
	    s = deck.pop(); //should throw exception. s should still be test.
	    if (!s.equals("test")) { System.out.println("pop() wrongly returned a value"); }
	}
	catch (NoSuchElementException e) {
	    System.out.println("pop() properly threw an exception");
	}
	*/
	
	//poll testing
	s = "test";
	try {
	    s = deck.poll(); //s should be null;
	    if (s == null) { System.out.println("poll() properly returned null"); }
	}
	catch (NoSuchElementException e) {
	    System.out.println("poll() wrongly threw an exception");
	}
	
	/*
	//add not included in HorsesNeck implementation.
	//add testing
	try {
	    deck.addFirst(null);
	    System.out.println("addFirst(null) should have thrown an exception but didn't");
	}
	catch (NullPointerException e) {
	    System.out.println("addFirst(null) properly threw an exception");
	}
	*/
	
	//offer testing
	try {
	    deck.offerFirst(null);
	    System.out.println("offerFirst(null) should have thrown an exception but didn't");
	}
	catch (NullPointerException e) {
	    System.out.println("offerFirst(null) properly threw an exception");
	}

	/*
	//push not included in HorsesNeck implementation.
	//push testing
	try {
	    deck.push(null);
	    System.out.println("push(null) should have thrown an exception but didn't");
	}
	catch (NullPointerException e) {
	    System.out.println("push(null) properly threw an exception");
	}
	*/
	
	//contains testing
	try {
	    deck.contains(null);
	    System.out.println("contains(null) should have thrown an exception but didn't");
	}
	catch (NullPointerException e) {
	    System.out.println("contains(null) properly threw an exception");
	}

	System.out.println("\n\n\n\nGeneral Usage\n");
	
	System.out.println("Deque<Object> d = new DLDeque<Object>()");
	Deque<Object> d = new DLDeque<Object>();
	
        System.out.println("\ntesting various add methods");
        System.out.println("d.offerFirst(\"c\")");
        d.offerFirst("c");
        System.out.println("d: " + d); //d: [c]
        System.out.println("d.offerFirst(\"b\")");
        d.offerFirst("b");
        System.out.println("d: " + d); //d: [b, c]
        System.out.println("d.offerFirst(\"a\")");
        d.offerFirst("a");
        System.out.println("d: " + d); //d: [a, b, c]
        System.out.println("d.offer(\"y\")");
        d.offer("y");
        System.out.println("d: " + d); //d: [a, b, c, y]
        System.out.println("d.offer(\"z\"): ");
        d.offer("z");
        System.out.println("d: " + d); //d: [a, b, c, y, z]

        System.out.println("\ntesting various accessor methods");
        System.out.println("d.peek(): " + d.peek()); //d.peek(): a
        System.out.println("d.peekLast(): " + d.peekLast()); //d.peekLast(): z

        System.out.println("\ntesting size() and isEmpty()");
        System.out.println("d: " + d); //d: [a, b, c, y, z]
        System.out.println("d.size(): " + d.size()); //d.size(): 5
        System.out.println("d.isEmpty(): " + d.isEmpty()); //d.isEmpty(): false

        System.out.println("\ntesting poll() and size() and isEmpty()");
        System.out.println("d: " + d); //d: [a, b, c, y, z]
        System.out.println("d.poll(): " + d.poll()); //d.poll(): a
        System.out.println("d.poll(): " + d.poll()); //d.poll(): b
	System.out.println("d.poll(): " + d.poll()); //d.poll(): c
        System.out.println("d.pollLast(): " + d.pollLast()); //d.pollLast(): y
        System.out.println("d.pollLast(): " + d.pollLast()); //d.pollLast(): z	
	System.out.println("d: " + d); //d: []
        System.out.println("d.size(): " + d.size()); //d.size(): 0
        System.out.println("d.isEmpty(): " + d.isEmpty()); //d.isEmpty(): true

        System.out.println("\ntesting misc methods");
        System.out.println("d.offer(\"p\")");
        d.offer("p");
        System.out.println("d: " + d); //d: [p]
        System.out.println("d.offer(\"L\")");
        d.offer("L");
        System.out.println("d: " + d); //d: [p, L]
        System.out.println("d.offer(\"b\")");
        d.offer("b");
        System.out.println("d: " + d); //d: [p, L, b]
        System.out.println("d.offer(\"L\")");
        d.offer("L");
        System.out.println("d: " + d); //d: [p, L, b, L]
        System.out.println("d.offer(\"p\")");
        d.offer("p");
        System.out.println("d: " + d); //d: [p, L, b, L, p]
        System.out.println("d.offer(\"L\")");
        d.offer("L");
        System.out.println("d: " + d); //d: [p, L, b, L, p, L]
        System.out.println("d.offer(\"b\")");
        d.offer("b");
        System.out.println("d: " + d); //d: [p, L, b, L, p, L, b]

        System.out.println("\ntesting contains(Object o)");
        System.out.println("d.contains(\"L\"): " + d.contains("L")); //d.contains("L"): true
        System.out.println("\ntesting removeFirstOccurrence(Object o)");
        System.out.println("d: " + d); //d: [p, L, b, L, p, L, b]
        System.out.println("d.removeFirstOccurrence(\"L\"): " + d.removeFirstOccurrence("L")); //d.removeFirstOccurrence("L"): true
        System.out.println("d: " + d); //d: [p, b, L, p, L, b]
        System.out.println("\ntesting removeLastOccurrence(Object o)");
        System.out.println("d: " + d); //d: [p, b, L, p, L, b]
        System.out.println("d.removeLastOccurrence(\"L\"): " + d.removeLastOccurrence("L")); //d.removeLastOccurrence("L"): true
        System.out.println("d: " + d); //d: [p, b, L, p, b]
        System.out.println("\ntesting removeFirstOccurrence(Object o)");
        System.out.println("d: " + d); //d: [p, b, L, p, b]
        System.out.println("d.removeFirstOccurrence(\"p\"): " + d.removeFirstOccurrence("p")); //d.removeFirstOccurrence("p"): true
        System.out.println("d: " + d); //d: [b, L, p, b]
        System.out.println("\ntesting removeLastOccurrence(Object o)");
        System.out.println("d: " + d); //d: [b, L, p, b]
        System.out.println("d.removeLastOccurrence(\"b\"): " + d.removeLastOccurrence("b")); //d.removeLastOccurrence("b"): true
        System.out.println("d: " + d); //d: [b, L, p]


	
        System.out.println("\ntesting various remove methods");
        System.out.println("d.poll(): " + d.poll()); //d.poll(): b
        System.out.println("d: " + d); //d: [L, p]
        System.out.println("d.poll(): " + d.poll()); //d.poll(): L
        System.out.println("d: " + d); //d: [p]
        System.out.println("d.pollLast(): " + d.pollLast()); //d.pollLast(): p
        System.out.println("d: " + d); //d: []

        System.out.println("\ntesting for null output");
        System.out.println("d.peek(): " + d.peek()); //d.peek(): null
        System.out.println("d.peekLast(): " + d.peekLast()); //d.peekLast(): null
        System.out.println("d.poll(): " + d.poll()); //d.poll(): null
        System.out.println("d.pollLast(): " + d.pollLast()); //d.pollLast(): null


        System.out.println("\ntesting iterator()");
        System.out.println("d.offer(\"a\")");
        d.offer("a");
        System.out.println("d: " + d); //d: [a]
        System.out.println("d.offer(\"b\")");
        d.offer("b");
        System.out.println("d: " + d); //d: [a, b]
        System.out.println("d.offer(\"c\")");
        d.offer("c");
        System.out.println("d: " + d); //d: [a, b, c]
        System.out.println("d.offer(\"d\")");
        d.offer("d");
        System.out.println("d: " + d); //d: [a, b, c, d]

        System.out.println("Iterator<Object> ascIt = d.iterator()");
        Iterator<Object> ascIt = d.iterator();

        System.out.println("ascIt.hasNext(): " + ascIt.hasNext()); //ascIt.hasNext(): true
        System.out.println("ascIt.next(): " + ascIt.next()); //ascIt.next(): a
        System.out.println("ascIt.hasNext(): " + ascIt.hasNext()); //ascIt.hasNext(): true
        System.out.println("ascIt.next(): " + ascIt.next()); //ascIt.next(): b
        System.out.println("ascIt.hasNext(): " + ascIt.hasNext()); //ascIt.hasNext(): true
        System.out.println("ascIt.next(): " + ascIt.next()); //ascIt.next(): c
        System.out.println("ascIt.remove()");
        ascIt.remove();
        System.out.println("d: " + d); //d: [a, b, d]
        System.out.println("ascIt.hasNext(): " + ascIt.hasNext()); //ascIt.hasNext(): true
        System.out.println("ascIt.next(): " + ascIt.next()); //ascIt.next(): d
        System.out.println("ascIt.hasNext(): " + ascIt.hasNext()); //ascIt.hasNext(): false

    }
}

