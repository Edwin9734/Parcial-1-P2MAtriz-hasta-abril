package com.edwin.dato;
import java.util.Scanner;

public class Clsgestion {
    static Scanner write=new Scanner(System.in);
      
    
    private static  String[][] comisiones = 
       {{"Ferna","500","700","700","700","","","","","",""},
        {"Juanes","500","700","700","60","","","","","",""},
        {"Armando","500","700","100","700","","","","","",""},
        {"Ernesto","500","700","100","100","","","","","",""},
        {"Vicente","500","700","100","300","","","","","",""},   
        {"Totales","","","","","","","","","",""}};
        
    
     
    
    private static final int NOMBRE =0;
    private static final int ENERO=1;
    private static final int FEBRERO =2;
    private static final int MARZO=3;
    private static final int ABRIL=4;
    private static final int TOTAL=5;
    private static final int VEINTE=6;
    private static final int TREINT=7;
    private static final int COMISION=8;
    private static final int ISR =9;
    private static final int LIQUIDO =10;
     

    public static void menu(){
        int opcion=0;
        System.out.println("Bienvenido a su Calculo Inventrial");
        System.out.println("        MENU DE OPCIONES");
        System.out.println("1   Visualizar los ingresos mensuales");
        System.out.println("2   Visualizar los calculos des sus datos");
        System.out.println("3   Salir");
        opcion = write.nextInt();
         switch(opcion)
        {
            case 1:
           imprimeDecorado();           
            break;
            case 2:
           Calculos();
           totales();
           imprimeDecorado(); 
           rango();
            break;
            case 3:
            System.out.println("Gracias por preferirnos");
              break;
            
        }
        
        
        
        
        
        
        
        
    } 
    public static void totales(){
      int mes1=0;
      int mes2=0;
      int mes3=0;
      int mes4=0;
      int comis=0;
    for (int x=0; x < 5; x++) {
      mes1 = mes1 + Integer.parseInt(comisiones[x][ENERO]);
      mes2 = mes2 + Integer.parseInt(comisiones[x][FEBRERO]);
      mes3 = mes3 + Integer.parseInt(comisiones[x][MARZO]);
      mes4 = mes4 + Integer.parseInt(comisiones[x][ABRIL]);
      comis = comis + Integer.parseInt(comisiones[x][COMISION]);
      
    }
       comisiones[5][ENERO]= String.valueOf(mes1);
       comisiones[5][FEBRERO]= String.valueOf(mes2);
       comisiones[5][MARZO]= String.valueOf(mes3);
       comisiones[5][ABRIL]= String.valueOf(mes4);
       comisiones[5][COMISION]= String.valueOf(comis);
    
    }
    public static void imprimeDecorado(){
        for (int x=0;x<comisiones.length;x++ ){
            System.out.print("");
             for (int y=0;y<comisiones[x].length;y++ ){
                 System.out.print(comisiones[x][y]+"\t");
                    if( y != comisiones[x].length-1 ){//asi da la longitud de la columna y ma.length la longitud de filas
                           System.out.print("\t");                       
                }
             }   
             System.out.println("");
         }
    } 
    public static void Calculos(){
        int total = 0;
        System.out.println("Nombre         Enero           Febrero         Marzo           Abril         Total ventas       20%             35%         V.Comisiones        ISR            LIQUIDO");

         for ( int i=0; i<5;i++){
             total = Integer.parseInt(comisiones[i][ENERO]);
             total = total + Integer.parseInt(comisiones[i][FEBRERO]);
             total = total + Integer.parseInt(comisiones[i][MARZO]);
             total = total + Integer.parseInt(comisiones[i][ABRIL]);
            
             comisiones[i][TOTAL] = String.valueOf(total);        
             
             if (total<=2000 ){
                comisiones[i][VEINTE]= String.valueOf(Math.round(total*(0.20)));
                comisiones[i][COMISION]= String.valueOf(Math.round((total +(total*(0.20)))));
             }
             if(total>=2001){
                 comisiones[i][TREINT]= String.valueOf(Math.round(total*(0.35)));
                 comisiones[i][COMISION]= String.valueOf(Math.round((total +(total*(0.35)))));
             }
             
             comisiones[i][ISR] = String.valueOf(Math.round((total*0.05)));
             comisiones[i][LIQUIDO] = String.valueOf(total-(total*0.05));
         
             }
         
    }
    public static void rango(){
        float numMax=0;
        String persona ="";
        String persona2="";
        System.out.println("");
     for ( int x =0; x<5;x++){
                  
         if (Float.parseFloat(comisiones[x][LIQUIDO])> numMax){
                    numMax = Float.parseFloat(comisiones[x][LIQUIDO]);
                    persona = comisiones[x][NOMBRE];
                } 
     }
     System.out.println("El mayor ingreso es de: "+ persona);
     
     for ( int x =0; x<5;x++){
                  
         if (Float.parseFloat(comisiones[x][LIQUIDO])< numMax){
                    numMax = Float.parseFloat(comisiones[x][LIQUIDO]);
                    persona2 = comisiones[x][NOMBRE];
                } 
     }
     
     
        System.out.println("El menor ingreso es de: "+ persona2);
     
    }
    
}