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
		
		      <div class="d-flex flex-column align-items-center m-4">
		        <label for="startDate" class="d-inline">시작 날짜</label>
		        <input
		          type="date"
		          id="startDate"
		          name="startDate"
		          class="form-control w-50"/>
		      </div>
		
		      <div class="row">
		        <div class="col-lg-3 col-md-6 col-sm-6 mb-4 pTableWrapper">
		          <div class="pricingTable">
		            <div class="pricingTable-header mt-3">
		              <h3>10회/1개월</h3>
		            </div>
		
		            <div class="price-value">
		              <span>39만원</span>
		              <span class="subtitle">기본 이용권</span>
		            </div>
		
		            <div class="pricingContent">
		              <ul>
		                <li><b>10회</b> PT</li>
		                <li><b>1개월</b> 헬스 이용</li>
		                <li><b>락커, 운동복</b> 대여 무료</li>
		              </ul>
		            </div>
		
		            <div class="pricingTable-sign-up">
		              <input type="button" class="btn btn-block btn-default" value="결제" id="pay1" onclick="pay(this)">결제</button>
		            </div>
		          </div>
		        </div>
		
		        <div class="col-lg-3 col-md-6 col-sm-6 mb-4 pTableWrapper">
		          <div class="pricingTable">
		            <div class="pricingTable-header mt-3">
		              <h3>20+3회/2개월</h3>
		            </div>
		
		            <div class="price-value">
		              <span>73만원</span>
		              <span class="subtitle"><del>89만 7,000원</del></span>
		            </div>
		
		            <div class="pricingContent">
		              <ul>
		                <li><b>23회</b> PT</li>
		                <li><b>2개월</b> 헬스 이용</li>
		                <li><b>락커, 운동복</b> 대여 무료</li>

		              </ul>
		            </div>
		
		            <div class="pricingTable-sign-up">
		              <input type="button" class="btn btn-block btn-default" value="결제" id="pay2" onclick="pay(this)">결제</button>
		            </div>
		          </div>
		        </div>
		
		        <div class="col-lg-3 col-md-6 col-sm-6 mb-4 pTableWrapper">
		          <div class="pricingTable">
		            <div class="pricingTable-header mt-3">
		              <div class="best-offer">인기 상품</div>
		              <h3>30+5회권/3개월</h3>
		            </div>
		
		            <div class="price-value">
		              <span>103만원</span>
		              <span class="subtitle"><del>136만 5000원</del></span>
		            </div>
		
		            <div class="pricingContent">
		               <ul>
		                <li><b>35회</b> PT</li>
		                <li><b>3개월</b> 헬스 이용</li>
		                <li><b>락커, 운동복</b> 대여 무료</li>
		                <li><b>프로틴</b> 증정</li>
		              </ul>
		            </div>
		
		            <div class="pricingTable-sign-up">
				<input type="button" class="btn btn-block btn-default" value="결제" id="pay3" onclick="pay(this)">결제</button>	
	            </div>
		          </div>
		        </div>
		
		        <div class="col-lg-3 col-md-6 col-sm-6 mb-4 pTableWrapper">
		          <div class="pricingTable">
		            <div class="pricingTable-header mt-3">
		              <h3>50+10회권/6개월</h3>
		            </div>
		
		            <div class="price-value">
		              <span>164만원</span>
					 <span class="subtitle"><del>234만원</del></span>		            
					 </div>
		
		            <div class="pricingContent">
		             <ul>
		                <li><b>60회</b> PT</li>
		                <li><b>6개월</b> 헬스 이용</li>
		                <li><b>락커, 운동복</b> 대여 무료</li>
		                <li><b>프로틴</b> 증정</li>
		                <li><b>프로필 사진</b> 촬영 무료</li>
		              </ul>
		            </div>
		
		            <div class="pricingTable-sign-up">
		              <input type="button" class="btn btn-block btn-default" value="결제" id="pay4" onclick="pay(this)">
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
    <script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
    
    <script src="/myPT/js/scripts.js"></script>
    <script src="/myPT/js/payment.js"></script>
    
  </body>
</html>
