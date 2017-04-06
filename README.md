# HorsesNeck
Queue and Deque Lab-Manahal Tabassum, Dimitriy Leksanov and Michael Ruvinshteyn

## Our rationale for selecting certain methods:
#### There are a number of bases that have to be covered when it comes to a queue. One has to be able to add, remove, and view elements. However, since this is a double-edged queue, or deque, the only elements that are really relevant are the first and last elements. This is true in real life, too, since, generally, only the first and last people are the ones who have just done, or will be doing anything in a line.
### Adding and Appending
#### To add and append elements, there are a number of options according to the deque() description on the Oracle site. There exist add(), push(), and offer(), which feature a number of methods branching off that are specific to front and ene. push() did not really make sense, since it refers specifically to stacks, and we chose offer() over add() since offer() has extra functionality that automatically tests for a deque filled to capacity, avoiding any potential exceptions (IllegalStateException) that add() may throw.
### Removing and Retrieving Elements
#### To remove elements, there are also a number of options, including pop(), poll(),  and remove(), the latter of which also involves two end-specific methods. pop(), like push(), is stack specific, so we avoided that one. Then, we again chose poll() over remove(), since, like with add() and offer(), poll() offers the unique functionality of testing the deque. Here, poll() tests for emptiness, simply returning "null" instead of throwing an exception, but returns the removed value under all other circumstances.
### Viewing Elements at the Front and End
#### The options were element(), getFirst(), getLast(), and peek(). Like before, we chose peek() due to the extra caveat that the method will test whether the deque is empty first, and return a "null" value in that case. Otherwise, it is exactly like the other three methods, returning but not removing the value of the element at a specific end of the queue.

### size()
#### This method is used to access the value representing the length of the deque remotely. Since _size is a private attribute, size() is public and allows the value of _size to be viewed.
### contains(Object x)
#### contains() is important, since it tests whether a certain value exists within the values of the deque. A boolean value is returned accordingly. While this does not have much value now, it could with the implementation of future methods, like removeFirstOccurrence() and removeLastOccurrence().

##### Note: The methods poll() and peek() only work in reference to the first element, and the method offer() only works in reference to the last. This is by convention. Thus, pollLast(), peekLast(), and offerFirst() exist to account for both ends of the queue.

### removeFirstOccurrence() and removeLastOccurrence()
##### As we had previously mentioned, the value in contains() is not in its own functionality as a method, but, rather, in the functionality it provides. remove(First/Last)Occurrence() is very valuable to have, as it allows specific value elements to be removed, but also allows elements of a certain value to be counted, if it is done repeatedly. If we go on to write a reverse method, this could be used for a plethora of tasks, such as keeping an index with all of the String values. However, none of this is possible unless contains() is involved. Though contains() is not used directly, the same functionality that was used to find an element can now be employed to remove it. Also, the two can be combined to create a "remove-all" algorithm.

### Iterator
##### This is another method that could be valuable in the future. By actually bringing in the iterator class, this is extra functionality that could make DLList traversal a little bit easier.

### toString()
#### This method is meant to be a full representation of the queue. Going from front to back, and under assumption that the cargo is of type String, the cargo is appended to an empty String to be returned, which is to represent all of the deque's elements in a row. It requires a constructor to set up the iterator itself, but should work as it was used in prior homeworks.

## Our rationale for using DLLNodes:
#### We were going to use ArrayList initially, but DLLNodes seemed more efficient in terms of runtime. With an ArrayList, for appending and removing, depending on which side we chose as the front, there would be one direction that would require elements to "slide" over to be either added or removed, resulting in linear runtime. However, with DLLNodes, adding and removing is simply a matter of moving _front and _end nodes, and updating _size, which are of constant runtime, making the process a whole lot more efficient, as it does not require traversal.

### Changes made
#### Thanks to the driver added by team Chipettes, we have discovered some flaws in our code. After much inquiry, we ended up catching the NullPointerException in order to deal with the ends of the queue for removeFirstOccurrence() and removeLastOccurrence(). This prevented the runtime error of the NullPointerException when dealing with the front and end of the queue. Furthermore, some changes were made to poll() in order to deal with queues of size 1, where we set the front equal to the end, both to null, when removing the only element in the queue.

##### -The HorsesNeck Crew