package app.todo;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int opc;
        ArrayList lista = new ArrayList<String>();

        while (true) {
            System.out.println("\n\nMI LISTA DE TAREAS");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Completar tarea");
            System.out.println("3. Ver tareas");
            System.out.println("4. Exportar tareas");
            System.out.println("5. Salir");
            System.out.print("OPCION: ");
            try {
                opc = Integer.parseInt(br.readLine());
            } catch (IOException e) {
                opc = 0;
            } catch (NumberFormatException e) {
                opc = 0;
            }

            switch(opc) {
                case 1:
                    String tarea;
                    System.out.println("Vamos a agregar una tarea...");
                    System.out.print("TAREA: ");
                    while (true) {
                        try {
                            tarea = br.readLine();
                        } catch (IOException e) {
                            tarea = null;
                            System.out.println("ERROR::Tarea invalida");
                        }
                        if (tarea != null && !tarea.equals("")) {
                            break;
                        }
                    }
                    lista.add(tarea);
                    break;
                case 2:
                    int op;
                    System.out.println("Vamos a completar una tarea...");
                    if (lista.size() > 0) {
                        lista.forEach(t -> {
                            System.out.println(lista.indexOf(t)+1 + ". " + t);
                        });
                        while (true) {
                            try {
                                System.out.print("Tarea a Borrar: ");
                                op = Integer.parseInt(br.readLine());
                            } catch (IOException e) {
                                op = -20;
                            } catch (NumberFormatException e) {
                                op = -20;
                            }
                            if (op > 0 && op <= lista.size()) {
                                break;
                            } else {
                                System.out.println("ERROR::Opcion invalida");
                            }
                        }
                    } else {
                        System.out.println("Sin tareas todavia...");
                        break;
                    }
                    lista.remove(op-1);
                    break;
                case 3:
                    System.out.println("Vamos a ver las tareas...");
                    if (lista.size() > 0) {
                        System.out.println("Hay " + lista.size() + " tareas.");
                        lista.forEach(t -> {
                            System.out.println("[] " + t);
                        });
                    } else {
                        System.out.println("Sin tareas todavia...");
                    }
                    break;
                case 4:
                    System.out.println("Vamos a exportar las tareas...");
                    if (lista.size() > 0) {
                        try {
                            BufferedWriter bw = new BufferedWriter(new FileWriter("lista.txt"));
                            lista.forEach(t -> {
                                try {
                                    bw.write("[] " + t + "\n");
                                } catch (IOException e) {
                                    System.out.println("ERROR::Problema con el archivo");
                                }
                            });
                            bw.close();
                        } catch (IOException e) {
                            System.out.println("ERROR::Problema con el archivo");
                        }
                    } else {
                        System.out.println("Sin tareas todavia...");
                    }
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("ERROR::Opcion invalida!");
                    break;
            }
        }

    }
}