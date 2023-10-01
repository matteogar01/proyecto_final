import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.logger.LogBackendType;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.support.ConnectionSource;

import java.util.*;
import java.sql.SQLException;

//pendientes//
//Ordenar por año, marca//


public class config {
    static Dao<Inventario, String> tablaInventario;

    public static void main(String[] args) throws SQLException {
        LoggerFactory.setLogBackendFactory(LogBackendType.NULL);
        Scanner teclado = new Scanner(System.in);
        String url = "jdbc:h2:file:./Concecionarioautos";
        ConnectionSource con = new JdbcConnectionSource(url);
        tablaInventario = DaoManager.createDao(con, Inventario.class);

        int opcion = 0;

        do {
            System.out.println("===== CONCECIONARIO SUPERMOTOS =====");
            System.out.println("1. Ver placas motos");
            System.out.println("2. buscar por placa");
            System.out.println("3. agregar vehiculo");
            System.out.println("4. Buscar por modelo");
            System.out.println("5. buscar por año");
            System.out.println("6. Comprar moto");
            System.out.println("7. Pomocion");
            System.out.println("8. Vehiculo mas antiguo");
            System.out.println("9. Vehiculo mas barato");
            System.out.println("10. Vehiculo mas potente");
            System.out.println("11. ordenar vehiculos");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("las placas de los vehiculos son: ");
                    for (Inventario i : tablaInventario) {
                        System.out.println(i.getPlaca());
                    }
                    break;
            }

            switch (opcion) {
                case 2:
                    System.out.print("ingresa la placa: ");
                    String id = teclado.next();
                    boolean placaEncontrada = false;
                    for (Inventario i : tablaInventario) {
                        if (i.getPlaca().equals(id)) {
                            System.out.println("el vehiculo es Marca " + i.getMarca());
                            System.out.println("Modelo " + i.getModelo());
                            System.out.println("Año " + i.getAño());
                            System.out.println("La moto cuenta con " + i.getEjes() + " Ejes");
                            System.out.println("CC " + i.getCc());
                            System.out.println("Precio " + i.getValor());
                            placaEncontrada = true;
                        }
                    }
                    if (!placaEncontrada) {
                        System.out.println("No se encuentra vehiculo con placas " + id + " en el inventario");
                    }
                    break;
            }

            switch (opcion) {
                case 3:
                    System.out.print("ingrese placa de la moto");
                    String placa = teclado.next();
                    System.out.print("ingrese marca de la moto");
                    String marca = teclado.next();
                    System.out.print("ingrese modelo de la moto");
                    String modelo = teclado.next();
                    System.out.print("ingrese el año de la moto");
                    int año = teclado.nextInt();
                    System.out.print("ingrese el numero de ejes de la moto");
                    int ejes = teclado.nextInt();
                    System.out.print("ingrese el cilindraje de la moto");
                    int cc = teclado.nextInt();
                    System.out.print("ingrese el precio de la moto");
                    int valor = teclado.nextInt();

                    Inventario inventario = new Inventario(placa, marca, modelo, año, ejes, cc, valor);
                    tablaInventario.create(inventario);
                    System.out.println("Moto Agregada con exito! ");
                    break;
            }

            switch (opcion) {
                case 4:
                    System.out.println("ingresar modelo de la moto");
                    String mod = teclado.next();
                    boolean ModeloEncontrado = false;
                    for (Inventario i : tablaInventario) {
                        if (i.getModelo().equals(mod)) {
                            Inventario inventario = tablaInventario.queryForId(i.getPlaca());
                            System.out.println("el vehiculo es Marca " + i.getMarca());
                            System.out.println("Modelo " + i.getModelo());
                            System.out.println("Año " + i.getAño());
                            System.out.println("La moto cuenta con " + i.getEjes() + " Ejes");
                            System.out.println("CC " + i.getCc());
                            System.out.println("Precio " + i.getValor());
                            ModeloEncontrado = true;
                        }
                    }
                    if (!ModeloEncontrado) {
                        System.out.println("No se encuentra vehiculo modelo " + mod + " en el inventario");
                    }
                    break;
            }

            switch (opcion) {
                case 5:
                    System.out.print("ingresa el año: ");
                    int year = teclado.nextInt();
                    boolean AñoEncontrado = false;
                    for (Inventario i : tablaInventario) {
                        if (i.getAño() == year) {
                            Inventario inventario = tablaInventario.queryForId(i.getPlaca());
                            System.out.println("el vehiculo es Marca " + i.getMarca());
                            System.out.println("Modelo " + i.getModelo());
                            System.out.println("Año " + i.getAño());
                            System.out.println("La moto cuenta con " + i.getEjes() + " Ejes");
                            System.out.println("CC " + i.getCc());
                            System.out.println("Precio " + i.getValor());
                            AñoEncontrado = true;
                        }
                    }
                    if (!AñoEncontrado) {
                        System.out.println("No se encuentra vehiculo del año  " + year + " en el inventario");
                    }
                    break;

            }


            switch (opcion) {
                case 6:
                    System.out.print("ingresa la placa: ");
                    String id = teclado.next();
                    if (tablaInventario.idExists(id)) {
                        tablaInventario.deleteById(id);
                        System.out.println("Moto vendida con exito");
                    } else {
                        System.out.println("La moto con placas " + id + " no existe");
                    }
                    break;
            }

            switch (opcion) {
                case 7:
                    System.out.println("Ingrese el valor de los vehiuclos que aplican a la promoción");
                    int promo = teclado.nextInt();
                    for (Inventario i : tablaInventario) {
                        if (i.getValor() >= promo) {
                            Inventario inventario = tablaInventario.queryForId(i.getPlaca());
                            System.out.println("el vehiculo es Marca " + i.getMarca());
                            System.out.println("Modelo " + i.getModelo());
                            System.out.println("Año " + i.getAño());
                            System.out.println("La moto cuenta con " + i.getEjes() + " Ejes");
                            System.out.println("CC " + i.getCc());
                            System.out.println("Precio Anterior" + i.getValor());
                            String fin = String.format("%.1f", i.getValor() * (1 - 0.1));
                            System.out.println("Precio Actual" + (fin));

                        }
                    }
                    break;
            }


            switch (opcion) {
                case 8:
                    Inventario vehiculoMasAntiguo = null;
                    int añoMasAntiguo = Integer.MAX_VALUE;
                    int ref = 2024;

                    for (Inventario i : tablaInventario) {
                        if (i.getAño() <= ref && i.getAño() < añoMasAntiguo) {
                            añoMasAntiguo = i.getAño();
                            vehiculoMasAntiguo = i;
                        }
                    }

                    if (vehiculoMasAntiguo != null) {
                        System.out.println("El vehículo más antiguo es Marca " + vehiculoMasAntiguo.getMarca());
                        System.out.println("Modelo " + vehiculoMasAntiguo.getModelo());
                        System.out.println("Año " + vehiculoMasAntiguo.getAño());
                        System.out.println("La moto cuenta con " + vehiculoMasAntiguo.getEjes() + " Ejes");
                        System.out.println("CC " + vehiculoMasAntiguo.getCc());
                        System.out.println("Precio " + vehiculoMasAntiguo.getValor());
                    } else {
                        System.out.println("No se encontraron vehículos en la lista.");
                    }
                    break;
            }
            switch (opcion) {
                case 9:
                    Inventario vehiculoMasEconomico = null;
                    int PrecioMasBarato = Integer.MAX_VALUE;
                    int ref = 999999999;

                    for (Inventario i : tablaInventario) {
                        if (i.getValor() <= ref && i.getValor() < PrecioMasBarato) {
                            PrecioMasBarato = i.getValor();
                            vehiculoMasEconomico = i;
                        }
                    }

                    if (vehiculoMasEconomico != null) {
                        System.out.println("El vehículo más Economico es Marca " + vehiculoMasEconomico.getMarca());
                        System.out.println("Modelo " + vehiculoMasEconomico.getModelo());
                        System.out.println("Año " + vehiculoMasEconomico.getAño());
                        System.out.println("La moto cuenta con " + vehiculoMasEconomico.getEjes() + " Ejes");
                        System.out.println("CC " + vehiculoMasEconomico.getCc());
                        System.out.println("Precio " + vehiculoMasEconomico.getValor());
                    } else {
                        System.out.println("No se encontraron vehículos en la lista.");
                    }
                    break;
            }
            switch (opcion) {
                case 10:
                    Inventario vehiculoMasPotente = null;
                    int CcMayor = Integer.MIN_VALUE;
                    int ref = 1;

                    for (Inventario i : tablaInventario) {
                        if (i.getCc() >= ref && i.getCc() > CcMayor) {
                            CcMayor = i.getCc();
                            vehiculoMasPotente = i;
                        }
                    }

                    if (vehiculoMasPotente != null) {
                        System.out.println("El vehículo más Potente es Marca " + vehiculoMasPotente.getMarca());
                        System.out.println("Modelo " + vehiculoMasPotente.getModelo());
                        System.out.println("Año " + vehiculoMasPotente.getAño());
                        System.out.println("La moto cuenta con " + vehiculoMasPotente.getEjes() + " Ejes");
                        System.out.println("CC " + vehiculoMasPotente.getCc());
                        System.out.println("Precio " + vehiculoMasPotente.getValor());
                    } else {
                        System.out.println("No se encontraron vehículos en la lista.");
                    }
                    break;
            }
            switch (opcion) {
                case 11:
                    System.out.println("Desea  ordenar  por 1. año  o  por 2. marca");
                    int ordenar = teclado.nextInt();
                    if (ordenar == 1) {
                        System.out.print("Desea  ordenar 1. de menor a mayor "  +"    2.mayor a menor");
                        int mayormenor = teclado.nextInt();
                        if (mayormenor == 1){
                            int ref = 2024;

                            List<Inventario> vehiculosOrdenados = new ArrayList<Inventario>();

                            for (Inventario i : tablaInventario) {
                                if (i.getAño() <= ref) {
                                    vehiculosOrdenados.add(i);
                                }
                            }

                            if (!vehiculosOrdenados.isEmpty()) {
                                Collections.sort(vehiculosOrdenados, new Comparator<Inventario>() {
                                    @Override
                                    public int compare(Inventario i1, Inventario i2) {
                                        return Integer.compare(i1.getAño(), i2.getAño());
                                    }
                                });
                                
                                System.out.println("Vehículos ordenados por antigüedad:");
                                for (Inventario i : vehiculosOrdenados) {
                                    System.out.println("Marca " + i.getMarca());
                                    System.out.println("Modelo " + i.getModelo());
                                    System.out.println("Año " + i.getAño());
                                    System.out.println("La moto cuenta con " + i.getEjes() + " Ejes");
                                    System.out.println("CC " + i.getCc());
                                    System.out.println("Precio " + i.getValor());
                                }
                            } else {
                                System.out.println("No se encontraron vehículos en la lista.");
                            }
                        }
                        if (mayormenor == 2){
                            int ref = 2024;

                            List<Inventario> vehiculosOrdenados = new ArrayList<Inventario>();

                            for (Inventario i : tablaInventario) {
                                if (i.getAño() <= ref) {
                                    vehiculosOrdenados.add(i);
                                }
                            }

                            if (!vehiculosOrdenados.isEmpty()) {
                                Collections.sort(vehiculosOrdenados, new Comparator<Inventario>() {
                                    @Override
                                    public int compare(Inventario i1, Inventario i2) {
                                        return Integer.compare(i2.getAño(), i1.getAño());
                                    }
                                });

                                System.out.println("Vehículos ordenados por antigüedad:");
                                for (Inventario i : vehiculosOrdenados) {
                                    System.out.println("Marca " + i.getMarca());
                                    System.out.println("Modelo " + i.getModelo());
                                    System.out.println("Año " + i.getAño());
                                    System.out.println("La moto cuenta con " + i.getEjes() + " Ejes");
                                    System.out.println("CC " + i.getCc());
                                    System.out.println("Precio " + i.getValor());
                                }
                            } else {
                                System.out.println("No se encontraron vehículos en la lista.");
                            }
                        }
                    }
                    if(ordenar == 2){
                        List<Inventario> vehiculosOrdenados = new ArrayList<>();

                        for (Inventario i : tablaInventario) {
                            if (i.getAño() <= i.getAño()) {
                                vehiculosOrdenados.add(i);
                            }
                        }
                        if (!vehiculosOrdenados.isEmpty()) {
                            Collections.sort(vehiculosOrdenados, new Comparator<Inventario>() {
                                @Override
                                public int compare(Inventario i1, Inventario i2) {
                                    return i1.getMarca().compareTo(i2.getMarca());
                                }
                            });

                            System.out.println("Vehículos ordenados por marca (en orden alfabético):");
                            for (Inventario i : vehiculosOrdenados) {
                                System.out.println("Marca " + i.getMarca());
                                System.out.println("Modelo " + i.getModelo());
                                System.out.println("Año " + i.getAño());
                                System.out.println("La moto cuenta con " + i.getEjes() + " Ejes");
                                System.out.println("CC " + i.getCc());
                                System.out.println("Precio " + i.getValor());
                            }
                        } else {
                            System.out.println("No se encontraron vehículos en la lista.");
                        }
                    }
                    break;
            }
        }
            while (opcion != 0) ;
    }
}