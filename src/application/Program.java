package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;
import model.entity.LogEntry;

public class Program {
	
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Set<LogEntry> set = new HashSet<LogEntry>();
		
		System.out.print("Enter file full path: ");
		String strPath = sc.nextLine();
		
		try (BufferedReader br = new BufferedReader(new FileReader(strPath))) {
			
			String line = br.readLine();
			
			while(line != null) {
				String[] filds = line.split(" ");
				String name = filds[0];
				Date moment = Date.from(Instant.parse(filds[1]));
				set.add(new LogEntry(name, moment));
				line = br.readLine();
			}
			
			System.out.print("Total users: " + set.size());
			
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		
		sc.close();
	}

}
