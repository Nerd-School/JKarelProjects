public class Zoo {
    public static void main(String args[]) {
        // creates 5 new lions
        for (int i = 0; i< 5; i++) {
            new Lion(1,1);
        }

        // will print out 5
        System.out.println("There are " + Lion.getNumLions() + " lions");
    }
}
