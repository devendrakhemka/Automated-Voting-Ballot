
  

import java.io.*;
class Faculty extends Student
{
    Administrator obj=new Administrator();
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       public int LoginFaculty()throws IOException
      {
        System.out.print("Enter your name : ");
        String name=br.readLine();
        System.out.println();
        System.out.print("Enter your SSN (integer) : ");
        int reg=Integer.parseInt(br.readLine()); 
        System.out.println();
        System.out.println();
        int flag=0;
        try
        {
            
                
            for(int i=0;i<Administrator.candidate;i++)
            {
                if(name.equalsIgnoreCase("EXIT"))
                return 2;
                
                if(name.equalsIgnoreCase(Fname[i]))
                {
                    flag=1;
                    if(reg==Freg[i])
                   {
                       if(voteCountFaculty[i]==1)
                       System.out.println("This Faculty has already completed the Voting process");
                       else
                       if(voteCountFaculty[i]==0)
                       {
                         fvoteCandidate();
                         voteCountFaculty[i]=1;
                       }    
                   }
                }
                
                else
                continue;
            }
            if(flag==0)
            {
                System.out.println("The Faculty does not exist in the database");
                return 1;
            }
        }
        catch(Exception e)
        {
            System.out.println("No more Faculty members are present in the database");
        }
        return 0;
      }

    public void fvoteCandidate() throws IOException
    {
        int valid[]=new int[candidate];
        System.out.print('\f');
        System.out.println('\t'+"Faculty Voting Portal");
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
                           vote[v]+=2;
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
        System.out.println("Faculty Voting Portal");
        for(int i=0;i<Administrator.faculty;i++)
        {
            int c=LoginFaculty();
            if(c==1)
            i--; 
            else
            if(c==2)
            return;
        }
    }
}
