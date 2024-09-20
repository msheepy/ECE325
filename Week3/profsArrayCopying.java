package Week3;

public class profsArrayCopying {
    int[] arr = {0,1,2};
    //makes a shallow copy
    int[] copy = arr.clone();
    for(int elem : arr){
        System.out.println(elem);
    }
    for(int i = 0; i < arr.length; i++){
        System.out.println(arr[i]);
    }
}
