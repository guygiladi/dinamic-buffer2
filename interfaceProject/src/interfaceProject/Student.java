package interfaceProject;

import java.util.Random;

public class Student implements Comparable {
	
	private String name;
	private int[] grades;
	
	//ctor with one parameter- name of the student
	public Student (String name)
	{
		Random rand = new Random();
		setName(name);
		this.grades= new int[rand.nextInt(4)+3];
		
		for(int i=0;i<this.grades.length;i++)
			this.grades[i]=rand.nextInt(60)+40;
	}
	
	//default ctor
	public Student ()
	{
		Random rand = new Random();
		setName("");
		this.grades= new int[rand.nextInt(4)+3];
		
		for(int i=0;i<this.grades.length;i++)
			this.grades[i]=rand.nextInt(60)+40;
	}
	
	//return the name of the student
	public String getName() {
		return name;
	}



	//set the name of the student
	public void setName(String name) {
		this.name = name;
	}



	//return the grades array
	public int[] getGrades() {
		return grades;
	}



	//set the grades array
	public void setGrades(int[] grades) {
		this.grades = grades;
	}

	//the function get two student obj and compare them.
	//return 0 if equals, -1 if this object is lesser and 1 if this object is greater
	@Override
	public int compareTo(Object o) {
		
		Student newStudent = (Student)o;
		
		if(this.getAverage()==newStudent.getAverage())
			return 0;
		else if (this.getAverage()>newStudent.getAverage())
			return 1;
		else
			return -1;

	}
	
	//return the grade's avg
	public double getAverage()
	{
		double sum=0;
		
		for (int i :this.grades)
			sum+=i;
		
		return sum/grades.length;
	}
	
	
	//hash code method
		public int hashCode()
	    {
	        int hash = 7;
	        hash = 31 * hash + (null == name ? 0 : name.hashCode());
	        hash = 31 * hash + (null == grades ? 0 : grades.length);
	        return hash;
	    }
	
	//equals method
	  public boolean equals(Object object)
	{

	    if (object == null || object.getClass() != getClass()) {
	      return false;
	    } 
	    else {
	    	Student newStudent = (Student) object;
	      if (!(this.name.equals(newStudent.name)))
	    	  return false;
	      
	      for(int i=0;i<this.grades.length;i++)
	    	  if((this.grades[i]!=newStudent.grades[i]))
	    		  return false;
	      
	      return true;
	    		  
		     
	    }
	}
	  
	public String toString()
	{
		 String str="";
		
		str+="name:"+this.name;
		
		str+="  grades:";
		
		for(int i=0;i<this.grades.length;i++)
			str+=","+this.grades[i];
		
		return str;
	}
	

}
