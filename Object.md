# Object Oriented Programming

* Java is an OOP  
What does that mean?  

* One of the important characteristics of objects is that they encapsulate **code** and **data**  

### Object = Code + Data  
Code -> Methods
Data -> Fields

An object can be Strings, CSV Records, Image resources, etc...  

### Class = Type, Object = Instance  

* Classes define a types:  
  * Define what is in objects of that type  
* Objects are instances of class  
  * Can make many (using: *new*)  

### Fields

They are also called instance variables.  
The Fields are part of the object and exist as long as the object exists.  

### Summary of Class Concepts
* Class = Noun (sustantivo)  
* Method = verb  
* Fields = Noun  
 * Noun: Things that a class has  
 * Can also be **adjectives** that describes properties  
 
 ## Abstraction
 
 * Separation of **interface** + **implementation**  
 
 public   **Interface: What it Does**  
 private  **Implementation: How it Does It**  
 
 ### General Guidance
 * Fields: private  
  * Typically part of implementation  
 * Methods: depends  
  * Things object does public  
  * Helpers: private  
 * Classes: public  
  * For now: always  
  * You might will want non-public classes in advance java  
 * Constructors: public  
  * For now: always  
 
 ### Constructors
 
 * Has name of the class  
 * is public (not always    
 * has not return type  
 * Specify how to initialize an Object  

This line:  
CaesarCipher cc = new CaesarCipher(22);  
* Asks Java to make a new instance of the CaesarCipher class  
* And initialize it by passing 22 in the constructor  
1. Creates a new variable, cc.  
2. Then it creates a new instance of the CaesarCipher class.  
   * It means that you have a new object with it's own copy of the fields of that class, alphabet and shiftedAlphabet.  
3. Then it calls the constructor, passing 22 for the key.  
4. Once inside the constructor Java begins executing the code you wrote to initialize the object.  
