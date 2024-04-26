import Modelos.Consulta;
import Modelos.Registro;
import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Registro registro = new Registro();
        menu(registro);
    }

    public static void menu(Registro registro) {
        int opcion;
        BigDecimal cantidad;
        Consulta consulta;
        do  {
            System.out.println("Elija su opcion\n" +
                    "1) Peso a Dolar\n" +
                    "2) Peso a Euro\n" +
                    "3) Dolar a peso\n" +
                    "4) Dolar a Euro\n" +
                    "5) Euro a Peso\n" +
                    "6) Euro a Dolar\n" +
                    "7) Otro por codigo\n" +
                    "8) Salir");
            try {
                opcion = scanner.nextInt();
            } catch (InputMismatchException e){
                scanner.nextLine();
                opcion = 0;
            }
                switch (opcion) {
                    case 1:
                        System.out.print("Cuantos PESOS quiere pasar a DOLARES? ");
                        cantidad = scanner.nextBigDecimal();
                        consulta = new Consulta("ARS", "USD", cantidad);
                        registro.agregarConsulta(consulta);
                        break;
                    case 2:
                        System.out.print("Cuantos PESOS quiere pasar a EUROS? ");
                        cantidad = scanner.nextBigDecimal();
                        consulta = new Consulta("ARS", "EUR", cantidad);
                        registro.agregarConsulta(consulta);
                        break;
                    case 3:
                        System.out.print("Cuantos DOLARES quiere pasar a PESOS? ");
                        cantidad = scanner.nextBigDecimal();
                        consulta = new Consulta("USD", "ARS", cantidad);
                        registro.agregarConsulta(consulta);
                        break;
                    case 4:
                        System.out.print("Cuantos DOLARES quiere pasar a EUROS? ");
                        cantidad = scanner.nextBigDecimal();
                        consulta = new Consulta("USD", "EUR", cantidad);
                        registro.agregarConsulta(consulta);
                        break;
                    case 5:
                        System.out.print("Cuantos EUROS quiere pasar a PESOS? ");
                        cantidad = scanner.nextBigDecimal();
                        consulta = new Consulta("EUR", "ARS", cantidad);
                        registro.agregarConsulta(consulta);
                        break;
                    case 6:
                        System.out.print("Cuantos EUROS quiere pasar a DOLARES? ");
                        cantidad = scanner.nextBigDecimal();
                        consulta = new Consulta("EUR", "USD", cantidad);
                        registro.agregarConsulta(consulta);
                        break;
                    case 7:
                        System.out.print("Ingrese el codigo de su moneda inicial ");
                        scanner.nextLine();
                        String monedaA = scanner.nextLine();
                        System.out.print ("Ingrese el codigo de la moneda destino ");
                        String monedaB = scanner.nextLine();
                        System.out.print("Cuantos " + monedaA + " quiere pasar a "+ monedaB + "? ");
                        cantidad = scanner.nextBigDecimal();
                        consulta = new Consulta(monedaA, monedaB, cantidad);
                        registro.agregarConsulta(consulta);
                        break;
                    case 8:
                        registro.verRegistro();
                        System.exit(0);
                    default:
                        System.out.println("Opcion incorrecta, intente nuevamente");
                }
            }while ((opcion!=8));
        }
    }

