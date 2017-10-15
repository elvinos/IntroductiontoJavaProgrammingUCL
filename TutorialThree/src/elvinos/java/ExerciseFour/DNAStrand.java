package elvinos.java.ExerciseFour;

import com.sun.tools.javac.util.ArrayUtils;

public class DNAStrand {
    String dna;
    public DNAStrand(String dna){
        this.dna = dna;
    }

    public boolean isValidDNA() {
        char[] dnaCharArray = dna.toCharArray();
        if (dnaCharArray.length <= 0){
            return false;
        }
        System.out.println(dnaCharArray);
        for (char i : dnaCharArray) {
            if(i != 'A' && i != 'T' && i != 'C' && i != 'G'){
                return false;
            } else if (Character.isLowerCase(i)){
                return false;
            }
        }
        return true;
    }

    public String complementWC(){
        char[] dnaCharArray = dna.toCharArray();
        char[] compDnaCharArray = new char[dnaCharArray.length];
        int count = 0;
        for (char i : dnaCharArray) {
            if(i == 'A'){
                compDnaCharArray[count] = 'T';
            }else if(i == 'T'){
                compDnaCharArray[count] = 'A';
            }else if(i == 'C'){
                compDnaCharArray[count] = 'G';
            }else if(i == 'G'){
                compDnaCharArray[count] = 'C';
            }
            count++;
        }
        String complementDNA = new String(compDnaCharArray);
        return complementDNA;
    }


    public String palindromeWC() {
        String complementDNA = complementWC();
        String reverseComplementDNA = new StringBuilder(complementDNA).reverse().toString();
        return reverseComplementDNA;

    }

    public boolean containsSequence(String seq){
        if(dna.contains(seq)){
        return true;
        } else{
            return false;
        }

    }

    @Override
    public String toString(){
        return dna;
    }


}
