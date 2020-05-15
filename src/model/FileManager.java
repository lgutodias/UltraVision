package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class FileManager<T> {
	
	public boolean save(File file, T[] objects) {
		
		try(FileOutputStream fos = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			
			oos.writeObject(objects);
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Wrong data format");
			e.printStackTrace();
		}
				
		return true;
		
	}
	
	public T[] read(File file) {
		
		try(FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis)) {
			
			T[] objects = (T[]) ois.readObject();
			
			return objects;
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Wrong data format");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("The object stored in the file doesn't match");
			e.printStackTrace();
		}
		
		return null;
		
	}

}
