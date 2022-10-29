package data_structures;

//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.PrintWriter;

import java.io.*;

/* Name: Hanh Tran Dieu Nguyen 
 * RedID: 826051324
 * Account number: cssc0242
 * Course: CS210-02_CS496-03-CX-Spring2022
 * Prof. Louie Lu 
 * Date: 03-15-2022
 */

public class SortableArray implements SortableArrayInterface{
	
	
	final int CAPACITY; 
	int[] myArray;
	int counter; 
	
	//Constructor 
	public SortableArray() {
		CAPACITY = DEFAULT_MAX_CAPACITY;
		myArray = new int[CAPACITY];
		counter = 0;
	}
	
	public SortableArray(int capacity) {
		CAPACITY = capacity; 
		myArray = new int[capacity]; 
		counter = 0;
	}
	
	@Override
	public boolean add(int element) {
		if(counter != CAPACITY) {
			myArray[counter] = element; 
			counter++; 
			return true;
		}
		else {
			return false; 
		}
	}

	@Override
	public boolean add(int index, int element) {
		try {
			if(index ==  0 && counter == 0)  {
				myArray[0] = element;
			}
			if(index < 0 || index > counter ) {
				throw new IndexOutOfBoundsException();
			}
			for (int i = counter; i > index; i--) {
				myArray[i] = myArray[i-1]; 
			}
			
			myArray[index] = element;
			counter ++; 
			return true; 
		} catch(Exception e) {
			return false;
		}
	}
		
        


	@Override
	public int get(int index) {
		try {
			if(index < 0 || index >= counter) {
				throw new IndexOutOfBoundsException();
			}
			return myArray[index]; 	
		} catch (Exception e) {
			return 0;
		}
		
	}

	@Override
	public int remove(int index) {
		try {
			int removedElement = 0;
			if (index < 0 || index >= counter) {
				throw new IndexOutOfBoundsException();
			} else {
				for (int i = 0 , k = 0; i < counter; i++) {
					if (i == index) {
						removedElement = myArray[i];
						continue;
					}
					myArray[k++] = myArray[i];
				}
			}
			myArray[counter-1] = 0;
			counter--;
			return removedElement;
		} catch (Exception e) {
			return 0;
		}

	}

	@Override
	public int size() {
		return counter;
	}

	@Override
	public boolean readFile(String filename) {
		boolean isReadSuccess = true;
        FileReader fr = null;
        BufferedReader br = null;
        try {
        	fr = new FileReader(filename);
            br = new BufferedReader(fr);
            String line = null;
            while ((line = br.readLine()) != null) {
            	myArray[counter++] = Integer.parseInt(line);
            }
        } catch (Exception e) {
                isReadSuccess = false;
        } finally {
                try {
                        if (br != null) {
                                br.close();
                        }
                        if (fr != null) {
                                fr.close();
                        }
                } catch (Exception e) {
                        e.printStackTrace();
                }

        }
        return isReadSuccess;
	}

	@Override
	public boolean saveFile(String filename) {
		 boolean isSaveSuccess = true;
         try {
        	 FileWriter writer = new FileWriter(filename, false);
             for (int i = 0; i < size(); i++) {
            	 writer.write(myArray[i] + System.lineSeparator());
             }
             writer.close();
         } catch (Exception e) {
        	 isSaveSuccess = false;
         }
         return isSaveSuccess;
         }
			

	@Override
	public long insertionSort() {
		long startTime = System.nanoTime(); 
		
		int size = myArray.length; 
		for (int step = 1; step < size; step++) {
			int key = myArray[step]; 
			int j = step -1;
			while(j >= 0 && key < myArray[j]) {
				myArray[j + 1] = myArray[j]; 
				j--; 
			}
			myArray[j+1] = key;
		}
		
		long endTime = System.nanoTime(); 
		
		long processTime = (endTime - startTime)/1000l; 
		
		return processTime; 
	}

}
