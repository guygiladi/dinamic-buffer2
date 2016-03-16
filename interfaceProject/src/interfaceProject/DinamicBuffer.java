package interfaceProject;

public final class DinamicBuffer implements BufferInterface {

	private static DinamicBuffer instance= null;
	private Comparable[] buffer;
	private int capacity;
	private int currentSize;
	
	//default ctor- singleton pattern
	private DinamicBuffer ()
	{
			setCapacity(1);
			buffer=new Comparable[this.getCapacity()];
	}
	
	//get reference to instance var
	public static DinamicBuffer getInstance()
	{
		if(instance==null)
			instance=new DinamicBuffer();
		
		return instance;
	}
	
	//set the capacity
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	//the function get new Comparable obj and add it to the array
	public boolean add(Comparable obj) {
		
		//if the currentSize if equal to the capacity, the capacity will be double
		if(this.getCurrentSize()==capacity)
		{
			this.setCapacity(capacity*2);
			copyElements(this.getCapacity());
			
		}
		
		buffer[currentSize]=obj;
		currentSize++;
		
		return true;
	}

	//get an Comparable obj,serch it and remove it from the array
	public boolean remove(Comparable obj) {
		
		if(getCurrentSize()<=capacity/4)
		{
			setCapacity(capacity/4);	
			copyElements(getCapacity());
		}
		//check for the Comparable object and remove it from the array.
		//shrink the array by one
		for(int i=0;i<currentSize;i++)
			if(buffer[i].equals(obj))
			{
				buffer[i]=buffer[getCurrentSize()-1];
				buffer[getCurrentSize()]=null;
				currentSize--;
				return true;
			}
		
		return false;
	}

	//get index of the array and return the Comparable obj in that index from the array
	//the function don't deal with situation that the index is out of bound
	public Comparable getObject(int index) {
		
		return this.buffer[index];
	}

	//return the capacity of the array
	public int getCapacity() {
		
		return this.capacity;
	}

	//return the current index of the array
	public int getCurrentSize() {
		return currentSize;
	}
	
	//return the buffer obj
	public Comparable[] getBuffer() {
		return buffer;
	}


	//the function do bubble sort to the array by the average value in ascending order
	public void sort() {
		Comparable tmp;
		
		for(int i=0;i<this.currentSize;i++)
		{
			for(int j=0;j<this.currentSize-1;j++)
			{
				if(this.buffer[j].compareTo(this.buffer[j+1])==1)
					{
						tmp=this.buffer[j];
						this.buffer[j]=this.buffer[j+1];
						this.buffer[j+1]=tmp;
					}
			}
		}
	}
	
	//hash code method
	public int hashCode()
    {
        int hash = 7;
        hash = 31 * hash + capacity;
        hash = 31 * hash + (null == buffer ? 0 : buffer.hashCode());
        return hash;
    }
	
	
	//equals method
	  public boolean equals(Object object)
	{

	    if (object == null || object.getClass() != getClass()) {
	      return false;
	    } 
	    else {
	    	DinamicBuffer newBuffer = (DinamicBuffer) object;
	      if (this.capacity != newBuffer.capacity)
	    	  return false;
	      
	      for(int i=0;i<this.capacity;i++)
	    	  if((this.buffer[i].compareTo(newBuffer.buffer[i]))!=0)
	    		  return false;
	      
	      return true;
	    		  
		     
	    }

	  }
	  
	  private void copyElements(int newCapacity)
	  {
		  Comparable[] newBuffer = new Comparable[newCapacity];
		  
		  for(int i=0;i<newCapacity/2;i++)
			  newBuffer[i]=buffer[i];
		  
		  this.buffer=newBuffer; 
	  }
	  
	  
	  //the method get Comparable obj and return his index in the array, if not found return -1
	  public int getObject(Comparable  obj)
	  {
		  for(int i=0;i<currentSize;i++)
				if(buffer[i].equals(obj))
					return i;
		  
		  return -1;
	  }
	  

}
