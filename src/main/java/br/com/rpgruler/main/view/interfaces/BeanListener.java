package br.com.rpgruler.main.view.interfaces;

import br.com.rpgruler.main.object.BeanEvent;

/**
 *
 * @author kaciano
 * @param <T>
 */
public interface BeanListener<T> {

    /**
     * Metodo padrão para salvar
     *
     * @param evt <code>BeanEvent</code> Evento
     * @throws java.lang.Exception Exceção
     * @see br.com.rpgruler.main.view.generic.DefaultView#save()
     */
    void save(BeanEvent evt) throws Exception;

    /**
     * Metodo padrão para processar os dados
     *
     * @param evt <code>BeanEvent</code> Evento
     * @throws java.lang.Exception Exceção
     * @see br.com.rpgruler.main.view.generic.DefaultView#process()
     */
    void process(BeanEvent evt) throws Exception;

    /**
     * Metodo padrão para limpar a tela
     *
     * @param evt <code>BeanEvent</code> Evento
     * @throws java.lang.Exception Exceção
     * @see br.com.rpgruler.main.view.generic.DefaultView#clear()
     */
    void clear(BeanEvent evt) throws Exception;

    /**
     * Metodo padrão para carregar a tela
     *
     * @param evt <code>BeanEvent</code> Evento
     * @throws java.lang.Exception Exceção
     * @see br.com.rpgruler.main.view.generic.DefaultView#load()
     */
    void load(BeanEvent evt) throws Exception;

    /**
     * Retorna a view do bean
     *
     * @return <code>T</code> View do bean
     */
    T getView();
}
