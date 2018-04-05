
import java.io.*;
class AutomatedVotingBallot
{
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    Administrator aobj= new Administrator();
    Student sobj=new Student();
    Faculty fobj=new Faculty();
    public void main() throws IOException
    {
        System.out.println("Would you like to start the voting Process? yes/no");
        String choice=br.readLine();
        if(choice.equalsIgnoreCase("yes"))
        {
            System.out.print('\f');
            System.out.println("Please note, only the ADMINISTRATOR can update the database");
            System.out.println();
            System.out.println();
            System.out.println("Please enter the ADMINISTRATOR PASSWORD to continue");
            String password=br.readLine();
            if(password.equals("AVBadmin"))
            {
                System.out.print('\f');
                System.out.println("Please update all the database before the polling starts");
                System.out.println('\n'+'\n');
                aobj.Adminmain();
                System.out.println('\f');
                System.out.println("You have successfully updated the database");
                System.out.println("To begin the polling press 'Y'");
                boolean x=true;
                while(x==true)
                 {
                     String poll=br.readLine();
                     if(poll.equalsIgnoreCase("y"))
                    {
                        System.out.print('\f');
                        x=false;
                        System.out.println("Who shall start the voting, student/faculty ?");
                        System.out.println();
                        System.out.println("PS: faculty will commence voting immediately after the students finish voting(in case Students are selected) else vice 			    versa");
                        String op= br.readLine();
                        System.out.print('\f');
                        if(op.equalsIgnoreCase("Student"))
                        {
                            sobj.StartPoll();
                            System.out.print('\f');
                            fobj.StartPoll();
                        }
                        else
                        {
                            fobj.StartPoll();
                            System.out.print('\f');
                            sobj.StartPoll();
                        }
                    }
                    else
                    System.out.println("Waiting for you to press 'Y'");
                }
                
                System.out.print('\f');
                System.out.println("Now the Voting Process has Concluded !");
                System.out.println("View Voting Results?");
                String option=br.readLine();
                System.out.print('\f');
                if(option.equalsIgnoreCase("yes"))
                {
                    aobj.ViewResults();
                }
                else
                {
                    System.out.println("The Results are stored in the file");
                System.exit(0);
            }
                
             }
            
             else
             { 
                 System.out.println("You are not authorized to do the above task");
                 System.exit(0);
                }
            }
            else
            {
            System.out.print('\f');
            System.out.println("Ok, see you some other time");
        }
            
}
}


          