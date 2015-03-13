
/**
 * Write a description of class Cliente here.
 * Persona que va a comprar en la bocateria
 * 
 * @author Ruben Jimenez
 * @version 1.0
 */
public class Cliente
{
    // instance variables - replace the example below with your own
    private int numeroCliente;
    private Cliente siguienteEnLaCola;
    private int numeroDeBocadillos;
    private static int numeroClienteActual = 0;

    /**
     * Constructor for objects of class Cliente
     */
    public Cliente(int numeroDeBocadillos)
    {
        // initialise instance variables
        this. numeroDeBocadillos = numeroDeBocadillos;
        
        numeroClienteActual++;
        numeroCliente = numeroClienteActual;
    }
    
    /**
     * Devuelve el numero del cliente
     */
    public int getNumeroCliente()
    {
        return numeroCliente;
    }
}
