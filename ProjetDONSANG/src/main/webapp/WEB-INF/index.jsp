<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <%@include file="../header.jsp" %>
</head>
<body class="bg">
     <%@include file="../navBar.jsp" %>
<section >
<div ></div>
</section>
   <section style="background-color: white;height:500px;position: absolute;left: 400px;right: 0;top: 750px;bottom: 0;">
       <div class="container col-md-8 align-content-center">
           <!--Section: Contact v.2-->
           <section class="mb-4">

               <!--Section heading-->
               <div class="section-title text-center wow zoomIn mt-4">
                   <h1>Contactez-nous</h1>
                   <span></span>
               </div>
               <!--Section description-->
               <p class="text-center w-responsive mx-auto ">Si vous avez des questions? N'hésitez pas à nous contacter directement
                   .Notre équipe est disponible pour vous aider.</p>

               <c:if test="${not empty isInserted}">
                   <h5 class='h5 text-center  mt-4'>
                       <div class='alert alert-success'>Message sent</div>
                   </h5>
               </c:if>

               <div class="row">

                   <!--Grid column-->
                   <div class="col-md-9 mb-md-0 mb-5">
                       <form id="contact-form" name="contact-form" action="contact" method="POST">

                           <!--Grid row-->
                           <div class="row">

                               <!--Grid column-->

                               <!--Grid column-->

                               <!--Grid column-->
                               <div class="col-md-6">
                                   <div class="md-form mb-0">
                                       <input type="text" id="email" name="email" class="form-control">
                                       <label for="email" class="">Votre email</label>
                                   </div>
                               </div>
                               <!--Grid column-->
                               <div class="col-md-6">
                                   <div class="md-form mb-0">
                                       <input type="text" id="pass" name="pass" class="form-control">
                                       <label for="pass" class="">mot de passe de votre email</label>
                                   </div>
                               </div>

                           </div>
                           <!--Grid row-->

                           <!--Grid row-->

                           <div class="row">
                               <div class="col-md-6">
                                   <div class="md-form mb-0">
                                       <input type="text" id="name" name="name" class="form-control">
                                       <label for="name" class="">Votre name</label>
                                   </div>
                               </div>

                               <div class="col-md-6">
                                   <div class="md-form mb-0">
                                       <input type="text" id="subject" name="subject" class="form-control">
                                       <label for="subject" class="">Sujet</label>
                                   </div>
                               </div>
                           </div>
                           <!--Grid row-->

                           <!--Grid row-->
                           <div class="row">

                               <!--Grid column-->
                               <div class="col-md-12">

                                   <div class="md-form">
                                <textarea type="text" id="message" name="message" rows="2"
                                          class="form-control md-textarea"></textarea>
                                       <label for="message">Votre message</label>
                                   </div>

                               </div>
                           </div>
                           <!--Grid row-->

                           <div class="text-center text-md-left">
                               <button class="btn btn-danger" name="submit" type="submit">Envoyer</button>
                           </div>

                       </form>
                       <c:if test="${not empty Message}">
                       <div class='alert ${Message == 'The e-mail was sent successfully' ? 'alert-success' : 'alert-danger'}'>${Message}</div>

                       <div class="status"></div>
                       </c:if>
                   </div>

                   <!--Grid column-->

                   <!--Grid column-->
                   <div class="col-md-3 text-center">
                       <ul class="list-unstyled mb-0">
                           <li><i class="fas fa-map-marker-alt fa-2x"></i>
                               <p>Madinat Al Irfane, Rabat 10 000, MOROCCO</p>
                           </li>

                           <li><i class="fas fa-phone mt-4 fa-2x"></i>
                               <p>+ 212 234 567 89</p>
                           </li>

                           <li><i class="fas fa-envelope mt-4 fa-2x"></i>
                               <p>contact@bloodbrothers.com</p>
                           </li>
                       </ul>
                   </div>
                   <!--Grid column-->

               </div>
   </section>
       </div>
   </section>
     <br/>
     <br/>
     <br/>
     <br/>
     <br/>
     <br/>
     <%@include file="../footer.jsp" %>


</body>
</html>