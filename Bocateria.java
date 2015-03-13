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
        //Añadimos el cliente a la cola
        clientesDespachados.put(nuevoCliente.getNumeroCliente(),nuevoCliente);
        // Le ponemos al cliente anterior este cliente en el atributo siguienteEnLaCola
        if (nuevoCliente.getNumeroCliente() > 1)
        {
            clientesDespachados.get(nuevoCliente.getNumeroCliente()-1).setSiguienteEnLaCola(nuevoCliente);
        }
    }
    
    /**
     * Visualizamos los datos de los clientes en cola
     */
    public void visualizaDatosClientesEnCola()
    {
        int cont = 1;
        while(cont <= clientesDespachados.size())
        {
            System.out.println(clientesDespachados.get(cont).toString());
            cont++;
        }
    }
}
