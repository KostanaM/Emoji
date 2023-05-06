package praksa;

import java.util.*;


public class MessagesPrint {

	public static void main(String[] args) {

		List<Character> characters = new ArrayList<>();
		String m = FileHelper.loadMetaData();
		String[] l= m.split(System.lineSeparator());
		for (int i = 1; i < l.length; i++) {
			String[] s = l[i].split(",");
			String name = s[0].trim();
			String allegiance = s[1].trim();
			String messagesFile = s[2].trim();

			Character character = new Character(name, allegiance, messagesFile);
			characters.add(character);
		}

		Character.info(characters);
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("Daenerys` meggases: ");
		Character.ispisPoruka(characters);
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("Number of messages by character: ");
		Character.brojPoruka(characters);
		System.out.println("---------------------------------------------------------------------------------");
		Character.ljubavnaPoruka(characters);
		System.out.println("---------------------------------------------------------------------------------");
		Character.Disposition(characters);

	}

}