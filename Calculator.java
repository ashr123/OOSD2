import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Calculator
{
	public static void main(String[] args)
	{
		System.out.println("Sets Calculator");
		System.out.println("==========================");
		Scanner myScanner=new Scanner(System.in);
		//noinspection InfiniteLoopStatement
		while (true)
			calc(myScanner.nextLine());
	}
	
	private static void calc(String instruction)
	{
		
		StringTokenizer stk=new StringTokenizer(instruction, " ");
		String command=stk.nextToken();
		String rest=stk.nextToken();
		
		Set mySet=new Set();
		StringTokenizer toSets;
		if (!command.contentEquals("help") && !command.contentEquals("exit") && !command.contentEquals("bonus"))
		{
			toSets=new StringTokenizer(rest, " ");
			mySet=setParser(toSets.nextToken());
		}
		
		
		switch (command)
		{
			case "size"://Works
				System.out.println(mySet+"\n"+mySet.size());
				break;
			case "contains"://Woks
				System.out.println(mySet.contains(setParser(stk.nextToken())));
				break;
			case "member"://Works
				System.out.println(mySet.member(nextElementOrSet(stk.nextToken())));
				break;
			case "deepExistence":
				mySet.deepExistence(nextElementOrSet(stk.nextToken()));
				break;
			case "equals":
				System.out.println(mySet.equals(nextElementOrSet(stk.nextToken())));
				break;
			case "insert"://Works
				System.out.println(mySet.insert(nextElementOrSet(stk.nextToken())));
				break;
			case "remove"://Works
				System.out.println(mySet.remove(nextElementOrSet(stk.nextToken())));
				break;
			case "union"://works
				System.out.println(mySet.union(setParser(stk.nextToken())));
				break;
			case "intersect"://works
				System.out.println(mySet.intersect(setParser(stk.nextToken())));
				break;
			case "difference":
				System.out.println(mySet.difference(setParser(stk.nextToken())));
				break;
			case "power":
				System.out.println(mySet.power());
				break;
			case "transformAdd":
				System.out.println(mySet.transformAdd((Numeric)elementParser(stk.nextToken())));
				break;
			case "transformMul":
				System.out.println(mySet.transformMul((Numeric)elementParser(stk.nextToken())));
				break;
			case "help":
				printHelp();
				break;
			case "bonus":
				getBonus();
				break;
			case "exit":
				System.exit(1);
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
		System.out.println("size <set>\n"+
		                   "contains <set> <set>\n"+
		                   "member <set> <element>\n"+
		                   "deepExistence <set> <element>\n"+
		                   "equals <element> <element>\n"+
		                   "insert <set> <element>\n"+
		                   "remove <set> <element>\n"+
		                   "union <set> <set>\n"+
		                   "intersect <set> <set>\n"+
		                   "difference <set> <set>\n"+
		                   "power <set>\n"+
		                   "transformAdd <element> <numeric>\n"+
		                   "transformMul <element> <numeric>\n"+
		                   "help\n"+
		                   "bonus\n"+
		                   "exit\n");
	}
	
	private static Element elementParser(String s)
	{
		StringTokenizer stk=new StringTokenizer(s);
		String nextToken=stk.nextToken();
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
	
	private static Set setParser(String rest)
	{
		Stack<Set> myStack=new Stack<>();
		//myStack.push(new Set());
		StringTokenizer stk=new StringTokenizer(rest, ", ");
		while (stk.hasMoreTokens())
		{
			String nextToken=stk.nextToken();
			while (nextToken.charAt(0)=='{')
			{
				nextToken=nextToken.substring(1); //Removes the "{"
				myStack.push(new Set());
			}
			int isFinished=0;
			while (nextToken.length()!=0 && nextToken.charAt(nextToken.length()-1)=='}')
			{
				nextToken=nextToken.substring(0, nextToken.length()-1); //Removes the "}"
				isFinished++;
			}
			if (nextToken.length()!=0)
				if (nextToken.contains("/")) // It's a Rational Number.
				{
					StringTokenizer divideStringTokenizer=new StringTokenizer(nextToken, "/");
					int intA=Integer.parseInt(divideStringTokenizer.nextToken());
					int intB=Integer.parseInt(divideStringTokenizer.nextToken());
					myStack.peek().insert(new RationalNumeric(intA, intB));
				}
				else   // It's a Real number.
				{
					myStack.peek().insert(new RealNumeric(Double.parseDouble(nextToken)));
				}
			
			while (myStack.size()>1 && isFinished>0)
			{
				Set temp=myStack.pop();
				myStack.peek().insert(temp);
				isFinished--;
			}
		}
		return myStack.pop();
	}
	
	
	private static void getBonus()
	{
		System.out.println(
				"                                            8j_j%jQ                                            \n               _|jjWQQ vQjj<@p Ujjj@Q _Qj<%jpmpQQBpU|Qp _QU%j@p QQ<jQQ -QMjjp_                 \n                jQUQmp  pBjQM  _QQjQp  8pC@MUjUjpjpQBm   QQpQQ  8QWQM|  MMQQm                  \n                8m@MmQ  M+jmW_ _QjBpQ  QQ|pjQjppmQpMQQ   QpjpB  BQQQm|  MmQQw                  \n                vBQQBB  8QQQM_  MQQQW  8QpQQCvQjQQQBBM   QpQMB  qmQQqC  BQQQQ                  \n                 -QQm    mMQc   _wWp    mpQ-  8jp vQQ    -QQm    -pQ     Qmp                   \n                  Q8p    jQQ     Q8Q    jcc   _|% _%mj    m8p    _QQ     BMQ                   \n                  Qj%    8Wj     Q|%    QB|    _   jQQ    _jQ     _mQ    |#p                   \n                 jpQ     M8p     @p|   QQQ     U   _MQM   QQQ     QmQ    %Bq_                  \n                 8mQ    _mpQ    j8Q_   mpp     Q    QQQ   8BQ     BQB    _QQC                  \n                 8Qp     QQQ    _QQ_   QQp     p    QQQ   dQQ     BQQ    jQQ_                  \n                 _MQ|    QWM     QQQ   Qm|     p    QQp   BQp     Mmp    8QB                   \n                  8QQ    vpQ     8jQ   vpQ     _    pp_   QQ!    jQp     mmc                   \n                  _8Qj    WQQ     pp|   mp     _   jmU   @Qp     mBm    @QU                    \n                   ~|@j    UQQ    _QQ   vQQ    |   BM_  jp%    jBQ_    @pp                     \n                     UpQ|   %MQj   _pQj  jpj  j|  Qp|  jQj    QQj_  jjQm_                      \n                      _mpjjjjBQmQ$jBQppQQbLQUBpWmQppMQMpWQQ$QQp#BWQpQp_                        \n                         _vpwppmWpmmc  _W%  _c_%v_  vm-  vQmjmmmQvw-                           \n                            jQ|  -mQQQj               j$pMQpmmmmp                              \n                             v       vWQ@j          /UQp-       _                              \n                                        WQjj      jLQm                                         \n                                         _QpQ    BQp                                           \n                                           QQb  QQp                                            \n                                            QQjQmW                                             \n                                            8ppQpm                                             \n                                           jpMp#WQ|                                            \n                                           _UQWmpp                                             \n                                            #QjQp                                              \n                                            _jQj_                                              \n                                            jppm                                               \n                                            CQ--p|                                             \n                                           jpQjjmQ                                             \n                                           pQQLpMQ                                             \n                                          jUpMBpQQj                                            \n                                         jpQQQQQp8p|                                           \n                                        jp|QQ_%%jQQpj|                                         \n                                      jp%_jppUjjQQQj%Uj                                        \n                                     pQQjjQQQjppppQQjjQQ|                                      \n                                   jpQ8QmQQpbL@$pUQQMppQQj                                     \n                                  jQpppQWp8jQ<L_@QQQ#mpQQWQ                                    \n                                jppQmQpbQ8Bmmw>8mCWQQMCpMQ8pj                                  \n                                8ppCmBMM@BQQUMp8jpQUWQQMQmpQU|                                 \n                                U||__mMppmmjbLBL#UWMjQpQmpjUU_                                 \n                                 %jjWQQQjjpp|||UQjj|jjjQjjQp_                                  \n                                   _%%%-wmU]_]__vmwU8pc_pv_                                    \n                                        ____________");
	}
	
}