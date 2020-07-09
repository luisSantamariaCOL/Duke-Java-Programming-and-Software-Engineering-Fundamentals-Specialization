# DukeJavaProgramming

Para agregar la libreria de la universidad de Duke (.jar) a los proyectos de Java:
Click derecho al project > Open Module Settings (f4) > Libraries > + > (buscar libreria) > todo OK

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

# Find Web Link Algorithm (String and substrings) (with lastIndexOf() and indexOf())

public static void main(String[] args) {

        URLResource url = new URLResource("https://www.dukelearntoprogram.com/course2/data/manylinks.html");
        // System.out.println(urlToString(url));
        urlToString(url);
    }

    public static void findWebLink(String line) {
        String youtube = "youtube.com";
        String lineLower = line.toLowerCase();
        if (lineLower.contains(youtube)) {
            int firstIndex = line.indexOf("\"http");
            int lastIndex = line.indexOf("\"", firstIndex+1);
            System.out.println(line.substring(firstIndex, lastIndex + 1));
        }
    }

    public static void urlToString(URLResource url) {
        String string = "";
        int i = 0;
        for (String item : url.words()) {
            // System.out.println((i) + " : " + line);
            // i++;
            // findWebLink(line);
            String itemLower = item.toLowerCase();
            int pos = itemLower.indexOf("youtube.com");
            if (pos != -1) {
                int beg = item.lastIndexOf("\"", pos);
                int end = item.indexOf("\"", pos +1);
                System.out.println(item.substring(beg+1, end));
            }
        }
        // return string;
    }
