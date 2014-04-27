package br.com.rpgruler.main.util;

/**
 * Classe utilitária para gerar descrições de telas
 *
 * @author kaciano
 */
public class Description {

    private String title;
    private String description;
    private String save;
    private String procces;
    private String clear;
    private String load;
    private final String base = "<html>"
            + "<body style='margin: 10px'>"
            + "<b>%1$2s</b><br><br>"
            + "%2$2s<br><br>"
            + "Funções<br><br>"
            + "        <table border=\"1\">"
            + "            <thead>"
            + "                <tr>"
            + "                    <th>Função</th>"
            + "                    <th>Ação</th>"
            + "                </tr>"
            + "            </thead>"
            + "            <tbody>"
            + "                <tr>"
            + "                    <td><b>F2</b> - Salvar</td>"
            + "                    <td>%3$2s</td>"
            + "                </tr>"
            + "                <tr>"
            + "                    <td><b>F6</b> - Processar</td>"
            + "                    <td>%4$2s</td>"
            + "                </tr>"
            + "                <tr>"
            + "                    <td><b>F4</b> - Limpar</td>"
            + "                    <td>%5$2s</td>"
            + "                </tr>"
            + "                <tr>"
            + "                    <td><b>F8</b> - Carregar</td>"
            + "                    <td>%6$2s</td>"
            + "                </tr>"
            + "            </tbody>"
            + "        </table>"
            + "</body>"
            + "</html>";

    /**
     * Cria nova instancia de Description
     */
    public Description() {
        this.title = "--";
        this.description = "--";
        this.save = "--";
        this.procces = "--";
        this.clear = "--";
        this.load = "--";
    }

    /**
     * Cria nova instancia de Description
     *
     * @param title <code>String</code> Texto do titulo
     * @param description <code>String</code> Texto da descrição
     * @param save <code>String</code> Texto da função de salvar
     * @param procces <code>String</code> Texto da função de processar
     * @param clear <code>String</code> Texto da função de limpar
     * @param load <code>String</code> Texto da função de carregar
     */
    public Description(String title, String description, String save, String procces, String clear, String load) {
        this.title = title;
        this.description = description;
        this.save = save;
        this.procces = procces;
        this.clear = clear;
        this.load = load;
    }

    /**
     * Retorna a descrição formatada da view
     *
     * @return <code>String</code> Descrição formatada da view
     */
    public String format() {
        return String.format(base, title, description, save, procces, clear, load);
    }

    /**
     * Retorna o Texto do titulo
     *
     * @return <code>String</code> Texto do titulo
     */
    public String getTitle() {
        return title;
    }

    /**
     * Modifica o Texto do titulo
     *
     * @param title <code>String</code> Texto do titulo
     * @return <code>Description</code> Construtor de descrição
     */
    public Description setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * Retorna o Texto da descrição
     *
     * @return <code>String</code> Texto da descrição
     */
    public String getDescription() {
        return description;
    }

    /**
     * Modifica o Texto da descrição
     *
     * @param description <code>String</code> Texto da descrição
     * @return <code>Description</code> Construtor de descrição
     */
    public Description setDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Retorna o Texto da função de salvar
     *
     * @return <code>String</code> Texto da função de salvar
     */
    public String getSave() {
        return save;
    }

    /**
     * Modifica o Texto da função de salvar
     *
     * @param save <code>String</code> Texto da função de salvar
     * @return <code>Description</code> Construtor de descrição
     */
    public Description setSave(String save) {
        this.save = save;
        return this;
    }

    /**
     * Retorna o Texto da função de processar
     *
     * @return <code>String</code> Texto da função de processar
     */
    public String getProcces() {
        return procces;
    }

    /**
     * Modifica o Texto da função de processar
     *
     * @param procces <code>String</code> Texto da função de processar
     * @return <code>Description</code> Construtor de descrição
     */
    public Description setProcces(String procces) {
        this.procces = procces;
        return this;
    }

    /**
     * Retorna o Texto da função de limpar
     *
     * @return <code>String</code> Texto da função de limpar
     */
    public String getClear() {
        return clear;
    }

    /**
     * Modifica o Texto da função de limpar
     *
     * @param clear <code>String</code> Texto da função de limpar
     * @return <code>Description</code> Construtor de descrição
     */
    public Description setClear(String clear) {
        this.clear = clear;
        return this;
    }

    /**
     * Retorna o Texto da função de carregar
     *
     * @return <code>String</code> Texto da função de carregar
     */
    public String getLoad() {
        return load;
    }

    /**
     * Modifica o Texto da função de carregar
     *
     * @param load <code>String</code> Texto da função de carregar
     * @return <code>Description</code> Construtor de descrição
     */
    public Description setLoad(String load) {
        this.load = load;
        return this;
    }

}
