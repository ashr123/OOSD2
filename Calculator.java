import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Calculator
{
	public static void main(String[] args)
	{
		Scanner myScanner=new Scanner(System.in);
		System.out.println("Sets Calculator");
		System.out.println("==========================");
		//noinspection InfiniteLoopStatement
		while (true)
			calc(myScanner.nextLine().trim());
	}
	
	private static void calc(String instruction)
	{
		if (instruction.equals(""))
			return;
		StringTokenizer stk=new StringTokenizer(instruction, " ");
		String command=stk.nextToken();
		Set mySet=null;
		String toSet;
		if (!command.contentEquals("help") && !command.contentEquals("exit") && !command.contentEquals("bonus"))
		{
			String rest="";
			try
			{
				rest=stk.nextToken();
			}
			catch (Exception ignored)
			{
			
			}
			StringTokenizer toSets=new StringTokenizer(rest, " ");
			try
			{
				toSet=toSets.nextToken();
				mySet=setParser(toSet);
			}
			catch (Exception ignored)
			{
			
			}
		}
		String temp;
		Element tempSet;
		switch (command)
		{
			case "size":
				System.out.println(mySet==null ? "" : /*mySet+"\n"+*/mySet.size());
				break;
			case "contains":
				temp=stk.nextToken();
				tempSet=setParser(temp);
				if (temp==null || tempSet==null)
				{
					System.out.println();
					break;
				}
				System.out.println(mySet==null ? "" : mySet.contains((Set)tempSet));
				break;
			case "member":
				temp=stk.nextToken();
				tempSet=nextElementOrSet(temp);
				if (temp==null || tempSet==null)
				{
					System.out.println();
					break;
				}
				System.out.println(mySet==null ? "" : mySet.member(tempSet));
				break;
			case "deepExistence":
				temp=stk.nextToken();
				tempSet=nextElementOrSet(temp);
				if (temp==null || tempSet==null)
				{
					System.out.println();
					break;
				}
				System.out.println(mySet==null ? "" : mySet.deepExistence(tempSet));
				break;
			case "equals":
				temp=stk.nextToken();
				tempSet=nextElementOrSet(temp);
				if (temp==null || tempSet==null)
				{
					System.out.println();
					break;
				}
				System.out.println(mySet==null ? "" : mySet.equals(tempSet));
				break;
			case "insert":
				temp=stk.nextToken();
				tempSet=nextElementOrSet(temp);
				if (temp==null || tempSet==null)
				{
					System.out.println();
					break;
				}
				System.out.println(mySet==null ? "" : mySet.insert(tempSet));
				break;
			case "remove":
				temp=stk.nextToken();
				tempSet=nextElementOrSet(temp);
				if (temp==null || tempSet==null)
				{
					System.out.println();
					break;
				}
				System.out.println(mySet==null ? "" : mySet.remove(tempSet));
				break;
			case "union":
				temp=stk.nextToken();
				tempSet=setParser(temp);
				if (temp==null || tempSet==null)
				{
					System.out.println();
					break;
				}
				System.out.println(mySet==null ? "" : mySet.union((Set)tempSet));
				break;
			case "intersect":
				temp=stk.nextToken();
				tempSet=setParser(temp);
				if (temp==null || tempSet==null)
				{
					System.out.println();
					break;
				}
				System.out.println(mySet==null ? "" : mySet.intersect((Set)tempSet));
				break;
			case "difference":
				temp=stk.nextToken();
				tempSet=setParser(temp);
				if (temp==null || tempSet==null)
				{
					System.out.println();
					break;
				}
				System.out.println(mySet==null ? "" : mySet.difference((Set)tempSet));
				break;
			case "power":
				System.out.println(mySet==null ? "" : mySet.power());
				break;
			case "transformAdd":
				temp=stk.nextToken();
				tempSet=elementParser(temp);
				if (temp==null || tempSet==null)
				{
					System.out.println();
					break;
				}
				System.out.println(mySet==null ? "" : mySet.transformAdd((Numeric)tempSet));
				break;
			case "transformMul":
				temp=stk.nextToken();
				tempSet=elementParser(temp);
				if (temp==null || tempSet==null)
				{
					System.out.println();
					break;
				}
				System.out.println(mySet==null ? "" : mySet.transformMul((Numeric)tempSet));
				break;
			case "help":
				printHelp();
				break;
			case "bonus":
				getBonus();
				break;
			case "exit":
				System.exit(0);
				break;
			default:
				System.out.println("Error: invalid command");
		}
	}
	
	private static Element nextElementOrSet(String s)
	{
		if (s.charAt(0)=='{')
			return setParser(s);
		return elementParser(s);
	}
	
	private static void printHelp()
	{
		System.out.println(
				"size <set>\ncontains <set> <set>\nmember <set> <element>\ndeepExistence <set> <element>\nequals <element> <element>\ninsert <set> <element>\nremove <set> <element>\nunion <set> <set>\nintersect <set> <set>\ndifference <set> <set>\npower <set>\ntransformAdd <element> <numeric>\ntransformMul <element> <numeric>\nhelp\nbonus\nexit");
	}
	
	private static Element elementParser(String s)
	{
		if (s==null)
			return null;
		StringTokenizer stk=new StringTokenizer(s);
		String nextToken=stk.nextToken();
		try
		{
			if (nextToken.contains("/"))
			{
				StringTokenizer divideStringTokenizer=new StringTokenizer(nextToken, "/");
				int intA=Integer.parseInt(divideStringTokenizer.nextToken());
				int intB=Integer.parseInt(divideStringTokenizer.nextToken());
				return new RationalNumeric(intA, intB);
			}
			else
				return new RealNumeric(Double.parseDouble(nextToken));
		}
		catch (Exception e)
		{
			System.out.print("Error: cannot parse "+s);
			return null;
		}
	}
	
	private static Set setParser(String rest)
	{
		if (rest==null)
			return null;
		Stack<Set> myStack=new Stack<>();
		int bracesCount=0;
		StringTokenizer stk=new StringTokenizer(rest, ", ");
		while (stk.hasMoreTokens())
		{
			String nextToken=stk.nextToken();
			while (nextToken.length()!=0 && nextToken.charAt(0)=='{')
			{
				bracesCount++;
				nextToken=nextToken.substring(1);//Removes the "{"
				myStack.push(new Set());
			}
			int isFinished=0;
			while (nextToken.length()!=0 && nextToken.charAt(nextToken.length()-1)=='}')
			{
				nextToken=nextToken.substring(0, nextToken.length()-1); //Removes the "}"
				isFinished++;
				if ((--bracesCount<0 && nextToken.contentEquals("}")) || (!stk.hasMoreElements() && bracesCount!=0))
				{
					System.out.print("Error: cannot parse "+rest);
					return null;
				}
			}
			if (nextToken.length()!=0)
			{
				if (bracesCount==0 && isFinished<=0)
				{
					System.out.print("Error: "+rest+" is not a set!");
					return null;
				}
				try
				{
					if (nextToken.contains("/"))// It's a Rational Number.
					{
						StringTokenizer divideStringTokenizer=new StringTokenizer(nextToken, "/");
						int intA=Integer.parseInt(divideStringTokenizer.nextToken());
						int intB=Integer.parseInt(divideStringTokenizer.nextToken());
						myStack.peek().insert(new RationalNumeric(intA, intB));
					}
					else// It's a Real number.
					{
						double num=Double.parseDouble(nextToken);
						myStack.peek().insert(new RealNumeric(num));
					}
				}
				catch (Exception e)
				{
					System.out.print("Error: cannot parse "+rest);
					return null;
				}
			}
			while (myStack.size()>1 && isFinished>0)
			{
				Set temp=myStack.pop();
				myStack.peek().insert(temp);
				isFinished--;
			}
		}
		if (myStack.size()==1 && bracesCount>0)
		{
			System.out.print("Error: cannot parse "+rest);
			return null;
		}
		return myStack.pop();
	}
	
	private static void getBonus()
	{
		System.out.println(
				"                                            8j_j%jQ\n               _|jjWQQ vQjj<@p Ujjj@Q _Qj<%jpmpQQBpU|Qp _QU%j@p QQ<jQQ -QMjjp_\n                jQUQmp  pBjQM  _QQjQp  8pC@MUjUjpjpQBm   QQpQQ  8QWQM|  MMQQm\n                8m@MmQ  M+jmW_ _QjBpQ  QQ|pjQjppmQpMQQ   QpjpB  BQQQm|  MmQQw\n                vBQQBB  8QQQM_  MQQQW  8QpQQCvQjQQQBBM   QpQMB  qmQQqC  BQQQQ\n                 -QQm    mMQc   _wWp    mpQ-  8jp vQQ    -QQm    -pQ     Qmp\n                  Q8p    jQQ     Q8Q    jcc   _|% _%mj    m8p    _QQ     BMQ\n                  Qj%    8Wj     Q|%    QB|    _   jQQ    _jQ     _mQ    |#p\n                 jpQ     M8p     @p|   QQQ     U   _MQM   QQQ     QmQ    %Bq_\n                 8mQ    _mpQ    j8Q_   mpp     Q    QQQ   8BQ     BQB    _QQC\n                 8Qp     QQQ    _QQ_   QQp     p    QQQ   dQQ     BQQ    jQQ_\n                 _MQ|    QWM     QQQ   Qm|     p    QQp   BQp     Mmp    8QB\n                  8QQ    vpQ     8jQ   vpQ     _    pp_   QQ!    jQp     mmc\n                  _8Qj    WQQ     pp|   mp     _   jmU   @Qp     mBm    @QU\n                   ~|@j    UQQ    _QQ   vQQ    |   BM_  jp%    jBQ_    @pp\n                     UpQ|   %MQj   _pQj  jpj  j|  Qp|  jQj    QQj_  jjQm_\n                      _mpjjjjBQmQ$jBQppQQbLQUBpWmQppMQMpWQQ$QQp#BWQpQp_\n                         _vpwppmWpmmc  _W%  _c_%v_  vm-  vQmjmmmQvw-\n                            jQ|  -mQQQj               j$pMQpmmmmp\n                             v       vWQ@j          /UQp-       _\n                                        WQjj      jLQm\n                                         _QpQ    BQp\n                                           QQb  QQp\n                                            QQjQmW\n                                            8ppQpm\n                                           jpMp#WQ|\n                                           _UQWmpp\n                                            #QjQp\n                                            _jQj_\n                                            jppm\n                                            CQ--p|\n                                           jpQjjmQ\n                                           pQQLpMQ\n                                          jUpMBpQQj\n                                         jpQQQQQp8p|\n                                        jp|QQ_%%jQQpj|\n                                      jp%_jppUjjQQQj%Uj\n                                     pQQjjQQQjppppQQjjQQ|\n                                   jpQ8QmQQpbL@$pUQQMppQQj\n                                  jQpppQWp8jQ<L_@QQQ#mpQQWQ\n                                jppQmQpbQ8Bmmw>8mCWQQMCpMQ8pj\n                                8ppCmBMM@BQQUMp8jpQUWQQMQmpQU|\n                                U||__mMppmmjbLBL#UWMjQpQmpjUU_\n                                 %jjWQQQjjpp|||UQjj|jjjQjjQp_\n                                   _%%%-wmU]_]__vmwU8pc_pv_\n                                        ____________");
	}
}