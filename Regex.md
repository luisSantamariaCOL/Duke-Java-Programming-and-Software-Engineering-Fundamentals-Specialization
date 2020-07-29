### Split() method

      String str = "id-INT, name-STRING,";
          String str = "id-INT, name-STRING,";
          String[] parts = str.split("\\W+");
          System.out.println(parts.length);
          System.out.println(Arrays.toString(parts));
    
    
Output:  

      4
      [id, INT, name, STRING]
