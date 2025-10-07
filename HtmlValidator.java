import java.util.Stack;

class HtmlValidator {

    public boolean isWellFormed(String[] tags) {
        Stack<String> tagStack = new Stack<>();

        for (String tag : tags) {
            if (tag.startsWith("</")) {
                // Extract tag name from closing tag
                String tagName = tag.substring(2, tag.length() - 1);

                // Check if stack is empty or top doesn't match
                if (tagStack.isEmpty() || !tagStack.pop().equals(tagName)) {
                    return false;
                }
            } else {
                // Extract tag name from opening tag
                String tagName = tag.substring(1, tag.length() - 1);
                tagStack.push(tagName);
            }
        }

        // If stack is empty, all tags were matched correctly
        return tagStack.isEmpty();
    }
}