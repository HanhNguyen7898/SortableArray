# SortableArray
Programming Assignment (PA) #1 
Sortable Array 
 
For this assignment you will write a class using composition. You will implement a method that 
will sort the contents of the array contained in your class as an instance variable. Your sorting 
method will  make use of the insertion sort algorithm and should return the time in milliseconds 
that it took your algorithm to sort the array (The System class in Java could be useful for this). 
 
Implement the interface provided (following). Your class should have two constructors, a default 
constructor that uses DEFAULT_MAX_CAPACITY from the interface and a constructor that takes 
a single integer as a parameter to define the maximum capacity of the array. Additionally, your 
class should have a method of readFile() for reading the contents of a file 
(UnsortedNumberFile.txt) and storing the values therein into the array. And then your 
insertionSort() will sort the numbers in the Array. Afterwards the saveFile() method for storing the 
contents of the array into the output file. This output file should be named SortedNumberFile.txt 
and the format should be the same as the input file format (one entry per line).  
 
/* 
 * SortableArray interface for use in Assignment 1 
 * Concrete class should have an integer array as an instance variable 
 * Throw exceptions when user attempts to access indexes less than zero or greater 
 * than the number of elements. 
 */ 
public interface SortableArrayInterface{ 
    int DEFAULT_MAX_CAPACITY = 1024; 
 
    // Returns true if the element was added to the first available position of the array 
    boolean add(int element); 
 
    // Inserts the specified element at the specified position in this list 
    // Shifts the element currently at that position and any subsequent elements to the right 
    // Returns true if element added correctly. 
    // Must observe 0 <= index <= size. 
    boolean add(int index, int element); 
 
    // Returns the element at the specified position in the array 
    int get(int index); 
 
    // Removes and returns the element at the specified position in the array 
    int remove(int index); 
 
    // Returns the number of elements in the array 
    int size(); 
 
    // Returns true if able to read and store specified file’s contents into array 
    boolean readFile(String filename); 
 
    // Returns true if able to store array contents into specified file 
    boolean saveFile(String filename); 
 
    // Sort the elements of the array using insertion sort 
void insertionSort(); 
} 
Additional Details  
• Each method must be as efficient as possible. That is, a O(n) is unacceptable if the 
method could be written with O(log n) complexity.  
• Your project must consist of only the files specified (including the provided 
interface), no additional source code files are permitted. 
• You may not make any modifications to the SortableArrayInterface provided. I will grade 
your project with my copy of this file. 
• All source code files must have your name and class account number at the beginning of 
the file. 
• All of the above classes must be in a package named 'data_structures'. 
• You may import java.util.Iterator, java.util.NoSuchElementException, and java.io.* for file 
read and write. If you feel that you need to import anything else, let me know. You are 
expected to write all of the code yourself, and you may not use the Java API for any 
containers. 
• Your code must not print anything. 
• Your code should never crash, but must handle any/all error conditions gracefully.  
• You must write generic code according to the interface provided. You may not add 
any public methods to the implementations, but you may add private ones, if needed. 
• Your code may generate unchecked cast warnings when compiled, but it must 
compile and run correctly on edoras to receive any credit. 
 
Testing Your Code 
• Tester/driver programs will be provided going forward to help you test your code. 
• Allowing sufficient time for testing on edoras is essential. Use your sandbox with the 
following directory structure: 
~/sandbox/pa1/ 
TestDriverProgram.java 
UnsortedNumberFile.txt 
data_structures/ 
       SortableArrayInterface.java 
SortableArray.java 
• Compile from ~/sandbox/pa1 directory: 
[cssc0000@edoras pa1]$ javac TestDriverProgram.java 
[cssc0000@edoras pa1]$ java TestDriverProgram
