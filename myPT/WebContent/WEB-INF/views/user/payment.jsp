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

    <title>결제</title>
    <link href="/myPT/css/styles.css" rel="stylesheet" />
    <link href="/myPT/css/index.css" rel="stylesheet"/>
    <link href="/myPT/css/widget.css" rel="stylesheet"/>
    
    <link rel="stylesheet" href="css/payment.css" />
    
    <script
      src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js"
    ></script>

  </head>
  <body class="sb-nav-fixed">
    <!-- nav -->
    <jsp:include page="/includeFiles/nav.jsp"></jsp:include>
    <!-- nav -->

    <!-- QR 모달 -->
    <jsp:include page="/includeFiles/modalQR.jsp"></jsp:include>
    <!--//QR 모달-->

    <div id="layoutSidenav">
      <!-- sideNav -->
      <jsp:include page="/includeFiles/sideNav.jsp"></jsp:include>
      <!-- /sideNav -->
      <div id="layoutSidenav_content">
      
      
      
        <main>
          <div class="container-fluid">
          
		      <div class="row text-center mb-5">
		        <h1>결제</h1>
		      </div>
		
		      <div class="d-flex flex-column align-items-center mb-4">
		        <label for="startDate" class="d-inline">시작 날짜</label>
		        <input
		          type="date"
		          id="startDate"
		          name="startDate"
		          class="form-control w-50"/>
		      </div>
		
		      <div class="row">
		        <div class="col-lg-3 col-md-6 col-sm-6 mb-md-3 mb-sm-3 pTableWrapper">
		          <div class="pricingTable">
		            <div class="pricingTable-header p-4">
		              <h3>Standard</h3>
		            </div>
		
		            <div class="price-value">
		              <span>10</span>
		              <span class="subtitle">per month</span>
		            </div>
		
		            <div class="pricingContent">
		              <ul>
		                <li><b>50GB</b> Disk Space</li>
		                <li><b>50</b> Email Accounts</li>
		                <li><b>50GB</b> Monthly Bandwidth</li>
		                <li><b>10</b> subdomains</li>
		                <li><b>50</b> Domains</li>
		              </ul>
		            </div>
		
		            <div class="pricingTable-sign-up">
		              <a href="#" class="btn btn-block btn-default">sign up</a>
		            </div>
		          </div>
		        </div>
		
		        <div class="col-lg-3 col-md-6 col-sm-6 mb-md-3 mb-sm-3 pTableWrapper">
		          <div class="pricingTable">
		            <div class="pricingTable-header p-4">
		              <h3>Business</h3>
		            </div>
		
		            <div class="price-value">
		              <span>20</span>
		              <span class="subtitle">per month</span>
		            </div>
		
		            <div class="pricingContent">
		              <ul>
		                <li><b>70GB</b> Disk Space</li>
		                <li><b>70</b> Email Accounts</li>
		                <li><b>70GB</b> Monthly Bandwidth</li>
		                <li><b>20</b> subdomains</li>
		                <li><b>70</b> Domains</li>
		              </ul>
		            </div>
		
		            <div class="pricingTable-sign-up">
		              <a href="#" class="btn btn-block btn-default">sign up</a>
		            </div>
		          </div>
		        </div>
		
		        <div class="col-lg-3 col-md-6 col-sm-6 mb-md-3 mb-sm-3 pTableWrapper">
		          <div class="pricingTable">
		            <div class="pricingTable-header p-4">
		              <div class="best-offer">best offers</div>
		              <h3>Premium</h3>
		            </div>
		
		            <div class="price-value">
		              <span>30</span>
		              <span class="subtitle">per month</span>
		            </div>
		
		            <div class="pricingContent">
		              <ul>
		                <li><b>80GB</b> Disk Space</li>
		                <li><b>80</b> Email Accounts</li>
		                <li><b>80GB</b> Monthly Bandwidth</li>
		                <li><b>30</b> subdomains</li>
		                <li><b>80</b> Domains</li>
		              </ul>
		            </div>
		
		            <div class="pricingTable-sign-up">
		              <a href="#" class="btn btn-block btn-default">sign up</a>
		            </div>
		          </div>
		        </div>
		
		        <div class="col-lg-3 col-md-6 col-sm-6 mb-md-3 mb-sm-3 pTableWrapper">
		          <div class="pricingTable">
		            <div class="pricingTable-header p-4">
		              <h3>Extra</h3>
		            </div>
		
		            <div class="price-value">
		              <small class="fa fa-usd"></small>
		              <span>40</span>
		              <span class="subtitle">per month</span>
		            </div>
		
		            <div class="pricingContent">
		              <ul>
		                <li><b>90GB</b> Disk Space</li>
		                <li><b>90</b> Email Accounts</li>
		                <li><b>90GB</b> Monthly Bandwidth</li>
		                <li><b>40</b> subdomains</li>
		                <li><b>90</b> Domains</li>
		              </ul>
		            </div>
		
		            <div class="pricingTable-sign-up">
		              <a href="#" class="btn btn-block btn-default">sign up</a>
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
    <script src="/myPT/js/scripts.js"></script>
    <script src="/myPT/js/payment.js"></script>
  </body>
</html>
