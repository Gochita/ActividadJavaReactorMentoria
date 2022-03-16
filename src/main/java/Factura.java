import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


// clase factura
class Factura {
    String descripcion;
    int importe;
    int codigoFactura;
    int cantidadProd;
    LocalDate fecha;

    Factura(String descripcion, int importe, int codigoFactura, int cantidadProd, LocalDate fecha) {
        this.descripcion = descripcion;
        this.importe = importe;
        this.codigoFactura = codigoFactura;
        this.cantidadProd = cantidadProd;
        this.fecha = fecha;
    }

    int getImporte() {
        return importe;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCodigoFactura() {
        return codigoFactura;
    }

    public int getCantidadProd() {
        return cantidadProd;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "Factura[" +
                "descripcion: '" + descripcion + '\'' +
                ", importe: " + importe +
                ", codigoFactura: " + codigoFactura +
                ", cantidadProd: " + cantidadProd +
                ", fecha: " + fecha +
                ']';
    }

    public static void main(String[] args) {
        // registros de la data
        Factura f = new Factura("laptop", 1000, 123, 1, LocalDate.of(2020, 11, 27));
        Factura f2 = new Factura("headset-HYPERX", 300, 456, 2, LocalDate.of(2020, 7, 20));
        Factura f3 = new Factura("alexa-mini", 200, 789, 1, LocalDate.of(2022, 1, 3));
        Factura f4 = new Factura("rubix", 1500, 101, 2, LocalDate.of(2021, 11, 2));

        // generar una lista
        List<Factura> lista = new ArrayList<Factura>();

        // agregar los productos de la factura
        lista.add(f);
        lista.add(f2);
        lista.add(f3);
        lista.add(f4);


        // filtraje funcional con streams
        List<Factura> facturaFiltroCostoImporteMayor = lista.stream()
                .filter(elemento -> elemento.getImporte() > 300)
                .collect(Collectors.toList());
        if (facturaFiltroCostoImporteMayor.isEmpty()) {
            System.out.println("No se encontro ninguno");
        }
        facturaFiltroCostoImporteMayor.forEach(System.out::println);

        List<Factura> facturaFiltroCostoImporteMenor = lista.stream()
                .filter(elemento -> elemento.getImporte() < 300)
                .collect(Collectors.toList());
        if (facturaFiltroCostoImporteMenor.isEmpty()) {
            System.out.println("No se encontro ninguno");
        }
        facturaFiltroCostoImporteMenor.forEach(System.out::println);

        List<Factura> facturaFiltroCostoImporteIgual = lista.stream()
                .filter(elemento -> elemento.getImporte() == 300)
                .collect(Collectors.toList());
        if (facturaFiltroCostoImporteIgual.isEmpty()) {
            System.out.println("No se encontro ninguno");
        }
        facturaFiltroCostoImporteIgual.forEach(System.out::println);

        //------------------------------------------------------------------------------------------------------------


        //filtraje por cantidadProductos especifico
        List<Factura> facturaFiltroCantidad = lista.stream()
                .filter(elemento -> elemento.getCantidadProd() == 2)
                .collect(Collectors.toList());
        if (facturaFiltroCantidad.isEmpty()) {
            System.out.println("No se encontro ninguno");
        }
        facturaFiltroCantidad.forEach(System.out::println);

        //filtraje por cantidadProductos mayor a
        List<Factura> facturaFiltroCantidadMayor = lista.stream()
                .filter(elemento -> elemento.getCantidadProd() > 1)
                .collect(Collectors.toList());
        if (facturaFiltroCantidadMayor.isEmpty()) {
            System.out.println("No se encontro ninguno");
        }
        facturaFiltroCantidadMayor.forEach(System.out::println);

        //filtraje por cantidadProductos menor a
        List<Factura> facturaFiltroCantidadMenor = lista.stream()
                .filter(elemento -> elemento.getCantidadProd() < 1)
                .collect(Collectors.toList());
        if (facturaFiltroCantidadMayor.isEmpty()) {
            System.out.println("No se encontro ninguno");
        }
        facturaFiltroCantidadMenor.forEach(System.out::println);


        //------------------------------------------------------------------------------------------------------------


        //Filtraje por codigo de factura especifico
        Factura facturaFiltroCodigo = lista.stream()
                .filter(elemento -> elemento.getCodigoFactura() == 123)
                .findAny().get();
        System.out.println(facturaFiltroCodigo);


        //---------------------------------------------------------------------------------------------------------

        //Filtraje por fecha igual a una fecha

        List<Factura> filtrarPorFechaIgual = lista.stream()
                .filter(elemento -> elemento.getFecha().equals(LocalDate.of(2020, 11, 27)))
                .collect(Collectors.toList());
        if (filtrarPorFechaIgual.isEmpty()) {
            System.out.println("No se factura con esa fecha");
        }

        filtrarPorFechaIgual.forEach(System.out::println);

        //Filtrar por fecha despues de
        List<Factura> filtrarPorFechaMayor = lista.stream()
                .filter(elemento -> elemento.getFecha().isAfter(LocalDate.of(2020, 11, 27)))
                .collect(Collectors.toList());
        if (filtrarPorFechaMayor.isEmpty()) {
            System.out.println("No se factura con esa fecha");
        }

        filtrarPorFechaMayor.forEach(System.out::println);


        //Filtrar por fecha antes de
        List<Factura> filtrarPorFechaMenor= lista.stream()
                .filter(elemento -> elemento.getFecha().isBefore(LocalDate.of(2022, 11, 27)))
                .collect(Collectors.toList());
        if (filtrarPorFechaMenor.isEmpty()) {
            System.out.println("No se factura con esa fecha");
        }

        filtrarPorFechaMenor.forEach(System.out::println);


    }


}


