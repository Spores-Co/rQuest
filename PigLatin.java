

public class PigLatin{
  
    public String toPig(String inEnglish){
      
        String[] wordsEng;

            wordsEng = inEnglish.split(" ");
            String newSentence = "";

            for(String wordEng : wordsEng) {
                if( wordEng.startsWith("a") || wordEng.startsWith("e") || wordEng.startsWith("i") ||
                        wordEng.startsWith("o") || wordEng.startsWith("u"))
                {
                    newSentence += wordEng + "yay ";
                }
                    else
                {
                    newSentence += wordEng.substring(1) + wordEng.substring(0,1) + "ay ";
                }  
                inEnglish = newSentence; 
            }
            return inEnglish;
    }

    public String fromPig(String inPigLatin){

    String[] wordsPig;
    wordsPig = inPigLatin.split(" ");
    String newSentence = "";


    for(String wordPig : wordsPig)
    {
        wordPig = wordPig.replace("-", "");
   
    }
        for(int i=0;i<wordsPig.length;i++)
        {
            String wordToFix = wordsPig[i];

            if( wordToFix.endsWith("yay")){

                wordToFix= wordToFix.replace("yay", "");
                
            }else{
                wordToFix = wordToFix.replace("ay", "");
            } 
            char lastLetter = wordToFix.charAt(wordToFix.length()-1);
            System.out.println(lastLetter);
            wordToFix = lastLetter + wordToFix.substring(0, wordToFix.length()-1) + " ";
            newSentence += wordToFix;
        }
            inPigLatin = newSentence;
            return inPigLatin;
    }
        

    public static void main(String args[]) {
        PigLatin demo = new PigLatin();
        String inEnglish = "Now is the winter of our discontent " +
                "Made glorious summer by this sun of York; " +
                "And all the clouds that lour'd upon our house " +
                "In the deep bosom of the ocean buried.";

        String inPigLatin = "avajay isyay ayay onderfulway ogrammingpray " +
                "anguagelay, andyay objectyay-orientedyay ogrammingpray " +
                "isyay ethay estbay ingthay afteryay icedslay eadbray.";
       
        System.out.println(demo.toPig(inEnglish+"\n"));
        System.out.println(demo.fromPig(inPigLatin));

    }
}