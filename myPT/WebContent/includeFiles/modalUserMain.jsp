<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="modal" id="PT">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h4 class="modal-title">PT 일정</h4>
            <button class="close" type="button" data-dismiss="modal">
              &times
            </button>
          </div>
          <div class="modal-body">
            <div class="main-card mb-3 card">
              <div class="card-body">
                <div class="widget-content p-0">
                  <div class="widget-content-wrapper">
                    <div class="widget-content-left">
                      <div class="widget-heading">예약된 시간</div>
                      <div class="widget-subheading"></div>
                    </div>
                    <div class="widget-content-right">
                      <div
                        class="widget-numbers"
                        style="color: #3ac47d !important"
                      >
                        14:00
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-danger" data-dismiss="modal">
              닫기
            </button>
          </div>
        </div>
      </div>
    </div>

    <div class="modal" id="program">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h4 class="modal-title">프로그램</h4>
            <button class="close" type="button" data-dismiss="modal">
              &times
            </button>
          </div>
          <div class="modal-body">
            <ul class="list-group">
              <li class="list-group-item">
                <div class="row">
                  <div class="text-left h4 col-6">목표 부위</div>
                  <div class="text-right h5 col-6 text-danger">
                    가슴, 이두, 어깨
                  </div>
                </div>
              </li>
              <li class="list-group-item text-center">
                <div class="h5">밴치프레스, 바벨, 덤벨 이용하시면 됩니다.</div>
              </li>
            </ul>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-danger" data-dismiss="modal">
              닫기
            </button>
          </div>
        </div>
      </div>
    </div>

    <div class="modal" id="schedule">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h4 class="modal-title">이번주 스케줄</h4>
            <button class="close" type="button" data-dismiss="modal">
              &times
            </button>
          </div>
          <div class="modal-body">
            <div class="card-group text-center p-0">
              <div class="card mb-4 p-0">
                <div class="card-header bg-dark text-white">일요일</div>
                <div class="card-body">
                  <div class="card">
                    <div class="card-body p-0">쉬는 날</div>
                  </div>
                </div>
              </div>
              <div class="card mb-4 p-0">
                <div class="card-header bg-dark text-white">월요일</div>
                <div class="card-body">
                  <div class="card bg-danger text-white">
                    <div class="card-body p-0">
                      PT
                      <a
                        class="small stretched-link pt-modal"
                        data-toggle="modal"
                        data-target="#PT"
                        href="#"
                      ></a>
                    </div>
                  </div>
                </div>
              </div>
              <div class="card mb-4 p-0">
                <div class="card-header bg-dark text-white">화요일</div>
                <div class="card-body">
                  <div class="card bg-light">
                    <div class="card-body p-0">
                      프로그램
                      <a
                        class="small stretched-link"
                        data-toggle="modal"
                        data-target="#program"
                        href="#"
                      ></a>
                    </div>
                  </div>
                </div>
              </div>
              <div class="card mb-4 p-0">
                <div class="card-header bg-dark text-white">수요일</div>
                <div class="card-body">
                  <div class="card bg-light">
                    <div class="card-body p-0">
                      프로그램
                      <a
                        class="small stretched-link"
                        data-toggle="modal"
                        data-target="#program"
                        href="#"
                      ></a>
                    </div>
                  </div>
                </div>
              </div>
              <div class="card mb-4 p-0">
                <div class="card-header bg-dark text-white">목요일</div>
                <div class="card-body">
                  <div class="card bg-danger text-white">
                    <div class="card-body p-0">
                      PT
                      <a
                        class="small stretched-link pt-modal"
                        data-toggle="modal"
                        data-target="#PT"
                        href="#"
                      ></a>
                    </div>
                  </div>
                </div>
              </div>
              <div class="card mb-4 p-0">
                <div class="card-header bg-dark text-white">금요일</div>
                <div class="card-body">
                  <div class="card bg-light">
                    <div class="card-body p-0">
                      프로그램
                      <a
                        class="small stretched-link"
                        data-toggle="modal"
                        data-target="#program"
                        href="#"
                      ></a>
                    </div>
                  </div>
                </div>
              </div>
              <div class="card mb-4 p-0">
                <div class="card-header bg-dark text-white">토요일</div>
                <div class="card-body">
                  <div class="card">
                    <div class="card-body p-0">쉬는 날</div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-danger" data-dismiss="modal">
              닫기
            </button>
          </div>
        </div>
      </div>
    </div>
