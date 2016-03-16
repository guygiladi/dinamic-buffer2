package interfaceProject;

public class DinamicBufferTester {

	public static void main(String[] args) {
		
		DinamicBuffer newBuffer =DinamicBuffer.getInstance();
		DinamicBuffer newBuffer2 =DinamicBuffer.getInstance();
		Comparable newStudent=new Student("guy");
		Comparable newStudent2=new Student("gal");
		Comparable newStudent3=new Student("maor");
		Comparable newStudent4=new Student("liran");
		Comparable newStudent5=new Student("karin");
		Comparable newStudent6=new Student("lior");
		Comparable newStudent7=new Student("boaz");
		Comparable newStudent8=new Student("yosi");
		Comparable newStudent9=new Student("dani");
		Comparable newStudent10=new Student("dor");
		Comparable newStudent11=new Student("dor");
		
		
		newBuffer.add(newStudent);
		newBuffer.add(newStudent2);
		newBuffer.add(newStudent3);
		newBuffer.add(newStudent4);
		newBuffer.add(newStudent5);
		newBuffer.add(newStudent6);
		newBuffer.add(newStudent7);
		System.out.println("Capacity:"+newBuffer.getCapacity());
		System.out.println("Current size:"+newBuffer.getCurrentSize());
		System.out.println();
		newBuffer.add(newStudent8);
		System.out.println("Capacity:"+newBuffer.getCapacity());
		System.out.println("Current size:"+newBuffer.getCurrentSize());
		System.out.println();
		newBuffer.add(newStudent9);
		System.out.println("Capacity:"+newBuffer.getCapacity());
		System.out.println("Current size:"+newBuffer.getCurrentSize());
		System.out.println();
		newBuffer.add(newStudent10);
		System.out.println("Capacity:"+newBuffer.getCapacity());
		System.out.println("Current size:"+newBuffer.getCurrentSize());
		System.out.println();
		
		newBuffer.remove(newStudent9);
		System.out.println("Capacity:"+newBuffer.getCapacity());
		System.out.println("Current size:"+newBuffer.getCurrentSize());
		System.out.println();
		
		newBuffer.remove(newStudent10);
		System.out.println("Capacity:"+newBuffer.getCapacity());
		System.out.println("Current size:"+newBuffer.getCurrentSize());
		System.out.println();
		
		newBuffer.remove(newStudent7);
		System.out.println("Capacity:"+newBuffer.getCapacity());
		System.out.println("Current size:"+newBuffer.getCurrentSize());
		System.out.println();
		/*
		for(int i=0;i<newBuffer.getCurrentSize();i++)
		{
			Student tmpStudent= (Student)newBuffer.getBuffer()[i];
			System.out.println(tmpStudent.getAverage());
		}
		
		System.out.println();
		newBuffer.sort();
		
		for(int i=0;i<newBuffer.getCurrentSize();i++)
		{
			Student tmpStudent= (Student)newBuffer.getBuffer()[i];
			System.out.println(tmpStudent.getAverage());
		}
		
		*/
		
		System.out.println(newBuffer.getBuffer()[0].toString());
		
		System.out.println(newBuffer.getObject(newStudent5));
	}

}
