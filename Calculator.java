import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Calculator
{
	public static void main(String[] args)
	{
		System.out.println("Sets Calculator");
		System.out.println("==========================");
		Scanner myScanner = new Scanner(System.in);
		String str = myScanner.next();
		calc(str);
	}
	
	private static void calc(String instruction)
	{
		String command = "";
		String rest = "";
		for (int i=0;i<instruction.length();i++)
		{
			if (instruction.charAt(i)!=' '){
				command += instruction.charAt(i);
			}
			else {
				rest = instruction.substring(i+1);
				break;
			}
		}
		
		Set mySet1 = new Set();
		StringTokenizer stk = new StringTokenizer(rest , ", ");
		while(stk.hasMoreTokens())
		{
			if (stk.nextToken().charAt(0)=='{')
			{
				Stack myStack=new Stack();
				
				
			}
			else
			{
			
			}
		}
		
		
		
		
		
		
		switch (command){
			case "size":
				break;
			case "contains":
				break;
			case "member":
				break;
			case "deepExistence":
				break;
			case "equals":
				break;
			case "insert":
				break;
			case "remove":
				break;
			case "union":
				break;
			case "intersect":
				break;
			case "difference":
				break;
			case "power":
				break;
			case "transformAdd":
				break;
			case "transformMul":
				break;
			case "help":
				break;
			case "bonus":
				break;
			case "exit":
				System.exit(0);
				break;
			default:
				System.out.println("Error: invalid command");
			
			
		}
	}
	
}