public class Outer {
    private int x;

    public void doSometing() {
        int localVar = 5;

        class Inner {
            public void innerMethod() {
                x = 5;
                System.out.println("localVar: " + localVar);
            }
        }

        Inner inner = new Inner();
        inner.innerMethod();
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.doSometing();
    }
}