package dao;

import beans.*;


import java.util.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.sql.ResultSet;
import java.sql.SQLException;

import static dao.DAOUtilitaire.*;


public class DAOConcernerImpl implements DAOConcerner{
    private static final String SELECT_PAR_ID="SELECT * FROM concerne_demandeutil WHERE id_demandeUtil=?";
    private static final String SELECT_PAR_DATE="SELECT id_demandeUtil FROM demandeutil WHERE date_demande=?";
    private static String INSERT_QUERY="INSERT INTO concerne_demandeutil(id_demandeUtil,id_groupe) VALUES(?,?)";
    private static String DELETE_QUERY="delete FROM concerne_demandeutil where id_demandeUtil = ? and id_groupe = ?";
    private DAOFactory daoFactory;

    public DAOConcernerImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory; }
    public static concerner map( ResultSet resultSet ) throws SQLException {
        concerner concerneDemande = new concerner();
        concerneDemande.setIdDemande(resultSet.getInt( "id_demandeUtil" ) );
        concerneDemande.setIdGroupeSang(resultSet.getLong("id_groupe"));

        return concerneDemande;
    }

    @Override
    public boolean setAllGroupsConcerned(DemandeUtilisateur demande) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement1 = null;
        PreparedStatement preparedStatement2 = null;
        ResultSet resultSet1 = null;
        ResultSet resultSet2 = null;
        boolean etat=false;
        try {
            /* R�cup�ration d'une connexion depuis la Factory */

            connexion = daoFactory.getConnection();


                for (concerner concerneDemande : demande.getSangGroups()) {
                    concerneDemande.setIdDemande(demande.getIdDemande());
                    try {
                        preparedStatement2 = initialisationRequetePreparee(connexion, INSERT_QUERY, false, concerneDemande.getIdDemande(), concerneDemande.getIdGroupeSang());
                        int statue = preparedStatement2.executeUpdate();
                        if (statue == 0) {
                            etat = false;
                        } else {
                            etat = true;
                        }

                    } catch (SQLException e) {
                        throw new DAOException(e);
                    }

                }


        } catch ( SQLException e ) {
            throw new DAOException( e );
        }
        finally {
            fermeturesSilencieuses( resultSet1, preparedStatement1, connexion );
            fermeturesSilencieuses( resultSet2, preparedStatement2, connexion );


        }
        return etat;




    }

    @Override
    public ArrayList<concerner> getAllGroupesConcerned(int idDemande) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        concerner concerneDemande=null;
        ArrayList<concerner> concerneDemandeList = new ArrayList<concerner>();

        try {
            /* R�cup�ration d'une connexion depuis la Factory */
            connexion = daoFactory.getConnection();
            preparedStatement =initialisationRequetePreparee( connexion, SELECT_PAR_ID, false,  idDemande);
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de donn�es de l'�ventuel ResulSet retourn� */
            while ( resultSet.next() ) {
                concerneDemande= map( resultSet );
                concerneDemandeList.add( concerneDemande);
            }

        } catch ( SQLException e ) {
            throw new DAOException( e );
        }
        finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );

        }
        return concerneDemandeList;



    }

    @Override
    public boolean deleteConcerneDemande(int idDemande, int idGroupeSang) throws DAOException {
        return false;
    }
}
