package leetcode.array;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/unique-email-addresses/
public class UniqueEmails {

    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();
        for (String email : emails) {
            uniqueEmails.add(canonicalize(email));
        }

        return uniqueEmails.size();
    }

    private String canonicalize(String email) {
        int domainIndex = email.indexOf("@");
        String local = email.substring(0, domainIndex);
        String domain = email.substring(domainIndex);
        int plusIndex = local.indexOf("+");
        if (plusIndex != -1) {
            local = local.substring(0, plusIndex);
        }
        local = local.replaceAll("\\.", "");
        return local + domain;

    }
}
