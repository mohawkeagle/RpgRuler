package br.com.rpgruler.main.view.terms;

import br.com.gmp.comps.model.GListModel;
import br.com.rpgruler.data.entity.EffectType;
import br.com.rpgruler.data.entity.ExpertiseType;
import br.com.rpgruler.data.entity.PerkType;
import br.com.rpgruler.data.entity.RestrictionType;
import br.com.rpgruler.data.entity.UseType;
import br.com.rpgruler.main.MainScreen;
import br.com.rpgruler.main.object.BeanEvent;
import br.com.rpgruler.main.view.View;
import br.com.rpgruler.main.view.terms.bean.TermsBean;
import br.com.rpgruler.main.view.interfaces.BeanListener;
import br.com.rpgruler.main.view.object.ViewParameter;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Tela para cadastro de termos comuns
 *
 * @author kaciano
 * @version 1.0
 */
public class TermsView extends View {

    private TermsBean bean;
    private GListModel<UseType> useModel;
    private GListModel<EffectType> efModel;
    private GListModel<PerkType> perkModel;
    private GListModel<RestrictionType> restModel;
    private GListModel<ExpertiseType> expModel;

    /**
     * Cria nova instancia de TermsView
     *
     * @param mainScreen <code>MainScreen</code> Tela principal
     */
    public TermsView(MainScreen mainScreen) {
        super(mainScreen);
        initialize();
    }

    /**
     * Método de inicialização
     */
    private void initialize() {
        initComponents();
        this.setSize(625, 430);
        this.setControls(new ViewParameter(true, false, false, true));
        this.useModel = new GListModel<>();
        this.efModel = new GListModel<>();
        this.perkModel = new GListModel<>();
        this.restModel = new GListModel<>();
        this.expModel = new GListModel<>();
        this.bean = new TermsBean(this);                  
        this.gLtUseTp.setModel(useModel);
        this.gLtEffectTp.setModel(efModel);
        this.gLtPerkTp.setModel(perkModel);
        this.gLtRestTp.setModel(restModel);
        this.gLtExpTp.setModel(expModel);        
        try {
            this.bean.load(null);
        } catch (Exception ex) {
            Logger.getLogger(TermsView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Adiciona novo elemento na lista de tipos de uso para armas
     *
     * @param evt <code>KeyEvent</code> Evento do teclado
     */
    private void addUseType(KeyEvent evt) {
        if (gTUseTp.validateComponent()) {
            bean.addUseTp(new BeanEvent(this, gTUseTp.getText()));
            gTUseTp.clear();
        }
    }

    /**
     * Remove o UseType selecionado
     *
     * @param evt <code>KeyEvent</code> Evento do teclado
     */
    private void removeUseType(KeyEvent evt) {
        if (gLtUseTp.getModel().getSize() > 0 && gLtUseTp.getSelectedIndex() >= 0) {
            UseType wt = useModel.getElementAt(gLtUseTp.getSelectedIndex());
            useModel.remove(wt);
        }
    }

    /**
     * Adiciona novo elemento na lista de efeitos
     *
     * @param evt <code>KeyEvent</code> Evento do teclado
     */
    private void addEffectType(KeyEvent evt) {
        if (gTEffectTp.validateComponent()) {
            bean.addEffectTp(new BeanEvent(this, gTEffectTp.getText()));
            gTEffectTp.clear();
        }
    }

    /**
     * Remove o EffectType selecionado
     *
     * @param evt <code>KeyEvent</code> Evento do teclado
     */
    private void removeEffectType(KeyEvent evt) {
        if (gLtEffectTp.getModel().getSize() > 0 && gLtEffectTp.getSelectedIndex() >= 0) {
            EffectType ef = efModel.getElementAt(gLtEffectTp.getSelectedIndex());
            efModel.remove(ef);
        }
    }

    /**
     * Adiciona novo elemento na lista de PerkTypes
     *
     * @param evt <code>KeyEvent</code> Evento do teclado
     */
    private void addPerkType(KeyEvent evt) {
        if (gTPerkTp.validateComponent()) {
            bean.addPerkTp(new BeanEvent(this, gTPerkTp.getText()));
            gTPerkTp.clear();
        }
    }

    /**
     * Remove o PerkType selecionado
     *
     * @param evt <code>KeyEvent</code> Evento do teclado
     */
    private void removePerkType(KeyEvent evt) {
        if (gLtPerkTp.getModel().getSize() > 0 && gLtPerkTp.getSelectedIndex() >= 0) {
            PerkType type = perkModel.getElementAt(gLtPerkTp.getSelectedIndex());
            perkModel.remove(type);
        }
    }

    /**
     * Adiciona novo elemento na lista de PerkTypes
     *
     * @param evt <code>KeyEvent</code> Evento do teclado
     */
    private void addRestType(KeyEvent evt) {
        if (gTRestrictTp.validateComponent()) {
            bean.addRestTp(new BeanEvent(this, gTRestrictTp.getText()));
            gTRestrictTp.clear();
        }
    }

    /**
     * Remove o RestrictionType selecionado
     *
     * @param evt <code>KeyEvent</code> Evento do teclado
     */
    private void removeRestType(KeyEvent evt) {
        if (gLtRestTp.getModel().getSize() > 0 && gLtRestTp.getSelectedIndex() >= 0) {
            RestrictionType type = restModel.getElementAt(gLtRestTp.getSelectedIndex());
            restModel.remove(type);
        }
    }

    /**
     * Adiciona novo elemento na lista de PerkTypes
     *
     * @param evt <code>KeyEvent</code> Evento do teclado
     */
    private void addExpType(KeyEvent evt) {
        if (gTExpertiseTp.validateComponent()) {
            bean.addExpTp(new BeanEvent(this, gTExpertiseTp.getText()));
            gTExpertiseTp.clear();
        }
    }

    /**
     * Remove o ExpertiseType selecionado
     *
     * @param evt <code>KeyEvent</code> Evento do teclado
     */
    private void removeExpType(KeyEvent evt) {
        if (gLtExpTp.getModel().getSize() > 0 && gLtExpTp.getSelectedIndex() >= 0) {
            ExpertiseType type = expModel.getElementAt(gLtExpTp.getSelectedIndex());
            expModel.remove(type);
        }
    }

    /**
     * Retorna o modelo de lista dos WearTypes
     *
     * @return <code>GListModel(WearType)</code>
     */
    public GListModel<UseType> getUseModel() {
        return this.useModel;
    }

    /**
     * Retorna o modelo de lista dos EffectTypes
     *
     * @return <code>GListModel(EffectType)</code>
     */
    public GListModel<EffectType> getEfModel() {
        return efModel;
    }

    /**
     * Retorna o modelo de lista dos PerkTypes
     *
     * @return <code>GListModel(PerkType)</code>
     */
    public GListModel<PerkType> getPerkModel() {
        return perkModel;
    }

    /**
     * Retorna o modelo de lista dos RestrictionTypes
     *
     * @return <code>GListModel(RestrictionType)</code>
     */
    public GListModel<RestrictionType> getRestModel() {
        return restModel;
    }

    /**
     * Retorna o modelo de lista dos ExpertiseTypes
     *
     * @return <code>GListModel(ExpertiseType)</code>
     */
    public GListModel<ExpertiseType> getExpModel() {
        return expModel;
    }

    @Override
    public BeanListener getBean() {
        return bean;
    }

    /**
     *
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPUseTypes = new javax.swing.JPanel();
        gTUseTp = new br.com.gmp.comps.textfield.GTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        gLtUseTp = new br.com.gmp.comps.list.GList();
        jPEffects = new javax.swing.JPanel();
        gTEffectTp = new br.com.gmp.comps.textfield.GTextField();
        jSPEffect = new javax.swing.JScrollPane();
        gLtEffectTp = new br.com.gmp.comps.list.GList();
        jPRestrictTypes = new javax.swing.JPanel();
        gTRestrictTp = new br.com.gmp.comps.textfield.GTextField();
        jSPRestrict = new javax.swing.JScrollPane();
        gLtRestTp = new br.com.gmp.comps.list.GList();
        jPExpertiseTypes = new javax.swing.JPanel();
        gTExpertiseTp = new br.com.gmp.comps.textfield.GTextField();
        jSPExpertise = new javax.swing.JScrollPane();
        gLtExpTp = new br.com.gmp.comps.list.GList();
        jPPerkTypes = new javax.swing.JPanel();
        gTPerkTp = new br.com.gmp.comps.textfield.GTextField();
        jSPPerk = new javax.swing.JScrollPane();
        gLtPerkTp = new br.com.gmp.comps.list.GList();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Termos comuns");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/misc/slice1213_.png"))); // NOI18N
        setMaximumSize(new java.awt.Dimension(754, 300));
        setMinimumSize(new java.awt.Dimension(754, 300));
        setPreferredSize(new java.awt.Dimension(754, 300));
        getContentPane().setLayout(new java.awt.GridLayout(2, 4));

        jPUseTypes.setBorder(javax.swing.BorderFactory.createTitledBorder("Usos de armas"));

        gTUseTp.setPlaceholder("Tipos de uso");
        gTUseTp.setMaximumSize(new java.awt.Dimension(150, 2147483647));
        gTUseTp.setMinimumSize(new java.awt.Dimension(150, 28));
        gTUseTp.setNextFocusableComponent(gTEffectTp);
        gTUseTp.setPreferredSize(new java.awt.Dimension(150, 28));
        gTUseTp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gTUseTpKeyReleased(evt);
            }
        });

        gLtUseTp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gLtUseTpKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(gLtUseTp);

        javax.swing.GroupLayout jPUseTypesLayout = new javax.swing.GroupLayout(jPUseTypes);
        jPUseTypes.setLayout(jPUseTypesLayout);
        jPUseTypesLayout.setHorizontalGroup(
            jPUseTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPUseTypesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPUseTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(gTUseTp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
                .addGap(14, 14, 14))
        );
        jPUseTypesLayout.setVerticalGroup(
            jPUseTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPUseTypesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gTUseTp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPUseTypes);

        jPEffects.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipos de Efeitos"));

        gTEffectTp.setPlaceholder("Tipos de efeitos");
        gTEffectTp.setMaximumSize(new java.awt.Dimension(150, 2147483647));
        gTEffectTp.setMinimumSize(new java.awt.Dimension(150, 28));
        gTEffectTp.setNextFocusableComponent(gTPerkTp);
        gTEffectTp.setPreferredSize(new java.awt.Dimension(150, 28));
        gTEffectTp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gTEffectTpKeyReleased(evt);
            }
        });

        gLtEffectTp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gLtEffectTpKeyReleased(evt);
            }
        });
        jSPEffect.setViewportView(gLtEffectTp);

        javax.swing.GroupLayout jPEffectsLayout = new javax.swing.GroupLayout(jPEffects);
        jPEffects.setLayout(jPEffectsLayout);
        jPEffectsLayout.setHorizontalGroup(
            jPEffectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPEffectsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPEffectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gTEffectTp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSPEffect, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPEffectsLayout.setVerticalGroup(
            jPEffectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPEffectsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSPEffect, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gTEffectTp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        getContentPane().add(jPEffects);

        jPRestrictTypes.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipos de Restrições"));

        gTRestrictTp.setPlaceholder("Tipos de restrição");
        gTRestrictTp.setMaximumSize(new java.awt.Dimension(150, 2147483647));
        gTRestrictTp.setMinimumSize(new java.awt.Dimension(150, 28));
        gTRestrictTp.setNextFocusableComponent(gTUseTp);
        gTRestrictTp.setPreferredSize(new java.awt.Dimension(150, 28));
        gTRestrictTp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gTRestrictTpKeyReleased(evt);
            }
        });

        gLtRestTp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gLtRestTpKeyReleased(evt);
            }
        });
        jSPRestrict.setViewportView(gLtRestTp);

        javax.swing.GroupLayout jPRestrictTypesLayout = new javax.swing.GroupLayout(jPRestrictTypes);
        jPRestrictTypes.setLayout(jPRestrictTypesLayout);
        jPRestrictTypesLayout.setHorizontalGroup(
            jPRestrictTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPRestrictTypesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPRestrictTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gTRestrictTp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSPRestrict, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPRestrictTypesLayout.setVerticalGroup(
            jPRestrictTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPRestrictTypesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSPRestrict, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gTRestrictTp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        getContentPane().add(jPRestrictTypes);

        jPExpertiseTypes.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipos de Perícias"));

        gTExpertiseTp.setPlaceholder("Tipos de perícias");
        gTExpertiseTp.setMaximumSize(new java.awt.Dimension(150, 2147483647));
        gTExpertiseTp.setMinimumSize(new java.awt.Dimension(150, 28));
        gTExpertiseTp.setNextFocusableComponent(gTUseTp);
        gTExpertiseTp.setPreferredSize(new java.awt.Dimension(150, 28));
        gTExpertiseTp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gTExpertiseTpKeyReleased(evt);
            }
        });

        gLtExpTp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gLtExpTpKeyReleased(evt);
            }
        });
        jSPExpertise.setViewportView(gLtExpTp);

        javax.swing.GroupLayout jPExpertiseTypesLayout = new javax.swing.GroupLayout(jPExpertiseTypes);
        jPExpertiseTypes.setLayout(jPExpertiseTypesLayout);
        jPExpertiseTypesLayout.setHorizontalGroup(
            jPExpertiseTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPExpertiseTypesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPExpertiseTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gTExpertiseTp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSPExpertise, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPExpertiseTypesLayout.setVerticalGroup(
            jPExpertiseTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPExpertiseTypesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSPExpertise, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gTExpertiseTp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        getContentPane().add(jPExpertiseTypes);

        jPPerkTypes.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipos de Vantagens"));

        gTPerkTp.setPlaceholder("Tipos de vantagens");
        gTPerkTp.setMaximumSize(new java.awt.Dimension(150, 2147483647));
        gTPerkTp.setMinimumSize(new java.awt.Dimension(150, 28));
        gTPerkTp.setNextFocusableComponent(gTUseTp);
        gTPerkTp.setPreferredSize(new java.awt.Dimension(150, 28));
        gTPerkTp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gTPerkTpKeyReleased(evt);
            }
        });

        gLtPerkTp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gLtPerkTpKeyReleased(evt);
            }
        });
        jSPPerk.setViewportView(gLtPerkTp);

        javax.swing.GroupLayout jPPerkTypesLayout = new javax.swing.GroupLayout(jPPerkTypes);
        jPPerkTypes.setLayout(jPPerkTypesLayout);
        jPPerkTypesLayout.setHorizontalGroup(
            jPPerkTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPPerkTypesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPPerkTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gTPerkTp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSPPerk, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPPerkTypesLayout.setVerticalGroup(
            jPPerkTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPPerkTypesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSPPerk, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gTPerkTp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        getContentPane().add(jPPerkTypes);
    }// </editor-fold>//GEN-END:initComponents

    private void gTUseTpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gTUseTpKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                addUseType(evt);
            } catch (Exception ex) {
                Logger.getLogger(TermsView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_gTUseTpKeyReleased

    private void gTEffectTpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gTEffectTpKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                addEffectType(evt);
            } catch (Exception ex) {
                Logger.getLogger(TermsView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_gTEffectTpKeyReleased

    private void gTPerkTpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gTPerkTpKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                addPerkType(evt);
            } catch (Exception ex) {
                Logger.getLogger(TermsView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_gTPerkTpKeyReleased

    private void gLtUseTpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gLtUseTpKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            try {
                removeUseType(evt);
            } catch (Exception ex) {
                Logger.getLogger(TermsView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_gLtUseTpKeyReleased

    private void gLtEffectTpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gLtEffectTpKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            try {
                removeEffectType(evt);
            } catch (Exception ex) {
                Logger.getLogger(TermsView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_gLtEffectTpKeyReleased

    private void gLtPerkTpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gLtPerkTpKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            try {
                removePerkType(evt);
            } catch (Exception ex) {
                Logger.getLogger(TermsView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_gLtPerkTpKeyReleased

    private void gTRestrictTpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gTRestrictTpKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                addRestType(evt);
            } catch (Exception ex) {
                Logger.getLogger(TermsView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_gTRestrictTpKeyReleased

    private void gLtRestTpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gLtRestTpKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            try {
                removeRestType(evt);
            } catch (Exception ex) {
                Logger.getLogger(TermsView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_gLtRestTpKeyReleased

    private void gTExpertiseTpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gTExpertiseTpKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                addExpType(evt);
            } catch (Exception ex) {
                Logger.getLogger(TermsView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_gTExpertiseTpKeyReleased

    private void gLtExpTpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gLtExpTpKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            try {
                removeExpType(evt);
            } catch (Exception ex) {
                Logger.getLogger(TermsView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_gLtExpTpKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.com.gmp.comps.list.GList gLtEffectTp;
    private br.com.gmp.comps.list.GList gLtExpTp;
    private br.com.gmp.comps.list.GList gLtPerkTp;
    private br.com.gmp.comps.list.GList gLtRestTp;
    private br.com.gmp.comps.list.GList gLtUseTp;
    private br.com.gmp.comps.textfield.GTextField gTEffectTp;
    private br.com.gmp.comps.textfield.GTextField gTExpertiseTp;
    private br.com.gmp.comps.textfield.GTextField gTPerkTp;
    private br.com.gmp.comps.textfield.GTextField gTRestrictTp;
    private br.com.gmp.comps.textfield.GTextField gTUseTp;
    private javax.swing.JPanel jPEffects;
    private javax.swing.JPanel jPExpertiseTypes;
    private javax.swing.JPanel jPPerkTypes;
    private javax.swing.JPanel jPRestrictTypes;
    private javax.swing.JPanel jPUseTypes;
    private javax.swing.JScrollPane jSPEffect;
    private javax.swing.JScrollPane jSPExpertise;
    private javax.swing.JScrollPane jSPPerk;
    private javax.swing.JScrollPane jSPRestrict;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
