import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        // 문자열의 각 문자를 순회
        for (char c : s.toCharArray()) {
            // 여는 괄호일 경우 스택에 넣기
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // 닫는 괄호인데 스택이 비어있으면 짝이 맞지 않음
                if (stack.isEmpty()) {
                    return false;
                }

                // 스택의 마지막 값과 현재 닫힌 괄호가 맞는지 확인
                char open = stack.pop();
                if ((c == ')' && open != '(') || 
                    (c == '}' && open != '{') || 
                    (c == ']' && open != '[')) {
                    return false;
                }
            }
        }

        // 모든 괄호 처리 후 스택이 비어있어야 함
        return stack.isEmpty();
    }
}