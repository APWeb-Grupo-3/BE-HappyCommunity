package pe.edu.upc.aaw.behappycommunity.serviceinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.aaw.behappycommunity.entities.DocumentoPago;

import java.util.List;

public interface IDocumentoPagoService {
    public void insert(DocumentoPago documentoPago);
    public List<DocumentoPago>list();
    public void delete(int idDocumentoPago);
    //HU44	Visualizar el mes con mayor deuda
    List<Object[]> MesMayorDeuda(String nombreusuario);
    //HU45	Visualizar el monto total de deudas por cada mes
    List<Object[]> DeudaMes(String nombreusuario);
    public DocumentoPago listarId(int IdDocumentoPago);
    public List<DocumentoPago>findDocumentoAR(String nombre_usuario);
    public List<DocumentoPago>findDocumentoR(String nombre_usuario);
    public List<DocumentoPago>findDocumentoRD(String nombre_usuario);


}
