import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/*
 * Note: Ask Leo about how to make this work for getting text from a database
 */

public class Parse{
	private Scanner scanner;

	public Parse(String file)throws FileNotFoundException{
		scanner = new Scanner(new File(file));
	}

	//Reads and evaluates the next string
	//Returns the token type and the string itself
	//in a string array
	public String[] readNext(){
		String str = scanner.next();
		return null;
	}

	//Helper method to readNext
	//Returns the token of the given string
	private String tokenizer(String str){
		String token;

		/*Is str a number?*/

		//Get rid of negative sign if it's there
		if(str.charAt(0) == '-'){
			str = str.substring(1, str.length());
		}

		//Check if it's a number
		boolean isInt = true;
		boolean isDouble = false; //Becomes true if decimal detected
		for(int i = 0; i < str.length(); i++){
			//str is a double if it has one and only one decimal
			if(str.charAt(i) == '.' && !isDouble){
				isDouble = true;
			}
			else if(!Character.isDigit(str.charAt(i))){
				isInt = false;
				break;
			}
		}

		//If isInt and isDouble are both true, it's a double
		if(isInt && isDouble){
			return "double";
		}
		else if(isInt){
			return "int";
		}

		/*Is str an operator?*/

		if(str.length() <= 2){
			String[] arithOp = {"+", "-", "*", "/", "%"};
			String[] assignOp = {"=", "+=", "-=", "*=", "/=", "%="};
			String[] compOp = {"==", "<", ">", "!=", "<=", ">="};
			String[] logicOp = {"&&", "||"};
			String[] oddOp = {"?"};

			for(int i = 0; i < arithOp.length; i++){
				if(str.equals(arithOp[i])){
					return "arithmetic_op";
				}
			}
			for(int i = 0; i < assignOp.length; i++){
				if(str.equals(assignOp[i])){
					return "assign_op";
				}
			}
			for(int i = 0; i < compOp.length; i++){
				if(str.equals(compOp[i])){
					return "compare_op";
				}
			}
			for(int i = 0; i < logicOp.length; i++){
				if(str.equals(logicOp[i])){
					return "logic_op";
				}
			}
			for(int i = 0; i < oddOp.length; i++){
				if(str.equals(oddOp[i])){
					return "odd_op";
				}
			}
		}

		/*Is str a keyword?*/
		String[] type = {"byte", "short", "int", "long", "float", "double",
							"boolean", "char", "String", "Object"};
		String[] class = {"abstract", "class", "extends", }

		

		
		return null;
	}

	//Returns boolean saying whether there is
	//anything more to read
	public boolean hasNext(){
		return scanner.hasNext();
	}

	public static void main(String[] args){

	}
}