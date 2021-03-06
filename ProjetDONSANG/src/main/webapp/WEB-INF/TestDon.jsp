<%--
  Created by IntelliJ IDEA.
  User: Fatima zahra Azennag
  Date: 16/02/2021
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

    <title>Puis-je donner mon sang?</title>

</head>
<body>
     <form id="newItemForm">
         <div id="PremiersCritères">
             <h2>Les premières critères</h2>
       <div id="sex">
           <img src="" alt=""/>
           <p>SEXE<br/>Etes-vous une femme ou un homme ?</p>
           <c:set var="sex" value="${param.btn}"></c:set>
           <input value="femme" type="submit"  id="femme" name="btn"/>
           <input  value="homme" type="submit" id="homme" name="btn"/>

       </div>
         <div id="age">
             <img src="" alt=""/>
             <p>AGE<br/>Quel est votre age ?</p>
             <input value="- de 18 ans " type="submit" class="non1"/>
             <input  value="de 18 à 70 ans" type="submit" class="oui1"/>
             <input  value="+ 70 ans" type="submit" class="non2"/>

         </div>
         <div id="erreur1" style="display: none">Pour donner son sang, il faut être  majeur. Un 1er don de sang est une belle façon pour fêter votre majorité</div>
         <div id="erreur2" style="display: none">Pour préserver votre santé, il n’est plus possible de faire un don de sang total après 70 ans</div>
         <div id="poids">
             <img src="" alt=""/>
             <p>POIDS<br/>Quel est votre poid ?</p>
             <input value="- de 50 kg" type="submit" class="non3"/>
             <input  value="+ de 50 kg" type="submit" class="oui2"/>
         </div>
         <div id="erreur3" style="display: none"> Pour préserver votre santé,
             vous serrez en mesure de donner votre sang total si vous pesez plus de 50 kg</div>
         <div id="historique">
             <img src="" alt=""/>
             <p>HISTORIQUE DE DON<br/>Votre dernier don date de moins de 8 semaines ?</p>
             <input value="OUI" type="submit" class="non4"/>
             <input  value="NON" type="submit" class="oui3"/>
         </div>
         <div id="erreur4" style="display: none"> vous ne pouvez pas donner votre sang pour le moment,Votre dernier don est trop récent!!</div>

             <input  value="Suivant" type="submit" class="suivant1"/>
         </div>
         <div id="Maladies" style="display: none">
             <h2>Maladies et infections chroniques</h2>
             <div id="sida">
                 <img src="" alt=""/>
                 <p>HÉPATITES,INFECTIONS SEXUELLEMENT TRANSMISSIBLES <br/>Avez-vous été testé(e) positif pour le VIH (sida),
                     ou VHB (hépatite B) ou VHC (hépatite C) ou la syphilis ?</p>
                 <input value="OUI" type="submit" class="non5"/>
                 <input  value="NON" type="submit" class="oui1"/>
             </div>
             <div id="erreur5" style="display: none"> Certaines maladies comme le VIH, les hépatites B et C ou la syphilis sont transmissibles par le sang. Pour garantir la sécurité des patients et éviter tout risque de contamination,
                 vous ne pouvez pas donner votre sang</div>

         <div id="concer">
             <img src="" alt=""/>
             <p>Concer<br/>Avez-vous eu un cancer au cours de votre vie ?</p>
             <input value="OUI" type="submit" class="non6"/>
             <input  value="NON" type="submit" class="oui2"/>
         </div>
         <div id="erreur6" style="display: none"> Pour préserver votre santé, vous ne pouvez pas donner votre sang, sauf pour les cancers  du col de l’utérus et certains cancers superficiels de la peau</div>

         <div id="chronique">
             <img src="" alt=""/>
             <p>Maladies chroniques<br/>Êtes-vous traitée pour une maladie chronique telle que : diabète (traité par insuline),
                 maladie inflammatoire de l'intestin, maladie auto-immune...?</p>
             <input value="OUI" type="submit" class="non7"/>
             <input  value="NON" type="submit" class="oui3"/>
         </div>
         <div id="erreur7" style="display: none"> Pour préserver votre santé, vous ne pouvez pas donner votre sang</div>
         <div id="AVC">
             <img src="" alt=""/>
             <p>AVC<br/>Avez-vous ressenti, dans les dernières semaines, une douleur thoracique
                 ou un essoufflement anormal à la suite d’un effort ?</p>
             <input value="OUI" type="submit" class="non8"/>
             <input  value="NON" type="submit" class="oui4"/>
         </div>
         <div id="erreur8" style="display: none"> Pour préserver votre santé, vous ne pouvez pas donner votre sang,
             Le don n'est pas autorisé en cas de problèmes cardiaques ou d’antécédents d’accidents vasculaires (AVC) même transitoires et sans séquelles. N’hésitez pas à consulter votre médecin !</div>
         <div id="transfusion">
             <img src="" alt=""/>
             <p>TRANSFUSION<br/>Avez-vous déjà eu une transfusion de sang (globules rouges, plaquettes ou plasma) ou une greffe d’organe ?</p>
             <input value="OUI" type="submit" class="non9"/>
             <input  value="NON" type="submit" class="oui5"/>
         </div>
             <div id="erreur9" style="display: none"> Par mesure de précaution, vous ne pouvez pas donner votre sang</div>
             <input value="Précedent" type="submit" class="précédent2" />
             <input  value="Suivant" type="submit" class="suivant2"/>
         </div>
         <div id="mode" style="display: none">
             <h2>Mode de vie</h2>
             <div id="stupifiants">
                 <img src="" alt=""/>
                 <p>USAGE DE STUPÉFIANTS<br/>Avez-vous déjà pris des drogues illicites et/ou substances dopantes par
                     voie intraveineuse ?</p>
                 <input value="OUI" type="submit" class="non10"/>
                 <input  value="NON" type="submit" class="oui1"/>
             </div>
             <div id="erreur10" style="display: none"> Pour préserver la santé des patients et éviter la transmission d’éventuelles maladies infectieuses,
                 vous ne pouvez pas donner votre san</div>

             <div id="tatouage">
                 <img src="" alt=""/>
                 <p>TATOUAGES ET PIERCING<br/>Avez-vous fait un tatouage ou un piercing (oreilles comprises) dans les 4 derniers mois ?</p>
                 <input value="OUI" type="submit" class="non11"/>
                 <input  value="NON" type="submit" class="oui2"/>
             </div>
             <div id="erreur11" style="display: none">Ce délai permet d’éviter tout risque de transmission d’infection liée à une éventuelle mauvaise
                 stérilisation du matériel. Attendez 4 mois après votre tatouage ou piercing</div>

             <div id="VIESEXUELLE">
                 <img src="" alt=""/>
                 <p>VIE SEXUELLE<br/>Combien de partenaires sexuel avez-vous eu dans les 4 derniers mois ?</p>
                 <input value="+ de 1" type="submit" class="non12"/>
                 <input  value="0 ou 1" type="submit" class="oui3"/>
             </div>
             <div id="erreur12" style="display: none"> Pour préserver la santé des patients et éviter tout risque de transmission de maladies infectieuses,
                 vous ne pouvez pas donner votre sang</div>
             <input value="Précedent" type="submit" class="précédent3" />
             <input  value="Suivant" type="submit" class="suivant3"/>
         </div>
         <div id="operation" style="display: none">
             <h2>Examens et opérations chirurgicales</h2>
            <c:if test="${sex eq 'femme'}">
             <div id="grossesse">
                 <img src="" alt=""/>
                 <p>Grossesse<br/>Êtes-vous enceinte ou avez-vous accouché depuis moins de 6 mois ?</p>
                 <input value="oui" type="submit" class="non13"/>
                 <input  value="non" type="submit" class="oui1"/>
             </div>
             <div id="erreur13" style="display: none">Pour préserver votre santé et éviter tout risque de carence pour vous et votre bébé, vous ne pouvez pas donner votre sang,
                 Après ce délai, vous pourrez à nouveau donner, même si vous allaitez votre enfant... Prenez soin de vous !</div>
            </c:if>
             <div id="anemie">
                 <img src="" alt=""/>
                 <p>Anémie<br/>Êtes-vous suivie par votre médecin pour une anémie (baisse du taux d’hémoglobine) ou un manque de fer ?</p>
                 <input value="oui" type="submit" class="non14"/>
                 <input  value="non" type="submit" class="oui2"/>
             </div>
             <div id="erreur14" style="display: none">Pour préserver votre santé, vous ne pouvez pas donner votre sang!</div>

             <div id="examens">
                 <img src="" alt=""/>
                 <p>Examens<br/>Avez-vous fait un examen de type « fibroscopie » gastrique, ORL,
                     pulmonaire fibroscopie Coloscopie dans les 4 derniers mois ?</p>
                 <input value="oui" type="submit" class="non15"/>
                 <input  value="non" type="submit" class="oui3"/>
             </div>
             <div id="erreur15" style="display: none">Pour préserver votre santé et celle des patients, vous ne pouvez pas donner votre sang!</div>
             <div id="operations">
                 <img src="" alt=""/>
                 <p>OPERATIONS<br/>Avez-vous été opérée dans les 4 derniers mois ?</p>
                 <input value="oui" type="submit" class="non16"/>
                 <input  value="non" type="submit" class="oui4"/>
             </div>
             <div id="erreur16" style="display: none">Pour préserver votre santé et celle des patients, selon la nature de l'opération et la durée de l'hospitalisation, certains dons ne sont pas autorisés. En cas d’intervention chirurgicale prochaine,
                 le don de sang peut être déconseillé</div>


             <input value="Précedent" type="submit" class="précédent4" />
             <input  value="Suivant" type="submit" class="suivant4"/>
         </div>
                 <div id="dernier" style="display: none">
                     <h2>Dernières vérifications</h2>

                     <div id="fièvre">
                         <img src="" alt=""/>
                         <p>FIEVRE<br/>Avez-vous eu de la fièvre* ou une infection (toux, diarrhée, infection urinaire, plaie cutanée…) dans les 2 dernières semaines ?</p>
                         <input value="oui" type="submit" class="non17"/>
                         <input  value="non" type="submit" class="oui1"/>
                     </div>
                     <div id="erreur17" style="display: none">Pour préserver la santé des patients, vous ne pouvez pas donner votre sang,=pour le moment. Attendez 2 semaines après la disparition complète des symptômes !!</div>

                     <div id="SOINS">
                         <img src="" alt=""/>
                         <p>Examens<br/>Avez-vous eu des soins dentaires depuis moins de 24 heures (carie, détartrage), un traitement de racine ou une extraction dentaire depuis moins d’une semaine ?
                         </p>
                         <input value="oui" type="submit" class="non18"/>
                         <input  value="non" type="submit" class="oui2"/>
                     </div>
                     <div id="erreur18" style="display: none">Pour préserver la santé des patients et éviter tout risque de transmission d’éventuelles bactéries, vous ne pouvez pas donner votre sang pour le moment. Attendez 1 jour après votre détartrage, votre traitement de carie ou 1 semaine après votre extraction dentaire ou d’un soin touchant la gencive (anesthésie locale comprise) et revenez nous voir</div>
                     <div id="medicament">
                         <img src="" alt=""/>
                         <p>MEDICAMENTS<br/>APrenez-vous des médicaments, même tous les jours ?</p>
                         <input value="oui" type="submit" class="non19"/>
                         <input  value="non" type="submit" class="oui3"/>
                     </div>
                     <div id="erreur19" style="display: none">La prise de médicaments n’empêche généralement pas de donner son sang (sauf pour certains d’entre eux)!</div>


                     <input value="Précedent" type="submit" class="précédent5" />
                     <input  value="Valider" type="submit" class="valider"/>
                 </div>
                 <div id="resultat" style="display: none">Bravo, d'après les informations indiquées, vous remplissez toutes les conditions pour donner votre sang!!</div>
         <div id="alert" style="display: none">Attention.Veuiller traiter tous les champs SVP!!</div>


     </form>

</body>
<script src="https://code.jquery.com/jquery-1.12.3.js" integrity="sha256-1XMpEtA4eKXNNpXcJ1pmMPs8JV+nwLdEqwiJeCQEkyc=" crossorigin="anonymous"></script>
<script type="text/javascript">
    $newItemForm = $('#newItemForm');
    var $chek1=false;
    var $chek2=false;
    var $chek3=false;
    var $chek4=false;
    var $chek5=false;

    $newItemForm.on('click','.non1',function(e) {
        e.preventDefault();
        $('#erreur2').hide();
        $('#erreur1').show(); });
        $newItemForm.on('click','.non2',function(e) {
            e.preventDefault();
            $('#erreur1').hide();
            $('#erreur2').show();

    });
    $newItemForm.on('click','.non3',function(e) {
        e.preventDefault();
        $('#erreur3').show();


    });
    $newItemForm.on('click','.non4',function(e) {
        e.preventDefault();
        $('#erreur4').show();


    });
    $newItemForm.on('click','.oui1',function(e) {
        e.preventDefault();
         $chek1=true;
    });
    $newItemForm.on('click','.oui2',function(e) {
        e.preventDefault();
        $chek2=true;
    });
    $newItemForm.on('click','.oui3',function(e) {
        e.preventDefault();
        $chek3=true;
    });
    $newItemForm.on('click','.oui4',function(e) {
        e.preventDefault();
        $chek4=true;
    });
    $newItemForm.on('click','.oui5',function(e) {
        e.preventDefault();
        $chek5=true;
    });
    $newItemForm.on('click','.suivant1',function(e) {
        e.preventDefault();

        if($chek1 && $chek2 && $chek3) {
            $('#PremiersCritères').hide();
            $('#Maladies').show();
            $('#alert').hide();

        }
        else {
        $('#alert').show();
    }
        $chek1=false;
        $chek2=false;
        $chek3=false;

    });
    $newItemForm.on('click','.suivant2',function(e) {
        e.preventDefault();

        if($chek1 && $chek2 && $chek3 && $chek4 && $chek5) {
        $('#Maladies').hide();
        $('#mode').show();
            $('#alert').hide();
        }else{
            $('#alert').show();
        }
        $chek1=false;
        $chek2=false;
        $chek3=false;
        $chek4=false;
        $chek5=false;

    });
    $newItemForm.on('click','.précédent2',function(e) {
        e.preventDefault();
        $('#Maladies').hide();
        $('#PremiersCritères').show();

    });
    $newItemForm.on('click','.précédent3',function(e) {
        e.preventDefault();
        $('#mode').hide();
        $('#Maladies').show();


    });
    $newItemForm.on('click','.suivant3',function(e) {

        e.preventDefault();
        if($chek1 && $chek2 && $chek3) {
        $('#mode').hide();
        $('#operation').show();
            $('#alert').hide();
    }else{
        $('#alert').show();
    }
        $chek1=false;
        $chek2=false;
        $chek3=false;

    });
    $newItemForm.on('click','.suivant4',function(e) {
        e.preventDefault();
        if($chek1 && $chek2 && $chek3 &&  $chek4) {
        $('#operation').hide();
        $('#dernier').show();
            $('#alert').hide();
    }else{
        $('#alert').show();
    }
        $chek1=false;
        $chek2=false;
        $chek3=false;
        $chek4=false;

    });
    $newItemForm.on('click','.précédent4',function(e) {
        e.preventDefault();
        $('#operation').hide();
        $('#mode').show();

    });
    $newItemForm.on('click','.précédent5',function(e) {
        e.preventDefault();
        $('#dernier').hide();
        $('#operation').show();

    });
    $newItemForm.on('click','.valider',function(e) {
        e.preventDefault();
        if($chek1 && $chek2 && $chek3) {
        $('#dernier').hide();
        $('#resultat').show();
            $('#alert').hide();
    }else{
        $('#alert').show();
    }


    });
    $newItemForm.on('click','.non5',function(e) {
        e.preventDefault();
        $('#erreur5').show();
    });
    $newItemForm.on('click','.non6',function(e) {
        e.preventDefault();
        $('#erreur6').show();
    });
    $newItemForm.on('click','.non7',function(e) {
        e.preventDefault();
        $('#erreur7').show();
    });
    $newItemForm.on('click','.non8',function(e) {
        e.preventDefault();
        $('#erreur8').show();
    });
    $newItemForm.on('click','.non9',function(e) {
        e.preventDefault();
        $('#erreur9').show();
    });
    $newItemForm.on('click','.non10',function(e) {
        e.preventDefault();
        $('#erreur10').show();
    });
    $newItemForm.on('click','.non11',function(e) {
        e.preventDefault();
        $('#erreur11').show();
    });
    $newItemForm.on('click','.non12',function(e) {
        e.preventDefault();
        $('#erreur12').show();
    });
    $newItemForm.on('click','.non13',function(e) {
        e.preventDefault();
        $('#erreur13').show();
    });
    $newItemForm.on('click','.non14',function(e) {
        e.preventDefault();
        $('#erreur14').show();
    });
    $newItemForm.on('click','.non15',function(e) {
        e.preventDefault();
        $('#erreur15').show();
    });
    $newItemForm.on('click','.non16',function(e) {
        e.preventDefault();
        $('#erreur16').show();
    });
    $newItemForm.on('click','.non17',function(e) {
        e.preventDefault();
        $('#erreur17').show();
    });
    $newItemForm.on('click','.non18',function(e) {
        e.preventDefault();
        $('#erreur18').show();
    });
    $newItemForm.on('click','.non19',function(e) {
        e.preventDefault();
        $('#erreur19').show();
    });





</script>
</html>
