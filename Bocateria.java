import java.util.HashMap;

/**
 * Write a description of class Bocateria here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bocateria
{
    // instance variables - replace the example below with your own
    private Cliente primeraPersonaEnCola;
    private int facturacionActual;
    private HashMap <Integer,Cliente> clientesDespachados;
    private final static int PRECIO_BOCADILLO = 5;

    /**
     * Constructor for objects of class Bocateria
     */
    public Bocateria()
    {
        // initialise instance variables
        clientesDespachados = new HashMap<>();
        facturacionActual = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  numeroDeBocadillos del cliente que vamos a poner en cola
     */
    public void llegaNuevoClienteALaCola(int numeroDeBocadillos)
    {
        //Creamos el nuevo cliente
        Cliente nuevoCliente = new Cliente(numeroDeBocadillos);
        //Guardamos el primer cliente
        if(primeraPersonaEnCola == null)
        {
            primeraPersonaEnCola = nuevoCliente;
        }
        else 
        {
            Cliente ultimoCliente = primeraPersonaEnCola;
            
            while (ultimoCliente.getSiguienteEnLaCola() != null)
            {
                ultimoCliente = ultimoCliente.getSiguienteEnLaCola();
            }
            
            ultimoCliente.setSiguienteEnLaCola(nuevoCliente);
        }
    }
    
    /**
     * Visualizamos los datos de los clientes en cola
     */
    public void visualizaDatosClientesEnCola()
    {
        Cliente ultimoCliente = primeraPersonaEnCola;
            
        if (ultimoCliente != null)
        {
    
            while (ultimoCliente.getSiguienteEnLaCola() != null)
            {
                System.out.println(ultimoCliente.toString());
                ultimoCliente = ultimoCliente.getSiguienteEnLaCola();
            }
            System.out.println(ultimoCliente.toString());
        }
    }
    
    /**
     * Despachamos a un cliente y almacenamos el dinero
     */
    public void despacharClienteActual()
    {
        if (primeraPersonaEnCola != null)
        {
            //Almacenamos el cliente despachado
            clientesDespachados.put(primeraPersonaEnCola.getNumeroCliente(), primeraPersonaEnCola);
            //Incrementamos la facturacion
            facturacionActual += primeraPersonaEnCola.getNumeroDeBocadillos()*PRECIO_BOCADILLO;
            
            // Eliminamos el cliente despachado y guardamos el siguiente para qu sea el primero
            primeraPersonaEnCola = primeraPersonaEnCola.getSiguienteEnLaCola();
        }
    }
    
    /**
     * Visualizamos por pantalla los datos de la bocateria
     */
    public void visualizaDatosBocateria()
    {
        System.out.println("Facturacion de la bocateria : " + facturacionActual + " Euros");
        System.out.println("Estado de la cola");
        // Visualizamos los datos de los clientes en cola
        Cliente ultimoCliente = primeraPersonaEnCola;
            
        if (ultimoCliente != null)
        {
    
            while (ultimoCliente.getSiguienteEnLaCola() != null)
            {
                System.out.println(ultimoCliente.toString());
                ultimoCliente = ultimoCliente.getSiguienteEnLaCola();
            }
            System.out.println(ultimoCliente.toString());
        }
        // Visualizamos los datos de los clientes despachados
        System.out.println("Clientes despachados");
        int cont = 0;
        while (cont < clientesDespachados.size())
        {
            cont ++;
            System.out.println(clientesDespachados.get(cont).toString());            
        }
    }
    
    /**
     * Devuelve la posicion del cliente con mas bocadillos
     * Si no hay clientes devuelve -1
     */
    public int getPosicionPrimerClienteConMasBocadillos()
    {
        int posicion = -1;
        int max = 0;
        Cliente ultimoCliente = primeraPersonaEnCola;
            
        if (ultimoCliente != null)
        {
            //Comprobamos todos lso clientes menos el ultimo
            while (ultimoCliente.getSiguienteEnLaCola() != null)
            {
                if (ultimoCliente.getNumeroDeBocadillos() > max)
                {
                    max = ultimoCliente.getNumeroDeBocadillos();
                    posicion = ultimoCliente.getNumeroCliente();
                }
                ultimoCliente = ultimoCliente.getSiguienteEnLaCola();
            }
            //Comprobamos al ultimo cliente
            if (ultimoCliente.getNumeroDeBocadillos() > max)
                {
                    max = ultimoCliente.getNumeroDeBocadillos();
                    posicion = ultimoCliente.getNumeroCliente();
                }
        }
        
        return posicion;
    }
    
    /**
     * Cliente abandona la cola
     */
    public void clienteAbandonaCola(int id)
    {
        //Buscamos el cliente con el id indicado y lo eliminamos de la cola
        Cliente ultimoCliente = primeraPersonaEnCola;
        //Comprobamos si es el primer cliente de la cola
        if(id == primeraPersonaEnCola.getNumeroCliente())
        {
            // Si hay mas clientes ponemos al siguiente en priemra posicion sino dejamos la cola vacia
            if(primeraPersonaEnCola.getSiguienteEnLaCola() != null)
            {
                primeraPersonaEnCola = primeraPersonaEnCola.getSiguienteEnLaCola();
            }
            else
            {
                primeraPersonaEnCola = null;
            }
        }
        else
        //No es el primero asi que miramos si el id 
        //que buscamos menos uno para modificar el cliente siguiente y saltar uno
        {
            if (ultimoCliente != null)
            {
                while (ultimoCliente.getSiguienteEnLaCola() != null)
                {
                    if (ultimoCliente.getNumeroCliente() == (id-1))
                    {
                        ultimoCliente.setSiguienteEnLaCola(ultimoCliente.getSiguienteEnLaCola().getSiguienteEnLaCola());
                    }
                    ultimoCliente = ultimoCliente.getSiguienteEnLaCola();
                }
            }
        }
    }
    
    /**
     * Ordenamos por cantidad de bocadillos
     */
    public void ordenarColaPorNumeroDeBocadillos()
    {
        Cliente ultimoCliente = primeraPersonaEnCola;
            
        if (ultimoCliente != null)
        {
            while (ultimoCliente.getSiguienteEnLaCola() != null)
            {
                while (ultimoCliente.getNumeroDeBocadillos() > ultimoCliente.getSiguienteEnLaCola().getNumeroDeBocadillos())
                {
                    //siguiente se corre uno y comprobamos si hay un tercero
                    if(ultimoCliente.getSiguienteEnLaCola().getSiguienteEnLaCola() != null)
                    {
                        ultimoCliente.setSiguienteEnLaCola(ultimoCliente.getSiguienteEnLaCola().getSiguienteEnLaCola());
                    }
                    //el adelantado sigue al que le ha adelantado
                    ultimoCliente.getSiguienteEnLaCola().setSiguienteEnLaCola(ultimoCliente);
                }
                ultimoCliente = primeraPersonaEnCola;
            }
        }
    }
}
