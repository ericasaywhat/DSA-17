
public class Boomerang {

    public static int numberOfBoomerangs(int[][] points) {
        int numBoom = 0;
        MyHashMap<Integer,Integer> map = new MyHashMap<>();
        for(int i = 0; i < points.length; i++){
            for (int j = 0; j < points.length; j++){
                int distance = getSquaredDistance(points[i],points[j]);
                map.put(distance,map.getOrDefault(distance,0)+1);
            }
            for(Integer value: map.values()){
                numBoom += value*(value-1);
            }
            map.clear();
        }
        return numBoom;
    }

    private static int getSquaredDistance(int[] a, int[] b) {
        int dx = a[0] - b[0];
        int dy = a[1] - b[1];

        return dx*dx + dy*dy;
    }
}
