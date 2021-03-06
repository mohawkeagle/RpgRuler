package br.com.rpgruler.main.bean;

import br.com.rpgruler.main.MainScreen;
import br.com.rpgruler.main.interfaces.MainListener;
import br.com.rpgruler.main.object.BeanEvent;
import br.com.rpgruler.main.view.View;
import br.com.rpgruler.main.view.object.ViewParameter;
import java.awt.Component;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

/**
 * Bean de controle da tela principal
 *
 * @author kaciano
 */
public class MainScreenBean implements MainListener {

    private View actualView;
    private final MainScreen screen;

    /**
     * Cria nova instancia de MainScreenBean
     *
     * @param mainScreen <code>MainScreen</code>
     */
    public MainScreenBean(MainScreen mainScreen) {
        this.screen = mainScreen;
    }

    @Override
    public void save(BeanEvent evt) {
        if (getActualView() != null) {
            getActualView().save();
        }
    }

    @Override
    public void process(BeanEvent evt) {
        if (getActualView() != null) {
            getActualView().process();
        }
    }

    @Override
    public void clear(BeanEvent evt) {
        if (getActualView() != null) {
            getActualView().clear();
        }
    }

    @Override
    public void load(BeanEvent evt) {
        if (getActualView() != null) {
            getActualView().load();
        }
    }

    @Override
    public View getActualView() {
        return actualView;
    }

    @Override
    public void setActualView(View view) {
        this.actualView = view;
        this.screen.setControls(new ViewParameter(
                this.actualView.canSave() != null ? actualView.canSave() : false,
                this.actualView.canProcces() != null ? actualView.canProcces() : false,
                this.actualView.canClear() != null ? actualView.canClear() : false,
                this.actualView.canLoad() != null ? actualView.canLoad() : false
        ));
        System.out.println("View ativa: " + actualView.getClass().getSimpleName());
    }

    @Override
    public void clear() {
        if (screen.getDesktop().getComponentCount() == 0) {
            this.screen.setControls(new ViewParameter(false, false, false, false));
        }
    }

    @Override
    public void insertView(View view) {
        if (!isOnDesktop(view)) {
            for (Component c : screen.getDesktop().getComponents()) {
                if (c instanceof JInternalFrame) {
                    try {
                        JInternalFrame jif = (JInternalFrame) c;
                        jif.setSelected(false);
                    } catch (PropertyVetoException ex) {
                        Logger.getLogger(MainScreenBean.class.getName())
                                .log(Level.SEVERE, null, ex);
                    }
                }
            }
            try {
                screen.getDesktop().add(view);
                screen.getDesktop().setLayer(view,
                        JDesktopPane.FRAME_CONTENT_LAYER);
                screen.getDesktop().setSelectedFrame(view);
                view.setSelected(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(MainScreenBean.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("View já está aberta");
        }
    }

    /**
     * Verifica se a View já está na tela
     *
     * @param view View
     * @return Boolean Está na tela?
     */
    private Boolean isOnDesktop(JInternalFrame view) {
        boolean indesktop = false;
        for (Component c : screen.getDesktop().getComponents()) {
            if (c instanceof JInternalFrame) {
                JInternalFrame jif = (JInternalFrame) c;
                if (jif.getTitle().equals(view.getTitle())) {
                    indesktop = true;
                    break;
                }
            }
        }
        return indesktop;
    }

    /**
     * Remove todos os frames da tela principal
     */
    public void clearDesktop() {
        screen.getDesktop().removeAll();
    }

}
