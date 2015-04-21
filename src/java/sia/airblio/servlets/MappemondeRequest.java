/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sia.airblio.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Query;
import org.hibernate.Session;
import org.json.simple.JSONObject;
import sia.airblio.beans.Client;
import sia.airblio.beans.Commande;
import sia.airblio.beans.EquipeTechnique;
import sia.airblio.beans.HibernateUtil;
import sia.airblio.beans.Materiel;
import sia.airblio.beans.SiteStockage;
import sia.airblio.beans.Technicien;
import sia.airblio.forms.CommandeForm;

/**
 *
 * @author Skulldy
 */
@WebServlet(urlPatterns = {"/member/mappemondeRequest"})
public class MappemondeRequest extends HttpServlet {

    JSONObject json = new JSONObject();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("/airblio/accueil");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String requete = request.getParameter("requete");
        json.clear();

        PrintWriter out = response.getWriter();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        if ("afficheEquipes".equals(requete)) {
            getEquipes(session, false);
        } else if ("afficheEquipesIntervention".equals(requete)) {
            getEquipes(session, true);
        } else if ("arricheUneEquipe".equals(requete)) {
            getEquipe(session, request.getParameter("nom"));
        } else if ("afficheClients".equals(requete)) {
            getClients(session, false);
        } else if ("afficheClientsIntervention".equals(requete)) {
            getClients(session, true);
        } else if ("afficheMaterielsSite".equals(requete)) {
            getMaterielsSite(session);
        } else if ("afficheMaterielsClients".equals(requete)) {
            getMaterielsClients(session);
        } else if ("afficheUnClient".equals(requete)) {
            getClient(session, request.getParameter("nom"));
        } else if ("afficheClientPossedant".equals(requete)) {
            getClientPossedant(session, request.getParameter("nom"));
        } else if ("afficheInterventionDepuis".equals(requete)) {
            getInterventionDepuis(session, request.getParameter("nom"));
        } else if ("afficheMateriel".equals(requete)) {
            getMateriel(session, request.getParameter("nom"));
        }
        session.close();
        out.println(json);
        out.close();
    }

    private void getEquipes(Session session, boolean estEnIntervention) {
        Query query = session.createQuery("from EquipeTechnique");
        List<EquipeTechnique> equipes = query.list();
        for (EquipeTechnique equipe : equipes) {
            if ((estEnIntervention && equipe.getCommandes().isEmpty())) {
                continue;
            }
            String content = "<h3>" + equipe.getNom() + "</h3><p>";
            Iterator it = equipe.getTechniciens().iterator();
            while (it.hasNext()) {
                Technicien tech = (Technicien) it.next();
                content += tech.getNom() + " " + tech.getPrenom() + ": " + tech.getPoste();
                content += (it.hasNext() ? "<br />" : "");
            }
            content += "</p>";
            JSONObject jsonEquipe = new JSONObject();
            jsonEquipe.put("nom", equipe.getNom());
            jsonEquipe.put("latitude", equipe.getLatitude());
            jsonEquipe.put("longitude", equipe.getLongitude());
            jsonEquipe.put("content", content);
            json.put(equipe.getId(), jsonEquipe);
        }
    }

    private void getEquipe(Session session, String nom) {
        Query query = session.createQuery("from EquipeTechnique");
        List<EquipeTechnique> equipes = query.list();
        for (EquipeTechnique equipe : equipes) {
            if (!nom.equals(equipe.getNom())) {
                continue;
            }
            String content = "<h3>" + equipe.getNom() + "</h3><p>";
            Iterator it = equipe.getTechniciens().iterator();
            while (it.hasNext()) {
                Technicien tech = (Technicien) it.next();
                content += tech.getNom() + " " + tech.getPrenom() + ": " + tech.getPoste();
                content += (it.hasNext() ? "<br />" : "");
            }
            content += "</p>";
            json.put("nom", nom);
            json.put("content", content);
            json.put("latitude", equipe.getLatitude());
            json.put("longitude", equipe.getLongitude());
            break;
        }
    }

    private void getClients(Session session, boolean estEnIntervention) {
        Query query = session.createQuery("from Client");
        List<Client> clients = query.list();
        for (Client client : clients) {
            if (estEnIntervention && client.getCommandes().size() == 0) {
                continue;
            }
            String content = "<h3>" + client.getNom() + "</h3><p>";
            content += client.getAdresse();
            content += "</p>";
            JSONObject jsonClient = new JSONObject();
            jsonClient.put("nom", client.getNom());
            jsonClient.put("adresse", client.getAdresse());
            jsonClient.put("content", content);
            json.put(client.getId(), jsonClient);
        }
    }

    private void getMaterielsSite(Session session) {
        Query query = session.createQuery("from SiteStockage");
        List<SiteStockage> sites = query.list();
        for (SiteStockage site : sites) {
            String content = "<h3>" + site.getNom() + "</h3><p>";
            Iterator it = site.getMateriauxStockes().iterator();
            List<String> matUniq = new ArrayList<>();
            List<String> matAll = new ArrayList<>();
            while (it.hasNext()) {
                Materiel materiel = (Materiel) it.next();
                matAll.add(materiel.getNom());
            }
            it = matAll.iterator();
            while (it.hasNext()) {
                String nomMat = (String) it.next();
                if (!matUniq.contains(nomMat)) {
                    matUniq.add(nomMat);
                    content += nomMat + ": " + Collections.frequency(matAll, nomMat);
                    content += (it.hasNext() ? "<br />" : "");
                }
            }
            content += "</p>";
            JSONObject jsonSites = new JSONObject();
            jsonSites.put("nom", site.getNom());
            jsonSites.put("latitude", site.getLatitude());
            jsonSites.put("longitude", site.getLongitude());
            jsonSites.put("content", content);
            json.put(site.getId(), jsonSites);
        }
    }

    private void getMaterielsClients(Session session) {
        Query query = session.createQuery("from Commande");
        List<Commande> commandes = query.list();
        for (Commande commande : commandes) {
            String content = "<h3>" + commande.getClient().getNom() + "</h3><p>";
            Iterator it = commande.getMateriaux().iterator();
            List<String> matUniqClient = new ArrayList<>();
            List<String> matAllClient = new ArrayList<>();
            while (it.hasNext()) {
                Materiel materiel = (Materiel) it.next();
                matAllClient.add(materiel.getNom());
            }
            it = matAllClient.iterator();
            while (it.hasNext()) {
                String nomMat = (String) it.next();
                if (!matUniqClient.contains(nomMat)) {
                    matUniqClient.add(nomMat);
                    content += nomMat + ": " + Collections.frequency(matAllClient, nomMat);
                    content += (it.hasNext() ? "<br />" : "");
                }
            }
            content += "</p>";
            JSONObject jsonSites = new JSONObject();
            jsonSites.put("nom", commande.getClient().getNom());
            jsonSites.put("latitude", commande.getLatitude());
            jsonSites.put("longitude", commande.getLongitude());
            jsonSites.put("content", content);
            json.put(commande.getId(), jsonSites);
        }
    }

    private void getClient(Session session, String nom) {
        Query query = session.createQuery("from Client");
        List<Client> clients = query.list();
        for (Client client : clients) {
            if (!nom.equals(client.getNom())) {
                continue;
            }
            String content = "<h3>" + client.getNom() + "</h3><p>";
            content += client.getAdresse();
            content += "</p>";
            json.put("nom", nom);
            json.put("content", content);
            json.put("adresse", client.getAdresse());
            break;
        }
    }

    private void getClientPossedant(Session session, String nom) {
        Query query = session.createQuery("from Commande");
        List<Commande> commandes = query.list();
        for (Commande commande : commandes) {
            if (commande.getDebut().before(new Date()) && commande.getFin().after(new Date())) {
                Iterator it = commande.getMateriaux().iterator();
                List<String> matAllClient = new ArrayList<>();
                while (it.hasNext()) {
                    Materiel materiel = (Materiel) it.next();
                    matAllClient.add(materiel.getNom());
                }
                if (!matAllClient.contains(nom)) {
                    continue;
                }
                String content = "<h3>" + commande.getClient().getNom() + "</h3><p>";
                content += commande.getClient().getAdresse();
                content += "</p>";
                JSONObject jsonSites = new JSONObject();
                jsonSites.put("nom", commande.getClient().getNom());
                jsonSites.put("adresse", commande.getClient().getAdresse());
                jsonSites.put("content", content);
                json.put(commande.getClient().getId(), jsonSites);
            }
        }
    }

    private void getInterventionDepuis(Session session, String date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date input = new Date();
        try {
            input = df.parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(CommandeForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        Query query = session.createQuery("from Commande");
        List<Commande> commandes = query.list();
        for (Commande commande : commandes) {
            if (input.after(commande.getDebut())) {
                continue;
            }
            String content = "<h3>" + commande.getLieu() + "</h3><p>";
            content += commande.getClient().getNom() + "<br />";
            content += commande.getClient().getAdresse() + "<br />";
            content += "</p>";
            JSONObject jsonSites = new JSONObject();
            jsonSites.put("nom", commande.getClient().getNom());
            jsonSites.put("latitude", commande.getLatitude());
            jsonSites.put("longitude", commande.getLongitude());
            jsonSites.put("content", content);
            json.put(commande.getId(), jsonSites);
        }
    }

    private void getMateriel(Session session, String nom) {
        Query query = session.createQuery("from Materiel");
        List<Materiel> materiaux = query.list();
        for (Materiel materiel : materiaux) {
            if (!materiel.getNom().equals(nom)) {
                continue;
            }
            String content = "<h3>" + materiel.getNom() + "</h3><p>";
            content += materiel.getDescription() + "<br />";
            
            JSONObject jsonSites = new JSONObject();
            jsonSites.put("nom", materiel.getNom());
            if (materiel.getSiteStockage() == null) {
                jsonSites.put("latitude", materiel.getCommande().getLatitude());
                jsonSites.put("longitude", materiel.getCommande().getLongitude());
                content += "client: " + materiel.getCommande().getClient().getNom();
            } else {
                jsonSites.put("latitude", materiel.getSiteStockage().getLatitude());
                jsonSites.put("longitude", materiel.getSiteStockage().getLongitude());
                content += "site de stockage: " + materiel.getSiteStockage().getNom();
            }
            content += "</p>";
            jsonSites.put("content", content);
            json.put(materiel.getId(), jsonSites);
        }
    }
}
