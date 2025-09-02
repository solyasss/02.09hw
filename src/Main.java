public class Main {
    public static void main(String[] args) {
        int length = 20;

        r_string generator = new r_string(length);
        String random_string = generator.generate_string();

        System.out.println("result: " + random_string);
    }
}
