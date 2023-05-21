/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaDeNegocio;

/**
 *
 * @author ferna
 */
public class ConjuntoCadena {

    VectorNBits VNumerador;
    VectorNBits VDenominador;
    int cant;
    
    public ConjuntoCadena(){
        this.VNumerador=new VectorNBits(28, 5);
        this.VDenominador=new VectorNBits(28, 5);
        cant=0;
    }
                          //a           ,       b
    public void insertar(char numerador,char  denominador){
        
        if (vocales(numerador,denominador)) {
            if (!pertenece(numerador,denominador)) {
                int cantidadDelementos=VNumerador.cantidad();
                if (cant<cantidadDelementos) {
                    cant++;
                    //a=0 b=1 ...z=27
                    int numeradorletra=obtenerValorLetra(numerador);
                    int denominadorletra=obtenerValorLetra(denominador);
                    
                    VNumerador.insertar(numeradorletra,cant);
                    VDenominador.insertar(denominadorletra,cant);
                    //System.out.println(VNumerador.toString());
                    //System.out.println(VDenominador.toString());
                }
            }
        }
    }
                              //'a'
    public boolean vocales(char numerador, char denominador) {
        String numeradorcad=String.valueOf(numerador); //"a"
        String denominadorcad=String.valueOf(denominador); //"a"
        
        boolean numeroadoresLetra=numeradorcad.matches("[a-z]");
        boolean denominadoresLetra=denominadorcad.matches("[a-z]");
        //boolean numeradorUnico=!pertenece(numerador, );
        boolean valoresunicos=!pertenece(numerador, denominador);
        return  numeroadoresLetra && denominadoresLetra && valoresunicos;
    }
    
    public boolean pertenece(char numerador, char denominador) {
        for (int i = 0; i < cant; i++) {
            //0=a 1=b c=3
            if (numerador==obtenerletra(VNumerador.sacar(i+1))&& 
                denominador==obtenerletra(VDenominador.sacar(i+1))) {
                return  true;
            }
        }
        return  false;
    
    }
    //a=0 b=1 ...z=27
    public int obtenerValorLetra(char letra) {
        if (letra>='a' && letra <='z') {
             return letra-'a';////a =97 -97=0
        }else{
            return -1;
        }
    }
    //a=0 b=1 ...z=27
    public char obtenerletra(int valor) {
         if (valor>=0 && valor<28) {
            return (char) (valor+97);
        }else{
             return 0;
         }
    }
    
    
    public String toString(){
        String salida="C={";
        for (int i = 0; i < cant; i++) {
            salida=salida+obtenerletra(VNumerador.sacar(i+1))+"/"+
                    obtenerletra(VDenominador.sacar(i+1))+",";
        }
        salida=salida.substring(0, salida.length()-1);
        return  salida+"}";
    }
    
    public static void main(String[] args) {
        ConjuntoCadena C=new ConjuntoCadena();
        C.insertar('a', 'b');
        C.insertar('c', 'd');
        C.insertar('e', 'f');
        C.insertar('c', 'b');
        
        //System.out.println(C.obtenerValorLetra('b'));
           
       // System.out.println(C.obtenerletra(0));
        System.out.println(C.toString());
    }

   

   

    
    
}
