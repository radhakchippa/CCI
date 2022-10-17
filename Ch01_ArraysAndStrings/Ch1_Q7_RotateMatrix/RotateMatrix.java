//Rotate Matrix: Given an image represented by an NxN matrix, where each pixel in the image is 4
//bytes, write a method to rotate the image by 90 degrees. (an you do this in place?

//notes: 4 bytes == 4x8 = 32 bits which is integer range in java.
//we can work on an integer Matrix and rotate in place.

//idea1 : swap layer by layer, entire top row, entire left colom, entire bottom row, entire right colom.
// idea 2 : swap cell by cell , this one also layer by layer.

public class RotateMatrix {
    public static int[][] rotateMatrix(int[][] matrix){
        if(matrix == null || matrix.length==0 || matrix[0].length==0) throw new Exception("Matrix is empty");
        if(matrix.length != matrix[0].length) throw new Exception("Invalid Input Exception");
        int size = matrix[0].length;
        for(int i=0;i<size/2;i++){
            for(int j=i;j<(size-1-i);j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[size-1-i][j];
                matrix[size-1-i][j] = matrix[size-1-i][size-1-j];
                matrix[size-1-i][size-1-j]= matrix[i][size-1-j];
                matrix[i][size-1-j] = temp;
            }
        }
        return matrix;
    }
    // the rotation is done in layers like onion, outer most layer, then layer below it and so on.
    // so for a nxn matrix, there will be n/2 layers.
    // in each layer we have to rotate arraysize-layer*2. eg: first layer: n-1-(0*2) since i=0,
    // in layer 2 , we have to roate from 1,1 to 1n-2 which means n-1-(1*2) since i=1.
    // since rotation is in place , space complexity is O(1) constant.
    // time complexity is ( we are rotation all the nxn elements O(n^2)


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of nxn matrix:");
        int size= sc.getInteger();
        int[][] matrix = new int[size][size];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                matrix[i][j] = sc.getInteger();
        }
        System.out.println(rotateMatrix(matrix));
    }
}