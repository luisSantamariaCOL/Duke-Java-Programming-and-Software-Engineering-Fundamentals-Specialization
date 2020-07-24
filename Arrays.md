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

### GladLib

-> One public method makeStory  
make story will read from file or URL  

## HashMap

* Is most efficient that using two parallet ArrayLists
* A HashMap is a class that associates keys with values, generally called a map  
   * Key is element in domain, value is what key maps to in range
* Look up key, get associated value

      map.get("rainbow") -> 41
      map.get("truth") -> 17
      
![HashMap](https://i.imgur.com/OQrXfur.png)

### Accessing All Values in Map

* Printing all values in parallel arrays uses for loop with index accessing word and freq

![HashMapPrint](https://i.imgur.com/5ps4OLE.png)

### Other example

![HashMapExample](https://i.imgur.com/4s4virI.png)

![FindingNounsAndVerbs](https://i.imgur.com/ywUeZbh.png)
![FindingNounsHashMapImplementation](https://i.imgur.com/GyKKYDg.png)
