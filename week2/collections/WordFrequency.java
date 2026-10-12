import java.util.HashMap;
import java.util.Map;

void main() {
    String sentence = IO.readln("Escribe una oración: ");

    HashMap<String, Integer> wordCount = new HashMap<>();

    String[] words = sentence.split("\\s+");

    for (String word : words) {
        if (wordCount.containsKey(word)) {
            wordCount.put(word, wordCount.get(word) + 1);
        }
        else {
            wordCount.put(word, 1);
        }
    }

    for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
        IO.println(entry.getKey() + " = " + entry.getValue());
    }
}