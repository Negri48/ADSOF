package es.uam.ads.p4;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

public interface ModeloDatos {

  void leeFicheroPreferencias(String ruta) throws IOException;
  Map<Long, Double> getPreferenciasUsuario(Long usuario);
  Map<Long, Double> getPreferenciasItem(Long item);
  Set<Long> getUsuariosUnicos();
  Set<Long> getItemsUnicos();

//Otros metodos que los/las estudiantes crean oportuno
}
