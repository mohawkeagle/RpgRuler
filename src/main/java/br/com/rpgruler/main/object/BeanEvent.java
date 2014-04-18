package br.com.rpgruler.main.object;

import br.com.rpgruler.main.view.object.ViewWrapper;

/**
 * Evento de transporte de dados
 *
 * @author kaciano
 */
public class BeanEvent {

    private Object frame;
    private Object value;
    private ViewWrapper wrapper;

    /**
     * Cria nova instancia de BeanEvent
     *
     * @param wrapper <code>ViewWrapper</code> Objeto de transporte
     */
    public BeanEvent(ViewWrapper wrapper) {
        this.wrapper = wrapper;
    }

    /**
     * Cria nova instancia de BeanEvent
     *
     * @param frame <code>Object</code> Tela que carregou o evento
     * @param value <code>Object</code> Objeto transportado
     */
    public BeanEvent(Object frame, Object value) {
        this.frame = frame;
        this.value = value;
    }

    /**
     * Retorna o frame
     *
     * @return <code>Object</code> Frame
     */
    public Object getFrame() {
        return frame;
    }

    /**
     * Modifica o frame
     *
     * @param frame <code>Object</code> Frame
     */
    public void setFrame(Object frame) {
        this.frame = frame;
    }

    /**
     * Retorna o valor transportado
     *
     * @return <code>Object</code> Valor transportado
     */
    public Object getValue() {
        return value;
    }

    /**
     * Modifica o valor transportado
     *
     * @param value <code>Object</code> Valor transportado
     */
    public void setValue(Object value) {
        this.value = value;
    }

    /**
     * Retorna o objeto de transporte
     *
     * @return <code>ViewWrapper</code> Objeto de transporte
     */
    public ViewWrapper getWrapper() {
        return wrapper;
    }

    /**
     * Modifica o objeto de transporte
     *
     * @param wrapper <code>ViewWrapper</code> Objeto de transporte
     */
    public void setWrapper(ViewWrapper wrapper) {
        this.wrapper = wrapper;
    }

}
