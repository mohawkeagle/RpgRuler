package br.com.rpgruler.data.entitity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Id;

/**
 *
 * @author kaciano
 */
public class PlayerCharInfo implements Serializable {

    @Id
    @Column(name = "Código")
    private Long id;
    @Column(name = "Nivel")
    private long charLevel;
    @Column(name = "HP")
    private Integer hp;
    @Column(name = "Força")
    private Integer strength;
    @Column(name = "Destreza")
    private Integer dexterity;
    @Column(name = "Sabedoria")
    private Integer wisdom;
    @Column(name = "Resistencia")
    private Integer resistance;
    @Column(name = "Sorte")
    private Integer lucky;
    @Column(name = "Personagem")
    private PlayerChar playerChar;

    public PlayerCharInfo() {
    }

    public PlayerCharInfo(Long id) {
        this.id = id;
    }

    public PlayerCharInfo(Long id, long charLevel, Integer hp, Integer strength, Integer dexterity, Integer resistance, Integer wisdom, Integer lucky) {
        this.id = id;
        this.charLevel = charLevel;
        this.hp = hp;
        this.strength = strength;
        this.dexterity = dexterity;
        this.resistance = resistance;
        this.wisdom = wisdom;
        this.lucky = lucky;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getCharLevel() {
        return charLevel;
    }

    public void setCharLevel(long charLevel) {
        this.charLevel = charLevel;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public Integer getDexterity() {
        return dexterity;
    }

    public void setDexterity(Integer dexterity) {
        this.dexterity = dexterity;
    }

    public Integer getResistance() {
        return resistance;
    }

    public void setResistance(Integer resistance) {
        this.resistance = resistance;
    }

    public Integer getWisdom() {
        return wisdom;
    }

    public void setWisdom(Integer wisdom) {
        this.wisdom = wisdom;
    }

    public Integer getLucky() {
        return lucky;
    }

    public void setLucky(Integer lucky) {
        this.lucky = lucky;
    }

    public PlayerChar getIdPlayerChar() {
        return playerChar;
    }

    public void setIdPlayerChar(PlayerChar idPlayerChar) {
        this.playerChar = idPlayerChar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlayerCharInfo)) {
            return false;
        }
        PlayerCharInfo other = (PlayerCharInfo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.rpgruler.data.entitity.PlayerCharInfo[ id=" + id + " ]";
    }

}
