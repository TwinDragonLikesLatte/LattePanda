<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

    <!-- 조직도 -->
    <style>
        .org-chart {
            grid-column: 2 / 3;
            grid-row: 1 / 3;
        }

        .org-chart div:nth-child(2) {
            border: var(--border);
            height: calc(100% - 46px);
            background-color: #FFFFFF;
        }

        .org-chart>div:last-child {
            padding: 20px;
        }

        .org-chart li>ul li>ul {
            height: 0;
            overflow: hidden;
            transition: 0.2s;
        }

        .org-chart .glyphicon-folder-open~ul {
            height: auto;
        }

        .org-chart li>ul>ul,
        .org-chart li>ul>li {
            margin-left: 20px;
        }

        .org-chart ul>li {
            padding: 2px;
            cursor: pointer;
        }

        .org-chart li>.glyphicon {
            margin-right: 5px;
            color: var(--black_sub2);
        }

        .glyphicon-folder-open {
            color: var(--black_sub1);
        }

        .glyphicon-folder-close {
            color: var(--black_sub2);
        }
    </style>
    <section class="org-chart">
        <div class="section-header">
            <span class="sub-title">조직도</span>
        </div>
        <div>
            <ul>
                <li>
                    <span class="glyphicon glyphicon-globe"></span>
                    <span data-seq_department="all">전체보기</span>
                    <ul>
                        <li>
                            <span class="glyphicon glyphicon-folder-close"></span>
                            <span data-seq_department="1">임원진</span>
                        </li>
                        <li>
                            <span class="glyphicon glyphicon-folder-close"></span>
                            <span data-seq_department="2">경영본부</span>
                            <ul>
                                <li>
                                    <span class="glyphicon glyphicon-folder-close"></span>
                                    <span data-seq_department="21">연구기획과</span>
                                </li>
                                <li>
                                    <span class="glyphicon glyphicon-folder-close"></span>
                                    <span data-seq_department="22">인사과</span>
                                </li>
                                <li>
                                    <span class="glyphicon glyphicon-folder-close"></span>
                                    <span data-seq_department="23">총무과</span>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <span class="glyphicon glyphicon-folder-close"></span>
                            <span data-seq_department="3">영업부</span>
                            <ul>
                                <li>
                                    <span class="glyphicon glyphicon-folder-close"></span>
                                    <span data-seq_department="31">서울</span>
                                    <ul>
                                        <li>
                                            <span class="glyphicon glyphicon-folder-close"></span>
                                            <span data-seq_department="3101">강남구</span>
                                            <ul>
                                                <li>
                                                    <span class="glyphicon glyphicon-folder-close"></span>
                                                    <span data-seq_department="310101">강남대로점</span>
                                                </li>
                                                <li>
                                                    <span class="glyphicon glyphicon-folder-close"></span>
                                                    <span data-seq_department="310102">대치점</span>
                                                </li>
                                                <li>
                                                    <span class="glyphicon glyphicon-folder-close"></span>
                                                    <span data-seq_department="310103">수서점</span>
                                                </li>
                                            </ul>
                                        </li>
                                        <li>
                                            <span class="glyphicon glyphicon-folder-close"></span>
                                            <span data-seq_department="3118">서초구</span>
                                            <ul>
                                                <li>
                                                    <span class="glyphicon glyphicon-folder-close"></span>
                                                    <span data-seq_department="311801">석촌점</span>
                                                </li>
                                                <li>
                                                    <span class="glyphicon glyphicon-folder-close"></span>
                                                    <span data-seq_department="311802">송파구청점</span>
                                                </li>
                                                <li>
                                                    <span class="glyphicon glyphicon-folder-close"></span>
                                                    <span data-seq_department="311803">잠실새내점</span>
                                                </li>
                                            </ul>
                                        </li>
                                    </ul>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <span class="glyphicon glyphicon-folder-close"></span>
                            <span data-seq_department="4">물류부</span>
                            <ul>
                                <li>
                                    <span class="glyphicon glyphicon-folder-close"></span>
                                    <span data-seq_department="41">구매과</span>
                                </li>
                                <li>
                                    <span class="glyphicon glyphicon-folder-close"></span>
                                    <span data-seq_department="42">운송과</span>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </li>
                <li>
                    <span class="glyphicon glyphicon-inbox"></span>
                    <span data-seq_department="resign">퇴사자</span>
                </li>
            </ul>
        </div>
    </section>

    <script>

        $('.org-chart').find('.glyphicon').on({
            click: function toggleDepartment(event) {
                $(this).toggleClass("glyphicon-folder-open")
                $(this).toggleClass("glyphicon-folder-close")

                if ($(this).hasClass("glyphicon-folder-close")) {
                    $(this).siblings('ul').find('.glyphicon')
                        .removeClass('glyphicon-folder-open')
                        .addClass('glyphicon-folder-close');
                }

                event.stopPropagation()
            }
        })

    </script>