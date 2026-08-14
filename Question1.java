import java.util.*; 
 
public class Question1{ 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
 
        int n = sc.nextInt(); 
        long budget = sc.nextLong(); 
 
        int[] scholarship = new int[n]; 
 
        for (int i = 0; i < n; i++) { 
            scholarship[i] = sc.nextInt(); 
        } 
 
        Arrays.sort(scholarship); 
 
        long total = 0; 
        int count = 0; 
 
        for (int amount : scholarship) { 
            if (total + amount <= budget) { 
                total += amount; 
                count++; 
            } else { 
                break; 
            } 
        } 
 
        System.out.println(count); 
 
        sc.close(); 
    } 
}