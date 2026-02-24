import java.util.HashMap;
import java.util.Map;

public class DialingCodes {

    // Initialize the internal storage
    private final Map<Integer, String> codesMap = new HashMap<>();

    public Map<Integer, String> getCodes() {
        return codesMap;
    }

    public void setDialingCode(Integer code, String country) {
        // put() handles both adding new entries and updating existing keys
        codesMap.put(code, country);
    }

    public String getCountry(Integer code) {
        return codesMap.get(code);
    }

    public void addNewDialingCode(Integer code, String country) {
        // Only add if the code (key) doesn't exist AND the country (value) doesn't exist
        if (!codesMap.containsKey(code) && !codesMap.containsValue(country)) {
            codesMap.put(code, country);
        }
    }

    public Integer findDialingCode(String country) {
        // We have to iterate through the entries to find a key by its value
        for (Map.Entry<Integer, String> entry : codesMap.entrySet()) {
            if (entry.getValue().equals(country)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public void updateCountryDialingCode(Integer code, String country) {
        // First, check if the country exists in our map
        Integer existingCode = findDialingCode(country);
        
        if (existingCode != null) {
            // Remove the old entry and add the corrected one
            codesMap.remove(existingCode);
            codesMap.put(code, country);
        }
    }
}
