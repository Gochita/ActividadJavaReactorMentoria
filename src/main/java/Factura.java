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

    Factura(String descripcion, int importe, int codigoFactura,int cantidadProd, LocalDate fecha) {
        this.descripcion = descripcion;
        this.importe = importe;
        this.codigoFactura=codigoFactura;
        this.cantidadProd=cantidadProd;
        this.fecha=fecha;
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
        return "Factura{" +
                "descripcion='" + descripcion + '\'' +
                ", importe=" + importe +
                ", codigoFactura=" + codigoFactura +
                ", cantidadProd=" + cantidadProd +
                ", fecha=" + fecha +
                '}';
    }

    public static void main(String[] args) {
        // registros de la data
        Factura f = new Factura("ordenador", 1000, 123,1,LocalDate.now());
        Factura f2 = new Factura("movil", 300,456,2,LocalDate.now());
        Factura f3 = new Factura("imporesora", 200,789,1,LocalDate.now());
        Factura f4 = new Factura("imac", 1500,101,2,LocalDate.now());

        // generar una lista
        List<Factura> lista = new ArrayList<Factura>();

        // agregar los productos de la factura
        lista.add(f);
        lista.add(f2);
        lista.add(f3);
        lista.add(f4);


        // filtraje funcional con streams
        Factura facturaFiltroCostoImporte = lista.stream()
                .filter(elemento -> elemento.getImporte() > 300)
                .findFirst()
                .get();
       System.out.println(facturaFiltroCostoImporte.getImporte());



        //------------------------------------------------------------------------------------------------------------
        //filtraje por cantidadProductos especifico
        List<Factura> facturaFiltroCantidad= lista.stream()
                .filter(elemento -> elemento.getCantidadProd() == 2)
                        .collect(Collectors.toList());
        if(facturaFiltroCantidad.isEmpty()){
            System.out.println("No se encontro ninguno");
        }
       facturaFiltroCantidad.forEach(System.out::println);

        //filtraje por cantidadProductos mayor a
        List<Factura> facturaFiltroCantidadMayor= lista.stream()
                .filter(elemento -> elemento.getCantidadProd() > 1)
                .collect(Collectors.toList());
                if(facturaFiltroCantidadMayor.isEmpty()){
                    System.out.println("No se encontro ninguno");
                }
               facturaFiltroCantidadMayor.forEach(System.out::println);

        //filtraje por cantidadProductos menor a
        List<Factura> facturaFiltroCantidadMenor= lista.stream()
                .filter(elemento -> elemento.getCantidadProd() < 1)
                .collect(Collectors.toList());
        if(facturaFiltroCantidadMayor.isEmpty()){
            System.out.println("No se encontro ninguno");
        }
        facturaFiltroCantidadMenor.forEach(System.out::println);




        //------------------------------------------------------------------------------------------------------------


        //Filtraje por codigo de factura especifico
        Factura facturaFiltroCodigo= lista.stream()
                .filter(elemento -> elemento.getCodigoFactura()==123)
                .findAny().get();
        //System.out.println(facturaFiltroCodigo);




    }



}


