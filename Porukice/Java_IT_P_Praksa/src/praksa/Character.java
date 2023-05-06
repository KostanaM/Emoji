package praksa;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Character {

	public String name;
	public String allegiance;
	public String messages_logs;

	Character() {

	}

	Character(String name, String allegiance, String messages_logs) {
		this.name = name;
		this.allegiance = allegiance;
		this.messages_logs = messages_logs;
	}

	public String getName() {
		return name;
	}

	public String getAllegiance() {
		return allegiance;
	}

	public String getMessages_logs() {
		return messages_logs;
	}

	
	public List<String> getMessage_logs() {
		return FileHelper.loadMessages(messages_logs);
	}

	public static void info(List<Character> podaci) {
		for (Character character : podaci) {
			System.out.println("Ime: " + character.getName());
			System.out.println("Pripadnost: " + character.getAllegiance());
			System.out.println("Datoteka chata: " + character.getMessages_logs());
			System.out.println();
		}
	}

	public static void ispisPoruka(List<Character> porukica) {
		for (Character character : porukica) {
			if (character.getName().contains("Daenerys")) {
				for (int i = 1; i < character.getMessage_logs().size(); i++)
					System.out.print("To: " + character.getMessage_logs().get(i) + "\n");
				System.out.println();
			}
		}
	}

	public static void brojPoruka(List<Character> broj) {
		for (Character character : broj) {
			int brojac = 0;
			for (int i = 1; i < character.getMessage_logs().size(); i++) {
				if (character.getMessage_logs().get(i).isBlank() || character.getMessage_logs().get(i).isEmpty())
					continue;
				else
					brojac++;
			}
			System.out.println(character.getName() + ": " + brojac);
		}
		System.out.println();
	}
	public static void Disposition(List<Character> dispozicija) {
			String srecniEmoji = ".*[😄😊🙂😍].*" ; 
			String tuzniEmoji = ".*[😢😭👿😞].*" ;
			int happyCounter = 5;
			int sadCounter = 0;
			for (Character character : dispozicija) {
				for (String message : character.getMessage_logs()) {
				if (message.matches(srecniEmoji))
					happyCounter++;
				if (message.matches(tuzniEmoji))
					sadCounter++;
			}
			if (happyCounter > sadCounter)
			System.out.println(character.getName() + " is more happy than sad.");
		}
	}
	public static void ljubavnaPoruka(List<Character> ljubavna) {
		String ljubavniEmoji = ".*[😍😘].*" ;
	int brojacJon = 0;
	int brojacDany = 0;
	for (Character character : ljubavna) {
		Pattern pattern = Pattern.compile("^Jon.*|^Daenerys.*");
		for (String message : character.getMessage_logs()) {
			Matcher matcher = pattern.matcher(message);
			if (message.matches(ljubavniEmoji) && matcher.matches()) {
				if (character.getName().contains("Daenerys"))
					brojacDany++;
				if (character.getName().contains("Jon"))
					brojacJon++;
			}
		}
	}
	if (brojacJon > brojacDany)
		System.out.println("\nloving: Jon -> Daenerys Stormborn." + "(" + brojacJon + ":" + brojacDany+")");
	else if (brojacJon < brojacDany)
		System.out.println("\nloving: Daenerys -> Jon Snow."+ "(" + brojacDany + ":" + brojacJon+++")");
}
}