
import java.util.*;

public class CalculatorBrain {
    // precedence of operations
    private HashMap<Character, Integer> prec;
    
    // to keep whole operation
    private ArrayList<String> operations;
    
    // to temprorily keep the operators
    private ArrayList<Character> operators;
    
    public CalculatorBrain(){
        // initialize the fields
        operations = new ArrayList<>();
        operators = new ArrayList<>();
        initHashMap();
    }
    
    private void initHashMap(){
        // assign precedence values to the operators
        prec = new HashMap<>();
        prec.put('(', 3);
        prec.put(')', 3);
        prec.put('*', 2);
        prec.put('/', 2);
        prec.put('+', 1);
        prec.put('-', 1);
    }
    
    // Given expression must be converted from infix to postfix
    public void parseToPostfix(String ops){
        String num = "";
        for(int i=0; i<ops.length(); i++){
            char ch = ops.charAt(i);
            if ((ch>47 && ch<58)|| ch=='.') {
                num += ch;
            } else {
                
                if(!num.isBlank()){
                   operations.add(num);
                   num = ""; 
                }
                
                // detect negative numbers
                String detected = detectNegative(ch, ops, i);
                
                if(! detected.isBlank()){
                    if(ch=='('){
                        operations.add("0");
                        operations.add("(");
                        operations.add(detected.substring(1));
                        operations.add(")");
                        operations.add("-");
                        i += detected.length()+1;
                    }else{
                        operations.add("0");
                        operators.add('-');
                        operations.add(detected.substring(1)); // num
                        i += detected.length()-1;
                    }
                    
                }else{
         
                    if(operators.isEmpty()){
                        operators.add(ch);
                    }else {
                        if(prec.get(operators.get(operators.size()-1)) >= prec.get(ch)){
                            if(operators.get(operators.size()-1) == ')'){
                                int j = operators.size()-1;
                                while(true){
                                    operations.add(String.valueOf(operators.get(j)));
                                    operators.remove(j);
                                    j--;
                                    if(j<0) break;
                                }
                                operators.add(ch);
                            }else{
                                operations.add(String.valueOf(operators.get(operators.size()-1)));
                                operators.remove(operators.size()-1);
                                operators.add(ch);
                            }
                        }else {
                            operators.add(ch);
                        }
                    }  
                }
                 
            }
        }
        
        if(!num.isBlank()) operations.add(num);
        
        if(! operators.isEmpty()){
            for(int i=operators.size()-1; i>=0; i--){
                operations.add(String.valueOf(operators.get(i)));
            }
        }
        
        System.out.println("infix to postfix: " + operations); // debug print
    }
    
    
    private void refreshOperations(){
        this.operations.clear();
        this.operators.clear();
        // System.out.println("operations after deletion: " + this.operations); // debug print
    }
    
    // read postfix expression and do the math.
    public String calculate(){
        
        double result = 0; // to avoid error, temporary
        ArrayList<Double> nums = new ArrayList<>();
        // get the result.
        for(String str:this.operations){
            if(!(str.charAt(0) == '(' || str.charAt(0)==')')){
              if(!(str.charAt(0)>47 && str.charAt(0)<58)){
                    int lastIndex = nums.size() -1;
                    if(lastIndex>=1){
                        result = doMath(nums.get(lastIndex-1), nums.get(lastIndex), str.charAt(0));
                        nums.remove(lastIndex);
                        nums.remove(lastIndex-1);
                        nums.add(result);
                    }else {
                        result = nums.get(0);
                        nums.remove(lastIndex);
                    }
                }else{
                    nums.add(Double.valueOf(str));
                }  
            } 
        }
        
        refreshOperations();
        //System.out.println(result); // debug print
        return String.valueOf(result);
    }
    
    private String detectNegative(char ch, String operation, int i){
        String result = "";
        // System.out.println(operation); // debug print
        int len = operation.length();
        if(i==0 && len>=1 && ch=='-'){
            int k ;
            for(k=i+1; k<len; k++){
                if(!((operation.charAt(k)<58 && operation.charAt(k)>47) || (operation.charAt(k)=='.')) )
                    break;
            }
           result = operation.substring(0, k);
        }else if(ch == '(' && i<= len-3){
            if(operation.charAt(i+1) == '-' && (operation.charAt(i+2)<58 && operation.charAt(i+2)>47)){
                int j ;
                for(j=i+2; j<len; j++){
                    if(!((operation.charAt(j)<58 && operation.charAt(j)>47) || (operation.charAt(j)=='.')) )
                        break;
                }
                result = operation.substring(i+1, j);
            }
        }
        System.out.println("detected: "+result); // debug print
        return result;
    }
    
    // do the given operation over the given two numbers
    private double doMath(double operand1, double operand2, char operation){
        double result = 0;
        
        switch(operation){
            case '*':
                result = operand1 * operand2;
                break;
            case '/':
                result = operand1 / operand2;
                break;
            case '+':
                result = operand1 + operand2;
                break; 
            case '-':
                result = operand1 - operand2;
                break; 
            default:
                System.out.println("doMath method works: something went wrong!");
        }
        
        return result;
    }
    

}
