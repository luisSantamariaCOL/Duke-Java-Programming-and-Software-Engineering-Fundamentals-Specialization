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
    
   }
 
 
 # String Second Assignments (Multiple Genes) | Strings, Substrings, indexOf, isEmpty
    
    
    public class Part3 {
    public static void main(String[] args) {
        testCountGenes();
    }

    public static int findStopCodon(String dna, int startIndex, String stopCodon) {
        // find stopCodon starting from (startIndex + 3), currIndex;
        int currIndex = dna.indexOf(stopCodon, startIndex + 3);
        while (currIndex != -1) {
            int diff = currIndex - startIndex;
            if (diff % 3 == 0) {
                return currIndex;
            } else {
                currIndex = dna.indexOf(stopCodon, currIndex + 1);
            }
        }
        return dna.length();
    }

    public static void testFindStopCodon() {
        String s1 = "AACCCTAA";
        System.out.println(findStopCodon(s1, 0, "TAA"));
        String s2 = "AACCCTAACTAA";
        System.out.println(findStopCodon(s2, 0, "TAA"));
        String s3 = "AACCCTAACCCTACCTAA";
        System.out.println(findStopCodon(s3, 0, "TAA"));
        String s4 = "AACCCTAACCCTAACCCTAACCCTAA";
        System.out.println(findStopCodon(s4, 0, "TAA"));
    }

    public static String findGene(String dna) {
        // Find the index of the first occurrence of the start codon “ATG”. If there is no “ATG”, return the empty string.
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1) {
            return "";
        }

        // Find the index of the first occurrence of the stop codon “TAA” after the first occurrence of
        // “ATG” that is a multiple of three away from the “ATG”. Hint: call findStopCodon.
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");
        // int minIndex = Math.min(taaIndex, Math.min(tagIndex, tgaIndex));
        int minIndex = 0;

        // Return the gene formed from the “ATG” and the closest stop codon that is a multiple of three away
        if (taaIndex == -1 ||
                (tgaIndex != -1 && tgaIndex < taaIndex)) {
            minIndex = tgaIndex;
        } else {
            minIndex = taaIndex;
        }

        if (minIndex == -1 ||
                (taaIndex != -1 && tagIndex < minIndex)) {
            minIndex = tagIndex;
        }

        //  If there is no valid stop codon and therefore no gene, return the empty string.
        if (minIndex == -1) {
            return "";
        }
        return dna.substring(startIndex, minIndex + 3);
    }


    public static String findGene(String dna, int where) {
        int startIndex = dna.indexOf("ATG", where);
        if (startIndex == -1) {
            return "";
        }
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");
        // int minIndex = Math.min(taaIndex, Math.min(tagIndex, tgaIndex));
        int minIndex = 0;
        if (taaIndex == -1 ||
                (tgaIndex != -1 && tgaIndex < taaIndex)) {
            minIndex = tgaIndex;
        } else {
            minIndex = taaIndex;
        }

        if (minIndex == -1 ||
                (taaIndex != -1 && tagIndex < minIndex)) {
            minIndex = tagIndex;
        }


        if (minIndex == -1) {
            return "";
        }
        return dna.substring(startIndex, minIndex + 3);
    }

    public static void printAllGenes(String dna) {
        int startIndex = 0;

        while (true) {
            String currentGene = findGene(dna, startIndex);

            if (currentGene.isEmpty()) {
                break;
            }
            // Print that gene out
            System.out.println(currentGene);
            // Set startIndex to just part the end of the gene
            startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
        }
    }


    public static int countGenes(String dna) {
        int startIndex = 0;
        int geneCounter = 0;
        while (true) {
            String currentGene = findGene(dna, startIndex);

            if (currentGene.isEmpty()) {
                break;
            }
            // Print that gene out
            geneCounter++;
            // Set startIndex to just part the end of the gene
            startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
        }
        return geneCounter;
    }

    public static void testCountGenes() {
        System.out.println(countGenes("ATGTAAGATGCCCTAGT"));
    }
    }
    
# CSV FILES (Comma-Separated Values)

https://i.ytimg.com/vi/olXXqoaR0OY/maxresdefault.jpg


