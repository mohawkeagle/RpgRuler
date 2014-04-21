package br.com.rpgruler.main.view.armor.bean;

import br.com.rpgruler.data.db.dao.ArmorDAO;
import br.com.rpgruler.data.db.dao.ArmorTypeDAO;
import br.com.rpgruler.data.db.dao.MaterialsDAO;
import br.com.rpgruler.data.entitity.Armor;
import br.com.rpgruler.main.object.BeanEvent;
import br.com.rpgruler.main.view.armor.ArmorView;
import br.com.rpgruler.main.view.armor.dialog.ArmorDialog;
import br.com.rpgruler.main.view.bean.ViewBean;

/**
 * Bean de controle para tela de armaduras
 *
 * @author kaciano
 * @version 1.0
 */
public class ArmorBean extends ViewBean<ArmorView> {

    private ArmorTypeDAO armorTypeDAO;
    private MaterialsDAO materialsDAO;
    private ArmorDAO armorDAO;

    /**
     * Cria nova instancia de ArmorBean
     *
     * @param view <code>ArmorView</code> Tela de armaduras
     */
    public ArmorBean(ArmorView view) {
        super(view);
        this.armorTypeDAO = new ArmorTypeDAO();
        this.materialsDAO = new MaterialsDAO();
        this.armorDAO = new ArmorDAO();
    }

    @Override
    public void save(BeanEvent evt) throws Exception {
        armorDAO.replaceAll(getView().getModel().getData());
    }

    @Override
    public void load(BeanEvent evt) throws Exception {

    }

    @Override
    public void add(BeanEvent evt) throws Exception {
        getView().getModel().add((Armor) evt.getValue());
    }

    @Override
    public void edit(BeanEvent evt) throws Exception {
        if (getView().getTable().getSelectedRowCount() > 0) {
            Integer row = (Integer) getView().getTable().getSelectedRows()[0];
            ArmorDialog dialog = new ArmorDialog(getView(), getView().getModel().getObject(row), true);
            if (dialog.getArmor() != null) {
                getView().getModel().update(row, dialog.getArmor());
            }
        }
    }

    /**
     * Retorna o DAO de controle dos tipos de armadura
     *
     * @return <code>ArmorTypeDAO</code> DAO de ArmorType
     */
    public ArmorTypeDAO getArmorTypeDAO() {
        return armorTypeDAO;
    }

    /**
     * Retorna o DAO de controle das matérias primas
     *
     * @return <code>MaterialsDAO</code> DAO de PrimeMaterial
     */
    public MaterialsDAO getMaterialsDAO() {
        return materialsDAO;
    }

    /**
     * Procura pelo próximo ID
     *
     * @return <code>Integer</code> Próximo ID
     */
    public Long getNextID() {
        Long id = (long) 0;
        for (Armor type : getView().getModel().getData()) {
            if (type.getId() > id) {
                id = type.getId();
            }
        }
        return (id + 1);
    }
}