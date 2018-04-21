package miniprojet.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystems;
import java.util.ArrayList;

public class Authentication {

	public void register(Person m) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		String path=this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
        String test = path.substring(0,path.indexOf(".metadata")).concat("/miniprojet/dataBase.txt");
        ArrayList<Person> list = read();
        System.out.println(test);
        
        if(list==null) {
        	list = new ArrayList<Person>();
        }
        list.add(m);
         FileOutputStream fichier = new FileOutputStream(test);
         ObjectOutputStream oos =  new ObjectOutputStream(fichier) ;
         oos.writeObject(list) ;
				
	}
	
	
	
	
	public ArrayList<Person> read() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		 String path=this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
	        String test = path.substring(0,path.indexOf(".metadata")).concat("/miniprojet/dataBase.txt");
	        FileInputStream fichier = new FileInputStream(test);
	        
	        ArrayList<Person> m = null;
	        if(fichier.available()>10) {
	        	ObjectInputStream ois =  new ObjectInputStream(fichier) ;
		        m = (ArrayList<Person>)ois.readObject() ;
	        	
	        }
	        
	        return m;
	}
	
	public boolean verify(Person user) throws IOException, ClassNotFoundException {
		
		 ArrayList<Person> listePerson = read();
		for(Person p:listePerson) {
			if(p.getName().equals(user.getName())) {
				if(p.getPass().equals(user.getPass())) {
					return true;
				}
			}
		}
		
		return false;
	}
	
}
