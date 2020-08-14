/*
- one word key to N-word key
How to search for N words in a String[]

 */


import java.util.ArrayList;

public class WordGram {
    private String[] myWords;
    private int myHash;

    public WordGram(String[] source, int start, int size) {
        myWords = new String[size];
        System.arraycopy(source, start, myWords, 0, size);
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    // like charAt
    public String wordAt(int index) {
        if (index < 0 || index >= myWords.length) {
            throw new IndexOutOfBoundsException("bad index in wordAt "+index);
        }
        return myWords[index];
    }


    //
    public int length(){
        return myWords.length;
    }

    public String toString(){
        String ret = "";
        // TODO: Complete this method
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length(); i++) {
            sb.append(myWords[i] + " ");
        }
        ret = sb.toString();
        return ret.trim();
    }

    public boolean equals(Object o) {
        WordGram other = (WordGram) o;

        if (length() != other.length()) return false;

        for (int i = 0; i < myWords.length; i++) {
            if (!this.myWords[i].equals(other.wordAt(i))) {
                return false;
            }
        }
        return true;

    }

    public WordGram shiftAdd(String word) {
        // TODO: Complete this method
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length() - 1; i++) {
            sb.append(myWords[i+1] + " ");
        }
        sb.append(word);
        String strOut[] = sb.toString().split("\\s+");
        WordGram out = new WordGram(strOut, 0, length());
        return out;
    }

}