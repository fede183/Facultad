public class MaxBetweenInt {
    public int max(int x, int y) {
        if (x<y) {
            int tmp = x;
            x = y;
            y = tmp;
        }
        return Math.max(x,y);
    }
}
