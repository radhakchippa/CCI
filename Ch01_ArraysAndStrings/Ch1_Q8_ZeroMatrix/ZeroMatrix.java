//Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
//column are set to O.

public class ZeroMatrix {

    //idea 1 keep the row and column where zero exists, then replace entire row and columns in next iteration.
    public static void zeroMatrix1(int[][] matrix){
        if(matrix == null) return;
        if(matrix.length == 0 || matrix[0].length == 0) return;
        int rows[] = new int[matrix.length];
        int colomn[] = new int[matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    rows[i] =i, colomn[j] = j;
                }
            }
        }
        for(int i=0;i<rows.length;i++){
            if(rows[i] !=0) {
                for(int j=0;j<matrix[0].length;j++)
                    matrix[i][j] = 0
            }
        }

        for(int i=0;i<colomn.length;i++){
            if(colomn[i] !=0) {
                for(int j=0;j<matrix.length;j++)
                    matrix[j][i] = 0
            }
        }
    }
    //idea2  set the first element of the rows and columns where zero exits, then replace entire row and columns
    // in next iteration.
    public static void zeroMatrix2(int[][] matrix){
        if(matrix == null) return;
        if(matrix.length == 0 || matrix.[0].length==0) return;

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for(int i=0;i<matrix.length;i++){
            if(matrix[i][0] == 0){
                for(int j=0;j<matrix[0].length;j++){
                    matrix[i][j] = 0;
                }
            }
        }

        for(int i=0;i<matrix[0].length;i++){
            if(matrix[0][i] == 0){
                for(int j=0;j<matrix.length;j++){
                    matrix[j][i] = 0;
                }
            }
        }
    }
    //Why cant we set all rows and columns when we find a zero?? eventually all the matrix becomes 0 matrix. - so we have
    // to two two iterations.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m,n;
        System.out.println("enter row size:");
        m = sc.nextInt();
        System.out.println("enter column size:");
        n = sc.nextInt();
        int[][] array = new int[m][n];
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                array[i][j] = sc.nextInt();
        zeroMatrix(array);
    }
}