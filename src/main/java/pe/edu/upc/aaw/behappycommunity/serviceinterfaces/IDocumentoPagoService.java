package pe.edu.upc.aaw.behappycommunity.serviceinterfaces;

import pe.edu.upc.aaw.behappycommunity.entities.DocumentoPago;

import java.util.List;

public interface IDocumentoPagoService {
    public void insert(DocumentoPago documentoPago);
    public List<DocumentoPago>list();
    public void delete(int idDocumentoPago);
    //HU44	Visualizar el mes con mayor deuda
    List<Object[]> MesMayorDeuda(int condomino);
    //HU45	Visualizar el monto total de deudas por cada mes
    List<Object[]> DeudaMes(int condomino);
    public DocumentoPago listarId(int IdDocumentoPago);

}
