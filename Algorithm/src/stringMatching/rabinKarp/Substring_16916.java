

package stringMatching.rabinKarp;

import java.util.Scanner;

public class Substring_16916 {
    //a prime number
    static long mod = Integer.MAX_VALUE; //2,147,483,647
    //the number of characters in the input alphabet
    static int base = 256;
    /* pat -> pattern
        txt -> text
    */
    static int search(String pat, String txt){
        int m = pat.length();
        int n = txt.length();
        if(n < m) return 0;
        int i, j;
        long hash_p = 0; // hash value for pattern
        long hash_t = 0; // hash value for txt
        long h = 1;

        //The value of h would be "pow(base, m-1)%mod"
        //항상 맨앞에 거 없애고 뒤에 붙이니까 pow(base, m-1)만 필요하
        for(i=0; i<m-1; i++){
            h = (h*base)%mod;
        }
        //Calculate the hash value of pattern and first window of text
        for(i=0; i<m; i++){
            hash_p = (base*hash_p + pat.charAt(i))%mod;
            hash_t = (base*hash_t + txt.charAt(i))%mod;
        }

        //Slide the pattern over text one by one
        for(i=0; i<=n-m; i++){
            /*
            * check the hash values of current window of text and pattern.
            * If the hash values match then only
            * check for characters one by one
            * */
            if(hash_p == hash_t){
                //check for characters one by one
                for(j=0; j<m; j++){
                    if(txt.charAt(i+j) != pat.charAt(j)) break;
                }

                if(j == m) return 1;

            }

            /*
            * Calculate hash value for next window of text :
            * Remove leading digit, add trailing digit
            * */
            if(i < n-m){
                hash_t = (base*(hash_t - txt.charAt(i)*h) + txt.charAt(i+m))%mod;

                //We might get negative value of t, converting it to positive
                if(hash_t < 0){
                    hash_t = (hash_t+mod);
                }
            }
        }

        return 0;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String p = sc.next();
        System.out.println(search(p, s));
    }

}
