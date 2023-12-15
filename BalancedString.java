
public class Test {
    public static void main(String[] args) {
        String input  ="([{([])}])";
        String input1 = "([])";

        if(isBalancedCheckValidParenthesis(input1)){
            System.out.println("Balanced");
        }else{
            System.out.println("Not Balanced");
        }
    }

    public static boolean isBalancedCheckValidParenthesis(String str) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i< str.length();i++){
            char ch = str.charAt(i);
            if(ch == '(' || ch == '{' || ch == '[' ){
                stack.push(ch);
                continue;
            }
            if(stack.empty()){
               return false;
            }

            char check;
            switch (ch){
                case ')':
                    check = stack.pop();
                    if(check == '{' || check == '['){
                       return false;
                    }
                    break;
                case '}':
                    check = stack.pop();
                    if(check == '(' || check == '['){
                        return false;
                    }
                    break;
                case ']':
                    check = stack.pop();
                    if(check == '{' || check == '('){
                        return false;
                    }
                break;
            }
        }
        return stack.empty();
    }
}
