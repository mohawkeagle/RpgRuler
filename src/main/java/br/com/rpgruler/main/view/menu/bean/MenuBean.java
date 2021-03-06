package br.com.rpgruler.main.view.menu.bean;

import br.com.gmp.utils.collections.Triad;
import br.com.rpgruler.data.db.dao.MenuDAO;
import br.com.rpgruler.data.entitity.Menu;
import br.com.rpgruler.main.object.BeanEvent;
import br.com.rpgruler.main.util.MenuBuilder;
import br.com.rpgruler.main.view.bean.ViewBean;
import br.com.rpgruler.main.view.menu.MenuView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

/**
 * Bean de controle para a View de menus
 *
 * @author kaciano
 * @version 1.0
 */
public class MenuBean extends ViewBean<MenuView> {

    private MenuDAO dao;

    /**
     * Cria nova instancia de MenuBean
     *
     * @param view <code>MenuView</code> Tela
     */
    public MenuBean(MenuView view) {
        super(view);
        this.dao = new MenuDAO();
        getView().getIconModel().setData(getMenuIcons());
        getView().getParentModel().setData(getParentMenus());
        buildPreview();
    }

    @Override
    public void save(BeanEvent evt) throws Exception {
        this.dao.deleteAll();
        this.dao.insertAll(getView().getModel().getData());
    }

    @Override
    public void load(BeanEvent evt) throws Exception {
        getView().getIconModel().setData(getMenuIcons());
        getView().getParentModel().setData(getParentMenus());
    }

    @Override
    public void process(BeanEvent evt) throws Exception {
        buildPreview();
    }

    /**
     * Constroi os dados no menu de pré-visualização
     */
    private void buildPreview() {
        new MenuBuilder(getView().getMainScreen(), getView().getRoot())
                .buildMenu(getView().getModel().getData());
    }

    /**
     * Constroi um objeto do tipo Menu
     *
     * @return <code>Menu</code> Menu gerado
     */
    private Menu buildNew(String title, String icon, Long parent) {
        Menu menu = new Menu();
        menu.setId(getNextID());
        menu.setTitle(title);
        menu.setParent(parent);
        menu.setIcon(icon);
        return menu;
    }

    /**
     * Adiciona novo item na tabela
     *
     * @param evt <code>BeanEvent</code> Evento do Bean
     */
    public void add(BeanEvent evt) {
        Triad<String, Integer, Long> triad = (Triad<String, Integer, Long>) evt.getValue();
        String title = triad.getFirst();
        String icon = getIcons()[triad.getSecond()];
        Long parent = triad.getThird();
        Menu menu = buildNew(title, icon, parent);
        getView().getModel().add(menu);
        getView().getParentModel().setData(getParentMenus());
        buildPreview();
        getView().refresh();
    }

    /**
     * Retorna o próximo ID da lista
     *
     * @return <code>Long</code> Próximo ID
     */
    public Long getNextID() {
        Long id = (long) 0;
        for (Menu menu : getView().getModel().getData()) {
            if (id < menu.getId()) {
                id = menu.getId();
            }
        }
        return (id + 1);
    }

    /**
     * Retorna um array com os icones possiveis para menus
     *
     * @return <code>ImageIcon[]</code> Array de iconess
     */
    private ImageIcon[] getMenuIcons() {
        List<ImageIcon> icons = new ArrayList<>();
        for (String icon : getIcons()) {
            icons.add(new ImageIcon(getClass().getResource(icon)));
        }
        return icons.toArray(new ImageIcon[]{});
    }

    /**
     * Retorna os nomes dos icones
     *
     * @return <code>String[]</code> Nomes dos icones
     */
    private String[] getIcons() {
        String path = "/RpgIcons/misc/";
        List<String> list = new ArrayList<>();
        File dir = new File(getClass().getResource(path).getFile());
        for (File file : dir.listFiles()) {
            list.add(path + file.getName());
        }
        return list.toArray(new String[]{});
    }

    /**
     * Retorna lista de menus superiores
     *
     * @return <code>List(Menu)</code>
     */
    private List<Menu> getParentMenus() {
        List<Menu> parents = new ArrayList<>();
        parents.add(new Menu((long) 0, "Raiz", null));
        getView().getModel().getData().stream().forEach((menu) -> {
            parents.add(menu);
        });
        return parents;
    }

}
