public class task3{
    public static int solutions(int a, int b, int c){
        int d = b*b-4*a*c; //ищет дискриминант уравнения
        if (d>0) return 2 ; //если дискриминант больше нуля, уравнение имеет два решения
        if (d==0) return 1 ; //если дискриминант равен нулю, уравнение имеет одно решение
        return 0 ; //если дискриминант меньше нуля, уравнение не имеет решении
    }
    
    public static int findZip(String a){
        //функция ищет второе вхождение zip в строку a
        //если нет второго вхождения, возвращает -1
        return a.indexOf("zip", a.indexOf("zip")+3);
    }
    
    public static boolean checkPerfect(int a){
        //проверяет, является ли число a идеальным
        int k = 0;
        for (int i = 1; i<a; i+=1){
            if (a%i==0) k+=i; //если i является делителем числа а, то прибавляем к k
        }
        return (k==a); // возвращает true если число идеальное (сумма делителей равно числу)
    }
    
    public static String flipEndChars(String a){
        if (a.length()<3) return "Incompatible."; //– Если длина строки меньше двух, верните "несовместимо".".
        if (a.charAt(0)==a.charAt(a.length()-1)) return "Two's a pair."; //– Если первый и последний символы совпадают, верните "два-это пара.".
        return a.charAt(a.length()-1)+a.substring(1, a.length()-1)+a.charAt(0);
    }
    
    public static boolean isValidHexCode( String j ){
        if (j.charAt(0)!='#') return false; 
        
        try{//проверить, является ли часть строки без # hex - кодом
           Integer.parseInt(j.substring(1), 16);
        }
        catch(java.lang.NumberFormatException e){
            return false; //если нет, вернуть false
        }
        return true;
    }
    
    public static int countDistinct(int arr[]) 
    { //функция возвращает количество уникальных чисел в массиве
    int n = arr.length;
    int res = 0; 
    int i;
    for (i = 0; i < n; i+=1)  
    { 
        int j = 0; 
        for (j = 0; j < i; j++) {
            if (arr[i] == arr[j]) break; 
        };
        if (i == j) res++; 
    } 
    return res; 
    } 
    
    public static boolean same(int []a, int []b){
        //функция возвращает true если количество уникальных чисел в массивах равны
        return countDistinct(a)==countDistinct(b);
    }
    
    public static void main(String [] argv){
    }
}
