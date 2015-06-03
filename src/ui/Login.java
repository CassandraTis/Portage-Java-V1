/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.ArrayList;
import javax.swing.BoxLayout;
import static javax.swing.BoxLayout.Y_AXIS;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import princetonPlainsboro.DossierMedical;
import princetonPlainsboro.LectureXML;
import princetonPlainsboro.Medecin;
import princetonPlainsboro.Patient;
import princetonPlainsboro.Secretaire;

/**
 *
 * @author Cassandra
 */
public class Login extends javax.swing.JFrame {

    private String id;
    private String mdpasse;
    private ArrayList<Medecin> mdpsMedecin;
    private JTextField identifiant;
    private JTextField mdp;
    private ArrayList<Secretaire> mdpsSecretaire;
    private boolean estSecretaire;

    public Login() {
        //JFrame login = new JFrame();
        this.estSecretaire = false;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(300, 250);//On lui donne une taille
        setTitle("Connexion"); //On lui donne un titre

        JPanel connexion = new JPanel();
        connexion.setLayout(new BoxLayout(connexion, Y_AXIS));
        add(connexion);
        identifiant = new JTextField();
        mdp = new JTextField();
        mdpasse = mdp.getText();
        JButton validation = new JButton("Se connecter");

        connexion.add(identifiant);
        connexion.add(mdp);
        connexion.add(validation);
        mdpsSecretaire = new ArrayList<Secretaire>();
        mdpsMedecin = new ArrayList<Medecin>();
        LectureXML pat = new LectureXML("dossiers.xml");
        DossierMedical dm = pat.getDossier();
        for (int i = 0; i < dm.getFiches().size(); i++) {

            Medecin m = new Medecin(dm.getFiches().get(i).getMedecin().getNom(), dm.getFiches().get(i).getMedecin().getPrenom(), dm.getFiches().get(i).getMedecin().getSpecialite(), dm.getFiches().get(i).getMedecin().getTel(), dm.getFiches().get(i).getMedecin().getMdp(), dm.getFiches().get(i).getMedecin().getIdentifiant());
            mdpsMedecin.add(m);

        }

        for (int i = 0; i < dm.getListeSecretaire().size(); i++) {

            Secretaire s = new Secretaire(dm.getListeSecretaire().get(i).getNom(), dm.getListeSecretaire().get(i).getPrenom(), dm.getListeSecretaire().get(i).getIdentifiant(), dm.getListeSecretaire().get(i).getMdp());
            mdpsSecretaire.add(s);

        }

        validation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validationActionPerformed(evt);
            }
        });

    }

    public void validationActionPerformed(java.awt.event.ActionEvent evt) {
        id = identifiant.getText();
        mdpasse = mdp.getText();
        if (this.checkId()) {
            new Fenetre(this.estSecretaire).setVisible(true);
            this.dispose();
        } else {
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "Mauvais identifiant ou mauvais mot de passe");
        }

    }
    /*
     public String getIdentifiant() {
     return id;
     }

     public String getMdp() {
     return mdpasse;
     }
     */

    public boolean checkId() {
        boolean res = false;
        //return res;

        for (int i = 0; i < mdpsMedecin.size(); i++) {
            if (mdpsMedecin.get(i).getIdentifiant().equals(this.id)) {
                if (mdpsMedecin.get(i).getMdp().equals(this.mdpasse)) {
                    res = true;
                }
            }
        }
        for (int j = 0; j < mdpsSecretaire.size(); j++) {
            if (mdpsSecretaire.get(j).getIdentifiant().equals(this.id)) {
                if (mdpsSecretaire.get(j).getMdp().equals(this.mdpasse)) {
                    res = true;
                    estSecretaire = true;
                }
            }
        }
        return res;
    }
}

    // Pouvoir récupérer tous les mots de passe des médecins issus de l'XML
// Mettre dans l'arrayList mdpsMedecin

