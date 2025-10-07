import java.util.Stack;

class TextEditor {
    private StringBuilder content;
    private Stack<String> history;

    public TextEditor() {
        this.content = new StringBuilder();
        this.history = new Stack<>();
    }

    public void type(String text) {
        // Save current content to history before modifying
        history.push(content.toString());
        content.append(text);
    }

    public void undo() {
        if (!history.isEmpty()) {
            content = new StringBuilder(history.pop());
        }
    }

    public String getContent() {
        return content.toString();
    }
}
