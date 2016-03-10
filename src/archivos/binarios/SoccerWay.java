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
    
    public SoccerWay(){
        try{
            new File(ROOT).mkdir();
            rPlayers = new RandomAccessFile(ROOT+"/players.fut","rw");
            initCodes();
        }
        catch(IOException e){
            System.out.println("No deberia pasar");
        }
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

    private boolean jerseyAssigned(int nc)throws IOException {
        rPlayers.seek(0);
        while(rPlayers.getFilePointer() < rPlayers.length()){
            rPlayers.readInt();
            rPlayers.readUTF();
            rPlayers.readLong();
            rPlayers.readUTF();
            rPlayers.readUTF();
            int camisa = rPlayers.readInt();
            rPlayers.readDouble();
            
            if(rPlayers.readBoolean() && nc == camisa){
                return true;
            }
        }
        return false;
    }
    
    public void printAvailables()throws IOException{
        rPlayers.seek(0);
        while(rPlayers.getFilePointer() < rPlayers.length()){
            int cod = rPlayers.readInt();
            String n = rPlayers.readUTF();
            Date fecha = new Date(rPlayers.readLong());
            String pos = rPlayers.readUTF();
            String pais = rPlayers.readUTF();
            int camisa = rPlayers.readInt();
            double sal = rPlayers.readDouble();
            
            if(rPlayers.readBoolean()){
                System.out.println(cod+"-"+n+"-"+pos+"-"+pais+
                        "- $"+sal+" camisa: #"+camisa+" Nacido en: "+
                        fecha);
            }
        }
    }
    
    public boolean search(int cod)throws IOException{
        /*
        retorne true si un jugador con ese codigo existe
        */
        rPlayers.seek(0);
        while(rPlayers.getFilePointer() < rPlayers.length()){
            if( cod == rPlayers.readInt() )
                return true;
            rPlayers.readUTF();
            rPlayers.readLong();
            rPlayers.readUTF();
            rPlayers.readUTF();
            rPlayers.skipBytes(13);
        }
        return false;
    }
    
    public boolean updateBirthdayFor(int cod, String fecha) throws IOException{
        if(search(cod)){
            //armo la fecha
            String data[] = fecha.split("/");
            int dia = Integer.parseInt(data[0]);
            int mes = Integer.parseInt(data[1]) - 1;
            int year = Integer.parseInt(data[2]);
            Calendar birthday = Calendar.getInstance();
            birthday.set(year, mes, dia);
            
            //si la fecha fue antes
            if(birthday.before(Calendar.getInstance())){
                //mi puntero por el search esta justo antes del nombre
                rPlayers.readUTF();
                //ahora viena la fecha!
                rPlayers.writeLong(birthday.getTimeInMillis());
                //no me importa ya los demas datos
                return true;
            }
        }
        return false;
    }
}
