<%--
  Created by IntelliJ IDEA.
  User: Fatima zahra Azennag
  Date: 21/02/2021
  Time: 12:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">


    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <script src="js/fontawesome-all.min.js"></script>
    <style>
      body, html {
            height:100%;
            margin: 0;
        }


        .bg{
            /* The image used */
            background-image: url("<c:url value="img/background.jpg"/>");

            /* Full height */
            height: 50%;

            /* Center and scale the image nicely */
            background-position: center;
            background-repeat: no-repeat;
            background-size: cover;
        }
      img.bg1{
          /* Set rules to fill background */
          min-height: 100%;
          min-width: 1024px;

          /* Set up proportionate scaling */
          width: 100%;
          height: auto;

          /* Set up positioning */
          position: fixed;
          top: 0;
          left: 0;
          Z-index:-4;

      }

      @media screen and (max-width: 1024px) { /* Specific to this particular image */
          .bg1 {
              left: 50%;
              margin-left: -512px;   /* 50% */
          }
      }
      .butt{
             width: 30px;
             height: 30px;
      }
      .hero {
          position: absolute;
          top: 50%;
          left: 50%;
          z-index: 3;
          color: black;
          text-align: center;
          text-transform: uppercase;
          text-shadow: 1px 1px 0 rgba(0,0,0,.75);
          -webkit-transform: translate3d(-50%,-50%,0);
          -moz-transform: translate3d(-50%,-50%,0);
          -ms-transform: translate3d(-50%,-50%,0);
          -o-transform: translate3d(-50%,-50%,0);
          transform: translate3d(-50%,-50%,0);
      }
    </style>






