import java.util.HashSet;
import java.util.List;
import java.util.Set;

class GottaSnatchEmAll {
    /**
    * Creates a new unique collection from a list of cards.
    */
    static Set<String> newCollection(List<String> cards) {
        return new HashSet<>(cards);
    }

    /**
    * Adds a card to the collection. Returns true if the card was new.
    */
    static boolean addCard(String card, Set<String> collection) {
        return collection.add(card);
    }

    /**
    * A trade is possible if both parties have at least one card the other doesn't.
    */
    static boolean canTrade(Set<String> myCollection, Set<String> theirCollection) {
        boolean iHaveSomethingTheyDont = myCollection.stream().anyMatch(card -> !theirCollection.contains(card));
        boolean theyHaveSomethingIDont = theirCollection.stream().anyMatch(card -> !myCollection.contains(card));
        
        return iHaveSomethingTheyDont && theyHaveSomethingIDont;
    }

    /**
    * Finds the intersection of all collections (cards everyone owns).
    */
    static Set<String> commonCards(List<Set<String>> collections) {
        if (collections.isEmpty()) {
            return new HashSet<>();
        }

        // Start with the first collection
        Set<String> common = new HashSet<>(collections.get(0));

        // Keep only elements that exist in every subsequent set (Intersection)
        for (Set<String> collection : collections) {
            common.retainAll(collection);
        }
        
        return common;
    }
    
    /**
     * Combines all collections into one set of unique cards.
     */
    static Set<String> allCards(List<Set<String>> collections) {
        Set<String> combined = new HashSet<>();
        
        // Add all elements from every set (Union)
        for (Set<String> collection : collections) {
            combined.addAll(collection);
        }

        return combined;
    }
}
