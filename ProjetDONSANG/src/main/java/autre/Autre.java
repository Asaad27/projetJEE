package autre;

import java.util.ArrayList;
import java.util.List;

import beans.*;

public class Autre {
    public static Ville getVilleByName(List<Ville> list, String vil){
        for (Ville ville : list){
            if(ville.getNomVille().equals(vil))
                return ville;
        }
        return null;
    }
    public static GroupSang getGroupeByName(List<GroupSang> list, String grp){
        for (GroupSang groupe : list){
            if(groupe.getNomGroupe().equals(grp))
                return groupe;
        }
        return null;
    }
    public static boolean filterBygroup(ArrayList<concerner> listgroupe, int idgroupe){
        Long[] groupe=new Long[listgroupe.size()];
        for(int i=0;i< listgroupe.size();i++){
              groupe[i]=listgroupe.get(i).getIdGroupeSang();
        }
        if(idgroupe==1){
            for(int i=0;i< listgroupe.size();i++){
                if(listgroupe.get(i).getIdGroupeSang()==1 || listgroupe.get(i).getIdGroupeSang()==3) return true;
            }
        }else if(idgroupe==2){
            for(int i=0;i< listgroupe.size();i++){
                if(listgroupe.get(i).getIdGroupeSang()==1 || listgroupe.get(i).getIdGroupeSang()==2
                        || listgroupe.get(i).getIdGroupeSang()==3 || listgroupe.get(i).getIdGroupeSang()==4)
                    return true;
            }
        }
        else if(idgroupe==3 ){
            for(int i=0;i< listgroupe.size();i++){
                if(listgroupe.get(i).getIdGroupeSang()==3)
                    return true;
            }

        }
        else if(idgroupe==4){
            for(int i=0;i< listgroupe.size();i++){
                if(listgroupe.get(i).getIdGroupeSang()==3 || listgroupe.get(i).getIdGroupeSang()==4)
                    return true;
            }
        }
        else if(idgroupe==5 ){
            for(int i=0;i< listgroupe.size();i++){
                if(listgroupe.get(i).getIdGroupeSang()==1 || listgroupe.get(i).getIdGroupeSang()==3
                        || listgroupe.get(i).getIdGroupeSang()==5 || listgroupe.get(i).getIdGroupeSang()==7)
                    return true;
            }
        }
        else if(idgroupe==6){
                   return true;

        }
        else if(idgroupe==7 && listgroupe.size()==2){
            for(int i=0;i< listgroupe.size();i++){
                if(listgroupe.get(i).getIdGroupeSang()==3 || listgroupe.get(i).getIdGroupeSang()==7)
                    return true;
            }
        }
        else if(idgroupe==8 && listgroupe.size()==1){
            for(int i=0;i< listgroupe.size();i++){
                if(listgroupe.get(i).getIdGroupeSang()==3 || listgroupe.get(i).getIdGroupeSang()==4
                        || listgroupe.get(i).getIdGroupeSang()==7 || listgroupe.get(i).getIdGroupeSang()==8)
                    return true;
            }
        }
        return false;
    }


}