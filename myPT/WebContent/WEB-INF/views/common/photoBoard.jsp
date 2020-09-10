<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <title>포토 게시판</title>
    <link href="/myPT/css/styles.css" rel="stylesheet" />
    <link href="/myPT/css/index.css" rel="stylesheet"/>
    <link href="/myPT/css/widget.css" rel="stylesheet"/>
    <link href="/myPT/css/like.css" rel="stylesheet" />

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
          <div class="container-fluid mt-3">
            <div class="row">
              <div class="col-12">
                <h3 class="mb-5 mt-3">포토 게시판</h3>

                <div class="row">
                  <div class="col-md-6 col-xs-12 col-lg-4">
                    <div class="card border-0">
                      <p
                        class="card-text mb-0 text-muted"
                        style="font-size: 14px"
                      >
                        2020-08-27
                      </p>
                      <img src="img/photo/1.jpg" class="card-img-top mb-1" />
                      <div class="card-body p-0 pt-2">
                        <h5 class="card-title mb-1 ml-2">OOO 회원입니다.</h5>
                        <p class="card-text mb-1 ml-2">OOO 회원</p>

                        <!-- 좋아요버튼 -->
                        <div class="row m-0 likebutton">
                          <input type="checkbox" class="like" />
                          <div>
                            <svg
                              id="heart-svg"
                              viewBox="467 392 58 57"
                              xmlns="http://www.w3.org/2000/svg"
                              style="width: 40px"
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
                          <p class="mt-2">1</p>
                          <i
                            class="far fa-comment-dots fa-lg mt-2 ml-3 text-muted"
                          ></i>
                          <p class="mt-2 ml-2">1</p>
                        </div>
                        <!-- 좋아요버튼 -->
                      </div>
                    </div>
                  </div>
                  <div class="col-md-6 col-xs-12 col-lg-4">
                    <div class="card border-0">
                      <p
                        class="card-text mb-0 text-muted"
                        style="font-size: 14px"
                      >
                        2020-08-27
                      </p>
                      <img src="img/photo/2.jpg" class="card-img-top mb-1" />
                      <div class="card-body p-0 pt-2">
                        <h5 class="card-title mb-1 ml-2">OOO 회원입니다.</h5>
                        <p class="card-text mb-1 ml-2">OOO 회원</p>

                        <!-- 좋아요버튼 -->
                        <div class="row m-0 likebutton">
                          <input type="checkbox" class="like" />
                          <div>
                            <svg
                              id="heart-svg"
                              viewBox="467 392 58 57"
                              xmlns="http://www.w3.org/2000/svg"
                              style="width: 40px"
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
                          <p class="mt-2">1</p>
                          <i
                            class="far fa-comment-dots fa-lg mt-2 ml-3 text-muted"
                          ></i>
                          <p class="mt-2 ml-2">1</p>
                        </div>
                        <!-- 좋아요버튼 -->
                      </div>
                    </div>
                  </div>
                  <div class="col-md-6 col-xs-12 col-lg-4">
                    <div class="card border-0">
                      <p
                        class="card-text mb-0 text-muted"
                        style="font-size: 14px"
                      >
                        2020-08-27
                      </p>
                      <img src="img/photo/3.jpg" class="card-img-top mb-1" />
                      <div class="card-body p-0 pt-2">
                        <h5 class="card-title mb-1 ml-2">OOO 회원입니다.</h5>
                        <p class="card-text mb-1 ml-2">OOO 회원</p>

                        <!-- 좋아요버튼 -->
                        <div class="row m-0 likebutton">
                          <input type="checkbox" class="like" />
                          <div>
                            <svg
                              id="heart-svg"
                              viewBox="467 392 58 57"
                              xmlns="http://www.w3.org/2000/svg"
                              style="width: 40px"
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
                          <p class="mt-2">1</p>
                          <i
                            class="far fa-comment-dots fa-lg mt-2 ml-3 text-muted"
                          ></i>
                          <p class="mt-2 ml-2">1</p>
                        </div>
                        <!-- 좋아요버튼 -->
                      </div>
                    </div>
                  </div>
                  <div class="col-md-6 col-xs-12 col-lg-4">
                    <div class="card border-0">
                      <p
                        class="card-text mb-0 text-muted"
                        style="font-size: 14px"
                      >
                        2020-08-27
                      </p>
                      <img src="img/photo/4.jpg" class="card-img-top mb-1" />
                      <div class="card-body p-0 pt-2">
                        <h5 class="card-title mb-1 ml-2">OOO 회원입니다.</h5>
                        <p class="card-text mb-1 ml-2">OOO 회원</p>

                        <!-- 좋아요버튼 -->
                        <div class="row m-0 likebutton">
                          <input type="checkbox" class="like" />
                          <div>
                            <svg
                              id="heart-svg"
                              viewBox="467 392 58 57"
                              xmlns="http://www.w3.org/2000/svg"
                              style="width: 40px"
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
                          <p class="mt-2">1</p>
                          <i
                            class="far fa-comment-dots fa-lg mt-2 ml-3 text-muted"
                          ></i>
                          <p class="mt-2 ml-2">1</p>
                        </div>
                        <!-- 좋아요버튼 -->
                      </div>
                    </div>
                  </div>
                  <div class="col-md-6 col-xs-12 col-lg-4">
                    <div class="card border-0">
                      <p
                        class="card-text mb-0 text-muted"
                        style="font-size: 14px"
                      >
                        2020-08-27
                      </p>
                      <img src="img/photo/5.png" class="card-img-top mb-1" />
                      <div class="card-body p-0 pt-2">
                        <h5 class="card-title mb-1 ml-2">OOO 회원입니다.</h5>
                        <p class="card-text mb-1 ml-2">OOO 회원</p>

                        <!-- 좋아요버튼 -->
                        <div class="row m-0 likebutton">
                          <input type="checkbox" class="like" />

                          <div>
                            <svg
                              id="heart-svg"
                              viewBox="467 392 58 57"
                              xmlns="http://www.w3.org/2000/svg"
                              style="width: 40px"
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

                          <p class="mt-2">1</p>
                          <i
                            class="far fa-comment-dots fa-lg mt-2 ml-3 text-muted"
                          ></i>
                          <p class="mt-2 ml-2">1</p>
                        </div>
                        <!-- 좋아요버튼 -->
                      </div>
                    </div>
                  </div>
                  <div class="col-md-6 col-xs-12 col-lg-4">
                    <div class="card border-0">
                      <p
                        class="card-text mb-0 text-muted"
                        style="font-size: 14px"
                      >
                        2020-08-27
                      </p>
                      <img src="img/photo/6.jpg" class="card-img-top mb-1" />
                      <div class="card-body p-0 pt-2">
                        <h5 class="card-title mb-1 ml-2">OOO 회원입니다.</h5>
                        <p class="card-text mb-1 ml-2">OOO 회원</p>

                        <!-- 좋아요버튼 -->
                        <div class="row m-0 likebutton">
                          <input type="checkbox" class="like" />

                          <div>
                            <svg
                              id="heart-svg"
                              viewBox="467 392 58 57"
                              xmlns="http://www.w3.org/2000/svg"
                              style="width: 40px"
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

                          <p class="mt-2">1</p>
                          <i
                            class="far fa-comment-dots fa-lg mt-2 ml-3 text-muted"
                          ></i>
                          <p class="mt-2 ml-2">1</p>
                        </div>
                        <!-- 좋아요버튼 -->
                      </div>
                    </div>
                  </div>
                  <div class="col-md-6 col-xs-12 col-lg-4">
                    <div class="card border-0">
                      <p
                        class="card-text mb-0 text-muted"
                        style="font-size: 14px"
                      >
                        2020-08-27
                      </p>
                      <img src="img/photo/7.jpg" class="card-img-top mb-1" />
                      <div class="card-body p-0 pt-2">
                        <h5 class="card-title mb-1 ml-2">OOO 회원입니다.</h5>
                        <p class="card-text mb-1 ml-2">OOO 회원</p>

                        <!-- 좋아요버튼 -->
                        <div class="row m-0 likebutton">
                          <input type="checkbox" class="like" />

                          <div>
                            <svg
                              id="heart-svg"
                              viewBox="467 392 58 57"
                              xmlns="http://www.w3.org/2000/svg"
                              style="width: 40px"
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

                          <p class="mt-2">1</p>
                          <i
                            class="far fa-comment-dots fa-lg mt-2 ml-3 text-muted"
                          ></i>
                          <p class="mt-2 ml-2">1</p>
                        </div>
                        <!-- 좋아요버튼 -->
                      </div>
                    </div>
                  </div>
                  <div class="col-md-6 col-xs-12 col-lg-4">
                    <div class="card border-0">
                      <p
                        class="card-text mb-0 text-muted"
                        style="font-size: 14px"
                      >
                        2020-08-27
                      </p>
                      <img src="img/photo/8.jpg" class="card-img-top mb-1" />
                      <div class="card-body p-0 pt-2">
                        <h5 class="card-title mb-1 ml-2">OOO 회원입니다.</h5>
                        <p class="card-text mb-1 ml-2">OOO 회원</p>

                        <!-- 좋아요버튼 -->
                        <div class="row m-0 likebutton">
                          <input type="checkbox" class="like" />

                          <div>
                            <svg
                              id="heart-svg"
                              viewBox="467 392 58 57"
                              xmlns="http://www.w3.org/2000/svg"
                              style="width: 40px"
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

                          <p class="mt-2">1</p>
                          <i
                            class="far fa-comment-dots fa-lg mt-2 ml-3 text-muted"
                          ></i>
                          <p class="mt-2 ml-2">1</p>
                        </div>
                        <!-- 좋아요버튼 -->
                      </div>
                    </div>
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
              <!-- ============================================================== -->
              <!-- End PAge Content -->
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
    <script src="/myPT/js/like.js"></script>
    <script src="/myPT/js/photo.js"></script>
  </body>
</html>
