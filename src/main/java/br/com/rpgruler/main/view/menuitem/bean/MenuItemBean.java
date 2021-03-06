package br.com.rpgruler.main.view.menuitem.bean;

import br.com.rpgruler.data.db.dao.MenuDAO;
import br.com.rpgruler.data.entitity.Menu;
import br.com.rpgruler.data.entitity.MenuItem;
import br.com.rpgruler.main.object.BeanEvent;
import br.com.rpgruler.main.view.bean.ViewBean;
import br.com.rpgruler.main.view.object.ViewWrapper;
import br.com.rpgruler.main.view.menuitem.MenuItemView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

/**
 * Bean de controle para tela de cadastro de itens de menu
 *
 * @author kaciano
 * @version 1.0
 */
public class MenuItemBean extends ViewBean<MenuItemView> {

    /**
     * Cria nova instancia de MenuItemBean
     *
     * @param view <code>MenuItemView</code> View dos itens de menu
     */
    public MenuItemBean(MenuItemView view) {
        super(view);
        getView().getParentModel().setData(getParentMenus());
        getView().getIconModel().setData(getItemIcons());
    }

    /**
     * Adiciona novo item na tabela
     *
     * @param evt <code>BeanEvent</code> Evento do bean
     */
    public void add(BeanEvent evt) {
        ViewWrapper vw = (ViewWrapper) evt.getValue();
        String title = (String) vw.getValue(0);
        Integer icon = (Integer) vw.getValue(1);
        String itemClass = (String) vw.getValue(2);
        Long menu = ((Menu) vw.getValue(3)).getId();
        MenuItem item = buildNew(title, icon, itemClass, menu);
        getView().getModel().add(item);
    }

    /**
     * Constroi novo MenuItem a partir dos dados recebidos
     *
     * @param title <code>String</code> Titulo do item
     * @param icon <code>Integer</code> Indice do icone
     * @param itemClass <code>String</code> Classe do Item
     * @param menu <code>Long</code> ID do menu do item
     * @return <code>MenuItem</code> Item de menu construido
     */
    public MenuItem buildNew(String title, Integer icon, String itemClass, Long menu) {
        Long id = getNextID();
        return new MenuItem(id, menu, itemClass, title, getIcons()[icon]);
    }

    /**
     * Retorna um array com os icones possiveis para menus
     *
     * @return <code>ImageIcon[]</code> Array de iconess
     */
    private ImageIcon[] getItemIcons() {
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
        new MenuDAO().getList().stream().forEach((menu) -> {
            parents.add(menu);
        });
        return parents;
    }

    /**
     * Retorna o próximo ID da lista
     *
     * @return <code>Long</code> Próximo ID
     */
    public Long getNextID() {
        Long id = (long) 0;
        for (MenuItem menu : getView().getModel().getData()) {
            if (id < menu.getId()) {
                id = menu.getId();
            }
        }
        return (id + 1);
    }
}
