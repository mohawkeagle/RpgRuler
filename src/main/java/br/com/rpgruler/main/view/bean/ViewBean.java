package br.com.rpgruler.main.view.bean;

import br.com.rpgruler.main.object.BeanEvent;
import br.com.rpgruler.main.view.interfaces.BeanListener;

/**
 * Bean padrão para implementação de ViewBeans
 *
 * @author kaciano
 * @version 1.0
 * @param <T>
 */
public class ViewBean<T> implements BeanListener<T> {

    private final T view;

    /**
     * Cria nova instancia de DefaultViewBean
     *
     * @param view <code>DefaultView</code> View do bean
     * @see br.com.rpgruler.main.view.generic.DefaultView
     */
    public ViewBean(T view) {
        this.view = view;
    }

    @Override
    public void save(BeanEvent evt) throws Exception {
        System.out.println("Save not implemented yet.");
    }

    @Override
    public void process(BeanEvent evt) throws Exception {
        System.out.println("Process not implemented yet.");
    }

    @Override
    public void clear(BeanEvent evt) throws Exception {
        System.out.println("Clear not implemented yet.");
    }

    @Override
    public void load(BeanEvent evt) throws Exception {
        System.out.println("Load not implemented yet.");
    }

    @Override
    public T getView() {
        return view;
    }

}
