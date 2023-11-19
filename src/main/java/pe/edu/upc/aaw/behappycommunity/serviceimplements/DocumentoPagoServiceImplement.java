package pe.edu.upc.aaw.behappycommunity.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.behappycommunity.entities.DocumentoPago;
import pe.edu.upc.aaw.behappycommunity.repositories.IDocumentoPagoRepository;
import pe.edu.upc.aaw.behappycommunity.serviceinterfaces.IDocumentoPagoService;

import java.util.List;

@Service
public class DocumentoPagoServiceImplement implements IDocumentoPagoService {
   @Autowired
    private IDocumentoPagoRepository dR;
    //HU26: Registrar documento de pago
    @Override
    public void insert(DocumentoPago documentoPago) {
        dR.save(documentoPago);
    }

    @Override
    public List<DocumentoPago> list() {
        return dR.findAll();
    }

    @Override
    public void delete(int idDocumentoPago) {
        dR.deleteById(idDocumentoPago);
    }

    //HU44	Visualizar el mes con mayor deuda
    @Override
    public List<Object[]> MesMayorDeuda(String nombreusuario) {
        return dR.MesMayorDeuda(nombreusuario);
    }

    @Override
    public List<Object[]> DeudaMes( String nombreusuario) {
        return dR.DeudaMes( nombreusuario);
    }




    @Override
    public DocumentoPago listarId(int IdDocumentoPago) {
        return dR.findById(IdDocumentoPago).orElse(new DocumentoPago());
    }

    @Override
    public List<DocumentoPago> findDocumentoAR(String nombre_usuario) {
        return dR.findDocumentoAR(nombre_usuario);
    }

    @Override
    public List<DocumentoPago> findDocumentoR(String nombre_usuario) {
        return dR.findDocumentoR(nombre_usuario);
    }

    @Override
    public List<DocumentoPago> findDocumentoRD(String nombre_usuario) {
        return dR.findDocumentoRD(nombre_usuario);
    }


    //HU28: Visualizar pagos pendientes (vecino)
}
