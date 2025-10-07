import java.util.Stack;

class PathSimplifier {
    public String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();
        String[] components = path.split("/");

        // Iterate through the 'components'.
        for (String result : components) {
            if (result.equals(".") || result.isEmpty()) {
                continue;

            } else if (result.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(result);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        // Use a StringBuilder to join the elements in the stack.
        // to form the final path string (e.g., "/dir1/dir2").
        StringBuilder resultTow = new StringBuilder();
        for (String dir : stack) {
            resultTow.append("/").append(dir);

        }
        return resultTow.toString();
    }
}
