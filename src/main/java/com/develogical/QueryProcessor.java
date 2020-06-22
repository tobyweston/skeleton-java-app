package com.develogical;

import java.io.IOException;

public class QueryProcessor {

    public String process(String query) throws IOException {
        if (query == null) {
            throw new IOException("No query was supplied, perhaps no query parameter was supplied on the URI (q= instead of q=param)");
        }
        if (query.toLowerCase().contains("romeo and juliet")) {
            return "William Shakespeare";
        }
        return "";
    }
}
