public class copyingArray {
    int[] arr = {0, 1, 2, 3, 4};
    int[]copy = new int[5];
    for(int i = 0; i < arr.length; i++){
        copy[i] = arr[i];
    }
}
