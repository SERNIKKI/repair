<%--
  Created by IntelliJ IDEA.
  User: 18239
  Date: 2020/6/2
  Time: 9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <title>区域管理页面</title>

    <link href="css/bootstrap.min.css" rel="stylesheet" >
    <!-- Custom styles for this template -->
    <link href="css/dashboard.css" rel="stylesheet">
    <style type="text/css">/* Chart.js */
    @-webkit-keyframes chartjs-render-animation{from{opacity:0.99}to{opacity:1}}@keyframes chartjs-render-animation{from{opacity:0.99}to{opacity:1}}.chartjs-render-monitor{-webkit-animation:chartjs-render-animation 0.001s;animation:chartjs-render-animation 0.001s;}</style>

    <!-- font awesome css-->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">

    <!-- boostrap-table css-->
    <link href="bootstrap-table/bootstrap-table.min.css">
</head>
<body>
<!--上边的导航栏-->
<nav class="navbar navbar-dark fixed-top bg-dark flex-md-nowrap p-0 shadow">
    <a class="navbar-brand col-sm-3 col-md-2 mr-0" ><td> <div style="color:white; align:center;">欢迎回来，<%=session.getAttribute("username")%></div> </td></a>

    </a>
    <input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search">
    <ul class="navbar-nav px-3">
        <li class="nav-item text-nowrap">
            <a class="nav-link" href="login.jsp">退出</a>
        </li>
    </ul>
</nav>
<!--左边的导航栏-->
<div class="container-fluid">
    <div class="row">
        <nav class="col-md-2 d-none d-md-block bg-light sidebar">
            <div class="sidebar-sticky">
                <ul class="nav flex-column">
                    <li class="nav-item">
                        <a class="nav-link" href="success.jsp">
                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-home"><path d="M3 9l9-7 9 7v11a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2z"></path><polyline points="9 22 9 12 15 12 15 22"></polyline></svg>
                            首页 <span class="sr-only">(current)</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <div id="accordion" class="panel-group">
                            <!-- 子模块的标题 -->
                            <a class="nav-link active" data-toggle="collapse" href="#collapseThree" data-parent="#accordion">
                                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-layers"><polygon points="12 2 2 7 12 12 22 7 12 2"></polygon><polyline points="2 17 12 22 22 17"></polyline><polyline points="2 12 12 17 22 12"></polyline></svg>
                                设备报修管理
                            </a>
                            <!--收缩div-->
                            <div id = "collapseThree" class="panel-collapse">
                                <div class="panel-body">
                                    <a class="dropdown-item" href="repairs.jsp">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file"><path d="M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z"></path><polyline points="13 2 13 9 20 9"></polyline></svg>
                                        设备报修
                                    </a>
                                    <a class="dropdown-item" href="assign.jsp">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file"><path d="M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z"></path><polyline points="13 2 13 9 20 9"></polyline></svg>
                                        报修分派
                                    </a>
                                    <a class="dropdown-item" href="maintain.jsp">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file"><path d="M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z"></path><polyline points="13 2 13 9 20 9"></polyline></svg>
                                        维修管理
                                    </a>
                                    <a class="dropdown-item" href="equi_manag.jsp">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file"><path d="M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z"></path><polyline points="13 2 13 9 20 9"></polyline></svg>
                                        设备管理
                                    </a>
                                    <a class="dropdown-item active" href="area_manag.jsp">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file"><path d="M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z"></path><polyline points="13 2 13 9 20 9"></polyline></svg>
                                        区域管理
                                    </a>
                                </div>
                            </div>
                            <a class="nav-link" data-toggle="collapse" href="#collapseThree2" data-parent="#accordion">
                                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-layers"><polygon points="12 2 2 7 12 12 22 7 12 2"></polygon><polyline points="2 17 12 22 22 17"></polyline><polyline points="2 12 12 17 22 12"></polyline></svg>
                                系统管理
                            </a>
                            <div id="collapseThree2" class="panel-collapse">
                                <div class="panel-body">
                                    <a class="dropdown-item" href="#">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file"><path d="M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z"></path><polyline points="13 2 13 9 20 9"></polyline></svg>
                                        个人中心
                                    </a>
                                    <a class="dropdown-item" href="#">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file"><path d="M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z"></path><polyline points="13 2 13 9 20 9"></polyline></svg>
                                        系统管理2
                                    </a>
                                    <a class="dropdown-item" href="#">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file"><path d="M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z"></path><polyline points="13 2 13 9 20 9"></polyline></svg>
                                        系统管理3
                                    </a>
                                    <a class="dropdown-item" href="#">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file"><path d="M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z"></path><polyline points="13 2 13 9 20 9"></polyline></svg>
                                        系统管理4
                                    </a>
                                </div>
                            </div>
                        </div>
                    </li>

                </ul>
            </div>
        </nav>
        <!-- 右边的主体部分 -->
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4"><div class="chartjs-size-monitor" style="position: absolute; left: 0px; top: 0px; right: 0px; bottom: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;"><div class="chartjs-size-monitor-expand" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:1000000px;height:1000000px;left:0;top:0"></div></div><div class="chartjs-size-monitor-shrink" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:200%;height:200%;left:0; top:0"></div></div></div>
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                <h1 class="h2">区域管理</h1>
            </div>
            <!--写一个table bootstrap-table-->
            <!-- toolbar  -->
            <div class="panel panel-primary">
                <div class="panel-body">
                    <div id="toolbar" >
                        <form class="form-inline" style="width:100%; margin-bottom: 20px;">
                            <div class="form-group" style="margin-left: 5px;">
                                <input type="button" value="新增区域" id="addBtn" data-toggle="modal" data-target="#addAreaModal" class="btn btn-primary" >
                            </div>
                            <div class="form-group" style="margin-left: 5px;">
                                <input type="button" value="删除区域" id="deleteBtn" class="btn btn-info" onclick="deleteArea()">
                            </div>
                            <div class="form-group" style="margin-left: 5px;">
                                <input type="button" value="修改区域" id="editBtn" class="btn btn-danger" onclick="editArea()">
                            </div>
                            <div class="form-group" style="margin-left: 5px;">
                                <label for="queryName"></label>
                                <input type="text" id="queryName" class="form-control" placeholder="楼栋">
                                <input type="button" class="btn btn-success" id="queryBtn"  value="查询" onclick="queryArea()">
                            </div>
                        </form>

                    </div>
                    <div class="container" style="width:100%;margin-top: 20px;">
                        <!--放一个table元素-->
                        <table id="table"></table>
                    </div>
                </div>
            </div>

            <!-- 新增区域模态窗体 -->
            <div class="modal fade" id="addAreaModal" role="dialog" tabindex="-1">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header ">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="resetForm()"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title">区域信息</h4>
                        </div>
                        <div class="modal-body">

                            <form id="addAreaForm" class="form-horizontal" action="/areaAdd"  method="post">
                                <input type="hidden" name ="id" id="areaId">
                                <div class="form-group">
                                    <label for="building" class="col-sm-2 control-label">楼栋名称：</label>
                                    <div class="col-sm-10">
                                        <input type="text" name="building" id="building" class="form-control">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="floor" class="col-sm-2 control-label">楼层：</label>
                                    <div class="col-sm-10">
                                        <input type="text" name="floor" id="floor" class="form-control">
                                    </div>
                                </div>

                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal" onclick="resetForm()">取消</button>
                            <button type="button" class="btn btn-primary" onclick="addArea()">确定</button>
                        </div>
                    </div>
                </div>
            </div>
        </main>

    </div>
    <script src="js/jquery.min.js" ></script>
    <script src="js/bootstrap.bundle.min.js"></script>
    <%--<script src="jss/feather.min.js"></script>--%>
    <%--<script src="jss/dashboard.js"></script>--%>
    <!-- 引入 bootstrap-table js -->
    <script type="text/javascript" src="bootstrap-table/bootstrap-table.min.js"></script>
    <script type="text/javascript" src="bootstrap-table/bootstrap-table-zh-CN.min.js"></script>
    <!--font awesome-->
    <script src="https://cdn.bootcss.com/font-awesome/5.8.1/js/all.min.js"></script>
    <script>
        $("#table").bootstrapTable({
            contentType : "application/x-www-form-urlencoded",//模拟form表单的形式
            url: '${pageContext.request.contextPath}/queryServlet',
            queryParams:queryParam,
            method:"POST",
            dataType:"json",
            pagination: true,
            sidePagination: "server",       //server表示服务端分页，client表示客户端分页
            pageNumber:1,                       //初始化加载第一页，默认第一页
            pageSize: 5,                       //每页的记录行数（*）
            pageList: [5, 10, 25],        //可供选择的每页的行数（*）
            uniqueId: "rhesis_id",               //id唯一不变
            striped:true,
            singleSelect: true,
            clickToSelect: true,
            showRefresh: true,
            showToggle: true,
            toolbar: "#toolbar",
            columns: [{
                field:"state",
                checkbox:"true"
            },{
                field: 'id',
                title: 'ID'
            }, {
                field: 'building',
                title: '楼栋'
            },{
                field: 'floor',
                title: '楼层'
            }]
        });
        function queryParam(params) {
            console.info(params);
            console.log(this);//this表示当前bootStrap-table的实例
            var param = {
                queryName:$("#queryName").val(),
                limit:params.limit,//数据集合的大小
                offset:params.offset,//页码
                pageIndex:this.pageNumber,
                pageSize:this.pageSize
            };
            console.info(param);
            return param;
        }
        //查询操作
        function queryArea() {
            $("#table").bootstrapTable('refresh');
        }
        //新增区域信息
        function addArea() {
            //获取input框中的输入值
            var areaID = $('#areaId').val()
            var building = $('#building').val()
            var floor = $('#floor').val()
            //jquery 提供的获取表单输入的方式
            var params = $('#addAreaForm').serializeArray()

            //根据id是否为空，判断当前的请求时新增还是删除
            var url = ''
            if(areaID === ''){//新增操作
                url = '${pageContext.request.contextPath}/areaAdd'
            }else {
                url = '${pageContext.request.contextPath}/areaUpdate'
            }
            $.ajax({
                    url:url,
                    // data: {"building":building,"floor":floor},
                    data: params,
                    method: "POST",
                    dataType: "json",
                    async: false,
                    success :function (result) {
                        if(result.status==="success"){
                            alert(result.message)

                        }else {
                            alert(result.message)
                        }
                        //隐藏模态框
                        $('#addAreaModal').modal('hide');
                        //对模态框的from表单中的值清空
                        resetForm()
                    },
                    timeout: 1000,
                    error: function (error) {
                        alert("服务器请求失败! [" + error + "]")
                    }
                });
            $("#table").bootstrapTable('refresh')
        }
        //取消
        function resetForm() {
            $('#addAreaForm').find('input[type=text],input[type=hidden]').each(function () {
                //清除value值
                $(this).val('');
            })
        }
        //修改
        function editArea() {
            var rows = $('#table').bootstrapTable('getSelections')

            if(rows.length === 0){
                alert("没有选择任何行！")
                return;
            }
            var currentRow = rows[0]
            //给模态框中的input赋值
            $('#areaId').val(currentRow.id)
            $('#building').val(currentRow.building)
            $('#floor').val(currentRow.floor)
            //显示模态框
            $('#addAreaModal').modal('show');
        }
        //删除
        function deleteArea() {
            var rows = $('#table').bootstrapTable('getSelections')

            if(rows.length === 0){
                alert("没有选择任何行！")
                return;
            }
            var currentRow = rows[0]
            var areaID = currentRow.id;

            var answer = window.confirm("确定要删除该行记录吗？");
            if(answer){
                $.ajax({
                    url:'${pageContext.request.contextPath}/areaDelete',
                    method: "POST",
                    data: {"id":areaID},
                    dataType: "json",
                    async: false,
                    success: function (result) {
                        if(result.status==="success"){
                            alert(result.message)
                            $("#table").bootstrapTable('refresh')
                        }else {
                            alert(result.message)
                        }
                    },
                    timeout: 1000,
                    error: function (error) {
                        alert("服务器请求失败! [" + error + "]")
                    }
                });
            }
        }
    </script>
</body></html>
