import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SortThePeople {
    public static void main(String[] args) {
        String[] names;
        int[] heights;
        if (args.length == 0) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Digite el tamaño del arreglo");
            int n = sc.nextInt();
            names = new String[n];
            heights = new int[n];
            System.out.println("Digite el array de nombres");
            for (int i = 0; i < n; i++) {
                names[i] = sc.next();
            }
            System.out.println("Digite el array de estaturas");
            for (int i = 0; i < n; i++) {
                heights[i] = sc.nextInt();
            }
            for (int i = 0; i < names.length; i++) {
                System.out.println(names[i] + "," + heights[i]);
            }

            System.out.println("\nPersonas Ordenadas por estatura(Descendentemente)");
            String[] orden = sortPeople(names, heights);
            for (int i = 0; i < orden.length; i++) {
                System.out.println(orden[i]);
            }
            boolean repetidos = false;
            for (int i = 0; i < heights.length; i++) {
                for (int j = i + 1; j < heights.length; j++) {
                    repetidos = true;
                    if (heights[i] == heights[j]) {
                        System.out.println("ERROR se encontraron estaturas iguales");
                    }
                }
            }
        } else {
            int caso = 1;
            while (caso < 101) {
                names = generarNombres(Integer.parseInt(args[0]));
                heights = generarEstaturas(Integer.parseInt(args[0]));
                System.out.println("CASO #" + caso);
                for (int i = 0; i < names.length; i++) {
                    System.out.println(names[i] + "," + heights[i]);
                }

                System.out.println("\nPersonas Ordenadas por estatura(Descendentemente)");
                String[] orden = sortPeople(names, heights);
                for (int i = 0; i < orden.length; i++) {
                    System.out.println(orden[i]);
                }

                boolean repetidos = false;
                for (int i = 0; i < heights.length; i++) {
                    for (int j = i + 1; j < heights.length; j++) {
                        repetidos = true;
                        if (heights[i] == heights[j]) {
                            System.out.println("ERROR se encontraron estaturas iguales");
                        }
                    }
                }

                System.out.println("FIN CASO #" + caso + "\n");
                caso++;
            }
        }
    }

    public static String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> personas = new HashMap();
        for (int i = 0; i < heights.length; i++) {
            personas.put(heights[i], names[i]);
        }
        burbuja(heights);

        String[] nombres = new String[names.length];
        for (int i = 0; i < heights.length; i++) {
            nombres[i] = personas.get(heights[i]);
        }
        return nombres;
    }

    // metodo burbuja invertido para ordenar las estaturas en orden descendente
    public static void burbuja(int[] A) {
        int i, j, aux;
        for (i = 0; i < A.length - 1; i++) {
            for (j = 0; j < A.length - i - 1; j++) {
                if (A[j + 1] > A[j]) {
                    aux = A[j + 1];
                    A[j + 1] = A[j];
                    A[j] = aux;
                }
            }
        }
    }

    public static String[] generarNombres(int cantidad) {
        String[] nombresAleatorios = new String[cantidad];

        String[] nombres = { "Andrea", "David", "Baldomero", "Balduino", "Baldwin", "Baltasar", "Barry", "Bartolo",
                "Bartolome", "Baruc", "Baruj", "Candelaria", "Candida", "Canela", "Caridad", "Carina", "Carisa",
                "Caritina", "Carlota", "Baltazar" };
        String[] apellidos = { "Gomez", "Guerrero", "Cardenas", "Cardiel", "Cardona", "Cardoso", "Cariaga", "Carillo",
                "Carion", "Castiyo", "Castorena", "Castro", "Grande", "Grangenal", "Grano", "Grasia", "Griego",
                "Grigalva" };

        for (int i = 0; i < cantidad; i++) {
            nombresAleatorios[i] = nombres[(int) (Math.floor(Math.random() * ((nombres.length - 1) - 0 + 1) + 0))] + " "
                    + apellidos[(int) (Math.floor(Math.random() * ((apellidos.length - 1) - 0 + 1) + 0))];
        }
        return nombresAleatorios;
    }

    public static int[] generarEstaturas(int cantidad) {
        int[] estaturas = new int[cantidad];
        for (int i = 0; i < cantidad; i++) {
            estaturas[i] = (int) (Math.random() * 200) + 1;
        }
        return estaturas;
    }

}
