package assessment;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SearchSuggestionSystem {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        for (String product : products) {
            trie.addWord(product);
        }
        List<List<String>> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (char ch : searchWord.toCharArray()) {
            List<String> words = trie.searchByPrefix(sb.append(ch).toString());
            result.add(words.stream().limit(3).collect(Collectors.toList()));
        }
        return result;
    }

    public static void main(String[] args) {
        SearchSuggestionSystem searchSuggestionSystem = new SearchSuggestionSystem();
        String[] products = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String searchTerm = "mouse";
        List<List<String>> lists = searchSuggestionSystem.suggestedProducts(products, searchTerm);
        lists.forEach(System.out::println);
    }
}
