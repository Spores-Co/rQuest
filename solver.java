public class solver {
    static int address = 1000;

    public static boolean isTrue(int address) {
        int first = address / 1000;
        int second = (address / 100) - (10 * first);
        int third = (address / 10) - (10 * second) - (100 * first);
        int fourth = address - (10 * third) - (100 * second) - (1000 * first);
        if (first == second || first == third || first == fourth || second == third || second == fourth
                || third == fourth || first != (3 * third) || fourth % 2 == 0
                || (first + second + third + fourth) != 27) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        while (!isTrue(address)) {
            address++;
        }
        System.out.println("The address is: " + address);
    }
}