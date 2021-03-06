package br.com.rpgruler.data.db;

import br.com.rpgruler.data.db.interfaces.DAO;
import br.com.gmp.utils.object.ObjectCopy;
import br.com.rpgruler.data.db.map.EntityMap;
import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import java.io.File;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO Genérico para embasamento
 *
 * @author kaciano
 * @version 1.0
 * @param <T> Classe de entidade
 */
public class GenericDAO<T> implements DAO<T> {

    private Class<T> objectClass;
    private String prefix = "db/";
    private String database;
    private String sufix = ".yap";

    /**
     * Cria nova instancia de GenericDAO
     */
    public GenericDAO() {
        this.objectClass = (Class<T>) ((ParameterizedType) (getClass()
                .getGenericSuperclass())).getActualTypeArguments()[0];
        this.database = prefix + (new EntityMap().getMap().get(objectClass)) + sufix;
        File file = new File("db");
        if (!file.exists()) {
            file.mkdir();
        }
    }

    /**
     * Retorna a conexão com o banco de dados para buscas externas
     *
     * @return <code>ObjectContainer</code> Conexão com o banco
     */
    @Override
    public ObjectContainer getDB() {
        return Db4o.openFile(database);
    }

    /**
     * Busca todos os dados da entidade
     *
     * @return <code>T</code> Entidade
     */
    @Override
    public List<T> getList() {
        ObjectContainer db = Db4o.openFile(database);
        Query query = db.query();
        query.constrain(objectClass);
        query.descend("id").orderAscending();
        ObjectSet os = query.execute();
        List<T> objs = new ArrayList<>();
        objs.addAll(os);
        db.close();
        return objs;
    }

    /**
     * Insere a entidade no banco de dados
     *
     * @param entity <code>T</code> Entidade
     */
    @Override
    public void insert(T entity) {
        ObjectContainer db = Db4o.openFile(database);
        db.store(entity);
        db.commit();
        db.close();
    }

    /**
     * Insere as entidades no banco de dados
     *
     * @param entities <code>List(T)</code> Entidades
     */
    @Override
    public void insertAll(List<T> entities) {
        ObjectContainer db = Db4o.openFile(database);
        entities.stream().forEach((entity) -> {
            db.store(entity);
        });
        db.commit();
        db.close();
    }

    /**
     * Atualiza a entidade
     *
     * @param entity <code>T</code> Entidade
     * @throws java.lang.IllegalAccessException Acesso ilegal
     */
    @Override
    public void update(T entity) throws IllegalArgumentException, IllegalAccessException {
        ObjectContainer db = Db4o.openFile(database);
        Query query = db.query();
        query.constrain(objectClass);
        ObjectSet<T> get = db.queryByExample(entity);
        ObjectCopy.copy(entity, get);
        db.store(get);
        db.commit();
        db.close();
    }

    /**
     * Deleta todos os objetos da lista
     *
     * @param entities <code>List(T)</code> Lista a ser deletada
     */
    @Override
    public void deleteAll(List<T> entities) {
        ObjectContainer db = Db4o.openFile(database);
        entities.stream().forEach((entity) -> {
            ObjectSet<T> os = db.queryByExample(entity);
            db.delete(os.next());
        });
        db.commit();
        db.close();
    }

    /**
     * Deleta todos os objetos do banco
     */
    @Override
    public void deleteAll() {
        ObjectContainer db = Db4o.openFile(database);
        ObjectSet<T> query = db.query(objectClass);
        for (T t : query) {
            db.delete(t);
        }
        db.commit();
        db.close();
    }

    /**
     * Deleta a entidade
     *
     * @param entity <code>T</code> Entidade
     */
    @Override
    public void delete(T entity) {
        ObjectContainer db = Db4o.openFile(database);
        ObjectSet<T> os = db.queryByExample(entity);
        db.delete(os.next());
        db.commit();
        db.close();
    }

    /**
     * Deleta todos os registros anteriores e insere os registros da lista
     *
     * @param entities <code>List(T)</code> Lista dos novos registros
     */
    @Override
    public void replaceAll(List<T> entities) {
        deleteAll();
        insertAll(entities);
    }

    /**
     * Retorna a entidade a partir do ID
     *
     * @param id <code>Integer</code> ID
     * @return <code>T</code> Entidade
     */
    @Override
    public T queryByID(int id) {
        ObjectContainer db = Db4o.openFile(database);
        Query query = db.query();
        query.constrain(objectClass);
        query.descend("id").orderAscending();
        ObjectSet<T> os = query.execute();
        List<T> list = new ArrayList<>();
        list.addAll(os);
        db.close();
        for (T entity : list) {
            return entity;
        }
        return null;
    }

    /**
     * Efetua a busca com base no campo informado
     *
     * @param field <code>String</code> Campo a ser verificado
     * @param value <code>Object</code> Valor da busca
     * @return <code>List(T)</code> Lista contendo o resultado
     */
    @Override
    public List<T> queryByField(String field, Object value) {
        List<T> list = new ArrayList<>();
        ObjectContainer db = Db4o.openFile(database);
        Query query = db.query();
        query.constrain(objectClass);
        query.descend(field).constrain(value);
        ObjectSet<T> os = query.execute();
        list.addAll(os);
        db.close();
        return list;
    }

    /**
     * Retorna a classe do objeto que aplica o DAO
     *
     * @return <code>Class(?)</code> Classe do DAO
     */
    @Override
    public Class<T> getObjectClass() {
        return objectClass;
    }

    /**
     * Modifica a classe do objeto que aplica o DAO
     *
     * @param oClass <code>Class(?)</code> Classe do DAO
     */
    @Override
    public void setObjectClass(Class<T> oClass) {
        this.objectClass = oClass;
    }

    /**
     * Retorna o prefixo da base de dados (Caminho do arquivo)
     *
     * @return <code>String</code> Prefixo da base de dados
     */
    @Override
    public String getPrefix() {
        return prefix;
    }

    /**
     * Modifica o prefixo da base de dados (Caminho do arquivo)
     *
     * @param prefix <code>String</code> Prefixo da base de dados
     */
    @Override
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    /**
     * Retorna o nome da base de dados
     *
     * @return <code>String</code> Nome da base de dados
     */
    @Override
    public String getDatabase() {
        return database;
    }

    /**
     * Modifica o nome da base de dados
     *
     * @param database <code>String</code> Nome da base de dados
     */
    @Override
    public void setDatabase(String database) {
        this.database = database;
    }

    /**
     * Retorna o sufixo da base de dados (Extensão do arquivo)
     *
     * @return <code>String</code> sufixo da base de dados (Extensão do arquivo)
     */
    @Override
    public String getSufix() {
        return sufix;
    }

    /**
     * Modifica o sufixo da base de dados (Extensão do arquivo)
     *
     * @param sufix <code>String</code> Sufixo da base de dados (Extensão do
     * arquivo)
     */
    @Override
    public void setSufix(String sufix) {
        this.sufix = sufix;
    }

}
