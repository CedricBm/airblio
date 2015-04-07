/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sia.airblio.forms;

import javax.servlet.http.HttpServletRequest;
import sia.airblio.beans.Client;

/**
 *
 * @author Superced
 */
public class ClientForm {

    private final static String CHAMP_NOM = "nom";
    private final static String CHAMP_TELEPHONE = "telephone";
    private final static String CHAMP_ADRESSE = "adresse";
    private final static String CHAMP_EMAIL = "email";
    private final static String CHAMP_REFERENCE = "reference";
    private final static String CHAMP_IBAN = "iban";
    private final static String CHAMP_BIC = "bic";

    public Client getClient(HttpServletRequest request) {
        String nom = getValeurChamp(request, CHAMP_NOM);
        String telephone = getValeurChamp(request, CHAMP_TELEPHONE);
        String adresse = getValeurChamp(request, CHAMP_ADRESSE);
        String email = getValeurChamp(request, CHAMP_EMAIL);
        String reference = getValeurChamp(request, CHAMP_REFERENCE);
        String iban = getValeurChamp(request, CHAMP_IBAN);
        String bic = getValeurChamp(request, CHAMP_BIC);

        Client client = new Client();
        client.setNom(nom);
        client.setTelephone(telephone);
        client.setAdresse(adresse);
        client.setEmail(email);
        client.setReference(reference);
        client.setIban(iban);
        client.setBic(bic);
        
        return client;
    }

    /*
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    private static String getValeurChamp(HttpServletRequest request, String nomChamp) {
        String valeur = request.getParameter(nomChamp);
        if (valeur == null || valeur.trim().length() == 0) {
            return null;
        } else {
            return valeur.trim();
        }
    }
}
