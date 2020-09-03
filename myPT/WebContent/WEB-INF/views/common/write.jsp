<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"/>

    <title>글 쓰기</title>
   	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    
    <link href="/myPT/css/styles.css" rel="stylesheet" />
    <link href="/myPT/css/index.css" rel="stylesheet"/>
    <link href="/myPT/css/widget.css" rel="stylesheet"/>
    <link rel="stylesheet" href="assets/summernote-0.8.18-dist/summernote-bs4.css">
    <link href="/myPT/css/write.css" rel="stylesheet"/>

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
       
	      <div class="container py-3">
			<div>
				<header class="px-4">
					<h4>글쓰기</h4>
					<div class="text-right">
						목록으로
					</div>
				</header>
			</div>
				
			<div>
				<main>
					<form method="post"> 
						<div class="cardWrapper p-2">
							<div class="card border border-secondary h-100">
								<div class="card-body p-1">
									<ul class="list-group list-group-flush h-100">
										<li class="list-group-item">
											<div class="row">
												<div class="col-lg-2 col-sm-6">
													<select class="form-control" name="selectHead">
														<option value="일상">일상</option>
														<option value="목표공유">목표공유</option>
														<option value="정보">정보</option>
														<option value="이벤트참여">이벤트참여</option>
													</select>
												</div>
												<div class="col-lg-10 pl-lg-0">
													<input class="form-control" id="subject" name="subject" placeholder="제목">
												</div>
											</div>
										</li>
										<li class="list-group-item">
	                                        <textarea class="summernote" name="content"></textarea>
										</li>
									</ul>
									<div class="text-right px-4 d-flex justify-content-end align-items-center">
										<button class="btn btn-outline-warning m-2">수정하기</button>
										<button class="btn btn-primary">글쓰기</button>
									</div>
								</div>
							</div>
						</div>
					</form>
				</main>
			</div>

		</div>
			       
      </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js"
        crossorigin="anonymous"></script>
        
    <script type="text/javascript" src="assets/summernote-0.8.18-dist/summernote-bs4.js"></script>
    <script src="/myPT/assets/summernote-0.8.18-dist/lang/summernote-ko-KR.js"></script>
    <script src="/myPT/js/scripts.js"></script>
    <script src="/myPT/js/write.js"></script>
    
  </body>
</html>
