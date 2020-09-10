<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>---게시글 제목---</title>
    <link href="/myPT/css/styles.css" rel="stylesheet" />
    <link href="/myPT/css/index.css" rel="stylesheet"/>
    <link href="/myPT/css/widget.css" rel="stylesheet"/>
    <link href="/myPT/css/like.css" rel="stylesheet"/>

    <script
      src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js"
    ></script>
    
    <style>
    
    .comments
    {
      margin: 15px 0px;
    }
    
    .commentDate
    {
    	font-size: 0.8rem;
    	opacity: 0.8;
    }
    </style>

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
      <c:choose>
      <c:when test="${sessionScope.grade==0 }">
      <jsp:include page="/includeFiles/adminSideNav.jsp"></jsp:include>
      </c:when>
      <c:when test="${sessionScope.grade==1 }" >
      <jsp:include page="/includeFiles/trainerSideNav.jsp"></jsp:include>
      </c:when>
      <c:otherwise>
      <jsp:include page="/includeFiles/userSideNav.jsp"></jsp:include>
      </c:otherwise>
      </c:choose> 
      <!-- /sideNav -->
      <div id="layoutSidenav_content">
        
          <div class="container py-3">
          <div>
         
            <header class="px-4">
              <h3>글보기</h3>
              <div class="text-right">              
              <a href="reply.do" class="mr-2" type="submit()">답변</a>/
              <a href="#" class="ml-2">목록으로</a>
              </div>
            </header>
          </div>

          <div>
            <main>             
                <div class="cardWrapper p-2">
                 <form>
                  <div class="card h-100">
                    <div class="card-body p-1">
                      <ul class="list-group list-group-flush h-100">
                        <li class="list-group-item">
                          <div class="row">
                            <div class="col-lg-12">
                            <div class="row ml-2 mt-3 mb-0 d-flex justify-content-between">
                            <input type="text" id="num" name="num" hidden="true" value="${dto.num }">                            
                            <input type="text" id="board" name="board" hidden="true" value="cboard">
                              <h3 class=" ">${dto.title }</h3>
                              <!-- 좋아요버튼 -->
                        <div class="row m-0 likebutton">
                        <c:choose>
                        <c:when test="${lflag==1 }">
                          <input type="checkbox" class="like" id="like" checked="checked"/>
                          </c:when>
                          <c:otherwise>
                          <input type="checkbox" class="like" id="like"/>
                          </c:otherwise>
                          </c:choose>
                          <div>
                            <svg
                              id="heart-svg"
                              viewBox="467 392 58 57"
                              xmlns="http://www.w3.org/2000/svg"
                              style="width: 50px"
                            >
                              <g
                                id="Group"
                                fill="none"
                                fill-rule="evenodd"
                                transform="translate(467 392)"
                              >
                                <path
                                  d="M29.144 20.773c-.063-.13-4.227-8.67-11.44-2.59C7.63 28.795 28.94 43.256 29.143 43.394c.204-.138 21.513-14.6 11.44-25.213-7.214-6.08-11.377 2.46-11.44 2.59z"
                                  id="heart"
                                  fill="#AAB8C2"
                                />
                                <circle
                                  id="main-circ"
                                  fill="#E2264D"
                                  opacity="0"
                                  cx="29.5"
                                  cy="29.5"
                                  r="1.5"
                                />

                                <g
                                  id="grp7"
                                  opacity="0"
                                  transform="translate(7 6)"
                                >
                                  <circle
                                    id="oval1"
                                    fill="#9CD8C3"
                                    cx="2"
                                    cy="6"
                                    r="2"
                                  />
                                  <circle
                                    id="oval2"
                                    fill="#8CE8C3"
                                    cx="5"
                                    cy="2"
                                    r="2"
                                  />
                                </g>

                                <g
                                  id="grp6"
                                  opacity="0"
                                  transform="translate(0 28)"
                                >
                                  <circle
                                    id="oval1"
                                    fill="#CC8EF5"
                                    cx="2"
                                    cy="7"
                                    r="2"
                                  />
                                  <circle
                                    id="oval2"
                                    fill="#91D2FA"
                                    cx="3"
                                    cy="2"
                                    r="2"
                                  />
                                </g>

                                <g
                                  id="grp3"
                                  opacity="0"
                                  transform="translate(52 28)"
                                >
                                  <circle
                                    id="oval2"
                                    fill="#9CD8C3"
                                    cx="2"
                                    cy="7"
                                    r="2"
                                  />
                                  <circle
                                    id="oval1"
                                    fill="#8CE8C3"
                                    cx="4"
                                    cy="2"
                                    r="2"
                                  />
                                </g>

                                <g
                                  id="grp2"
                                  opacity="0"
                                  transform="translate(44 6)"
                                >
                                  <circle
                                    id="oval2"
                                    fill="#CC8EF5"
                                    cx="5"
                                    cy="6"
                                    r="2"
                                  />
                                  <circle
                                    id="oval1"
                                    fill="#CC8EF5"
                                    cx="2"
                                    cy="2"
                                    r="2"
                                  />
                                </g>

                                <g
                                  id="grp5"
                                  opacity="0"
                                  transform="translate(14 50)"
                                >
                                  <circle
                                    id="oval1"
                                    fill="#91D2FA"
                                    cx="6"
                                    cy="5"
                                    r="2"
                                  />
                                  <circle
                                    id="oval2"
                                    fill="#91D2FA"
                                    cx="2"
                                    cy="2"
                                    r="2"
                                  />
                                </g>

                                <g
                                  id="grp4"
                                  opacity="0"
                                  transform="translate(35 50)"
                                >
                                  <circle
                                    id="oval1"
                                    fill="#F48EA7"
                                    cx="6"
                                    cy="5"
                                    r="2"
                                  />
                                  <circle
                                    id="oval2"
                                    fill="#F48EA7"
                                    cx="2"
                                    cy="2"
                                    r="2"
                                  />
                                </g>

                                <g
                                  id="grp1"
                                  opacity="0"
                                  transform="translate(24)"
                                >
                                  <circle
                                    id="oval1"
                                    fill="#9FC7FA"
                                    cx="2.5"
                                    cy="3"
                                    r="2"
                                  />
                                  <circle
                                    id="oval2"
                                    fill="#9FC7FA"
                                    cx="7.5"
                                    cy="2"
                                    r="2"
                                  />
                                </g>
                              </g>
                            </svg>
                          </div>                          
                        </div>
                        <!-- 좋아요버튼 -->
                        </div>
                              
                              <h5 class="mt-2 ml-2">${dto.writer }</h5>
                              <div class="row mt-2 ml-2 mb-0">
                                <div class="container pl-0 mb-0">
                                  <p class="text-muted mb-0 float-left">
                                    ${dto.date }
                                  </p>
                                  <div class="row float-right">
                                    <p class="mb-0">
                                      조회수 <span id="readnum" class=""
                                        >${dto.hit }</span
                                      >  ｜
                                    </p>
                                    <p class="mb-0 ml-2">
                                      추천수 <span id="likenum" class=""
                                        >${dto.like }</span
                                      > ｜
                                    </p>
                                    <p class="mb-0 ml-2 mr-1">
                                      댓글 <span id="commentnum" class=""
                                        >10</span
                                      >
                                    </p>
                                  </div>
                                </div>
                              </div>
                            </div>
                          </div>
                        </li>
                        <li class="list-group-item">
                          <div id="result">${dto.content }</div>
                        </li>
                      </ul>
                    </div>
                  </div>
                  </form>
                            

                      <div class="card my-4 border border-secondary">
		                  <div class="card-body p-1" style="width:100%;">
			            
			                  <textarea name="commentContent" id="commentContent" cols="30" rows="5" maxlength="500"
		                              style="width: 100%; resize:none" class="border-0"></textarea>
	                      </div>
			           
	             	 	  <div class="card-footer bg-white">
		                      <input type="button" class="btn btn-dark float-right" id="commentBtn" value="등록">
		                  </div>
		               </div>

	    
	             	 

    
                  
                  <div class="card">
                  	<div class="card-body">
                  	
                  	<div class="comments">
                  		<div class="row">
                  			<div class="row col-9">
                  				<div class="col-12 font-weight-bold">홍길동</div>
                  				<div class="col-12 text-secondary commentDate">2020-08-25 12:40</div>
                  			</div>
                  			<div class="col-3 text-right">신고/수정/삭제 메뉴</div>
                  		</div>	
                  		<div class="row">
                  			<div class="col-12 py-3">안녕하세요. 안녕하세요. 안녕하세요</div>  
                  		</div>
                  		
                  		<div class="row">
                  			<div class="col-9 text-secondary">답글 (수)</div>
                  			<div class="col-3 text-right">좋아요 아이콘/수</div>
                  		</div>
                  			
                  	</div>
                  		
                  	<div class="comments">
                  		<div class="row">
                  			<div class="row col-9">
                  				<div class="col-12 font-weight-bold">아이유</div>
                  				<div class="col-12 text-secondary commentDate">2020-08-25 12:40</div>
                  			</div>
							<div class="col-3 text-right">신고/수정/삭제 메뉴</div>                  		
						</div>	
                  		<div class="row">
                  			<div class="col-12 py-3">반갑습니다 아이유입니다. 반갑습니다.</div>  
                  		</div>
                  		
                  		<div class="row">
                  			<div class="col-9 text-secondary">답글 (수)</div>
                  			<div class="col-3 text-right">좋아요 아이콘/수</div>
                  		</div>
                  			
                  	</div>
                  		
                  	</div>
                  		
                  		
<!--                     <div class="table-responsive"> -->
<!--                       <table class="table mb-0"> -->
<!--                         <tbody> -->
<!--                           <tr> -->
<!--                             <td class="text-left"> -->
<!--                               <p class="mb-0 ml-3">홍길동</p> -->
<!--                             </td> -->
<!--                             <td class="text-left" style="width: 60%"> -->
<!--                               <p class="mb-0">안녕하세요</p> -->
<!--                             </td> -->
<!--                             <td class="text-right"> -->
<!--                               <p class="text-muted mb-0">2020-08-25 12:40</p> -->
<!--                             </td> -->
<!--                           </tr> -->
<!--                           <tr> -->
<!--                             <td class="text-left"> -->
<!--                               <p class="mb-0 ml-3">아이유</p> -->
<!--                             </td> -->
<!--                             <td class="text-left" style="width: 60%"> -->
<!--                               <p class="mb-0">반갑습니다</p> -->
<!--                             </td> -->
<!--                             <td class="text-right"> -->
<!--                               <p class="text-muted mb-0">2020-08-24 11:30</p> -->
<!--                             </td> -->
<!--                           </tr> -->
<!--                           <tr> -->
<!--                             <td class="text-left"> -->
<!--                               <p class="mb-0 ml-3">아이유</p> -->
<!--                             </td> -->
<!--                             <td class="text-left" style="width: 60%"> -->
<!--                               <p class="mb-0"> -->
<!--                                 반갑습니다 아이유입니다. 반갑습니다. -->
<!--                                 아이유입니다. 반갑습니다. 아이유입니다. -->
<!--                                 반갑습니다.아이유입니다. -->
<!--                               </p> -->
<!--                             </td> -->
<!--                             <td class="text-right"> -->
<!--                               <p class="text-muted mb-0 mr-1"> -->
<!--                                 2020-08-24 11:30 -->
<!--                                 <a href="#" -->
<!--                                   ><i -->
<!--                                     class="fas fa-edit ml-1 mr-1 text-success" -->
<!--                                   ></i -->
<!--                                 ></a> -->
<!--                                 <a href="#" -->
<!--                                   ><i class="fas fa-times text-danger"></i -->
<!--                                 ></a> -->
<!--                               </p> -->
<!--                             </td> -->
<!--                           </tr>  -->
<!--                         </tbody> -->
<!--                       </table> -->
<!--                     </div> -->
                    
                    <div class="card-footer bg-white">
                        <input type="button" class="btn col-12 text-center" value="더보기">
                    </div>    
                  </div>
                  
    
                </div>              
            </main>
          </div>
        </div>
      </div>
    </div>
    <script
      src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script
      src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.bundle.min.js">
    </script>
    <script src="/myPT/js/scripts.js"></script>
    <script src="/myPT/js/like.js"></script>
    <!-- 게시판 관련 -->
    <script src="/myPT/js/boardDetail.js"></script>
  <script type="text/javascript" src="assets/summernote-0.8.18-dist/summernote-bs4.js"></script>
  <script src="assets/summernote-0.8.18-dist/lang/summernote-ko-KR.js"></script>
  </body>
</html>
