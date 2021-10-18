package Sel;

import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Properitiessnew {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Properties pro = System.getProperties();
		
		Set proper = pro.entrySet();
		Iterator i = proper.iterator();
		
		while (i.hasNext()) {
			
			Map.Entry mp = (Map.Entry)i.next();
			
			System.out.println(mp.getKey()+"="+mp.getValue());
			
			
			
		}
		
		
		
	}

}
