public InsertionClass{

public static int replace(int N, int M, int i, int j){
    //assume N has enough range, and i > j and m has (j-i number of bits)  N=10000000000 M=10011 i = 2, j=6
    int mask = 1;
    System.out.println(Integer.toBinaryString(N));
    for(int k=0;k<(j-i);k++){ // k=3 mask =111100
        mask = (mask<<1) | 1; 
    }
    mask = mask << i;  
    N = N & (~mask); //10000000000 & 111100 = 10000000000
    M = M << i;  //      1001100
    N =  N | M ; //  10001001100            
    System.out.println(Integer.toBinaryString(N));
    return N;
}

public static void main(String[] args) {
		int a = ~23423;
        int b = 5;
		int c = replace(a, b, 29, 31);
	}

}
