//Rotate Matrix: Given an image represented by an NxN matrix, where each pixel in the image is 4
//bytes, write a method to rotate the image by 90 degrees. (an you do this in place?

//notes: 4 bytes == 4x8 = 32 bits which is integer range in java.
//we can work on an integer Matrix and rotate in place.

//idea1 : swap layer by layer, entire top row, entire left colom, entire bottom row, entire right colom.
// idea 2 : swap cell by cell , this one also layer by layer.

public class RotateMatrix {
    public static int[][] rotateMatrix(int[][] matrix){
        int size = matrix[0].length;
        for(int i=0;i<size/2;i++){
            for(int j=0;j<size;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[size-1-i][j];
                matrix[size-1-i][j] = matrix[size-1-i][size-1-j];
                matrix[size-1-i][size-1-j]= matrix[i][size-1-j];
                matrix[i][size-1-j] = temp;
            }
        }
    }  // figure out an offset so swaps happen properly
    // do on paper.
    00 01 02 03      30 20 10 00
    10 11 12 13      31
    20 21 22 23
    30 31 32 33



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