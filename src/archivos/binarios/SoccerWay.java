package archivos.binarios;


import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
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
    
    private Calendar buildCalendarFromString(String date){
        //armo la fecha
        String data[] = date.split("/");
        int dia = Integer.parseInt(data[0]);
        int mes = Integer.parseInt(data[1]) - 1;
        int year = Integer.parseInt(data[2]);
        Calendar cal = Calendar.getInstance();
        cal.set(year, mes, dia);
        return cal;
    }
    
    public boolean updateBirthdayFor(int cod, String fecha) throws IOException{
        if(search(cod)){
            Calendar birthday = buildCalendarFromString(fecha);
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
    
    
    //TRABAJO GRUPO 3
    
    /**
     * 1- (15%)Con esta funcion podemos actualizar el salario de un 
     * jugador siempre y cuando exista. 
     * PARTE VISUAL: AGREGAR una ventana parecida a la del Birthday para
     * ejecutar esta opción. Ya esta la opcion que llamara esa forma en 
     * MenuSoccer
     * @param cod Codigo del jugador
     * @param newSalary Nuevo Salario
     * @return TRUE si se pudo guardar o FALSE si no.
     */
    public boolean updateSalary(int cod, double newSalary)throws IOException{
        if(search(cod)){
            rPlayers.readUTF();//nombre
            rPlayers.readLong();//fecha
            rPlayers.readUTF();//posicion
            rPlayers.readUTF();//pais
            rPlayers.readInt();//camisa
            double sal = rPlayers.readDouble();//salario
            if(sal < newSalary){
                //me regreso para actualizar
                rPlayers.seek(rPlayers.getFilePointer()-8);
                rPlayers.writeDouble(newSalary);
                return true;
            }
        }
        return false;
    }
    
    /**
     * 2- (20%)Agrega una nueva estadistica al archivo del jugador de estadisticas,
     * recordar que el archivo tendrá un nombre "estadistica_cod.fut" donde
     * cod es el codigo del jugador, siempre dentro del folder ROOT.
     * Valida primero que el jugador EXISTA (Para no crear un archivo de 
     * estadistica de puro gusto). La fecha de la estadistica se toma la del
     * momento.
     * PARTE VISUAL: Hacer una forma que se llame en la opcion de Agregar Estadistica
     * del menu de Jugadores en MenuSoccer. Esa forma tiene que llamar a esta
     * funcion.
     * @param cod Codigo del jugador
     * @param action El tipo de estadistica a guardar
     * @param cantidad La cantidad lograda de dicha estadistica
     * @param desc La descripcion de la estadistica.
     */
    public void addNewStadistic(int cod, TipoAccion action, int cantidad, String desc) throws IOException{
        if(search(cod)){
            RandomAccessFile rStats = new RandomAccessFile(ROOT+"/estadistica_"+cod+".fut", "rw");
            rStats.seek(rStats.length());
            
            //fecha
            rStats.writeLong(Calendar.getInstance().getTimeInMillis());
            //tipo
            rStats.writeUTF(action.name());
            //cantidad
            rStats.writeInt(cantidad);
            //desc
            rStats.writeUTF(desc);
            
            rStats.close();
        }
    }
    
    /**
     * 3- (20%) Agrega un nuevo registro en el archivo de "temporada.fut" dentro del
     * ROOT folder. 
     *  - Si el archivo esta nuevo, Se toma la fecha actual como la inicial y 
     *      y la fecha de exactamente un año despues como la final.
     * - Si ya hay por lo menos 1 registro, Se agrega el registro al final, 
     *      tomando como fecha de inicio, la fecha final del registro anterior 
     *      + 1 dia y la del fina siempre 1 año despues.
     * 
     * PARTE VISUAL: Hacer una forma para que la opcion de "Temporada->Agregar 
     * nueva" la llame y se llama esta funcion.
     * 
     * @param title El titulo de la Season.
     */
    public void addNewSeason(String title)throws IOException{
        RandomAccessFile rTemp = new RandomAccessFile(ROOT+"/temporada.fut", "rw");
        //iniciarlo con la de hoy
        Calendar start = Calendar.getInstance();
        
        while(rTemp.getFilePointer() < rTemp.length()){
            rTemp.readLong();//fecha inicio
            start.setTimeInMillis(rTemp.readLong());//fecha fin
            //sumarle 1 dia
            start.add(Calendar.DATE, 1);
            rTemp.readUTF();
        }
        
        //escribimos
        rTemp.writeLong(start.getTimeInMillis());//fecha de inicio
        //fecha fin
        start.add(Calendar.YEAR, 1);
        rTemp.writeLong(start.getTimeInMillis());
        //title
        rTemp.writeUTF(title);
        rTemp.close();
    }
    
    /**
     * 4- (15%)Funcion que despide un jugador, poniendo su dato booleano de disponible
     * en false, se valida que el jugador exista.
     * @param cod Codigo del jugador
     * @return TRUE si se pudo despedir o no.
     * PARTE VISUAL: Llamar esta opcion desde el submenu "Jugadores->Dar de Baja"
     */
    public boolean retirePlayer(int cod)throws IOException{
        if(search(cod)){
            rPlayers.readUTF();//nombre
            rPlayers.readLong();//fecha
            rPlayers.readUTF();//posicion
            rPlayers.readUTF();//pais
            rPlayers.skipBytes(12);//camisa y salario
            rPlayers.writeBoolean(false);
            return true;
        }
        return false;
    }
    
    /**
     * 5- (20%)Funcion que retorna la suma de las acciones conseguidas durante un 
     * periodo de tiempo para un jugador especifico EXISTENTE. 
     *  Por ejemplo si action es: GOLES, se suma todos los goles conseguidos en 
     * la fecha entre startDate y endDate.
     * NOTA: Utilizar la funcion nueva (ya hecha) buildCalendarFromString para
     * formar las fechas.
     * 
     * PARTE VISUAL: hacer una forma que pida los datos necesarios para llamar
     * esta funcion. La accion que sea un ComboBox como hicimos con las
     * posiciones, utilizar para las fechas el mismo componente usado en el de
     * birthday form. Luego al darle clic a un boton, mostrar la suma en algun
     * lado. Esta forma se llamara desde el submenu "Reportes -> Suma de acciones"
     * @param cod Codigo del Jugador
     * @param action Tipo de Accion
     * @param startDate Fecha de Inicio
     * @param endDate Fecha Final
     * @return la suma de las acciones estadisticas conseguidas.
     */
    public int actionQuantity(int cod, TipoAccion action, String startDate, String endDate) throws IOException{
        int suma =0;
        
        if(search(cod)){
            RandomAccessFile rStats = new RandomAccessFile(ROOT+"/estadistica_"+cod+".fut", "rw");
            rStats.seek(0);
            
            Calendar start = buildCalendarFromString(startDate);
            Calendar end = buildCalendarFromString(endDate);
            
            while(rStats.getFilePointer() < rStats.length()){
                //fecha
                Calendar fecha = Calendar.getInstance();
                fecha.setTimeInMillis(rStats.readLong());
                //tipo
                TipoAccion caction = TipoAccion.valueOf(rStats.readUTF());
                //cantidad
                int cant = rStats.readInt();
                //desc
                rStats.readUTF();

                if(caction == action){
                    if( fecha.after(start) && fecha.before(end)){
                        suma += cant;
                    }
                }
            }
            
            rStats.close();
        }
        return suma;
    }
    
    
    /**
     * 6- (10%) Retorna la CANTIDAD de jugadores disponibles que tiene el equipo.
     * Esta funcion se usa en la funcion de abajo: toTable()
     * @return la cantidad disponible
     */
    private int totalAvailables() throws IOException{
        rPlayers.seek(0);
        int total = 0;
        
        while(rPlayers.getFilePointer() < rPlayers.length()){
            rPlayers.readInt();//cod
            rPlayers.readUTF();//nombre
            rPlayers.readLong();//fecha
            rPlayers.readUTF();//posicion
            rPlayers.readUTF();//pais
            rPlayers.skipBytes(12);//camisa y salario
            if(rPlayers.readBoolean())
                total++;
        }
        
        return total;
    }
    
        /**
     * BONO. (10%)Funcion que retorna una String con los datos de:
     *  CODIGO - CAMISA - NOMBRE - SALARIO
     * del jugador MAS CARO del equipo.
     * PARTE VISUAL: Hacer que la opcion "Reportes->Mas Caro" imprima la String
     * resultante en la consola.
     * @return El texto formado.
     */
    public String expensivePlayer() throws IOException{
        String datoMayor="";
        double salMayor = 0;
        rPlayers.seek(0);
        while(rPlayers.getFilePointer() < rPlayers.length()){
            int cod = rPlayers.readInt();//cod
            String name = rPlayers.readUTF();//nombre
            rPlayers.readLong();//fecha
            rPlayers.readUTF();//posicion
            rPlayers.readUTF();//pais
            int nc = rPlayers.readInt();//camisa
            double sal = rPlayers.readDouble(); //salario
            //si esta disponible y el salario es > el mayor
            if(rPlayers.readBoolean() && sal > salMayor){
                salMayor = sal;
                datoMayor = cod+"-"+nc+"-"+name+"- $"+sal;
            }
        }
        return datoMayor;
    }
    
     //Para el listado de jugadores (VER FORMA YA AGREGADA al llamar "Jugadores->Listado"
    
    public String[] encabezados(){
        String head[] = {"Codigo"," Nombre", "Fecha Nacimiento","Posicion", "Pais",
            "Numero Camisa", "Salario"};
        return head;
    }
    
    /**
     * Se usa en la tabla del listado
     * @return el Arreglo Bidimensional de Object
     * @throws IOException 
     */
    public Object[][] toTable()throws IOException{
        int filas = totalAvailables();
        //son 6 columnas, vease encabezados()
        Object table[][] = new Object[filas][7];
        
        rPlayers.seek(0);
        for(int f=0; f < filas; f++){
            //codigo
            table[f][0] = rPlayers.readInt();
            //nombre
            table[f][1] = rPlayers.readUTF();
            //fecha
            table[f][2] = new Date(rPlayers.readLong()).toString();
            //posicion
            table[f][3] = rPlayers.readUTF();
            //Pais
            table[f][4] = rPlayers.readUTF();
            //camisa
            table[f][5] = rPlayers.readInt();
            //salario
            table[f][6] = rPlayers.readDouble();
            
            if(!rPlayers.readBoolean()){
                //si no esta dispobible, hare que la fila no avance
                f--; //luego el ciclo le aumentara uno mas.
            }
            
        }
        
        return table;
    }
    
    public Object[] toArray() throws IOException{
        ArrayList list = new ArrayList();
        rPlayers.seek(0);
        
        while(rPlayers.getFilePointer() < rPlayers.length()){
            int cod = rPlayers.readInt();//cod
            String name = rPlayers.readUTF();//nombre
            rPlayers.readLong();//fecha
            rPlayers.readUTF();//posicion
            rPlayers.readUTF();//pais
            rPlayers.skipBytes(12);//camisa-salario
            
            if(rPlayers.readBoolean())
                list.add(cod+"-"+name);
        }
        return list.toArray();
    }
    
    /**
     * PRUEBA 5:
     * Imprime en consola TODAS las estadisticas de un
     * jugador existente de la actual temporada.
     * NOTA: Se imprime asi:
     *  Jugador: Nombre
     *  - Fecha - Tipo Accion - Cantidad - Descripcion
     * NOTA: La current season es aquella cuya fecha actual (hoy)
     *  esta entre la fecha de inicio y fin.
     * NOTA:
     *      - Puede usar la funcion search(int cod).
     * @param cod 
     */
    public void printSeasonData(int cod)throws IOException{
        RandomAccessFile rSeasons = new RandomAccessFile(ROOT+"/temporada.fut","r");
        if(search(cod)){
            Calendar start=Calendar.getInstance();
            Calendar end=Calendar.getInstance();
            Calendar today=Calendar.getInstance();
            boolean season = false;
            //busquemos la season actual
            while(rSeasons.getFilePointer() < rSeasons.length()){
                start.setTimeInMillis(rSeasons.readLong());
                end.setTimeInMillis(rSeasons.readLong());
                rSeasons.readUTF();
                if(start.before(today) && end.after(today)){
                    season = true;
                    break;
                }
            }
            //imprimir
            if(season){
                //imprimir nombre
                System.out.println("Jugador: "+rPlayers.readUTF());
                
                RandomAccessFile rSts = new RandomAccessFile(ROOT+"/estadisticas_"+cod+".fut", "r");
                while(rSts.getFilePointer() < rSts.length()){
                    long fecha = rSts.readLong();
                    String accion = rSts.readUTF();
                    int cant = rSts.readInt();
                    String desc = rSts.readUTF();
                    if(start.getTimeInMillis()<= fecha && 
                            end.getTimeInMillis() >= fecha){
                        System.out.println("-"+new Date(fecha)+" - "+accion+
                                "-"+cant+" - "+desc);
                    }
                }
            }
        }
    }
    
    /**
     * TAREA:
     *  Generar un reporte en un archivo de texto cuya direccion
     *  viene de parametro con la informacion de todos los jugadores
     *  que estan disponibles.
     *      Formato a escribir en el archivo por registro:
     *          Numero camisa - Nombre - Posicion
     * @param filepath 
     */
    public void exportAvailablePlayers(String filepath){
        
    }
    
}
