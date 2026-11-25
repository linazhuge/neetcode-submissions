class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stk = deque()
        operations = ["+", "-", "*", "/"]
        for token in tokens:
            if token in operations:
                val2 = stk.pop()
                val1 = stk.pop()
                match token:
                    case "+":
                        stk.append(val1 + val2)
                    case "-":
                        stk.append(val1 - val2)
                    case "*":
                        stk.append(val1 * val2)
                    case "/":
                        stk.append(int(val1 / val2))
            else:
                stk.append(int(token))

        return stk.pop()
