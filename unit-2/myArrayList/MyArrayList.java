//create your own version of the ArrayList by completing this class definition
//look in ListInterface to see what methods you need to create

public class MyArrayList<anyType> implements ListInterface<anyType> {
   private Object[] list; // stores the actual elements
   private int numElements; // used to keep track of the number of valid elements in the list

   public MyArrayList() {
      list = new Object[10]; // start with a buffer size of 10
      numElements = 0;
   }

   private void doubleCapacity() // private because this is a helper method that need not be used outside of the
                                 // class
   {
      // make list twice as big, i.e. given [A, B, C, null], results with [A, B, C,
      // null, null, null, null, null]
      // to be used if we add an element that would be over the capacity of list

      Object[] newList = new Object[list.length * 2];

      for (int i = 0; i < list.length; i++) 
      {
         newList[i] = list[i];
      }

      list = newList;
   }

   private void cutCapacity() // private because this is a helper method that need not be used outside of the
                              // class
   {
      // make list half as big, i.e. given [A, B, C, null, null, null, null, null],
      // results with [A, B, C, null]
      // to be used if after removing an element, we have less than 1/3 of the
      // capacity of list being used

      Object[] newList = new Object[list.length / 2];

      for (int i = 0; i < newList.length; i++) 
      {
         newList[i] = list[i];
      }

      list = newList;
   }

   public boolean add(anyType x) 
   {
      if (numElements == list.length) 
      {
         doubleCapacity();
      }

      list[numElements] = x;

      numElements++;

      return true;
   }

   public boolean add(int index, anyType x) 
   {
      if (numElements == list.length)
      {
         doubleCapacity();
      }

      for (int i = numElements; i > index; i--) 
      {
         list[i] = list[i - 1];
      }

      list[index] = x;

      numElements++;

      return true;
   }

   public int size() 
   {
      return numElements;
   }

   public anyType set(int index, anyType x) 
   {
      anyType temp = (anyType) list[index];

      list[index] = x;

      return temp;
   }

   public anyType get(int index) 
   {
      return (anyType) list[index];
   }

   public anyType remove(int index)
   {
      anyType temp = (anyType) list[index];

      for (int i = index; i < numElements - 1; i++) 
      {
         list[i] = list[i + 1];
      }

      numElements--;

      if (numElements < list.length / 3) {
         cutCapacity();
      }

      return temp;
   }

   public String toString() {
      String ans = "[";

      for (int i = 0; i < numElements; i++) {

         // Print each element of the list separated by a comma and a space unless it is
         // the last element in the list
         ans += (i != numElements - 1) ? list[i] + ", " : list[i];
      }

      return ans + "]";
   }
}