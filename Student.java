

import java.io.*;
class Student extends Administrator
{
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    
    public int LoginStudent()throws IOException
      {
        System.out.print("Enter your name : ");
        String name=br.readLine();
        System.out.println();
        System.out.print("Enter your registration number : ");
        int reg=Integer.parseInt(br.readLine());
        System.out.println();
        System.out.print("Enter the password ");
        int pass=Integer.parseInt(br.readLine());
        System.out.println();
        int flag=0;
       
        for(int i=0;i<Administrator.student;i++)
        {
            if(name.equalsIgnoreCase("EXIT"))
            return 2;
            if(name.equalsIgnoreCase(Sname[i]))
            {
                flag=1;
                if(reg==Sreg[i]&& pass==Spass[i])
               {
                   if(voteCountStudent[i]==1)
                   System.out.println("This Student has already completed the Voting process");
                   
                   if(voteCountStudent[i]!=1)
                   {
                     voteCandidate();
                     voteCountStudent[i]=1;
                   }    
               }
            }
            else
            continue;
        }
        if(flag==0)
        {
            System.out.println("The Student does not exist in the database");
            return 1;
        }
        return 0;
      }

    public void voteCandidate() throws IOException
    {
        int valid[]=new int[candidate];
        System.out.print('\f');
        System.out.println("Student Voting Portal");
        for(int i =0;i<Administrator.candidate;i++)
        {
            int check[]=new int[100];
            int c=0;
            System.out.print('\f');
            if(valid[i]==0)
            {
                 System.out.println("Voting for the post of : "+ Cpost[i]);
                String p1=Cpost[i];
                for(int j=0;j<Administrator.candidate;j++)
                {
                    String p2=Cpost[j];
                    if(p2.equalsIgnoreCase(p1))
                    {
                        valid[j]=1;
                        System.out.println("Press "+ j + " to vote for candidate " + Cname[j]);
                        check[c]=j;
                        c++;       
                    }
                    else continue;
                }
                boolean d=true;
                while(d==true)
                {
                  
                    int v=Integer.parseInt(br.readLine());
                    int flag=0;
                    for(int z=0;z<c;z++)
                    {
                        if(v==check[z])
                       {
                           vote[v]++;
                           flag=1;
                           
                           d=false;
                           break;
                        }
                    }
                    if(flag==0)
                    System.out.println("Invalid Vote");
                    System.out.println("Please Vote again");
                }
            }
            else
            continue;
        }
    }

    public void StartPoll() throws IOException
    {
        System.out.println("Student Voting Portal");
        for(int i=0;i<Administrator.student;i++)
        {
            int c=LoginStudent();
            if(c==1)
            i--; 
            else
            if(c==2)
            return;
        }
    }
    public void Studentmain() throws IOException
    {
        Administrator obj=new Administrator();
        obj.Adminmain();
        System.out.println('\f');
        StartPoll();
    }
}