package br.com.rpgruler.data.entitity;

import br.com.gmp.comps.annotations.ColumnName;
import br.com.gmp.utils.annotations.Editable;
import br.com.gmp.utils.annotations.Ignore;
import br.com.gmp.utils.annotations.NotCopiable;
import java.util.Objects;

/**
 * Tipo de armadura
 *
 * @author kaciano
 */
public class ArmorType extends Type {

    @Ignore
    @NotCopiable
    @ColumnName(name = "Código")
    private Long id;
    @Editable
    @ColumnName(name = "Nome")
    private String name;
    @Editable
    @ColumnName(name = "Base")
    private Double base;
    @Editable
    @ColumnName(name = "Quantidade 1")
    private Double materialAmount1;
    @Editable
    @ColumnName(name = "Quantidade 2")
    private Double materialAmount2;

    /**
     * Cria nova instancia de ArmorType
     */
    public ArmorType() {
    }

    /**
     * Cria nova instancia de ArmorType
     *
     * @param id <code>Long</code> Código do tipo
     * @param typeName <code>String</code> Nome do tipo
     * @param materialAmount1 <code>Double</code> Quantidade do material 1
     * @param materialAmount2 <code>Double</code> Quantidade do material 2
     */
    public ArmorType(Long id, String typeName, Double materialAmount1, Double materialAmount2) {
        this.id = id;
        this.name = typeName;
        this.base = (double) 0;
        this.materialAmount1 = materialAmount1;
        this.materialAmount2 = materialAmount2;
    }

    /**
     * Retorna o Código do tipo
     *
     * @return <code>Long</code> Código do tipo
     */
    public Long getId() {
        return id;
    }

    /**
     * Modifica o Código do tipo
     *
     * @param id <code>Long</code> Código do tipo
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna o Nome do tipo
     *
     * @return <code>String</code> Nome do tipo
     */
    public String getName() {
        return name;
    }

    /**
     * Modifica o Nome do tipo
     *
     * @param name <code>String</code> Nome do tipo
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retorna a Resistencia base
     *
     * @return <code>Double</code> Resistencia base
     */
    public Double getBase() {
        return base;
    }

    /**
     * Modifica a Resistencia base
     *
     * @param base <code>Double</code> Resistencia base
     */
    public void setBase(Double base) {
        this.base = base;
    }

    /**
     * Retorna a Quantidade do material 1
     *
     * @return <code>Double</code> Quantidade do material 1
     */
    public Double getMaterialAmount1() {
        return materialAmount1;
    }

    /**
     * Modifica a Quantidade do material 1
     *
     * @param amount1 <code>Double</code> Quantidade do material 1
     */
    public void setMaterialAmount1(Double amount1) {
        this.materialAmount1 = amount1;
    }

    /**
     * Retorna a Quantidade do material 2
     *
     * @return <code>Double</code> Quantidade do material 2
     */
    public Double getMaterialAmount2() {
        return materialAmount2;
    }

    /**
     * Modifica a Quantidade do material 2
     *
     * @param amount2 <code>Double</code> Quantidade do material 2
     */
    public void setMaterialAmount2(Double amount2) {
        this.materialAmount2 = amount2;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.name);
        hash = 89 * hash + Objects.hashCode(this.materialAmount1);
        hash = 89 * hash + Objects.hashCode(this.materialAmount2);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ArmorType other = (ArmorType) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.materialAmount1, other.materialAmount1)) {
            return false;
        }
        return Objects.equals(this.materialAmount2, other.materialAmount2);
    }

    @Override
    public String toString() {
        return name;
    }

}
