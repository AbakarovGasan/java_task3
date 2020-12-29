import java.util.*;

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
    
    public static boolean isKaprekar(int a){
        String out = String.valueOf((int)Math.pow(a, 2)); // получить строку
        // от числа а, возведенной в квадрат
        int len = out.length(); // размер строки
        if (len==1) return false; //ecли размер строки равен 1, то квадрат числа больше а
        len = len / 2; // если число нечетное, то остаток отбрасывается
        String left = out.substring(0, len); // правая часть числа
        String right = out.substring(len); // левая часть числа
        return ( Integer.parseInt(left)+Integer.parseInt(right) ) == a;//возвращает 
        //true, если число является числом Капрекара 
    }
    
    public static String longestZero(String bin){
        String out = "";
        try{
            Integer.parseInt(bin, 2); //проверяет, является ли число двоичным, если нет, 
            // то вызывается ошибка
            int len = bin.length(); // размер строки
            int zeros = 0; // число последовательных нулей
            int max = 0; // максимальное число последовательных нулей
            boolean is_counting = false; // флаг, указывающий на то, ведет ли отсчет нулей
            char temp = '1'; // временная переменная
            int i = 0; // переменная для цикла
            while (i<len){
                temp = bin.charAt(i); // присвоить temp символ из строки
                i+=1; 
                if (is_counting & (temp == '1')){
                    is_counting = false; // если введется счет нулей
                    // и символ равен 1, то приостановить счет нулей
                    if (zeros > max){
                        max = zeros;
                    }
                }
                else if (is_counting & (temp == '0')){
                    zeros +=1;
                }
                else if ((!is_counting) & (temp == '0')){
                    zeros = 1;
                    is_counting = true;
                }
            }
            if (zeros > max){
                max = zeros;
            }
            for (i=0; i<max; i++){
                out+='0';
            }
            return out;
        }
        catch(Exception e){
            return out;
        }
    } 
    
    //проверяет, является ли число простым 
    public static boolean isPrime(int a){
        int j = (int)primes.get(primes.size()-1); // берется последнее число из списка primes (список простых чисел)
        l1: while (a>j){
            // выполняется до тех пор, пока последнее число из списка primes (список простых чисел) меньше а
            j+=2;  
            for (int i = 0; i < primes.size(); i++){
                int f = (int)(primes.get(i));
                if ((j%f)==0) continue l1; 
            }
            primes.add(j); // если число не делится без остатка ни на одно из чисел из списка primes,
            // то оно добавляется в конец списка
        }
        if (a==j) return true;
        if (a<j) return primes.contains(a);
        return true;
    }
    static public List primes = new ArrayList<Integer> (Arrays.asList(2, 3, 5));
    
    //Если задано целое число, то возвращается следующее
    //простое число. Если число простое, возвращается само число. 
    static public int nextPrime(int a){
        while (!isPrime(a)){
         //    System.out.println(isPrime(a));
             a++; // увеличивать число до тех пор, пока не станет простым
        }
        return a;
    }
    
    public static void main(String [] argv){
        System.out.println(nextPrime(4));
    }
}

