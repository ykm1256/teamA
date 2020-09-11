<%@page import="com.mypt.dao.CboardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
		request.setCharacterEncoding("utf-8");
		int totalRecord = 0;//총게시물수
		int numPerPage = 10;//페이지당 레코드 개수(5,10,15,30)
		int pagePerBlock = 15;//블럭당 페이지 개수
		int totalPage = 0;//총 페이지 개수
		int totalBlock = 0;//총 블럭 개수
		int nowPage = 1;//현재 페이지
		int nowBlock = 1;//현재 블럭
		CboardDao dao = CboardDao.getInstance();
		
		//처음 shead 설정
		String shead = "all";
		if(request.getParameter("head")!=null){
			shead = request.getParameter("head");
		}
				
		//검색에 필요한 변수
		String keyField = "", keyWord = "";
		//검색일때
		if(request.getParameter("keyWord")!=null){
			keyField = request.getParameter("keyField");
			keyWord = request.getParameter("keyWord");
		}
		
		//검색 후에 다시 처음화면 요청
		if(request.getParameter("reload")!=null&&
				request.getParameter("reload").equals("true")){
			keyField = ""; keyWord = "";
		}		
		
		totalRecord = dao.getTotalCount(keyField, keyWord,shead);
		System.out.println("totalRecord : " + totalRecord);
		
		//nowPage 요청 처리
		if(request.getParameter("nowPage")!=null){
			nowPage = Integer.parseInt(request.getParameter("nowPage"));
		}
		
		//sql문에 들어가는 start, cnt 선언
		int start = (nowPage*numPerPage)-numPerPage;
		int cnt = numPerPage;
		System.out.println(start);
		System.out.println(cnt);
		
		
		//전체페이지 개수
		totalPage = (int)Math.ceil((double)totalRecord/numPerPage);
		//전체블럭 개수
		 totalBlock = (int)Math.ceil((double)totalPage/pagePerBlock);
		//현재블럭
		nowBlock = (int)Math.ceil((double)nowPage/pagePerBlock);
%>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>질문 게시판</title>
    <link href="/myPT/css/styles.css" rel="stylesheet" />
    <link href="/myPT/css/index.css" rel="stylesheet"/>
    <link href="/myPT/css/widget.css" rel="stylesheet"/>

    <script
      src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js"
    ></script>
    
    <script type="text/javascript">
    
    function check() {
		if(document.searchFrm.keyField.value=="default"){
			alert("카테고리를 지정하세요.");			
			return false;
		}
		else if(document.searchFrm.keyWord.value==""){
			window.location.href="moveQuestion.do"
			return false;
		}
		document.searchFrm.submit();
	}
	function pageing(page) {
		document.readFrm.nowPage.value = page;
		document.readFrm.submit();
	}
	function block(block) {
		document.readFrm.nowPage.value = 
			<%=pagePerBlock%>*(block-1)+1;
		document.readFrm.submit();
	}
	function  list() {
		document.listFrm.action = "list.jsp";
		document.listFrm.submit();
	}
	function numPerFn(numPerPage) {
		document.readFrm.numPerPage.value = numPerPage;
		document.readFrm.submit();
	}
	//list.jsp에서 read.jsp로 요청이 될때 기존에 조건 같이 넘어감.
	//기존 조건 : keyField,keyWord,nowPage,numPerPage
	function read(num) {
		document.readFrm.num.value = num;
		document.readFrm.action = "boardView.do";
		document.readFrm.submit();
	}
	function headFn(head){
		document.readFrm.head.value = head;
		document.readFrm.submit();
	}
</script>

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
          <div class="container-fluid mt-3">
            <!-- ============================================================== -->
            <!-- Start Page Content -->
            <!-- ============================================================== -->
            <div class="row">
              <div class="col-12">
                <div class="card">
                  <div class="card-body">
                    <h3 class="card-title text-center">질문게시판</h3>
                  </div>

                  <div class="table-responsive">
                    <table class="table mb-0">
                      <thead class="thead-light text-center">
                        <tr>
                          <th style="width: 50%">제목</th>
                          <th>작성자</th>
                          <th>작성일자</th>
                          <th>조회수</th>
                        </tr>
                      </thead>
                      <tbody class="customtable text-center">
                        <tr>
                          <td><a href="">안녕하세요</a></td>
                          <td>홍길동</td>
                          <td>2020-08-25 12:40</td>
                          <td>21</td>
                        </tr>
                        <tr>
                          <td><a href="">반갑습니다</a></td>
                          <td>아이유</td>
                          <td>2020-08-24 11:30</td>
                          <td>29</td>
                        </tr>
                      </tbody>
                    </table>
                  </div>
                </div>

                <div class="form-group mt-3 float-right">
                  <a class="btn btn-primary text-white">글쓰기</a>
                </div>

                <ul class="pagination mt-5 ml-5 justify-content-center">
                  <li class="page-item">
                    <a class="page-link" href="#">이전</a>
                  </li>
                  <li class="page-item">
                    <a class="page-link" href="#">1</a>
                  </li>
                  <li class="page-item">
                    <a class="page-link" href="#">2</a>
                  </li>
                  <li class="page-item">
                    <a class="page-link" href="#">다음</a>
                  </li>
                </ul>
              </div>
            </div>
            <!-- ============================================================== -->
            <!-- End PAge Content -->
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
    <script src="/myPT/js/board.js"></script>
  </body>
</html>
