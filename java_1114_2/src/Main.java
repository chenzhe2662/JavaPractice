import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                String s = scanner.next();
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < s.length(); i++) {
                    char ch = s.charAt(i);
                    String str = builder.toString();
                    if(!str.contains(ch + "")) {
                        builder.append(ch);
                    }
                }
                System.out.println(builder.toString());
            }
        }
    }

