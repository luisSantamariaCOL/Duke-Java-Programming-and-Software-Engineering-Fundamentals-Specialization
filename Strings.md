# Strings

  * Are inmutable
    * Cannot change them
    * Can only make new ones

## Methods

GENES Start of a gene (codon) -> ATG
End of a gene (stop codon) -> TAA

String s = "dukeprogramming"
String x = s.substring(4,7);  
// 4 -> Start (included)  
// 7 -> End (excluded)  

Values  
s.substring(4,7) -> "pro"  
s.length() -> 15  
s.indexOf("program") -> 4  
s.indexOf("g") -> 7  
s.indexOf("f") -> -1  
s.indexOf("g",8) -> 14  

.indexOf : Find one string within another, return the starting index (This sounds like it might be useful for our DNA problem...)  
.indexOf("g",8) : Will ignore characters in the indices 0 to 7 as it searches for g.  

s.startsWith("duke") -> true  
s.endsWith("king") -> false  

## StringBuilder  

  * Java has StringBuilder for exactly this puropose  
    * (For building larg strings by adding many small pieces)  
    * Mutable sequence of characters  
  * StringBuilder sb = new StringBuilder("Hello");  
  
### Methods 

append          put string, int, char, etc... on end.  
insert          Insert String, int char, etc ... into middle  
charAt          Gets character at specified index  
setCharAt       Changes the character at specified index  
toString        Get back String that you made  

StringBuilder sb = new StringBuilder("start");  
sb.insert(4,"le");  
-> **"startlet"**  
