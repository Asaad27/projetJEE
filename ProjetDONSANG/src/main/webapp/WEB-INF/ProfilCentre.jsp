<%--
  Created by IntelliJ IDEA.
  User: Fatima zahra Azennag
  Date: 23/02/2021
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <%@include file="../header.jsp"%>
    <title>Title</title>

</head>
<body style="height:900px;">
     <%@include file="../navBar.jsp"%>
     <div class="row mt-5">
         <div class="card">
             <div class="card-header text-center" style="font-size: 24px"></div>
             <div class="card-body">
                 <div id="container1" style="margin: 0 auto;width: 800px;"></div>
             </div>
         </div>
     </div>

     <section style="text-align: center;">
         <div class="col-lg-4 col-md-4 col-xs-4 ">
             <a href="ajouterdemande">
                 <img src="img/demandeSang.jpg" title="Ajouter une demande de sang" class=" img-circle" style="width:304px; height: 206px;"/>
             </a>
             <p><strong>Ajouter une demande de sang</strong></p>
         </div>
         <div class="col-lg-4 col-md-4 col-xs-4 ">
             <a href="AjouterCompagne"><img src="img/evenement.png" class=" img-circle" style="width:304px;height: 206px;"/></a>
             <p><strong>Ajouter un événement</strong></p>
         </div>
         <div  class="col-lg-4 col-md-4 col-xs-4 ">
             <a href="AjouterStock"><img src="img/stock.jpg" class=" img-circle" style="width:304px;height: 206px;"/></a>
             <p><strong>Gérer le stock</strong></p>
         </div>

     </section>

     </div>


     <%@include file="../footer.jsp"%>
     <script src="https://code.highcharts.com/highcharts.js"></script>
     <script src="https://code.highcharts.com/modules/exporting.js"></script>
     <script src="https://code.highcharts.com/modules/export-data.js"></script>
     <script src="https://code.highcharts.com/modules/series-label.js"></script>
     <script src="https://code.highcharts.com/modules/data.js"></script>
     <script src="https://code.highcharts.com/modules/drilldown.js"></script>
     <script>
         // Create the chart
         Highcharts.chart('container1', {
             chart: {
                 type: 'column'
             },
             title: {
                 text: 'Les statistiques Courantes'
             },
             subtitle: {
                 text: '${sessionScope.centre.nameCentre}'
             },
             xAxis: {
                 type: 'category'
             },
             yAxis: {
                 title: {
                     text: 'Quantité Totale en L'
                 }
             },
             legend: {
                 enabled: false
             },
             plotOptions: {
                 series: {
                     borderWidth: 0,
                     dataLabels: {
                         enabled: true,
                         format: '{point.y:.1f}L'
                     }
                 }
             },
             tooltip: {
                 headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
                 pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.2f}</b> L<br/>'
             },
             "series": [
                 {
                     "name": "Browsers",
                     "colorByPoint": true,
                     "data": [
                         {
                             "name": "A+",
                             "y": ${stocks.get(0).quantiteStock},
                             "drilldown": "A+"
                         },
                         {
                             "name": "A-",
                             "y": ${stocks.get(1).quantiteStock},
                             "drilldown": "A-"
                         },
                         {
                             "name": "AB+",
                             "y": ${stocks.get(2).quantiteStock},
                             "drilldown": "AB+"
                         },
                         {
                             "name": "AB-",
                             "y": ${stocks.get(3).quantiteStock},
                             "drilldown": "AB-"
                         },
                         {
                             "name": "O+",
                             "y": ${stocks.get(4).quantiteStock},
                             "drilldown": "O+"
                         },
                         {
                             "name": "O-",
                             "y": ${stocks.get(5).quantiteStock},
                             "drilldown": "O-"
                         },
                         {
                             "name": "B+",
                             "y": ${stocks.get(6).quantiteStock},
                             "drilldown": "B+"
                         },
                         {
                             "name": "B-",
                             "y": ${stocks.get(7).quantiteStock},
                             "drilldown": "B-"
                         }
                     ]
                 }
             ],
             "drilldown": {
                 "series": [
                     {
                         "name": "Chrome",
                         "id": "Chrome",
                         "data": [
                             [
                                 "v65.0",
                                 0.1
                             ],
                             [
                                 "v64.0",
                                 1.3
                             ],
                             [
                                 "v63.0",
                                 53.02
                             ],
                             [
                                 "v62.0",
                                 1.4
                             ],
                             [
                                 "v61.0",
                                 0.88
                             ],
                             [
                                 "v60.0",
                                 0.56
                             ],
                             [
                                 "v59.0",
                                 0.45
                             ],
                             [
                                 "v58.0",
                                 0.49
                             ],
                             [
                                 "v57.0",
                                 0.32
                             ],
                             [
                                 "v56.0",
                                 0.29
                             ],
                             [
                                 "v55.0",
                                 0.79
                             ],
                             [
                                 "v54.0",
                                 0.18
                             ],
                             [
                                 "v51.0",
                                 0.13
                             ],
                             [
                                 "v49.0",
                                 2.16
                             ],
                             [
                                 "v48.0",
                                 0.13
                             ],
                             [
                                 "v47.0",
                                 0.11
                             ],
                             [
                                 "v43.0",
                                 0.17
                             ],
                             [
                                 "v29.0",
                                 0.26
                             ]
                         ]
                     },
                     {
                         "name": "Firefox",
                         "id": "Firefox",
                         "data": [
                             [
                                 "v58.0",
                                 1.02
                             ],
                             [
                                 "v57.0",
                                 7.36
                             ],
                             [
                                 "v56.0",
                                 0.35
                             ],
                             [
                                 "v55.0",
                                 0.11
                             ],
                             [
                                 "v54.0",
                                 0.1
                             ],
                             [
                                 "v52.0",
                                 0.95
                             ],
                             [
                                 "v51.0",
                                 0.15
                             ],
                             [
                                 "v50.0",
                                 0.1
                             ],
                             [
                                 "v48.0",
                                 0.31
                             ],
                             [
                                 "v47.0",
                                 0.12
                             ]
                         ]
                     },
                     {
                         "name": "Internet Explorer",
                         "id": "Internet Explorer",
                         "data": [
                             [
                                 "v11.0",
                                 6.2
                             ],
                             [
                                 "v10.0",
                                 0.29
                             ],
                             [
                                 "v9.0",
                                 0.27
                             ],
                             [
                                 "v8.0",
                                 0.47
                             ]
                         ]
                     },
                     {
                         "name": "Safari",
                         "id": "Safari",
                         "data": [
                             [
                                 "v11.0",
                                 3.39
                             ],
                             [
                                 "v10.1",
                                 0.96
                             ],
                             [
                                 "v10.0",
                                 0.36
                             ],
                             [
                                 "v9.1",
                                 0.54
                             ],
                             [
                                 "v9.0",
                                 0.13
                             ],
                             [
                                 "v5.1",
                                 0.2
                             ]
                         ]
                     },
                     {
                         "name": "Edge",
                         "id": "Edge",
                         "data": [
                             [
                                 "v16",
                                 2.6
                             ],
                             [
                                 "v15",
                                 0.92
                             ],
                             [
                                 "v14",
                                 0.4
                             ],
                             [
                                 "v13",
                                 0.1
                             ]
                         ]
                     },
                     {
                         "name": "Opera",
                         "id": "Opera",
                         "data": [
                             [
                                 "v50.0",
                                 0.96
                             ],
                             [
                                 "v49.0",
                                 0.82
                             ],
                             [
                                 "v12.1",
                                 0.14
                             ]
                         ]
                     }
                 ]
             }
         });
     </script>
</body>
</html>
