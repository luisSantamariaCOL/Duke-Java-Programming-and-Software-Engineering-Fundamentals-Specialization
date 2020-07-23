## Arrays  

* Puede haber de una dimensión [], de dos dimensiones [][] o de hasta 3 o más dimensiones [][][]  
* Representados graficamente por índices y celdas.
* Permite definir de una sola vez varias variables (del mismo tipo).

## ArrayList

* Allows to choose elements in a random way  
* Class **ArrayList** in package **java.util**  
  * Expands as needed using .add method  
  * Provides access via index to any element in list  
  * Essential in implementing StorageResource  

* Basic syntax, we'll see usage in code  

      ArrayList<Strings> words = new ArrayList<String>();
      words.add("hello");
      words.add("world");
      String s = words.get(1); // world
      words.set(0, "goodbye"); 

### Common methods for ArrayList  

* .add(elt) - added to end of ArrayList
* .size() - returns number of elements in ArrayList
* .get(index) - returns elements at index
* .set(index, elt) - assign elt to index location

### Tips

* Do not call **.remove()** during iteration
