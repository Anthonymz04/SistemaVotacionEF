package controller;
import java.util.ArrayList;
import java.util.List;
import model.Mesa;

public class ControladorMesas {
    private List<Mesa> mesas;

    public ControladorMesas() {
        mesas = new ArrayList<>();
    }

    public void agregarMesa(Mesa mesa) {
        mesas.add(mesa);
    }

    public List<Mesa> obtenerMesas() {
        return mesas;
    }

    public Mesa obtenerMesaPorId(Long id) {
        for (Mesa mesa : mesas) {
            if (mesa.getId().equals(id)) {
                return mesa;
            }
        }
        return null;
    }
}
