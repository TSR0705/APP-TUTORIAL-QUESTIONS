public class Container {
    public static void main(String[] args) {
        int waterInContainer = 0;
        int count10L = 0;
        int count3L = 0;
        while (waterInContainer < 50) {
            count10L++;
            waterInContainer += 10;
            if (waterInContainer == 50) {
                break;
            }
            count3L++;
            waterInContainer += 3;
        }
        System.out.println("No. of 10L buckets: " + count10L);
        System.out.println("No. of 3L buckets: " + count3L);
    }
}
