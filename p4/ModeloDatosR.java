package es.uam.ads.p4;

import es.uam.ads.p4.ModeloDatos;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ModeloDatosR implements ModeloDatos {

   private HashMap<Long, Map<Long, Double>>  preferenciasUsuario = new HashMap<>();
   private HashMap<Long, Map<Long, Double>>  itemsPreferidos = new HashMap<>();


  @Override
  /**
   * Metodo que almacena en memoria, utilizando las estructuras especificadas en la practica, desde
   * los ficheros que se nos proporcionan
   */
  public void leeFicheroPreferencias(String ruta) throws IOException {
    String linea;
    String [] partes;
    
    FileInputStream fispreferencias = new FileInputStream(ruta);
    InputStreamReader ispreferencias = new InputStreamReader(fispreferencias);
    BufferedReader brpreferencias = new BufferedReader(ispreferencias);

    while ((linea = brpreferencias.readLine()) != null) {

      partes = linea.split("\\s+");
      Long usuario = Long.parseLong(partes[0]);
      Long item = Long.parseLong(partes[1]);
      Double ratio = Double.parseDouble(partes[2]);

      if (preferenciasUsuario.containsKey(usuario)) {
        preferenciasUsuario.get(usuario).put(item, ratio);
      }else{
        Map<Long,Double> Usuario = new HashMap<>();
        Usuario.put(item,ratio);
        preferenciasUsuario.put(usuario,Usuario);
      }

      if ((itemsPreferidos.containsKey(item))) {
        itemsPreferidos.get(item).put(usuario,ratio);
      }else{
        Map<Long, Double> Item = new HashMap<>();
        Item.put(usuario,ratio);
        itemsPreferidos.put(item,Item);
      }
      
    }
    
    brpreferencias.close();
    
    System.out.println(preferenciasUsuario);
    System.out.println(itemsPreferidos);
  }

  @Override
  /**
  * Devuelve el HashMap de las preferencias del usuario pasado como argumento
  * @param usuario Usuario del que queremos obtener sus preferencias
  * @return Devuelve el HashMap del usuario
  */
  public Map<Long, Double> getPreferenciasUsuario(Long usuario) {
    return Collections.unmodifiableMap(preferenciasUsuario.get(usuario));
  }

  @Override
  /**
  * Devuelve el HashMap con los usuarios y sus valoraciones del elemento pasado como
  * argumento
  * @param item Elemento del que queremos obtener la información
  * @return Devuelve el HashMap del elemento
  */
  public Map<Long, Double> getPreferenciasItem(Long item) {
    return Collections.unmodifiableMap(itemsPreferidos.get(item));
  }

  @Override
  /**
  * Devuelve el Set de todos los usuarios sin repetición
  * @return Devuelve el Set con todas las claves (usuarios)
  */
  public Set<Long> getUsuariosUnicos() {
    return Collections.unmodifiableSet(preferenciasUsuario.keySet());
  }

  @Override
  /**
  * Devuelve el Set de todos los elementos sin repetición
  * @return Devuelve el Set con todas las claves (elementos)
  */
  public Set<Long> getItemsUnicos() {
    return Collections.unmodifiableSet(itemsPreferidos.keySet());
  }

}
