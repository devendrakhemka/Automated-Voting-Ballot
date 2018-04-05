

import java.io.*;
public class Administrator
{
    public static int Sreg[]=new int[200];
    public static String Sname[]=new String [200];
    public static int Spass[]=new int[200];
    public static int Freg[]=new int[200];
    public static String Fname[]=new String [200];
    public static int Fpass[]=new int[200];
    public static String Cname[]=new String[100];
    public static String Cpost[]=new String[100];  //contesting post
    public static int vote[]=new int[100];
    public static int voteCountStudent[]=new int[100];
    public static int voteCountFaculty[]=new int[100];
    public static int student=0;
    public static int faculty=0;
    public static int candidate=0;
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    public  void AddStudents()throws IOException
    {
        try
        {
            
            System.out.print('\f');
            System.out.println("Enter Student Data");
            int ch=1;
            int i=0;
            while(ch==1) //True condition
            {
                student++;
                System.out.println("Enter the name of the Student");
                Sname[i]=br.readLine();
                System.out.println("Enter the Registration number of the student");
                Sreg[i]=Integer.parseInt(br.readLine());
                System.out.println("Enter the password");
                Spass[i]=Integer.parseInt(br.readLine());            
                System.out.println();
                System.out.println("Number of students registered "+student);
                System.out.println("More students ? "); //Press 1 for yes
                ch= Integer.parseInt(br.readLine());
                System.out.println('\f'); //clear screen
                i++;
                
            }   
    }
    catch(Exception e)
    {
        System.out.println('\f');
        System.out.println("Incorrect Data entry");
    }
}
    
        public  void AddFaculty()throws IOException
        {
        System.out.print('\f');
        System.out.println("Enter Faculty Data");
        int ch=1;
        int i=0;
        while(ch==1) //True condition
        {
            
            faculty++;
            System.out.println("Enter the name of the Faculty");
            Fname[i]=br.readLine();
            System.out.println("Enter the registration number of Faculty");
            Freg[i]=Integer.parseInt(br.readLine());
            System.out.println("Enter the password");
            Fpass[i]=Integer.parseInt(br.readLine()); 
            System.out.println();
            System.out.println("Number of faculty registered "+faculty);
            System.out.println("More Faculty ? "); //Press 1 for yes
            ch= Integer.parseInt(br.readLine());
            System.out.println('\f'); //clear screen
            i++;
        }   
    }
    
      public  void AddCandidate()throws IOException
    {
        
        System.out.print('\f');
        System.out.println("Enter Candidate Data");
        int ch=1;
        int i=0;
        while(ch==1) //True condition
        {
            candidate++;
            System.out.println("Enter the name of the Candidate");
            Cname[i]=br.readLine();
            System.out.println("Enter the Post that the candidate will be contesting for");
            Cpost[i]=br.readLine();
            System.out.println();
            System.out.println("Number of candidates registered "+candidate);
            System.out.println("More Candidates ? "); //Press 1 for yes
            ch= Integer.parseInt(br.readLine());
            System.out.println('\f'); //clear screen
            i++;
            
        }   
    }
    
    public void ViewStudent() throws IOException
    {
        System.out.print('\f');
        for(int i=0;i<100;i++)
        {
            if(Sname[i]!=null )
            {
                System.out.println(Sname[i]+ '\t' + Sreg[i] + '\t' + Spass[i]);
            }
            else
            continue;
        }
    }
    
     public void ViewFaculty() throws IOException
    {
        System.out.print('\f');
        for(int i=0;i<100;i++)
        {
            if(Fname[i]!=null )
            {
                System.out.println(Fname[i]+ '\t' + Freg[i] + '\t' + Fpass[i]);
            }
            else
            continue;
        }
    }
    
      public void ViewCandidate() throws IOException
    {
        System.out.print('\f');
        for(int i=0;i<100;i++)
        {
            if(Cname[i]!=null )
            {
                System.out.println(Cname[i]+ '\t' +Cpost[i]);
            }
            else
            continue;
        }
    }
    
    public void ViewResults() throws IOException
    {
        File f1= new File ("G:\\SE project\\results.txt");
        FileOutputStream f = new FileOutputStream(f1);
        System.out.println('\f');
        System.out.println("Results of the polling are as follows");
        
        for(int i=0;i<candidate;i++)
        {
            System.out.println();
            System.out.println();
           
                if(Cpost[i]!=null)
                {
                    String post=Cpost[i];
                    System.out.println("For Post of "+post);
                    for(int j=0;j<candidate;j++)
                    {
                        if(Cpost[j].equalsIgnoreCase(post))
                        {
                            System.out.println(Cname[j] + '\t' + vote[j]);                           
                            String d = Cname[j]+'\t'+Cpost[j]+'\t'+vote[j]+'\t'+'\n';
                            char c[] = d.toCharArray();
                            for(int x = 0; x < c.length; x++)
                            f.write(c[x]);
                            Cname[j]=null;
                            Cpost[j]=null;
                            
                        }
                }
            }
            else
            continue;
        }
    }
        
    
    
    public void StartPolling() throws IOException
    {
        System.out.println("All the databases are now complete");
        System.out.println("Let the VOTING BEGIN");
        System.out.println("Best of luck to all the candidates");
        return;
    }
            
    public void Adminmain() throws IOException
    {
        String decision="yes";
        while(decision.equalsIgnoreCase("yes"))
        {
            System.out.println('\f');
            System.out.println("1.Edit Student Database");
            System.out.println("2.Edit Faculty Database");
            System.out.println("3.Edit Candidate Database");
            System.out.println("4.View Results");
            System.out.println("5.View Student Database");
            System.out.println("6.View Faculty Database");
            System.out.println("7.View Candidate Database");
            System.out.println();
            System.out.print("Enter your choice: ");
            int choice=Integer.parseInt(br.readLine());
            System.out.println('\f');
            boolean pw=true;
            while(pw==true)
            {
                System.out.println("Enter admin password");
                String p= br.readLine();
                    if(p.equals("AVBadmin")== false)
                {
                    System.out.println("Incorrect Password");
                    System.out.println("Please Re-Enter the password");
                    
                }            
                else
                pw=false;
            }
            
            if(choice==1)
            AddStudents();
            else
            if(choice==2)
            AddFaculty();
            else
            if(choice==3)
            AddCandidate();
            else
            if(choice==4)
            ViewResults();
            else
            if(choice==5)
            ViewStudent();
            else
            if(choice==6)
            ViewFaculty();
            else
            if(choice==7)
            ViewCandidate();
            else
            System.out.println("Wrong Option Entered");
            System.out.println();
            System.out.println("Decision to Continue");
            decision= br.readLine();
        }      
    }
}


 