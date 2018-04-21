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

public class Reservation {

public void registerBook(Book m) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		String path=this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
        String test = path.substring(0,path.indexOf(".metadata")).concat("/miniprojet/dataBaseBook.txt");
        ArrayList<Book> list = readBook();
        
        if(list==null) {
        	list = new ArrayList<Book>();
        }
        list.add(m);
         FileOutputStream fichier = new FileOutputStream(test);
         ObjectOutputStream oos =  new ObjectOutputStream(fichier) ;
         oos.writeObject(list) ;
				
	}
	
	
	
	
	public ArrayList<Book> readBook() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		 String path=this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
	        String test = path.substring(0,path.indexOf(".metadata")).concat("/miniprojet/dataBaseBook.txt");
	        FileInputStream fichier = new FileInputStream(test);
	        
	        ArrayList<Book> m = null;
	        if(fichier.available()>10) {
	        	ObjectInputStream ois =  new ObjectInputStream(fichier) ;
		        m = (ArrayList<Book>)ois.readObject() ;
	        	
	        }
	        
	        return m;
	}
	
	
	
	public boolean verifyBook(Book b) throws IOException, ClassNotFoundException {
		
		 ArrayList<Book> listeBook = readBook();
		
		for(Book p:listeBook) {
			if(p.getName().equals(b.getName())) {
					return true;
				}
		}
		
		return false;
	}
	
	public boolean verifyReserv(Book b) throws IOException, ClassNotFoundException {
		
		 ArrayList<Book> listeBook = readBook();
		
		for(Book p:listeBook) {
			if(p.getName().equals(b.getName())) {
					if(!p.isReserv()) {
				
				return false;
				}
		} }
		
		return true;
	}
	
	public void Reserver(Book b) throws IOException, ClassNotFoundException {
		
		 ArrayList<Book> listeBook = readBook();
			
			for(Book p:listeBook) {
				if(p.getName().equals(b.getName())) {
						p.setReserv(true);
			} }
			
			String path=this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
	        String test = path.substring(0,path.indexOf(".metadata")).concat("/miniprojet/dataBaseBook.txt");
			FileOutputStream fichier = new FileOutputStream(test);
	        ObjectOutputStream oos =  new ObjectOutputStream(fichier) ;
	        oos.writeObject(listeBook) ;
	}
	
}
