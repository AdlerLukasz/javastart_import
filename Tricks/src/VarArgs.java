
public class VarArgs {
    public static void main(String[] args) {
        print("Ania", "Kasia", "Basia");
        print();
    }
    
    private static void print(String... values) {
        System.out.println(values.length);
        for (String val : values) {
            System.out.println(val);
        }
    }
}
