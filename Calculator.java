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
		String str=myScanner.next();
		calc(str);
	}
	
	private static void calc(String instruction)
	{
		String command="";
		String rest="";
		for (int i=0; i<instruction.length(); i++)
		{
			if (instruction.charAt(i)!=' ')
			{
				command+=instruction.charAt(i);
			}
			else
			{
				rest=instruction.substring(i+1);
				break;
			}
		}
		
		Set mySet1=new Set();
		StringTokenizer stk=new StringTokenizer(rest, ", ");
		while (stk.hasMoreTokens())
		{
			if (stk.nextToken().charAt(0)=='{')
			{
				Stack myStack=new Stack();
				
				
			}
			else
			{
			
			}
		}
		
		
		switch (command)
		{
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
				System.out.println(
						"                                            8j_j%jQ                                            \n               _|jjWQQ vQjj<@p Ujjj@Q _Qj<%jpmpQQBpU|Qp _QU%j@p QQ<jQQ -QMjjp_                 \n                jQUQmp  pBjQM  _QQjQp  8pC@MUjUjpjpQBm   QQpQQ  8QWQM|  MMQQm                  \n                8m@MmQ  M+jmW_ _QjBpQ  QQ|pjQjppmQpMQQ   QpjpB  BQQQm|  MmQQw                  \n                vBQQBB  8QQQM_  MQQQW  8QpQQCvQjQQQBBM   QpQMB  qmQQqC  BQQQQ                  \n                 -QQm    mMQc   _wWp    mpQ-  8jp vQQ    -QQm    -pQ     Qmp                   \n                  Q8p    jQQ     Q8Q    jcc   _|% _%mj    m8p    _QQ     BMQ                   \n                  Qj%    8Wj     Q|%    QB|    _   jQQ    _jQ     _mQ    |#p                   \n                 jpQ     M8p     @p|   QQQ     U   _MQM   QQQ     QmQ    %Bq_                  \n                 8mQ    _mpQ    j8Q_   mpp     Q    QQQ   8BQ     BQB    _QQC                  \n                 8Qp     QQQ    _QQ_   QQp     p    QQQ   dQQ     BQQ    jQQ_                  \n                 _MQ|    QWM     QQQ   Qm|     p    QQp   BQp     Mmp    8QB                   \n                  8QQ    vpQ     8jQ   vpQ     _    pp_   QQ!    jQp     mmc                   \n                  _8Qj    WQQ     pp|   mp     _   jmU   @Qp     mBm    @QU                    \n                   ~|@j    UQQ    _QQ   vQQ    |   BM_  jp%    jBQ_    @pp                     \n                     UpQ|   %MQj   _pQj  jpj  j|  Qp|  jQj    QQj_  jjQm_                      \n                      _mpjjjjBQmQ$jBQppQQbLQUBpWmQppMQMpWQQ$QQp#BWQpQp_                        \n                         _vpwppmWpmmc  _W%  _c_%v_  vm-  vQmjmmmQvw-                           \n                            jQ|  -mQQQj               j$pMQpmmmmp                              \n                             v       vWQ@j          /UQp-       _                              \n                                        WQjj      jLQm                                         \n                                         _QpQ    BQp                                           \n                                           QQb  QQp                                            \n                                            QQjQmW                                             \n                                            8ppQpm                                             \n                                           jpMp#WQ|                                            \n                                           _UQWmpp                                             \n                                            #QjQp                                              \n                                            _jQj_                                              \n                                            jppm                                               \n                                            CQ--p|                                             \n                                           jpQjjmQ                                             \n                                           pQQLpMQ                                             \n                                          jUpMBpQQj                                            \n                                         jpQQQQQp8p|                                           \n                                        jp|QQ_%%jQQpj|                                         \n                                      jp%_jppUjjQQQj%Uj                                        \n                                     pQQjjQQQjppppQQjjQQ|                                      \n                                   jpQ8QmQQpbL@$pUQQMppQQj                                     \n                                  jQpppQWp8jQ<L_@QQQ#mpQQWQ                                    \n                                jppQmQpbQ8Bmmw>8mCWQQMCpMQ8pj                                  \n                                8ppCmBMM@BQQUMp8jpQUWQQMQmpQU|                                 \n                                U||__mMppmmjbLBL#UWMjQpQmpjUU_                                 \n                                 %jjWQQQjjpp|||UQjj|jjjQjjQp_                                  \n                                   _%%%-wmU]_]__vmwU8pc_pv_                                    \n                                        ____________");
				break;
			case "exit":
				System.exit(1);
				break;
			default:
				System.out.println("Error: invalid command");
			
			
		}
	}
	
}