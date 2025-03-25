
package com.comp.complementos.DEMO;

import com.comp.complementos.DTO.DoctoRelacionado40DTO;
import com.comp.complementos.DTO.PagoCliente;
import com.comp.complementos.DTO.Totales40DTO;
import com.comp.complementos.DTO.TrasladosP40DTO;
import com.complementos.Impuestos;
//import com.comp.complementos.DTO.Totales40DTO;

/**
 *
 * @author msalas
 * Clase encargada de realizar el TEST a cada clase DTO
 */
public class PrincipalDemo {
    
    public static void main(String args[]){
        
        PagoCliente pagoCliente = new PagoCliente();
        pagoCliente.setTransactionProcess(5679498);
        
        Totales40DTO totales = new Totales40DTO(pagoCliente);
        
        TrasladosP40DTO tras;
        
        if (Impuestos.Iva16T(pagoCliente, "IVA16") == true) {
            tras = new TrasladosP40DTO(pagoCliente, "IVA16");
            tras.fill();
        }
        if (Impuestos.Iva00T(pagoCliente, "IVA00") == true) {
            tras = new TrasladosP40DTO(pagoCliente, "IVA00");
            tras.fill();
        }
        
        DoctoRelacionado40DTO docto = new DoctoRelacionado40DTO(pagoCliente);
        docto.fillDoctosRelacionados();
              
    }
    
}
