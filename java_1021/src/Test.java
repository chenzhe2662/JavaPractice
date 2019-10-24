public class Test {
    public static String replaceSpace(StringBuffer str) {
        if (str == null) {
            return null;
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                str.deleteCharAt(i);
                str.insert(i, "20%");
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer();

        String ret = replaceSpace(str.append("hello world"));
        System.out.println(ret);


//        StringBuffer str = new StringBuffer();
//        str.append("hello").append("world");
//        //str.setCharAt(2,'R');
//        //System.out.println(str);
//        for (int i = 0; i < str.length(); i++) {
//            System.out.print(str.charAt(i)+" ");
//        }
    }
}
