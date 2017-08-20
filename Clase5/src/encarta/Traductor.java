package encarta;

import java.util.HashMap;
import java.util.Iterator;

public class Traductor {
    private HashMap<String, String> palabras;

    public Traductor() {
        palabras = new HashMap<>();
        palabras.put("agua", "water");
        palabras.put("arroz", "rice");
        palabras.put("raton", "mouse");
        palabras.put("caballo", "horse");
        palabras.put("computadora", "computer");
    }

    public String traducir (String p) {
        String traducida;
        if (palabras.containsKey(p)) {
            traducida = palabras.get(p);
        } else {
            return "Palabra no encontrada";
        }
        return traducida;
    }

    public void mostrar() {
        System.out.println("    Encarta 2017");

        Iterator iter = palabras.entrySet().iterator();
        while (iter.hasNext()) {
            HashMap.Entry pal = (HashMap.Entry) iter.next();
            System.out.println(pal.getKey() + " = " + pal.getValue());
        }
    }
}
