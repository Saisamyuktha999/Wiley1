package wiley.daythree;
import java.util.Scanner;
import java.util.*;
public class EmployeeProject {
   String name;
   int age;
   String dsg;
   int space=0;
   static int count=0;
   char ch;
   int loop1=0;
   float salary1;
   float sal1;
   String employeeid=null;
   static int id1=0;
   Scanner sc = new Scanner(System.in);
   int j=0;
   EmployeeProject()
   {
	   create();
   }
   void create()
   {
	   while(true)
	   {
		   System.out.println("enter your name");
		   name = sc.nextLine();
		   space=0;
		   for(int i=0;i<name.length();i++)
		   {
			   ch = name.charAt(i);
			   if(ch==' ')
			   {
				   space++;
			   }
     
		   }
		   if(space>2)
		   {
			   System.out.println("invalid name");
		   }
		   else
		   {
			   break;
		   }
	   }
	   if(space<=2)
	   {
		   while(true)
		   {
			   System.out.println("enter your age");
      //sc.next();
			   String s2 = sc.nextLine();
			   if(s2.charAt(0)>=48 && s2.charAt(0)<=57 && s2.charAt(1)>=48 && s2.charAt(1)<=57 && s2.length()==2)
			   {
				   age = Integer.parseInt(s2);
				   if(age>=18 && age<=60)
				   {
					   break;
				   }
				   else
				   {
					   System.out.println("enter your age within 18 and 60");
					   continue;
				   }
			   }
			   else
			   {
				   System.out.println("invalid age format");
				   continue;
			   }
		   }
		   while(true)
		   {
			   System.out.println("enter ur designation");
			   dsg = sc.nextLine();
      
			   if(dsg.equalsIgnoreCase("programmer") || dsg.equalsIgnoreCase("tester")||dsg.equalsIgnoreCase("manager"))
			   {
				   dsg = dsg;
				   if(dsg.equalsIgnoreCase("programmer"))
				   {
					   salary1 = 30000f;
				   }
				   else if(dsg.equalsIgnoreCase("manager"))
				   {
					   salary1=35000f;
				   }
				   else
				   {
					   salary1=25000f;
				   }
				   break;
			   }
			   else
			   {
				   System.out.println("invalid designation.enter within the programmer,tester,manager");
				   continue;
			   }
    	   }
	   }
	   employeeid = "Wil"+id1 ;
	   id1++;
     }
   
   void display()
   {
	   System.out.println("Name:"+this.name+"\n"+"Age:"+this.age+"\n"+"Designation:"+this.dsg+"\nSalary:"+this.salary1+"\nemployee id: "+employeeid);
	   
   }
   
   void salary()
   {
	   System.out.println("Enter percentage to raise:");
	   int percent=sc.nextInt();
	   float temp = (float)percent/100;
       salary1 = salary1+(temp*salary1);
	   System.out.println("salary updated");
   }
   public static void main(String args[])
   {
	   try
	   {
		   String empid;
		   String n1;
		   boolean flag=false;
		   ArrayList<EmployeeProject>ed = new ArrayList<EmployeeProject>();
		   while(true)
		   {
			   System.out.println("1.create  2.display  3.salary  4.delete  5.exit");
			   Scanner sc = new Scanner(System.in);
			   String inp = sc.nextLine();
			   if(inp.length()==1 && inp.charAt(0)>=48 && inp.charAt(0)<=57)
			   {
				   int a = Integer.parseInt(inp);
				   String str[];
				   int id;
				   String e1 = null;
				   int i=0;
				   switch(a)
				   {
				   case 1 :
					   for(int count2=0;count2<10;count2++)
					   {
						   if(count2>10)
						   {
							   System.out.println("entries not possible");
							   break;
						   }
						   else
						   {
							   ed.add(new EmployeeProject());
							   System.out.println("enter yes or no to continue");
							   e1 = sc.next();
							   if(e1.equalsIgnoreCase("no"))
							   {
								   break;
							   }
							   else
							   {
								   continue;	
							   }
       
						   }
					   }
					   break;
    
      
				 case 2:if(ed.size()==0)
				 {
					 System.out.println("create records first");
					 break;
				 }
				 else
				 {
					 for(int j=0;j<ed.size();j++)
					 {
						 ed.get(j).display();
					 }
				 }
				 break;
				 case 3 :
					 if(ed.size()==0)
					 {
						 System.out.println("create records");
					 }
					 else
					 {
						 
						 while(true)
						 {
      
							 System.out.println("enter the employee id");
							 empid = sc.nextLine();      
							 str=empid.split("wil");
							 id=Integer.parseInt(str[1]);
							 ed.get(id).salary();
							 break;
						 }
					 }
					 break;
				 case 4 : 
					 
					 System.out.println("Enter employee id:");
					 sc.nextLine();
					 empid=sc.nextLine();
					 str=empid.split("wil");
					 id=Integer.parseInt(str[1]);
					 ed.remove(id);
					 System.out.println("Employee deleted");
					 break;
				 case 5: System.exit(1);
				   }
				   
				    
			   }
			   else
			   {
				   System.out.println("invalid input ");
				   continue;
			   }
		   }
	   }catch(Exception ae)
	   {
		   ae.printStackTrace();
     
	   }
   
   }
}
