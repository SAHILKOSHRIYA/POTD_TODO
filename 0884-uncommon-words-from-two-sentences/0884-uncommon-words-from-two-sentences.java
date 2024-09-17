import java.util.*;

class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        // Split both sentences into words
        String[] words1 = s1.split(" ");
        String[] words2 = s2.split(" ");
        
        // Create a HashMap to count word frequencies
        Map<String, Integer> wordCount = new HashMap<>();
        
        // Count words in the first sentence
        for (String word : words1) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        // Count words in the second sentence
        for (String word : words2) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        // Collect uncommon words (words that appear exactly once)
        List<String> uncommonWords = new ArrayList<>();
        for (String word : wordCount.keySet()) {
            if (wordCount.get(word) == 1) {
                uncommonWords.add(word);
            }
        }
        
        // Convert the list to an array and return
        return uncommonWords.toArray(new String[0]);
    }
}
