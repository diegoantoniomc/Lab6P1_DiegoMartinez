//Diego Martinez
package lab6p1_diegomartinez;

import java.util.Scanner;
import java.util.Random;

public class Lab6P1_DiegoMartinez {

    static Scanner read = new Scanner (System.in);
    static Random random=new Random();
    
    public static void main(String[] args) {
        int opcion;
        do{
            System.out.println("");
            System.out.println("Menu");
            System.out.println("1 -> Turing");
            System.out.println("2 -> Constante de Kaprekar");
            System.out.println("3 -> Salida");
            System.out.println("Escoja la opcion que desee utilizar");
            System.out.println("");
            opcion = read.nextInt();
            
            switch (opcion){
                case 1:{
                    System.out.println("1 -> Turing");
                    System.out.println("Ingrese el tamaño de su arreglo");
                    int size=read.nextInt();
                    System.out.println("Arreglo generado");
                    int a[]=random(size);
                    print(a);
                    System.out.println("");
                    System.out.println("Ingrese la cadena de instrucciones: ");
                    read.nextLine();
                    String inst = read.nextLine();
                    String UP = inst.toUpperCase();
                    System.out.println("Cadena generada: "+generadora(a,UP));
                    
                }//End Case 1
                break;
                case 2: {
                    System.out.println("2 -> Constante de Kaprekar");
                    System.out.println("Ingrese su numero de 4 digitos");
                    int numero = read.nextInt();
                    String num=Integer.toString(numero);
                    while (num.length()!=4){
                        System.out.println("Numero no valido, que solo sea de 4 digitos");
                        numero = read.nextInt();
                        num=Integer.toString(numero);
                    }//End While
                    int c1,c2,c3,c4;
                    c1=num.charAt(0);
                    c2=num.charAt(1);
                    c3=num.charAt(2);
                    c4=num.charAt(3);                    
                    while(c1==c2&&c1==c3&&c1==c4){
                        System.out.println("Numero no valido, que no se repitan los digitos ");
                        numero = read.nextInt();
                    }//End While
                    while(c2==c1&&c2==c3&&c2==c4){
                        System.out.println("Numero no valido, que no se repitan los digitos ");
                        numero = read.nextInt();
                    }//End While
                    while(c3==c1&&c3==c2&&c3==c4){
                        System.out.println("Numero no valido, que no se repitan los digitos ");
                        numero = read.nextInt();
                    }//End While
                    System.out.println("Numero original: "+numero);
                    Kaprekar(numero);
                }//End Case 2
                break;
            }//End Switch
        }//End Do
        while (opcion!=3);
    }//End Public Static Void
    
    
    public static int[] random(int size){
        int[] temp = new int[size];
        for (int i = 0; i < temp.length; i++) {
            temp[i]=random.nextInt(10);
        }//End For
        return temp;
    }//End Random
    
    public static String generadora(int array[],String I){
        String cad="";
        int a=0;
        for (int i = 0; i < I.length(); i++) {
            if(I.charAt(i)=='R'){
               a++;
            }//End if
            else if (I.charAt(i)=='L'){
               a--;
            }//End else if
            else if (I.charAt(i)=='X'){
               cad+=array[a];
            }
        }//End For
        return cad;
    }//End Generadora
    
    public static int[] array(int num){
        int [] temp= new int[4];
        for (int i = 0; i < temp.length; i++) {
            temp[i]=num%10;
            num/=10;
        }//End For
        return temp;
    }//End Num
    
    public static int[] ascendente(int array[]){
        int temp;
        //El primer for funciona para poder inicializar el primer puesto del array
        //El segundo for funciona para comparar el el primer puesto con el segundo
        //El temp va agarando el numero de los lugares de los lugares del array para agregarlo de nuevo en orden
        //El if funciona para la comparacion y va haciendo un metodo de swap para ir ordenando
        for (int i = 0; i < array.length; i++) {
            for (int j = i+ 1; j < array.length; j++) {
                if(array[i]>array[j]){
                    temp=array[i];
                    array[i]=array[j];
                    array[j]=temp;
                }//End if
            }//End for 2
        }//End for 1
        return array;
    }//End Ascendente
    
    public static int[] descendente(int array[]){
    int temp;
    for (int i = 0; i < array.length; i++) {
        for (int j = i+ 1; j < array.length; j++) {
            if(array[i]<array[j]){
                temp=array[i];
                array[i]=array[j];
                array[j]=temp;
            }//End if
        }//End for 2
    }//End for 1
    return array;
    }//End Ascendente
    
    public static int numero(int array[]){
        int num=0;
        num=array[0]*1000+array[1]*100+array[2]*10+array[3];
        return num;
    }//End numero
    
    public static int Kaprekar(int num){
        int res=0,a,b,c=0;
        do{
                a=numero(ascendente(array(num)));
                b=numero(descendente(array(num)));
                res=b-a;
                num=res;
                System.out.println(b+"-"+a+"="+res);
                c++;
        }
        while(res!=6174);
        return res;
    }//End Kaprekar
    
    public static void print (int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print("["+array[i]+"]");
        }//End For
    }//End Print
    
}//End Public Class
