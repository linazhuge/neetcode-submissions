class Solution {
    public boolean isValid(String s) {
        Stack <Character> stk = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stk.push(c);
            } else if (c == ')') {
                if (stk.isEmpty() || stk.pop() != '(') return false;
            } else if (c == '}') {
                if (stk.isEmpty() || stk.pop() != '{') return false;
            } else if (c == ']') {
                if (stk.isEmpty() || stk.pop() != '[') return false;
            }
        }

        if (!stk.isEmpty()) return false;
        return true;
    }
}
