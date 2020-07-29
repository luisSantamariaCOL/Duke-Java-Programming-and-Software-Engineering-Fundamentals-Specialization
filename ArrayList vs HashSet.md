### ArrayList

* Does not validate duplicates.
* get() is O(1)
* contains() is O(n) but you have fully control over the order of the entries.

                      get  add  contains next remove(0) iterator.remove  
          ArrayList   O(1) O(1) O(n)     O(1) O(1)      O(1)  
          
* Not thread safe and to make it thread safe you have to use.  
          Collections.synchronizedList(...)  

### HashSet

* Ensures there are no duplicates
* Gives you an O(1) contains() method but doesn't preserve order.

                      add      contains next     notes
             HashSet  O(1)     O(1)     O(h/n)   h is the table 

* Not thread safe and to make it thread safe you have to use  
          Collections.synchronizedList(...)
          
### What use?

If you have duplicate data in your code then you should use **ArrayList** otherwise you can use **HashSet**.  

            ArrayList arr =new ArrayList();
            arr.add("Hello");
            arr.add("is");
            arr.add("Hello");
            System.out.println(arr);  //As we are using Arraylist therefore 
                                      //the duplicate elements are allowed therefore
                                      //"Hello" is not removed in the output  

            HashSet arr =new HashSet();
            arr.add("Hello");
            arr.add("is");
            arr.add("Hello");
            System.out.println(arr);  //As we are using Hashset therefore 
                                      //the duplicate elements removed therefore
                                      //"Hello" is removed in the output  
