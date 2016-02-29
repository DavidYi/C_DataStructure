package exceptions.test;

public class Task1 {

	public static double percentVowels (String s) throws UnexpectedCharacterException
	{
		int vowel = 0;
        char temp;
        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++){
            temp = s.charAt(i);
            if (temp == 'a' || temp == 'e' || temp == 'i' ||  temp == 'o' || temp == 'u')
                vowel++;
            if (!(temp >= 'a' && temp <= 'z'))
                throw new UnexpectedCharacterException();
        }
        double percent = (double) vowel * 100/s.length();
        return percent;
	}
	
	public static void main(String[] args) {
		String[] s = {"Happy", "Jackson", "School Days", "Gr4et", "i", "AeIoU", "b", "16"};

		for (int i=0; i<s.length; i++)
		{
			try {
				System.out.print(s[i] + ": ");
				System.out.printf("%.1f%%\n", percentVowels(s[i]));
			}catch (UnexpectedCharacterException ex) {
				System.out.println("Illegal characters in string!");
			}
		}
	}
}
