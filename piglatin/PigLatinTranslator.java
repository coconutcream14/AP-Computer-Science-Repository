package piglatin;

public class PigLatinTranslator {
    public static Book translate(Book input) {
        Book translatedBook = new Book();

        // TODO: Add code here to populate translatedBook with a translation of the
        // input book.
        // Curent do-nothing code will return an empty book.
        // Your code will need to call translate(String input) many times.

        int length = input.getLineCount();
        String line = "";
        for(int i = 0; i < length; i++){
            line = translate(input.getLine(i));
            translatedBook.appendLine(line);
        } 

        return translatedBook;
    }

    public static String translate(String input) {
        System.out.println("  -> translate('" + input + "')");

        String result = "";

        // TODO: translate a string input, store in result.
        // The input to this function could be any English string.
        // It may be made up of many words.
        // This method must call translateWord once for each word in the string.
        result = translateWord(input);

        return result;
    }

    private static String translateWord(String input) {
        System.out.println("  -> translateWord('" + input + "')");

        String result = "";
        int length = input.length();

        // TODO: Replace this code to correctly translate a single word.
        // Start here first!
        // This is the first place to work.

        // To check for empty strings
        if(input.isBlank()){
            return "";
        }

        // To check for sentences and send the word into a sentence using piglatinifyer method
        if (input.contains(" ")){
            String output = SentencePigLatinifyer(input);
            return output;
        }

        //To check for punctuation
        String tail = "";
        String newInput = "";
        if(input.substring(length - 1).equals(".")){
            tail = ".";
            newInput = input.substring(0, length - 1);
        } else{
            newInput = input;
        }
        length = newInput.length();
        //To check for any placements of capitalized letters and keep the index stored if so
        int i = 0;
        int index = 0;
        int upperCaseCount = 0;

        for(i = 0; i < length; i++){
            if(Character.isUpperCase(newInput.charAt(i))){
                upperCaseCount++;
            }
        }
//        System.out.println("The uppercase count is" + upperCaseCount);

        int [] upperCaseLetterAry  = new int[upperCaseCount];
        int j = 0;
        if(upperCaseCount > 0) {
            i = 0;
            for(j = 0; j < length; j++){
                if(Character.isUpperCase(newInput.charAt(j))){
                    upperCaseLetterAry[i++] = j;
                    //continue;
                }
            }
        } 

        String firstLetter = newInput.substring(0,1);

        String lowerCaseStr = newInput.toLowerCase(); // Convert to lowercase to handle both cases
        String vowels = "aeiouy";
        int indexOfFirstVowel = 0;

            // To check for a word starting with a vowel
            if(vowels.indexOf(firstLetter) != -1){
                result = newInput + "ay";
                return result;
            }  
            // To find the index of where the first vowel in a word is
            for (i = 0; i < lowerCaseStr.length(); i++) {
                char currentChar = lowerCaseStr.charAt(i);
                if (vowels.indexOf(currentChar) != -1) {
                    indexOfFirstVowel = i; // Return the index of the first vowel found
                    break;
                }
            }
        String firstPart = lowerCaseStr.substring(0, indexOfFirstVowel);
        String secondPart = lowerCaseStr.substring(indexOfFirstVowel);
        result = secondPart + firstPart;
        String answer = "";

        if(upperCaseCount > 0){
            j = 0;
            for(i = 0; i < length; i++){
                if(j < upperCaseLetterAry.length && i == upperCaseLetterAry[j]){
                    answer = answer + String.valueOf(result.charAt(upperCaseLetterAry[j])).toUpperCase();
                    j++;
                    continue;
                }
                answer = answer + String.valueOf(result.charAt(i));
            }
            return answer + "ay" + tail;
        }

        return result + "ay" + tail;
    }

    private static String SentencePigLatinifyer(String input) {
        int i = 0;
        input = input.trim();

        //Seperates the string input into the different words
        String [] wordAry = input.trim().split(" ");
        
        //Takes each individual word and converts it to pig latin form
        int lengthOfwordAry = wordAry.length;

        for(i = 0; i < lengthOfwordAry; i++){
            wordAry[i]  = wordPigLatinify(wordAry[i]);
        }

        //Combines all the words back together

        String result = "";
        for(i = lengthOfwordAry - 1; i >= 0; i--){
            result = wordAry[i] + " " + result;
        }

        return result.trim();
    }

    private static String wordPigLatinify(String input) {
        String result = "";
        String vowelTest = input.substring(0,1);

        String lowerCaseStr = input.toLowerCase(); // Convert to lowercase to handle both cases
        String vowels = "aeiou";
        int index = 0;

        // To check for a word starting with a vowel
        if(vowelTest.equals("a") || vowelTest.equals("e") || vowelTest.equals("i") || vowelTest.equals("o") || vowelTest.equals("u")){
            result = input + "ay";
        } else {
            // To find the index of where the first vowel in a word is
            for (int i = 0; i < lowerCaseStr.length(); i++) {
                char currentChar = lowerCaseStr.charAt(i);
                if (vowels.indexOf(currentChar) != -1) {
                    index = i; // Return the index of the first vowel found
                    break;
                }
            }
        }

        String firstPart = input.substring(0, index);
        String secondPart = input.substring(index);
        result = secondPart + firstPart + "ay";

        return result;
    }

    // Add additonal private methods here.
    // For example, I had one like this:
    // private static String capitalizeFirstLetter(String input)

}
