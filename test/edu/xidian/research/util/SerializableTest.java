package edu.xidian.research.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import junit.framework.TestCase;

public class SerializableTest extends TestCase{
	
	public void testserial() throws ClassNotFoundException
	{
		String[] a = new String[]{"a","b","c"};
		 ByteArrayOutputStream out = new ByteArrayOutputStream();

	        try {
				ObjectOutputStream sOut = new ObjectOutputStream(out);
			     sOut.writeObject(a);
			     sOut.flush();
			     byte[] bytes = out.toByteArray();
			     ByteArrayInputStream in = new ByteArrayInputStream(bytes);

			     ObjectInputStream sIn = new ObjectInputStream(in);
			     System.out.println(a.toString());
			     String[] b =(String[]) sIn.readObject();
			     System.out.println(b[1]);
	        
	        } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	      
	  
	        
	        
	}

}
