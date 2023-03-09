/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.awt.Color;

import static Ventanas.VtnPrincipal.R_repaint;
import static Ventanas.VtnPrincipal.areaJuego;

/**
 *
 * @author jacqueline
 */
public class AlgoritmoKruskal {
    private int acumulado;
    private int aristaMenor;
    private int fin;
    private boolean estaNodo=false;
    private boolean aumentaPeso;
    private int nodoApuntado;  
    private int nodoApuntador;
    private int peso;
    private int aristaMayor;
    private Arbol arboles;
    private int limite;
    private int  nodoOrigen;
   
    public AlgoritmoKruskal(Arbol arbol , int top ,int aristaMayor ){
       this.acumulado = 0;
       this.aristaMenor = 0;
       this.fin = 0;
       this.estaNodo=false;
       this.aumentaPeso = false;
       this.nodoApuntado = 0;  
       this.nodoApuntador = 0;
       this.peso = 1;
       this.aristaMayor = aristaMayor;
       this.arboles = arbol;
       this.limite = top;
    }

    public int getAcumulado() {
        return acumulado;
    }
  
   
    public void algoritmo(){
        this.nodoOrigen= 0;
        areaJuego.paint(areaJuego.getGraphics());
        R_repaint(limite,arboles);
        arboles.crearEnArbol(limite);
        arboles.setEnArbol(0, nodoOrigen);
        do{
            this.aristaMenor = this.aristaMayor;
            this.fin=2;
            for (int j = 0; j < peso; j++) {
                for (int k = 0; k < limite; k++){
                    if(arboles.getmAdyacencia(k, arboles.getEnArbol(j))==1){
                        for (int h = 0; h < peso; h++) {
                            if(arboles.getEnArbol(h)==k ){
                                this.estaNodo=true; 
                                break;
                            }
                        }
                        if(estaNodo==false){
                            if(arboles.getmCoeficiente(k, arboles.getEnArbol(j))<=aristaMenor && arboles.getmCoeficiente(k, arboles.getEnArbol(j))>0 ){
                                 aristaMenor=arboles.getmCoeficiente(k, arboles.getEnArbol(j));
                                 this.nodoApuntado=k;
                                 this.aumentaPeso=true;
                                 this.nodoApuntador=arboles.getEnArbol(j);
                                 this.fin=1;
                            }
                        }
                        this.estaNodo=false;
                    }
                }
            }   
            if(aumentaPeso==true){
                Pintar.pintarCamino(areaJuego.getGraphics(),arboles.getCordeX(nodoApuntador), arboles.getCordeY(nodoApuntador),arboles.getCordeX(nodoApuntado), arboles.getCordeY(nodoApuntado),Color.red); 
                Pintar.clickSobreNodo(areaJuego.getGraphics(),arboles.getCordeX(nodoApuntador), arboles.getCordeY(nodoApuntador), null,Color. red);
                Pintar.clickSobreNodo(areaJuego.getGraphics(),arboles.getCordeX(nodoApuntado), arboles.getCordeY(nodoApuntado), null, Color.red);                                  
                arboles.setEnArbol(peso, nodoApuntado);
                this.peso++;
                this.aumentaPeso=false;
                this.acumulado += this.aristaMenor;
            }
        }while(fin<2);
    }
}
