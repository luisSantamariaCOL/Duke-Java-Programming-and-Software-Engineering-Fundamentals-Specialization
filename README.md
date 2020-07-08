# DukeJavaProgramming

# # Semana 2 | (Strings)

GENES
Start of a gene (codon)	-> ATG
End of a gene (stop codon)	-> TAA



# String s = "dukeprogramming"
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

# GENE Algorithm (String and substring)

public String findGeneSimple(String dna) {
    // Start codon is "ATG"
    // stop codon is "TAA"
    String result = "";
    int startIndex = dna.indexOf("ATG");
    if (startIndex == -1) // no ATG
    {
      return "";
    }
    int stopIndex = dna.indexOf("TAA", startIndex + 3);
    if (stopIndex == -1) // no TAA
    {
      return "";
    }
    result = dna.substring(startIndex, stopIndex + 3);
    
    return result;
}
