package com.utp.model.interfaces;



import Modelo.*;

public interface IUsuarioService extends  ICRUD<Empleado> {
     public Empleado validar(String user, String dni);
    
}
