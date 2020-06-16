package principal;

import java.util.*;

import priorityQueue.EjPriorityQueue;

public class EjerciciosLPC {

	public static void main(String[] args) {
		
		//infixToPostFix("( ( 5 * 6 ) - 10 )");
		//System.out.println(evaluatePostfix("5 6 * 10 -"));
		/*try {
			parentesis("(()(ab)c(ad)((al)()");
		} catch (ExceptionParentesis e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}*/
		
		System.out.println(palindrome("la,ruta .natural"));
		
	}
	
	/*Palindromo*/
	public static boolean palindrome(String msg) {
		msg=msg.replace(" ", "").replace(".", "").replace(",", "").toLowerCase();
		
		Stack<String> p1=new Stack<String>();
		Queue<String> c1=new LinkedList<String>();
		
		p1.addAll(Arrays.asList(msg.substring(0, msg.length()/2).split("")));
		System.out.println(p1);
			
		c1.addAll(Arrays.asList(msg.substring(msg.length()%2==0?msg.length()/2:msg.length()/2+1, msg.length()).split("")));
		System.out.println(c1);
		
		
		while(!p1.isEmpty() && !c1.isEmpty()) {
			if(!p1.pop().equals(c1.poll())) {
				return false;
			}
		}
		
		return true;
		
	}
	
	/*Haga un procedimiento que evalúe la notación posfija*/
	public static double evaluatePostfix(String exp) {
		Stack<String> lista=new Stack<String>();
		Stack<String> result=new Stack<String>();
		
		String[] expresion = (exp).split(" ");
		 for (int i = expresion.length - 1; i >= 0; i--) {
		      lista.push(expresion[i]);
		    }
		 
		
		System.out.println(lista);
		while(!lista.isEmpty()) {
			if(lista.peek().equals("*")||lista.peek().equals("+")||
							lista.peek().equals("-")||lista.peek().equals("/")) {
				result.push(Double.toString(operacion(Double.parseDouble(result.pop()), 
						Double.parseDouble(result.pop()), lista.pop())));
				
			}else{
				result.push(lista.pop());
			}
			System.out.println("l: "+lista);
			System.out.println("r: "+result);
			
		}
		
		double r=Double.parseDouble(result.pop());
		
		return r;
	}
	
	public static double operacion(double n1,double n2, String op) {
		double result=n2;
		
			switch (op) {
			case "+":
				result+=n1;
				break;
			case "-":
				result-=n1;
				break;
			case "*":
				result*=n1;
				break;
			case "/":
				result/=n1;
				break;
			default:
				break;
			}
		
		
		return result;
	}
	
		
	/* chequee si los paréntesis están bien 
	 * (verifique siempre cierre los que abre y en el orden correcto)*/
	
	public static void parentesis(String msg) throws ExceptionParentesis {
		
		 Stack<Character> parentesis=new Stack<Character>();
		 Stack<Integer> posNoPermitida=new Stack<Integer>();
		 
		 int i=0;
		 while(i<msg.length()) {
			 
			 switch (verificarP(String.valueOf(msg.charAt(i)))) {
				case 1:
					posNoPermitida.push(i);
					parentesis.push(msg.charAt(i));
					break;
				case 2:
					if(parentesis.isEmpty()) {
						posNoPermitida.push(i);
					}else if(parentesis.peek().equals('(')) {
						parentesis.pop();
						posNoPermitida.pop();
					} 
					break;
	
				default:
					break;
				}
			 i++;
			//System.out.println("p: "+parentesis);
		 }
		// System.out.println("P:"+posNoPermitida);
		 if(parentesis.isEmpty()) {
			System.out.println("Los parentesis estan bien");
		 }else {
			throw new ExceptionParentesis(posNoPermitida);
		 }
		
	}
	
	public static int verificarP(String msg) {
		if(msg.equals("("))
			return 1;
		else if(msg.equals(")"))
				return 2;
		else 
			return 10; 			
	}
	
		/*convertir de notación infija a posfija*/
	public static void infixToPostFix(String exp) {
	    String[] arrayInfix = (exp).split(" ");

	    Stack<String> entrada = new  Stack<String>(); 
	    Stack<String> operadores = new  Stack<String>(); 
	    Stack<String> result = new  Stack<String>();

	    for (int i = arrayInfix.length - 1; i >= 0; i--) {
	      entrada.push(arrayInfix[i]);
	    }
	    
	    try {
	      while (!entrada.isEmpty()) {
	    	  //System.out.println("e: "+entrada);
	        switch (jerarquia(entrada.peek())){
	          case 1:
	            operadores.push(entrada.pop());
	            break;
	          case 3:
	          case 4:
	            while(jerarquia(operadores.peek()) >= jerarquia(entrada.peek())) {
	              result.push(operadores.pop());
	            }
	            operadores.push(entrada.pop());
	            break; 
	          case 2:
	            while(!operadores.peek().equals("(")) {
	              result.push(operadores.pop());
	            }
	            operadores.pop();
	            entrada.pop();
	            break; 
	          default:
	            result.push(entrada.pop()); 
	        }
	        
	        //System.out.println("o: "+operadores);
	        //System.out.println("s: "+result);
	      } 

	      System.out.println("Expresion Infija: " + exp.replace(" ", ""));
	      System.out.println("Expresion Postfija: " + result.toString().replaceAll("[\\]\\[,]", ""));

	    }catch(Exception ex){ 
	    	System.out.println("Error en la expresión algebraica");
	    }
	  } 

	  private static int jerarquia(String op) {
	    if (op.equals("^")) return 5;
	    if (op.equals("*") || op.equals("/")) return 4;
	    if (op.equals("+") || op.equals("-")) return 3;
	    if (op.equals(")")) return 2;
	    if (op.equals("(")) return 1;
	    return 99;
	  }

	
	
	
	
	
	
}
