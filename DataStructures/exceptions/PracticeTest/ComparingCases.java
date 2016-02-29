package exceptions.PracticeTest;

/**
 * Created by David on 1/20/2016.
 */
public class ComparingCases {
    public static void main(String[] args){
        ComparingCases c = new ComparingCases();
        System.out.println(c.compareCases("ABBh"));
        System.out.println(c.compareCases("MaGdHij"));
        System.out.println(c.compareCases("JHGFKJSL"));
        //System.out.println(c.compareCases("g5"));
        System.out.println(c.compareCases("m?h"));
    }

    public int compareCases(String s) {
        int upper = 0, lower = 0;
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++){
            if (Character.isUpperCase(c[i]))
                upper++;
            else if (Character.isLowerCase(c[i]))
                lower++;
            else
                throw new IllegalArgumentException("The string should be composed of only letters");
        }

        return upper - lower;
    }
}
