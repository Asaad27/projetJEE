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
<html >
<head>
    <link rel="stylesheet" ref="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" ref="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.0.3/css/font-awesome.css">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
    <link rel="stylesheet" type="text/css" href="css/style3.css">
    <%@include file="../header.jsp"%>
</head>
<body  style="height: 1200px;">
<img src="img/don-sang.jpg" class="bg1"/>
<%@include file="../navBar.jsp"%>
<ul id="progressbar">
    <li class="active" id="etape1"><strong>Les premières critères</strong></li>
    <li id="etape2"><strong>Maladies et infections chroniques</strong></li>
    <li id="etape3"><strong>Examens et opérations chirurgicales</strong></li>
    <li id="etape4"><strong>Mode de vie</strong></li>
    <li id="etape5"><strong>Dernières vérifications</strong></li>
</ul>
     <form id="msform"  style="z-index: -3;">

         <div id="PremiersCritères" >
             <h2></h2>
           <div id="sex" style="">
           <p class="question">Etes-vous une femme ou un homme ?</p>
           <c:set var="sex" value="${param.btn}"></c:set>
               <div class="choix" style="">
                   <p><input type="submit"   id="femme"  name="btn" value="femme"/></p>
               <p><input  type="submit"  id="homme" name="btn" value="homme"/></p>
               </div>
       </div>

         <div id="age">
             <img src="" alt=""/>
             <p class="question">Quel est votre age ?</p>
             <div class="choix">
            <p><input value="- de 18 ans " type="submit" class="non1"/></p>
                 <p><input  value="de 18 à 70 ans" type="submit" class="oui1"/></p>
                 <p> <input  value="+ 70 ans" type="submit" class="non2"/></p>
             </div>
         </div>

         <div id="erreur1"  class="error" style="display: none">Pour donner son sang, il faut être  majeur. Un 1er don de sang est une belle façon pour fêter votre majorité</div>
         <div id="erreur2" class="error" style="display: none">Pour préserver votre santé, il n’est plus possible de faire un don de sang total après 70 ans</div>
         <div id="poids">
             <img src="" alt=""/>
            <p class="question">Quel est votre poid ?</p>
             <div class="choix">
                 <p> <input value="- de 50 kg" type="submit" class="non3"/></p>
                 <p><input  value="+ de 50 kg" type="submit" class="oui2"/></p>
             </div>
         </div>

         <div id="erreur3"  class="error" style="display: none"> Pour préserver votre santé,
             vous serrez en mesure de donner votre sang total si vous pesez plus de 50 kg</div>
         <div id="historique">
             <img src="" alt=""/>
             <p class="question">Votre dernier don date de moins de 8 semaines ?</p>
             <div class="choix">
                 <p><input value="OUI" type="submit" class="non4"/></p>
                 <p><input  value="NON" type="submit" class="oui3"/></p>

             </div>
         </div>

         <div id="erreur4"  class="error" style="display: none"> vous ne pouvez pas donner votre sang pour le moment,Votre dernier don est trop récent!!</div>
             <div class="passer">
                 <p> <input  value="Suivant" type="submit" class="suivant1" name="previous" class="next action-button"/></p>
             </div>
         </div>
         <div id="Maladies" class="error" style="display: none">

             <div id="sida">
                 <img src="" alt=""/>
                 <p class="question">Avez-vous été testé(e) positif pour le VIH (sida) ?</p>
                 <div class="choix">
                     <p><input value="OUI" type="submit" class="non5"/></p>
                     <p><input  value="NON" type="submit" class="oui1"/></p>
                 </div>
             </div>

             <div id="erreur5" class="error" class="error" style="display: none"> Certaines maladies comme le VIH, les hépatites B et C ou la syphilis sont transmissibles par le sang. Pour garantir la sécurité des patients et éviter tout risque de contamination,
                 vous ne pouvez pas donner votre sang</div>

         <div id="concer">
             <img src="" alt=""/>
             <p class="question">Avez-vous eu un cancer au cours de votre vie ?</p>
             <div class="choix">
                 <p> <input value="OUI" type="submit" class="non6"/></p>
                 <p><input  value="NON" type="submit" class="oui2"/></p>
             </div>
         </div>

         <div id="erreur6" class="error" style="display: none"> Pour préserver votre santé, vous ne pouvez pas donner votre sang, sauf pour les cancers  du col de l’utérus et certains cancers superficiels de la peau</div>

         <div id="chronique">
             <img src="" alt=""/>
             <p class="question">Êtes-vous traitée pour une maladie chronique telle que : diabète ?</p>
             <div class="choix">
                 <p> <input value="OUI" type="submit" class="non7"/></p>
                 <p><input  value="NON" type="submit" class="oui3"/></p>
         </div>

         <div id="erreur7" class="error" style="display: none"> Pour préserver votre santé, vous ne pouvez pas donner votre sang</div>
         <div id="AVC">
             <img src="" alt=""/>
             <p class="question">Avez-vous ressenti, dans les dernières semaines,un essoufflement anormal à la suite d’un effort ?</p>
             <div class="choix">
                 <p> <input value="OUI" type="submit" class="non8"/></p>
                 <p> <input  value="NON" type="submit" class="oui4"/></p>
             </div>
         </div>

         <div id="erreur8"class="error" style="display: none"> Pour préserver votre santé, vous ne pouvez pas donner votre sang,
             Le don n'est pas autorisé en cas de problèmes cardiaques ou d’antécédents d’accidents vasculaires (AVC) même transitoires et sans séquelles. N’hésitez pas à consulter votre médecin !</div>
         <div id="transfusion">
             <img src="" alt=""/>
             <p class="question">Avez-vous déjà eu une transfusion de sang ou une greffe d’organe ?</p>
             <div class="choix">
                 <p><input value="OUI" type="submit" class="non9"/></p>
                 <p> <input  value="NON" type="submit" class="oui5"/></p>
             </div>
         </div>

             <div id="erreur9" class="error" style="display: none"> Par mesure de précaution, vous ne pouvez pas donner votre sang</div>
             <div class="passer">
                 <p> <input value="Précedent" type="submit" class="précédent2" /></p>
                 <p> <input  value="Suivant" type="submit" class="suivant2"/></p>
             </div>
         </div>
         </div>
         <div id="mode" style="display: none">

             <div id="stupifiants">
                 <img src="" alt=""/>
                 <p class="question">Avez-vous déjà pris des drogues illicites ?</p>
                 <div class="choix">
                     <p> <input value="OUI" type="submit" class="non10"/></p>
                     <p> <input  value="NON" type="submit" class="oui1"/></p>
                 </div>
             </div>

             <div id="erreur10" class="error" style="display: none"> Pour préserver la santé des patients et éviter la transmission d’éventuelles maladies infectieuses,
                 vous ne pouvez pas donner votre san</div>

             <div id="tatouage">
                 <img src="" alt=""/>
                 <p class="question">Avez-vous fait un tatouage ou un piercing  dans les 4 derniers mois ?</p>
                 <div class="choix">
                 <p><input value="OUI" type="submit" class="non11"/></p>
                 <p> <input  value="NON" type="submit" class="oui2"/></p>
                 </div>
             </div>

             <div id="erreur11" class="error" style="display: none">Ce délai permet d’éviter tout risque de transmission d’infection liée à une éventuelle mauvaise
                 stérilisation du matériel. Attendez 4 mois après votre tatouage ou piercing</div>

             <div id="VIESEXUELLE">
                 <img src="" alt=""/>
                 <p class="question">Combien de partenaires sexuel avez-vous eu dans les 4 derniers mois ?</p>
                 <div class="choix">
                     <p><input value="+ de 1" type="submit" class="non12"/></p>
                     <p> <input  value="0 ou 1" type="submit" class="oui3"/></p>
                 </div>
             </div>

             <div id="erreur12" class="error" style="display: none"> Pour préserver la santé des patients et éviter tout risque de transmission de maladies infectieuses,
                 vous ne pouvez pas donner votre sang</div>
                 <div class="choix" style="margin-top: 10px;">
                 <p><input value="Précedent" type="submit" class="précédent3" /></p>
                     <p> <input  value="Suivant" type="submit" class="suivant3"/></p>
                 </div>
         </div>

         <div id="operation" style="display: none">

             <div id="anemie">
                 <img src="" alt=""/>
                 <p class="question">Êtes-vous suivie par votre médecin pour une anémie  ou un manque de fer ?</p>
                 <div class="passer">
                     <p> <input value="oui" type="submit" class="non14"/></p>
                     <p>   <input  value="non" type="submit" class="oui2"/></p>
                 </div>
             </div>

             <div id="erreur14" class="error" style="display: none">Pour préserver votre santé, vous ne pouvez pas donner votre sang!</div>

             <div id="examens">
                 <img src="" alt=""/>
                 <p class="question">Avez-vous fait un examen de type « fibroscopie » gastrique, ORL,
                     pulmonaire fibroscopie Coloscopie dans les 4 derniers mois ?</p>
                 <div class="choix">
                     <p>  <input value="oui" type="submit" class="non15"/></p>
                     <p> <input  value="non" type="submit" class="oui3"/></p>
                 </div>
             </div>

             <div id="erreur15" class="error" style="display: none">Pour préserver votre santé et celle des patients, vous ne pouvez pas donner votre sang!</div>
             <div id="operations">
                 <img src="" alt=""/>
                 <p class="question">Avez-vous été opérée dans les 4 derniers mois ?</p>
                 <div class="choix">
               <p> <input value="oui" type="submit" class="non16"/></p>
                     <p>  <input  value="non" type="submit" class="oui4"/></p>
                 </div>
             </div>

             <div id="erreur16" class="error" style="display: none">Pour préserver votre santé et celle des patients, selon la nature de l'opération et la durée de l'hospitalisation, certains dons ne sont pas autorisés. En cas d’intervention chirurgicale prochaine,
                 le don de sang peut être déconseillé</div>
             <div class="passer">
                 <p> <input value="Précedent" type="submit" class="précédent4" /></p>
                 <p> <input  value="Suivant" type="submit" class="suivant4"/></p>
             </div>
         </div>
                 <div id="dernier" style="display: none">


                     <div id="fièvre">
                         <img src="" alt=""/>
                         <p class="question">Avez-vous eu de la fièvre ou une infectionx dans les 2 dernières semaines ?</p>
                         <div class="choix">
                             <p> <input value="oui" type="submit" class="non17"/></p>
                             <p> <input  value="non" type="submit" class="oui1"/></p>
                         </div>
                     </div>

                     <div id="erreur17" class="error" style="display: none">Pour préserver la santé des patients, vous ne pouvez pas donner votre sang,=pour le moment. Attendez 2 semaines après la disparition complète des symptômes !!</div>

                     <div id="SOINS">
                         <img src="" alt=""/>
                         <<p class="question">Avez-vous eu des soins dentaires depuis moins de 24 heures  ?
                         </p>
                         <div class="choix">
                             <p>  <input value="oui" type="submit" class="non18"/></p>
                             <p><input  value="non" type="submit" class="oui2"/></p>
                     </div>

                     <div id="erreur18"  class="error" style="display: none">Pour préserver la santé des patients et éviter tout risque de transmission d’éventuelles bactéries, vous ne pouvez pas donner votre sang pour le moment. Attendez 1 jour après votre détartrage, votre traitement de carie ou 1 semaine après votre extraction dentaire ou d’un soin touchant la gencive (anesthésie locale comprise) et revenez nous voir</div>
                     <div id="medicament">
                         <img src="" alt=""/>
                         <p class="question">Prenez-vous des médicaments, même tous les jours ?</p>
                         <div class="choix">
                         <p> <input value="oui" type="submit" class="non19"/></p>
                         <p> <input  value="non" type="submit" class="oui3"/></p>
                         </div>
                     </div>

                     </div>
                     <div id="erreur19" class="error" style="display: none">La prise de médicaments n’empêche généralement pas de donner son sang (sauf pour certains d’entre eux)!</div>

                     <div class="passer">
                         <p> <input value="Précedent" type="submit" class="précédent5" /></p>
                         <p> <input  value="Valider" type="submit" class="valider"/></p>
                     </div>
                 </div>
                 <div id="resultat" style="display: none"><p class="alert alert-success" style="width:450px;">Bravo, d'après les informations indiquées, vous remplissez toutes les conditions pour donner votre sang!!
                 </p><img src="../img/valider.jpg" style="width: 400px;z-index: 4;"/>
                 </div>
         <div id="alert" class="error" style="display: none">Attention.Veuiller traiter tous les champs SVP!!</div>


     </form>
<%@include file="../footer.jsp"%>
</body>

<script src="https://code.jquery.com/jquery-1.12.3.js" integrity="sha256-1XMpEtA4eKXNNpXcJ1pmMPs8JV+nwLdEqwiJeCQEkyc=" crossorigin="anonymous"></script>
<script type="text/javascript">
    $newItemForm = $('#msform');
    var $chek1=false;
    var $chek2=false;
    var $chek3=false;
    var $chek4=false;
    var $chek5=false;
    $newItemForm.on('click','#femme',function(e) {
        e.preventDefault();
        $('#femme').css('background-color','#ff3333');
    });

    $newItemForm.on('click','#homme',function(e) {
        e.preventDefault();
        $('#homme').css('background-color','#ff3333');
    });

    $newItemForm.on('click','.non1',function(e) {
        e.preventDefault();
        $('#erreur2').hide();
        $('#erreur1').show();
        $('.non1').css('background-color','#ff0000');
    });

        $newItemForm.on('click','.non2',function(e) {
            e.preventDefault();
            $('#erreur1').hide();
            $('#erreur2').show();
            $('.non2').css('background-color','#ff0000');


    });
    $newItemForm.on('click','.non3',function(e) {
        e.preventDefault();
        $('#erreur3').show();
        $('.non3').css('background-color','#ff0000');


    });
    $newItemForm.on('click','.non4',function(e) {
        e.preventDefault();
        $('#erreur4').show();
        $('.non4').css('background-color','#ff0000');


    });
    $newItemForm.on('click','.oui1',function(e) {
        e.preventDefault();
         $chek1=true;
         $('.oui1').css('background-color','#ff3333');
    });
    $newItemForm.on('click','.oui2',function(e) {
        e.preventDefault();
        $chek2=true;
        $('.oui2').css('background-color','#ff3333');
    });
    $newItemForm.on('click','.oui3',function(e) {
        e.preventDefault();
        $chek3=true;
        $('.oui3').css('background-color','#ff3333');
    });
    $newItemForm.on('click','.oui4',function(e) {
        e.preventDefault();
        $chek4=true;
        $('.oui4').css('background-color','#ff3333');
    });
    $newItemForm.on('click','.oui5',function(e) {
        e.preventDefault();
        $chek5=true;
        $('.oui5').css('background-color','#ff3333');
    });
    $newItemForm.on('click','.suivant1',function(e) {
        e.preventDefault();

        if($chek1 && $chek2 && $chek3) {
            $('#PremiersCritères').hide();
            $('#Maladies').show();
            $('#alert').hide();
            $('#etape2').addClass('active');
            $('.oui1').css('background-color','#D92228');
            $('.oui2').css('background-color','#D92228');
            $('.oui3').css('background-color','#D92228');
            $('.oui4').css('background-color','#D92228');
            $('.oui5').css('background-color','#D92228');
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
        $('#etape3').addClass('active');
        $('.oui1').css('background-color','#D92228');
        $('.oui2').css('background-color','#D92228');
        $('.oui3').css('background-color','#D92228');
        $('.oui4').css('background-color','#D92228');
        $('.oui5').css('background-color','#D92228');
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
        $('#etape2').removeClass("active");

    });
    $newItemForm.on('click','.précédent3',function(e) {
        e.preventDefault();
        $('#mode').hide();
        $('#Maladies').show();
        $('#etape3').removeClass("active");

    });
    $newItemForm.on('click','.suivant3',function(e) {

        e.preventDefault();
        if( $chek1 && $chek2 && $chek3) {
        $('#mode').hide();
        $('#operation').show();
        $('#alert').hide();
        $('#etape4').addClass('active');
        $('.oui1').css('background-color','#D92228');
        $('.oui2').css('background-color','#D92228');
        $('.oui3').css('background-color','#D92228');
        $('.oui4').css('background-color','#D92228');
        $('.oui5').css('background-color','#D92228');
    }else{
        $('#alert').show();
    }
        $chek1=false;
        $chek2=false;
        $chek3=false;

    });
    $newItemForm.on('click','.suivant4',function(e) {
        e.preventDefault();
        if(($chek1 && $chek2 && $chek3 && $chek4) || ($chek2 && $chek3 && $chek4)) {
          $('#operation').hide();
          $('#dernier').show();
          $('#alert').hide();
          $('#etape5').addClass('active');
          $('.oui1').css('background-color','#D92228');
          $('.oui2').css('background-color','#D92228');
          $('.oui3').css('background-color','#D92228');
          $('.oui4').css('background-color','#D92228');
          $('.oui5').css('background-color','#D92228');
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
        $('#etape4').removeClass("active");

    });
    $newItemForm.on('click','.précédent5',function(e) {
        e.preventDefault();
        $('#dernier').hide();
        $('#operation').show();
        $('#etape5').removeClass("active");

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
        $('.non5').css('background-color','#ff3333');
    });
    $newItemForm.on('click','.non6',function(e) {
        e.preventDefault();
        $('#erreur6').show();
        $('.non6').css('background-color','#ff3333');
    });
    $newItemForm.on('click','.non7',function(e) {
        e.preventDefault();
        $('#erreur7').show();
        $('.non7').css('background-color','#ff3333');
    });
    $newItemForm.on('click','.non8',function(e) {
        e.preventDefault();
        $('#erreur8').show();
        $('.non8').css('background-color','#ff3333');
    });
    $newItemForm.on('click','.non9',function(e) {
        e.preventDefault();
        $('#erreur9').show();
        $('.non9').css('background-color','#ff3333');
    });
    $newItemForm.on('click','.non10',function(e) {
        e.preventDefault();
        $('#erreur10').show();
        $('.non10').css('background-color','#ff3333');
    });
    $newItemForm.on('click','.non11',function(e) {
        e.preventDefault();
        $('#erreur11').show();
        $('.non11').css('background-color','#ff3333');
    });
    $newItemForm.on('click','.non12',function(e) {
        e.preventDefault();
        $('#erreur12').show();
        $('.non12').css('background-color','#ff3333');
    });
    $newItemForm.on('click','.non13',function(e) {
        e.preventDefault();
        $('#erreur13').show();
        $('.non13').css('background-color','#ff3333');
    });
    $newItemForm.on('click','.non14',function(e) {
        e.preventDefault();
        $('#erreur14').show();
        $('.non14').css('background-color','#ff3333');
    });
    $newItemForm.on('click','.non15',function(e) {
        e.preventDefault();
        $('#erreur15').show();
        $('.non15').css('background-color','#ff3333');
    });
    $newItemForm.on('click','.non16',function(e) {
        e.preventDefault();
        $('#erreur16').show();
        $('.non16').css('background-color','#ff3333');
    });
    $newItemForm.on('click','.non17',function(e) {
        e.preventDefault();
        $('#erreur17').show();
        $('.non17').css('background-color','#ff3333');
    });
    $newItemForm.on('click','.non18',function(e) {
        e.preventDefault();
        $('#erreur18').show();
        $('.non18').css('background-color','#ff3333');
    });
    $newItemForm.on('click','.non19',function(e) {
        e.preventDefault();
        $('#erreur19').show();
        $('.non19').css('background-color','#ff3333');
    });

</script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</html>
