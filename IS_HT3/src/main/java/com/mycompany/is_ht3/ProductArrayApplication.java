/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.is_ht3;

import java.util.Arrays;
import java.util.OptionalLong;

/**
 *
 * @author luis
 */
public class ProductArrayApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        long[] resultado= null;
        long[] entrada = null;
        //1
        entrada = new long[] {1, 2, 3, 4, 5 };
        resultado= calculateProductArrayBasic(entrada);
        System.out.println("Probando "+Arrays.toString(entrada)+" - Resultado "+Arrays.toString(resultado));
        //2
        entrada = new long[0];
        resultado =calculateProductArrayBasic(entrada);
        System.out.println("Probando "+Arrays.toString(entrada)+" - Resultado "+Arrays.toString(resultado));
        //3
        entrada = new long[]{1, 0};
        resultado =calculateProductArrayBasic(entrada);
        System.out.println("Probando "+Arrays.toString(entrada)+" - Resultado "+Arrays.toString(resultado));
        //4
        entrada = new long[]{1, 0,2,5,3};
        resultado =calculateProductArrayBasic(entrada);
        System.out.println("Probando "+Arrays.toString(entrada)+" - Resultado "+Arrays.toString(resultado));
        //5
        entrada = new long[]{1, 0,2,0,3};
        resultado =calculateProductArrayBasic(entrada);
        System.out.println("Probando "+Arrays.toString(entrada)+" - Resultado "+Arrays.toString(resultado));
        //6
        entrada = new long[]{1};
        resultado =calculateProductArrayBasic(entrada);
        System.out.println("Probando "+Arrays.toString(entrada)+" - Resultado "+Arrays.toString(resultado));
        //7
        entrada = new long[]{0};
        resultado =calculateProductArrayBasic(entrada);
        System.out.println("Probando "+Arrays.toString(entrada)+" - Resultado "+Arrays.toString(resultado));
        //8
        entrada = null;
        resultado =calculateProductArrayBasic(entrada);
        System.out.println("Probando "+Arrays.toString(entrada)+" - Resultado "+Arrays.toString(resultado));
        //9
        entrada =  new long[]{};
        resultado =calculateProductArrayBasic(entrada);
        System.out.println("Probando "+Arrays.toString(entrada)+" - Resultado "+Arrays.toString(resultado));
        
        //10
        entrada =  new long[]{1,2,  3};
        resultado =calculateProductArrayBasic(entrada);
        System.out.println("Probando "+Arrays.toString(entrada)+" - Resultado "+Arrays.toString(resultado));
        
        
    }
    
    public static long[] calculateProductArrayBasic(long[] input){
        long[] respuesta=null;
        if(input!=null){
        
        respuesta=Arrays.copyOf(input,input.length);
        Arrays.fill(respuesta, 0);
        OptionalLong resp= Arrays.stream(input).reduce((a,b)->a*  b );
        long[] aux = null;
        aux = Arrays.copyOf(input,input.length);
        Arrays.sort(aux);
        //System.out.println(Arrays.toString(aux));
        for(int i=0; i<input.length; i++){
            //System.out.println(aux[i]);
            long dato = input[i];
            int posicion = Arrays.binarySearch(aux, dato);
            //System.out.println(posicion);
            long aux2=aux[posicion];
            aux[posicion]=1;
            OptionalLong operacion= Arrays.stream(aux).reduce((a,b)->a*  b );
            //System.out.println(operacion.getAsLong());
            respuesta[i]=operacion.getAsLong();
            aux[posicion]=aux2;
        }
        }
        return respuesta;
    }
    
}
