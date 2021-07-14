package wiley.miniproject.pck;
import java.util.*;
public class MapList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//List<project1> pl=new ArrayList<>();
//		//List<project1> pl1=new ArrayList<>();
//		//List<project1> pl=new ArrayList<>();
//
//		project1 pj1=new project1("Proj1","1");
//		project1 pj=new project1("Proj2","2");
//		
//		pl.add(pj1);
//		pl.add(pj);
//		
//		List<User2> ul=new ArrayList<>();
//		User2 user1=new User2("AAA","User1",pl);
//		ul.add(user1);
		List<project1> pl=new ArrayList<>();
		List<User2> ul=new ArrayList<>();
		Adding ad=new Adding();
		Thread t1=new Thread(ad);
		t1.start();
		
		pl=ad.proj();
		ul=ad.Use();
		Processes p=new Processes(pl, ul);
		Thread t2=new Thread(p);
		try {
			Thread.sleep(100);
		}
		catch(Exception ee) {
			
		}
		t2.start();
		
	}

}
class User2{
	String name;
	String id;
	List<project1> pj;
	public User2(String name,String id,List<project1> pj){
		this.name=name;
		this.id=id;
		this.pj=pj;
	}
	@Override
	public String toString() {
		return " [name=" + name + ", id=" + id + ", pj=" + pj + "]";
	}
	
	
}
class project1{
	String projname;
	String projid;
	public project1(String projname,String projid) {
		this.projname=projname;
		this.projid=projid;
	}
	@Override
	public String toString() {
		return " [projname=" + projname + ", projid=" + projid + "]";
	}
	
}
class Adding   implements Runnable{
	List<project1> pl=new ArrayList<>();
	List<User2> ul=new ArrayList<>();
	//@Override
	MapList mp=new MapList();
	
	public void run() {
		// TODO Auto-generated method stub
		project1 pj1=new project1("Proj1","1");
		project1 pj=new project1("Proj2","2");
		
		pl.add(pj1);
		pl.add(pj);
		User2 user1=new User2("AAA","User1",pl);
		ul.add(user1);
		
		//ul.forEach(System.out::println);
	}
	public List<project1> proj(){
		return pl;
	}
	public List<User2> Use(){
		return ul;
	}
	
}
class Processes implements Runnable{
//	Adding a=new Adding();
	List<project1> pl=new ArrayList<>();
	List<User2> ul=new ArrayList<>();
	Map<project1,List<String>> mp=new HashMap();
	public Processes(List<project1> pl,List<User2> ul) {
		// TODO Auto-generated constructor stub
		this.pl=pl;
		this.ul=ul;
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(User2 u:ul) {
			for(project1 p: u.pj) {
				if(!mp.containsKey(p)) {
					ArrayList<String> u1=new ArrayList<>();
					u1.add(u.id);
					mp.put(p, u1);
				}
				else {
					mp.get(p).add(u.id);
				}
			
		}
	}
		
	for(Map.Entry<project1, List<String>> u: mp.entrySet()) {
		System.out.println(u.getKey() +"------"+ u.getValue());
	}
}
}