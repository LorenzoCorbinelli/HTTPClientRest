package httpclientrest;

import java.util.Scanner;

public class HTTPClientRest 
{
    public static void main(String[] args) 
    {
        RestClient client = new RestClient();
        Scanner input = new Scanner(System.in);
        
        int id;
        String nome;
        String cognome;
        String email;
        String numero;
        String s;
        do
        {
            System.out.println("1. get");
            System.out.println("2. post");
            System.out.println("3. delete");
            System.out.println("4. get(id)");
            System.out.println("5. put");
            System.out.println("0. uscita");
            s = input.nextLine();
            switch(s)
            {
                case "1":
                    client.get();
                break;
                case "2":
                    System.out.println("Inserisci l'ID:");
                    id=Integer.parseInt(input.nextLine());
                    System.out.println("Inserisci il nome:");
                    nome=input.nextLine();
                    System.out.println("Inserisci il cognome:");
                    cognome=input.nextLine();
                    System.out.println("Inserisci l'email:");
                    email=input.nextLine();
                    System.out.println("Inserisci il telefono:");
                    numero=input.nextLine();
                    client.post(id,nome,cognome,email,numero);
                break;
                case "3":
                    System.out.println("Inserissci l'ID:");
                    id=Integer.parseInt(input.nextLine());
                    client.delete(id);
                break;
                case "4":
                    System.out.println("Inserissci l'ID:");
                    id=Integer.parseInt(input.nextLine());
                    client.getId(id);
                break;
                case "5":
                    System.out.println("Inserisci l'ID:");
                    id=Integer.parseInt(input.nextLine());
                    System.out.println("Inserisci il nome:");
                    nome=input.nextLine();
                    System.out.println("Inserisci il cognome:");
                    cognome=input.nextLine();
                    System.out.println("Inserisci l'email:");
                    email=input.nextLine();
                    System.out.println("Inserisci il telefono:");
                    numero=input.nextLine();
                    client.put(id,nome,cognome,email,numero);
                break;
            }
            System.out.println("");
        }while(!s.equals("0"));
    }
    
}
