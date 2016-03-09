package archivos.binarios;


import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Calendar;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aula
 */
public class SoccerWay {
    RandomAccessFile rPlayers, rCods;
    public static String ROOT = "soccerway";
    
    public SoccerWay() throws IOException{
        new File(ROOT).mkdir();
        rPlayers = new RandomAccessFile(ROOT+"/players.fut","rw");
        initCodes();
    }

    private void initCodes()throws IOException {
        rCods = new RandomAccessFile(ROOT+"/codigos.fut","rw");
        if(rCods.length() == 0)
            rCods.writeInt(1);
    }
    
    private int getCode()throws IOException{
        rCods.seek(0);
        int cod = rCods.readInt();
        rCods.seek(0);
        rCods.writeInt(cod+1);
        return cod;
    }
    
    public boolean addPlayer(String n,Posiciones pos, String pais,int nc) throws IOException{
        
        if(!jerseyAssigned(nc)){
            //codigo
            rPlayers.writeInt(getCode());
            //nombre
            rPlayers.writeUTF(n);
            //fecha 
            rPlayers.writeLong(Calendar.getInstance().getTimeInMillis());
            //posicion
            rPlayers.writeUTF(pos.name());
            //pais
            rPlayers.writeUTF(pais);
            //numero camisa
            rPlayers.writeInt(nc);
            //salario
            rPlayers.writeDouble(10000);
            //dispo
            rPlayers.writeBoolean(true);
            return true;
        }
        return false;
    }

    private boolean jerseyAssigned(int nc) {
        /*
        1- Mover el puntero a 0
        2- Recorrer todos los jugadores, viendo si alguno
            tiene ese numero de camisa Y esta disponible.
        3- Si hay alguno asi retorno true, sino, retorno false
        */
        return true;
    }
}
