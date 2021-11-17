package br.com.planet.exception;

public class OldFirmwareException extends RuntimeException{

    public OldFirmwareException(){
        super ("A versão desse equipamento é muito antiga, por favor atualize manualmente");
    }
    
}
