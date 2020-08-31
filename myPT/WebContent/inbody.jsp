<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"/>

    <title>인바디</title>
    <link href="css/styles.css" rel="stylesheet" />
    <link href="css/index.css" rel="stylesheet"/>
    <link href="css/widget.css" rel="stylesheet"/>
    <link href="css/inbody.css" rel="stylesheet"/>

    <script
      src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js"
    ></script>

  </head>
  <body class="sb-nav-fixed">
    <!-- nav -->
    <jsp:include page="includeFiles/nav.jsp"></jsp:include>
    <!-- nav -->

    <!-- QR 모달 -->
    <jsp:include page="includeFiles/modalQR.jsp"></jsp:include>
    <!--//QR 모달-->

    <div id="layoutSidenav">
      <!-- sideNav -->
      <jsp:include page="includeFiles/userSideNav.jsp"></jsp:include>
      <!-- /sideNav -->
      
      
      
      <div id="layoutSidenav_content">
         
         <main>
       		 <div class="container-fluid text-center">
	              <div class="row border border-dark rounded-top my-3 mx-auto p-1">
	                  <div class="col border-right border-dark">
	                      멍멍
	                  </div>
	                  <div class="col border-right border-dark">
	                      111세
	                  </div>
	                  <div class="col border-right border-dark">
	                      무성
	                  </div>
	                  <div class="col">
	                      213cm
	                  </div>
	              </div>
	                  
	
	              <div class="card mb-4">
	                  <div class="card-body p-1">
	                      <canvas id="myBarChart" width="100%" height="25"></canvas>
	                  </div>
	                  <div class="card-footer">
	                      측정일: <span id="latestMeasureDay">20.8.26</span>
	                  </div>
	              </div>
	
	
	              <div class="card-deck mb-4">
	                  <div class="card pt-3">
	                      <h6 class="card-title">체중(kg)</h6>
	                      <canvas id="weight" width="100%"></canvas>                            
	                  </div>
	
	                  <div class="card pt-3">
	                      <h6 class="card-title">골격근량(kg)</h6>
	                      <canvas id="muscleMass" width="100%"></canvas>                            
	                  </div>
	
	                  <div class="card pt-3">
	                      <h6 class="card-title">체지방량(kg)</h6>
	                      <canvas id="fatMass" width="100%"></canvas>                            
	                  </div>
             	 </div>

                  <div class="card border-secondary mb-4 col-12 p-0" id="comparison">
                      <div class="card-header bg-dark text-white">

                          <div class="row">
                              <div class="col">
                                  <select id="previousMeasureDay" onchange="preDayIschanged()"> 
                                      <option value="default" disabled selected>이전 측정일</option>
                                      <option value="1">20.8.20</option>
                                      <option value="2">20.8.10</option>
                                      <option value="3">20.7.27</option>
                                  </select>
                      
                                  <select id="numOfResult" onchange="numOfResultIschanged()"> 
                                      <option value="10" selected>10개</option>
                                      <option value="15">15개</option>
                                      <option value="20">20개</option>
                                  </select>
                              </div>
                          
                              <div class="col previousMeasureDay">과거</div>
                              <div class="col latestMeasureDay">현재</div>
                              <div class="col">차이</div>
                          </div>
                      </div>

                      <div class="card-body p-md-2  d-flex align-items-center">
                          <div class="w-100">
                              <div class="row">
                                  <div class="col">체중</div>
                                  <div class="col"><span class="before">63</span>kg</div>
                                  <div class="col"><span class="after">60</span>kg</div>
                                  <div class="col"><span class="result"></span>kg</div>
                              </div>
                              <div class="row">
                                  <div class="col">골격근량</div>
                                  <div class="col"><span class="before">17</span>kg</div>
                                  <div class="col"><span class="after">20</span>kg</div>
                                  <div class="col"><span class="result"></span>kg</div>
                              </div>
                              <div class="row">
                                  <div class="col">체지방량</div>
                                  <div class="col"><span class="before">12</span>kg</div>
                                  <div class="col"><span class="after">13</span>kg</div>
                                  <div class="col"><span class="result"></span>kg</div>
                              </div>
    
                          </div>
                      </div>
                  </div> 
           </div>          
        </main>       
     
     </div>    
  </div>

    <script
      src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script
      src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.bundle.min.js">
    </script>
    <script src="js/scripts.js"></script>
    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.min.js"></script>
<!--     chart demo -->
    <script src="assets/chartDemo/chart-line-demo.js"></script>
    <script src="assets/chartDemo/chart-line-demo2.js"></script>
    <script src="assets/chartDemo/chart-line-demo3.js"></script>
    <script src="assets/chartDemo/chart-bar-demo.js"></script>
    
    <script src="js/inbody.js"></script>
    
    
  </body>
</html>
